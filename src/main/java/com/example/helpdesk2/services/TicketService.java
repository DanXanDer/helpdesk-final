package com.example.helpdesk2.services;

import com.example.helpdesk2.DTO.CambiarEstadoTicketDTO;
import com.example.helpdesk2.repositories.*;
import org.springframework.stereotype.Service;

@Service
public class TicketService {
    private final TicketRepository ticketRepository;
    private final ReporteIncidenteRepository reporteIncidenteRepository;
    private final ActividadTicketRepository actividadTicketRepository;
    private final ActividadTicketImagenRepository actividadTicketImagenRepository;
    private final ImagenRepository imagenRepository;


    public TicketService(TicketRepository ticketRepository, ReporteIncidenteRepository reporteIncidenteRepository, ActividadTicketRepository actividadTicketRepository, ActividadTicketImagenRepository actividadTicketImagenRepository, ImagenRepository imagenRepository) {
        this.ticketRepository = ticketRepository;
        this.reporteIncidenteRepository = reporteIncidenteRepository;
        this.actividadTicketRepository = actividadTicketRepository;
        this.actividadTicketImagenRepository = actividadTicketImagenRepository;
        this.imagenRepository = imagenRepository;
    }

    public int cambiarEstadoTicket(CambiarEstadoTicketDTO cambiarEstadoTicketDTO) {
        ticketRepository.actualizarEstadoTicket(cambiarEstadoTicketDTO.getEstadoTicket(), cambiarEstadoTicketDTO.getIdTicket());
        reporteIncidenteRepository.actualizarEstadoReporteIncidente(cambiarEstadoTicketDTO.getIdReporteIncidente(), cambiarEstadoTicketDTO.getEstadoReporteIncidente());
        actividadTicketRepository.guardarActividadTicket(cambiarEstadoTicketDTO.getIdTicket(), cambiarEstadoTicketDTO.getEmisor(),cambiarEstadoTicketDTO.getMensaje(), cambiarEstadoTicketDTO.getEstadoTicket());
        return actividadTicketRepository.obtenerUltimoIdInsertado();
    }

    public void registrarActividadTicketImagen(int idActividadTicket, String nombreImagen){
        imagenRepository.guardarImagen(nombreImagen);
        int idImagen = imagenRepository.obtenerUltimoIDImagen();
        actividadTicketImagenRepository.guardarActividadTicketImagen(idActividadTicket, idImagen);
    }
}

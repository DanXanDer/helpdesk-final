package com.example.helpdesk2.moduloTrabajador.services;

import com.example.helpdesk2.DTO.EscogerTicketDTO;
import com.example.helpdesk2.models.Imagen;
import com.example.helpdesk2.models.ReporteIncidente;
import com.example.helpdesk2.moduloTrabajador.exceptions.ReporteNoEncontradoException;
import com.example.helpdesk2.repositories.ImagenRepository;
import com.example.helpdesk2.repositories.ReporteIncidenteRepository;
import com.example.helpdesk2.repositories.TicketRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CrearTicketService {
    private final ReporteIncidenteRepository reporteIncidenteRepository;
    private final ImagenRepository imagenRepository;
    private final TicketRepository ticketRepository;

    public CrearTicketService(ReporteIncidenteRepository reporteIncidenteRepository, ImagenRepository imagenRepository, TicketRepository ticketRepository) {
        this.reporteIncidenteRepository = reporteIncidenteRepository;
        this.imagenRepository = imagenRepository;
        this.ticketRepository = ticketRepository;
    }

    public List<ReporteIncidente> obtenerReportesIncidentes() {
        return reporteIncidenteRepository.buscarReportesIncidentes().orElseThrow(ReporteNoEncontradoException::new);
    }

    public Map<String, Object> obtenerReporteIncidente(int idReporteIncidente) {
        List<Imagen> rutasImagenes = imagenRepository.buscarImagenesReporte(idReporteIncidente);
        ReporteIncidente reporteIncidente = reporteIncidenteRepository.buscarReporteIncidente(idReporteIncidente);
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("reporteIncidente", reporteIncidente);
        respuesta.put("rutasImagenes", rutasImagenes);
        return respuesta;
    }

    @Transactional
    public void escogerReporteIncidente(EscogerTicketDTO escogerTicketDTO, int idTrabajador) {
        reporteIncidenteRepository.actualizarEstadoReporteIncidente(escogerTicketDTO.getIdReporteIncidente(), escogerTicketDTO.getEstado());
        ticketRepository.guardarTicket(idTrabajador, escogerTicketDTO.getIdReporteIncidente());
    }


}

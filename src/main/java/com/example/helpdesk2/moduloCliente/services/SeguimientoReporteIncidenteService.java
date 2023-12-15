package com.example.helpdesk2.moduloCliente.services;

import com.example.helpdesk2.DTO.ActividadTicketDTO;
import com.example.helpdesk2.DTO.ConformidadTicketDTO;
import com.example.helpdesk2.DTO.RegistrarMensajeTicketDTO;
import com.example.helpdesk2.DTO.ReporteIncidenteDetalleDTO;
import com.example.helpdesk2.models.*;
import com.example.helpdesk2.repositories.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class SeguimientoReporteIncidenteService {
    private final ReporteIncidenteRepository reporteIncidenteRepository;
    private final TicketRepository ticketRepository;
    private final ClienteRepository clienteRepository;
    private final UsuarioRepository usuarioRepository;
    private final MensajeRepository mensajeRepository;
    private final MensajeTicketRepository mensajeTicketRepository;
    private final TrabajadorRepository trabajadorRepository;
    private final ActividadTicketRepository actividadTicketRepository;

    public SeguimientoReporteIncidenteService(ReporteIncidenteRepository reporteIncidenteRepository, TicketRepository ticketRepository, ClienteRepository clienteRepository, UsuarioRepository usuarioRepository, MensajeRepository mensajeRepository, MensajeTicketRepository mensajeTicketRepository, TrabajadorRepository trabajadorRepository, ActividadTicketRepository actividadTicketRepository) {
        this.reporteIncidenteRepository = reporteIncidenteRepository;
        this.ticketRepository = ticketRepository;
        this.clienteRepository = clienteRepository;
        this.usuarioRepository = usuarioRepository;
        this.mensajeRepository = mensajeRepository;
        this.mensajeTicketRepository = mensajeTicketRepository;
        this.trabajadorRepository = trabajadorRepository;
        this.actividadTicketRepository = actividadTicketRepository;
    }

    public List<ReporteIncidenteDetalleDTO> obtenerReportesIncidentesCliente(int idUsuario) {
        int idCliente = clienteRepository.buscarClientePorIdUsuario(idUsuario).getIdCliente();
        List<ReporteIncidente> reportesIncidentes = reporteIncidenteRepository.buscarReportesIncidentesCliente(idCliente);

        List<ReporteIncidenteDetalleDTO> reportesIncidentesDetalles = new ArrayList<>();

        for (ReporteIncidente reporteIncidente : reportesIncidentes) {
            Optional<Ticket> ticketOptional = ticketRepository.buscarTicketPorIDReporteIncidente(reporteIncidente.getIdReporteIncidente());
            ReporteIncidenteDetalleDTO reporteIncidenteDetalleDTO = new ReporteIncidenteDetalleDTO();
            reporteIncidenteDetalleDTO.setReporteIncidente(reporteIncidente);
            if (ticketOptional.isPresent()) {
                reporteIncidenteDetalleDTO.setTrabajador(usuarioRepository.buscarUsuarioPorId(idUsuario).getNombres());
                reporteIncidenteDetalleDTO.setFechaCreacion(ticketOptional.get().getFecha());
            } else {
                reporteIncidenteDetalleDTO.setTrabajador("Por asignar");
                reporteIncidenteDetalleDTO.setFechaCreacion(null);
            }

            reportesIncidentesDetalles.add(reporteIncidenteDetalleDTO);
        }

        return reportesIncidentesDetalles;
    }

    public Map<String, Object> obtenerReporteIncidentePorID(int idReporteIncidente) {
        ReporteIncidente reporteIncidente = reporteIncidenteRepository.buscarReporteIncidente(idReporteIncidente);
        Ticket ticket = ticketRepository.buscarTicketPorIDReporteIncidente(idReporteIncidente).get();
        int idUsuario = trabajadorRepository.buscarTrabajadorPorIdTrabajador(ticket.getIdTrabajador()).getIdUsuario();
        String nombres = usuarioRepository.buscarUsuarioPorId(idUsuario).getNombres();
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("reporteIncidente", reporteIncidente);
        respuesta.put("ticket", ticket);
        respuesta.put("nombreTrabajador", nombres);
        return respuesta;
    }

    public List<Mensaje> obtenerMensajesTicket(int idTicket) {
        return mensajeRepository.buscarMensajesTicket(idTicket);
    }
    @Transactional
    public void registrarMensajeTicket(RegistrarMensajeTicketDTO registrarMensajeTicketDTO) {
        mensajeRepository.guardarMensaje(registrarMensajeTicketDTO);
        int idMensaje = mensajeRepository.obtenerUltimoIdInsertado();
        mensajeTicketRepository.guardarMensajeTicket(registrarMensajeTicketDTO.getIdTicket(), idMensaje);
    }

    @Transactional
    public void confirmarAtencion(ConformidadTicketDTO conformidadTicketDTO){
        ticketRepository.actualizarEstadoTicket(conformidadTicketDTO.getEstadoTicket(), conformidadTicketDTO.getIdTicket());
        reporteIncidenteRepository.actualizarEstadoReporteIncidente(conformidadTicketDTO.getIdReporteIncidente(), conformidadTicketDTO.getEstadoReporteIncidente());
        actividadTicketRepository.guardarActividadTicket(conformidadTicketDTO.getIdTicket(), conformidadTicketDTO.getMensaje(), conformidadTicketDTO.getEstadoTicket());
    }

}

package com.example.helpdesk2.moduloTrabajador.services;

import com.example.helpdesk2.DTO.DatosClienteDTO;
import com.example.helpdesk2.DTO.CambiarEstadoTicketDTO;
import com.example.helpdesk2.DTO.RegistrarMensajeTicketDTO;
import com.example.helpdesk2.DTO.TicketAsignadoDTO;
import com.example.helpdesk2.models.Imagen;
import com.example.helpdesk2.models.Mensaje;
import com.example.helpdesk2.moduloTrabajador.exceptions.TicketsTrabajadorNoEncontradosException;
import com.example.helpdesk2.repositories.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AtenderTicketService {

    private final TicketRepository ticketRepository;
    private final TrabajadorRepository trabajadorRepository;
    private final ClienteRepository clienteRepository;
    private final ImagenRepository imagenRepository;
    private final MensajeRepository mensajeRepository;
    private final MensajeTicketRepository mensajeTicketRepository;
    private final ActividadTicketRepository actividadTicketRepository;
    private final ReporteIncidenteRepository reporteIncidenteRepository;
    private final MensajeImagenRepository mensajeImagenRepository;
    private final ActividadTicketImagenRepository actividadTicketImagenRepository;

    public AtenderTicketService(TicketRepository ticketRepository, TrabajadorRepository trabajadorRepository, ClienteRepository clienteRepository, ImagenRepository imagenRepository, MensajeRepository mensajeRepository, MensajeTicketRepository mensajeTicketRepository, ActividadTicketRepository actividadTicketRepository, ReporteIncidenteRepository reporteIncidenteRepository, MensajeImagenRepository mensajeImagenRepository, ActividadTicketImagenRepository actividadTicketImagenRepository) {
        this.ticketRepository = ticketRepository;
        this.trabajadorRepository = trabajadorRepository;
        this.clienteRepository = clienteRepository;
        this.imagenRepository = imagenRepository;
        this.mensajeRepository = mensajeRepository;
        this.mensajeTicketRepository = mensajeTicketRepository;
        this.actividadTicketRepository = actividadTicketRepository;
        this.reporteIncidenteRepository = reporteIncidenteRepository;
        this.mensajeImagenRepository = mensajeImagenRepository;
        this.actividadTicketImagenRepository = actividadTicketImagenRepository;
    }

    public List<TicketAsignadoDTO> obtenerTicketsTrabajador(int idTrabajador) {
        return ticketRepository.buscarTicketsTrabajador(idTrabajador).orElseThrow(TicketsTrabajadorNoEncontradosException::new);
    }

    public int obtenerIdTrabajador(int idUsuario) {
        return trabajadorRepository.buscarTrabajadorPorIdUsuario(idUsuario).getIdTrabajador();
    }

    @Transactional
    public Map<String, Object> obtenerDetallesTicketPorID(int idTicket) {
        TicketAsignadoDTO ticket = ticketRepository.buscarTicketPorID(idTicket);
        DatosClienteDTO datosCliente = clienteRepository.buscarDatosCliente(ticket.getIdCliente());
        List<Imagen> rutasImagenes = imagenRepository.buscarImagenesReporte(ticket.getIdReporteIncidente());
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("ticket", ticket);
        respuesta.put("datosCliente", datosCliente);
        respuesta.put("rutasImagenes", rutasImagenes);
        return respuesta;
    }

    public List<Imagen> obtenerImagenesMensaje(int idMensaje) {
        return imagenRepository.buscarImagenesMensaje(idMensaje);
    }

    @Transactional
    public int registrarMensajeTicket(RegistrarMensajeTicketDTO registrarMensajeTicketDTO) {
        mensajeRepository.guardarMensaje(registrarMensajeTicketDTO);
        int idMensaje = mensajeRepository.obtenerUltimoIdInsertado();
        mensajeTicketRepository.guardarMensajeTicket(registrarMensajeTicketDTO.getIdTicket(), idMensaje);
        return idMensaje;
    }

    public void registrarMensajeImagen(int idMensaje, String nombreImagen) {
        imagenRepository.guardarImagen(nombreImagen);
        int idImagen = imagenRepository.obtenerUltimoIDImagen();
        mensajeImagenRepository.guardarMensajeImagen(idMensaje, idImagen);
    }

    public List<Mensaje> obtenerMensajesTicket(int idTicket) {
        return mensajeRepository.buscarMensajesTicket(idTicket);
    }
}

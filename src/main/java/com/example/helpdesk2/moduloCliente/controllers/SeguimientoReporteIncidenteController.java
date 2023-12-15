package com.example.helpdesk2.moduloCliente.controllers;

import com.example.helpdesk2.DTO.ActividadTicketDTO;
import com.example.helpdesk2.DTO.ConformidadTicketDTO;
import com.example.helpdesk2.DTO.RegistrarMensajeTicketDTO;
import com.example.helpdesk2.DTO.ReporteIncidenteDetalleDTO;
import com.example.helpdesk2.models.Mensaje;
import com.example.helpdesk2.models.ReporteIncidente;
import com.example.helpdesk2.moduloCliente.services.SeguimientoReporteIncidenteService;
import com.example.helpdesk2.services.LoggedUserManagamentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/modulo-cliente")
public class SeguimientoReporteIncidenteController {

    private final SeguimientoReporteIncidenteService seguimientoReporteIncidenteService;

    private final LoggedUserManagamentService loggedUserManagamentService;

    public SeguimientoReporteIncidenteController(SeguimientoReporteIncidenteService seguimientoReporteIncidenteService, LoggedUserManagamentService loggedUserManagamentService) {
        this.seguimientoReporteIncidenteService = seguimientoReporteIncidenteService;
        this.loggedUserManagamentService = loggedUserManagamentService;
    }

    @GetMapping("/reportes")
    public ResponseEntity<List<ReporteIncidenteDetalleDTO>> obtenerReportesIncidentesCliente() {
        int idUsuario = loggedUserManagamentService.getIdUsuario();
        List<ReporteIncidenteDetalleDTO> reportesIncidentesDetalles = seguimientoReporteIncidenteService.obtenerReportesIncidentesCliente(idUsuario);
        return ResponseEntity
                .ok()
                .body(reportesIncidentesDetalles);
    }

    @GetMapping("/reportes/{idReporteIncidente}")
    public ResponseEntity<Map<String, Object>> obtenerReporteIncidentePorID(@PathVariable int idReporteIncidente) {
        Map<String,Object> respuesta = seguimientoReporteIncidenteService.obtenerReporteIncidentePorID(idReporteIncidente);
        return ResponseEntity
                .ok()
                .body(respuesta);
    }

    @GetMapping("/reportes/{idReporteIncidente}/mensajes")
    public ResponseEntity<List<Mensaje>> obtenerMensajesTicket(@PathVariable int idReporteIncidente) {
        List<Mensaje> mensajesTicket = seguimientoReporteIncidenteService.obtenerMensajesTicket(idReporteIncidente);
        return ResponseEntity
                .ok()
                .body(mensajesTicket);
    }

    @PostMapping("/reportes/mensaje")
    public ResponseEntity<Void> registrarMensajeTicket(@RequestBody RegistrarMensajeTicketDTO registrarMensajeTicketDTO) {
        seguimientoReporteIncidenteService.registrarMensajeTicket(registrarMensajeTicketDTO);
        return ResponseEntity
                .ok()
                .build();
    }

    @PostMapping("/reportes/cambiar-estado-ticket")
    public ResponseEntity<Void> cambiarEstadoTicket(@RequestBody ConformidadTicketDTO conformidadTicketDTO) {
        seguimientoReporteIncidenteService.confirmarAtencion(conformidadTicketDTO);
        return ResponseEntity
                .ok()
                .build();
    }
}

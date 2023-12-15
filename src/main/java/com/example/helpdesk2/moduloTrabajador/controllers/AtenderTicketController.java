package com.example.helpdesk2.moduloTrabajador.controllers;

import com.example.helpdesk2.DTO.ActividadTicketDTO;
import com.example.helpdesk2.DTO.RegistrarMensajeTicketDTO;
import com.example.helpdesk2.DTO.TicketAsignadoDTO;
import com.example.helpdesk2.models.Mensaje;
import com.example.helpdesk2.moduloTrabajador.services.AtenderTicketService;
import com.example.helpdesk2.services.LoggedUserManagamentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/modulo-trabajador")
public class AtenderTicketController {

    private final AtenderTicketService atenderTicketService;
    private final LoggedUserManagamentService loggedUserManagamentService;

    public AtenderTicketController(AtenderTicketService atenderTicketService, LoggedUserManagamentService loggedUserManagamentService) {
        this.atenderTicketService = atenderTicketService;
        this.loggedUserManagamentService = loggedUserManagamentService;
    }

    @GetMapping("/tickets")
    public ResponseEntity<List<TicketAsignadoDTO>> obtenerTickets() {
        int idUsuario = loggedUserManagamentService.getIdUsuario();
        int idTrabajador = atenderTicketService.obtenerIdTrabajador(idUsuario);
        List<TicketAsignadoDTO> ticketsTrabajador = atenderTicketService.obtenerTicketsTrabajador(idTrabajador);
        return ResponseEntity
                .ok()
                .body(ticketsTrabajador);
    }

    @GetMapping("/tickets/{idTicket}")
    public ResponseEntity<Map<String, Object>> obtenerTicketPorID(@PathVariable int idTicket) {
        Map<String, Object> respuesta = atenderTicketService.obtenerDetallesTicketPorID(idTicket);
        return ResponseEntity
                .ok()
                .body(respuesta);
    }

    @PostMapping("/tickets/mensaje")
    public ResponseEntity<Void> registrarMensajeTicket(@RequestBody RegistrarMensajeTicketDTO registrarMensajeTicketDTO) {
        atenderTicketService.registrarMensajeTicket(registrarMensajeTicketDTO);
        return ResponseEntity
                .ok()
                .build();
    }

    @PostMapping("/tickets/cambiar-estado-ticket")
    public ResponseEntity<Void> cambiarEstadoTicket(@RequestBody ActividadTicketDTO actividadTicketDTO) {
        atenderTicketService.atenderTicket(actividadTicketDTO);
        return ResponseEntity
                .ok()
                .build();
    }

    @GetMapping("/tickets/{idTicket}/mensajes")
    public ResponseEntity<List<Mensaje>> obtenerMensajesTicket(@PathVariable int idTicket) {
        List<Mensaje> mensajesTicket = atenderTicketService.obtenerMensajesTicket(idTicket);
        return ResponseEntity
                .ok()
                .body(mensajesTicket);
    }

}

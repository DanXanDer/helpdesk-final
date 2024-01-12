package com.example.helpdesk2.moduloAdministrador.controllers;

import com.example.helpdesk2.DTO.TicketAsignadoDTO;
import com.example.helpdesk2.moduloAdministrador.services.VerTicketsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/modulo-administrador")
public class VerTicketsController {

    private final VerTicketsService verTicketsService;

    public VerTicketsController(VerTicketsService verTicketsService) {
        this.verTicketsService = verTicketsService;
    }

    @GetMapping("/tickets")
    public ResponseEntity<Map<String, Object>> obtenerTickets() {
        List<TicketAsignadoDTO> tickets = verTicketsService.obtenerTickets();
        Map<String, Object> respuesta = Map.of("tickets", tickets);
        return ResponseEntity.ok(respuesta);
    }
}

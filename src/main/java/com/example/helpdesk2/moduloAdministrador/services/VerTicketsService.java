package com.example.helpdesk2.moduloAdministrador.services;

import com.example.helpdesk2.DTO.TicketAsignadoDTO;
import com.example.helpdesk2.repositories.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VerTicketsService {
    private final TicketRepository ticketRepository;

    public VerTicketsService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public List<TicketAsignadoDTO> obtenerTickets() {
        return ticketRepository.buscarTickets();
    }



}

package com.example.helpdesk2.services;

import com.example.helpdesk2.DTO.RegistrarMensajeTicketDTO;
import com.example.helpdesk2.models.Mensaje;
import com.example.helpdesk2.repositories.ImagenRepository;
import com.example.helpdesk2.repositories.MensajeImagenRepository;
import com.example.helpdesk2.repositories.MensajeRepository;
import com.example.helpdesk2.repositories.MensajeTicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MensajesService {
    private final MensajeRepository mensajeRepository;
    private final MensajeTicketRepository mensajeTicketRepository;
    private final MensajeImagenRepository mensajeImagenRepository;
    private final ImagenRepository imagenRepository;

    public MensajesService(MensajeRepository mensajeRepository, MensajeTicketRepository mensajeTicketRepository, MensajeImagenRepository mensajeImagenRepository, ImagenRepository imagenRepository) {
        this.mensajeRepository = mensajeRepository;
        this.mensajeTicketRepository = mensajeTicketRepository;
        this.mensajeImagenRepository = mensajeImagenRepository;
        this.imagenRepository = imagenRepository;
    }

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

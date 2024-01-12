package com.example.helpdesk2.moduloTrabajador.controllers;

import com.example.helpdesk2.DTO.CambiarEstadoTicketDTO;
import com.example.helpdesk2.DTO.ObtenerImagenesMensajeDTO;
import com.example.helpdesk2.DTO.RegistrarMensajeTicketDTO;
import com.example.helpdesk2.DTO.TicketAsignadoDTO;
import com.example.helpdesk2.models.Imagen;
import com.example.helpdesk2.models.Mensaje;
import com.example.helpdesk2.moduloTrabajador.services.AtenderTicketService;
import com.example.helpdesk2.services.FileStorageService;
import com.example.helpdesk2.services.LoggedUserManagamentService;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/modulo-trabajador")
public class AtenderTicketController {

    private final AtenderTicketService atenderTicketService;
    private final LoggedUserManagamentService loggedUserManagamentService;
    private final FileStorageService fileStorageService;

    public AtenderTicketController(AtenderTicketService atenderTicketService, LoggedUserManagamentService loggedUserManagamentService, FileStorageService fileStorageService) {
        this.atenderTicketService = atenderTicketService;
        this.loggedUserManagamentService = loggedUserManagamentService;
        this.fileStorageService = fileStorageService;
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

    @Transactional
    @PostMapping("/tickets/mensaje")
    public ResponseEntity<Map<String, Object>> registrarMensajeTicket(
            @RequestParam int idTicket,
            @RequestParam String emisor,
            @RequestParam String receptor,
            @RequestParam String mensaje,
            @RequestPart(required = false) MultipartFile[] imagenes) throws IOException{
        RegistrarMensajeTicketDTO registrarMensajeTicketDTO = new RegistrarMensajeTicketDTO(idTicket, emisor, receptor, mensaje);
        int idMensaje = atenderTicketService.registrarMensajeTicket(registrarMensajeTicketDTO);
        if(imagenes != null){
            Path ticketFolder = fileStorageService.crearDirectorio(idTicket, "ticket", null);
            Path mensajeFolder = fileStorageService.crearDirectorio(idMensaje, "mensaje", ticketFolder);
            for(MultipartFile imagen : imagenes){
                String nombreImagen = fileStorageService.guardar(imagen, mensajeFolder);
                atenderTicketService.registrarMensajeImagen(idMensaje, nombreImagen);
            }
        }
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("ok", true);
        return ResponseEntity
                .ok()
                .body(respuesta);
    }

    @PostMapping("/mensaje-imagenes")
    public ResponseEntity<?> obtenerImagenesMensaje(@RequestBody ObtenerImagenesMensajeDTO obtenerImagenesMensajeDTO) throws IOException {
        int idTicket = obtenerImagenesMensajeDTO.getIdTicket();
        int idMensaje = obtenerImagenesMensajeDTO.getIdMensaje();
        Resource resource = fileStorageService.cargar(obtenerImagenesMensajeDTO.getRutaImagen(), "ticket-" + idTicket + "/mensaje-" + idMensaje);
        String contentType = "application/octet-stream";
        String headerValue = "attachment; filename=\"" + resource.getFilename() + "\"";
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, headerValue)
                .body(resource);
    }

    @GetMapping("/mensajes/{idMensaje}/imagenes")
    public ResponseEntity<List<Imagen>> obtenerRutasImagenesMensaje(@PathVariable int idMensaje) {
        List<Imagen> rutasImagenes = atenderTicketService.obtenerImagenesMensaje(idMensaje);
        return ResponseEntity
                .ok()
                .body(rutasImagenes);
    }

    @GetMapping("/tickets/{idTicket}/mensajes")
    public ResponseEntity<List<Mensaje>> obtenerMensajesTicket(@PathVariable int idTicket) {
        List<Mensaje> mensajesTicket = atenderTicketService.obtenerMensajesTicket(idTicket);
        return ResponseEntity
                .ok()
                .body(mensajesTicket);
    }



}

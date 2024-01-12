package com.example.helpdesk2.controllers;

import com.example.helpdesk2.DTO.CambiarEstadoTicketDTO;
import com.example.helpdesk2.DTO.RegistrarMensajeTicketDTO;
import com.example.helpdesk2.models.Imagen;
import com.example.helpdesk2.models.Mensaje;
import com.example.helpdesk2.repositories.TicketRepository;
import com.example.helpdesk2.services.FileStorageService;
import com.example.helpdesk2.services.ImagenesService;
import com.example.helpdesk2.services.MensajesService;
import com.example.helpdesk2.services.TicketService;
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
@RequestMapping("/api/modulo-sistema")
public class ModuloSistemaController {

    private final FileStorageService fileStorageService;
    private final ImagenesService imagenesService;
    private final MensajesService mensajesService;
    private final TicketService ticketService;

    public ModuloSistemaController(FileStorageService fileStorageService, ImagenesService imagenesService, MensajesService mensajesService, TicketService ticketService) {
        this.fileStorageService = fileStorageService;
        this.imagenesService = imagenesService;
        this.mensajesService = mensajesService;
        this.ticketService = ticketService;
    }

    @GetMapping("/reportes/{idReporteIncidente}/imagenes")
    public ResponseEntity<?> obtenerReporteIncidenteImagen(@PathVariable int idReporteIncidente, @RequestParam(name = "rutaImagen") String rutaImagen ) throws IOException {
        Resource resource = fileStorageService.cargar(rutaImagen, "reporte-" + idReporteIncidente);
        String contentType = "application/octet-stream";
        String headerValue = "attachment; filename=\"" + resource.getFilename() + "\"";
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, headerValue)
                .body(resource);
    }
    @GetMapping("/mensajes/{idMensaje}/rutas-imagenes")
    public ResponseEntity<List<Imagen>> obtenerRutasImagenesMensaje(@PathVariable int idMensaje) {
        List<Imagen> rutasImagenes = imagenesService.obtenerImagenesMensaje(idMensaje);
        return ResponseEntity
                .ok()
                .body(rutasImagenes);
    }
    @GetMapping("/tickets/{idTicket}/mensajes/{idMensaje}/imagenes")
    public ResponseEntity<?> obtenerImagenMensaje(@PathVariable int idTicket, @PathVariable int idMensaje, @RequestParam String rutaImagen) throws IOException {
        Resource resource = fileStorageService.cargar(rutaImagen, "ticket-" + idTicket + "/mensaje-" + idMensaje);
        String contentType = "application/octet-stream";
        String headerValue = "attachment; filename=\"" + resource.getFilename() + "\"";
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, headerValue)
                .body(resource);
    }

    @Transactional
    @PostMapping("/tickets/{idTicket}/mensajes/registrar-mensaje")
    public ResponseEntity<Map<String, Object>> registrarMensajeTicket(
            @PathVariable int idTicket,
            @RequestParam String emisor,
            @RequestParam String receptor,
            @RequestParam String mensaje,
            @RequestPart(required = false) MultipartFile[] imagenes) throws IOException{
        RegistrarMensajeTicketDTO registrarMensajeTicketDTO = new RegistrarMensajeTicketDTO(idTicket, emisor, receptor, mensaje);
        int idMensaje = mensajesService.registrarMensajeTicket(registrarMensajeTicketDTO);
        if(imagenes != null){
            Path ticketFolder = fileStorageService.crearDirectorio(idTicket, "ticket", null);
            Path mensajeFolder = fileStorageService.crearDirectorio(idMensaje, "mensaje", ticketFolder);
            for(MultipartFile imagen : imagenes){
                String nombreImagen = fileStorageService.guardar(imagen, mensajeFolder);
                mensajesService.registrarMensajeImagen(idMensaje, nombreImagen);
            }
        }
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("ok", true);
        return ResponseEntity
                .ok()
                .body(respuesta);
    }

    @GetMapping("/tickets/{idTicket}/mensajes")
    public ResponseEntity<List<Mensaje>> obtenerMensajesTicket(@PathVariable int idTicket) {
        List<Mensaje> mensajesTicket = mensajesService.obtenerMensajesTicket(idTicket);
        return ResponseEntity
                .ok()
                .body(mensajesTicket);
    }

    @Transactional
    @PostMapping("/tickets/{idTicket}/cambiar-estado-ticket")
    public ResponseEntity<Map<String, Object>> cambiarEstadoTicket(
            @PathVariable int idTicket,
            @RequestParam int idReporteIncidente,
            @RequestParam String emisor,
            @RequestParam String mensaje,
            @RequestParam String estadoTicket,
            @RequestParam String estadoReporteIncidente,
            @RequestPart(required = false) MultipartFile[] imagenes) throws IOException
    {
        CambiarEstadoTicketDTO cambiarEstadoTicketDTO = new CambiarEstadoTicketDTO(idTicket, idReporteIncidente, emisor, mensaje, estadoTicket, estadoReporteIncidente);
        int idActividadTicket = ticketService.cambiarEstadoTicket(cambiarEstadoTicketDTO);
        if(imagenes != null){
            Path ticketFolder = fileStorageService.crearDirectorio(idTicket, "ticket", null);
            Path actividadTicketFolder = fileStorageService.crearDirectorio(idActividadTicket, "actividad-ticket", ticketFolder);
            for(MultipartFile imagen : imagenes){
                String nombreImagen = fileStorageService.guardar(imagen, actividadTicketFolder);
                ticketService.registrarActividadTicketImagen(idActividadTicket, nombreImagen);
            }
        }
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("ok", true);
        return ResponseEntity
                .ok()
                .body(respuesta);
    }
}

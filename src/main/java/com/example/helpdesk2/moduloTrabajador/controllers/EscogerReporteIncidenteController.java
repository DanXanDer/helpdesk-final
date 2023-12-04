package com.example.helpdesk2.moduloTrabajador.controllers;

import com.example.helpdesk2.DTO.EscogerTicketDTO;
import com.example.helpdesk2.DTO.ObtenerReporteIncidenteImagenDTO;
import com.example.helpdesk2.models.ReporteIncidente;
import com.example.helpdesk2.moduloTrabajador.services.EscogerReporteIncidenteService;
import com.example.helpdesk2.repositories.TrabajadorRepository;
import com.example.helpdesk2.services.FileStorageService;
import com.example.helpdesk2.services.LoggedUserManagamentService;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/modulo-trabajador")
public class EscogerReporteIncidenteController {

    private final LoggedUserManagamentService loggedUserManagamentService;
    private final EscogerReporteIncidenteService escogerReporteIncidenteService;
    private final FileStorageService fileStorageService;
    private final TrabajadorRepository trabajadorRepository;

    public EscogerReporteIncidenteController(LoggedUserManagamentService loggedUserManagamentService, EscogerReporteIncidenteService escogerReporteIncidenteService, FileStorageService fileStorageService, TrabajadorRepository trabajadorRepository) {
        this.loggedUserManagamentService = loggedUserManagamentService;
        this.escogerReporteIncidenteService = escogerReporteIncidenteService;
        this.fileStorageService = fileStorageService;
        this.trabajadorRepository = trabajadorRepository;
    }

    @GetMapping("/reportes-incidentes")
    public ResponseEntity<Map<String, Object>> obtenerReportesIncidentes() {
        List<ReporteIncidente> reportesIncidentes = escogerReporteIncidenteService.obtenerReportesIncidentes();
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("ok", true);
        respuesta.put("reportesIncidentes", reportesIncidentes);
        return ResponseEntity.status(HttpStatus.OK).body(respuesta);
    }

    @GetMapping("/reportes-incidentes/{idReporteIncidente}")
    public ResponseEntity<Map<String, Object>> obtenerReporteIncidente(@PathVariable int idReporteIncidente) {
        Map<String, Object> respuesta = escogerReporteIncidenteService.obtenerReporteIncidente(idReporteIncidente);
        return ResponseEntity.status(HttpStatus.OK).body(respuesta);
    }

    @PostMapping("/reporte-incidente-imagen")
    public ResponseEntity<?> obtenerReporteIncidenteImagen(@RequestBody ObtenerReporteIncidenteImagenDTO obtenerReporteIncidenteImagenDTO) throws IOException {
        Resource resource = fileStorageService.cargar(obtenerReporteIncidenteImagenDTO.getRutaImagen(), obtenerReporteIncidenteImagenDTO.getIdReporteIncidente());
        String contentType = "application/octet-stream";
        String headerValue = "attachment; filename=\"" + resource.getFilename() + "\"";
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, headerValue)
                .body(resource);
    }

    @PostMapping("/escoger-reporte-incidente")
    public ResponseEntity<Map<String, Object>> escogerReporteIncidente(@RequestBody EscogerTicketDTO escogerTicketDTO) {
        int idUsuario = loggedUserManagamentService.getIdUsuario();
        int idTrabajador = trabajadorRepository.buscarTrabajadorPorIdUsuario(idUsuario).getIdTrabajador();
        escogerReporteIncidenteService.escogerReporteIncidente(escogerTicketDTO, idTrabajador);
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("ok", true);
        return ResponseEntity.status(HttpStatus.OK).body(respuesta);
    }

}

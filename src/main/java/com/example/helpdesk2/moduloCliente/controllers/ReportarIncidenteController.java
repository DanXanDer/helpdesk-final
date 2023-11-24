package com.example.helpdesk2.moduloCliente.controllers;

import com.example.helpdesk2.moduloCliente.services.ReportarIncidenteService;
import com.example.helpdesk2.services.FileStorageServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/modulo-cliente")
public class ReportarIncidenteController {

    private final ReportarIncidenteService reportarIncidenteService;
    private final FileStorageServiceImpl fileStorageService;

    public ReportarIncidenteController(ReportarIncidenteService reportarIncidenteService, FileStorageServiceImpl fileStorageService) {
        this.reportarIncidenteService = reportarIncidenteService;
        this.fileStorageService = fileStorageService;
    }

    @Transactional
    @PostMapping("/reportar-incidente")
    public ResponseEntity<Map<String, Object>> reportarIncidente(
            @RequestParam int idCliente,
            @RequestParam String descripcion,
            @RequestPart(required = false) MultipartFile[] imagenes) throws IOException {
        int idIncidente = reportarIncidenteService.registrarIncidente(idCliente, descripcion);
        if (imagenes != null) {
            Path reporteFolder = fileStorageService.crearDirectorio(idIncidente);
            for (MultipartFile imagen : imagenes) {
                String nombreImagen = fileStorageService.guardar(imagen, reporteFolder);
                reportarIncidenteService.registrarImagen(idIncidente, nombreImagen);
            }
        }
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("ok", true);
        return ResponseEntity
                .ok()
                .body(respuesta);
    }
}

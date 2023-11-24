package com.example.helpdesk2.services;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileStorageServiceImpl {
    private final Path root = Paths.get("src/main/resources/static/reportes");

    public Path crearDirectorio(int idReporteIncidente) throws IOException {
        String nombreDirectorio = "reporte-" + idReporteIncidente;
        Path reporteFolder = root.resolve(nombreDirectorio);
        Files.createDirectories(reporteFolder);
        return reporteFolder;
    }

    public String guardar(MultipartFile imagen, Path reporteFolder) throws IOException {
        long timestamp = System.currentTimeMillis();
        String nombreImagen = timestamp + "-" + imagen.getOriginalFilename();
        Files.copy(imagen.getInputStream(), reporteFolder.resolve(nombreImagen), StandardCopyOption.REPLACE_EXISTING);
        return nombreImagen;
    }

    public Resource cargar(String archivo) {
        try {
            Path file = root.resolve(archivo);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

}

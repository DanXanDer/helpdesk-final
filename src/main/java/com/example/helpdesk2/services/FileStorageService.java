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
public class FileStorageService {
    private final Path root = Paths.get("src/main/resources/static/reportes");

    public Path crearDirectorio(int id, String prefijo, Path rootPath) throws IOException {
        String nombreDirectorio = prefijo + "-" + id;
        Path directorio = rootPath == null ? root.resolve(nombreDirectorio) : rootPath.resolve(nombreDirectorio);
        Files.createDirectories(directorio);
        return directorio;
    }

    public String guardar(MultipartFile imagen, Path folder) throws IOException {
        long timestamp = System.currentTimeMillis();
        String nombreImagen = timestamp + "-" + imagen.getOriginalFilename();
        Files.copy(imagen.getInputStream(), folder.resolve(nombreImagen), StandardCopyOption.REPLACE_EXISTING);
        return nombreImagen;
    }

    public Resource cargar(String archivo, String directorio) throws IOException {
        Path rootReporte = root.resolve(directorio);
        Path file = rootReporte.resolve(archivo);
        return new UrlResource(file.toUri());
    }
}


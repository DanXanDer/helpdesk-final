package com.example.helpdesk2.moduloCliente.services;

import com.example.helpdesk2.repositories.ImagenRepository;
import com.example.helpdesk2.repositories.ReporteImagenRepository;
import com.example.helpdesk2.repositories.ReporteIncidenteRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ReportarIncidenteService {
    private final ReporteIncidenteRepository reporteIncidenteRepository;
    private final ImagenRepository imagenRepository;
    private final ReporteImagenRepository reporteImagenRepository;

    public ReportarIncidenteService(ReporteIncidenteRepository reporteIncidenteRepository, ImagenRepository imagenRepository, ReporteImagenRepository reporteImagenRepository) {
        this.reporteIncidenteRepository = reporteIncidenteRepository;
        this.imagenRepository = imagenRepository;
        this.reporteImagenRepository = reporteImagenRepository;
    }

    public int registrarIncidente(int idCliente, String descripcion) {
        reporteIncidenteRepository.guardarReporteIncidente(idCliente, descripcion);
        return reporteIncidenteRepository.obtenerUltimoIDReporteIncidente();
    }

    public void registrarImagen(int idReporte, String nombreImagen){
        imagenRepository.guardarImagen(nombreImagen);
        int idImagen = imagenRepository.obtenerUltimoIDImagen();
        reporteImagenRepository.guardarReporteImagen(idReporte, idImagen);
    }

}

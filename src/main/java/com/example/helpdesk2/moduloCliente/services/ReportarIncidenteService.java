package com.example.helpdesk2.moduloCliente.services;

import com.example.helpdesk2.repositories.ReporteIncidenteRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ReportarIncidenteService {
    private final ReporteIncidenteRepository reporteIncidenteRepository;

    public ReportarIncidenteService(ReporteIncidenteRepository reporteIncidenteRepository) {
        this.reporteIncidenteRepository = reporteIncidenteRepository;
    }

    public int registrarIncidente(int idCliente, String descripcion) {
        reporteIncidenteRepository.insertarReporteIncidente(idCliente, descripcion);
        return reporteIncidenteRepository.obtenerUltimoIDReporteIncidente();
    }

    public void guardarArchivo(MultipartFile archivo){

    }

}

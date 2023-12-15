package com.example.helpdesk2.DTO;

import com.example.helpdesk2.models.ReporteIncidente;

import java.sql.Timestamp;

public class ReporteIncidenteDetalleDTO {
    private ReporteIncidente reporteIncidente;
    private String trabajador;
    private Timestamp fechaCreacion;

    public ReporteIncidenteDetalleDTO(ReporteIncidente reporteIncidente, String trabajador, Timestamp fechaCreacion) {
        this.reporteIncidente = reporteIncidente;
        this.trabajador = trabajador;
        this.fechaCreacion = fechaCreacion;
    }

    public ReporteIncidenteDetalleDTO() {
    }

    public ReporteIncidente getReporteIncidente() {
        return reporteIncidente;
    }

    public void setReporteIncidente(ReporteIncidente reporteIncidente) {
        this.reporteIncidente = reporteIncidente;
    }

    public String getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(String trabajador) {
        this.trabajador = trabajador;
    }

    public Timestamp getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Timestamp fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}

package com.example.helpdesk2.DTO;

import com.example.helpdesk2.models.Imagen;

import java.util.List;

public class ObtenerReporteIncidenteImagenDTO {
    private int idReporteIncidente;
    private String rutaImagen;

    public ObtenerReporteIncidenteImagenDTO() {
    }

    public ObtenerReporteIncidenteImagenDTO(int idReporteIncidente, String rutaImagen) {
        this.idReporteIncidente = idReporteIncidente;
        this.rutaImagen = rutaImagen;
    }

    public int getIdReporteIncidente() {
        return idReporteIncidente;
    }

    public void setIdReporteIncidente(int idReporteIncidente) {
        this.idReporteIncidente = idReporteIncidente;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

}

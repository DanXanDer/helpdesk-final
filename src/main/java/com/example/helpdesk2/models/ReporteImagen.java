package com.example.helpdesk2.models;

public class ReporteImagen {
    private int idReporte;
    private int idImagen;

    public ReporteImagen(int idReporte, int idImagen) {
        this.idReporte = idReporte;
        this.idImagen = idImagen;
    }

    public int getIdReporte() {
        return idReporte;
    }

    public void setIdReporte(int idReporte) {
        this.idReporte = idReporte;
    }

    public int getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(int idImagen) {
        this.idImagen = idImagen;
    }



}

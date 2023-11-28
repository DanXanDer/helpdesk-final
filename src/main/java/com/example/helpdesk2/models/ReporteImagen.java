package com.example.helpdesk2.models;

public class ReporteImagen {

    private int idReporteImagen;
    private int idReporteIncidente;
    private int idImagen;


    public ReporteImagen(int idReporteImagen, int idReporteIncidente, int idImagen) {
        this.idReporteImagen = idReporteImagen;
        this.idReporteIncidente = idReporteIncidente;
        this.idImagen = idImagen;
    }

    public ReporteImagen() {
    }

    public int getIdReporteImagen() {
        return idReporteImagen;
    }

    public void setIdReporteImagen(int idReporteImagen) {
        this.idReporteImagen = idReporteImagen;
    }

    public int getIdReporteIncidente() {
        return idReporteIncidente;
    }

    public void setIdReporteIncidente(int idReporteIncidente) {
        this.idReporteIncidente = idReporteIncidente;
    }

    public int getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(int idImagen) {
        this.idImagen = idImagen;
    }
}

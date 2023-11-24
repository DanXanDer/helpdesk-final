package com.example.helpdesk2.models;

public class Imagen {
    private int idImagen;
    private String nombreImagen;

    public Imagen() {
    }

    public Imagen(int idImagen, String nombreImagen) {
        this.idImagen = idImagen;
        this.nombreImagen = nombreImagen;
    }

    public int getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(int idImagen) {
        this.idImagen = idImagen;
    }

    public String getNombreImagen() {
        return nombreImagen;
    }

    public void setNombreImagen(String nombreImagen) {
        this.nombreImagen = nombreImagen;
    }

}

package com.example.helpdesk2.models;

public class PreguntaSeguridad {
    private int idPreguntaSeguridad;
    private String nombrePreguntaSeguridad;

    public PreguntaSeguridad() {
    }

    public PreguntaSeguridad(int idPreguntaSeguridad, String nombrePreguntaSeguridad) {
        this.idPreguntaSeguridad = idPreguntaSeguridad;
        this.nombrePreguntaSeguridad = nombrePreguntaSeguridad;
    }

    public int getIdPreguntaSeguridad() {
        return idPreguntaSeguridad;
    }

    public void setIdPreguntaSeguridad(int idPreguntaSeguridad) {
        this.idPreguntaSeguridad = idPreguntaSeguridad;
    }

    public String getNombrePreguntaSeguridad() {
        return nombrePreguntaSeguridad;
    }

    public void setNombrePreguntaSeguridad(String nombrePreguntaSeguridad) {
        this.nombrePreguntaSeguridad = nombrePreguntaSeguridad;
    }

}

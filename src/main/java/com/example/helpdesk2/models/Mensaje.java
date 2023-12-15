package com.example.helpdesk2.models;

import java.sql.Timestamp;

public class Mensaje {
    private int idMensaje;
    private String emisor;
    private String receptor;
    private String mensaje;
    private Timestamp fecha;

    public Mensaje() {
    }

    public Mensaje(int idMensaje, String emisor, String receptor, String mensaje, Timestamp fecha) {
        this.idMensaje = idMensaje;
        this.emisor = emisor;
        this.receptor = receptor;
        this.mensaje = mensaje;
        this.fecha = fecha;
    }

    public int getIdMensaje() {
        return idMensaje;
    }

    public void setIdMensaje(int idMensaje) {
        this.idMensaje = idMensaje;
    }

    public String getEmisor() {
        return emisor;
    }

    public void setEmisor(String emisor) {
        this.emisor = emisor;
    }

    public String getReceptor() {
        return receptor;
    }

    public void setReceptor(String receptor) {
        this.receptor = receptor;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }
}

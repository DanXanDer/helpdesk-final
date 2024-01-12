package com.example.helpdesk2.models;

import java.sql.Timestamp;

public class ActividadTicket {
    private int idActividadTicket;
    private int idTicket;
    private String emisor;
    private String mensaje;
    private String estado;
    private Timestamp fecha;

    public ActividadTicket() {
    }

    public ActividadTicket(int idActividadTicket, int idTicket, String emisor, String mensaje, String estado, Timestamp fecha) {
        this.idActividadTicket = idActividadTicket;
        this.idTicket = idTicket;
        this.emisor = emisor;
        this.mensaje = mensaje;
        this.estado = estado;
        this.fecha = fecha;
    }

    public int getIdActividadTicket() {
        return idActividadTicket;
    }

    public void setIdActividadTicket(int idActividadTicket) {
        this.idActividadTicket = idActividadTicket;
    }

    public int getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    public String getEmisor() {
        return emisor;
    }

    public void setEmisor(String emisor) {
        this.emisor = emisor;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }
}

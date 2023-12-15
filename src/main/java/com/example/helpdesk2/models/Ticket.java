package com.example.helpdesk2.models;

import java.sql.Timestamp;

public class Ticket {
    private int idTicket;
    private int idTrabajador;
    private int idReporteIncidente;
    private String estado;
    private Timestamp fecha;

    public Ticket() {
    }

    public Ticket(int idTicket, int idTrabajador, int idReporteIncidente, String estado, Timestamp fecha) {
        this.idTicket = idTicket;
        this.idTrabajador = idTrabajador;
        this.idReporteIncidente = idReporteIncidente;
        this.estado = estado;
        this.fecha = fecha;
    }

    public int getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    public int getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public int getIdReporteIncidente() {
        return idReporteIncidente;
    }

    public void setIdReporteIncidente(int idReporteIncidente) {
        this.idReporteIncidente = idReporteIncidente;
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

package com.example.helpdesk2.models;

public class Ticket {
    private int idTicket;
    private int idTrabajador;
    private int idReporteIncidente;
    private String estado;

    public Ticket() {
    }

    public Ticket(int idTicket, int idTrabajador, int idReporteIncidente, String estado) {
        this.idTicket = idTicket;
        this.idTrabajador = idTrabajador;
        this.idReporteIncidente = idReporteIncidente;
        this.estado = estado;
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
}

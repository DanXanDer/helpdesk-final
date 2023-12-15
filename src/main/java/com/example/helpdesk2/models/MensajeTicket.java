package com.example.helpdesk2.models;

public class MensajeTicket {
    private int idMensajeTicket;
    private int idTicket;
    private int idMensaje;

    public MensajeTicket() {
    }

    public MensajeTicket(int idMensajeTicket, int idTicket, int idMensaje) {
        this.idMensajeTicket = idMensajeTicket;
        this.idTicket = idTicket;
        this.idMensaje = idMensaje;
    }

    public int getIdMensajeTicket() {
        return idMensajeTicket;
    }

    public void setIdMensajeTicket(int idMensajeTicket) {
        this.idMensajeTicket = idMensajeTicket;
    }

    public int getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    public int getIdMensaje() {
        return idMensaje;
    }

    public void setIdMensaje(int idMensaje) {
        this.idMensaje = idMensaje;
    }
}

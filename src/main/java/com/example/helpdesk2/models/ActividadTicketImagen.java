package com.example.helpdesk2.models;

public class ActividadTicketImagen {
    private int idActividadTicketImagen;
    private int idActividadTicket;
    private int idImagen;

    public ActividadTicketImagen(int idActividadTicketImagen, int idActividadTicket, int idImagen) {
        this.idActividadTicketImagen = idActividadTicketImagen;
        this.idActividadTicket = idActividadTicket;
        this.idImagen = idImagen;
    }

    public ActividadTicketImagen() {
    }

    public int getIdActividadTicketImagen() {
        return idActividadTicketImagen;
    }

    public void setIdActividadTicketImagen(int idActividadTicketImagen) {
        this.idActividadTicketImagen = idActividadTicketImagen;
    }

    public int getIdActividadTicket() {
        return idActividadTicket;
    }

    public void setIdActividadTicket(int idActividadTicket) {
        this.idActividadTicket = idActividadTicket;
    }

    public int getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(int idImagen) {
        this.idImagen = idImagen;
    }
}

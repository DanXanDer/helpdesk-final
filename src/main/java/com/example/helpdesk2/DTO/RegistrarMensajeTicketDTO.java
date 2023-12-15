package com.example.helpdesk2.DTO;

public class RegistrarMensajeTicketDTO {
    private int idTicket;
    private String emisor;
    private String receptor;
    private String mensaje;

    public RegistrarMensajeTicketDTO() {
    }

    public RegistrarMensajeTicketDTO(int idTicket, String emisor, String receptor, String mensaje) {
        this.idTicket = idTicket;
        this.emisor = emisor;
        this.receptor = receptor;
        this.mensaje = mensaje;
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
}

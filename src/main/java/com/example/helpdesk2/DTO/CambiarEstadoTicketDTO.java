package com.example.helpdesk2.DTO;

public class CambiarEstadoTicketDTO {
    private int idTicket;
    private int idReporteIncidente;
    private String emisor;
    private String mensaje;
    private String estadoTicket;
    private String estadoReporteIncidente;

    public CambiarEstadoTicketDTO() {
    }

    public CambiarEstadoTicketDTO(int idTicket, int idReporteIncidente, String emisor, String mensaje, String estadoTicket, String estadoReporteIncidente) {
        this.idTicket = idTicket;
        this.idReporteIncidente = idReporteIncidente;
        this.emisor = emisor;
        this.mensaje = mensaje;
        this.estadoTicket = estadoTicket;
        this.estadoReporteIncidente = estadoReporteIncidente;
    }

    public int getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    public int getIdReporteIncidente() {
        return idReporteIncidente;
    }

    public void setIdReporteIncidente(int idReporteIncidente) {
        this.idReporteIncidente = idReporteIncidente;
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

    public String getEstadoTicket() {
        return estadoTicket;
    }

    public void setEstadoTicket(String estadoTicket) {
        this.estadoTicket = estadoTicket;
    }

    public String getEstadoReporteIncidente() {
        return estadoReporteIncidente;
    }

    public void setEstadoReporteIncidente(String estadoReporteIncidente) {
        this.estadoReporteIncidente = estadoReporteIncidente;
    }
}

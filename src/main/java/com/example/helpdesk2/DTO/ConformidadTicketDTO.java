package com.example.helpdesk2.DTO;

public class ConformidadTicketDTO {
    private int idTicket;
    private int idReporteIncidente;
    private String estadoTicket;
    private String estadoReporteIncidente;
    private String mensaje;

    public ConformidadTicketDTO() {
    }

    public ConformidadTicketDTO(int idTicket, int idReporteIncidente, String estadoTicket, String estadoReporteIncidente, String mensaje) {
        this.idTicket = idTicket;
        this.idReporteIncidente = idReporteIncidente;
        this.estadoTicket = estadoTicket;
        this.estadoReporteIncidente = estadoReporteIncidente;
        this.mensaje = mensaje;
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

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}

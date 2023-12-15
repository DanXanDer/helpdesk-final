package com.example.helpdesk2.DTO;

public class ActividadTicketDTO {
    private int idTicket;
    private int idReporteIncidente;
    private String mensaje;
    private String estado;

    public ActividadTicketDTO() {
    }

    public ActividadTicketDTO(int idTicket, int idReporteIncidente, String mensaje, String estado) {
        this.idTicket = idTicket;
        this.idReporteIncidente = idReporteIncidente;
        this.mensaje = mensaje;
        this.estado = estado;
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
}

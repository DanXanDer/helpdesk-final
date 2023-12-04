package com.example.helpdesk2.DTO;

public class EscogerTicketDTO {
    private int idReporteIncidente;
    private String estado;

    public EscogerTicketDTO() {
    }

    public EscogerTicketDTO(int idReporteIncidente, String estado) {
        this.idReporteIncidente = idReporteIncidente;
        this.estado = estado;
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

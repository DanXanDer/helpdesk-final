package com.example.helpdesk2.models;

import java.sql.Timestamp;

public class ReporteIncidente {
    private int idReporteIncidente;
    private int idCliente;
    private String descripcion;
    private Timestamp fecha;

    public ReporteIncidente(int idReporteIncidente, int idCliente, String descripcion, Timestamp fecha) {
        this.idReporteIncidente = idReporteIncidente;
        this.idCliente = idCliente;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public ReporteIncidente() {
    }

    public int getIdReporteIncidente() {
        return idReporteIncidente;
    }

    public void setIdReporteIncidente(int idReporteIncidente) {
        this.idReporteIncidente = idReporteIncidente;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

}

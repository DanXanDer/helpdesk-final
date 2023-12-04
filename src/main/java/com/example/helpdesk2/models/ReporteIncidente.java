package com.example.helpdesk2.models;

import java.sql.Timestamp;

public class ReporteIncidente {
    private int idReporteIncidente;
    private int idCliente;
    private String nombreIncidente;
    private String descripcion;
    private int nivel;
    private String estado;
    private Timestamp fecha;

    public ReporteIncidente() {
    }

    public ReporteIncidente(int idReporteIncidente, int idCliente, String nombreIncidente, String descripcion, int nivel, String estado, Timestamp fecha) {
        this.idReporteIncidente = idReporteIncidente;
        this.idCliente = idCliente;
        this.nombreIncidente = nombreIncidente;
        this.descripcion = descripcion;
        this.nivel = nivel;
        this.estado = estado;
        this.fecha = fecha;
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

    public String getNombreIncidente() {
        return nombreIncidente;
    }

    public void setNombreIncidente(String nombreIncidente) {
        this.nombreIncidente = nombreIncidente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
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

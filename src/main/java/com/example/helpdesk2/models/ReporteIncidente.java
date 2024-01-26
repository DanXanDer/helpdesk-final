package com.example.helpdesk2.models;

import java.sql.Timestamp;

public class ReporteIncidente {
    private int idReporteIncidente;
    private int idCliente;
    private String nombreIncidente;
    private String descripcion;
    private String estado;
    private Timestamp fecha;
    private String nombres;
    private String apellidos;
    private String nombreArea;
    private String nombreSede;
    private String nombreEmpresa;

    public ReporteIncidente(int idReporteIncidente, int idCliente, String nombreIncidente, String descripcion,
                            String estado, Timestamp fecha, String nombres, String apellidos, String nombreArea,
                            String nombreSede, String nombreEmpresa) {
        this.idReporteIncidente = idReporteIncidente;
        this.idCliente = idCliente;
        this.nombreIncidente = nombreIncidente;
        this.descripcion = descripcion;
        this.estado = estado;
        this.fecha = fecha;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.nombreArea = nombreArea;
        this.nombreSede = nombreSede;
        this.nombreEmpresa = nombreEmpresa;
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

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombreArea() {
        return nombreArea;
    }

    public void setNombreArea(String nombreArea) {
        this.nombreArea = nombreArea;
    }

    public String getNombreSede() {
        return nombreSede;
    }

    public void setNombreSede(String nombreSede) {
        this.nombreSede = nombreSede;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }
}

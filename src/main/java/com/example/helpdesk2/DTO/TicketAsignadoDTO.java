package com.example.helpdesk2.DTO;

import java.sql.Timestamp;

public class TicketAsignadoDTO {
    private int idTicket;
    private int idTrabajador;
    private int idReporteIncidente;
    private int idCliente;
    private String nombresCliente;
    private String apellidosCliente;
    private String nombresTrabajador;
    private String apellidosTrabajador;
    private String nombreIncidente;
    private String descripcion;
    private String estado;
    private Timestamp fecha;

    public TicketAsignadoDTO(int idTicket, int idTrabajador, int idReporteIncidente, int idCliente, String nombresCliente, String apellidosCliente, String nombresTrabajador, String apellidosTrabajador, String nombreIncidente, String descripcion, String estado, Timestamp fecha) {
        this.idTicket = idTicket;
        this.idTrabajador = idTrabajador;
        this.idReporteIncidente = idReporteIncidente;
        this.idCliente = idCliente;
        this.nombresCliente = nombresCliente;
        this.apellidosCliente = apellidosCliente;
        this.nombresTrabajador = nombresTrabajador;
        this.apellidosTrabajador = apellidosTrabajador;
        this.nombreIncidente = nombreIncidente;
        this.descripcion = descripcion;
        this.estado = estado;
        this.fecha = fecha;
    }

    public TicketAsignadoDTO() {
    }

    public int getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    public int getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
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

    public String getNombresCliente() {
        return nombresCliente;
    }

    public void setNombresCliente(String nombresCliente) {
        this.nombresCliente = nombresCliente;
    }

    public String getApellidosCliente() {
        return apellidosCliente;
    }

    public void setApellidosCliente(String apellidosCliente) {
        this.apellidosCliente = apellidosCliente;
    }

    public String getNombresTrabajador() {
        return nombresTrabajador;
    }

    public void setNombresTrabajador(String nombresTrabajador) {
        this.nombresTrabajador = nombresTrabajador;
    }

    public String getApellidosTrabajador() {
        return apellidosTrabajador;
    }

    public void setApellidosTrabajador(String apellidosTrabajador) {
        this.apellidosTrabajador = apellidosTrabajador;
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
}

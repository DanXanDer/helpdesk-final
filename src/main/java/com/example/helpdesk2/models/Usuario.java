package com.example.helpdesk2.models;

public class Usuario {
    private int idUsuario;
    private int idPreguntaSeguridad;
    private String nombreUsuario;
    private String clave;
    private String nombres;
    private String apellidos;
    private String correo;
    private String tipo;
    private String rptaSecreta;
    private int estado;
    private int primerLogin;

    public Usuario() {
    }

    public Usuario(int idUsuario, int idPreguntaSeguridad, String nombreUsuario, String clave, String nombres, String apellidos, String correo, String tipo, String rptaSecreta, int estado, int primerLogin) {
        this.idUsuario = idUsuario;
        this.idPreguntaSeguridad = idPreguntaSeguridad;
        this.nombreUsuario = nombreUsuario;
        this.clave = clave;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.tipo = tipo;
        this.rptaSecreta = rptaSecreta;
        this.estado = estado;
        this.primerLogin = primerLogin;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdPreguntaSeguridad() {
        return idPreguntaSeguridad;
    }

    public void setIdPreguntaSeguridad(int idPreguntaSeguridad) {
        this.idPreguntaSeguridad = idPreguntaSeguridad;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getRptaSecreta() {
        return rptaSecreta;
    }

    public void setRptaSecreta(String rptaSecreta) {
        this.rptaSecreta = rptaSecreta;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getPrimerLogin() {
        return primerLogin;
    }

    public void setPrimerLogin(int primerLogin) {
        this.primerLogin = primerLogin;
    }
}

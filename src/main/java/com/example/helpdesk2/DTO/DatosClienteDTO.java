package com.example.helpdesk2.DTO;

public class DatosClienteDTO {
    private int idUsuario;
    private String nombreUsuario;
    private String nombres;
    private String apellidos;
    private String correo;
    private int estado;
    private String nombreArea;
    private String nombreSede;
    private String nombreEmpresa;
    private String anydesk;
    private String teamviewer;

    public DatosClienteDTO() {
    }

    public DatosClienteDTO(int idUsuario, String nombreUsuario, String nombres, String apellidos, String correo, int estado, String nombreArea, String nombreSede, String nombreEmpresa, String anydesk, String teamviewer) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.estado = estado;
        this.nombreArea = nombreArea;
        this.nombreSede = nombreSede;
        this.nombreEmpresa = nombreEmpresa;
        this.anydesk = anydesk;
        this.teamviewer = teamviewer;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
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

    public String getAnydesk() {
        return anydesk;
    }

    public void setAnydesk(String anydesk) {
        this.anydesk = anydesk;
    }

    public String getTeamviewer() {
        return teamviewer;
    }

    public void setTeamviewer(String teamviewer) {
        this.teamviewer = teamviewer;
    }
}

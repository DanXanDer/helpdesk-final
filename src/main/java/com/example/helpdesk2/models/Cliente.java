package com.example.helpdesk2.models;

public class Cliente {
    private int idCliente;
    private int idUsuario;
    private int idArea;
    private String anydesk;
    private String teamviewer;

    public Cliente() {
    }

    public Cliente(int idCliente, int idUsuario, int idArea, String anydesk, String teamviewer) {
        this.idCliente = idCliente;
        this.idUsuario = idUsuario;
        this.idArea = idArea;
        this.anydesk = anydesk;
        this.teamviewer = teamviewer;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdArea() {
        return idArea;
    }

    public void setIdArea(int idArea) {
        this.idArea = idArea;
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

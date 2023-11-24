package com.example.helpdesk2.models;

public class Trabajador {
    private int idTrabajador;
    private int idUsuario;
    private int nivel;

    public Trabajador() {
    }

    public Trabajador(int idTrabajador, int idUsuario, int nivel) {
        this.idTrabajador = idTrabajador;
        this.idUsuario = idUsuario;
        this.nivel = nivel;
    }

    public int getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
}

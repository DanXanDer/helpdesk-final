package com.example.helpdesk2.moduloSeguridad.DTO;

public class UsuarioIDRequest {
    private int idUsuario;

    public UsuarioIDRequest(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public UsuarioIDRequest() {
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}

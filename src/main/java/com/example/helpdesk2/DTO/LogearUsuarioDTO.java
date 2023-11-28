package com.example.helpdesk2.DTO;

public class LogearUsuarioDTO {

    private int idUsuario;

    public LogearUsuarioDTO(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public LogearUsuarioDTO() {
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}

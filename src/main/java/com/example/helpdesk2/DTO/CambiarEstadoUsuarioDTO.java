package com.example.helpdesk2.DTO;

public class CambiarEstadoUsuarioDTO {
    private int idUsuario;
    private int estado;

    public CambiarEstadoUsuarioDTO(int idUsuario, int estado) {
        this.idUsuario = idUsuario;
        this.estado = estado;
    }

    public CambiarEstadoUsuarioDTO() {
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}

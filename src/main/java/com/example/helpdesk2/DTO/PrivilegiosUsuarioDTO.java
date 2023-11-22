package com.example.helpdesk2.DTO;

public class PrivilegiosUsuarioDTO {

    private int idUsuario;

    public PrivilegiosUsuarioDTO(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public PrivilegiosUsuarioDTO() {
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}

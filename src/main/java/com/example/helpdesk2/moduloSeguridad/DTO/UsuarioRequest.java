package com.example.helpdesk2.moduloSeguridad.DTO;


import jakarta.validation.constraints.NotBlank;

public class UsuarioRequest {

    @NotBlank(message = "El nombre de usuario no puede estar vacío")
    private String nombreUsuario;

    @NotBlank(message = "La clave no puede estar vacía")
    private String clave;

    public UsuarioRequest(String nombreUsuario, String clave) {
        this.nombreUsuario = nombreUsuario;
        this.clave = clave;
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
}

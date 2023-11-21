package com.example.helpdesk2.moduloSeguridad.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ReestablecerClaveRequest {
    private int idUsuario;
    @Size(min = 8, max = 20, message = "La clave debe tener entre 8 y 20 caracteres")
    private String clave;
    @Size(min = 8, max = 20, message = "La clave debe tener entre 8 y 20 caracteres")
    private String reClave;

    public ReestablecerClaveRequest(int idUsuario, String clave, String reClave) {
        this.idUsuario = idUsuario;
        this.clave = clave;
        this.reClave = reClave;
    }

    public ReestablecerClaveRequest() {
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getReClave() {
        return reClave;
    }

    public void setReClave(String reClave) {
        this.reClave = reClave;
    }
}

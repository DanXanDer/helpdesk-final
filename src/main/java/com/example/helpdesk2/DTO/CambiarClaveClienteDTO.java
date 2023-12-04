package com.example.helpdesk2.DTO;

import jakarta.validation.constraints.NotNull;

public class CambiarClaveClienteDTO {

    @NotNull(message = "La clave no puede ser nula")
    private String clave;

    @NotNull(message = "La clave no puede ser nula")
    private String reClave;

    public CambiarClaveClienteDTO() {
    }

    public CambiarClaveClienteDTO(String clave, String reClave) {
        this.clave = clave;
        this.reClave = reClave;
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

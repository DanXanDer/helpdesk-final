package com.example.helpdesk2.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CompletarDatosDTO {

    private int idUsuario;

    @Size(min = 8, max = 20, message = "La clave debe tener entre 8 y 20 caracteres")
    private String clave;

    @Size(min = 8, max = 20, message = "La clave debe tener entre 8 y 20 caracteres")
    private String reClave;

    private int preguntaSeguridad;

    @NotBlank(message = "La respuesta secreta no puede estar vacía")
    private String rptaSecreta;

    public CompletarDatosDTO() {
    }

    public CompletarDatosDTO(int idUsuario, String clave, String reClave, int preguntaSeguridad, String rptaSecreta) {
        this.idUsuario = idUsuario;
        this.clave = clave;
        this.reClave = reClave;
        this.preguntaSeguridad = preguntaSeguridad;
        this.rptaSecreta = rptaSecreta;
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

    public int getPreguntaSeguridad() {
        return preguntaSeguridad;
    }

    public void setPreguntaSeguridad(int preguntaSeguridad) {
        this.preguntaSeguridad = preguntaSeguridad;
    }

    public String getRptaSecreta() {
        return rptaSecreta;
    }

    public void setRptaSecreta(String rptaSecreta) {
        this.rptaSecreta = rptaSecreta;
    }
}

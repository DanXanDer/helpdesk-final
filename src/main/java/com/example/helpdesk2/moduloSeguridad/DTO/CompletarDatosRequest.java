package com.example.helpdesk2.moduloSeguridad.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CompletarDatosRequest {

    private int idUsuario;

    @Size(min = 8, max = 20, message = "La clave debe tener entre 8 y 20 caracteres")
    private String clave;

    @Size(min = 8, max = 20, message = "La clave debe tener entre 8 y 20 caracteres")
    private String nuevaClave;

    private int preguntaSeguridad;

    @NotBlank(message = "La respuesta secreta no puede estar vacía")
    private String rptaSecreta;

    public CompletarDatosRequest(int idUsuario, String clave, String nuevaClave, int preguntaSeguridad, String rptaSecreta) {
        this.idUsuario = idUsuario;
        this.clave = clave;
        this.nuevaClave = nuevaClave;
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

    public String getNuevaClave() {
        return nuevaClave;
    }

    public void setNuevaClave(String nuevaClave) {
        this.nuevaClave = nuevaClave;
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

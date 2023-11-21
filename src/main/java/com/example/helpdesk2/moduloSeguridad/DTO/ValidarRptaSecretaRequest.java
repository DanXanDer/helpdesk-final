package com.example.helpdesk2.moduloSeguridad.DTO;

import jakarta.validation.constraints.NotBlank;

public class ValidarRptaSecretaRequest {

    int idUsuario;
    @NotBlank(message = "El campo de respuesta secreta no debe estar vacío")
    private String rptaSecreta;

    public ValidarRptaSecretaRequest(int idUsuario, String rptaSecreta) {
        this.idUsuario = idUsuario;
        this.rptaSecreta = rptaSecreta;
    }

    public ValidarRptaSecretaRequest() {
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getRptaSecreta() {
        return rptaSecreta;
    }

    public void setRptaSecreta(String rptaSecreta) {
        this.rptaSecreta = rptaSecreta;
    }
}

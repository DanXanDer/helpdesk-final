package com.example.helpdesk2.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class ActualizarDatosClienteDTO {

    @Pattern(regexp = "^[0-9]{9}$", message = "El campo anydesk debe tener 9 dígitos")
    private String anydesk;

    @Pattern(regexp = "^[0-9]{9}$", message = "El campo teamviewer debe tener 9 dígitos")
    private String teamviewer;

    @Email(message = "El campo correo debe ser un correo válido")
    private String correo;

    public ActualizarDatosClienteDTO() {
    }

    public ActualizarDatosClienteDTO(String anydesk, String teamviewer, String correo) {
        this.anydesk = anydesk;
        this.teamviewer = teamviewer;
        this.correo = correo;
    }

    public String getAnydesk() {
        return anydesk;
    }

    public void setAnydesk(String anydesk) {
        this.anydesk = anydesk;
    }

    public String getTeamviewer() {
        return teamviewer;
    }

    public void setTeamviewer(String teamviewer) {
        this.teamviewer = teamviewer;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}

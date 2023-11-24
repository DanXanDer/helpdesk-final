package com.example.helpdesk2.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class RegistrarClienteDTO extends RegistrarUsuarioDTO {

    private int idUsuario;

    @NotNull(message = "Seleccione un área")
    private int idArea;

    @NotBlank(message = "Ingrese el ID de AnyDesk")
    private String anydesk;

    @NotBlank(message = "Ingrese el ID de TeamViewer")
    private String teamviewer;

    public RegistrarClienteDTO(String nombreUsuario, String clave, String nombres, String apellidos, String correo, String tipo, List<Integer> privilegios, int idUsuario, int idArea, String anydesk, String teamviewer) {
        super(nombreUsuario, clave, nombres, apellidos, correo, tipo, privilegios);
        this.idUsuario = idUsuario;
        this.idArea = idArea;
        this.anydesk = anydesk;
        this.teamviewer = teamviewer;
    }

    public RegistrarClienteDTO(String nombreUsuario, String clave, String nombres, String apellidos, String correo, String tipo, List<Integer> privilegios) {
        super(nombreUsuario, clave, nombres, apellidos, correo, tipo, privilegios);
    }

    public RegistrarClienteDTO(int idUsuario, int idArea, String anydesk, String teamviewer) {
        this.idUsuario = idUsuario;
        this.idArea = idArea;
        this.anydesk = anydesk;
        this.teamviewer = teamviewer;
    }

    public RegistrarClienteDTO() {
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdArea() {
        return idArea;
    }

    public void setIdArea(int idArea) {
        this.idArea = idArea;
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
}

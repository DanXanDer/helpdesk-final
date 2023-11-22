package com.example.helpdesk2.DTO;

import java.util.List;

public class RegistrarClienteDTO extends RegistrarUsuarioDTO {

    private int idEmpresa;
    private int idSede;
    private int idArea;
    private String anydesk;
    private String teamviewer;

    public RegistrarClienteDTO(String nombreUsuario, String clave, String nombres, String apellidos, String correo, String tipo, List<Integer> privilegios, int idEmpresa, int idSede, int idArea, String anydesk, String teamviewer) {
        super(nombreUsuario, clave, nombres, apellidos, correo, tipo, privilegios);
        this.idEmpresa = idEmpresa;
        this.idSede = idSede;
        this.idArea = idArea;
        this.anydesk = anydesk;
        this.teamviewer = teamviewer;
    }

    public RegistrarClienteDTO(String nombreUsuario, String clave, String nombres, String apellidos, String correo, String tipo, List<Integer> privilegios) {
        super(nombreUsuario, clave, nombres, apellidos, correo, tipo, privilegios);
    }

    public RegistrarClienteDTO() {
    }

    public RegistrarClienteDTO(int idEmpresa, int idSede, int idArea, String anydesk, String teamviewer) {
        this.idEmpresa = idEmpresa;
        this.idSede = idSede;
        this.idArea = idArea;
        this.anydesk = anydesk;
        this.teamviewer = teamviewer;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public int getIdSede() {
        return idSede;
    }

    public void setIdSede(int idSede) {
        this.idSede = idSede;
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

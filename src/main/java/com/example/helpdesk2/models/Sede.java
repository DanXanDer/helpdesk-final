package com.example.helpdesk2.models;

public class Sede {
    private int idSede;
    private int idEmpresa;
    private String nombreSede;

    public Sede(int idSede, int idEmpresa, String nombreSede) {
        this.idSede = idSede;
        this.idEmpresa = idEmpresa;
        this.nombreSede = nombreSede;
    }

    public Sede() {
    }

    public int getIdSede() {
        return idSede;
    }

    public void setIdSede(int idSede) {
        this.idSede = idSede;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNombreSede() {
        return nombreSede;
    }

    public void setNombreSede(String nombreSede) {
        this.nombreSede = nombreSede;
    }
}

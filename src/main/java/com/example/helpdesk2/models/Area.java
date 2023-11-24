package com.example.helpdesk2.models;

public class Area {
    private int idArea;
    private int idSede;
    private String nombreArea;

    public Area(int idArea, int idSede, String nombreArea) {
        this.idArea = idArea;
        this.idSede = idSede;
        this.nombreArea = nombreArea;
    }

    public Area() {
    }

    public int getIdArea() {
        return idArea;
    }

    public void setIdArea(int idArea) {
        this.idArea = idArea;
    }

    public int getIdSede() {
        return idSede;
    }

    public void setIdSede(int idSede) {
        this.idSede = idSede;
    }

    public String getNombreArea() {
        return nombreArea;
    }

    public void setNombreArea(String nombreArea) {
        this.nombreArea = nombreArea;
    }

}

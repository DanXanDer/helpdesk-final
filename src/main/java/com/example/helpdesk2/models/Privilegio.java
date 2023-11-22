package com.example.helpdesk2.models;

public class Privilegio {
    private int idPrivilegio;
    private String label;
    private String path;
    private String button;
    private String icon;

    public Privilegio() {
    }

    public Privilegio(int idPrivilegio, String label, String path, String button, String icon) {
        this.idPrivilegio = idPrivilegio;
        this.label = label;
        this.path = path;
        this.button = button;
        this.icon = icon;
    }

    public int getIdPrivilegio() {
        return idPrivilegio;
    }

    public void setIdPrivilegio(int idPrivilegio) {
        this.idPrivilegio = idPrivilegio;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getButton() {
        return button;
    }

    public void setButton(String button) {
        this.button = button;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}

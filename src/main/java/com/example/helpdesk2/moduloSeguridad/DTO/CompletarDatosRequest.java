package com.example.helpdesk2.moduloSeguridad.DTO;

public class CompletarDatosRequest {
    private int idUsuario;
    private String clave;
    private String nuevaClave;
    private int preguntaSeguridad;
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

package com.example.helpdesk2.DTO;

public class ObtenerImagenesMensajeDTO {
    private int idTicket;
    private int idMensaje;
    private String rutaImagen;

    public ObtenerImagenesMensajeDTO(int idTicket, int idMensaje, String rutaImagen) {
        this.idTicket = idTicket;
        this.idMensaje = idMensaje;
        this.rutaImagen = rutaImagen;
    }

    public ObtenerImagenesMensajeDTO() {
    }

    public int getIdTicket() {
        return idTicket;
    }

    public int getIdMensaje() {
        return idMensaje;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    public void setIdMensaje(int idMensaje) {
        this.idMensaje = idMensaje;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }
}

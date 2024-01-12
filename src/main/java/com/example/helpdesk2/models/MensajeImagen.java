package com.example.helpdesk2.models;

public class MensajeImagen {
    private int id_mensaje_imagen;
    private int id_mensaje;
    private int id_imagen;

    public MensajeImagen() {
    }

    public MensajeImagen(int id_mensaje_imagen, int id_mensaje, int id_imagen) {
        this.id_mensaje_imagen = id_mensaje_imagen;
        this.id_mensaje = id_mensaje;
        this.id_imagen = id_imagen;
    }

    public int getId_mensaje_imagen() {
        return id_mensaje_imagen;
    }

    public void setId_mensaje_imagen(int id_mensaje_imagen) {
        this.id_mensaje_imagen = id_mensaje_imagen;
    }

    public int getId_mensaje() {
        return id_mensaje;
    }

    public void setId_mensaje(int id_mensaje) {
        this.id_mensaje = id_mensaje;
    }

    public int getId_imagen() {
        return id_imagen;
    }

    public void setId_imagen(int id_imagen) {
        this.id_imagen = id_imagen;
    }
}

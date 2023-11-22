package com.example.helpdesk2.DTO;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class RegistrarTrabajadorDTO extends RegistrarUsuarioDTO {

    private int idUsuario;
    private int nivel;

    public RegistrarTrabajadorDTO(String nombreUsuario, String clave, String nombres, String apellidos, String correo, String tipo, List<Integer> privilegios) {
        super(nombreUsuario, clave, nombres, apellidos, correo, tipo, privilegios);
    }

    public RegistrarTrabajadorDTO(String nombreUsuario, String clave, String nombres, String apellidos, String correo, String tipo, List<Integer> privilegios, int idUsuario, int nivel) {
        super(nombreUsuario, clave, nombres, apellidos, correo, tipo, privilegios);
        this.idUsuario = idUsuario;
        this.nivel = nivel;
    }

    public RegistrarTrabajadorDTO(int idUsuario, int nivel) {
        this.idUsuario = idUsuario;
        this.nivel = nivel;
    }

    public RegistrarTrabajadorDTO() {
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
}

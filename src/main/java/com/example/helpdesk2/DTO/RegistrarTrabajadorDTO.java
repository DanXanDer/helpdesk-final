package com.example.helpdesk2.DTO;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class RegistrarTrabajadorDTO extends RegistrarUsuarioDTO {

    private int idUsuario;

    public RegistrarTrabajadorDTO(String nombreUsuario, String clave, String nombres, String apellidos, String correo, String tipo, List<Integer> privilegios, int idUsuario) {
        super(nombreUsuario, clave, nombres, apellidos, correo, tipo, privilegios);
        this.idUsuario = idUsuario;
    }

    public RegistrarTrabajadorDTO(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public RegistrarTrabajadorDTO(String nombreUsuario, String clave, String nombres, String apellidos, String correo, String tipo, List<Integer> privilegios) {
        super(nombreUsuario, clave, nombres, apellidos, correo, tipo, privilegios);
    }

    public RegistrarTrabajadorDTO() {
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}

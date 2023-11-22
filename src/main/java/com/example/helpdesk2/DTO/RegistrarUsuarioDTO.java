package com.example.helpdesk2.DTO;

import jakarta.validation.constraints.*;

import java.util.List;

public abstract class RegistrarUsuarioDTO {

    @Size(min = 8, max = 20, message = "El nombre de usuario debe tener entre 4 y 20 caracteres")
    private String nombreUsuario;
    @Size(min = 8, max = 20, message = "La clave debe tener entre 8 y 20 caracteres")
    private String clave;
    @NotBlank(message = "El campo de nombres no puede estar vacío")
    private String nombres;
    @NotBlank(message = "El campo apellidos no puede estar vacío")
    private String apellidos;
    @Email(message = "El correo electrónico no es válido")
    private String correo;
    private String tipo;
    @NotEmpty(message = "Debe seleccionar al menos un privilegio")
    private List<Integer> privilegios;

    public RegistrarUsuarioDTO(String nombreUsuario, String clave, String nombres, String apellidos, String correo, String tipo, List<Integer> privilegios) {
        this.nombreUsuario = nombreUsuario;
        this.clave = clave;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.tipo = tipo;
        this.privilegios = privilegios;
    }

    public RegistrarUsuarioDTO() {
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<Integer> getPrivilegios() {
        return privilegios;
    }

    public void setPrivilegios(List<Integer> privilegios) {
        this.privilegios = privilegios;
    }
}

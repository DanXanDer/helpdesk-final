package com.example.helpdesk2.services;

import com.example.helpdesk2.models.Privilegio;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;

@Component
@SessionScope
public class LoggedUserManagamentService {

    private int idUsuario;
    private String nombreUsuario;
    private String nombres;
    private String tipo;
    private List<Privilegio> privilegios;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<Privilegio> getPrivilegios() {
        return privilegios;
    }

    public void setPrivilegios(List<Privilegio> privilegios) {
        this.privilegios = privilegios;
    }
}

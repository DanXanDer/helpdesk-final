package com.example.helpdesk2.models;

public class UsuarioPrivilegio {
    private int idUsPriv;
    private int idUsuario;
    private int idPrivilegio;

    public UsuarioPrivilegio() {
    }

    public UsuarioPrivilegio(int idUsPriv, int idUsuario, int idPrivilegio) {
        this.idUsPriv = idUsPriv;
        this.idUsuario = idUsuario;
        this.idPrivilegio = idPrivilegio;
    }

    public int getIdUsPriv() {
        return idUsPriv;
    }

    public void setIdUsPriv(int idUsPriv) {
        this.idUsPriv = idUsPriv;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdPrivilegio() {
        return idPrivilegio;
    }

    public void setIdPrivilegio(int idPrivilegio) {
        this.idPrivilegio = idPrivilegio;
    }
}

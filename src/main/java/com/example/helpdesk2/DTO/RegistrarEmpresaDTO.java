package com.example.helpdesk2.DTO;

import java.util.List;

public class RegistrarEmpresaDTO {
    private String nombreEmpresa;
    private List<SedeDTO> sedes;

    public RegistrarEmpresaDTO() {
    }

    public RegistrarEmpresaDTO(String nombreEmpresa, List<SedeDTO> sedes) {
        this.nombreEmpresa = nombreEmpresa;
        this.sedes = sedes;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public List<SedeDTO> getSedes() {
        return sedes;
    }

    public void setSedes(List<SedeDTO> sedes) {
        this.sedes = sedes;
    }
}

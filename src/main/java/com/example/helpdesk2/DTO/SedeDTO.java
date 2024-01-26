package com.example.helpdesk2.DTO;

import java.util.List;

public class SedeDTO {
   private String direccion;
   private List<AreaDTO> areas;

    public SedeDTO() {
    }

    public SedeDTO(String direccion, List<AreaDTO> areas) {
        this.direccion = direccion;
        this.areas = areas;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<AreaDTO> getAreas() {
        return areas;
    }

    public void setAreas(List<AreaDTO> areas) {
        this.areas = areas;
    }
}

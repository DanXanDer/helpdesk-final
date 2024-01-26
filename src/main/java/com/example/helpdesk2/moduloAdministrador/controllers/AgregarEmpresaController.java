package com.example.helpdesk2.moduloAdministrador.controllers;

import com.example.helpdesk2.DTO.AreaDTO;
import com.example.helpdesk2.DTO.RegistrarEmpresaDTO;
import com.example.helpdesk2.DTO.SedeDTO;
import com.example.helpdesk2.moduloAdministrador.services.AgregarEmpresaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/modulo-administrador")
public class AgregarEmpresaController {
    private final AgregarEmpresaService agregarEmpresaService;

    public AgregarEmpresaController(AgregarEmpresaService agregarEmpresaService) {
        this.agregarEmpresaService = agregarEmpresaService;
    }

    @PostMapping("/agregar-empresa")
    public String agregarEmpresa(@RequestBody RegistrarEmpresaDTO registrarEmpresaDTO){
        System.out.println(registrarEmpresaDTO.getNombreEmpresa());
        int idEmpresa = agregarEmpresaService.registrarEmpresa(registrarEmpresaDTO.getNombreEmpresa());
        for (SedeDTO sede : registrarEmpresaDTO.getSedes()){
            int idSede = agregarEmpresaService.registrarSede(idEmpresa, sede.getDireccion());
            for(AreaDTO area : sede.getAreas()){
                agregarEmpresaService.registrarArea(idSede, area.getNombre());
            }
        }
        return "Empresa agregada exitosamente";
    }

}

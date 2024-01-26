package com.example.helpdesk2.moduloAdministrador.services;

import com.example.helpdesk2.moduloAdministrador.exceptions.NombreEmpresaExisteException;
import com.example.helpdesk2.repositories.AreaRepository;
import com.example.helpdesk2.repositories.EmpresaRepository;
import com.example.helpdesk2.repositories.SedeRepository;
import org.springframework.stereotype.Service;

@Service
public class AgregarEmpresaService {
    private final EmpresaRepository empresaRepository;
    private final SedeRepository sedeRepository;
    private final AreaRepository areaRepository;

    public AgregarEmpresaService(EmpresaRepository empresaRepository, SedeRepository sedeRepository, AreaRepository areaRepository) {
        this.empresaRepository = empresaRepository;
        this.sedeRepository = sedeRepository;
        this.areaRepository = areaRepository;
    }

    public int registrarEmpresa(String nombreEmpresa){
        if(empresaRepository.buscarNombreEmpresaExistente(nombreEmpresa).isPresent()){
            throw new NombreEmpresaExisteException();
        }
        empresaRepository.guardarEmpresa(nombreEmpresa, "Habilitado");
        return empresaRepository.obtenerUltimoIdEmpresa();
    }

    public int registrarSede(int idEmpresa, String nombreSede){
        sedeRepository.guardarSede(idEmpresa, nombreSede, "Habilitado");
        return sedeRepository.obtenerUltimoIdSede();
    }

    public void registrarArea(int idSede, String nombreArea){
        areaRepository.guardarArea(idSede, nombreArea, "Habilitado");
    }

}

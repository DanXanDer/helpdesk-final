package com.example.helpdesk2.repositories;

import com.example.helpdesk2.DTO.RegistrarEmpresaDTO;
import com.example.helpdesk2.models.Area;
import com.example.helpdesk2.models.Empresa;
import com.example.helpdesk2.models.Sede;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface EmpresaRepository extends CrudRepository<Empresa, Integer> {

    @Query("SELECT * FROM empresa")
    List<Empresa> buscarEmpresas();

    @Query("SELECT nombre_empresa FROM empresa WHERE nombre_empresa = :nombreEmpresa")
    Optional<String> buscarNombreEmpresaExistente(String nombreEmpresa);

    @Modifying
    @Query("INSERT INTO empresa (nombre_empresa, estado) VALUES (:nombreEmpresa, :estado)")
    void guardarEmpresa(String nombreEmpresa, String estado);

    @Query("SELECT LAST_INSERT_ID()")
    int obtenerUltimoIdEmpresa();
}

package com.example.helpdesk2.repositories;

import com.example.helpdesk2.models.Area;
import com.example.helpdesk2.models.Empresa;
import com.example.helpdesk2.models.Sede;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmpresaRepository extends CrudRepository<Empresa, Integer> {

    @Query("SELECT * FROM empresa")
    List<Empresa> buscarEmpresas();

}

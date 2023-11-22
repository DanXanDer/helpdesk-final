package com.example.helpdesk2.repositories;

import com.example.helpdesk2.models.Sede;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SedeRepository extends CrudRepository<Sede, Integer> {
    @Query("SELECT * FROM sede WHERE id_empresa = :idEmpresa")
    List<Sede> buscarSedesPorEmpresa(int idEmpresa);
}

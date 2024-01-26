package com.example.helpdesk2.repositories;

import com.example.helpdesk2.models.Sede;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SedeRepository extends CrudRepository<Sede, Integer> {
    @Query("SELECT * FROM sede WHERE id_empresa = :idEmpresa")
    List<Sede> buscarSedesPorEmpresa(int idEmpresa);

    @Modifying
    @Query("INSERT INTO sede (id_empresa, nombre_sede, estado) VALUES (:idEmpresa, :nombreSede, :estado)")
    void guardarSede(int idEmpresa, String nombreSede, String estado);

    @Query("SELECT LAST_INSERT_ID()")
    int obtenerUltimoIdSede();
}

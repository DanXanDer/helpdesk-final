package com.example.helpdesk2.repositories;

import com.example.helpdesk2.models.Area;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AreaRepository extends CrudRepository<Area, Integer> {

    @Query("SELECT * FROM area WHERE id_sede = :idSede")
    List<Area> buscarAreasPorSede(int idSede);

    @Modifying
    @Query("INSERT INTO area (id_sede, nombre_area, estado) VALUES (:idSede, :nombreArea, :estado)")
    void guardarArea(int idSede, String nombreArea, String estado);

}

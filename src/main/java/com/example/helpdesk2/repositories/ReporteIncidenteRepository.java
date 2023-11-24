package com.example.helpdesk2.repositories;

import com.example.helpdesk2.models.ReporteIncidente;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

public interface ReporteIncidenteRepository extends CrudRepository<ReporteIncidente, Integer> {
    @Modifying
    @Query("INSERT INTO reporte_incidente (id_cliente, descripcion) VALUES (:idCliente, :descripcion)")
    void guardarReporteIncidente(int idCliente, String descripcion);

    @Query("SELECT LAST_INSERT_ID()")
    int obtenerUltimoIDReporteIncidente();
}

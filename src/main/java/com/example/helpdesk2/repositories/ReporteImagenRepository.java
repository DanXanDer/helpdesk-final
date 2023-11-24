package com.example.helpdesk2.repositories;

import com.example.helpdesk2.models.ReporteImagen;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

public interface ReporteImagenRepository extends CrudRepository<ReporteImagen, Integer> {

    @Modifying
    @Query("INSERT INTO reporte_imagen (id_reporte_incidente, id_imagen) VALUES (:idReporte, :idImagen)")
    void guardarReporteImagen(int idReporte, int idImagen);
}

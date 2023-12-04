package com.example.helpdesk2.repositories;

import com.example.helpdesk2.models.Imagen;
import com.example.helpdesk2.models.Privilegio;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ImagenRepository extends CrudRepository<Imagen, Integer> {

    @Modifying
    @Query("INSERT INTO imagen (nombre_imagen) VALUES (:nombreImagen)")
    void guardarImagen(String nombreImagen);

    @Query("SELECT LAST_INSERT_ID()")
    int obtenerUltimoIDImagen();

    @Query("SELECT i.* FROM imagen i " +
            "JOIN reporte_imagen ri ON i.id_imagen = ri.id_imagen " +
            "JOIN reporte_incidente rin ON ri.id_reporte_incidente = rin.id_reporte_incidente " +
            "WHERE rin.id_reporte_incidente = :idReporteIncidente" )
    List<Imagen> buscarImagenesReporte(int idReporteIncidente);
}

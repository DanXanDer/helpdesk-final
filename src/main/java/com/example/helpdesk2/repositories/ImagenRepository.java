package com.example.helpdesk2.repositories;

import com.example.helpdesk2.models.Imagen;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

public interface ImagenRepository extends CrudRepository<Imagen, Integer> {

    @Modifying
    @Query("INSERT INTO imagen (nombre_imagen) VALUES (:nombreImagen)")
    void guardarImagen(String nombreImagen);

    @Query("SELECT LAST_INSERT_ID()")
    int obtenerUltimoIDImagen();
}

package com.example.helpdesk2.repositories;

import com.example.helpdesk2.models.MensajeImagen;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

public interface MensajeImagenRepository extends CrudRepository<MensajeImagen, Integer> {
    @Modifying
    @Query("INSERT INTO mensaje_imagen (id_mensaje, id_imagen) VALUES (:idMensaje, :idImagen)")
    void guardarMensajeImagen(int idMensaje, int idImagen);
}

package com.example.helpdesk2.repositories;

import com.example.helpdesk2.models.ActividadTicketImagen;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

public interface ActividadTicketImagenRepository extends CrudRepository<ActividadTicketImagen, Integer> {
    @Modifying
    @Query("INSERT INTO actividad_ticket_imagen (id_actividad_ticket, id_imagen) VALUES (:idActividadTicket, :idImagen)")
    void guardarActividadTicketImagen(int idActividadTicket, int idImagen);
}

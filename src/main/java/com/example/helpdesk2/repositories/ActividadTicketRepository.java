package com.example.helpdesk2.repositories;

import com.example.helpdesk2.models.ActividadTicket;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

public interface ActividadTicketRepository extends CrudRepository<ActividadTicket, Integer> {

    @Modifying
    @Query("INSERT INTO actividad_ticket (id_ticket, emisor, mensaje, estado) " +
            "VALUES (:idTicket, :emisor, :mensaje, :estado)")
    void guardarActividadTicket(int idTicket, String emisor, String mensaje, String estado);

    @Query("SELECT LAST_INSERT_ID()")
    int obtenerUltimoIdInsertado();
}
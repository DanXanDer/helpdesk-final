package com.example.helpdesk2.repositories;

import com.example.helpdesk2.models.MensajeTicket;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

public interface MensajeTicketRepository extends CrudRepository<MensajeTicket, Integer> {

    @Modifying
    @Query("INSERT INTO mensaje_ticket (id_ticket, id_mensaje) VALUES (:idTicket, :idMensaje)")
    void guardarMensajeTicket(int idTicket, int idMensaje);
}

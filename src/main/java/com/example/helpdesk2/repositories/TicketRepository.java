package com.example.helpdesk2.repositories;

import com.example.helpdesk2.models.Ticket;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

public interface TicketRepository extends CrudRepository<Ticket, Integer> {

    @Modifying
    @Query("INSERT INTO ticket (id_trabajador, id_reporte_incidente) VALUES (:idTrabajador, :idReporteIncidente)")
    void guardarTicket(int idTrabajador, int idReporteIncidente);
}

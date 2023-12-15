package com.example.helpdesk2.repositories;

import com.example.helpdesk2.DTO.TicketAsignadoDTO;
import com.example.helpdesk2.models.Ticket;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TicketRepository extends CrudRepository<Ticket, Integer> {

    @Modifying
    @Query("INSERT INTO ticket (id_trabajador, id_reporte_incidente) VALUES (:idTrabajador, :idReporteIncidente)")
    void guardarTicket(int idTrabajador, int idReporteIncidente);

    @Query("SELECT t.id_ticket, t.id_reporte_incidente, t.estado, ri.id_cliente, ri.nombre_incidente, ri.descripcion, ri.nivel, ri.fecha " +
            "FROM ticket t " +
            "INNER JOIN reporte_incidente ri " +
            "ON t.id_reporte_incidente = ri.id_reporte_incidente " +
            "WHERE t.id_trabajador = :idTrabajador " +
            "AND ri.nivel <= (SELECT nivel FROM trabajador WHERE id_trabajador = :idTrabajador) " +
            "AND t.estado = 'En atención'")
    Optional<List<TicketAsignadoDTO>> buscarTicketsTrabajador(int idTrabajador);


    @Query("SELECT t.id_ticket, t.id_reporte_incidente, t.estado, ri.id_cliente, ri.nombre_incidente, ri.descripcion, ri.nivel, ri.fecha " +
            "FROM ticket t " +
            "INNER JOIN reporte_incidente ri " +
            "ON t.id_reporte_incidente = ri.id_reporte_incidente " +
            "WHERE t.id_ticket = :idTicket")
    TicketAsignadoDTO buscarTicketPorID(int idTicket);

    @Modifying
    @Query("UPDATE ticket SET estado = :estado  WHERE id_ticket = :idTicket")
    void actualizarEstadoTicket(String estado, int idTicket);

    @Query("SELECT * FROM ticket WHERE id_reporte_incidente = :idReporteIncidente")
    Optional<Ticket> buscarTicketPorIDReporteIncidente(int idReporteIncidente);
}

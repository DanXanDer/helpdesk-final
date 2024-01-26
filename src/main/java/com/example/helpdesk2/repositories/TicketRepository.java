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

    @Query("SELECT t.id_ticket, t.id_trabajador, t.id_reporte_incidente, t.estado, t.fecha as ticket_fecha, a.nombre_area, s.nombre_sede, e.nombre_empresa, " +
            "c.id_cliente, u_cliente.nombres as nombres_cliente, u_cliente.apellidos as apellidos_cliente, " +
            "u_trabajador.nombres as nombres_trabajador, u_trabajador.apellidos as apellidos_trabajador, " +
            "ri.nombre_incidente, ri.descripcion, ri.fecha as reporte_fecha " +
            "FROM ticket t " +
            "INNER JOIN reporte_incidente ri ON t.id_reporte_incidente = ri.id_reporte_incidente " +
            "INNER JOIN cliente c ON ri.id_cliente = c.id_cliente " +
            "INNER JOIN usuario u_cliente ON c.id_usuario = u_cliente.id_usuario " +
            "INNER JOIN area a ON c.id_area = a.id_area " +
            "INNER JOIN sede s ON a.id_sede = s.id_sede " +
            "INNER JOIN empresa e ON s.id_empresa = e.id_empresa " +
            "LEFT JOIN trabajador tbd ON t.id_trabajador = tbd.id_trabajador " +
            "LEFT JOIN usuario u_trabajador ON tbd.id_usuario = u_trabajador.id_usuario")
    List<TicketAsignadoDTO> buscarTickets();


    @Query("SELECT t.id_ticket, t.id_trabajador, t.id_reporte_incidente, t.estado, t.fecha as ticket_fecha, a.nombre_area, s.nombre_sede, e.nombre_empresa, " +
            "c.id_cliente, u_cliente.nombres as nombres_cliente, u_cliente.apellidos as apellidos_cliente, " +
            "u_trabajador.nombres as nombres_trabajador, u_trabajador.apellidos as apellidos_trabajador, " +
            "ri.nombre_incidente, ri.descripcion, ri.fecha as reporte_fecha " +
            "FROM ticket t " +
            "INNER JOIN reporte_incidente ri ON t.id_reporte_incidente = ri.id_reporte_incidente " +
            "INNER JOIN cliente c ON ri.id_cliente = c.id_cliente " +
            "INNER JOIN usuario u_cliente ON c.id_usuario = u_cliente.id_usuario " +
            "INNER JOIN area a ON c.id_area = a.id_area " +
            "INNER JOIN sede s ON a.id_sede = s.id_sede " +
            "INNER JOIN empresa e ON s.id_empresa = e.id_empresa " +
            "LEFT JOIN trabajador tbd ON t.id_trabajador = tbd.id_trabajador " +
            "LEFT JOIN usuario u_trabajador ON tbd.id_usuario = u_trabajador.id_usuario " +
            "WHERE t.id_trabajador = :idTrabajador")
    List<TicketAsignadoDTO> buscarTicketsTrabajador(int idTrabajador);

    @Query("SELECT t.id_ticket, t.id_reporte_incidente, t.estado, ri.id_cliente, ri.nombre_incidente, ri.descripcion, ri.fecha " +
            "FROM ticket t " +
            "INNER JOIN reporte_incidente ri " +
            "ON t.id_reporte_incidente = ri.id_reporte_incidente " +
            "WHERE t.id_ticket = :idTicket")
    TicketAsignadoDTO buscarTicketPorID(int idTicket);

    @Modifying
    @Query("UPDATE ticket SET estado = :estado  WHERE id_ticket = :idTicket")
    void actualizarEstadoTicket(String estado, int idTicket);

    @Query("SELECT * FROM ticket WHERE id_reporte_incidente = :idReporteIncidente AND estado != 'No conforme'")
    Optional<Ticket> buscarTicketPorIDReporteIncidente(int idReporteIncidente);
}

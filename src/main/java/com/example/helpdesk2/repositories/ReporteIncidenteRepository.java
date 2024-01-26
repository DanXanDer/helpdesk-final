package com.example.helpdesk2.repositories;

import com.example.helpdesk2.models.ReporteIncidente;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReporteIncidenteRepository extends CrudRepository<ReporteIncidente, Integer> {
    @Modifying
    @Query("INSERT INTO reporte_incidente (id_cliente, nombre_incidente, descripcion) VALUES (:idCliente, :nombreIncidente, :descripcion)")
    void guardarReporteIncidente(int idCliente, String nombreIncidente, String descripcion);

    @Query("SELECT LAST_INSERT_ID()")
    int obtenerUltimoIDReporteIncidente();

    @Query("SELECT ri.id_reporte_incidente, ri.id_cliente, ri.nombre_incidente, " +
            "ri.descripcion, ri.estado, ri.fecha, " +
            "u.nombres, u.apellidos, " +
            "a.nombre_area, s.nombre_sede, e.nombre_empresa " +
            "FROM reporte_incidente ri " +
            "INNER JOIN cliente c ON ri.id_cliente = c.id_cliente " +
            "INNER JOIN usuario u ON c.id_usuario = u.id_usuario " +
            "INNER JOIN area a ON c.id_area = a.id_area " +
            "INNER JOIN sede s ON a.id_sede = s.id_sede " +
            "INNER JOIN empresa e ON s.id_empresa = e.id_empresa " +
            "WHERE ri.estado = 'En espera'")
    List<ReporteIncidente> buscarReportesIncidentes();

    @Query("SELECT * FROM reporte_incidente WHERE id_reporte_incidente = :idReporteIncidente")
    ReporteIncidente buscarReporteIncidente(int idReporteIncidente);

    @Modifying
    @Query("UPDATE reporte_incidente SET estado = :estado WHERE id_reporte_incidente = :idReporteIncidente")
    void actualizarEstadoReporteIncidente(int idReporteIncidente, String estado);

    @Query("SELECT * FROM reporte_incidente WHERE id_cliente = :idCliente")
    List<ReporteIncidente> buscarReportesIncidentesCliente(int idCliente);
}

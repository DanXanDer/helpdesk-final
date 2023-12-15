package com.example.helpdesk2.repositories;

import com.example.helpdesk2.DTO.CambiarClaveClienteDTO;
import com.example.helpdesk2.DTO.EscogerTicketDTO;
import com.example.helpdesk2.DTO.ReestablecerClaveDTO;
import com.example.helpdesk2.DTO.ValidarDatosUsuarioDTO;
import com.example.helpdesk2.models.ReporteIncidente;
import com.example.helpdesk2.models.Usuario;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ReporteIncidenteRepository extends CrudRepository<ReporteIncidente, Integer> {
    @Modifying
    @Query("INSERT INTO reporte_incidente (id_cliente, nombre_incidente, descripcion) VALUES (:idCliente, :nombreIncidente, :descripcion)")
    void guardarReporteIncidente(int idCliente, String nombreIncidente, String descripcion);

    @Query("SELECT LAST_INSERT_ID()")
    int obtenerUltimoIDReporteIncidente();

    @Query("SELECT * FROM reporte_incidente WHERE estado = 'En espera'")
    Optional<List<ReporteIncidente>> buscarReportesIncidentes();

    @Query("SELECT * FROM reporte_incidente WHERE id_reporte_incidente = :idReporteIncidente")
    ReporteIncidente buscarReporteIncidente(int idReporteIncidente);

    @Modifying
    @Query("UPDATE reporte_incidente SET estado = :estado WHERE id_reporte_incidente = :idReporteIncidente")
    void actualizarEstadoReporteIncidente(int idReporteIncidente, String estado);

    @Query("SELECT * FROM reporte_incidente WHERE id_cliente = :idCliente")
    List<ReporteIncidente> buscarReportesIncidentesCliente(int idCliente);
}

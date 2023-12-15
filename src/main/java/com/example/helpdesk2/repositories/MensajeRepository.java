package com.example.helpdesk2.repositories;

import com.example.helpdesk2.DTO.RegistrarMensajeTicketDTO;
import com.example.helpdesk2.models.Mensaje;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MensajeRepository extends CrudRepository<Mensaje, Integer> {

    @Modifying
    @Query("INSERT INTO mensaje (emisor, receptor, mensaje) " +
            "VALUES (:#{#registrarMensajeTicketDTO.emisor}, :#{#registrarMensajeTicketDTO.receptor}, :#{#registrarMensajeTicketDTO.mensaje})")
    void guardarMensaje(RegistrarMensajeTicketDTO registrarMensajeTicketDTO);

    @Query("SELECT LAST_INSERT_ID()")
    int obtenerUltimoIdInsertado();

    @Query("SELECT m.emisor, m.receptor, m.mensaje, m.fecha, m.id_mensaje " +
            "FROM mensaje m " +
            "INNER JOIN mensaje_ticket mt " +
            "ON m.id_mensaje = mt.id_mensaje " +
            "WHERE mt.id_ticket = :idTicket")
    List<Mensaje> buscarMensajesTicket(int idTicket);
}

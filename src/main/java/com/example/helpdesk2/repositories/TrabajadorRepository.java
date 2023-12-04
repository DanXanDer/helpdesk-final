package com.example.helpdesk2.repositories;

import com.example.helpdesk2.DTO.RegistrarTrabajadorDTO;
import com.example.helpdesk2.models.Trabajador;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

public interface TrabajadorRepository extends CrudRepository<Trabajador, Integer> {

    @Modifying
    @Query("INSERT INTO trabajador (id_usuario, nivel) VALUES " +
            "(:#{#registrarTrabajadorDTO.idUsuario}, " +
            ":#{#registrarTrabajadorDTO.nivel})")
    void registrarTrabajador(RegistrarTrabajadorDTO registrarTrabajadorDTO);

    @Query("SELECT * FROM trabajador WHERE id_usuario = :idUsuario")
    Trabajador buscarTrabajadorPorIdUsuario(int idUsuario);
}

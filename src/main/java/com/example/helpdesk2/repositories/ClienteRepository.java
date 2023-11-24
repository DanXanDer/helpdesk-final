package com.example.helpdesk2.repositories;

import com.example.helpdesk2.DTO.RegistrarClienteDTO;
import com.example.helpdesk2.models.Cliente;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Integer> {

    @Modifying
    @Query("INSERT INTO cliente (id_usuario, id_area, anydesk, teamviewer) VALUES " +
            "(:#{#registrarClienteDTO.idUsuario}, " +
            ":#{#registrarClienteDTO.idArea}, " +
            ":#{#registrarClienteDTO.anydesk}, " +
            ":#{#registrarClienteDTO.teamviewer})")
    void registrarCliente(RegistrarClienteDTO registrarClienteDTO);
}

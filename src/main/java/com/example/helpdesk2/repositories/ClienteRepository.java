package com.example.helpdesk2.repositories;

import com.example.helpdesk2.DTO.ActualizarDatosClienteDTO;
import com.example.helpdesk2.DTO.CambiarClaveClienteDTO;
import com.example.helpdesk2.DTO.ReestablecerClaveDTO;
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

    @Query("SELECT id_cliente, anydesk, teamviewer FROM cliente WHERE id_usuario = :idUsuario")
    Cliente buscarClientePorIdUsuario(int idUsuario);

    @Modifying
    @Query("UPDATE cliente SET " +
            "anydesk = :#{#actualizarDatosClienteDTO.anydesk}, " +
            "teamviewer = :#{#actualizarDatosClienteDTO.teamviewer} " +
            "WHERE id_cliente =:idCliente")
    void actualizarDatosCliente(ActualizarDatosClienteDTO actualizarDatosClienteDTO, int idCliente);

    @Modifying
    @Query("UPDATE usuario SET clave = :#{#cambiarClaveClienteDTO.clave} WHERE id_usuario = :idUsuario")
    void actualizarClave(CambiarClaveClienteDTO cambiarClaveClienteDTO, int idUsuario);

}

package com.example.helpdesk2.repositories;

import com.example.helpdesk2.models.Privilegio;
import com.example.helpdesk2.DTO.PrivilegiosUsuarioDTO;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PrivilegioRepository extends CrudRepository<Privilegio, Integer> {

    @Query("SELECT * from usuario_privilegio WHERE id_usuario = :idUsuario")
    List<Privilegio> buscarPrivilegiosDeUsuario(int idUsuario);

    @Query("SELECT * from privilegio")
    List<Privilegio> buscarTodosPrivilegios();

    @Modifying
    @Query("INSERT INTO usuario_privilegio (id_privilegio, id_usuario) VALUES (:#{#idPrivilegio}, :#{#idUsuario})")
    void registrarPrivilegioUsuario(int idUsuario, int idPrivilegio);

}

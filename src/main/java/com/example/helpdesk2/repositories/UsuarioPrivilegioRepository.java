package com.example.helpdesk2.repositories;

import com.example.helpdesk2.models.UsuarioPrivilegio;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsuarioPrivilegioRepository extends CrudRepository<UsuarioPrivilegio, Integer> {

    @Query("SELECT * from usuario_privilegio WHERE id_usuario = :idUsuario")
    List<UsuarioPrivilegio> buscarPrivilegiosDeUsuario(int idUsuario);
}

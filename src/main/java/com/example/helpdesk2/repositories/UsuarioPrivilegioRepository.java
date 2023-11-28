package com.example.helpdesk2.repositories;

import com.example.helpdesk2.models.Privilegio;
import com.example.helpdesk2.models.UsuarioPrivilegio;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsuarioPrivilegioRepository extends CrudRepository<UsuarioPrivilegio, Integer> {


    @Modifying
    @Query("INSERT INTO usuario_privilegio (id_privilegio, id_usuario) VALUES (:#{#idPrivilegio}, :#{#idUsuario})")
    void registrarPrivilegioUsuario(int idUsuario, int idPrivilegio);


}

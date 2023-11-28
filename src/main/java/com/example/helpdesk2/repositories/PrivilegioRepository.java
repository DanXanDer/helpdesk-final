package com.example.helpdesk2.repositories;

import com.example.helpdesk2.models.Privilegio;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PrivilegioRepository extends CrudRepository<Privilegio, Integer> {

    @Query("SELECT * from privilegio")
    List<Privilegio> buscarTodosPrivilegios();

    @Query("SELECT p.* FROM privilegio p " +
            "JOIN usuario_privilegio up ON p.id_privilegio = up.id_privilegio " +
            "JOIN usuario u ON up.id_usuario = u.id_usuario " +
            "WHERE u.id_usuario = :idUsuario" )
    List<Privilegio> buscarPrivilegiosDeUsuario(int idUsuario);

}

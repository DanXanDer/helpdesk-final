package com.example.helpdesk2.moduloSeguridad.repositories;

import com.example.helpdesk2.models.Usuario;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

    @Query("SELECT * FROM usuario WHERE nombre_usuario = :nombreUsuario AND clave = :clave AND estado = 1")
    Optional<Usuario> buscarUsuarioPorCredenciales(String nombreUsuario, String clave);

    @Query("UPDATE usuario SET clave, pregunta_seguridad, rpta_secreta WHERE id_usuario = :idUsuario")
    void completarDatosUsuario(int idUsuario, String clave, int preguntaSeguridad, String rptaSecreta);
}

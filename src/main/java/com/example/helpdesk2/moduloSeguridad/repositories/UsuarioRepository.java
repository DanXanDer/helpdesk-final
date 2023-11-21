package com.example.helpdesk2.moduloSeguridad.repositories;

import com.example.helpdesk2.models.Usuario;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

    @Query("SELECT * FROM usuario WHERE nombre_usuario = :nombreUsuario AND clave = :clave AND estado = 1")
    Optional<Usuario> buscarUsuarioPorCredenciales(String nombreUsuario, String clave);

    @Query("UPDATE usuario SET primer_login = 0, clave = :clave, id_pregunta_seguridad = :preguntaSeguridad, rpta_secreta = :rptaSecreta WHERE id_usuario = :idUsuario")
    @Modifying
    void completarDatosUsuario(int idUsuario, String clave, int preguntaSeguridad, String rptaSecreta);

    @Query("SELECT * FROM usuario WHERE nombre_usuario = :nombreUsuario AND nombres = :nombres AND apellidos = :apellidos AND estado = 1")
    Optional<Usuario> buscarUsuarioPorDatos(String nombreUsuario, String nombres, String apellidos);

    @Query("SELECT nombre_pregunta_seguridad FROM pregunta_seguridad WHERE id_pregunta_seguridad = :idPreguntaSeguridad")
    String buscarPreguntaSeguridad(int idPreguntaSeguridad);

    @Query("SELECT rpta_secreta FROM usuario WHERE id_usuario = :idUsuario")
    String buscarRptaSecreta(int idUsuario);

    @Query("UPDATE usuario SET clave = :clave WHERE id_usuario = :idUsuario")
    @Modifying
    void reestablecerClave(int idUsuario, String clave);

}

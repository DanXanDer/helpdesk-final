package com.example.helpdesk2.repositories;

import com.example.helpdesk2.DTO.*;
import com.example.helpdesk2.models.Usuario;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {


    @Query("SELECT u.id_usuario, u.nombre_usuario, u.nombres, u.apellidos FROM usuario u WHERE " +
            "nombre_usuario = :#{#checkPrimerLoginDTO.nombreUsuario} AND " +
            "clave = :#{#checkPrimerLoginDTO.clave} " +
            "AND estado = 1")
    Optional<Usuario> buscarUsuarioPorCredenciales(CheckPrimerLoginDTO checkPrimerLoginDTO);

    @Modifying
    @Query("UPDATE usuario SET " +
            "primer_login = 0, " +
            "clave = :#{#completarDatosDTO.clave}, " +
            "id_pregunta_seguridad = :#{#completarDatosDTO.preguntaSeguridad}, " +
            "rpta_secreta = :#{#completarDatosDTO.rptaSecreta} " +
            "WHERE id_usuario = :#{#completarDatosDTO.idUsuario}")
    void completarDatosUsuario(CompletarDatosDTO completarDatosDTO);

    @Query("SELECT u.id_usuario, u.id_pregunta_seguridad FROM usuario u WHERE " +
            "nombre_usuario = :#{#validarDatosUsuarioDTO.nombreUsuario} AND " +
            "nombres = :#{#validarDatosUsuarioDTO.nombres} AND " +
            "apellidos = :#{#validarDatosUsuarioDTO.apellidos} AND " +
            "estado = 1 AND " +
            "primer_login = 0")
    Optional<Usuario> buscarUsuarioPorDatos(ValidarDatosUsuarioDTO validarDatosUsuarioDTO);

    @Query("SELECT nombre_pregunta_seguridad FROM pregunta_seguridad WHERE id_pregunta_seguridad = :idPreguntaSeguridad")
    String buscarPreguntaSeguridad(int idPreguntaSeguridad);

    @Query("SELECT rpta_secreta FROM usuario WHERE id_usuario = :#{#validarRptaSecretaDTO.idUsuario}")
    String buscarRptaSecreta(ValidarRptaSecretaDTO validarRptaSecretaDTO);

    @Modifying
    @Query("UPDATE usuario SET clave = :#{#reestablecerClaveDTO.clave} WHERE id_usuario = :#{#reestablecerClaveDTO.idUsuario}")
    void reestablecerClave(ReestablecerClaveDTO reestablecerClaveDTO);

    @Query("SELECT u.nombre_usuario, u.nombres, u.apellidos, u.correo, u.tipo, u.estado " +
            "FROM usuario u")
    Optional<List<Usuario>> buscarTodosLosUsuarios();

    @Query("SELECT u.id_usuario, u.nombre_usuario, u.nombres, u.apellidos FROM usuario u WHERE " +
            "(:filtro = 'nombre_usuario' AND u.nombre_usuario LIKE CONCAT(:valor, '%')) OR " +
            "(:filtro = 'nombres' AND u.nombres LIKE CONCAT(:valor, '%')) OR " +
            "(:filtro = 'apellidos' AND u.apellidos LIKE CONCAT(:valor, '%')) OR " +
            "(:filtro = 'tipo' AND u.tipo = :valor)")
    Optional<List<Usuario>> buscarUsuariosPorFiltro(String filtro, String valor);

    @Modifying
    @Query("UPDATE usuario SET estado = :#{#cambiarEstadoUsuarioDTO.estado} WHERE id_usuario = :#{#cambiarEstadoUsuarioDTO.idUsuario}")
    void cambiarEstadoUsuario(CambiarEstadoUsuarioDTO cambiarEstadoUsuarioDTO);

    @Query("SELECT u.nombre_usuario FROM usuario u WHERE nombre_usuario = :#{#registrarUsuarioDTO.nombreUsuario}")
    Optional<String> buscarNombreUsuarioExistente(RegistrarUsuarioDTO registrarUsuarioDTO);

    @Modifying
    @Query("INSERT INTO usuario (nombre_usuario, clave, nombres, apellidos, correo, tipo) " +
            "VALUES (:#{#registrarUsuarioDTO.nombreUsuario}, " +
            ":#{#registrarUsuarioDTO.clave}, " +
            ":#{#registrarUsuarioDTO.nombres}, " +
            ":#{#registrarUsuarioDTO.apellidos}, " +
            ":#{#registrarUsuarioDTO.correo}, " +
            ":#{#registrarUsuarioDTO.tipo})")
    void registrarUsuario(RegistrarUsuarioDTO registrarUsuarioDTO);

    @Query("SELECT LAST_INSERT_ID()")
    int obtenerUltimoIdUsuario();


}

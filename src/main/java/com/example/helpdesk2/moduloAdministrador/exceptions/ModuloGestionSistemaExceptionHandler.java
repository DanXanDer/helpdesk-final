package com.example.helpdesk2.moduloAdministrador.exceptions;

import com.example.helpdesk2.exceptions.ErrorDetalles;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ModuloGestionSistemaExceptionHandler {

    @ExceptionHandler(UsuariosNoEncontradosException.class)
    public ResponseEntity<Map<String, Object>> handleUsuariosNoEncontradosException(){
        ErrorDetalles errorDetalles = new ErrorDetalles();
        errorDetalles.setMensaje("No se encontraron usuarios");
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("ok", false);
        respuesta.put("error", errorDetalles);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(respuesta);
    }

    @ExceptionHandler(NombreUsuarioExisteException.class)
    public ResponseEntity<Map<String, Object>> handleNombreUsuarioExisteException(){
        ErrorDetalles errorDetalles = new ErrorDetalles();
        errorDetalles.setMensaje("El nombre de usuario ya existe. Intente con otro");
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("ok", false);
        respuesta.put("error", errorDetalles);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(respuesta);
    }

    @ExceptionHandler(CorreoUsuarioExisteException.class)
    public ResponseEntity<Map<String, Object>> handleCorreUsuarioExisteException(){
        ErrorDetalles errorDetalles = new ErrorDetalles();
        errorDetalles.setMensaje("El correo ya existe");
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("ok", false);
        respuesta.put("error", errorDetalles);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(respuesta);
    }

    @ExceptionHandler(NombreEmpresaExisteException.class)
    public ResponseEntity<Map<String, Object>> handleNombreEmpresaExisteException(){
        ErrorDetalles errorDetalles = new ErrorDetalles();
        errorDetalles.setMensaje("El nombre de la empresa ya existe");
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("ok", false);
        respuesta.put("error", errorDetalles);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(respuesta);
    }

}

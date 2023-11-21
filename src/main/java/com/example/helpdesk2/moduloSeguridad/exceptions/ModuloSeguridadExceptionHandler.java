package com.example.helpdesk2.moduloSeguridad.exceptions;

import com.example.helpdesk2.exceptions.ErrorDetalles;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ModuloSeguridadExceptionHandler {

    @ExceptionHandler(UsuarioNoEncontrado.class)
    public ResponseEntity<Map<String, Object>> exceptionUsuarioNoEncontrado(){
        ErrorDetalles errorDetalles = new ErrorDetalles();
        errorDetalles.setMensaje("El usuario no existe o se encuentra deshabilitado");
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("ok", false);
        respuesta.put("error", errorDetalles);
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(respuesta);
    }

    @ExceptionHandler(ClavesNoCoinciden.class)
    public ResponseEntity<Map<String, Object>> exceptionClavesNoCoinciden(){
        ErrorDetalles errorDetalles = new ErrorDetalles();
        errorDetalles.setMensaje("Las claves no coinciden");
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("ok", false);
        respuesta.put("error", errorDetalles);
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(respuesta);
    }

    @ExceptionHandler(RespuestaSecretaIncorrecta.class)
    public ResponseEntity<Map<String, Object>> exceptionRespuestaSecretaIncorrecta(){
        ErrorDetalles errorDetalles = new ErrorDetalles();
        errorDetalles.setMensaje("La respuesta secreta es incorrecta");
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("ok", false);
        respuesta.put("error", errorDetalles);
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(respuesta);
    }

}

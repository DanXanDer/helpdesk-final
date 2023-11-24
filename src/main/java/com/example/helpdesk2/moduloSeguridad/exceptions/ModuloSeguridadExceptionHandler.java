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

    @ExceptionHandler(UsuarioNoEncontradoException.class)
    public ResponseEntity<Map<String, Object>> handleUsuarioNoEncontrado(){
        ErrorDetalles errorDetalles = new ErrorDetalles();
        errorDetalles.setMensaje("El usuario no existe o se encuentra deshabilitado");
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("ok", false);
        respuesta.put("error", errorDetalles);
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(respuesta);
    }

    @ExceptionHandler(ClavesNoCoincidenException.class)
    public ResponseEntity<Map<String, Object>> handleClavesNoCoinciden(){
        ErrorDetalles errorDetalles = new ErrorDetalles();
        errorDetalles.setMensaje("Las claves no coinciden");
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("ok", false);
        respuesta.put("error", errorDetalles);
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(respuesta);
    }

    @ExceptionHandler(RespuestaSecretaIncorrectaException.class)
    public ResponseEntity<Map<String, Object>> handleRespuestaSecretaIncorrecta(){
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

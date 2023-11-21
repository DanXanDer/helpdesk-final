package com.example.helpdesk2.moduloGestionSistema.exceptions;

import com.example.helpdesk2.exceptions.ErrorDetalles;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ModuloGestionSistemaExceptionHandler {

    @ExceptionHandler(UsuariosNoEncontrados.class)
    public ResponseEntity<Map<String, Object>> exceptionUsuariosNoEncontrados(){
        ErrorDetalles errorDetalles = new ErrorDetalles();
        errorDetalles.setMensaje("No se encontraron usuarios");
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("ok", false);
        respuesta.put("error", errorDetalles);
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(respuesta);
    }
}

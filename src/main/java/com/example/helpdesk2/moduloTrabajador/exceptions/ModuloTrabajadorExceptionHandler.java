package com.example.helpdesk2.moduloTrabajador.exceptions;

import com.example.helpdesk2.exceptions.ErrorDetalles;
import com.example.helpdesk2.moduloGestionSistema.exceptions.UsuariosNoEncontradosException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ModuloTrabajadorExceptionHandler {

    @ExceptionHandler(ReporteNoEncontradoException.class)
    public ResponseEntity<Map<String, Object>> handleReporteNoEncontrado(){
        ErrorDetalles errorDetalles = new ErrorDetalles();
        errorDetalles.setMensaje("No se encontró reporte");
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("ok", false);
        respuesta.put("error", errorDetalles);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(respuesta);
    }
}

package com.example.helpdesk2.moduloCliente.exceptions;

import com.example.helpdesk2.exceptions.ErrorDetalles;
import org.apache.tomcat.util.http.fileupload.impl.FileSizeLimitExceededException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ModuloClienteExceptionHandler {

    @ExceptionHandler(FileSizeLimitExceededException.class)
    public ResponseEntity<Map<String, Object>> handleFileSizeLimitExceed(){
        ErrorDetalles errorDetalles = new ErrorDetalles();
        errorDetalles.setMensaje("Los archivos exceden el tamaño máximo permitido de 10MB");
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("ok", false);
        respuesta.put("error", errorDetalles);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(respuesta);
    }
}

package com.example.helpdesk2.moduloSeguridad.exceptions;

import com.example.helpdesk2.exceptions.ErrorDetalles;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(UsuarioNoEncontrado.class)
    public ResponseEntity<ErrorDetalles> exceptionUsuarioNoEncontrado(){
        ErrorDetalles errorDetalles = new ErrorDetalles();
        errorDetalles.setMensaje("El usuario no existe o se encuentra deshabilitado");
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(errorDetalles);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(ClavesNoCoinciden.class)
    public ResponseEntity<ErrorDetalles> exceptionClavesNoCoinciden(){
        ErrorDetalles errorDetalles = new ErrorDetalles();
        errorDetalles.setMensaje("Las claves no coinciden");
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(errorDetalles);
    }

}

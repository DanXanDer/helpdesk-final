package com.example.helpdesk2.exceptions;

import com.example.helpdesk2.moduloSeguridad.exceptions.UsuarioNoEncontrado;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    /*@ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorDetalles> exceptionEndPointNoEncontrado(){
        ErrorDetalles errorDetalles = new ErrorDetalles();
        errorDetalles.setMensaje("El recurso no existe");
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(errorDetalles);
    }*/

    @ExceptionHandler(UsuarioNoEncontrado.class)
    public ResponseEntity<ErrorDetalles> exceptionUsuarioNoEncontrado(){
        ErrorDetalles errorDetalles = new ErrorDetalles();
        errorDetalles.setMensaje("El usuario no existe o se encuentra deshabilitado");
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(errorDetalles);
    }
}

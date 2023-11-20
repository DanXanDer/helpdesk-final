package com.example.helpdesk2.exceptions;

import com.example.helpdesk2.moduloSeguridad.exceptions.ClavesNoCoinciden;
import com.example.helpdesk2.moduloSeguridad.exceptions.UsuarioNoEncontrado;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    /*@ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorDetalles> exceptionEndPointNoEncontrado(){
        ErrorDetalles errorDetalles = new ErrorDetalles();
        errorDetalles.setMensaje("El recurso no existe");
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body
                (errorDetalles);
    }*/

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, Map> exceptionValidacionesInvalidas(MethodArgumentNotValidException e){
        Map<String, String> listaErrores = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach(error -> {
            String campo = ((FieldError) error).getField();
            String errorMensaje = error.getDefaultMessage();
            listaErrores.put(campo, errorMensaje);
        });
        Map<String, Map> errores = new HashMap<>();
        errores.put("errores", listaErrores);
        return errores;
    }


}

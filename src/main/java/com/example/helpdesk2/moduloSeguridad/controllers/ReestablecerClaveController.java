package com.example.helpdesk2.moduloSeguridad.controllers;

import com.example.helpdesk2.moduloSeguridad.DTO.ValidarDatosUsuarioRequest;
import com.example.helpdesk2.moduloSeguridad.services.ReestablecerClaveService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ReestablecerClaveController {

    private final ReestablecerClaveService reestablecerClaveService;

    public ReestablecerClaveController(ReestablecerClaveService reestablecerClaveService) {
        this.reestablecerClaveService = reestablecerClaveService;
    }

    @PostMapping("/validarDatosUsuario")
    public ResponseEntity<Map<String, Object>> validarDatosUsuario(@Valid @RequestBody ValidarDatosUsuarioRequest validarDatosUsuarioRequest){
        int idUsuario = reestablecerClaveService.validarUsuarioPorDatos(
                validarDatosUsuarioRequest.getNombreUsuario(),
                validarDatosUsuarioRequest.getNombres(),
                validarDatosUsuarioRequest.getApellidos()
        );
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("ok", true);
        respuesta.put("idUsuario", idUsuario);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(respuesta);
    }
}

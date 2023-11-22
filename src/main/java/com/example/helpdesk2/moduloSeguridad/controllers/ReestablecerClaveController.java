package com.example.helpdesk2.moduloSeguridad.controllers;

import com.example.helpdesk2.models.Usuario;
import com.example.helpdesk2.DTO.ReestablecerClaveDTO;
import com.example.helpdesk2.DTO.ValidarDatosUsuarioDTO;
import com.example.helpdesk2.DTO.ValidarRptaSecretaDTO;
import com.example.helpdesk2.moduloSeguridad.services.ReestablecerClaveService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/seguridad")
public class ReestablecerClaveController {

    private final ReestablecerClaveService reestablecerClaveService;

    public ReestablecerClaveController(ReestablecerClaveService reestablecerClaveService) {
        this.reestablecerClaveService = reestablecerClaveService;
    }

    @PostMapping("/validar-datos-usuario")
    public ResponseEntity<Map<String, Object>> validarDatosUsuario(@Valid @RequestBody ValidarDatosUsuarioDTO validarDatosUsuarioDTO){
        Usuario usuario = reestablecerClaveService.validarUsuarioPorDatos(validarDatosUsuarioDTO);
        String preguntaSeguridad = reestablecerClaveService.obtenerPreguntaSeguridad(usuario.getIdPreguntaSeguridad());
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("ok", true);
        respuesta.put("idUsuario", usuario.getIdUsuario());
        respuesta.put("preguntaSeguridad", preguntaSeguridad);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(respuesta);
    }

    @PostMapping("/validar-rpta-secreta")
    public ResponseEntity<Map<String, Object>> validarRptaSecreta(@Valid @RequestBody ValidarRptaSecretaDTO validarRptaSecretaDTO){
        reestablecerClaveService.validarRespuestaSecreta(validarRptaSecretaDTO);
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("ok", true);
        respuesta.put("idUsuario", validarRptaSecretaDTO.getIdUsuario());
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(respuesta);
    }

    @PostMapping("/reestablecer-clave")
    public ResponseEntity<Map<String, Object>> reestablecerClave(@Valid @RequestBody ReestablecerClaveDTO reestablecerClaveDTO){
        reestablecerClaveService.reestablecerClave(reestablecerClaveDTO);
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("ok", true);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(respuesta);
    }

}

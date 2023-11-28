package com.example.helpdesk2.moduloSeguridad.controllers;

import com.example.helpdesk2.models.Usuario;
import com.example.helpdesk2.DTO.CompletarDatosDTO;
import com.example.helpdesk2.DTO.LogearUsuarioDTO;
import com.example.helpdesk2.DTO.CheckPrimerLoginDTO;
import com.example.helpdesk2.models.Privilegio;
import com.example.helpdesk2.moduloSeguridad.services.AutenticacionService;
import com.example.helpdesk2.services.LoggedUserManagamentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap; 
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/seguridad")
public class AutenticacionController {

    private final AutenticacionService autenticacionService;
    private final LoggedUserManagamentService loggedUserManagamentService;

    public AutenticacionController(AutenticacionService autenticacionService, LoggedUserManagamentService loggedUserManagamentService) {
        this.autenticacionService = autenticacionService;
        this.loggedUserManagamentService = loggedUserManagamentService;
    }

    @PostMapping("/check-primer-login")
    public ResponseEntity<Map<String, Object>> checkPrimerLogin(@Valid @RequestBody CheckPrimerLoginDTO checkPrimerLoginDTO) {
        Usuario usuario = autenticacionService.checkUsuarioPrimerLogin(checkPrimerLoginDTO);
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("ok", true);
        respuesta.put("idUsuario", usuario.getIdUsuario());
        respuesta.put("primerLogin", usuario.isPrimerLogin());
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(respuesta);
    }

    @PostMapping("/logear-usuario")
    public ResponseEntity<Map<String, Object>> logearUsuario(@RequestBody LogearUsuarioDTO logearUsuarioDTO) {
        autenticacionService.autenticarUsuario(logearUsuarioDTO);
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("ok", true);
        respuesta.put("idUsuario", loggedUserManagamentService.getIdUsuario());
        respuesta.put("nombreUsuario", loggedUserManagamentService.getNombreUsuario());
        respuesta.put("nombres", loggedUserManagamentService.getNombres());
        respuesta.put("apellidos", loggedUserManagamentService.getApellidos());
        respuesta.put("privilegios", loggedUserManagamentService.getPrivilegios());
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(respuesta);
    }

    @GetMapping("/preguntas-seguridad")
    public ResponseEntity<Map<String, Object>> obtenerPreguntasSeguridad() {
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("ok", true);
        respuesta.put("preguntasSeguridad", autenticacionService.obtenerPreguntasSeguridad());
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(respuesta);
    }

    @PostMapping("/completar-datos")
    public ResponseEntity<Map<String, Object>> completarDatos(@Valid @RequestBody CompletarDatosDTO completarDatosDTO) {
        autenticacionService.completarDatosUsuario(completarDatosDTO);
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("ok", true);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(respuesta);
    }

}

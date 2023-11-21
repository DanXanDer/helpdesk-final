package com.example.helpdesk2.moduloGestionSistema.controllers;

import com.example.helpdesk2.models.Usuario;
import com.example.helpdesk2.moduloGestionSistema.services.GestionarUsuariosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/gestion-sistema")
public class GestionarUsuariosController {

    private final GestionarUsuariosService gestionarUsuariosService;

    public GestionarUsuariosController(GestionarUsuariosService gestionarUsuariosService) {
        this.gestionarUsuariosService = gestionarUsuariosService;
    }

    @GetMapping("/usuarios")
    public ResponseEntity<Map<String, Object>> obtenerUsuarios(
            @RequestParam(required = false) String filtro,
            @RequestParam(required = false) String valor){
        List<Usuario> usuarios;
        usuarios = gestionarUsuariosService.obtenerUsuarios(filtro, valor);
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("ok", true);
        respuesta.put("usuarios", usuarios);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(respuesta);
    }


}

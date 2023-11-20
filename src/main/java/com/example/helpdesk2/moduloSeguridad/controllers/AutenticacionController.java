package com.example.helpdesk2.moduloSeguridad.controllers;

import com.example.helpdesk2.models.Usuario;
import com.example.helpdesk2.moduloSeguridad.DTO.CompletarDatosRequest;
import com.example.helpdesk2.moduloSeguridad.DTO.UsuarioIDRequest;
import com.example.helpdesk2.moduloSeguridad.DTO.UsuarioRequest;
import com.example.helpdesk2.models.UsuarioPrivilegio;
import com.example.helpdesk2.moduloSeguridad.services.AutenticacionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
public class AutenticacionController {

    private final AutenticacionService autenticacionService;

    public AutenticacionController(AutenticacionService autenticacionService) {
        this.autenticacionService = autenticacionService;
    }

    @PostMapping("/checkPrimerLogin")
    public ResponseEntity<Map<String, Object>> checkPrimerLogin(@RequestBody UsuarioRequest usuarioRequest){
        Usuario usuario = autenticacionService.checkUsuarioPrimerLogin(
                usuarioRequest.getNombreUsuario(),
                usuarioRequest.getClave()
        );
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("idUsuario", usuario.getIdUsuario());
        respuesta.put("primerLogin", usuario.isPrimerLogin());
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(respuesta);
    }

    @PostMapping("/bienvenida")
    public ResponseEntity<List<UsuarioPrivilegio>> bienvenida(@RequestBody UsuarioIDRequest usuarioIDRequest){
        List<UsuarioPrivilegio> usuarioPrivilegios = autenticacionService.obtenerPrivilegiosUsuario(usuarioIDRequest.getIdUsuario());
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(usuarioPrivilegios);
    }

    @PostMapping("/completarDatos")
    public ResponseEntity<Map<String, Object>> completarDatos(@RequestBody CompletarDatosRequest completarDatosRequest){
        autenticacionService.completarDatosUsuario(
                completarDatosRequest.getIdUsuario(),
                completarDatosRequest.getClave(),
                completarDatosRequest.getNuevaClave(),
                completarDatosRequest.getPreguntaSeguridad(),
                completarDatosRequest.getRptaSecreta()
        );
        Map<String, Object> mensaje = new HashMap<>();
        mensaje.put("mensaje", "Datos completados correctamente");
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(mensaje);
    }

}

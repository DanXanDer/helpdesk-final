package com.example.helpdesk2.moduloCliente.controllers;

import com.example.helpdesk2.DTO.ActualizarDatosClienteDTO;
import com.example.helpdesk2.DTO.CambiarClaveClienteDTO;
import com.example.helpdesk2.models.Cliente;
import com.example.helpdesk2.moduloCliente.services.ActualizarInformacionService;
import com.example.helpdesk2.services.LoggedUserManagamentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/modulo-cliente")
public class ActualizarInformacionController {

    private final ActualizarInformacionService actualizarInformacionService;
    private final LoggedUserManagamentService loggedUserManagamentService;

    public ActualizarInformacionController(ActualizarInformacionService actualizarInformacionService, LoggedUserManagamentService loggedUserManagamentService) {
        this.actualizarInformacionService = actualizarInformacionService;
        this.loggedUserManagamentService = loggedUserManagamentService;
    }

    @PostMapping("/actualizar-datos-cliente")
    public ResponseEntity<Map<String, Object>> actualizarDatosCliente(@RequestBody ActualizarDatosClienteDTO actualizarDatosClienteDTO) {
        int idUsuario = loggedUserManagamentService.getIdUsuario();
        int idCliente = actualizarInformacionService.obtenerClientePorIdUsuario(idUsuario).getIdCliente();
        actualizarInformacionService.cambiarDatosCliente(actualizarDatosClienteDTO, idCliente, idUsuario);
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("ok", true);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(respuesta);
    }

    @GetMapping("/datos-cliente")
    public ResponseEntity<Map<String, Object>> obtenerDatosCliente() {
        int idUsuario = loggedUserManagamentService.getIdUsuario();
        Map<String, Object> respuesta = actualizarInformacionService.obtenerDatosCliente(idUsuario);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(respuesta);
    }

    @PostMapping("/cambiar-clave-cliente")
    public ResponseEntity<Map<String, Object>> cambiarClaveCliente(@Valid @RequestBody CambiarClaveClienteDTO cambiarClaveClienteDTO) {
        int idUsuario = loggedUserManagamentService.getIdUsuario();
        actualizarInformacionService.cambiarClaveCliente(cambiarClaveClienteDTO, idUsuario);
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("ok", true);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(respuesta);
    }

}

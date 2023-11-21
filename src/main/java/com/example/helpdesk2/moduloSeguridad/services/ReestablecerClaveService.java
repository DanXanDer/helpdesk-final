package com.example.helpdesk2.moduloSeguridad.services;

import com.example.helpdesk2.moduloSeguridad.exceptions.UsuarioNoEncontrado;
import com.example.helpdesk2.moduloSeguridad.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

@Service
@RequestScope
public class ReestablecerClaveService {
    private final UsuarioRepository usuarioRepository;

    public ReestablecerClaveService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public int validarUsuarioPorDatos(String nombreUsuario, String nombres, String apellidos){
        return usuarioRepository.buscarUsuarioPorDatos(nombreUsuario, nombres, apellidos)
                .orElseThrow(UsuarioNoEncontrado::new);
    }
}

package com.example.helpdesk2.moduloGestionSistema.services;

import com.example.helpdesk2.models.Usuario;
import com.example.helpdesk2.moduloGestionSistema.exceptions.UsuariosNoEncontrados;
import com.example.helpdesk2.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GestionarUsuariosService {
    private final UsuarioRepository usuarioRepository;

    public GestionarUsuariosService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> obtenerUsuarios(String filtro, String valor){
        List<Usuario> usuarios;
        System.out.println(filtro);
        System.out.println(valor);
        if(filtro != null && valor != null){
            usuarios = usuarioRepository.buscarUsuariosPorFiltro(filtro, valor)
                    .orElseThrow(UsuariosNoEncontrados::new);
        }
        else{
            usuarios = usuarioRepository.buscarTodosLosUsuarios()
                    .orElseThrow(UsuariosNoEncontrados::new);
        }
        return usuarios;
    }

}

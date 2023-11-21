package com.example.helpdesk2.moduloSeguridad.services;

import com.example.helpdesk2.models.Usuario;
import com.example.helpdesk2.moduloSeguridad.exceptions.ClavesNoCoinciden;
import com.example.helpdesk2.moduloSeguridad.exceptions.RespuestaSecretaIncorrecta;
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

    public Usuario validarUsuarioPorDatos(String nombreUsuario, String nombres, String apellidos) {
        return usuarioRepository.buscarUsuarioPorDatos(nombreUsuario, nombres, apellidos)
                .orElseThrow(UsuarioNoEncontrado::new);
    }

    public String obtenerPreguntaSeguridad(int idPreguntaSeguridad) {
        return usuarioRepository.buscarPreguntaSeguridad(idPreguntaSeguridad);
    }

    public void validarRespuestaSecreta(int idUsuario, String rptaSecreta) {
        if (!usuarioRepository.buscarRptaSecreta(idUsuario).equals(rptaSecreta)) {
            throw new RespuestaSecretaIncorrecta();
        }
    }

    public void reestablecerClave(int idUsuario, String clave, String reClave){
        if(clave.equals(reClave)){
            usuarioRepository.reestablecerClave(idUsuario, clave);
        }
        else{
            throw new ClavesNoCoinciden();
        }
    }

}

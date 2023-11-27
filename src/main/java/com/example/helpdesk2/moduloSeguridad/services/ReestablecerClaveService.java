package com.example.helpdesk2.moduloSeguridad.services;

import com.example.helpdesk2.models.PreguntaSeguridad;
import com.example.helpdesk2.models.Usuario;
import com.example.helpdesk2.DTO.ReestablecerClaveDTO;
import com.example.helpdesk2.DTO.ValidarDatosUsuarioDTO;
import com.example.helpdesk2.DTO.ValidarRptaSecretaDTO;
import com.example.helpdesk2.moduloSeguridad.exceptions.ClavesNoCoincidenException;
import com.example.helpdesk2.moduloSeguridad.exceptions.RespuestaSecretaIncorrectaException;
import com.example.helpdesk2.moduloSeguridad.exceptions.UsuarioNoEncontradoException;
import com.example.helpdesk2.repositories.PreguntaSeguridadRepository;
import com.example.helpdesk2.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReestablecerClaveService {
    private final UsuarioRepository usuarioRepository;
    private final PreguntaSeguridadRepository preguntaSeguridadRepository;

    public ReestablecerClaveService(UsuarioRepository usuarioRepository, PreguntaSeguridadRepository preguntaSeguridadRepository) {
        this.usuarioRepository = usuarioRepository;
        this.preguntaSeguridadRepository = preguntaSeguridadRepository;
    }

    public Usuario validarUsuarioPorDatos(ValidarDatosUsuarioDTO validarDatosUsuarioDTO) {
        return usuarioRepository.buscarUsuarioPorDatos(validarDatosUsuarioDTO)
                .orElseThrow(UsuarioNoEncontradoException::new);
    }

    public String obtenerPreguntaSeguridad(int idPreguntaSeguridad) {
        return preguntaSeguridadRepository.buscarPreguntaSeguridad(idPreguntaSeguridad);
    }

    public void validarRespuestaSecreta(ValidarRptaSecretaDTO validarRptaSecretaDTO) {
        if (!usuarioRepository.buscarRptaSecreta(validarRptaSecretaDTO).equals(validarRptaSecretaDTO.getRptaSecreta())) {
            throw new RespuestaSecretaIncorrectaException();
        }
    }

    public void reestablecerClave(ReestablecerClaveDTO reestablecerClaveDTO) {
        if (reestablecerClaveDTO.getClave().equals(reestablecerClaveDTO.getReClave())) {
            usuarioRepository.reestablecerClave(reestablecerClaveDTO);
        } else {
            throw new ClavesNoCoincidenException();
        }
    }

}

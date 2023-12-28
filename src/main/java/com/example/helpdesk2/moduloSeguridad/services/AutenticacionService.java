package com.example.helpdesk2.moduloSeguridad.services;

import com.example.helpdesk2.DTO.CheckPrimerLoginDTO;
import com.example.helpdesk2.DTO.CompletarDatosDTO;
import com.example.helpdesk2.DTO.LogearUsuarioDTO;
import com.example.helpdesk2.models.PreguntaSeguridad;
import com.example.helpdesk2.moduloSeguridad.exceptions.ClavesNoCoincidenException;
import com.example.helpdesk2.moduloSeguridad.exceptions.UsuarioNoEncontradoException;
import com.example.helpdesk2.models.Usuario;
import com.example.helpdesk2.repositories.PreguntaSeguridadRepository;
import com.example.helpdesk2.repositories.PrivilegioRepository;
import com.example.helpdesk2.repositories.UsuarioPrivilegioRepository;
import com.example.helpdesk2.repositories.UsuarioRepository;
import com.example.helpdesk2.services.LoggedUserManagamentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutenticacionService {

    private final UsuarioRepository usuarioRepository;
    private final LoggedUserManagamentService loggedUserManagamentService;
    private final PrivilegioRepository privilegioRepository;
    private final PreguntaSeguridadRepository preguntaSeguridadRepository;

    public AutenticacionService(UsuarioRepository usuarioRepository, LoggedUserManagamentService loggedUserManagamentService, PrivilegioRepository privilegioRepository, PreguntaSeguridadRepository preguntaSeguridadRepository) {
        this.usuarioRepository = usuarioRepository;
        this.loggedUserManagamentService = loggedUserManagamentService;
        this.privilegioRepository = privilegioRepository;
        this.preguntaSeguridadRepository = preguntaSeguridadRepository;
    }


    public Usuario checkUsuarioPrimerLogin(CheckPrimerLoginDTO checkPrimerLoginDTO){
        return usuarioRepository.buscarUsuarioPorCredenciales(checkPrimerLoginDTO).orElseThrow(UsuarioNoEncontradoException::new);
    }

    public void autenticarUsuario(LogearUsuarioDTO logearUsuarioDTO){
        Usuario u = usuarioRepository.buscarUsuarioPorId(logearUsuarioDTO.getIdUsuario());
        loggedUserManagamentService.setIdUsuario(u.getIdUsuario());
        loggedUserManagamentService.setNombreUsuario(u.getNombreUsuario());
        loggedUserManagamentService.setNombres(u.getNombres());
        loggedUserManagamentService.setPrivilegios(privilegioRepository.buscarPrivilegiosDeUsuario(u.getIdUsuario()));
        loggedUserManagamentService.setTipo(u.getTipo());
    }

    public void completarDatosUsuario(CompletarDatosDTO completarDatosDTO) {
        if(completarDatosDTO.getClave().equals(completarDatosDTO.getReClave())){
            usuarioRepository.completarDatosUsuario(completarDatosDTO);
        }
        else{
            throw new ClavesNoCoincidenException();
        }
    }

    public List<PreguntaSeguridad> obtenerPreguntasSeguridad(){
        return preguntaSeguridadRepository.buscarTodasLasPreguntasSeguridad();
    }

}

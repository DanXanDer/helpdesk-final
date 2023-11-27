package com.example.helpdesk2.moduloSeguridad.services;

import com.example.helpdesk2.DTO.CheckPrimerLoginDTO;
import com.example.helpdesk2.DTO.CompletarDatosDTO;
import com.example.helpdesk2.DTO.PrivilegiosUsuarioDTO;
import com.example.helpdesk2.models.PreguntaSeguridad;
import com.example.helpdesk2.moduloSeguridad.exceptions.ClavesNoCoincidenException;
import com.example.helpdesk2.moduloSeguridad.exceptions.UsuarioNoEncontradoException;
import com.example.helpdesk2.models.Usuario;
import com.example.helpdesk2.models.Privilegio;
import com.example.helpdesk2.repositories.PreguntaSeguridadRepository;
import com.example.helpdesk2.repositories.PrivilegioRepository;
import com.example.helpdesk2.repositories.UsuarioRepository;
import com.example.helpdesk2.services.UsuarioLogeadoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutenticacionService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioLogeadoService usuarioLogeadoService;
    private final PrivilegioRepository privilegioRepository;
    private final PreguntaSeguridadRepository preguntaSeguridadRepository;

    public AutenticacionService(UsuarioRepository usuarioRepository, UsuarioLogeadoService usuarioLogeadoService, PrivilegioRepository privilegioRepository, PreguntaSeguridadRepository preguntaSeguridadRepository) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioLogeadoService = usuarioLogeadoService;
        this.privilegioRepository = privilegioRepository;
        this.preguntaSeguridadRepository = preguntaSeguridadRepository;
    }

    public Usuario checkUsuarioPrimerLogin(CheckPrimerLoginDTO checkPrimerLoginDTO){
        Usuario u = usuarioRepository.buscarUsuarioPorCredenciales(checkPrimerLoginDTO).orElseThrow(UsuarioNoEncontradoException::new);
        usuarioLogeadoService.setIdUsuario(u.getIdUsuario());
        usuarioLogeadoService.setNombreUsuario(u.getNombreUsuario());
        usuarioLogeadoService.setNombres(u.getNombres());
        usuarioLogeadoService.setApellidos(u.getApellidos());
        return u;
    }

    public List<Privilegio> obtenerPrivilegiosUsuario(PrivilegiosUsuarioDTO privilegiosUsuarioDTO){
        return privilegioRepository.buscarPrivilegiosDeUsuario(privilegiosUsuarioDTO.getIdUsuario());
    }

    public void completarDatosUsuario(CompletarDatosDTO completarDatosDTO) {
        if(completarDatosDTO.getClave().equals(completarDatosDTO.getNuevaClave())){
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

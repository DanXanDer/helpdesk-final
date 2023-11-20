package com.example.helpdesk2.moduloSeguridad.services;

import com.example.helpdesk2.moduloSeguridad.exceptions.ClavesNoCoinciden;
import com.example.helpdesk2.moduloSeguridad.exceptions.UsuarioNoEncontrado;
import com.example.helpdesk2.models.Usuario;
import com.example.helpdesk2.models.UsuarioPrivilegio;
import com.example.helpdesk2.moduloSeguridad.repositories.UsuarioPrivilegioRepository;
import com.example.helpdesk2.moduloSeguridad.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@Service
@RequestScope
public class AutenticacionService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioLogeadoService usuarioLogeadoService;
    private final UsuarioPrivilegioRepository usuarioPrivilegioRepository;

    public AutenticacionService(
            UsuarioRepository usuarioRepository,
            UsuarioLogeadoService usuarioLogeadoService,
            UsuarioPrivilegioRepository usuarioPrivilegioRepository) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioLogeadoService = usuarioLogeadoService;
        this.usuarioPrivilegioRepository = usuarioPrivilegioRepository;
    }

    public Usuario checkUsuarioPrimerLogin(String nombreUsuario, String clave){
        Usuario u = usuarioRepository.buscarUsuarioPorCredenciales(nombreUsuario, clave).orElseThrow(UsuarioNoEncontrado::new);
        usuarioLogeadoService.setIdUsuario(u.getIdUsuario());
        usuarioLogeadoService.setNombreUsuario(u.getNombreUsuario());
        usuarioLogeadoService.setNombres(u.getNombres());
        usuarioLogeadoService.setApellidos(u.getApellidos());
        return u;
    }

    public List<UsuarioPrivilegio> obtenerPrivilegiosUsuario(int idUsuario){
        return usuarioPrivilegioRepository.buscarPrivilegiosDeUsuario(idUsuario);
    }

    public void completarDatosUsuario(int idUsuario, String clave, String nuevaClave, int preguntaSeguridad, String rptaSecreta){
        if(clave.equals(nuevaClave)){
            usuarioRepository.completarDatosUsuario(idUsuario, clave, preguntaSeguridad, rptaSecreta);
        }
        else{
            throw new ClavesNoCoinciden();
        }
    }

}

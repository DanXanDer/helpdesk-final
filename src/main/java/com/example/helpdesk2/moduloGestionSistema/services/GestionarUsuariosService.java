package com.example.helpdesk2.moduloGestionSistema.services;

import com.example.helpdesk2.DTO.CambiarEstadoUsuarioDTO;
import com.example.helpdesk2.DTO.RegistrarTrabajadorDTO;
import com.example.helpdesk2.DTO.RegistrarUsuarioDTO;
import com.example.helpdesk2.models.*;
import com.example.helpdesk2.moduloGestionSistema.exceptions.NombreUsuarioExisteException;
import com.example.helpdesk2.moduloGestionSistema.exceptions.UsuariosNoEncontradosException;
import com.example.helpdesk2.repositories.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GestionarUsuariosService {
    private final UsuarioRepository usuarioRepository;
    private final PrivilegioRepository privilegioRepository;
    private final EmpresaRepository empresaRepository;
    private final SedeRepository sedeRepository;
    private final AreaRepository areaRepository;

    public GestionarUsuariosService(
            UsuarioRepository usuarioRepository,
            PrivilegioRepository privilegioRepository,
            EmpresaRepository empresaRepository,
            SedeRepository sedeRepository,
            AreaRepository areaRepository) {
        this.usuarioRepository = usuarioRepository;
        this.privilegioRepository = privilegioRepository;
        this.empresaRepository = empresaRepository;
        this.sedeRepository = sedeRepository;
        this.areaRepository = areaRepository;
    }

    public List<Usuario> obtenerUsuarios(String filtro, String valor) {
        List<Usuario> usuarios;
        if (filtro != null && valor != null) {
            usuarios = usuarioRepository.buscarUsuariosPorFiltro(filtro, valor)
                    .orElseThrow(UsuariosNoEncontradosException::new);
        } else {
            usuarios = usuarioRepository.buscarTodosLosUsuarios()
                    .orElseThrow(UsuariosNoEncontradosException::new);
        }
        return usuarios;
    }

    public void cambiarEstadoUsuario(CambiarEstadoUsuarioDTO cambiarEstadoUsuarioDTO) {
        usuarioRepository.cambiarEstadoUsuario(cambiarEstadoUsuarioDTO);
    }

    public List<Privilegio> obtenerTodosPrivilegios() {
        return privilegioRepository.buscarTodosPrivilegios();
    }

    public int crearUsuario(RegistrarUsuarioDTO registrarUsuarioDTO) {
        if (usuarioRepository.buscarNombreUsuarioExistente(registrarUsuarioDTO).isPresent()) {
            throw new NombreUsuarioExisteException();
        }
        usuarioRepository.registrarUsuario(registrarUsuarioDTO);
        int idUsuario = usuarioRepository.obtenerUltimoIdUsuario();
        registrarUsuarioDTO.getPrivilegios().forEach(
                idPrivilegio -> privilegioRepository.registrarPrivilegioUsuario(idUsuario, idPrivilegio)
        );
        return idUsuario;
    }

    public void crearTrabajador(RegistrarTrabajadorDTO registrarTrabajadorDTO) {
        usuarioRepository.registrarTrabajador(registrarTrabajadorDTO.getIdUsuario(), registrarTrabajadorDTO.getNivel());
    }

    public List<Empresa> obtenerEmpresas(){
        return empresaRepository.buscarEmpresas();
    }

    public List<Sede> obtenerSedesPorEmpresa(int idEmpresa){
        return sedeRepository.buscarSedesPorEmpresa(idEmpresa);
    }

    public List<Area> obtenerAreasPorSede(int idSede){
        return areaRepository.buscarAreasPorSede(idSede);
    }


}
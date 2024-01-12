package com.example.helpdesk2.moduloAdministrador.services;

import com.example.helpdesk2.DTO.CambiarEstadoUsuarioDTO;
import com.example.helpdesk2.DTO.RegistrarClienteDTO;
import com.example.helpdesk2.DTO.RegistrarTrabajadorDTO;
import com.example.helpdesk2.DTO.RegistrarUsuarioDTO;
import com.example.helpdesk2.models.*;
import com.example.helpdesk2.moduloAdministrador.exceptions.NombreUsuarioExisteException;
import com.example.helpdesk2.moduloAdministrador.exceptions.UsuariosNoEncontradosException;
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
    private final TrabajadorRepository trabajadorRepository;
    private final ClienteRepository clienteRepository;
    private final UsuarioPrivilegioRepository usuarioPrivilegioRepository;

    public GestionarUsuariosService(UsuarioRepository usuarioRepository, PrivilegioRepository privilegioRepository, EmpresaRepository empresaRepository, SedeRepository sedeRepository, AreaRepository areaRepository, TrabajadorRepository trabajadorRepository, ClienteRepository clienteRepository, UsuarioPrivilegioRepository usuarioPrivilegioRepository) {
        this.usuarioRepository = usuarioRepository;
        this.privilegioRepository = privilegioRepository;
        this.empresaRepository = empresaRepository;
        this.sedeRepository = sedeRepository;
        this.areaRepository = areaRepository;
        this.trabajadorRepository = trabajadorRepository;
        this.clienteRepository = clienteRepository;
        this.usuarioPrivilegioRepository = usuarioPrivilegioRepository;
    }


    public List<Usuario> obtenerUsuarios(String filtro, String valor) {
        List<Usuario> usuarios;
        if (filtro != null && valor != null) {
            usuarios = usuarioRepository.buscarUsuariosPorFiltro(filtro, valor)
                    .orElseThrow(UsuariosNoEncontradosException::new);
        } else {
            usuarios = usuarioRepository.buscarUsuariosNoAdministradores()
                    .orElseThrow(UsuariosNoEncontradosException::new);
        }
        return usuarios;
    }

    public void cambiarEstadoUsuario(CambiarEstadoUsuarioDTO cambiarEstadoUsuarioDTO) {
        usuarioRepository.cambiarEstadoUsuario(cambiarEstadoUsuarioDTO);
    }

    public int crearUsuario(RegistrarUsuarioDTO registrarUsuarioDTO) {
        if (usuarioRepository.buscarNombreUsuarioExistente(registrarUsuarioDTO).isPresent()) {
            throw new NombreUsuarioExisteException();
        }
        usuarioRepository.registrarUsuario(registrarUsuarioDTO);
        int idUsuario = usuarioRepository.obtenerUltimoIdUsuario();
        registrarUsuarioDTO.getPrivilegios().forEach(
                idPrivilegio -> usuarioPrivilegioRepository.registrarPrivilegioUsuario(idUsuario, idPrivilegio)
        );
        return idUsuario;
    }

    public void crearTrabajador(RegistrarTrabajadorDTO registrarTrabajadorDTO) {
        trabajadorRepository.registrarTrabajador(registrarTrabajadorDTO.getIdUsuario());
    }

    public void crearCliente(RegistrarClienteDTO registrarClienteDTO){
        clienteRepository.registrarCliente(registrarClienteDTO);
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

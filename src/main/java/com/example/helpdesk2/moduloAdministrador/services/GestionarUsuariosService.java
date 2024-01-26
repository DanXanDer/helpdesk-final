package com.example.helpdesk2.moduloAdministrador.services;

import com.example.helpdesk2.DTO.*;
import com.example.helpdesk2.models.*;
import com.example.helpdesk2.moduloAdministrador.exceptions.CorreoUsuarioExisteException;
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



    public List<Usuario> obtenerTrabajadores() {
        return usuarioRepository.buscarUsuariosNoAdministradores();
    }

    public List<DatosClienteDTO> obtenerTodosLosClientes(){
        return clienteRepository.buscarTodosLosClientes();
    }

    public void cambiarEstadoUsuario(CambiarEstadoUsuarioDTO cambiarEstadoUsuarioDTO) {
        usuarioRepository.cambiarEstadoUsuario(cambiarEstadoUsuarioDTO);
    }

    public int crearUsuario(RegistrarUsuarioDTO registrarUsuarioDTO) {
        if (usuarioRepository.buscarNombreUsuarioExistente(registrarUsuarioDTO.getNombreUsuario()).isPresent()) {
            throw new NombreUsuarioExisteException();
        }
        if(usuarioRepository.buscarCorreoUsuarioExistente(registrarUsuarioDTO.getCorreo()).isPresent()){
            throw new CorreoUsuarioExisteException();
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

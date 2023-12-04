package com.example.helpdesk2.moduloCliente.services;

import com.example.helpdesk2.DTO.ActualizarDatosClienteDTO;
import com.example.helpdesk2.DTO.CambiarClaveClienteDTO;
import com.example.helpdesk2.models.Cliente;
import com.example.helpdesk2.moduloSeguridad.exceptions.ClavesNoCoincidenException;
import com.example.helpdesk2.repositories.ClienteRepository;
import com.example.helpdesk2.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
public class ActualizarInformacionService {

    private final ClienteRepository clienteRepository;
    private final UsuarioRepository usuarioRepository;

    public ActualizarInformacionService(ClienteRepository clienteRepository, UsuarioRepository usuarioRepository) {
        this.clienteRepository = clienteRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public Cliente obtenerClientePorIdUsuario(int idUsuario){
        return clienteRepository.buscarClientePorIdUsuario(idUsuario);
    }

    @Transactional
    public void cambiarDatosCliente(ActualizarDatosClienteDTO actualizarDatosClienteDTO, int idCliente, int idUsuario){
        clienteRepository.actualizarDatosCliente(actualizarDatosClienteDTO, idCliente);
        usuarioRepository.actualizarCorreo(actualizarDatosClienteDTO.getCorreo(), idUsuario);
    }

    public Map<String, Object> obtenerDatosCliente(int idUsuario){
        Cliente c = clienteRepository.buscarClientePorIdUsuario(idUsuario);
        String correo = usuarioRepository.buscarCorreoUsuarioPorId(idUsuario);
        Map<String, Object> datosCliente = new HashMap<>();
        datosCliente.put("anydesk", c.getAnydesk());
        datosCliente.put("teamviewer", c.getTeamviewer());
        datosCliente.put("correo", correo);
        return datosCliente;
    }

    public void cambiarClaveCliente(CambiarClaveClienteDTO cambiarClaveClienteDTO, int idUsuario){
        if (cambiarClaveClienteDTO.getClave().equals(cambiarClaveClienteDTO.getReClave())) {
            clienteRepository.actualizarClave(cambiarClaveClienteDTO, idUsuario);
        } else {
            throw new ClavesNoCoincidenException();
        }
    }
}

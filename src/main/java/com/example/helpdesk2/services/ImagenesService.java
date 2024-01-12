package com.example.helpdesk2.services;

import com.example.helpdesk2.models.Imagen;
import com.example.helpdesk2.repositories.ImagenRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImagenesService {
    private final ImagenRepository imagenRepository;

    public ImagenesService(ImagenRepository imagenRepository) {
        this.imagenRepository = imagenRepository;
    }

    public List<Imagen> obtenerImagenesMensaje(int idMensaje){
        return imagenRepository.buscarImagenesMensaje(idMensaje);
    }
}

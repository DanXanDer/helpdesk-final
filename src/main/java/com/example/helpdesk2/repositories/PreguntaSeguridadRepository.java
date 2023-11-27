package com.example.helpdesk2.repositories;

import com.example.helpdesk2.DTO.CheckPrimerLoginDTO;
import com.example.helpdesk2.models.PreguntaSeguridad;
import com.example.helpdesk2.models.Usuario;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PreguntaSeguridadRepository extends CrudRepository<PreguntaSeguridad, Integer> {

    @Query("SELECT * FROM pregunta_seguridad")
    List<PreguntaSeguridad> buscarTodasLasPreguntasSeguridad();

    @Query("SELECT nombre_pregunta_seguridad FROM pregunta_seguridad WHERE id_pregunta_seguridad = :idPreguntaSeguridad")
    String buscarPreguntaSeguridad(int idPreguntaSeguridad);

}

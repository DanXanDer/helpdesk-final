package com.example.helpdesk2.repositories;

import com.example.helpdesk2.models.PreguntaSeguridad;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

public interface PreguntaSeguridadRepository extends CrudRepository<PreguntaSeguridad, Integer> {
}

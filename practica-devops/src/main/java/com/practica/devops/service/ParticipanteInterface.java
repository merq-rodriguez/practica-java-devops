package com.practica.devops.service;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practica.devops.model.Participante;

@Repository
public interface ParticipanteInterface extends JpaRepository<Participante, Long> {
	
	List<Participante> findByEstado(int estado);
	
}

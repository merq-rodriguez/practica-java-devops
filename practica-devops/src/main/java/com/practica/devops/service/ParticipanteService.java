package com.practica.devops.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practica.devops.model.Participante;

@Service
public class ParticipanteService {
	@Autowired
	private ParticipanteInterface participanteInterface;
	
	public List<Participante> obtenerTodos(){
		return participanteInterface.findAll();	
	}
	
	public List<Participante> obtenerParticipanteEstado(int estado){
		return participanteInterface.findByEstado(estado);
	}
	

	public Participante obtenerParticipanteId(Long id){
		Optional<Participante> optionalEntity =  participanteInterface.findById(id);
		Participante participante = new Participante();
		
		if(optionalEntity.isPresent()) {
			return optionalEntity.get();
		}else {
			return participante;
		}
	}
	

	public Participante crearParticipante(Participante participante) {
		return participanteInterface.save(participante);
	}
	

	public Participante actualizarParticipante(Long id,Participante participante) {
		
		Participante participanteSave  =  obtenerParticipanteId(id);
		participanteSave.setEstado(participante.getEstado());
		return crearParticipante(participanteSave);
	}
	
	public Participante eliminarParticipante(Long id) {
		Participante participanteDelete = obtenerParticipanteId(id);
		participanteInterface.delete(participanteDelete);
		return participanteDelete;
	}
	
}

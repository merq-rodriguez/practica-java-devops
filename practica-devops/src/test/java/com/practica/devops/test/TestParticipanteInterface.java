package com.practica.devops.test;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.practica.devops.PracticaDevOpsApplication;
import com.practica.devops.model.Participante;
import com.practica.devops.service.ParticipanteInterface;   

@RunWith(SpringRunner.class)
@SpringBootTest(classes =PracticaDevOpsApplication.class)
public class TestParticipanteInterface {
	
	private static final long ID = 123456L;
	private static final String NOMBRE = "Pedro Pruebas";
	private static final long ID2 = 1234567L;
	private static final String NOMBRE2 = "Juana Pruebas";
	private static final int ESTADO = 1;
	
	@MockBean
	private ParticipanteInterface participanteInterface;
	
	
	@Test
	public void obtenerTodosTest(){
		
		Mockito.when(participanteInterface.findAll()).thenReturn(Stream.
					of(new Participante(ID, NOMBRE, ESTADO),new Participante(ID2, NOMBRE2, ESTADO)).collect(Collectors.toList()));
		
		assertEquals(2, participanteInterface.findAll().size());
	}
	
	@Test
	public void obtenerParticipanteEstadoTest(){
		
		Mockito.when(participanteInterface.findByEstado(ESTADO)).thenReturn(Stream.
					of(new Participante(ID, NOMBRE, ESTADO),new Participante(ID2, NOMBRE2, ESTADO)).collect(Collectors.toList()));
		
		List<Participante> participantesActivos = participanteInterface.findByEstado(ESTADO);
		
		for (Participante participante : participantesActivos) {
			assertEquals(ESTADO, participante.getEstado());
		}
	}
	
	@Test
	public void obtenerParticipanteIdTest(){
		
		Optional<Participante> participanteOptional = Optional.of(new Participante(ID, NOMBRE, ESTADO));
		
		Mockito.when(participanteInterface.findById(ID)).thenReturn(participanteOptional);
		
		Optional<Participante> participante = participanteInterface.findById(ID);
		Participante participanteConsultado = participante.get();
		assertEquals(new BigDecimal(ID), new BigDecimal(participanteConsultado.getId()));
		
	}
	
	@Test
	public void crearParticipanteTest(){	
		
		Participante participanteSave = new Participante(ID, NOMBRE, ESTADO);
		
		Mockito.when(participanteInterface.save(participanteSave)).thenReturn(new Participante(ID, NOMBRE, ESTADO));
		
		Participante participanteConsultado = participanteInterface.save(participanteSave);
		assertEquals(new BigDecimal(ID), new BigDecimal(participanteConsultado.getId()));
		
	}
	
	@Test
	public void eliminarParticipanteTest(){	
		
		Participante participanteDelete = new Participante(ID, NOMBRE, ESTADO);		
		participanteInterface.delete(participanteDelete);
		Mockito.verify(participanteInterface, Mockito.times(1)).delete(participanteDelete);
		
	}
	
}

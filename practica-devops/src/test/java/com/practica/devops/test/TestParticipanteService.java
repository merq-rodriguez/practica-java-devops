package com.practica.devops.test;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.List;
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
import com.practica.devops.service.ParticipanteService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PracticaDevOpsApplication.class)
public class TestParticipanteService {
	
	private static final long ID = 123456L;
	private static final String NOMBRE = "Pedro Pruebas";
	private static final long ID2 = 1234567L;
	private static final String NOMBRE2 = "Juana Pruebas";
	private static final int ESTADO = 1;
	
	@MockBean
	private ParticipanteService participanteService;
	
	
	@Test
	public void obtenerTodosTest(){
		
		Mockito.when(participanteService.obtenerTodos()).thenReturn(Stream.
					of(new Participante(ID, NOMBRE, ESTADO),new Participante(ID2, NOMBRE2, ESTADO)).collect(Collectors.toList()));
		
		assertEquals(2, participanteService.obtenerTodos().size());
	}
	
	@Test
	public void obtenerParticipantesEstadoTest(){
		
		Mockito.when(participanteService.obtenerParticipanteEstado(ESTADO)).thenReturn(Stream.
					of(new Participante(ID, NOMBRE, ESTADO),new Participante(ID2, NOMBRE2, ESTADO)).collect(Collectors.toList()));
		
		List<Participante> participantesActivos = participanteService.obtenerParticipanteEstado(ESTADO);
		
		for (Participante participante : participantesActivos) {
			assertEquals(ESTADO, participante.getEstado());
		}
	}
	
	@Test
	public void obtenerParticipanteIdTest(){
		
		Mockito.when(participanteService.obtenerParticipanteId(ID)).thenReturn(new Participante(ID, NOMBRE, ESTADO));
		
		Participante participante = participanteService.obtenerParticipanteId(ID);
		assertEquals(new BigDecimal(ID), new BigDecimal(participante.getId()));
		
	}
	
	@Test
	public void crearParticipanteTest(){	
		
		Participante participanteSave = new Participante(ID, NOMBRE, ESTADO);
		
		Mockito.when(participanteService.crearParticipante(participanteSave)).thenReturn(new Participante(ID, NOMBRE, ESTADO));
		
		Participante participanteConsultado = participanteService.crearParticipante(participanteSave);
		assertEquals(new BigDecimal(ID), new BigDecimal(participanteConsultado.getId()));
		
	}
	
	@Test
	public void eliminarParticipanteTest(){	
			
		participanteService.eliminarParticipante(ID);
		Mockito.verify(participanteService, Mockito.times(1)).eliminarParticipante(ID);
		
	}
	
}

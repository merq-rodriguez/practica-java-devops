package com.practica.devops.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.practica.devops.PracticaDevOpsApplication;
import com.practica.devops.controller.ParticipanteController;
import com.practica.devops.model.Participante;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = PracticaDevOpsApplication.class)
public class TestParticipanteController {
	
	
	private MockMvc mockMvcCliente;
	
	@Autowired
	private ParticipanteController participanteController;
	
	@Before
	public void cargarCliente() throws Exception{
		mockMvcCliente = MockMvcBuilders.standaloneSetup(participanteController).build();
	}
	
	@Test
	public void obtenerTodosParticipantesControllerTest() throws Exception {	
		mockMvcCliente.perform(
				MockMvcRequestBuilders.get("/devops/obtenerTodosParticipantes").accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void obtenerParticipantesEstadoControllerTest() throws Exception {	
		mockMvcCliente.perform(
				MockMvcRequestBuilders.get("/devops/obtenerParticipanteEstado/1").accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void obtenerParticipanteIdControllerTest() throws Exception {	
		mockMvcCliente.perform(
				MockMvcRequestBuilders.get("/devops/obtenerParticipanteId/123456").accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void crearParticipanteControllerTest() throws Exception {
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		Participante par = new Participante();
		String json = ow.writeValueAsString(par);
		mockMvcCliente.perform(
				MockMvcRequestBuilders.post("/devops/crearParticipante")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json)
				.accept(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void eliminarParticipanteIdControllerTest() throws Exception {	
		mockMvcCliente.perform(
				MockMvcRequestBuilders.delete("/devops/eliminarParticipante/123456").accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
}

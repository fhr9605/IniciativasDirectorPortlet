package org.cenicafe.repository;

import java.net.URL;
import java.util.List;

import org.cenicafe.model.Empleado;
import org.cenicafe.model.Iniciativa;
import org.cenicafe.model.Pregunta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;


@Repository
@PropertySource("classpath:servicios.properties")
public class WebServicesImpl implements IWebServices{
	@Autowired
	Environment env;
	
	
	@Override		
	public Empleado RetornarEmpleado(String email) throws Exception{
		RestTemplate empleado = new RestTemplate();
		URL url = new URL(env.getProperty("WebService.Server")+"/WsSIGA_Empleados/siga/obtenerInformacionEmpleadoMail/"+email);
		
		return (Empleado)empleado.getForObject(url.toURI(), Empleado.class);					
		
	}
	
	@Override
    public List<Iniciativa> obtenerIniciativas () throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<Iniciativa>> response = restTemplate.exchange("http://localhost:8080/jsons/iniciativaPrueba.json",
		  HttpMethod.GET,
		  null,
		  new ParameterizedTypeReference<List<Iniciativa>>(){});
		List<Iniciativa> lstIniciativa = response.getBody();

		return lstIniciativa;
	}
	
	
	@Override
    public List<Pregunta> obtenerPreguntas () throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<Pregunta>> response = restTemplate.exchange("http://192.168.194.119/jsons/preguntas.json",
		  HttpMethod.GET,
		  null,
		  new ParameterizedTypeReference<List<Pregunta>>(){});
		List<Pregunta> lstPreguntas = response.getBody();

		return lstPreguntas;
	}
}

package org.cenicafe.controller;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.cenicafe.model.Empleado;
import org.cenicafe.model.Iniciativa;
import org.cenicafe.model.Pregunta;
import org.cenicafe.repository.IWebServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.remoting.soap.SoapFaultException;
import org.springframework.stereotype.Controller;

@Controller
@Scope("view") // El scope view fue creado por una clase custom.
@PropertySource("classpath:servicios.properties")
public class IniciativasDirectorController {

	final static Logger logger = Logger.getLogger(IniciativasDirectorController.class);
	
	/***
	 * ATRIBUTOS
	 */
			//CLASE EMPLEADO
			private Empleado usuario;
			
			//CLASE INICIATIVAS
			private List<Iniciativa> lstIniciativasPendiente;
			private Iniciativa iniciativaDetalle;
			
			//CLASE PREGUNTAS
			private List<Pregunta> lstPreguntas;
			
			//CLASE CONTROLLER 
			private String emailContacto;
			
			// GETTER AND SETTER DE LOS OBJETOS DE LA CLASE EMPLEADO
			public Empleado getUsuario() {
				return usuario;
			}
			public void setUsuario(Empleado usuario) {
				this.usuario = usuario;
			}
			
			
			//GETTER AND SETTER DE LOS OBJETOS DE LA CLASE INICIATIVA
			public List<Iniciativa> getLstIniciativasPendiente() {
				return lstIniciativasPendiente;
			}
			public void setLstIniciativasPendiente(List<Iniciativa> lstIniciativasPendiente) {
				this.lstIniciativasPendiente = lstIniciativasPendiente;
			}
			
			public Iniciativa getIniciativaDetalle() {
				return iniciativaDetalle;
			}
			public void setIniciativaDetalle(Iniciativa iniciativaDetalle) {
				this.iniciativaDetalle = iniciativaDetalle;
			}
			
			//GETTER AND SETTER DE LOS OBJETOS DE LA CLASE PREGUNTAS 
			public List<Pregunta> getLstPreguntas() {
				return lstPreguntas;
			}
			public void setLstPreguntas(List<Pregunta> lstPreguntas) {
				this.lstPreguntas = lstPreguntas;
			}
			
			//GETTER AND SETTER DE LOS OBJETOS DE LA CLASE CONTROLLER
			public String getEmailContacto() {
				return emailContacto;
			}
			public void setEmailContacto(String emailContacto) {
				this.emailContacto = emailContacto;
			}
			
		@Autowired
		IWebServices ws;
			
	/***
	 * METODOS ---> INIT 
	 */
			//METODO ---> INIT 
			@PostConstruct
			public void init () {
				logger.info("Hola Init ---> Iniciativas Director Portlet");
				
				setUsuario(new Empleado());
				
				setLstIniciativasPendiente(new ArrayList<>());
				setLstPreguntas(new ArrayList<>());
				setIniciativaDetalle(new Iniciativa());
				
				try {
					//obtenerEmailContacto();
					//setUsuario(ws.RetornarEmpleado(getEmailContacto()));
					setLstPreguntas(ws.obtenerPreguntas());
					setLstIniciativasPendiente(ws.obtenerIniciativas());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
	
	/***
	 * METODOS ---> GENERAR // CONVERTIR  // MENSAJES
	 */
			
			// METODO ---> OBTENER EMAIL DE CONTACTO 
			public void obtenerEmailContacto() throws ParseException, PortalException, SystemException {

		        String Login = getCurrentUser().getLogin();
		        if (Login.equals("default@liferay.com")) {
		            Login = null;
		        } else if (Login.trim().length() == 0) {
		            Login = null;
		        }
		        setEmailContacto(Login);
		    }
			
			// METODO ---> OBTENER USUARIO 
			public User getCurrentUser(){
		        User u = null;
		        FacesContext fc = FacesContext.getCurrentInstance();

		        ExternalContext externalContext = fc.getExternalContext();

		        if (externalContext.getUserPrincipal() == null) {

		        } else {
		            Long id = Long.parseLong(externalContext.getUserPrincipal().getName());
		            try {
		               u = UserLocalServiceUtil.getUserById(id);
		              
		           } catch (PortalException ex) {
		           		Logger.getLogger(IniciativasDirectorController.class.getName()).log(null, ex);
		           } catch (SystemException ex) {
		           		Logger.getLogger(IniciativasDirectorController.class.getName()).log(null, ex);
		           }
		       }
		       return u;
			}
			
	/***
	 * METODOS ---> PRUEBAS 
	 */
			//METODO ---> AGREGAR EMPLEADOS
			public void agregrarEmpleado(){
				Empleado objEmpleado = new Empleado();
				
				for (int i=0;i<4;i++) {
					objEmpleado.setCedula("Cedula :"+ i);
					objEmpleado.setnombres("Nombres :"+i);
					objEmpleado.setFoto(null);
					objEmpleado.setExtension("Extension :"+i);
					objEmpleado.setmailCorporativo("Email :" +i);
					objEmpleado.setprograma("Programa : "+i);
					
				}
			}
			
}

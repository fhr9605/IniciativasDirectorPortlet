package org.cenicafe.model;

import java.util.List;

public class Iniciativa {
	private String idIniciativa;
	private String programa;
	private String subPrograma;
	private String ejeEstrategico;
	private String tituloIniciativa;
	private String resumenIniciativa;
	private String fechaCreacion;
	private String estado;
	private String investigador;
	private String discutidaLider;
	private Pregunta[] preguntasIniciativa;
	
	public String getIdIniciativa() {
		return idIniciativa;
	}
	public void setIdIniciativa(String idIniciativa) {
		this.idIniciativa = idIniciativa;
	}
	public String getPrograma() {
		return programa;
	}
	public void setPrograma(String programa) {
		this.programa = programa;
	}
	public String getSubPrograma() {
		return subPrograma;
	}
	public void setSubPrograma(String subPrograma) {
		this.subPrograma = subPrograma;
	}
	public String getEjeEstrategico() {
		return ejeEstrategico;
	}
	public void setEjeEstrategico(String ejeEstrategico) {
		this.ejeEstrategico = ejeEstrategico;
	}
	public String getTituloIniciativa() {
		return tituloIniciativa;
	}
	public void setTituloIniciativa(String tituloIniciativa) {
		this.tituloIniciativa = tituloIniciativa;
	}
	public String getResumenIniciativa() {
		return resumenIniciativa;
	}
	public void setResumenIniciativa(String resumenIniciativa) {
		this.resumenIniciativa = resumenIniciativa;
	}
	public String getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getInvestigador() {
		return investigador;
	}
	public void setInvestigador(String investigador) {
		this.investigador = investigador;
	}
	public String getDiscutidaLider() {
		return discutidaLider;
	}
	public void setDiscutidaLider(String discutidaLider) {
		this.discutidaLider = discutidaLider;
	}
	public Pregunta[] getPreguntasIniciativa() {
		return preguntasIniciativa;
	}
	public void setPreguntasIniciativa(Pregunta[] preguntasIniciativa) {
		this.preguntasIniciativa = preguntasIniciativa;
	}
	
}

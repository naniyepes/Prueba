
package com.proint1.udea.administracion.dto;

import java.io.Serializable;

/**
 * @author danilo
 *
 */
public class SumaryGruposDTO implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7548446492968708134L;

	private String nombreDocente;
		
	private String nombreDependencia;
	
	private String semestre; 
	
	private String codigoCurso;
	
	private String nombreCurso;
	
	private String modalidadCurso;
	
	private String grupoNumero;
	
	private String Horario;
	
	private Double totalTiempoHoras;

	public String getNombreDocente() {
		return nombreDocente;
	}

	public void setNombreDocente(String nombreDocente) {
		this.nombreDocente = nombreDocente;
	}

	public String getNombreDependencia() {
		return nombreDependencia;
	}

	public void setNombreDependencia(String nombreDependencia) {
		this.nombreDependencia = nombreDependencia;
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public String getCodigoCurso() {
		return codigoCurso;
	}

	public void setCodigoCurso(String codigoCurso) {
		this.codigoCurso = codigoCurso;
	}

	public String getNombreCurso() {
		return nombreCurso;
	}

	public void setNombreCurso(String nombreCurso) {
		this.nombreCurso = nombreCurso;
	}

	public String getModalidadCurso() {
		return modalidadCurso;
	}

	public void setModalidadCurso(String modalidadCurso) {
		this.modalidadCurso = modalidadCurso;
	}

	public String getGrupoNumero() {
		return grupoNumero;
	}

	public void setGrupoNumero(String grupoNumero) {
		this.grupoNumero = grupoNumero;
	}

	public String getHorario() {
		return Horario;
	}

	public void setHorario(String horario) {
		Horario = horario;
	}

	public Double getTotalTiempoHoras() {
		return totalTiempoHoras;
	}

	public void setTotalTiempoHoras(Double totalTiempoHoras) {
		this.totalTiempoHoras = totalTiempoHoras;	
		}
	
}

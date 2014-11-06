package com.proint1.udea.administracion.dao;

import java.io.Serializable;

/**
 * DTO de persistencia para la entidad Grupo
 * @author Daniela Yepes - Danilo Mejía
 * @since 18/09/2014
 */

public class SemestreDTO implements Serializable {


	private static final long serialVersionUID = 1228386332005597588L;
	/**
	 * 
	 */

	/**Año* el 2014 */
	private int agno;
	
	/**Periodo ejemplo: 1 */
	private int periodo;
	
	/**Identificador unico del grupo*/
	private long idnSemestre;
	
	/**Identificador unico del grupo*/
	private long idnDependencia;
	
	/**Identificador unico del grupo*/
	private String idnEstadoSemestre;
	
	/**Identificador unico del grupo*/
	private String estadoSemestre;
	
	/**Identificador unico del grupo*/
	private String nombreDependencia;

	
	
	public int getAgno() {
		return agno;
	}

	public void setAgno(int agno) {
		this.agno = agno;
	}

	
	
	public int getPeriodo() {
		return periodo;
	}

	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}

	public long getIdnSemestre() {
		return idnSemestre;
	}

	public void setIdnSemestre(long idnSemestre) {
		this.idnSemestre = idnSemestre;
	}

	public long getIdnDependencia() {
		return idnDependencia;
	}

	public void setIdnDependencia(long idnDependencia) {
		this.idnDependencia = idnDependencia;
	}

	public String getEstadoSemestre() {
		return estadoSemestre;
	}

	public void setEstadoSemestre(String estadoSemestre) {
		this.estadoSemestre = estadoSemestre;
	}

	public String getNombreDependencia() {
		return nombreDependencia;
	}

	public void setNombreDependencia(String nombreDependencia) {
		this.nombreDependencia = nombreDependencia;
	}

	public String getIdnEstadoSemestre() {
		return idnEstadoSemestre;
	}

	public void setIdnEstadoSemestre(String idnEstadoSemestre) {
		this.idnEstadoSemestre = idnEstadoSemestre;
	}	
	
	
	
}

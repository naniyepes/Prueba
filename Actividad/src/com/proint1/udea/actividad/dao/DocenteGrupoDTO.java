package com.proint1.udea.actividad.dao;

import java.io.Serializable;

/**
 * DTO de persistencia para registro de actividades
 * @author Daniela Yepes - Danilo Mejía - Juan Cardona
 * @since 01/10/2014
 */

public class DocenteGrupoDTO implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 983623511849358862L;
	

	/**Año* el 2014 */
	private int agno;
	
	/**Periodo ejemplo: 1 */
	private int periodo;
	
	/**ID propio de la dependencia por ejemplo IDS-103 **/
	private String idCurso;
	
	/**Nombre del curso	 **/
	private String nombre;
	
	/**numero del grupo asignado por la universidadd ejempl 01 02 023 */
	private String numeroGrupo;

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

	public String getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(String idCurso) {
		this.idCurso = idCurso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNumeroGrupo() {
		return numeroGrupo;
	}

	public void setNumeroGrupo(String numeroGrupo) {
		this.numeroGrupo = numeroGrupo;
	}	
	
	
}

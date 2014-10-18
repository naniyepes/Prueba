package com.proint1.udea.administracion.dao;

import java.io.Serializable;

/**
 * DTO de persistencia para la entidad Grupo
 * @author Daniela Yepes - Danilo Mejía
 * @since 18/09/2014
 */

public class GrupoDTO implements Serializable {


	private static final long serialVersionUID = 1228386332005597588L;
	/**
	 * 
	 */

	/**Año* el 2014 */
	private String agno;
	
	/**Identificador unico del grupo*/
	private long idn;
	
	/**numero del grupo asignado por la universidadd ejempl 01 02 023 */
	private String numeroGrupo;
	
	/**horario destinado para el grupo*/
	private String horario;
	
	/**ID propio de la dependencia por ejemplo IDS-103 **/
	private String idCurso;
	
	/**Nombre del curso	 **/
	private String nombre;

	

	public String getAgno() {
		return agno;
	}

	public void setAgno(String agno) {
		this.agno = agno;
	}


	public long getIdn() {
		return idn;
	}

	public void setIdn(long idn) {
		this.idn = idn;
	}

	public String getNumeroGrupo() {
		return numeroGrupo;
	}

	public void setNumeroGrupo(String numeroGrupo) {
		this.numeroGrupo = numeroGrupo;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	
}

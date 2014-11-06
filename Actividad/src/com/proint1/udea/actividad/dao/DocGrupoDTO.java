package com.proint1.udea.actividad.dao;

import java.io.Serializable;

/**
 * DTO de persistencia para la entidad Docente por Grupo
 * @author Daniela Yepes - Danilo Mejía
 * @since 02/11/2014
 */

public class DocGrupoDTO implements Serializable {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = -667512431491503686L;
	
	/**Identificador unico del grupo*/
	private long idnDocGrupo;
	
	/**Identificador unico del grupo*/
	private long idnGrupo;
	
	/**numero del grupo asignado por la universidadd ejempl 01 02 023 */
	private String numeroGrupo;
	
	/**ID propio de la dependencia por ejemplo IDS-103 **/
	private String idCurso;
	
	/**Nombre del curso	 **/
	private String nombreCurso;
	
	/**Nombre del curso	 **/
	private String nombreDocente;
	
	/**Identificador unico del grupo*/
	private long idnDocente;
	
	

	public long getIdnGrupo() {
		return idnGrupo;
	}

	public void setIdnGrupo(long idnGrupo) {
		this.idnGrupo = idnGrupo;
	}

	public String getNumeroGrupo() {
		return numeroGrupo;
	}

	public void setNumeroGrupo(String numeroGrupo) {
		this.numeroGrupo = numeroGrupo;
	}

	public String getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(String idCurso) {
		this.idCurso = idCurso;
	}

	public String getNombreCurso() {
		return nombreCurso;
	}

	public void setNombreCurso(String nombreCurso) {
		this.nombreCurso = nombreCurso;
	}

	public String getNombreDocente() {
		return nombreDocente;
	}

	public void setNombreDocente(String nombreDocente) {
		this.nombreDocente = nombreDocente;
	}

	public long getIdnDocente() {
		return idnDocente;
	}

	public void setIdnDocente(long idnDocente) {
		this.idnDocente = idnDocente;
	}

	public long getIdnDocGrupo() {
		return idnDocGrupo;
	}

	public void setIdnDocGrupo(long idnDocGrupo) {
		this.idnDocGrupo = idnDocGrupo;
	}
	
	
	
}

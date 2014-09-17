package com.proint1.udea.administracion.dao;

import java.io.Serializable;

/**
 * DAO de persistencia para la entidad AdmCurso
 * @author Daniela Yepes
 * @since 25/05/2014
 */

public class CursoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3060533883881027273L;
	
	
	private String nombreCurso;
	private String idCurso;
	private String nombreDependencia;
	private long idn;
	private long idnDependencia;
	
	/**
	 * @return the nombreCurso
	 */
	public String getNombreCurso() {
		return nombreCurso;
	}	
	/**
	 * @param nombreCurso the nombreCurso to set
	 */
	public void setNombreCurso(String nombreCurso) {
		this.nombreCurso = nombreCurso;
	}
	/**
	 * @return the idCurso
	 */
	public String getIdCurso() {
		return idCurso;
	}
	/**
	 * @param idCurso the idCurso to set
	 */
	public void setIdCurso(String idCurso) {
		this.idCurso = idCurso;
	}
	/**
	 * @return the nombreDependencia
	 */
	public String getNombreDependencia() {
		return nombreDependencia;
	}
	/**
	 * @param nombreDependencia the nombreDependencia to set
	 */
	public void setNombreDependencia(String nombreDependencia) {
		this.nombreDependencia = nombreDependencia;
	}
	/**
	 * @return the idn
	 */
	public long getIdn() {
		return idn;
	}
	/**
	 * @param idn the idn to set
	 */
	public void setIdn(long idn) {
		this.idn = idn;
	}
	/**
	 * @return the idnDependencia
	 */
	public long getIdnDependencia() {
		return idnDependencia;
	}
	/**
	 * @param idnDependencia the idnDependencia to set
	 */
	public void setIdnDependencia(long idnDependencia) {
		this.idnDependencia = idnDependencia;
	}	
	
}

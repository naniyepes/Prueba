package com.proint1.udea.actividad.entidades;

import java.util.Date;

import com.proint1.udea.administracion.entidades.academico.Grupo;
import com.proint1.udea.administracion.entidades.terceros.Docente;

/**
 * Entridad que representa la participación de un docente en un grupo
 * @author Juan Cardona
 * @since 30/05/2014
 */
public class DocenteGrupo implements java.io.Serializable {

	/**serialVersionUID**/
	private static final long serialVersionUID = 6495744478039154471L;
	/**Identificador unico*/
	private long idn;
	/**iden del docente*/
	private long docenteIdn;
	/**Docente asociado al grupo*/
	private Docente docente;
	/**Idn del grupo*/
	private long grupoIdn;
	/**Grupo*/	
	private Grupo grupo;
	/**Tiempo total*/
	private double tiempoTotal;
	/**Usuario que modifica la entidad*/
	private String usuarioActualizacion;
	/**Fecha de modificación de la entidad*/
	private Date fechaActualizacion;

	/**
	 * 
	 */
	public DocenteGrupo() {
		super();
	}

	/**
	 * @param docenteIdn
	 * @param grupoIdn
	 */
	public DocenteGrupo(long docenteIdn, long grupoIdn) {
		super();
		this.docenteIdn = docenteIdn;
		this.grupoIdn = grupoIdn;
		this.fechaActualizacion = new Date();
		this.usuarioActualizacion = "SYSTEM";
	}

	/**
	 * @param docente
	 * @param grupo
	 */
	public DocenteGrupo(Docente docente, Grupo grupo) {
		super();
		this.docente = docente;
		this.grupo = grupo;
		this.fechaActualizacion = new Date();
		this.usuarioActualizacion = "SYSTEM";
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
	 * @return the docenteIdn
	 */
	public long getDocenteIdn() {
		return docenteIdn;
	}

	/**
	 * @param docenteIdn the docenteIdn to set
	 */
	public void setDocenteIdn(long docenteIdn) {
		this.docenteIdn = docenteIdn;
	}

	/**
	 * @return the docente
	 */
	public Docente getDocente() {
		return docente;
	}

	/**
	 * @param docente the docente to set
	 */
	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	/**
	 * @return the grupoIdn
	 */
	public long getGrupoIdn() {
		return grupoIdn;
	}

	/**
	 * @param grupoIdn the grupoIdn to set
	 */
	public void setGrupoIdn(long grupoIdn) {
		this.grupoIdn = grupoIdn;
	}

	/**
	 * @return the grupo
	 */
	public Grupo getGrupo() {
		return grupo;
	}

	/**
	 * @param grupo the grupo to set
	 */
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	/**
	 * @return the tiempoTotal
	 */
	public double getTiempoTotal() {
		return tiempoTotal;
	}

	/**
	 * @param tiempoTotal the tiempoTotal to set
	 */
	public void setTiempoTotal(double tiempoTotal) {
		this.tiempoTotal = tiempoTotal;
	}

	/**
	 * @return the usuarioActualizacion
	 */
	public String getUsuarioActualizacion() {
		return usuarioActualizacion;
	}

	/**
	 * @param usuarioActualizacion the usuarioActualizacion to set
	 */
	public void setUsuarioActualizacion(String usuarioActualizacion) {
		this.usuarioActualizacion = usuarioActualizacion;
	}

	/**
	 * @return the fechaActualizacion
	 */
	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}

	/**
	 * @param fechaActualizacion the fechaActualizacion to set
	 */
	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}
}

package com.proint1.udea.administracion.entidades.dependencias;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Entidad principal del sistema que representa el ente padre como por ejemplo Universidad de Antioquia
 * @author Juan Cardona
 * @since 24/05/2014
 */
public class UnidadAcademica implements java.io.Serializable {

	/**serialVersionUID**/
	private static final long serialVersionUID = -6546488802172451751L;
	/**Identificador unico*/
	private long idn;
	/**Nombre de la Unidad*/
	private String nombre;
	/**usario que modifica la entidad*/
	private String usuarioActualizacion;
	/**Fecha de modificación de la entidad*/
	private Date fechaActualizacion;
	/**Set de las diferentes dependencias Academicas*/
	private Set<DependenciaAcademica> dependenciasAcademicasSet = new HashSet<DependenciaAcademica>(0);
	
	
	
	/**
	 * 
	 */
	public UnidadAcademica() {
		super();
		this.usuarioActualizacion = "SYSTEM";
		this.fechaActualizacion = new Date();
	}

	
	
	/**
	 * @param nombre
	 */
	public UnidadAcademica(String nombre) {
		super();
		this.nombre = nombre;
		this.usuarioActualizacion = "SYSTEM";
		this.fechaActualizacion = new Date();
	}



	/**
	 * @param nombre
	 * @param usuarioActualizacion
	 * @param fechaActualizacion
	 */
	public UnidadAcademica(String nombre, String usuarioActualizacion,Date fechaActualizacion) {
		super();
		this.nombre = nombre;
		this.usuarioActualizacion = usuarioActualizacion;
		this.fechaActualizacion = fechaActualizacion;
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
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	/**
	 * @return the dependenciasAcademicasSet
	 */
	public Set<DependenciaAcademica> getDependenciasAcademicasSet() {
		return dependenciasAcademicasSet;
	}

	/**
	 * @param dependenciasAcademicasSet the dependenciasAcademicasSet to set
	 */
	public void setDependenciasAcademicasSet(Set<DependenciaAcademica> dependenciasAcademicasSet) {
		this.dependenciasAcademicasSet = dependenciasAcademicasSet;
	}
	
}

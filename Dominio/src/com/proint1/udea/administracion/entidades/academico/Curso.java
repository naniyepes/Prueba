package com.proint1.udea.administracion.entidades.academico;

import java.util.Date;

import com.proint1.udea.administracion.entidades.dependencias.DependenciaAcademica;


/**
 * Esta entidad representa el objeto Curso el cual esta asociado
 * a una {@link DependenciaAcademica}
 * 
 * @author Daniela - Danilo - Juan
 * @since 29/05/2014
 */
public class Curso implements java.io.Serializable {

	
	/**serialVersionUID**/
	private static final long serialVersionUID = 457441177668614060L;


	/**ID que identifica al curso*/
	private long idn;
	/**Dependencia Academica*/
	private DependenciaAcademica dependenciaAcademica;
	/**IDN de la Dependencia Academica*/
	private long dependenciaAcademicaIDN;
	/**ID propio de la dependencia por ejemplo IDS-103 **/
	private String idCurso;
	/**Nombre del curso	 **/
	private String nombre;
	/**Usuario que modifica la entidad*/
	private String usuarioActualizacion;
	/**Fecha de modificación de la entidad*/
	private Date fechaActualizacion;
	
	
	public Curso() {
		super();
		this.fechaActualizacion = new Date();
		this.usuarioActualizacion = "SYSTEM";
	}

	/**
	 * @param dependenciaAcademicaIDN
	 * @param idCurso
	 * @param nombre
	 */
	public Curso(long dependenciaAcademicaIDN, String idCurso, String nombre) {
		super();
		this.dependenciaAcademicaIDN = dependenciaAcademicaIDN;
		this.idCurso = idCurso;
		this.nombre = nombre;
		this.fechaActualizacion = new Date();
		this.usuarioActualizacion = "SYSTEM";
	}

	/**
	 * @param dependenciaAcademica
	 * @param idCurso
	 * @param nombre
	 */
	public Curso(DependenciaAcademica dependenciaAcademica, String idCurso,
			String nombre) {
		super();
		this.dependenciaAcademica = dependenciaAcademica;
		this.idCurso = idCurso;
		this.nombre = nombre;
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
	 * @return the dependenciaAcademica
	 */
	public DependenciaAcademica getDependenciaAcademica() {
		return dependenciaAcademica;
	}


	/**
	 * @param dependenciaAcademica the dependenciaAcademica to set
	 */
	public void setDependenciaAcademica(DependenciaAcademica dependenciaAcademica) {
		this.dependenciaAcademica = dependenciaAcademica;
	}


	/**
	 * @return the dependenciaAcademicaIDN
	 */
	public long getDependenciaAcademicaIDN() {
		return dependenciaAcademicaIDN;
	}


	/**
	 * @param dependenciaAcademicaIDN the dependenciaAcademicaIDN to set
	 */
	public void setDependenciaAcademicaIDN(long dependenciaAcademicaIDN) {
		this.dependenciaAcademicaIDN = dependenciaAcademicaIDN;
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
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}

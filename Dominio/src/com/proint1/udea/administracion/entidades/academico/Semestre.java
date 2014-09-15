package com.proint1.udea.administracion.entidades.academico;
// default package
// Generated 10-may-2014 11:58:30 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

import com.proint1.udea.administracion.entidades.dependencias.DependenciaAcademica;

/**
 * Esta entidad representa el objeto Semestre el cual esta asociado
 * a una {@link DependenciaAcademica}
 * 
 * @author Daniela - Danilo - Juan
 * @since 29/05/2014
 */
public class Semestre implements java.io.Serializable {

	/**serialVersionUID**/
	private static final long serialVersionUID = -2035605387256722705L;
	/**ID que identifica al semestre*/
	private long idn;
	/**Dependencia Academica*/
	private DependenciaAcademica dependenciaAcademica;
	/**IDN de la Dependencia Academica*/
	private long dependenciaAcademicaIDN;
	/**Código del estado del semestre*/
	private String estadoSemestreIdn;
	/**Estado del semestre*/
	private EstadoSemestre estadoSemestre;
	/**Año*/
	private int agno;
	/**Periodo ejemplo: 1 */
	private int periodo;
	/**Usuario que modifica la entidad*/
	private String usuarioActualizacion;
	/**Fecha de modificación de la entidad*/
	private Date fechaActualizacion;
	/**
	 * 
	 */
	public Semestre() {
		super();
		this.fechaActualizacion = new Date();
		this.usuarioActualizacion = "SYSTEM";
	}
	/**
	 * @param dependenciaAcademica
	 * @param estadoSemestre
	 * @param agno
	 * @param periodo
	 */
	public Semestre(DependenciaAcademica dependenciaAcademica,
			EstadoSemestre estadoSemestre, int agno, int periodo) {
		super();
		this.dependenciaAcademica = dependenciaAcademica;
		this.estadoSemestre = estadoSemestre;
		this.agno = agno;
		this.periodo = periodo;
		this.fechaActualizacion = new Date();
		this.usuarioActualizacion = "SYSTEM";
	}
	/**
	 * @param dependenciaAcademicaIDN
	 * @param estadoSemestreIdn
	 * @param agno
	 * @param periodo
	 */
	public Semestre(long dependenciaAcademicaIDN, String estadoSemestreIdn,
			int agno, int periodo) {
		super();
		this.dependenciaAcademicaIDN = dependenciaAcademicaIDN;
		this.estadoSemestreIdn = estadoSemestreIdn;
		this.agno = agno;
		this.periodo = periodo;
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
	 * @return the estadoSemestreIdn
	 */
	public String getEstadoSemestreIdn() {
		return estadoSemestreIdn;
	}
	/**
	 * @param estadoSemestreIdn the estadoSemestreIdn to set
	 */
	public void setEstadoSemestreIdn(String estadoSemestreIdn) {
		this.estadoSemestreIdn = estadoSemestreIdn;
	}
	/**
	 * @return the estadoSemestre
	 */
	public EstadoSemestre getEstadoSemestre() {
		return estadoSemestre;
	}
	/**
	 * @param estadoSemestre the estadoSemestre to set
	 */
	public void setEstadoSemestre(EstadoSemestre estadoSemestre) {
		this.estadoSemestre = estadoSemestre;
	}
	/**
	 * @return the agno
	 */
	public int getAgno() {
		return agno;
	}
	/**
	 * @param agno the agno to set
	 */
	public void setAgno(int agno) {
		this.agno = agno;
	}
	/**
	 * @return the periodo
	 */
	public int getPeriodo() {
		return periodo;
	}
	/**
	 * @param periodo the periodo to set
	 */
	public void setPeriodo(int periodo) {
		this.periodo = periodo;
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

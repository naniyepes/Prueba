package com.proint1.udea.actividad.entidades;


import java.util.Date;


/**
 * Reporte actividad de los diferentes docentes
 * @author Juan Cardona
 * @since 30/05/2014
 */
public class ReporteActividad implements java.io.Serializable {

	/**serialVersionUID**/
	private static final long serialVersionUID = 7123159070174236124L;
	/**Idn*/
	private long idn;
	/**Tipo de actividad idn*/
	private long tipoActividadIdn;
	/**Tipo de actividad*/
	private TipoActividad tipoActividad;
	/**docente grupo idn*/
	private long docenteGrupoIdn;
	/**Docente grupo*/
	private DocenteGrupo docenteGrupo;
	/**Fecha de registro*/
	private Date fechaRegistro;
	/**Descripción de la actividad realizada*/
	private String descripcionActividad;
	/**Tiempo invertido en la actividad*/
	private double tiempo;
	/**Usuario que modifica la entidad*/
	private String usuarioActualizacion;
	/**Fecha de modificación de la entidad*/
	private Date fechaActualizacion;
	/**
	 * 
	 */
	public ReporteActividad() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param tipoActividadIdn
	 * @param docenteGrupoIdn
	 * @param fechaRegistro
	 * @param descripcionActividad
	 * @param tiempo
	 */
	public ReporteActividad(long tipoActividadIdn, long docenteGrupoIdn,Date fechaRegistro, String descripcionActividad, double tiempo) {
		super();
		this.tipoActividadIdn = tipoActividadIdn;
		this.docenteGrupoIdn = docenteGrupoIdn;
		this.fechaRegistro = fechaRegistro;
		this.descripcionActividad = descripcionActividad;
		this.tiempo = tiempo;
	}
	/**
	 * @param tipoActividad
	 * @param docenteGrupo
	 * @param fechaRegistro
	 * @param descripcionActividad
	 * @param tiempo
	 */
	public ReporteActividad(TipoActividad tipoActividad,DocenteGrupo docenteGrupo, Date fechaRegistro,String descripcionActividad, double tiempo) {
		super();
		this.tipoActividad = tipoActividad;
		this.docenteGrupo = docenteGrupo;
		this.fechaRegistro = fechaRegistro;
		this.descripcionActividad = descripcionActividad;
		this.tiempo = tiempo;
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
	 * @return the tipoActividadIdn
	 */
	public long getTipoActividadIdn() {
		return tipoActividadIdn;
	}
	/**
	 * @param tipoActividadIdn the tipoActividadIdn to set
	 */
	public void setTipoActividadIdn(long tipoActividadIdn) {
		this.tipoActividadIdn = tipoActividadIdn;
	}
	/**
	 * @return the tipoActividad
	 */
	public TipoActividad getTipoActividad() {
		return tipoActividad;
	}
	/**
	 * @param tipoActividad the tipoActividad to set
	 */
	public void setTipoActividad(TipoActividad tipoActividad) {
		this.tipoActividad = tipoActividad;
	}
	/**
	 * @return the docenteGrupoIdn
	 */
	public long getDocenteGrupoIdn() {
		return docenteGrupoIdn;
	}
	/**
	 * @param docenteGrupoIdn the docenteGrupoIdn to set
	 */
	public void setDocenteGrupoIdn(long docenteGrupoIdn) {
		this.docenteGrupoIdn = docenteGrupoIdn;
	}
	/**
	 * @return the docenteGrupo
	 */
	public DocenteGrupo getDocenteGrupo() {
		return docenteGrupo;
	}
	/**
	 * @param docenteGrupo the docenteGrupo to set
	 */
	public void setDocenteGrupo(DocenteGrupo docenteGrupo) {
		this.docenteGrupo = docenteGrupo;
	}
	/**
	 * @return the fechaRegistro
	 */
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	/**
	 * @param fechaRegistro the fechaRegistro to set
	 */
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	/**
	 * @return the descripcionActividad
	 */
	public String getDescripcionActividad() {
		return descripcionActividad;
	}
	/**
	 * @param descripcionActividad the descripcionActividad to set
	 */
	public void setDescripcionActividad(String descripcionActividad) {
		this.descripcionActividad = descripcionActividad;
	}
	/**
	 * @return the tiempo
	 */
	public double getTiempo() {
		return tiempo;
	}
	/**
	 * @param tiempo the tiempo to set
	 */
	public void setTiempo(double tiempo) {
		this.tiempo = tiempo;
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

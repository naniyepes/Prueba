package com.proint1.udea.administracion.entidades.terceros;
// default package
// Generated 10-may-2014 11:58:30 by Hibernate Tools 3.4.0.CR1

import java.util.Date;


/**
 * INSERT INTO "PROINT1"."TB_ADM_TIPOIDENTIFICACION" (NB_IDN, DT_ADTFECHA, VR_ADTUSUARIO, VR_DESCRIPCION) VALUES ('1', TO_DATE('2014-06-20 17:51:31', 'YYYY-MM-DD HH24:MI:SS'), 'ADMIN', 'CEDULA')
 * TODO FUNCIONALIDAD
 * @author Juan Cardona
 * @since 21/06/2014
 */
public class TipoIdentificacion implements java.io.Serializable {

	
	/**serialVersionUID**/
	private static final long serialVersionUID = 3690527379874971648L;
	/**Identificador unico*/
	private long idn;
	/**Descripcion del tipo de identificacion*/
	private String descripcion;
	/**Fecha de actualizaci{on del registro*/
	private Date fechaActualizacion;
	/**Usuario que actualiza el registro*/
	private String usuarioActualizacion;
	
	/**
	 * 
	 */
	public TipoIdentificacion() {
		super();
		this.fechaActualizacion = new Date();
		this.usuarioActualizacion = "SYSTEM";
	}
	
	/**
	 * @param descripcion
	 */
	public TipoIdentificacion(String descripcion) {
		super();
		this.descripcion = descripcion;
		this.fechaActualizacion = new Date();
		this.usuarioActualizacion = "SYSTEM";
	}
	
	
	
	
	/**
	 * @param descripcion
	 * @param fechaActualizacion
	 * @param usuarioActualizacion
	 */
	public TipoIdentificacion(String descripcion, Date fechaActualizacion,String usuarioActualizacion) {
		super();
		this.descripcion = descripcion;
		this.fechaActualizacion = fechaActualizacion;
		this.usuarioActualizacion = usuarioActualizacion;
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
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
}

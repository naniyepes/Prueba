package com.proint1.udea.administracion.entidades.terceros;

import java.util.Date;
// Generated 10-may-2014 11:58:30 by Hibernate Tools 3.4.0.CR1


/**
 * Entidad que representa los Estudiantes de la universidad esxtendiendo todos los atriutos de {@link Persona}
 * @author Juan Cardona
 * @since 24/05/2014
 */
public class Estudiante extends Persona {

	/**serialVersionUID**/
	private static final long serialVersionUID = -3147505155535911241L;
	
	/** Codigo interno suministrado por la udea*/
	private String codigointernno;

	/**
	 * 
	 */
	public Estudiante() {
		super();
	}

	/**
	 * @param tipoidentificacionIdn
	 * @param nombres
	 * @param apellidos
	 * @param identificacion
	 * @param usuarioActualizacion
	 * @param fechaActualizacion
	 */
	public Estudiante(long tipoidentificacionIdn, String nombres,String apellidos, String identificacion,
			String usuarioActualizacion, Date fechaActualizacion) {
		super(tipoidentificacionIdn, nombres, apellidos, identificacion,usuarioActualizacion, fechaActualizacion);
	}

	/**
	 * @param tipoidentificacionIdn
	 * @param nombres
	 * @param apellidos
	 * @param identificacion
	 */
	public Estudiante(long tipoidentificacionIdn, String nombres,String apellidos, String identificacion) {
		super(tipoidentificacionIdn, nombres, apellidos, identificacion);
	}

	/**
	 * @return the codigointernno
	 */
	public String getCodigointernno() {
		return codigointernno;
	}

	/**
	 * @param codigointernno the codigointernno to set
	 */
	public void setCodigointernno(String codigointernno) {
		this.codigointernno = codigointernno;
	}

	
	
	
}

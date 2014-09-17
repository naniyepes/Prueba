package com.proint1.udea.administracion.entidades.terceros;

import java.util.Date;


/**
 * Entidad que representa los Docentes de la universidad los cuales extiendes sus caracteristicas de {@link Persona}
 * @author Juan Cardona
 * @since 24/05/2014
 */
public class Docente extends Persona {

	/**serialVersionUID **/
	private static final long serialVersionUID = 3738346166234186152L;
	
	/**Registro profesional*/
	private String registroProfesional;
	
	/**
	 * 
	 */
	public Docente() {
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
	public Docente(long tipoidentificacionIdn, String nombres,String apellidos, String identificacion,String usuarioActualizacion, Date fechaActualizacion) {
		super(tipoidentificacionIdn, nombres, apellidos, identificacion,usuarioActualizacion, fechaActualizacion);
	}
	
	/**
	 * @param tipoidentificacionIdn
	 * @param nombres
	 * @param apellidos
	 * @param identificacion
	 */
	public Docente(long tipoidentificacionIdn, String nombres,String apellidos, String identificacion) {
		super(tipoidentificacionIdn, nombres, apellidos, identificacion);
	}
	
	
	/**
	 * @return the registroProfesional
	 */
	public String getRegistroProfesional() {
		return registroProfesional;
	}
	/**
	 * @param registroProfesional the registroProfesional to set
	 */
	public void setRegistroProfesional(String registroProfesional) {
		this.registroProfesional = registroProfesional;
	}
}

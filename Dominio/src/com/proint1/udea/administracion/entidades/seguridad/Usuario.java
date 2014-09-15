package com.proint1.udea.administracion.entidades.seguridad;

import java.util.Date;

import com.proint1.udea.administracion.entidades.terceros.Persona;


/**
 * uusrio del sistema extends de persona
 * @author Juan Cardona
 * @since 30/05/2014
 */
public class Usuario extends Persona{

	/**SemestreDAO.java**/
	private static final long serialVersionUID = 5856336602272034168L;
	/**idn*/
	private long idn;
	/**Login*/
	private String login;
	/**Activo*/
	private boolean activo;
	/**
	 * 
	 */
	public Usuario() {
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
	public Usuario(long tipoidentificacionIdn, String nombres,
			String apellidos, String identificacion,
			String usuarioActualizacion, Date fechaActualizacion) {
		super(tipoidentificacionIdn, nombres, apellidos, identificacion,
				usuarioActualizacion, fechaActualizacion);
		// TODO Auto-generated constructor stub
	}




	/**
	 * @param tipoidentificacionIdn
	 * @param nombres
	 * @param apellidos
	 * @param identificacion
	 */
	public Usuario(long tipoidentificacionIdn, String nombres,
			String apellidos, String identificacion) {
		super(tipoidentificacionIdn, nombres, apellidos, identificacion);
		// TODO Auto-generated constructor stub
	}




	/**
	 * @param login
	 * @param activo
	 */
	public Usuario(String login, boolean activo) {
		super();
		this.login = login;
		this.activo = activo;
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
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}
	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}
	/**
	 * @return the activo
	 */
	public boolean isActivo() {
		return activo;
	}
	/**
	 * @param activo the activo to set
	 */
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
}

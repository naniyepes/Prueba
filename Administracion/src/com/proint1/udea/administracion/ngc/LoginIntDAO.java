package com.proint1.udea.administracion.ngc;

import com.proint1.udea.administracion.entidades.seguridad.Usuario;

/**
 * Interface para login 
 * @author Juan Cardona
 * @since 22/06/2014
 */
public interface LoginIntDAO {

	
	/**
	 * Valdia el usuario en la bases de datos
	 * @param usuario
	 * @param password
	 * @return
	 */
	public Usuario validarUsuario(String usuario,String password);
	
}

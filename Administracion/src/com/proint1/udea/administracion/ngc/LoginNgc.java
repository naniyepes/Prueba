/**
 * 
 */
package com.proint1.udea.administracion.ngc;

import com.proint1.udea.administracion.dao.terceros.PersonaProyDAO;
import com.proint1.udea.administracion.entidades.seguridad.Usuario;
import com.proint1.udea.administracion.entidades.terceros.Docente;

/**
 * Clse de negocio para Logi
 * @author Juan Cardona
 * @since 22/06/2014
 */
public class LoginNgc implements LoginIntDAO {

	/**
	 * Dao para persona
	 */
	private PersonaProyDAO personaProyDAO;
	
	@Override
	public Usuario validarUsuario(String usuario, String password) {
		return getPersonaProyDAO().validarUsuario(usuario,password);
	}


	/**
	 * @return the personaProyDAO
	 */
	public PersonaProyDAO getPersonaProyDAO() {
		return personaProyDAO;
	}


	/**
	 * @param personaProyDAO the personaProyDAO to set
	 */
	public void setPersonaProyDAO(PersonaProyDAO personaProyDAO) {
		this.personaProyDAO = personaProyDAO;
	}


	/**
	 * Busca un docente por la identificación
	 * @param identificacion
	 */
	public Docente buscarDocente(String identificacion) {
		return personaProyDAO.buscarDocente(identificacion);
	}

}

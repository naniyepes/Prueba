package com.proint1.udea.administracion.entidades.terceros;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.proint1.udea.TestBase;
import com.proint1.udea.administracion.dao.terceros.PersonaProyDAO;
import com.proint1.udea.administracion.entidades.seguridad.Usuario;

/**
 * Test para la entidad {@link Persona}
 * @author Juan Cardona
 * @since 24/05/2014
 */
public class PersonaTest extends TestBase {

	/**
	 * Dao para el tipo de actividades
	 */
	@Autowired
	private PersonaProyDAO personaProyDAO;
	


	/**
	 * Test que consulta todas las personas del sistema
	 */
	@Test
	public void getPersonasList() {
		List<Persona> personaList =  personaProyDAO.getPersonas();
		for (Persona persona : personaList) {
			System.out.println("idn" + persona.getIdn() + " Nombre:" + persona.getNombreCompleto());
		}
	}

	
	/**
	 * Test para crear una {@link Persona}
	 */
	@Test
	public void crearPersona() {
		Persona persona = new Persona(1,"Juan Carlos","Cardona P","71555825");
		persona.setNombreCompleto("Juan Carlos Cardona P");
		personaProyDAO.almacenarPersona(persona);
	}
	
	/**
	 * Test para crear un {@link Docente} con herencia de {@link Persona}
	 */
	@Test
	public void crearDocente() {
		Persona persona = new Docente(1,"Juan Carlos","Cardona P","71555825");
		persona.setNombreCompleto("Juan Carlos Cardona P");
		personaProyDAO.almacenarPersona(persona);
	}
	
	/***
	 * Test para crear un {@link Docente} 
	 */
	@Test
	public void crearDocente2() {
		Docente docente = new Docente(1,"Pedro Pablo","Montoya","7551555825");
		docente.setNombreCompleto("Pedro Pablo Montoya P");
		personaProyDAO.almacenarPersona(docente);
	}
	
	
	/***
	 * Test para crear un {@link Docente} 
	 */
	@Test
	public void crearEstudiante() {
		Estudiante estudiante = new Estudiante(1,"Ernesto Javier","Amaya","815");
		estudiante.setNombreCompleto("Ernesto Javier Amaya");
		personaProyDAO.almacenarPersona(estudiante);
	}
	
	
	/***
	 * Test para crear un {@link Usu} 
	 */
	@Test
	public void crearUsuario() {
		Usuario usuario = new Usuario(1,"Ernesto Javier","Amaya","815");
		usuario.setNombreCompleto("Ernesto Javier Amaya");
		usuario.setActivo(true);
		usuario.setLogin("pepe");
		personaProyDAO.almacenarPersona(usuario);
	}
	
	/**
	 * @return the personaProyDao
	 */
	public PersonaProyDAO getPersonaProyDao() {
		return personaProyDAO;
	}

	/**
	 * @param personaProyDao the personaProyDao to set
	 */
	public void setPersonaProyDao(PersonaProyDAO personaProyDAO) {
		this.personaProyDAO = personaProyDAO;
	}
	
	
}

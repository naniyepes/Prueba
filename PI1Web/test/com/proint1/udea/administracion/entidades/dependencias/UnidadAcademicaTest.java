package com.proint1.udea.administracion.entidades.dependencias;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.proint1.udea.TestBase;
import com.proint1.udea.administracion.dao.dependencias.UnidadAcademicaDAO;
import com.proint1.udea.administracion.entidades.terceros.Persona;



/**
 * Test de la entidad {@link UnidadAcademica}
 * @author Juan Cardona
 * @since 24/05/2014
 */
public class UnidadAcademicaTest extends TestBase {

	@Autowired
	private UnidadAcademicaDAO unidadAcademicaDAO;
	

	/**
	 * Test que consulta todas las personas del sistema
	 */
	@Test
	public void getUnidadAcademicaList() {
		List<UnidadAcademica> unidadAcademicaList =  unidadAcademicaDAO.getUnidadesAcademicas();
		for (UnidadAcademica unidadAcademica : unidadAcademicaList) {
			System.out.println("idn" + unidadAcademica.getIdn() + " Nombre:" + unidadAcademica.getNombre());
		}
	}
	
	/**
	 * Test para crear una {@link Persona}
	 */
	@Test
	public void crearUnidadAcademicaa() {
		UnidadAcademica unidadAcademica = new UnidadAcademica("Universidad de Antioquia");
		unidadAcademicaDAO.almacenarUnidadAcademica(unidadAcademica );
	}
	
	/**
	 * @return the unidadAcademicaDao
	 */
	public UnidadAcademicaDAO getUnidadAcademicaDao() {
		return unidadAcademicaDAO;
	}

	/**
	 * @param unidadAcademicaDao the unidadAcademicaDao to set
	 */
	public void setUnidadAcademicaDao(UnidadAcademicaDAO unidadAcademicaDao) {
		this.unidadAcademicaDAO = unidadAcademicaDao;
	}

}

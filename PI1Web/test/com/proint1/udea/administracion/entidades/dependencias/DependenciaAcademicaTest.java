package com.proint1.udea.administracion.entidades.dependencias;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.proint1.udea.TestBase;
import com.proint1.udea.administracion.dao.dependencias.DependenciaAcademicaDAO;

/**
 * Test para la entidad {@link DependenciaAcademica}
 * @author Juan Cardona
 * @since 24/05/2014
 */
public class DependenciaAcademicaTest extends TestBase {

	@Autowired
	private DependenciaAcademicaDAO dependenciaAcademicaDAO;
	
	/**
	 * Test que consulta todas las personas del sistema
	 */
	@Test
	public void getDependenciaAcademicasList() {
		List<DependenciaAcademica> dependenciaAcademicaList =  dependenciaAcademicaDAO.getDependenciaAcademicasList();
		for (DependenciaAcademica dependenciaAcademica : dependenciaAcademicaList) {
			System.out.println("idn" + dependenciaAcademica.getIdn() + " Nombre:" + dependenciaAcademica.getNombre());
		}
	}
	
	/**
	 * Test para crear una {@link DependenciaAcademica}
	 */
	@Test
	public void crearDependenciaAcademica() {
		DependenciaAcademica dependenciaAcademica = new DependenciaAcademica("Faculta de Ingenieria", 1, "FAC");
		dependenciaAcademicaDAO.almacenarDependenciaAcademica(dependenciaAcademica);
	}
	
	/**
	 * Crea una {@link DependenciaAcademica} con varias {@link DependenciaAcademica} hijas
	 */
	@Test
	public void crearDependenciaAcademicaConHijos() {
		DependenciaAcademica dependenciaAcademica = new DependenciaAcademica("Faculta de Ingenieria", 1, "FAC");
		dependenciaAcademicaDAO.almacenarDependenciaAcademica(dependenciaAcademica);
		for (int i = 1; i <= 10; i++) {
			DependenciaAcademica dependenciaAcademicaHija = new DependenciaAcademica("Dependencia Nro:" + i, 1, "FAC",dependenciaAcademica.getIdn());
			dependenciaAcademicaDAO.almacenarDependenciaAcademica(dependenciaAcademicaHija);
		}
	}
	
	
	/**
	 * @return the dependenciaAcademicaDAO
	 */
	public DependenciaAcademicaDAO getDependenciaAcademicaDAO() {
		return dependenciaAcademicaDAO;
	}

	/**
	 * @param dependenciaAcademicaDAO the dependenciaAcademicaDAO to set
	 */
	public void setDependenciaAcademicaDAO(DependenciaAcademicaDAO dependenciaAcademicaDAO) {
		this.dependenciaAcademicaDAO = dependenciaAcademicaDAO;
	}
	
}

package com.proint1.udea.administracion.entidades.academico;




import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.proint1.udea.TestBase;
import com.proint1.udea.administracion.dao.CursoDAO;
import com.proint1.udea.administracion.entidades.academico.Curso;

/**
 * Test para la entidad {@link Curso}
 * @author Daniela Yepes y Danilo Mejia
 * @since  25/05/2014
 * @version 1.0
 */


public class CursoTest extends TestBase {

	@Autowired
	private CursoDAO cursoDAO;
	
	/**
	 * Test que consulta todas las personas del sistema
	 */
	@Test
	public void getCursoList() {
		List<Curso> CursoList =  cursoDAO.getCursoList();
		for (Curso curso : CursoList) {
			System.out.println("idn: " + curso.getIdn()+ " Nombre:" + curso.getNombre());
		}
	}
	
	/**
	 * Test para crear una {@link Curso}
	 */
	@Test
	public void crearCurso() {
		Curso curso = new Curso(1, "IDS-103", "Proyecto Integrador I");
		cursoDAO.almacenarCurso(curso);
	}
	
	/**
	 * @return the CursoDao
	 */
	public CursoDAO getCursoDao() {
		return cursoDAO;
	}

	/**
	 * @param CursoDao the CursoDao to set
	 */
	public void setCursoDao(CursoDAO CursoDAO) {
		this.cursoDAO = CursoDAO;
	}

}

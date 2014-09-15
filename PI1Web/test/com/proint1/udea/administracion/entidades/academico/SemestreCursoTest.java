package com.proint1.udea.administracion.entidades.academico;




import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.proint1.udea.TestBase;
import com.proint1.udea.administracion.dao.SemestreCursoDAO;
import com.proint1.udea.administracion.entidades.academico.SemestreCurso;

/**
 * Test para la entidad {@link SemestreCurso}
 * @author Daniela Yepes y Danilo Mejia
 * @since  25/05/2014
 * @version 1.0
 */


public class SemestreCursoTest extends TestBase {

	@Autowired
	private SemestreCursoDAO semestreCursoDAO;
	
	/**
	 * Test que consulta todas modalidades de cursos
	 */
	@Test
	public void getSemestreCursoList() {
		List<SemestreCurso> semestreCursoList =  semestreCursoDAO.getSemestreCursoList();
		for (SemestreCurso semestreCurso : semestreCursoList) {
			System.out.println("idn: " + semestreCurso.getIdn()+ " Curso:" + semestreCurso.getCursoIDN() + " Modalidad:" + semestreCurso.getModalidadCursoIDN());
		}
	}
	
	/**
	 * Test para crear una {@link SemestreCurso}
	 */
	@Test
	public void crearSemestreCurso() {
		SemestreCurso semestreCurso = new SemestreCurso(1, 1, "VIR");
		semestreCursoDAO.almacenarSemestreCurso(semestreCurso);
	}
	
	/**
	 * @return the SemestreCursoDao
	 */
	public SemestreCursoDAO getSemestreCursoDao() {
		return semestreCursoDAO;
	}

	/**
	 * @param SemestreCursoDao the SemestreCursoDao to set
	 */
	public void setSemestreCursoDao(SemestreCursoDAO SemestreCursoDAO) {
		this.semestreCursoDAO = SemestreCursoDAO;
	}

}

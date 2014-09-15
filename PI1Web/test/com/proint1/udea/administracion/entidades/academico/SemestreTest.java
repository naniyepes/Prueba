package com.proint1.udea.administracion.entidades.academico;




import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.proint1.udea.TestBase;
import com.proint1.udea.administracion.dao.SemestreDAO;
import com.proint1.udea.administracion.entidades.academico.Semestre;

/**
 * Test para la entidad {@link Semestre}
 * @author Daniela Yepes y Danilo Mejia
 * @since  25/05/2014
 * @version 1.0
 */


public class SemestreTest extends TestBase {

	@Autowired
	private SemestreDAO semestreDAO;
	
	/**
	 * Test que consulta todas las personas del sistema
	 */
	@Test
	public void getSemestreList() {
		List<Semestre> semestreList =  semestreDAO.getSemestreList();
		for (Semestre Semestre : semestreList) {
			System.out.println("idn: " + Semestre.getIdn()+ " Dependencia Academica:" + Semestre.getDependenciaAcademicaIDN()+ " Año:" + Semestre.getAgno() + 
					" Estado semestre:" + Semestre.getEstadoSemestreIdn() + " Periodo:" + Semestre.getPeriodo());
		}
	}
	
	/**
	 * Test para crear una {@link Semestre}
	 */
	@Test
	public void crearSemestre() {
		Semestre semestre = new Semestre(1, "ACT", 2014, 1);
		semestreDAO.almacenarSemestre(semestre);
	}
	
	/**
	 * @return the SemestreDao
	 */
	public SemestreDAO getSemestreDao() {
		return semestreDAO;
	}

	/**
	 * @param SemestreDao the SemestreDao to set
	 */
	public void setSemestreDao(SemestreDAO SemestreDAO) {
		this.semestreDAO = SemestreDAO;
	}

}

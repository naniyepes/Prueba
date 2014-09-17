package com.proint1.udea.administracion.entidades.academico;




import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.proint1.udea.TestBase;
import com.proint1.udea.administracion.dao.ModalidadCursoDAO;
import com.proint1.udea.administracion.entidades.academico.ModalidadCurso;

/**
 * Test para la entidad {@link ModalidadCurso}
 * @author Daniela Yepes y Danilo Mejia
 * @since  25/05/2014
 * @version 1.0
 */


public class ModalidadCursoTest extends TestBase {

	@Autowired
	private ModalidadCursoDAO modalidadCursoDAO;
	
	/**
	 * Test que consulta todas modalidades de cursos
	 */
	@Test
	public void getModalidadCursoList() {
		List<ModalidadCurso> modalidadCursoList =  modalidadCursoDAO.getModalidadCursoList();
		for (ModalidadCurso modalidadCurso : modalidadCursoList) {
			System.out.println("idn: " + modalidadCurso.getIdn()+ " Descripción:" + modalidadCurso.getDescripcion());
		}
	}
	
	/**
	 * Test para crear una {@link ModalidadCurso}
	 */
	@Test
	public void crearModalidadCurso() {
		ModalidadCurso modalidadCurso = new ModalidadCurso("VIR", "Virtual");
		modalidadCursoDAO.almacenarModalidadCurso(modalidadCurso);
	}
	
	/**
	 * @return the ModalidadCursoDao
	 */
	public ModalidadCursoDAO getModalidadCursoDao() {
		return modalidadCursoDAO;
	}

	/**
	 * @param ModalidadCursoDao the ModalidadCursoDao to set
	 */
	public void setModalidadCursoDao(ModalidadCursoDAO ModalidadCursoDAO) {
		this.modalidadCursoDAO = ModalidadCursoDAO;
	}

}

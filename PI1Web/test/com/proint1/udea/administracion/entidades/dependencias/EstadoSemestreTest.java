package com.proint1.udea.administracion.entidades.dependencias;


import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.proint1.udea.TestBase;
import com.proint1.udea.administracion.dao.EstadoSemestreDAO;
import com.proint1.udea.administracion.entidades.academico.EstadoSemestre;

/**
 * Test para la entidad {@link EstadoSemestre}
 * @author Daniela Yepes y Danilo Mejia
 * @since  25/05/2014
 * @version 1.0
 */


public class EstadoSemestreTest extends TestBase {

	@Autowired
	private EstadoSemestreDAO estadoSemestreDAO;
	
	/**
	 * Test que consulta todas las personas del sistema
	 */
	@Test
	public void getEstadoSemestreList() {
		List<EstadoSemestre> estadoSemestreList =  estadoSemestreDAO.getEstadoSemestre();
		for (EstadoSemestre estadoSemestre : estadoSemestreList) {
			System.out.println("idn" + estadoSemestre.getIdn() + " Descripcion:" + estadoSemestre.getDescripcion());
		}
	}
	
	/**
	 * Test para crear una {@link EstadoSemestre}
	 */
	@Test
	public void crearEstadoSemestre() {
		EstadoSemestre estadoSemestre = EstadoSemestre.ACTIVO;
		estadoSemestreDAO.almacenarEstadoSemestre(estadoSemestre);
		
		EstadoSemestre.buscarPorCodigomaryKey(EstadoSemestre.ACTIVO_CODE);
		
		estadoSemestre = EstadoSemestre.INACTIVO;
		estadoSemestreDAO.almacenarEstadoSemestre(estadoSemestre);
	}
	
	/**
	 * @return the estadoSemestreDao
	 */
	public EstadoSemestreDAO getEstadoSemestreDao() {
		return estadoSemestreDAO;
	}

	/**
	 * @param estadoSemestreDao the estadoSemestreDao to set
	 */
	public void setEstadoSemestreDao(EstadoSemestreDAO estadoSemestreDAO) {
		this.estadoSemestreDAO = estadoSemestreDAO;
	}

}

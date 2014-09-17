package com.proint1.udea.actividad.entidades;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.proint1.udea.TestBase;
import com.proint1.udea.actividad.dao.ReporteActividadDAO;
import com.proint1.udea.administracion.entidades.terceros.Persona;

/**
 * Test para la entidad {@link ReporteActividad}
 * @author Juan Cardona
 * @since 30/05/2014
 */
public class ReporteActividadTest extends TestBase {

	@Autowired
	private ReporteActividadDAO reporteActividadDAO;
	
	
	/**
	 * Test que consulta todas las personas del sistema
	 */
	@Test
	public void getReporteActividadList() {
		List<ReporteActividad> reporteActividadList =  reporteActividadDAO.getReporteActividadList();
		for (ReporteActividad reporteActividad : reporteActividadList) {
			System.out.println("idn" + reporteActividad.getIdn() + " docente:" + reporteActividad.getDocenteGrupoIdn() + " tiempo:" + reporteActividad.getTiempo());
		}
	}
	
	/**
	 * Test para crear una {@link Persona}
	 */
	@Test
	public void crearReporteActividada() {
		ReporteActividad reporteActividad = new ReporteActividad(1,1,new Date(),"Test",25);
		reporteActividadDAO.crearReporteActividad(reporteActividad);
	}
	
}

package com.proint1.udea.actividad.entidades;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.proint1.udea.TestBase;
import com.proint1.udea.actividad.dao.DocenteGrupoDAO;
import com.proint1.udea.administracion.entidades.terceros.Persona;

/**
 * Test para la entidad {@link DocenteGrupo}
 * @author Juan Cardona
 * @since 30/05/2014
 */
public class DocenteGrupoTest extends TestBase {

	@Autowired
	private DocenteGrupoDAO docenteGrupoDAO;
	
	
	/**
	 * Test que consulta todas las personas del sistema
	 */
	@Test
	public void getDocenteGrupoList() {
		List<DocenteGrupo> DocenteGrupoList =  docenteGrupoDAO.getDocenteGrupoList();
		for (DocenteGrupo docenteGrupo : DocenteGrupoList) {
			System.out.println("idn" + docenteGrupo.getIdn() + " grupo:" + docenteGrupo.getGrupoIdn() + " docente:" + docenteGrupo.getGrupoIdn());
		}
	}
	
	/**
	 * Test para crear una {@link Persona}
	 */
	@Test
	public void crearDocenteGrupoa() {
		DocenteGrupo docenteGrupo = new DocenteGrupo(1,1);
		docenteGrupoDAO.crearDocenteGrupo(docenteGrupo);
	}
	
}

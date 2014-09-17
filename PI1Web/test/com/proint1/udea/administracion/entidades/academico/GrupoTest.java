package com.proint1.udea.administracion.entidades.academico;




import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.proint1.udea.TestBase;
import com.proint1.udea.administracion.dao.GrupoDAO;
import com.proint1.udea.administracion.entidades.academico.Grupo;

/**
 * Test para la entidad {@link Grupo}
 * @author Daniela Yepes y Danilo Mejia
 * @since  25/05/2014
 * @version 1.0
 */


public class GrupoTest extends TestBase {

	@Autowired
	private GrupoDAO grupoDAO;
	
	/**
	 * Test que consulta todas las personas del sistema
	 */
	@Test
	public void getGrupoList() {
		List<Grupo> GrupoList =  grupoDAO.getGrupoList();
		for (Grupo Grupo : GrupoList) {
			System.out.println("idn: " + Grupo.getIdn()+ " Numero:" + Grupo.getNumeroGrupo()+" Semestre Curso:" + Grupo.getSemestreCursoIdn());
		}
	}
	
	/**
	 * Test para crear una {@link Grupo}
	 */
	@Test
	public void crearGrupo() {
		Grupo grupo = new Grupo("01", 1);
		grupoDAO.almacenarGrupo(grupo);
	}
	
	/**
	 * @return the GrupoDao
	 */
	public GrupoDAO getGrupoDAO() {
		return grupoDAO;
	}

	/**
	 * @param GrupoDao the GrupoDao to set
	 */
	public void setGrupoDAO(GrupoDAO GrupoDAO) {
		this.grupoDAO = GrupoDAO;
	}

}

package com.proint1.udea.administracion.ngc;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;

import com.proint1.udea.administracion.dao.CursoDAO;
import com.proint1.udea.administracion.dao.CursoDTO;
import com.proint1.udea.administracion.dao.CursoOperacionesDAO;
import com.proint1.udea.administracion.entidades.academico.Curso;
import com.proint1.udea.administracion.entidades.dependencias.DependenciaAcademica;

/**
 * Clase de Negocio para realizar la administración de los cursos
 * @author Daniela Yepes
 * @since 25/05/2014
 */

public class AdministrarCursosNgc implements CursoOperacionesIntDAO,Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5981174028037961878L;
	
	CursoOperacionesDAO cursoOperacionesDAO;	
	
	
	

	private static Logger logger=Logger.getLogger(PersonaNgc.class);
	
	@Override
	public List<CursoDTO> getCursoList() {
		logger.info("consultando cursos");
		return cursoOperacionesDAO.getCursoList();
	}

	
	@Override
	public String almacenarCurso(CursoDTO cursoDTO) {
		logger.info("almacenando cursos");
		cursoOperacionesDAO.almacenarCurso(cursoDTO);
		return null;
	}
	
	@Override
	public List<CursoDTO> buscarCurso(String idCurso) {
		logger.info("buscando cursos");
		return cursoOperacionesDAO.buscarCurso(idCurso);
	}

	@Override
	public void eliminarCurso(CursoDTO cursoDTO) {
		logger.info("eliminando curso");
		cursoOperacionesDAO.eliminarCurso(cursoDTO);
	}
	
	@Override
	public void editarCurso(CursoDTO cursoDTO) {
		logger.info("editando curso");
		cursoOperacionesDAO.editarCurso(cursoDTO);
	}

	/**
	 * @return the cursoOperacionesDAO
	 */
	public CursoOperacionesDAO getCursoOperacionesDAO() {
		return cursoOperacionesDAO;
	}

	/**
	 * @param cursoOperacionesDAO the cursoOperacionesDAO to set
	 */
	public void setCursoOperacionesDAO(CursoOperacionesDAO cursoOperacionesDAO) {
		this.cursoOperacionesDAO = cursoOperacionesDAO;
	}


	@Override
	public List<DependenciaAcademica> getDependenciaList() {
		logger.info("consultando dependencias");
		return cursoOperacionesDAO.getDependenciaList();
	}

	
	
}

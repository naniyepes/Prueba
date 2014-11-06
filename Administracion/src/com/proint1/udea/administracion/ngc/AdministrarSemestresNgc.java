package com.proint1.udea.administracion.ngc;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;

import com.proint1.udea.administracion.dao.SemestreDTO;
import com.proint1.udea.administracion.entidades.academico.Curso;
import com.proint1.udea.administracion.entidades.academico.EstadoSemestre;
import com.proint1.udea.administracion.entidades.dependencias.DependenciaAcademica;

/**
 * Clase de Negocio para realizar la administración de los grupos
 * @author Daniela Yepes - Danilo Mejía
 * @since 19/09/2014
 */

public class AdministrarSemestresNgc implements SemestreOperacionesIntDAO,Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2081122064650467756L;


	SemestreOperacionesIntDAO semestreOperacionesDAO;	
	
	
	private static Logger logger=Logger.getLogger(AdministrarSemestresNgc.class);
	

	@Override
	public List<SemestreDTO> getSemestreList() {
		logger.info("consultando Grupos");
		return semestreOperacionesDAO.getSemestreList();
	}


	@Override
	public String almacenarSemestre(SemestreDTO semestreDTO) {
		logger.info("almacenando semestres");
		semestreOperacionesDAO.almacenarSemestre(semestreDTO);
		return null;
	}


	@Override
	public void eliminarSemestre(SemestreDTO semestreDTO) {
		logger.info("eliminando Semestre");
		semestreOperacionesDAO.eliminarSemestre(semestreDTO);
		
	}


	@Override
	public void editarSemestre(SemestreDTO semestreDTO) {
		semestreOperacionesDAO.editarSemestre(semestreDTO);
		
	}


	@Override
	public List<DependenciaAcademica> getDependenciaList() {
		logger.info("consultando dependencias");
		return semestreOperacionesDAO.getDependenciaList();
	}
	
	@Override
	public List<EstadoSemestre> getEstadoSemestreList() {
		logger.info("consultando Estado Semestre");
		return semestreOperacionesDAO.getEstadoSemestreList();
	}	

	

	public SemestreOperacionesIntDAO getSemestreOperacionesDAO() {
		return semestreOperacionesDAO;
	}


	public void setSemestreOperacionesDAO(
			SemestreOperacionesIntDAO semestreOperacionesDAO) {
		this.semestreOperacionesDAO = semestreOperacionesDAO;
	}	
}

package com.proint1.udea.administracion.ngc;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;

import com.proint1.udea.administracion.dao.GrupoDTO;
import com.proint1.udea.administracion.dao.GrupoOperacionesDAO;
import com.proint1.udea.administracion.entidades.academico.Curso;
import com.proint1.udea.administracion.entidades.academico.Semestre;

/**
 * Clase de Negocio para realizar la administración de los grupos
 * @author Daniela Yepes - Danilo Mejía
 * @since 19/09/2014
 */

public class AdministrarGruposNgc implements GrupoOperacionesIntDAO,Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2081122064650467756L;


	GrupoOperacionesDAO grupoOperacionesDAO;	
	
	
	private static Logger logger=Logger.getLogger(PersonaNgc.class);
	
	@Override
	public List<GrupoDTO> getGrupoList() {
		logger.info("consultando Grupos");
		return grupoOperacionesDAO.getGrupoList();
	}

	
	@Override
	public String almacenarGrupo(GrupoDTO grupoDTO) {
		logger.info("almacenando grupos");
		grupoOperacionesDAO.almacenarGrupo(grupoDTO);
		return null;
	}
	
	@Override
	public List<GrupoDTO> buscarGrupo(String idGrupo) {
		logger.info("buscando Grupo");
		return grupoOperacionesDAO.buscarGrupo(idGrupo);
	}

	@Override
	public void eliminarGrupo(GrupoDTO grupoDTO) {
		logger.info("eliminando Grupo");
		grupoOperacionesDAO.eliminarGrupo(grupoDTO);
	}
	
	@Override
	public void editarGrupo(GrupoDTO grupoDTO) {
		logger.info("editando Grupo");
		grupoOperacionesDAO.editarGrupo(grupoDTO);
	}

	
	//Lista los cursos activos por semestre 
	@Override
	public List<Curso> getSemCursoList() {
		logger.info("consultando cursos");
		return grupoOperacionesDAO.getSemCursoList();
	}
	public GrupoOperacionesDAO getGrupoOperacionesDAO() {
		return grupoOperacionesDAO;
	}


	public void setGrupoOperacionesDAO(GrupoOperacionesDAO grupoOperacionesDAO) {
		this.grupoOperacionesDAO = grupoOperacionesDAO;
	}


	


	
	
	
}

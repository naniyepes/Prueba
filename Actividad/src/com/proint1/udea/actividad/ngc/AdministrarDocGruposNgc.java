package com.proint1.udea.actividad.ngc;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;

import com.proint1.udea.actividad.dao.DocGrupoDTO;
import com.proint1.udea.actividad.dao.DocGrupoOperacionesDAO;
import com.proint1.udea.actividad.entidades.DocenteGrupo;
import com.proint1.udea.administracion.entidades.academico.Curso;
import com.proint1.udea.administracion.entidades.academico.Grupo;
import com.proint1.udea.administracion.entidades.academico.Semestre;
import com.proint1.udea.administracion.entidades.terceros.Docente;

/**
 * Clase de Negocio para realizar la administración de los grupos
 * @author Daniela Yepes - Danilo Mejía
 * @since 19/09/2014
 */

public class AdministrarDocGruposNgc implements DocGrupoOperacionesIntDAO,Serializable  {


	/**
	 * 
	 */
	private static final long serialVersionUID = -7876531093640348927L;
	
	DocGrupoOperacionesDAO docGrupoOperacionesDAO;

	
	@Override
	public List<DocGrupoDTO> getDocGrupoList() {
		return docGrupoOperacionesDAO.getDocGrupoList();
	}


	@Override
	public String almacenarDocGrupo(DocGrupoDTO docGrupoDTO) {
		docGrupoOperacionesDAO.almacenarDocGrupo(docGrupoDTO);
		return null;
	}

/*
	@Override
	public List<DocGrupoDTO> buscarDocGrupo(String idGrupo) {
		// TODO Auto-generated method stub
		return null;
	}*/


	@Override
	public void eliminarDocGrupo(DocGrupoDTO docGrupoDTO) {
		docGrupoOperacionesDAO.eliminarDocGrupo(docGrupoDTO);
		
	}


	@Override
	public void editarDocGrupo(DocGrupoDTO docGrupoDTO) {
		docGrupoOperacionesDAO.editarDocGrupo(docGrupoDTO);
		
	}	
	
	@Override
	public List<Curso> getSemCursoList() {
		return docGrupoOperacionesDAO.getSemCursoList();
	}


	@Override
	public List<Docente> getDocenteList() {
		return docGrupoOperacionesDAO.getDocenteList();
	}


	@Override
	public List<Grupo> getGrupoList(String nombreCurso) {
		return docGrupoOperacionesDAO.getGrupoList(nombreCurso);
	}
	


	@Override
	public List<DocenteGrupo> getDocGrupoNoReportList() {
		return docGrupoOperacionesDAO.getDocGrupoNoReportList();
	}
	

	public DocGrupoOperacionesDAO getDocGrupoOperacionesDAO() {
		return docGrupoOperacionesDAO;
	}


	public void setDocGrupoOperacionesDAO(
			DocGrupoOperacionesDAO docGrupoOperacionesDAO) {
		this.docGrupoOperacionesDAO = docGrupoOperacionesDAO;
	}



	
	
	
}

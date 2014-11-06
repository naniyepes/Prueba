package com.proint1.udea.actividad.ngc;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;

import com.proint1.udea.actividad.dao.DocGrupoDTO;
import com.proint1.udea.actividad.dao.DocGrupoOperacionesDAO;
import com.proint1.udea.actividad.entidades.TipoActividad;
import com.proint1.udea.administracion.entidades.academico.Curso;
import com.proint1.udea.administracion.entidades.academico.Grupo;
import com.proint1.udea.administracion.entidades.academico.Semestre;
import com.proint1.udea.administracion.entidades.terceros.Docente;

/**
 * Clase de Negocio para realizar la administración de los grupos
 * @author Daniela Yepes - Danilo Mejía
 * @since 19/09/2014
 */

public class AdministrarTipoActividadNgc implements TipoActividadInterfaceDAO,Serializable  {


	/**
	 * 
	 */
	private static final long serialVersionUID = -7876531093640348927L;
	
	TipoActividadInterfaceDAO tipoActividadDao;

	
	@Override
	public List<TipoActividad> getTipoActividadList() {
		return tipoActividadDao.getTipoActividadList();
	}


	@Override
	public String crearTipoActividad(TipoActividad tipoActividad) {
		tipoActividadDao.crearTipoActividad(tipoActividad);
		return null;
	}


	@Override
	public void eliminarTipoActividad(TipoActividad tipoActividad) {
		tipoActividadDao.eliminarTipoActividad(tipoActividad);
		
	}


	@Override
	public void editarTipoActividad(TipoActividad tipoActividad) {
		tipoActividadDao.editarTipoActividad(tipoActividad);
		
	}


	public TipoActividadInterfaceDAO getTipoActividadDao() {
		return tipoActividadDao;
	}


	public void setTipoActividadDao(TipoActividadInterfaceDAO tipoActividadDao) {
		this.tipoActividadDao = tipoActividadDao;
	}
	
	
}

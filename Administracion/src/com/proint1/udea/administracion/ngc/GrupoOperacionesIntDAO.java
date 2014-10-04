package com.proint1.udea.administracion.ngc;

import java.util.List;

import com.proint1.udea.administracion.dao.GrupoDTO;
import com.proint1.udea.administracion.entidades.dependencias.DependenciaAcademica;

/**
 * Interface de persitencia para la entidad {@link CursoDAO}
 * @author Daniela Yepes
 * @since 25/05/2014
 */

public interface GrupoOperacionesIntDAO {
	
	/**
	 * Operacion que consulta o extrae todos los {@link Grupos} del sistema
	 * @return
	 */
	public List<GrupoDTO> getGrupoList();

	
	/**
	 * servicio para crear {@link Grupo}
	 * @param Grupo
	 * @return
	 */
	String almacenarGrupo(GrupoDTO grupoDTO);

	public List<GrupoDTO> buscarGrupo(String idGrupo);


	void eliminarGrupo(GrupoDTO grupoDTO);


	void editarGrupo(GrupoDTO grupoDTO);


	//public List<DependenciaAcademica> getDependenciaList();
	
}

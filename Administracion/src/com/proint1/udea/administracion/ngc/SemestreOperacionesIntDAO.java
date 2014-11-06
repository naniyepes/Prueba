package com.proint1.udea.administracion.ngc;

import java.util.List;

import com.proint1.udea.administracion.dao.SemestreDTO;
import com.proint1.udea.administracion.entidades.academico.EstadoSemestre;
import com.proint1.udea.administracion.entidades.academico.Grupo;
import com.proint1.udea.administracion.entidades.dependencias.DependenciaAcademica;

/**
 * Interface de persitencia para la entidad {@link CursoDAO}
 * @author Daniela Yepes
 * @since 25/05/2014
 */

public interface SemestreOperacionesIntDAO {
	
	/**
	 * Operacion que consulta o extrae todos los {@link Grupos} del sistema
	 * @return
	 */
	public List<SemestreDTO> getSemestreList();

	
	/**
	 * servicio para crear {@link Grupo}
	 * @param Grupo
	 * @return
	 */
	String almacenarSemestre(SemestreDTO semestreDTO);

	//public List<SemestreDTO> buscarGrupo(String idGrupo);


	/**
	 * Elimina Semestre
	 * @param Grupo
	 * @return
	 */
	void eliminarSemestre(SemestreDTO semestreDTO);


	void editarSemestre(SemestreDTO semestreDTO);
	
	
	public List<DependenciaAcademica> getDependenciaList();
	
	public List<EstadoSemestre> getEstadoSemestreList();
	
	
}

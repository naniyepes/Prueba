package com.proint1.udea.administracion.ngc;

import java.util.List;

import com.proint1.udea.administracion.dao.CursoDTO;
import com.proint1.udea.administracion.entidades.dependencias.DependenciaAcademica;

/**
 * Interface de persitencia para la entidad {@link CursoDAO}
 * @author Daniela Yepes
 * @since 25/05/2014
 */

public interface CursoOperacionesIntDAO {
	
	/**
	 * Operacion que consulta o extrae todos los {@link Cursos} del sistema
	 * @return
	 */
	public List<CursoDTO> getCursoList();

	
	/**
	 * servicio para crear {@link Curso}
	 * @param Curso
	 * @return
	 */
	String almacenarCurso(CursoDTO cursoDTO);

	public List<CursoDTO> buscarCurso(String idCurso);


	void eliminarCurso(CursoDTO cursoDTO);


	void editarCurso(CursoDTO cursoDTO);


	public List<DependenciaAcademica> getDependenciaList();
	
}

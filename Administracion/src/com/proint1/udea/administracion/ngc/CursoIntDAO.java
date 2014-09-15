package com.proint1.udea.administracion.ngc;

import java.util.List;

import com.proint1.udea.administracion.dao.CursoDAO;
import com.proint1.udea.administracion.entidades.academico.Curso;

/**
 * Interface de persitencia para la entidad {@link CursoDAO}
 * @author Daniela Yepes
 * @since 25/05/2014
 */

public interface CursoIntDAO {
	
	/**
	 * Operacion que consulta o extrae todos los {@link Cursos} del sistema
	 * @return
	 */
	public List<Curso> getCursoList();

	
	/**
	 * servicio para crear {@link Curso}
	 * @param Curso
	 * @return
	 */
	String almacenarCurso(Curso curso);

	public List<Curso> buscarCurso(String idCurso);


	void eliminarCurso(String idCurso);


	void editarCurso(Long id, String idCurso, String nombreCurso, Long dependenciaAcademicaIDN);
	
}

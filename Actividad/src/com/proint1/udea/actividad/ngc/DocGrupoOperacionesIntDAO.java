package com.proint1.udea.actividad.ngc;

import java.util.List;

import com.proint1.udea.actividad.dao.DocGrupoDTO;
import com.proint1.udea.actividad.entidades.DocenteGrupo;
import com.proint1.udea.administracion.entidades.academico.Curso;
import com.proint1.udea.administracion.entidades.academico.Grupo;
import com.proint1.udea.administracion.entidades.academico.Semestre;
import com.proint1.udea.administracion.entidades.dependencias.DependenciaAcademica;
import com.proint1.udea.administracion.entidades.terceros.Docente;

/**
 * Interface de persitencia para la entidad {@link CursoDAO}
 * @author Daniela Yepes
 * @since 25/05/2014
 */

public interface DocGrupoOperacionesIntDAO {
	
	/**
	 * Operacion que consulta o extrae todos los {@link Grupos} del sistema
	 * @return
	 */
	public List<DocGrupoDTO> getDocGrupoList();

	
	/**
	 * servicio para crear {@link DocenteGrupo}
	 * @param Grupo
	 * @return
	 */
	String almacenarDocGrupo(DocGrupoDTO docGrupoDTO);

	//public List<DocGrupoDTO> buscarDocGrupo(String idGrupo);


	void eliminarDocGrupo(DocGrupoDTO docGrupoDTO);


	void editarDocGrupo(DocGrupoDTO docGrupoDTO);


	//Lista los cursos activos por semestre 
	public List<Curso> getSemCursoList();
	
	//Lista los docentes activos  
	public List<Docente> getDocenteList();
	
	//Lista los docentes activos  
	public List<Grupo> getGrupoList(String nombreCurso);
	
	//Lista los docentesxgrupo que no han reportado actividades
	public List<DocenteGrupo> getDocGrupoNoReportList();
	
	
}

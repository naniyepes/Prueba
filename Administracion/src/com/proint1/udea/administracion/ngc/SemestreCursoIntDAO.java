package com.proint1.udea.administracion.ngc;

import java.util.List;

import com.proint1.udea.administracion.entidades.academico.SemestreCurso;

public interface SemestreCursoIntDAO {

	List<SemestreCurso> getSemestreCursoList();

	String almacenarSemestreCurso(SemestreCurso SemestreCurso);

}

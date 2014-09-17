package com.proint1.udea.administracion.ngc;

import java.util.List;

import com.proint1.udea.administracion.entidades.academico.Semestre;

public interface SemestreIntDAO {

	List<Semestre> getSemestreList();

	String almacenarSemestre(Semestre Semestre);

}

package com.proint1.udea.administracion.ngc;

import java.util.List;

import com.proint1.udea.administracion.entidades.academico.ModalidadCurso;

public interface ModalidadCursoIntDAO {

	List<ModalidadCurso> getModalidadCursoList();

	String almacenarModalidadCurso(ModalidadCurso ModalidadCurso);

}

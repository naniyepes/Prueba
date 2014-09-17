package com.proint1.udea.actividad.ngc;

import java.util.List;

import com.proint1.udea.actividad.entidades.DocenteGrupo;

/**
 *  DAO {@link DocenteGrupo}
 * @author Juan Cardona
 * @since 30/05/2014
 */
public interface DocenteGrupoInterfaceDAO {

	List<DocenteGrupo> getDocenteGrupoList();

	String crearDocenteGrupo(DocenteGrupo docenteGrupo);

}

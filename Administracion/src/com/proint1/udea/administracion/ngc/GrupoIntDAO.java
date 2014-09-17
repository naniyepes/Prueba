package com.proint1.udea.administracion.ngc;

import java.util.List;

import com.proint1.udea.administracion.entidades.academico.Grupo;

/**
 * Interface de persitencia para la entidad {@link GrupoDAO}
 * @author Daniela Yepes
 * @since 25/05/2014
 */

public interface GrupoIntDAO {
	
	/**
	 * Operacion que consulta o extrae todos los {@link Grupos} del sistema
	 * @return
	 */
	public List<Grupo> getGrupoList();

	
	/**
	 * servicio para crear {@link Grupo}
	 * @param Grupo
	 * @return
	 */
	String almacenarGrupo(Grupo grupo);



}

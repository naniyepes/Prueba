package com.proint1.udea.actividad.ngc;

import java.util.List;

import com.proint1.udea.actividad.dao.RegistrarActividadDTO;
import com.proint1.udea.administracion.dto.SumaryGruposDTO;

/**
 * Operaciones del sumario de grupos
 * @author Juan Cardona
 * @since 22/06/2014
 */
public interface OperacionesSumaryGruposInterfaceDAO {

	/**
	 * Lista de grupos asignados a un docente HQL
	 * @param idnDocente
	 * @return
	 */
	List<SumaryGruposDTO> getSumariGrupoDTOPorDocenteIdn(long idnDocente);
	
	List<RegistrarActividadDTO> getRegistrarActividadDTO (long idnDOG);

	/**
	 * Lista de grupos asignados a un docente nativo
	 * @param idnDocente
	 * @return
	 */
	//List<SumaryGruposDTO> getSumariGrupoDTOPorDocenteIdnNativo(long idnDocente);

}

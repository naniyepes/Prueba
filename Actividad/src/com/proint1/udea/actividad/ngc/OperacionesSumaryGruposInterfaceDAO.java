package com.proint1.udea.actividad.ngc;

import java.util.List;

import com.proint1.udea.actividad.dao.RegistrarActividadDTO;
import com.proint1.udea.actividad.entidades.TipoActividad;
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
	
	/**
	 * Lista de actividades registradas
	 * @param idnDOG
	 * @return
	 */
	List<RegistrarActividadDTO> getActividadesList (long idnDOG);

	/**
	 * Tipo de Actividades
	 * @return
	 */
	List<TipoActividad> getTipoActividadesList();

	/**
	 * Guardar Actividad
	 * @param dto
	 */
	void guardarActividad(RegistrarActividadDTO dto);

	/**
	 * Actializa una actividad
	 * @param registrarActividadDTO
	 */
	void actualizarActividad(RegistrarActividadDTO registrarActividadDTO);

	/**
	 * Elimina una atividad por su idn
	 * @param idn
	 */
	void eliminarActividad(long idn);

}

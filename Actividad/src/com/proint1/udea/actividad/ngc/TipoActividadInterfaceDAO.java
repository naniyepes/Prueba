package com.proint1.udea.actividad.ngc;

import java.util.List;

import com.proint1.udea.actividad.entidades.TipoActividad;

/**
 * Intrafece de persitencia para la entidad {@link TipoActividadInterfaceDAO}
 * @author Juan Cardona
 * @since 16/05/2014
 */
public interface TipoActividadInterfaceDAO {
	
	/**
	 * Operacion que consulta o extrea todos los {@link TipoActividad} del sistema
	 * @return
	 */
	public List<TipoActividad> getTipoActividadList();

	
	/**
	 * servicio para crear {@link TipoActividad}
	 * @param tipoActividad
	 * @return
	 */
	String crearTipoActividad(TipoActividad tipoActividad); 
	
	
	
	
}

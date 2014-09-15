package com.proint1.udea.actividad.ngc;

import java.util.List;

import com.proint1.udea.actividad.entidades.DocenteGrupo;
import com.proint1.udea.actividad.entidades.ReporteActividad;

/**
 *  DAO {@link DocenteGrupo}
 * @author Juan Cardona
 * @since 30/05/2014
 */
public interface ReporteActividadInterfaceDAO {

	List<ReporteActividad> getReporteActividadList();

	String crearReporteActividad(ReporteActividad reporteActividad);

}

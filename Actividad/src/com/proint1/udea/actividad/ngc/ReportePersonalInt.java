package com.proint1.udea.actividad.ngc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;

import com.proint1.udea.actividad.dao.RegistrarActividadDTO;
import com.proint1.udea.actividad.reportes.FormatoActividad;
import com.proint1.udea.actividad.reportes.Resumen;

/**
 * @author Jhan  Farley Restrepo
 * @version 1.0.0
 *
 */

public interface ReportePersonalInt {
	
	public byte[] generarInforme(ArrayList<FormatoActividad> lista,  int a) throws JRException;
	
	public List listarActividadesMes(List<RegistrarActividadDTO> lista, String mes);
	
	public List ordenarActividades(List<RegistrarActividadDTO> lista);

	public List <Resumen>  sumarTipoActividades(List<RegistrarActividadDTO> lista);
	
	public List agruparActividades(List<RegistrarActividadDTO> lista);

}

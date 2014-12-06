/**
 * Interfaz temporal de las consultas para los reportes.
 */
package com.proint1.udea.actividad.ngc;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import net.sf.jasperreports.engine.JRException;

import org.zkoss.util.media.AMedia;

import com.proint1.udea.actividad.reportes.DataSetDocente;

/**
 * @author Yonatan Henao R.
 * @version 1.0.0
 *
 */
public interface ReportesActividadesInt {

	/**
	 * Esta funcion permite retornar una lista con los datos de los semestres 
	 * en años en cuatro cifras.
	 * @return La lista de los semestres representados en cuatro cifras.
	 */
	public List getSemestres();
	
	/**
	 * Esta fucion permite retornar una lista con los datos de los periodos 
	 * de los periodos de los años en una cifra.
	 * @return La lista de los periodos representados en una cifra.
	 */
	public List getPeriodos();
	
	/**
	 * Esta funcion permite retornar una lista con los datos de los cursos 
	 * existentes.
	 * @return La lista de los cursos existentes.
	 */
	public List getCursos();//String agno, String periodo);
	
	/**
	 * Esta funcion permite retornar una lista con los datos de los grupos 
	 * actuales.
	 * @return La lista de los grupos actuales.
	 */
	public List getGrupos();//String agno, String periodo, String curso);
	
	public List getPensum();
	
	public List getModalidad();
	
	public List getTipoActividad();
	
	public List filtroMateriasXSemestre(String semestre);
	
	public List filtroGrupoXMateria(String materia);
	
	/**
	 * Esta funcion permite retornar una lista con los datos de los usuarios 
	 * registrados.
	 * @return La lista de los usuarios registrados.
	 */
	public List getUsuarios();//String agno, String periodo, String curso, String grupo);
	
	/**
	 * Esta funcion permite retornar una lista con los datos filtrados por los   
	 * datos del semestre, el periodo, el curso, el grupo o el usuario.
	 * @param semestre Es el anio del semestre el cual se hara el filtro.
	 * @param periodo Es el periodo del semestre el cual se hara el filtro.
	 * @param curso Es el curso al cual se hara el filtro.
	 * @param grupo Es el grupo al cual se hara el filtro.
	 * @param usuario Es el usuario al cual se hara el filtro.
	 * @return Una lista filtrada con los campos del semestre, periodo, curso grupo y usuario.
	 */
	public List getDatosReporte(String semestre, String periodo, String curso, String grupo, String pensum, String modalidad, String fechaInicio, String fechaFin, String tipoActividad);
	
	public List getDatosReporteDocente();
	
	public AMedia generarReporteDocente(DataSetDocente dataSetDocente) throws JRException, IOException;
}

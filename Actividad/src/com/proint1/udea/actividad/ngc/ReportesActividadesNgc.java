/**
 * Logica del temporal.
 */
package com.proint1.udea.actividad.ngc;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import net.sf.jasperreports.engine.JRException;

import org.apache.log4j.Logger;
import org.zkoss.util.media.AMedia;

import com.proint1.udea.actividad.dao.ReportesActividadesDAO;
import com.proint1.udea.actividad.reportes.DataSetDocente;

/**
 * @author Yonatan Henao R.
 * @version 1.0.0
 *
 */
public class ReportesActividadesNgc implements ReportesActividadesInt {

	private ReportesActividadesDAO reportesActividadesDAO = new ReportesActividadesDAO();
	private static Logger logger = Logger.getLogger(ReportesActividadesNgc.class);
	
	public ReportesActividadesDAO getReportesActividadesDAO() {
		return reportesActividadesDAO;
	}

	public void setReportesActividadesDAO(ReportesActividadesDAO reportesActividadesDAO) {
		this.reportesActividadesDAO = reportesActividadesDAO;
	}

	@Override
	public List getSemestres() {
		logger.info("Consultando los semestres...");
		return reportesActividadesDAO.getSemestres();
	}

	@Override
	public List getPeriodos(){
		logger.info("Consultando los periodos de los semestres...");
		return reportesActividadesDAO.getPeriodos();
	}

	@Override
	public List getCursos(){//String agno, String periodo) {
		logger.info("Consultando los cursos...");
		return reportesActividadesDAO.getCursos();//agno, periodo);
	}

	@Override
	public List getGrupos(){//String agno, String periodo, String curso) {
		logger.info("Consultando los grupos...");
		return reportesActividadesDAO.getGrupos();//agno, periodo, curso);
	}
	
	@Override
	public List getPensum() {
		logger.info("Consultando los pensum...");
		return reportesActividadesDAO.getPensum();
	}
	
	@Override
	public List getModalidad() {
		logger.info("Consultado la modalidad...");
		return reportesActividadesDAO.getModalidad();
	}
	
	@Override
	public List getTipoActividad(){
		logger.info("Consultando la actividad...");
		return reportesActividadesDAO.getTipoActividad();
	}

	@Override
	public List filtroMateriasXSemestre(String semestre){
		logger.info("Filtrando materias por semestre...");
		return reportesActividadesDAO.filtroMateriasXSemestre(semestre);
	}
	
	@Override
	public List filtroGrupoXMateria(String materia){
		logger.info("Filtrando grupos por materia...");
		return reportesActividadesDAO.filtroGrupoXMateria(materia);
	}
	
	@Override
	public List getUsuarios(){//String agno, String periodo, String curso, String grupo) {
		logger.info("Consultando los usuarios...");
		return reportesActividadesDAO.getUsuarios();//agno, periodo, curso, grupo);
	}

	@Override
	public List getDatosReporte(String semestre, String periodo, String curso, String grupo, String pensum, String modalidad, String fechaInicio, String fechaFin, String tipoActividad){
		logger.info("Consultando los datos para el reporte...");
		return reportesActividadesDAO.getDatosReporte(semestre, periodo, curso, grupo, pensum, modalidad, fechaInicio, fechaFin, tipoActividad);
	}

	@Override
	public List getDatosReporteDocente(){
		logger.info("Consultando los datos para el reporte del docente...");
		return reportesActividadesDAO.getDatosReporteDocente();
	}
	
	@Override
	public AMedia generarReporteDocente(DataSetDocente dataSetDocente) throws JRException, IOException{
		logger.info("Generando el reporte del docente...");
		return reportesActividadesDAO.generarReporteDocente(dataSetDocente);
	}

}

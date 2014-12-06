/**
 * Logica del temporal.
 */
package com.proint1.udea.actividad.dao;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.zkoss.util.media.AMedia;

import com.proint1.udea.actividad.reportes.DataSetDocente;

/**
 * @author Yonatan Henao R.
 * @version 1.0.0
 *
 */
public class ReportesActividadesDAO extends HibernateDaoSupport {

	public List getSemestres(){
		Session session = this.getSession();
		String query = "SELECT sem.nbSemAgno FROM TbAdmSemestre sem";
		List listaSemestre = session.createQuery(query).list();
		session.close();
		return listaSemestre;
	}
	
	public List getPeriodos(){
		Session session = this.getSession();
		String query = "SELECT per.nbSemPeriodo FROM TbAdmSemestre per";
		List listaPeriodo = session.createQuery(query).list();
		session.close();
		return listaPeriodo;
	}
	
	public List getCursos(){//String agno, String periodo){
		Session session = this.getSession();
		String query = "SELECT cur.vrCurId FROM TbAdmCurso cur";
		List listaCursos = session.createQuery(query).list();
		session.close();
		return listaCursos;
	}
	
	public List getGrupos(){
		Session session = this.getSession();
		String query = "SELECT grp.vrGpoNumero FROM TbAdmGrupo grp";
		List listaGrupos = session.createQuery(query).list();
		session.close();
		return listaGrupos;
	}
	
	public List getPensum() {
		Session session = this.getSession();
		String query = "SELECT pen.nbVpeIdn FROM TbMicVersionpensum pen";
		List listaPensum = session.createQuery(query).list();
		session.close();
		return listaPensum;
	}
	
	public List getModalidad() {
		Session session = this.getSession();
		String query = "SELECT mod.vrMcuDescripcion FROM TbAdmModalidadCurso mod";
		List listaPensum = session.createQuery(query).list();
		session.close();
		return listaPensum;
	}
	
	public List getTipoActividad(){
		Session session = this.getSession();
		String query = "SELECT tac.vrTacNombre FROM TbActTipoActividad tac";
		List listaPensum = session.createQuery(query).list();
		session.close();
		return listaPensum;
	}
	//TODO: no se nesecita, se puede borrar
	public List getUsuarios(){
		Session session = this.getSession();
		String query = "SELECT usr.nbUsuIdn FROM TbAdmUsuario usr";
		List listaUsuarios = session.createQuery(query).list();
		session.close();
		return listaUsuarios;
	}
	
	public List getDatosReporte(String semestre, String periodo, String curso, String grupo, String pensum, String modalidad, 
			String fechaInicio, String fechaFin, String tipoActividad){
		
		semestre = validarDatosReporte("TB_ADM_SEMESTRE.NB_SEM_AGNO", semestre);
		periodo = validarDatosReporte("TB_ADM_SEMESTRE.NB_SEM_PERIODO", periodo);
		curso= validarDatosReporte("TB_ADM_CURSO.VR_CUR_ID", curso);
		grupo = validarDatosReporte("TB_ADM_GRUPO.VR_GPO_NUMERO", grupo);
		
		pensum = validarDatosReporte("TB_MIC_VERSIONPENSUM.NB_VPE_IDN", pensum);
		modalidad = validarDatosReporte("TB_ADM_MODALIDAD_CURSO.VR_MCU_DESCRIPCION", modalidad);
		String fecha = validarFecha(fechaInicio, fechaFin);
		tipoActividad = validarDatosReporte("TB_ACT_TIPO_ACTIVIDAD.VR_TAC_NOMBRE", tipoActividad);
		
		Session session = this.getSession();
		Query query = session.getNamedQuery("FN_DATOS_REPORTE_DOCENTE")
				.setParameter("P_AGNO", semestre)
				.setParameter("P_PERIODO", periodo)
				.setParameter("P_CURSO", curso)
				.setParameter("P_GRUPO", grupo)
				.setParameter("P_PENSUM", pensum)
				.setParameter("P_MODALIDAD", modalidad)
				.setParameter("P_FECHA", fecha)
				.setParameter("P_TIPO_ACTIVIDAD", tipoActividad);
		List listaDatosR = query.list();
		session.close();
		return listaDatosR;
	}
	
	public List getDatosReporteDocente(){
		//TODO: Query para el reporte de los docentes (ya no se necesita, pero se deja por si acaso)
		
		Session session = this.getSession();
		String query = "SELECT usr.nbUsuIdn FROM TbAdmUsuario usr";
		List listaDocentes = session.createQuery(query).list();
		session.close();
		return listaDocentes;
	}
	
	public AMedia generarReporteDocente(DataSetDocente dataSetDocente) throws JRException, IOException{
		JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile("C:/Users/YHR/workspace/proyectoIntegrador/Actividad/src/com/proint1/udea/actividad/reportes/report1_V3.jasper");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, dataSetDocente);
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		JRExporter exporter = new JRPdfExporter();
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, byteArrayOutputStream);
		exporter.exportReport();
		byteArrayOutputStream.close();
		AMedia aMedia = new AMedia("reporte_docente.pdf", "pdf", "pdf/application", byteArrayOutputStream.toByteArray());
		return aMedia;
	}
	
	/**
	 * Esta función es un complemento de una instruccion SQL, se le ingresa el query inicial, de esta manera: 
	 * 'SELECT campo AS alias ' y esta la complementa con una serie de condiciones para devolver los datos, al 
	 * realizar la consulta, devuelve una lista de datos filtrados por las condiciones.
	 * @param query Consulta de la forma: 'SELECT campo AS alias '.
	 * @param semestre Semestre del periodo academico.
	 * @param curso Curso que se va a consultar
	 * @param grupo Numero del grupo
	 * @param usuario Numero del usuario 
	 * @return Lista filtrada de la consulta realizada.
	 */
	private List queryDatosReporte(String query, String semestre, String periodo, String curso, String grupo, String pensum, String modalidad, String fechaInicio, String fechaFin, String tipoActividad){
		Session session = this.getSession();
		
		List list = session.createQuery(query).list();
		session.close();
		return list;
	}
	
	/**
	 * Esta funcion permite validar los datos unica y exclusivamente de la consulta de
	 * actividades, devuelve una cadena con los datos para concatenar la consulta 
	 * principal de la funcion que la llama devolviendo una cadena de comparacion entre 
	 * el campo y el valor.
	 * @param alias Es el campo o el alias del nombre de la tabla a la que se va 
	 * a concatenar la consulta condicional. 
	 * @param valor Es el valor con el cual se hara la comparacion con el parametro campo.
	 * @return Una cadena con la comparacion realizada.
	 */
	private String validarDatosReporte(String alias, String valor){
		String resultado = "";
		if (valor.equals("")) {
			resultado = "0 LIKE 0";
		} else {
			resultado = alias + " LIKE '" + valor + "'";
		}
		return resultado;
	}
	
	private String validarFecha(String fechaInicio, String fechaFin) {
		String resultado1 = "";
		String resultado2 = "";
		String resultado = "";
		
		if ( (fechaInicio.equals("")) || (fechaFin.equals("")) ) {
			if (fechaInicio.equals("")) {
				resultado1 = validarDatosReporte("", fechaInicio);
			} else {
				resultado1 = "TB_ADM_SEMESTRE.DT_ADTFECHA = '" + fechaInicio + "'";
			}
			
			if (fechaFin.equals("")) {
				resultado2 = validarDatosReporte("", fechaFin);
			} else {
				resultado2 = "TB_ADM_SEMESTRE.DT_ADTFECHA = '" + fechaFin + "'";
			}
			resultado = resultado1 + " AND " + resultado2; 
		} else {
			resultado = "TB_ADM_SEMESTRE.DT_ADTFECHA BETWEEN '" + fechaInicio + "' AND '" + fechaFin + "'";
		}
		return resultado;
		
	}
	
	public List filtroMateriasXSemestre(String semestre) {
		String anioSemestre = "";
		String periodo = ""; 
		try{
			anioSemestre = String.valueOf(semestre.substring(0, 4));
			periodo = String.valueOf(semestre.charAt(semestre.length() - 1));
		}catch (StringIndexOutOfBoundsException e){
			
		}

		Session session = this.getSession();
		String query = "SELECT TB_ADM_CURSO.vrCurId AS TB_ADM_CURSO_VR_CUR_NOMBRE " +
				"FROM TbAdmCurso TB_ADM_CURSO " +
				"INNER JOIN TB_ADM_CURSO.tbAdmSemestrexcursos TB_ADM_SEMESTREXCURSO " +
				"INNER JOIN TB_ADM_SEMESTREXCURSO.tbAdmSemestre TB_ADM_SEMESTRE " +
				"WHERE TB_ADM_SEMESTRE.nbSemAgno LIKE '" + anioSemestre +
				"' AND TB_ADM_SEMESTRE.nbSemPeriodo LIKE '" + periodo + "'";
		List listaMaterias = session.createQuery(query).list();
		session.close();
		
		return listaMaterias;
	}
	
	public List filtroGrupoXMateria(String materia) {
		Session session = this.getSession();
		String query = "SELECT TB_ADM_GRUPO.vrGpoNumero AS TB_ADM_GRUPO_VR_GPO_NUMERO " +
				"FROM TbAdmGrupo TB_ADM_GRUPO " +
				"INNER JOIN TB_ADM_GRUPO.tbAdmSemestrexcursos TB_ADM_SEMESTREXCURSO " +
				"INNER JOIN TB_ADM_SEMESTREXCURSO.tbAdmCurso TB_ADM_CURSO " +
				"WHERE TB_ADM_CURSO.vrCurId LIKE '" + materia + "'";
		List listaMaterias = session.createQuery(query).list();
		session.close();
		return listaMaterias;
	}
}

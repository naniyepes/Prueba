package com.proint1.udea;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.proint1.udea.actividad.dao.DocenteGrupoDAO;
import com.proint1.udea.actividad.entidades.DocenteGrupo;
import com.proint1.udea.administracion.dao.CursoDAO;
import com.proint1.udea.administracion.dao.EstadoSemestreDAO;
import com.proint1.udea.administracion.dao.GrupoDAO;
import com.proint1.udea.administracion.dao.ModalidadCursoDAO;
import com.proint1.udea.administracion.dao.SemestreCursoDAO;
import com.proint1.udea.administracion.dao.SemestreDAO;
import com.proint1.udea.administracion.dao.dependencias.DependenciaAcademicaDAO;
import com.proint1.udea.administracion.dao.dependencias.UnidadAcademicaDAO;
import com.proint1.udea.administracion.dao.terceros.PersonaProyDAO;
import com.proint1.udea.administracion.entidades.academico.Curso;
import com.proint1.udea.administracion.entidades.academico.EstadoSemestre;
import com.proint1.udea.administracion.entidades.academico.Grupo;
import com.proint1.udea.administracion.entidades.academico.ModalidadCurso;
import com.proint1.udea.administracion.entidades.academico.Semestre;
import com.proint1.udea.administracion.entidades.academico.SemestreCurso;
import com.proint1.udea.administracion.entidades.dependencias.DependenciaAcademica;
import com.proint1.udea.administracion.entidades.dependencias.TipoDependencia;
import com.proint1.udea.administracion.entidades.dependencias.UnidadAcademica;
import com.proint1.udea.administracion.entidades.seguridad.Usuario;
import com.proint1.udea.administracion.entidades.terceros.Docente;



/**
 * Test de la entidad {@link UnidadAcademica}
 * @author Juan Cardona
 * @since 24/05/2014
 */
public class PoblacionDatosRegistroActividadesUtil extends TestBase {

	@Autowired
	private UnidadAcademicaDAO unidadAcademicaDAO;
	@Autowired
	private DependenciaAcademicaDAO dependenciaAcademicaDAO;
	@Autowired
	private EstadoSemestreDAO estadoSemestreDAO;
	@Autowired
	private SemestreDAO semestreDAO;
	@Autowired
	private ModalidadCursoDAO modalidadCursoDAO;
	@Autowired
	private CursoDAO cursoDAO;
	@Autowired
	private SemestreCursoDAO semestreCursoDAO;
	@Autowired
	private GrupoDAO grupoDAO;
	@Autowired
	private PersonaProyDAO personaProyDAO;
	@Autowired
	private DocenteGrupoDAO docenteGrupoDAO;
	
	
	//Entidades
	UnidadAcademica unidadAcademica=null;
	TipoDependencia tipoDependencia =null;
	Docente docente =null;
	
	/**
	 * Test que consulta todas las personas del sistema
	 */
	@Test
	public void poblacionGeneralBD() {
		
		//Se crean primero los datos no vinculates y maestros
		poblarEstadoSemestres();
		poblarModalidadCurso();
		poblarDocentesUsuario();
		poblarUnidadAcademica();
		poblarDependenciasAcademincas();
	}




	/**
	 * Creau un docente que a la vez sera usuario del sistema
	 */
	private void poblarDocentesUsuario() {
		docente = new Docente(1,"Pedro Pablo","Montoya","7551555825");
		docente.setNombreCompleto("Pedro Pablo Montoya P");
		docente.setRegistroProfesional("45525");
		personaProyDAO.almacenarPersona(docente);
		
		//Crear usuario
		
		Usuario usuario = new Usuario(1,"Pedro Pablo","Montoya","7551555825");
		usuario.setNombreCompleto("Pedro Pablo Montoya P");
		usuario.setActivo(true);
		usuario.setLogin("pmontoya");
		personaProyDAO.almacenarPersona(usuario);
	}


	/**
	 * Modalidades de los cursos
	 */
	private void poblarModalidadCurso() {
		ModalidadCurso modalidadCurso = new ModalidadCurso("VIR", "Virtual");
		modalidadCursoDAO.almacenarModalidadCurso(modalidadCurso);
		
		modalidadCurso = new ModalidadCurso("PRE", "Presencial");
		modalidadCursoDAO.almacenarModalidadCurso(modalidadCurso);
	}


	/**
	 * Estado de los semestres
	 */
	private void poblarEstadoSemestres() {
		EstadoSemestre estadoSemestre = EstadoSemestre.ACTIVO;
		estadoSemestreDAO.almacenarEstadoSemestre(estadoSemestre);
		
		estadoSemestre = EstadoSemestre.INACTIVO;
		estadoSemestreDAO.almacenarEstadoSemestre(estadoSemestre);
	}



	private void poblarUnidadAcademica() {
		unidadAcademica = new UnidadAcademica("Universidad de Antioquia");
		unidadAcademicaDAO.almacenarUnidadAcademica(unidadAcademica );
	}
	

	/**
	 * Dependecnias
	 */
	private void poblarDependenciasAcademincas() {
		//Crear tipos de dependencias
		tipoDependencia = new TipoDependencia("FAC", "Facultad");
		dependenciaAcademicaDAO.almacenarTipoDependencia(tipoDependencia);
		
		TipoDependencia tipoDependenciaPrograma = new TipoDependencia("PRO", "Programa");
		dependenciaAcademicaDAO.almacenarTipoDependencia(tipoDependenciaPrograma);
		
		//Se crea la dependencia Facultad de ingeniería.
		DependenciaAcademica dependenciaAcademicaPadre = new DependenciaAcademica("Faculta de Ingeniería",tipoDependencia,unidadAcademica);
		dependenciaAcademicaDAO.almacenarDependenciaAcademica(dependenciaAcademicaPadre);
		
		
		
		DependenciaAcademica dependenciaAcademicaHija1 = new DependenciaAcademica("Pregrado",unidadAcademica.getIdn(),tipoDependencia.getCodigo(),dependenciaAcademicaPadre.getIdn());
		dependenciaAcademicaDAO.almacenarDependenciaAcademica(dependenciaAcademicaHija1);
		
		DependenciaAcademica dependenciaAcademicaHija2 = new DependenciaAcademica("Posgrado",unidadAcademica.getIdn(),tipoDependencia.getCodigo(),dependenciaAcademicaPadre.getIdn());
		dependenciaAcademicaDAO.almacenarDependenciaAcademica(dependenciaAcademicaHija2);
		
		
		
		DependenciaAcademica dependenciaAcademicaHija3 = new DependenciaAcademica("Ude@ Educación Virtual",unidadAcademica.getIdn(),tipoDependencia.getCodigo(),dependenciaAcademicaPadre.getIdn());
		dependenciaAcademicaDAO.almacenarDependenciaAcademica(dependenciaAcademicaHija3);
		     ///
			DependenciaAcademica dependenciaAcademicaHija3_1 = new DependenciaAcademica("Pregrado",unidadAcademica.getIdn(),tipoDependencia.getCodigo(),dependenciaAcademicaHija3.getIdn());
			dependenciaAcademicaDAO.almacenarDependenciaAcademica(dependenciaAcademicaHija3_1);
			
			DependenciaAcademica dependenciaAcademicaHija3_1_1 = new DependenciaAcademica("ingenieria de Sistemas",unidadAcademica.getIdn(),tipoDependenciaPrograma.getCodigo(),dependenciaAcademicaHija3.getIdn());
			dependenciaAcademicaDAO.almacenarDependenciaAcademica(dependenciaAcademicaHija3_1_1);
			
			DependenciaAcademica dependenciaAcademicaHija3_1_2 = new DependenciaAcademica("Ingeniería Ambiental",unidadAcademica.getIdn(),tipoDependenciaPrograma.getCodigo(),dependenciaAcademicaHija3.getIdn());
			dependenciaAcademicaDAO.almacenarDependenciaAcademica(dependenciaAcademicaHija3_1_2);
			
					
			DependenciaAcademica dependenciaAcademicaHija3_2 = new DependenciaAcademica("Posgrado",unidadAcademica.getIdn(),tipoDependencia.getCodigo(),dependenciaAcademicaHija3.getIdn());
			dependenciaAcademicaDAO.almacenarDependenciaAcademica(dependenciaAcademicaHija3_2);
		
		
		
		poblarSemestresDependenciaAcademica(dependenciaAcademicaPadre,dependenciaAcademicaHija3_1);
		
	}


	/**
	 * @param dependenciaAcademicaPadre
	 * @param nombreDependencia 
	 */
	private void poblarSemestresDependenciaAcademica(DependenciaAcademica dependenciaAcademicaPadre, DependenciaAcademica dependenciaAcademicaHijo) {
		//Crear Semestre
		Semestre semestre = new Semestre(dependenciaAcademicaHijo.getIdn(), EstadoSemestre.ACTIVO_CODE, 2014, 1);
		semestreDAO.almacenarSemestre(semestre);
		poblarCursosDependencia(dependenciaAcademicaPadre,semestre);
	}



	/**
	 * 
	 * @param dependenciaAcademica
	 * @param semestre
	 */
	private void poblarCursosDependencia(DependenciaAcademica dependenciaAcademica, Semestre semestre) {
		crearCursoSemestreGrupo("2554111", "MATEMATICAS DISCRETAS I",dependenciaAcademica, semestre,5);
		crearCursoSemestreGrupo("2559130", "CALCULO DIFERENCIAL",dependenciaAcademica, semestre,5);
		crearCursoSemestreGrupo("2554202", "LOGICA Y REPRESENTACIO II",dependenciaAcademica, semestre,5);
		crearCursoSemestreGrupo("2554246", "TEC. DE PROG. Y LAB.",dependenciaAcademica, semestre,5);
		crearCursoSemestreGrupo("2554302", "LOGICA Y REPRESENTA III",dependenciaAcademica, semestre,5);
	}

	
	
	private void crearCursoSemestreGrupo(String codigo, String nombre, DependenciaAcademica dependenciaAcademica, Semestre semestre, int nroGrupos) {
		Curso curso = new Curso(dependenciaAcademica.getIdn(), codigo, nombre);
		cursoDAO.almacenarCurso(curso);
		
		SemestreCurso semestreCurso = new SemestreCurso(curso.getIdn(), semestre.getIdn(), "VIR");
		semestreCursoDAO.almacenarSemestreCurso(semestreCurso);
		
		//Crear grupos por curso
		for (int i = 0; i < nroGrupos; i++) {
		  Grupo grupo = new Grupo("0" + i, semestreCurso.getIdn());
		  grupoDAO.almacenarGrupo(grupo);
		  
		  //Asignar un docente a este grupo
			DocenteGrupo docenteGrupo = new DocenteGrupo(docente.getIdn(),grupo.getIdn());
			docenteGrupoDAO.crearDocenteGrupo(docenteGrupo);
		}
	}
	
	
	


	public UnidadAcademicaDAO getUnidadAcademicaDAO() {
		return unidadAcademicaDAO;
	}



	public void setUnidadAcademicaDAO(UnidadAcademicaDAO unidadAcademicaDAO) {
		this.unidadAcademicaDAO = unidadAcademicaDAO;
	}



	public DependenciaAcademicaDAO getDependenciaAcademicaDAO() {
		return dependenciaAcademicaDAO;
	}



	public void setDependenciaAcademicaDAO(
			DependenciaAcademicaDAO dependenciaAcademicaDAO) {
		this.dependenciaAcademicaDAO = dependenciaAcademicaDAO;
	}



	public EstadoSemestreDAO getEstadoSemestreDAO() {
		return estadoSemestreDAO;
	}



	public void setEstadoSemestreDAO(EstadoSemestreDAO estadoSemestreDAO) {
		this.estadoSemestreDAO = estadoSemestreDAO;
	}



	public SemestreDAO getSemestreDAO() {
		return semestreDAO;
	}



	public void setSemestreDAO(SemestreDAO semestreDAO) {
		this.semestreDAO = semestreDAO;
	}



	public ModalidadCursoDAO getModalidadCursoDAO() {
		return modalidadCursoDAO;
	}



	public void setModalidadCursoDAO(ModalidadCursoDAO modalidadCursoDAO) {
		this.modalidadCursoDAO = modalidadCursoDAO;
	}



	public CursoDAO getCursoDAO() {
		return cursoDAO;
	}



	public void setCursoDAO(CursoDAO cursoDAO) {
		this.cursoDAO = cursoDAO;
	}



	public SemestreCursoDAO getSemestreCursoDAO() {
		return semestreCursoDAO;
	}



	public void setSemestreCursoDAO(SemestreCursoDAO semestreCursoDAO) {
		this.semestreCursoDAO = semestreCursoDAO;
	}



	public GrupoDAO getGrupoDAO() {
		return grupoDAO;
	}



	public void setGrupoDAO(GrupoDAO grupoDAO) {
		this.grupoDAO = grupoDAO;
	}



	public PersonaProyDAO getPersonaProyDAO() {
		return personaProyDAO;
	}



	public void setPersonaProyDAO(PersonaProyDAO personaProyDAO) {
		this.personaProyDAO = personaProyDAO;
	}




	public DocenteGrupoDAO getDocenteGrupoDAO() {
		return docenteGrupoDAO;
	}




	public void setDocenteGrupoDAO(DocenteGrupoDAO docenteGrupoDAO) {
		this.docenteGrupoDAO = docenteGrupoDAO;
	}

	


}

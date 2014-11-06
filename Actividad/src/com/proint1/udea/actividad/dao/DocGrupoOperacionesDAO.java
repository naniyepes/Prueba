package com.proint1.udea.actividad.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.proint1.udea.actividad.entidades.DocenteGrupo;
import com.proint1.udea.actividad.ngc.DocGrupoOperacionesIntDAO;
import com.proint1.udea.administracion.dto.SumaryGruposDTO;
import com.proint1.udea.administracion.entidades.academico.Curso;
import com.proint1.udea.administracion.entidades.academico.Grupo;
import com.proint1.udea.administracion.entidades.academico.Semestre;
import com.proint1.udea.administracion.entidades.academico.SemestreCurso;
import com.proint1.udea.administracion.entidades.dependencias.DependenciaAcademica;
import com.proint1.udea.administracion.entidades.terceros.Docente;

/**
 * DAO de persistencia para la entidad AdmGrupo
 * @author Daniela Yepes -  Danilo Mejía
 * @since 19/09/2014
 */

public class DocGrupoOperacionesDAO extends HibernateDaoSupport implements DocGrupoOperacionesIntDAO {

	@Override
	public List<DocGrupoDTO> getDocGrupoList() {
		String hql = "Select doGru from DocenteGrupo doGru";
		Query query = getSession().createQuery(hql);
		List<DocenteGrupo> response = (ArrayList<DocenteGrupo>) query.list();

		List <DocGrupoDTO> docGrupoListDTO = new ArrayList<DocGrupoDTO>();
		for (DocenteGrupo docGrupo : response) {
			DocGrupoDTO dto = new DocGrupoDTO();
			
			dto.setIdCurso(docGrupo.getGrupo().getSemestreCurso().getCurso().getIdCurso());
			dto.setIdnGrupo(docGrupo.getGrupoIdn());
			dto.setNombreCurso(docGrupo.getGrupo().getSemestreCurso().getCurso().getNombre());
			dto.setIdnDocente(docGrupo.getDocente().getIdn());
			dto.setNombreDocente(docGrupo.getDocente().getNombreCompleto());
			dto.setNumeroGrupo(docGrupo.getGrupo().getNumeroGrupo());
			dto.setIdnDocGrupo(docGrupo.getIdn());
			docGrupoListDTO.add(dto);
		}		
		return docGrupoListDTO;
	}
	
	
	@Override
	public String almacenarDocGrupo(DocGrupoDTO docGrupoDTO){
		
		DocenteGrupo docGrupo = new DocenteGrupo();
		
		
		docGrupo.setDocenteIdn(docGrupoDTO.getIdnDocente());
		docGrupo.setGrupoIdn(docGrupoDTO.getIdnGrupo());
		
			
		
		Session session = null;
		Transaction tx = null;
		try{
			session = getSession();
			tx = session.beginTransaction();
			session.save(docGrupo);			
			tx.commit();
			return "OK";
		}catch(HibernateException e){
			tx.rollback();
			throw e;
		}
	}
	
	@Override
	public void editarDocGrupo(DocGrupoDTO docGrupoDTO) {
	
		
		
		String hql1 = "update from DocenteGrupo set docenteIdn = ?, grupoIdn = ? where idn= ?";
		Query query1 = getSession().createQuery(hql1);
		query1.setParameter(0, docGrupoDTO.getIdnDocente());
		query1.setParameter(1, docGrupoDTO.getIdnGrupo());
		query1.setParameter(2, docGrupoDTO.getIdnDocGrupo());
		query1.executeUpdate();
		
	}
	
/*
	@Override
	public List<DocGrupoDTO> buscarDocGrupo(String idGrupo) {
//		String hql = "Select Curso.idCurso, Curso.nombre, DependenciaAcademica.nombre from Curso cr, DependenciaAcademica dep  where Curso.dependenciaAcademicaIDN = DependenciaAcademica.idn";
		String hql = "Select gru from Grupo gru";
		Query query = getSession().createQuery(hql);
		List<Grupo> response = (ArrayList<Grupo>) query.list();

		List <DocGrupoDTO> grupoListDTO = new ArrayList<DocGrupoDTO>();
		for (Grupo grupo : response) {
			DocGrupoDTO dto = new DocGrupoDTO();	
			dto.setIdn(grupo.getIdn());
			dto.setAgno(grupo.getSemestreCurso().getSemestre().getAgno()  + "-" + grupo.getSemestreCurso().getSemestre().getPeriodo());			
			dto.setIdCurso(grupo.getSemestreCurso().getCurso().getIdCurso());
			dto.setNombre(grupo.getSemestreCurso().getCurso().getNombre());
			dto.setNumeroGrupo(grupo.getNumeroGrupo());
			dto.setHorario(grupo.getHorario());
			grupoListDTO.add(dto);
		}		
		return grupoListDTO;
	}*/


	@Override
	public void eliminarDocGrupo(DocGrupoDTO docGrupoDTO) {
		String hql = "delete from DocenteGrupo where idn=:parCursoIdn";
		Query query = getSession().createQuery(hql);
		query.setParameter("parCursoIdn", docGrupoDTO.getIdnDocGrupo());
		query.executeUpdate();	
		
	}


	


	@Override
	public List<Curso> getSemCursoList() {
		String hql = "Select cur from Curso cur, SemestreCurso semcur where cur.idn = semcur.cursoIDN ";
		Query query = getSession().createQuery(hql);
		List<Curso> response = (ArrayList<Curso>) query.list();			
		return response;
	}


	@Override
	public List<Docente> getDocenteList() {
		String hql = "Select doc from Docente doc";
		Query query = getSession().createQuery(hql);
		List<Docente> response = (ArrayList<Docente>) query.list();			
		return response;
	}


	@Override
	public List<Grupo> getGrupoList(String nombreCurso) {
		String hql = "Select gru from Grupo gru, Curso cur, SemestreCurso semcur where gru.semestreCursoIdn = semcur.idn and " +
				"cur.idn = semcur.cursoIDN and cur.nombre = ?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, nombreCurso);
		List<Grupo> response = (ArrayList<Grupo>) query.list();			
		return response;
	}	
}

package com.proint1.udea.administracion.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.proint1.udea.administracion.dao.GrupoDTO;
import com.proint1.udea.actividad.entidades.DocenteGrupo;
import com.proint1.udea.administracion.ngc.CursoIntDAO;
import com.proint1.udea.administracion.ngc.CursoOperacionesIntDAO;
import com.proint1.udea.administracion.ngc.GrupoOperacionesIntDAO;
import com.proint1.udea.administracion.dto.SumaryGruposDTO;
import com.proint1.udea.administracion.entidades.academico.Curso;
import com.proint1.udea.administracion.entidades.academico.Grupo;
import com.proint1.udea.administracion.entidades.academico.Semestre;
import com.proint1.udea.administracion.entidades.academico.SemestreCurso;
import com.proint1.udea.administracion.entidades.dependencias.DependenciaAcademica;

/**
 * DAO de persistencia para la entidad AdmGrupo
 * @author Daniela Yepes -  Danilo Mejía
 * @since 19/09/2014
 */

public class GrupoOperacionesDAO extends HibernateDaoSupport implements GrupoOperacionesIntDAO {

	@Override
	public List<GrupoDTO> getGrupoList() {

		
		//		String hql = "Select Curso.idCurso, Curso.nombre, DependenciaAcademica.nombre from Curso cr, DependenciaAcademica dep  where Curso.dependenciaAcademicaIDN = DependenciaAcademica.idn";
		String hql = "Select gru from Grupo gru";
		Query query = getSession().createQuery(hql);
		List<Grupo> response = (ArrayList<Grupo>) query.list();

		List <GrupoDTO> grupoListDTO = new ArrayList<GrupoDTO>();
		for (Grupo grupo : response) {
			GrupoDTO dto = new GrupoDTO();	
			dto.setIdn(grupo.getIdn());
			dto.setAgno(grupo.getSemestreCurso().getSemestre().getAgno()  + "-" + grupo.getSemestreCurso().getSemestre().getPeriodo());			
			dto.setIdCurso(grupo.getSemestreCurso().getCurso().getIdCurso());
			dto.setNombre(grupo.getSemestreCurso().getCurso().getNombre());
			dto.setNumeroGrupo(grupo.getNumeroGrupo());
			dto.setHorario(grupo.getHorario());
			grupoListDTO.add(dto);
		}		
		return grupoListDTO;
	}

	
	@Override
	public String almacenarGrupo(GrupoDTO grupoDTO){

		Grupo grupo = new Grupo();	
		
		String hql = "Select semcur from SemestreCurso semcur, Curso cur where semcur.cursoIDN = cur.idn and cur.nombre = ?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, grupoDTO.getNombre());
		List<SemestreCurso> response = (ArrayList<SemestreCurso>) query.list();
		
		grupo.setHorario(grupoDTO.getHorario());
		grupo.setNumeroGrupo(grupoDTO.getNumeroGrupo());
		grupo.setSemestreCursoIdn(response.get(0).getIdn());		
		
		Session session = null;
		Transaction tx = null;
		try{
			session = getSession();
			tx = session.beginTransaction();
			session.save(grupo);			
			tx.commit();
			return "OK";
		}catch(HibernateException e){
			tx.rollback();
			throw e;
		}
	}

	@Override
	public List<GrupoDTO> buscarGrupo(String idGrupo){

		ArrayList<Curso> cursosList = new ArrayList<Curso>();

		String hql = "Select dog from Curso dog where idCurso=:parCursoIdn";
		Query query = getSession().createQuery(hql);
		query.setParameter("parCursoIdn", idGrupo);

		List<GrupoDTO> cursoGrupoList = (ArrayList<GrupoDTO>) query.list();

		return cursoGrupoList;

	}

	@Override
	public void eliminarGrupo(GrupoDTO grupoDTO){
		
		String hql = "delete from Curso where idn=:parCursoIdn";
		Query query = getSession().createQuery(hql);
		query.setParameter("parCursoIdn", grupoDTO.getIdn());
		query.executeUpdate();			

	}

	@Override
	public void editarGrupo(GrupoDTO grupoDTO){
		
		Grupo grupo = new Grupo();	
		
		String hql = "Select semcur from SemestreCurso semcur, Curso cur where semcur.cursoIDN = cur.idn and cur.nombre = ?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, grupoDTO.getNombre());
		List<SemestreCurso> response = (ArrayList<SemestreCurso>) query.list();
		
		
		String hql1 = "update from Grupo set numeroGrupo = ?, horario = ?, semestreCursoIdn = ? where idn= ?";
		Query query1 = getSession().createQuery(hql1);
		query1.setParameter(0, grupoDTO.getNumeroGrupo());
		query1.setParameter(1, grupoDTO.getHorario());
		query1.setParameter(2, response.get(0).getIdn());
		query1.setParameter(3,  grupoDTO.getIdn());
		query1.executeUpdate();

	}

	
	//Lista los cursos activos por semestre
	@Override
	public List<Curso> getSemCursoList() {
		String hql = "Select cur from Curso cur, SemestreCurso semcur where cur.idn = semcur.cursoIDN ";
		Query query = getSession().createQuery(hql);
		List<Curso> response = (ArrayList<Curso>) query.list();			
		return response;
	}


}

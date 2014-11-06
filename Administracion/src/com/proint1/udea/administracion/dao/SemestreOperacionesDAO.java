package com.proint1.udea.administracion.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.proint1.udea.administracion.entidades.academico.Curso;
import com.proint1.udea.administracion.entidades.academico.EstadoSemestre;
import com.proint1.udea.administracion.entidades.academico.Grupo;
import com.proint1.udea.administracion.entidades.academico.Semestre;
import com.proint1.udea.administracion.entidades.academico.SemestreCurso;
import com.proint1.udea.administracion.entidades.dependencias.DependenciaAcademica;
import com.proint1.udea.administracion.ngc.SemestreOperacionesIntDAO;

/**
 * DAO de persistencia para la entidad AdmGrupo
 * @author Daniela Yepes -  Danilo Mejía
 * @since 19/09/2014
 */

public class SemestreOperacionesDAO extends HibernateDaoSupport implements SemestreOperacionesIntDAO {


	@Override
	public List<SemestreDTO> getSemestreList() {

		String hql = "Select sem from Semestre sem";
		Query query = getSession().createQuery(hql);
		List<Semestre> response = (ArrayList<Semestre>) query.list();

		List <SemestreDTO> semestreListDTO = new ArrayList<SemestreDTO>();
		for (Semestre sem : response) {
			
			SemestreDTO dto = new SemestreDTO();	
			dto.setAgno(sem.getAgno());
			dto.setEstadoSemestre(sem.getEstadoSemestre().getDescripcion());
			dto.setIdnEstadoSemestre(sem.getEstadoSemestreIdn());
			dto.setIdnDependencia(sem.getDependenciaAcademicaIDN());
			dto.setIdnSemestre(sem.getIdn());
			dto.setNombreDependencia(sem.getDependenciaAcademica().getNombre());
			dto.setPeriodo(sem.getPeriodo());
			semestreListDTO.add(dto);
		}		
		return semestreListDTO;
	}


	@Override
	public String almacenarSemestre(SemestreDTO semestreDTO) {
		
		Semestre sem = new Semestre();
		
		sem.setAgno(semestreDTO.getAgno());
		sem.setDependenciaAcademicaIDN(semestreDTO.getIdnDependencia());
		sem.setEstadoSemestreIdn(semestreDTO.getIdnEstadoSemestre());
		sem.setPeriodo(semestreDTO.getPeriodo());
		
		Session session = null;
		Transaction tx = null;
		try{
			session = getSession();
			tx = session.beginTransaction();
			session.save(sem);			
			tx.commit();
			return "OK";
		}catch(HibernateException e){
			tx.rollback();
			throw e;
		}
	}


	@Override
	public void eliminarSemestre(SemestreDTO semestreDTO) {
		String hql = "delete from Semestre where idn=:parCursoIdn";
		Query query = getSession().createQuery(hql);
		query.setParameter("parCursoIdn", semestreDTO.getIdnSemestre());
		query.executeUpdate();	
		
	}


	@Override
	public void editarSemestre(SemestreDTO semestreDTO) {
		
		String hql1 = "update from Semestre set dependenciaAcademicaIDN = ?, estadoSemestreIdn = ?, agno = ?,  periodo = ? where idn= ?";
		Query query1 = getSession().createQuery(hql1);
		query1.setParameter(0, semestreDTO.getIdnDependencia());
		query1.setParameter(1, semestreDTO.getIdnEstadoSemestre());
		query1.setParameter(2, semestreDTO.getAgno());
		query1.setParameter(3, semestreDTO.getPeriodo());
		query1.setParameter(4, semestreDTO.getIdnSemestre());
		query1.executeUpdate();
		
	}


	@Override
	public List<DependenciaAcademica> getDependenciaList() {
		String hql = "Select dep from DependenciaAcademica dep";
		Query query = getSession().createQuery(hql);
		List<DependenciaAcademica> response = (ArrayList<DependenciaAcademica>) query.list();			
		return response;
	}


	@Override
	public List<EstadoSemestre> getEstadoSemestreList() {
		String hql = "Select estSem from EstadoSemestre estSem";
		Query query = getSession().createQuery(hql);
		List<EstadoSemestre> response = (ArrayList<EstadoSemestre>) query.list();			
		return response;
	}


}

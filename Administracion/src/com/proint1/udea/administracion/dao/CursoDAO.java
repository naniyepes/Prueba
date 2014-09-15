package com.proint1.udea.administracion.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.proint1.udea.actividad.entidades.DocenteGrupo;
import com.proint1.udea.administracion.ngc.CursoIntDAO;
import com.proint1.udea.administracion.dto.SumaryGruposDTO;
import com.proint1.udea.administracion.entidades.academico.Curso;

/**
 * DAO de persistencia para la entidad AdmCurso
 * @author Daniela Yepes
 * @since 25/05/2014
 */

public class CursoDAO extends HibernateDaoSupport implements CursoIntDAO {

	@Override
	public List<Curso> getCursoList() {
		
//		String hql = "Select Curso.idCurso, Curso.nombre, DependenciaAcademica.nombre from Curso cr, DependenciaAcademica dep  where Curso.dependenciaAcademicaIDN = DependenciaAcademica.idn";
		String hql = "Select dog.nombre, cur.idCurso, cur.nombre from DependenciaAcademica dog, Curso cur where dog.idn = cur.dependenciaAcademicaIDN";
		Query query = getSession().createQuery(hql);
		List<Curso> response = (ArrayList<Curso>) query.list();
		return response;
	}

	@Override
	public String almacenarCurso(Curso curso){

		Session session = null;
		Transaction tx = null;

		try{
			session = getSession();
			tx = session.beginTransaction();
			session.save(curso);
			tx.commit();
			return "OK";
		}catch(HibernateException e){
			tx.rollback();
			throw e;
		}

	}

	@Override
	public List<Curso> buscarCurso(String idCurso){

		ArrayList<Curso> cursosList = new ArrayList<Curso>();

		String hql = "Select dog from Curso dog where idCurso=:parCursoIdn";
		Query query = getSession().createQuery(hql);
		query.setParameter("parCursoIdn", idCurso);

		List<Curso> cursoGrupoList = (ArrayList<Curso>) query.list();
		
		return cursoGrupoList;

	}

	@Override
	public void eliminarCurso(String idCurso){

		String hql = "delete from Curso where idCurso=:parCursoIdn";
		Query query = getSession().createQuery(hql);
		query.setParameter("parCursoIdn", idCurso);
		query.executeUpdate();

	}
	
	@Override
	public void editarCurso(Long id, String idCurso, String nombreCurso, Long dependenciaAcademicaIDN){
		
		

		String hql = "update from Curso set idCurso = ?, nombre = ?, dependenciaAcademicaIDN = ? where idn= ?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, idCurso);
		query.setParameter(1, nombreCurso);
		query.setParameter(2, dependenciaAcademicaIDN);
		query.setParameter(3, id);
		query.executeUpdate();

	}

}

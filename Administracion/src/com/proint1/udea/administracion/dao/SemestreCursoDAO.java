package com.proint1.udea.administracion.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.proint1.udea.administracion.ngc.SemestreCursoIntDAO;
import com.proint1.udea.administracion.entidades.academico.SemestreCurso;

/**
 * DAO de persistencia para la entidad AdmSemestreCurso
 * @author Daniela Yepes
 * @since 25/05/2014
 */

public class SemestreCursoDAO extends HibernateDaoSupport implements SemestreCursoIntDAO {
	
	@Override
	public List<SemestreCurso> getSemestreCursoList() {
		String hql = "Select gr from SemestreCurso gr";
		Query query = getSession().createQuery(hql);
		List<SemestreCurso> response = (ArrayList<SemestreCurso>) query.list();
		return response;
	}
	
	@Override
	public String almacenarSemestreCurso(SemestreCurso SemestreCurso){
		
		Session session = null;
		Transaction tx = null;
		
		try{
			session = getSession();
			
			tx = session.beginTransaction();
			session.save(SemestreCurso);
			
			tx.commit();
			
			return "OK";
		}catch(HibernateException e){
		    tx.rollback();
			throw e;
		}		
	}
}

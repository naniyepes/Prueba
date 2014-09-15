package com.proint1.udea.administracion.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.proint1.udea.administracion.ngc.SemestreIntDAO;
import com.proint1.udea.administracion.entidades.academico.Semestre;

/**
 * DAO de persistencia para la entidad AdmSemestre
 * @author Daniela Yepes
 * @since 25/05/2014
 */

public class SemestreDAO extends HibernateDaoSupport implements SemestreIntDAO {
	
	@Override
	public List<Semestre> getSemestreList() {
		String hql = "Select gr from Semestre gr";
		Query query = getSession().createQuery(hql);
		List<Semestre> response = (ArrayList<Semestre>) query.list();
		return response;
	}
	
	@Override
	public String almacenarSemestre(Semestre Semestre){
		
		Session session = null;
		Transaction tx = null;
		
		try{
			session = getSession();
			tx = session.beginTransaction();
			session.save(Semestre);
			tx.commit();
			return "OK";
		}catch(HibernateException e){
		    tx.rollback();
			throw e;
		}
		
	}

}

package com.proint1.udea.administracion.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.proint1.udea.administracion.ngc.GrupoIntDAO;
import com.proint1.udea.administracion.entidades.academico.Grupo;

/**
 * DAO de persistencia para la entidad AdmGrupo
 * @author Daniela Yepes
 * @since 25/05/2014
 */

public class GrupoDAO extends HibernateDaoSupport implements GrupoIntDAO {
	
	@Override
	public List<Grupo> getGrupoList() {
		String hql = "Select gr from Grupo gr";
		Query query = getSession().createQuery(hql);
		List<Grupo> response = (ArrayList<Grupo>) query.list();
		return response;
	}
	
	@Override
	public String almacenarGrupo(Grupo grupo){
		
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


}

package com.proint1.udea.actividad.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.proint1.udea.actividad.entidades.DocenteGrupo;
import com.proint1.udea.actividad.ngc.DocenteGrupoInterfaceDAO;

/**
 * DAO de persistencia para la entyidad {@link DocenteGrupoInterfaceDAO}
 * @author Juan Cardona
 * @since 16/05/2014
 */
public class DocenteGrupoDAO extends HibernateDaoSupport implements DocenteGrupoInterfaceDAO{

	
	
	@Override
	public List<DocenteGrupo> getDocenteGrupoList() {
		String hql = "Select ta from DocenteGrupo ta";
		Query query = getSession().createQuery(hql);
		List<DocenteGrupo> response = (ArrayList<DocenteGrupo>) query.list();
		return response;
	}
	
	@Override
	public String crearDocenteGrupo(DocenteGrupo docenteGrupo){
		Session session = null;
		Transaction tx = null;
		try{
			session = getSession();
			tx = session.beginTransaction();
			session.save(docenteGrupo);
			tx.commit();
			return "OK";
		}catch(HibernateException e){
		    tx.rollback();
			throw e;
		}
	}
}

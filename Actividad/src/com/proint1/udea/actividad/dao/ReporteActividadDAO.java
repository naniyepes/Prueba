package com.proint1.udea.actividad.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.proint1.udea.actividad.entidades.ReporteActividad;
import com.proint1.udea.actividad.ngc.ReporteActividadInterfaceDAO;

/**
 * DAO de persistencia para la entyidad {@link ReporteActividadDAO}
 * @author Juan Cardona
 * @since 16/05/2014
 */
public class ReporteActividadDAO extends HibernateDaoSupport implements ReporteActividadInterfaceDAO{

	
	
	@Override
	public List<ReporteActividad> getReporteActividadList() {
		String hql = "Select ta from ReporteActividad ta";
		Query query = getSession().createQuery(hql);
		List<ReporteActividad> response = (ArrayList<ReporteActividad>) query.list();
		return response;
	}
	
	@Override
	public String crearReporteActividad(ReporteActividad reporteActividad){
		Session session = null;
		Transaction tx = null;
		try{
			session = getSession();
			tx = session.beginTransaction();
			session.save(reporteActividad);
			tx.commit();
			return "OK";
		}catch(HibernateException e){
		    tx.rollback();
			throw e;
		}
	}
}

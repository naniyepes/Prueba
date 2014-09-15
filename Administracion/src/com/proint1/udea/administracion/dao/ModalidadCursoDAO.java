package com.proint1.udea.administracion.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.proint1.udea.administracion.ngc.ModalidadCursoIntDAO;
import com.proint1.udea.administracion.entidades.academico.ModalidadCurso;

/**
 * DAO de persistencia para la entidad AdmModalidadCurso
 * @author Daniela Yepes
 * @since 25/05/2014
 */

public class ModalidadCursoDAO extends HibernateDaoSupport implements ModalidadCursoIntDAO {
	
	@Override
	public List<ModalidadCurso> getModalidadCursoList() {
		String hql = "Select gr from ModalidadCurso gr";
		Query query = getSession().createQuery(hql);
		List<ModalidadCurso> response = (ArrayList<ModalidadCurso>) query.list();
		return response;
	}
	
	@Override
	public String almacenarModalidadCurso(ModalidadCurso ModalidadCurso){
		
		Session session = null;
		Transaction tx = null;
		
		try{
			session = getSession();
			
			tx = session.beginTransaction();
			session.save(ModalidadCurso);
			
			tx.commit();
			
			return "OK";
		}catch(HibernateException e){
		    tx.rollback();
			throw e;
		}
		
	}


}

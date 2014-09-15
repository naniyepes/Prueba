package com.proint1.udea.administracion.dao.dependencias;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.proint1.udea.administracion.entidades.dependencias.DependenciaAcademica;
import com.proint1.udea.administracion.entidades.dependencias.TipoDependencia;

/**
 * DAO para la entidad {@link DependenciaAcademicaDAO} 
 * @author Juan Cardona
 * @since 24/05/2014
 */
public class DependenciaAcademicaDAO extends HibernateDaoSupport {

	private static Logger logger=Logger.getLogger(DependenciaAcademicaDAO.class);


	/**
	 * Consutla las diferentes {@link DependenciaAcademica} del sistema 
	 * @return {@link ArrayList} de {@link DependenciaAcademica}
	 */
	public List<DependenciaAcademica> getDependenciaAcademicasList(){
		logger.info("Consultando DependenciaAcademica");
		Session session = this.getSession();		 
		String query = "select p from DependenciaAcademica p";
		List<DependenciaAcademica> resultado = session.createQuery(query).list();
		session.close();		
		return resultado;
	}
	
	
	/**
	 * Almacena una {@link DependenciaAcademica}
	 * @param persona
	 */
	public void almacenarDependenciaAcademica(DependenciaAcademica dependenciaAcademica){
		logger.info("almacenando DependenciaAcademica");
		Session session = null;
		Transaction tx = null;
		try{
			session = getSession();
			tx = session.beginTransaction();
			session.save(dependenciaAcademica);
			tx.commit();
		}catch(HibernateException e){
			tx.rollback();
			throw e;
		}
	}


	public void almacenarTipoDependencia(TipoDependencia tipoDependencia) {
		logger.info("almacenando tipoDependencia");
		Session session = null;
		Transaction tx = null;
		try{
			session = getSession();
			tx = session.beginTransaction();
			session.save(tipoDependencia);
			tx.commit();
		}catch(HibernateException e){
			tx.rollback();
			throw e;
		}
		
	}

}

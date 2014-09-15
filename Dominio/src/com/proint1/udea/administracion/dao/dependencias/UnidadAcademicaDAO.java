package com.proint1.udea.administracion.dao.dependencias;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.proint1.udea.administracion.entidades.dependencias.UnidadAcademica;

/**
 * DAO para la entidad {@link UnidadAcademicaDAO} 
 * @author Juan Cardona
 * @since 24/05/2014
 */
public class UnidadAcademicaDAO extends HibernateDaoSupport {

	private static Logger logger=Logger.getLogger(UnidadAcademicaDAO.class);

	
	

	/**
	 * Consutla las diferentes {@link UnidadAcademica} del sistema 
	 * @return {@link ArrayList} de {@link UnidadAcademica}
	 */
	public List<UnidadAcademica> getUnidadesAcademicas(){
		logger.info("Consultando UnidadAcademicaDAO");
		Session session = this.getSession();		 
		String query = "select p from UnidadAcademica p";
		List<UnidadAcademica> resultado = session.createQuery(query).list();
		session.close();		
		return resultado;

	}
	
	
	/**
	 * Almacena una {@link UnidadAcademica}
	 * @param persona
	 */
	public void almacenarUnidadAcademica(UnidadAcademica unidadAcademica){
		logger.info("almacenando unidadAcademica");
		Session session = null;
		Transaction tx = null;
		try{
			session = getSession();
			tx = session.beginTransaction();
			session.save(unidadAcademica);
			tx.commit();
		}catch(HibernateException e){
			tx.rollback();
			throw e;
		}
	}

}

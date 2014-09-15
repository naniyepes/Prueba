
package com.proint1.udea.administracion.dao;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.proint1.udea.administracion.entidades.academico.EstadoSemestre;


/**
 * @author Daniela Yepes
 * @author Danilo Mejia
 *
 */
public class EstadoSemestreDAO extends HibernateDaoSupport {
	private static Logger logger=Logger.getLogger(EstadoSemestreDAO.class);

	/**
	 * Retorna los estadosSemestre del sistema
	 * @return
	 */
	public List<EstadoSemestre> getEstadoSemestre(){
		logger.info("Consultando Estados de Semestres");
		Session session = this.getSession();		 
		String query = "select es from EstadoSemestre es";
		List<EstadoSemestre> resultado = session.createQuery(query).list();
		session.close();		
		return resultado;
	}
	
	/**
	 * Almacena un Estado del Semestre
	 * @param EstadoSemestre
	 */
	public void almacenarEstadoSemestre(EstadoSemestre estadoSemestre){
		logger.info("almacenando estadoSemestre");
		Session session = null;
		Transaction tx = null;
		try{
			session = getSession();
			tx = session.beginTransaction();
			session.save(estadoSemestre);
			tx.commit();
		}catch(HibernateException e){
			tx.rollback();
			throw e;
		}
	}
	
	
}




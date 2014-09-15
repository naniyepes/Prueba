package com.proint1.udea.administracion.dao.terceros;




import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.proint1.udea.administracion.entidades.seguridad.Usuario;
import com.proint1.udea.administracion.entidades.terceros.Docente;
import com.proint1.udea.administracion.entidades.terceros.Persona;

/**
 * DAO para la entidad {@link Persona} del proyeto
 * @author Juan Cardona
 * @since 24/05/2014
 */
public class PersonaProyDAO extends HibernateDaoSupport {

	private static Logger logger=Logger.getLogger(PersonaProyDAO.class);

	/**
	 * Retorna las personas del sistema
	 * @return
	 */
	public List<Persona> getPersonas(){
		logger.info("Consultando personas");
		Session session = this.getSession();		 
		String query = "select p from Persona p";
		List<Persona> resultado = session.createQuery(query).list();
		session.close();		
		return resultado;
	}

	/**
	 * Almacena una persona
	 * @param persona
	 */
	public void almacenarPersona(Persona persona){
		logger.info("almacenando persona");
		Session session = null;
		Transaction tx = null;
		try{
			session = getSession();
			tx = session.beginTransaction();
			session.save(persona);
			tx.commit();
		}catch(HibernateException e){
			tx.rollback();
			throw e;
		}
	}

	/**
	 * Cosulta un usuario en el sistema
	 * @param usuario
	 * @param password
	 * @return
	 */
	public Usuario validarUsuario(String usuario, String password) {
		String sql = "select u from Usuario u where login=:usuario";
		Query query = getSession().createQuery(sql);
		query.setParameter("usuario", usuario);
		Usuario resultado = (Usuario) query.uniqueResult();
		return resultado;
	}

	/**
	 * Busca un {@link Docente} por su identificación
	 * @param identificacion
	 * @return 
	 */
	public Docente buscarDocente(String identificacion) {
		String sql = "select d from Docente d where identificacion=:identificacion";
		Query query = getSession().createQuery(sql);
		query.setParameter("identificacion", identificacion);
		Docente resultado = (Docente) query.uniqueResult();
		return resultado;
	}

}

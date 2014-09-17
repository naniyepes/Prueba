package com.proint1.udea.administracion.dao;




import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.proint1.udea.administracion.PersonaEjemplo;


public class PersonaDAO extends HibernateDaoSupport {
	
	 private static Logger logger=Logger.getLogger(PersonaDAO.class);
	 
	 public List getPersonas(){
		 logger.info("Consultando personas");
		 Session session = this.getSession();		 
		 String query = "select p from PersonaEjemplo p";
		 List resultado = session.createQuery(query).list();
		 session.close();		
		 return resultado;
		 
	 }
	 
	 public void almacenarPersona(PersonaEjemplo persona){
		 logger.info("almacenando persona");
		 this.getHibernateTemplate().save(persona);
	 }

}

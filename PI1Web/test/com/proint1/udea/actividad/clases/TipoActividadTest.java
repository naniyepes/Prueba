package com.proint1.udea.actividad.clases;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.proint1.udea.actividad.dao.TipoActividadDAO;
import com.proint1.udea.actividad.entidades.TipoActividad;


/**
 * Test genral de persistencia de la entidad {@link TipoActividad}
 * @author Juan Cardona
 * @since 16/05/2014
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:WEB-INF/applicationContext.xml")
public class TipoActividadTest {

	
	/**
	 * Dao para el tipo de actividades
	 */
	@Autowired
	private TipoActividadDAO tipoActividadDao;

	@Test
	public void getTipoActividadList() {
		List<TipoActividad> tipoActividadList =  getTipoActividadDao().getTipoActividadList();
		for (TipoActividad tipoActividad : tipoActividadList) {
			System.out.println("identificador" + tipoActividad.getNbTacIdn() + " Nombre:" + tipoActividad.getNombre() + " Descripción:" + tipoActividad.getDescripcion());
		}
	}
	
	@Test
	public void crearTipoActividad(){
		TipoActividad tipoActividad = new TipoActividad("Clase presencial","Clases en planta");
		tipoActividad.setNbTacIdn(5545);
		tipoActividadDao.crearTipoActividad(tipoActividad);
	}
	
	
	
	

	public TipoActividadDAO getTipoActividadDao() {
		return tipoActividadDao;
	}

	public void setTipoActividadDao(TipoActividadDAO tipoActividadDao) {
		this.tipoActividadDao = tipoActividadDao;
	}


}

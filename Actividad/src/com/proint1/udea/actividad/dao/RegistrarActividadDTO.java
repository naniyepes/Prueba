package com.proint1.udea.actividad.dao;

import java.io.Serializable;
import java.util.Date;


/**
 * DTO de persistencia para registro de actividades
 * @author Daniela Yepes - Danilo Mejía - Juan Cardona
 * @since 01/10/2014
 */

public class RegistrarActividadDTO implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 983623511849358862L;
	

	/**IDN DOG* el 2014 */
	private long idnDOG;
	
	/**Nombre del tipo actividad**/
	private String nombreTipo;
	
	/**numero del grupo asignado por la universidadd ejempl 01 02 023 */
	private Date fecha;
	
	/**Nombre del tipo actividad**/
	private String descripcion;

	
	
	public long getIdnDOG() {
		return idnDOG;
	}

	public void setIdnDOG(long idnDOG) {
		this.idnDOG = idnDOG;
	}

	public String getNombreTipo() {
		return nombreTipo;
	}

	public void setNombreTipo(String nombreTipo) {
		this.nombreTipo = nombreTipo;
	}	
	
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
	
	
	
}

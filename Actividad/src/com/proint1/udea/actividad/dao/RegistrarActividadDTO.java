package com.proint1.udea.actividad.dao;

import java.io.Serializable;
import java.util.Date;

import com.proint1.udea.actividad.entidades.TipoActividad;


/**
 * DTO de persistencia para registro de actividades
 * @author Daniela Yepes - Danilo Mejía - Juan Cardona
 * @since 01/10/2014
 */

public class RegistrarActividadDTO implements Serializable {


	/**serialVersionUID**/
	private static final long serialVersionUID = 983623511849358862L;
	
	/**Idn*/
	private long idn;

	/**IDN DOG* el 2014 */
	private long idnDOG;
	
	/**Nombre del tipo actividad**/
	private String nombreTipo;
	
	/**numero del grupo asignado por la universidadd ejempl 01 02 023 */
	private Date fecha;
	
	/**Nombre del tipo actividad**/
	private String descripcion;

    /**Tipo de actividad*/
	private TipoActividad tipoActividad;

	public RegistrarActividadDTO() {
		super();
	}

	/**
	 * @return the idnDOG
	 */
	public long getIdnDOG() {
		return idnDOG;
	}

	/**
	 * @param idnDOG the idnDOG to set
	 */
	public void setIdnDOG(long idnDOG) {
		this.idnDOG = idnDOG;
	}

	/**
	 * @return the nombreTipo
	 */
	public String getNombreTipo() {
		return nombreTipo;
	}

	/**
	 * @param nombreTipo the nombreTipo to set
	 */
	public void setNombreTipo(String nombreTipo) {
		this.nombreTipo = nombreTipo;
	}

	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the tipoActividad
	 */
	public TipoActividad getTipoActividad() {
		return tipoActividad;
	}

	/**
	 * @param tipoActividad the tipoActividad to set
	 */
	public void setTipoActividad(TipoActividad tipoActividad) {
		this.tipoActividad = tipoActividad;
	}

	public long getIdn() {
		return idn;
	}

	public void setIdn(long idn) {
		this.idn = idn;
	}
	
}

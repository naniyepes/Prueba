package com.proint1.udea.actividad.entidades;



/**
 * Esta entidad representa todos los tipos de actividades que se pueden registrar
 * en el módulo de registro de activades como por ejemplo: Clase virtual - Clase OPresencial etc 
 * @author Juan Cardona
 * @since 16/05/2014
 */
public class TipoActividad implements java.io.Serializable {

	/**serialVersionUID **/
	private static final long serialVersionUID = -2586948380191032547L;
	
	/**Identificador tabla*/
	private long nbTacIdn;
	/**Nombre del tipo de actividad */
	private String nombre;
	/** Descripción del tipo por ejemplo clase presencial*/
	private String descripcion;
	
	
	/**
	 * 
	 */
	public TipoActividad() {
		super();
	}


	/**
	 * @param nombre
	 * @param descripcion
	 */
	public TipoActividad(String nombre, String descripcion) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
	}


	/**
	 * @return the nbTacIdn
	 */
	public long getNbTacIdn() {
		return nbTacIdn;
	}


	/**
	 * @param nbTacIdn the nbTacIdn to set
	 */
	public void setNbTacIdn(long nbTacIdn) {
		this.nbTacIdn = nbTacIdn;
	}


	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}


	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	
	
	


	
	
	
	
	

}

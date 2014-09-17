package com.proint1.udea.administracion.entidades.dependencias;

/**
 * Enumerado que representa los diferentes tipos de dependencias como
 * Facultad, Instituto, Escuela
 * @author Juan Cardona
 * @since 24/05/2014
 */
public class TipoDependencia implements java.io.Serializable {

	/**serialVersionUID**/
	private static final long serialVersionUID = -3144331952732586945L;
		
	/**Código*/
	private String codigo;
	/**Nombre*/
	private String nombre;
	
	
	/**
	 * 
	 */
	public TipoDependencia() {
		super();
	}
	/**
	 * @param codigo
	 * @param nombre
	 */
	public TipoDependencia(String codigo, String nombre) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
	}
	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}
	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
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
}

package com.proint1.udea.administracion.entidades.academico;
// Generated 10-may-2014 11:58:30 by Hibernate Tools 3.4.0.CR1


/**
 * Entidad que representa la modalidad de un curso
 * @author Daniela - Danilo 
 * @since 24/05/2014
 */
public class ModalidadCurso implements java.io.Serializable {

	/**serialVersionUID**/
	private static final long serialVersionUID = 2278318027896624393L;

	/**Código repesentativo de la modalidad por ejemplo VIR **/
	private String idn;
	
	/**Descripción de la modalidad**/
	private String descripcion;

	/**
	 * 
	 */
	public ModalidadCurso() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param idn
	 * @param descripcion
	 */
	public ModalidadCurso(String idn, String descripcion) {
		super();
		this.idn = idn;
		this.descripcion = descripcion;
	}

	/**
	 * @return the idn
	 */
	public String getIdn() {
		return idn;
	}

	/**
	 * @param idn the idn to set
	 */
	public void setIdn(String idn) {
		this.idn = idn;
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
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}

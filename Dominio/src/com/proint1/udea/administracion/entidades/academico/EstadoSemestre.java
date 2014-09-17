package com.proint1.udea.administracion.entidades.academico;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * Entidad que representa un Estado Semestre por ejemplo activo
 * @author Daniela Yepes
 * @author Danilo Mejia
 * @since 25/05/2014
 */
public class EstadoSemestre implements java.io.Serializable {

	/**serialVersionUID**/
	private static final long serialVersionUID = -8355532088464422809L;
	/**Identificador unico*/
	private String idn;
	/**Descripcion del Estado del Semestre*/
	private String descripcion;

	public static final java.lang.String ACTIVO_CODE = "ACT";
	public static final java.lang.String INACTIVO_CODE = "INACT";
	public static final EstadoSemestre ACTIVO = new EstadoSemestre(ACTIVO_CODE,"Activo");
	public static final EstadoSemestre INACTIVO = new EstadoSemestre(INACTIVO_CODE,"Inactivo");
	private static HashMap<String, EstadoSemestre> enumMapByCode = new HashMap<String, EstadoSemestre>();
	private static ArrayList<EstadoSemestre> enumList = new ArrayList<EstadoSemestre>();

	static {
		enumMapByCode.put(ACTIVO_CODE, EstadoSemestre.ACTIVO);
		enumList.add(EstadoSemestre.ACTIVO); 
		enumMapByCode.put(INACTIVO_CODE, EstadoSemestre.INACTIVO);
		enumList.add(EstadoSemestre.INACTIVO); 
	}
	/**
	 * 
	 */
	public EstadoSemestre() {
		super();
	}
	/**
	 * @param idn Nombre que identifica el estado del semestre (Activo, Inactivo)
	 * @param descripcion  Breve descripción del estado de semestre
	 */
	public EstadoSemestre(String idn, String descripcion) {
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

	public static ArrayList<EstadoSemestre> getEstadoSemestreList() {
		return enumList;
	}  

	/** Find by the primary key. */
	public static EstadoSemestre buscarPorCodigomaryKey (String code) {
		return enumMapByCode.get(code);
	}
}

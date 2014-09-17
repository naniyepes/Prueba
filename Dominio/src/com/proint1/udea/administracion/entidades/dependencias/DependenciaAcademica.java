package com.proint1.udea.administracion.entidades.dependencias;


import java.io.Serializable;


/**
 * Entidad que representa uan Dependencia de la {@link UnidadAcademica} por ejemplo
 * Facultad de Ingenieria, Faculta de Medicina .....
 * @author Juan Cardona
 * @since 24/05/2014
 */
public class DependenciaAcademica implements Serializable {

	/** serialVersionUID**/
	private static final long serialVersionUID = 8154184161347652131L;
	
	/**Idn*/
	private long idn;
	/**Nombre de la dependencia*/
	private String nombre;
	/**Unidad academica idn a la cual pertenece*/
	private long unidadAcademicaIdn;
	/**Codigo Tipo de dependica*/
	private String tipoDependenciaCodigo;
	/**Dependencia padre si es un Hijo*/
	private Long dependenciaPadreCodigo;
	/**Tipo de dependencia*/
	private TipoDependencia tipoDependencia;
	/**Unidad Academica*/
	private UnidadAcademica unidadAcademica;
	/**Dependencia Padre*/
	private DependenciaAcademica dependenciaAcademicaPadre;
	
	/**
	 * 
	 */
	public DependenciaAcademica() {
		super();
	}
	
	/**
	 * @param nombre
	 * @param unidadAcademicaIdn
	 * @param tipoDependenciaCodigo
	 */
	public DependenciaAcademica(String nombre, long unidadAcademicaIdn,String tipoDependenciaCodigo) {
		super();
		this.nombre = nombre;
		this.unidadAcademicaIdn = unidadAcademicaIdn;
		this.tipoDependenciaCodigo = tipoDependenciaCodigo;
		this.dependenciaPadreCodigo = null;
	}
	
	/**
	 * @param nombre
	 * @param tipoDependencia
	 * @param unidadAcademica
	 */
	public DependenciaAcademica(String nombre, TipoDependencia tipoDependencia,UnidadAcademica unidadAcademica) {
		super();
		this.nombre = nombre;
		this.setTipoDependencia(tipoDependencia);
		this.setUnidadAcademica(unidadAcademica);
		this.dependenciaPadreCodigo = null;
	}

	/**
	 * @param nombre
	 * @param unidadAcademicaIdn
	 * @param tipoDependenciaCodigo
	 * @param dependenciaPadreCodigo
	 */
	public DependenciaAcademica(String nombre, long unidadAcademicaIdn,	String tipoDependenciaCodigo, long dependenciaPadreCodigo) {
		super();
		this.nombre = nombre;
		this.unidadAcademicaIdn = unidadAcademicaIdn;
		this.tipoDependenciaCodigo = tipoDependenciaCodigo;
		this.dependenciaPadreCodigo = dependenciaPadreCodigo;
	}




	/**
	 * @return the idn
	 */
	public long getIdn() {
		return idn;
	}
	/**
	 * @param idn the idn to set
	 */
	public void setIdn(long idn) {
		this.idn = idn;
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
	 * @return the unidadAcademicaIdn
	 */
	public long getUnidadAcademicaIdn() {
		return unidadAcademicaIdn;
	}
	/**
	 * @param unidadAcademicaIdn the unidadAcademicaIdn to set
	 */
	public void setUnidadAcademicaIdn(long unidadAcademicaIdn) {
		this.unidadAcademicaIdn = unidadAcademicaIdn;
	}
	/**
	 * @return the tipoDependenciaCodigo
	 */
	public String getTipoDependenciaCodigo() {
		return tipoDependenciaCodigo;
	}
	/**
	 * @param tipoDependenciaCodigo the tipoDependenciaCodigo to set
	 */
	public void setTipoDependenciaCodigo(String tipoDependenciaCodigo) {
		this.tipoDependenciaCodigo = tipoDependenciaCodigo;
	}
	/**
	 * @return the dependenciaPadreCodigo
	 */
	public Long getDependenciaPadreCodigo() {
		return dependenciaPadreCodigo;
	}
	/**
	 * @param dependenciaPadreCodigo the dependenciaPadreCodigo to set
	 */
	public void setDependenciaPadreCodigo(Long dependenciaPadreCodigo) {
		this.dependenciaPadreCodigo = dependenciaPadreCodigo;
	}
	/**
	 * @return the tipoDependencia
	 */
	public TipoDependencia getTipoDependencia() {
		return tipoDependencia;
	}
	/**
	 * @param tipoDependencia the tipoDependencia to set
	 */
	public void setTipoDependencia(TipoDependencia tipoDependencia) {
		this.tipoDependencia = tipoDependencia;
		this.tipoDependenciaCodigo = tipoDependencia == null ? null : tipoDependencia.getCodigo();
	}
	/**
	 * @return the unidadAcademica
	 */
	public UnidadAcademica getUnidadAcademica() {
		return unidadAcademica;
	}
	/**
	 * @param unidadAcademica the unidadAcademica to set
	 */
	public void setUnidadAcademica(UnidadAcademica unidadAcademica) {
		this.unidadAcademica = unidadAcademica;
		this.unidadAcademicaIdn = unidadAcademica == null ? null : unidadAcademica.getIdn();
	}
	/**
	 * @return the dependenciaAcademicaPadre
	 */
	public DependenciaAcademica getDependenciaAcademicaPadre() {
		return dependenciaAcademicaPadre;
	}
	/**
	 * @param dependenciaAcademicaPadre the dependenciaAcademicaPadre to set
	 */
	public void setDependenciaAcademicaPadre(DependenciaAcademica dependenciaAcademicaPadre) {
		this.dependenciaAcademicaPadre = dependenciaAcademicaPadre;
		this.dependenciaPadreCodigo = dependenciaAcademicaPadre == null ? null : dependenciaAcademicaPadre.getIdn();
	}
	
	public String toString() {
        return this.getNombre();
    }
}

package com.proint1.udea.administracion;

// default package
// Generated 24/11/2014 10:29:53 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * TbAdmUniversidades generated by hbm2java
 */
public class TbAdmUniversidades implements java.io.Serializable {

	private long nbIdm;
	private TbAdmPaises tbAdmPaises;
	private String vrNombre;
	private Date dtAdtfecha;
	private String vrAdtusuario;

	public TbAdmUniversidades() {
	}

	public TbAdmUniversidades(long nbIdm, TbAdmPaises tbAdmPaises,
			String vrNombre, Date dtAdtfecha, String vrAdtusuario) {
		this.nbIdm = nbIdm;
		this.tbAdmPaises = tbAdmPaises;
		this.vrNombre = vrNombre;
		this.dtAdtfecha = dtAdtfecha;
		this.vrAdtusuario = vrAdtusuario;
	}

	public long getNbIdm() {
		return this.nbIdm;
	}

	public void setNbIdm(long nbIdm) {
		this.nbIdm = nbIdm;
	}

	public TbAdmPaises getTbAdmPaises() {
		return this.tbAdmPaises;
	}

	public void setTbAdmPaises(TbAdmPaises tbAdmPaises) {
		this.tbAdmPaises = tbAdmPaises;
	}

	public String getVrNombre() {
		return this.vrNombre;
	}

	public void setVrNombre(String vrNombre) {
		this.vrNombre = vrNombre;
	}

	public Date getDtAdtfecha() {
		return this.dtAdtfecha;
	}

	public void setDtAdtfecha(Date dtAdtfecha) {
		this.dtAdtfecha = dtAdtfecha;
	}

	public String getVrAdtusuario() {
		return this.vrAdtusuario;
	}

	public void setVrAdtusuario(String vrAdtusuario) {
		this.vrAdtusuario = vrAdtusuario;
	}

}

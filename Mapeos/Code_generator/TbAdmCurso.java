package com.proint1.udea.administracion;

// default package
// Generated 24/11/2014 10:29:53 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TbAdmCurso generated by hbm2java
 */
public class TbAdmCurso implements java.io.Serializable {

	private long nbCurIdn;
	private TbAdmDependenciaAcademica tbAdmDependenciaAcademica;
	private String vrCurId;
	private String vrCurNombre;
	private String vrAdtusuario;
	private Date dtAdtfecha;
	private Set tbMicCursosxpensums = new HashSet(0);
	private Set tbAdmSemestrexcursos = new HashSet(0);

	public TbAdmCurso() {
	}

	public TbAdmCurso(long nbCurIdn,
			TbAdmDependenciaAcademica tbAdmDependenciaAcademica,
			String vrCurId, String vrCurNombre) {
		this.nbCurIdn = nbCurIdn;
		this.tbAdmDependenciaAcademica = tbAdmDependenciaAcademica;
		this.vrCurId = vrCurId;
		this.vrCurNombre = vrCurNombre;
	}

	public TbAdmCurso(long nbCurIdn,
			TbAdmDependenciaAcademica tbAdmDependenciaAcademica,
			String vrCurId, String vrCurNombre, String vrAdtusuario,
			Date dtAdtfecha, Set tbMicCursosxpensums, Set tbAdmSemestrexcursos) {
		this.nbCurIdn = nbCurIdn;
		this.tbAdmDependenciaAcademica = tbAdmDependenciaAcademica;
		this.vrCurId = vrCurId;
		this.vrCurNombre = vrCurNombre;
		this.vrAdtusuario = vrAdtusuario;
		this.dtAdtfecha = dtAdtfecha;
		this.tbMicCursosxpensums = tbMicCursosxpensums;
		this.tbAdmSemestrexcursos = tbAdmSemestrexcursos;
	}

	public long getNbCurIdn() {
		return this.nbCurIdn;
	}

	public void setNbCurIdn(long nbCurIdn) {
		this.nbCurIdn = nbCurIdn;
	}

	public TbAdmDependenciaAcademica getTbAdmDependenciaAcademica() {
		return this.tbAdmDependenciaAcademica;
	}

	public void setTbAdmDependenciaAcademica(
			TbAdmDependenciaAcademica tbAdmDependenciaAcademica) {
		this.tbAdmDependenciaAcademica = tbAdmDependenciaAcademica;
	}

	public String getVrCurId() {
		return this.vrCurId;
	}

	public void setVrCurId(String vrCurId) {
		this.vrCurId = vrCurId;
	}

	public String getVrCurNombre() {
		return this.vrCurNombre;
	}

	public void setVrCurNombre(String vrCurNombre) {
		this.vrCurNombre = vrCurNombre;
	}

	public String getVrAdtusuario() {
		return this.vrAdtusuario;
	}

	public void setVrAdtusuario(String vrAdtusuario) {
		this.vrAdtusuario = vrAdtusuario;
	}

	public Date getDtAdtfecha() {
		return this.dtAdtfecha;
	}

	public void setDtAdtfecha(Date dtAdtfecha) {
		this.dtAdtfecha = dtAdtfecha;
	}

	public Set getTbMicCursosxpensums() {
		return this.tbMicCursosxpensums;
	}

	public void setTbMicCursosxpensums(Set tbMicCursosxpensums) {
		this.tbMicCursosxpensums = tbMicCursosxpensums;
	}

	public Set getTbAdmSemestrexcursos() {
		return this.tbAdmSemestrexcursos;
	}

	public void setTbAdmSemestrexcursos(Set tbAdmSemestrexcursos) {
		this.tbAdmSemestrexcursos = tbAdmSemestrexcursos;
	}

}

package com.proint1.udea.administracion.entidades.academico;


import java.io.Serializable;
import java.util.Date;


/**
 * parea fsdkfksdkflsd fsdkflsdkflsdkfl
 * @author Daniela
 *
 */
public class Grupo implements Serializable {

	/**serialVersionUID **/
	private static final long serialVersionUID = 1674031712093917633L;
	
	
	/**Identificador unico*/
	private long idn;
	/**numero del grupo asignado por la universidadd ejempl 01 02 023 */
	private String numeroGrupo;
	/**horeario destinado para el grupo*/
	private String horario;
	/**usario que modifica la entidad*/
	private String usuarioActualizacion;
	/**Fecha de modificación de la entidad*/
	private Date fechaActualizacion;
	/**Código del Semesxtre-Curso al que pertenece*/
	private long semestreCursoIdn;
	/**Semestre Currso del grupo*/
	private SemestreCurso semestreCurso;
	
	
	/**
	 * constructor for default
	 */
	public Grupo() {
		super();
		this.usuarioActualizacion = "SYSTEM";
		this.fechaActualizacion = new Date();
	}


	/**
	 * @param numeroGrupo numero del grupo identificador del grupo
	 * @param semestreCursoIdn codigo del {@link SemestreCurso}
	 */
	public Grupo(String numeroGrupo, long semestreCursoIdn) {
		super();
		this.numeroGrupo = numeroGrupo;
		this.semestreCursoIdn = semestreCursoIdn;
		this.usuarioActualizacion = "SYSTEM";
		this.fechaActualizacion = new Date();
	}


	/**
	 * @param numeroGrupo
	 * @param semestreCurso
	 */
	public Grupo(String numeroGrupo, SemestreCurso semestreCurso) {
		super();
		this.numeroGrupo = numeroGrupo;
		this.semestreCurso = semestreCurso;
	}


	/**
	 * @param numeroGrupo
	 * @param horario
	 * @param semestreCursoIdn
	 */
	public Grupo(String numeroGrupo, String horario, long semestreCursoIdn) {
		super();
		this.numeroGrupo = numeroGrupo;
		this.horario = horario;
		this.semestreCursoIdn = semestreCursoIdn;
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
	 * @return the numeroGrupo
	 */
	public String getNumeroGrupo() {
		return numeroGrupo;
	}


	/**
	 * @param numeroGrupo the numeroGrupo to set
	 */
	public void setNumeroGrupo(String numeroGrupo) {
		this.numeroGrupo = numeroGrupo;
	}


	/**
	 * @return the horario
	 */
	public String getHorario() {
		return horario;
	}


	/**
	 * @param horario the horario to set
	 */
	public void setHorario(String horario) {
		this.horario = horario;
	}


	/**
	 * @return the usuarioActualizacion
	 */
	public String getUsuarioActualizacion() {
		return usuarioActualizacion;
	}


	/**
	 * @param usuarioActualizacion the usuarioActualizacion to set
	 */
	public void setUsuarioActualizacion(String usuarioActualizacion) {
		this.usuarioActualizacion = usuarioActualizacion;
	}


	/**
	 * @return the fechaActualizacion
	 */
	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}


	/**
	 * @param fechaActualizacion the fechaActualizacion to set
	 */
	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}


	/**
	 * @return the semestreCursoIdn
	 */
	public long getSemestreCursoIdn() {
		return semestreCursoIdn;
	}


	/**
	 * @param semestreCursoIdn the semestreCursoIdn to set
	 */
	public void setSemestreCursoIdn(long semestreCursoIdn) {
		this.semestreCursoIdn = semestreCursoIdn;
	}


	/**
	 * @return the semestreCurso
	 */
	public SemestreCurso getSemestreCurso() {
		return semestreCurso;
	}


	/**
	 * @param semestreCurso the semestreCurso to set
	 */
	public void setSemestreCurso(SemestreCurso semestreCurso) {
		this.semestreCurso = semestreCurso;
		this.semestreCursoIdn = semestreCurso == null ? null : semestreCurso.getIdn();
	}
	
	
}

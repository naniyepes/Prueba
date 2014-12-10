package com.proint1.udea.actividad.reportes;

public class ResultadoReporte {

	private String semestre;
	private String curso;
	private String profesor;
	private String grupo;
	private String horas;
	
	public ResultadoReporte(String semestre, String curso, String profesor,
			String grupo, String horas) {
		super();
		this.semestre = semestre;
		this.curso = curso;
		this.profesor = profesor;
		this.grupo = grupo;
		this.horas = horas;
	}
		
	public ResultadoReporte() {
		super();
	}

	public String getSemestre() {
		return semestre;
	}
	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public String getProfesor() {
		return profesor;
	}
	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	public String getHoras() {
		return horas;
	}
	public void setHoras(String horas) {
		this.horas = horas;
	}
	
}

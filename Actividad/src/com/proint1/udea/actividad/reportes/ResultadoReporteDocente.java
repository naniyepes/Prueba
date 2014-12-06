package com.proint1.udea.actividad.reportes;

public class ResultadoReporteDocente {

	private String identificacion;
	private String nombre;
	private String apellido;
	private String curso;
	private String horas;
	private String descripcion;
	
	public ResultadoReporteDocente(String identificacion, String nombre,
			String apellido, String curso, String horas, String descripcion) {
		super();
		this.identificacion = identificacion;
		this.nombre = nombre;
		this.apellido = apellido;
		this.curso = curso;
		this.horas = horas;
		this.descripcion = descripcion;
	}

	public ResultadoReporteDocente() {
		super();
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getHoras() {
		return horas;
	}

	public void setHoras(String horas) {
		this.horas = horas;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}

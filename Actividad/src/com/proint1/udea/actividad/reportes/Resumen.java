package com.proint1.udea.actividad.reportes;

public class Resumen {
	
	String tipoctividad;
	int totalActividad;
	
	
	
	public Resumen(String tipoctividad, int totalActividad) {
		super();
		this.tipoctividad = tipoctividad;
		this.totalActividad = totalActividad;
	}
	
	public String getTipoctividad() {
		return tipoctividad;
	}
	public void setTipoctividad(String tipoctividad) {
		this.tipoctividad = tipoctividad;
	}
	public int getTotalActividad() {
		return totalActividad;
	}
	public void setTotalActividad(int totalActividad) {
		this.totalActividad = totalActividad;
	}
	
	
	
	

}

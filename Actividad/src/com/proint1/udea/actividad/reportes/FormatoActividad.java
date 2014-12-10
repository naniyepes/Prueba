package com.proint1.udea.actividad.reportes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class FormatoActividad {
	
	public Date fechaAct;
	public String actividad;
	public String contrato;
	public String cargo;
	public String nombreCompletoContratista;
	public String diaInicial;
	public String diaFinal;
	public String mesInicial;
	public String mesFinal;
	public String añoInicial;
	public String añoFinal;
	public String nombreDependencia;
	public String codigoCurso;
	public String nombreCurso;
	public String modalidadCurso;
	public String numeroGrupo;
	public String tipoActividad;
	public String horario;
	public int numeroHora;
	
	public List <Resumen> actividades = new ArrayList<Resumen>();
	
	public FormatoActividad(){
		
	}
	
	public FormatoActividad(String tipoActividad){
		super();
		this.tipoActividad = tipoActividad;
		
	}
		public FormatoActividad(Date fechaAct, String actividad, String contrato,
			String cargo, String nombreCompletoContratista, String diaInicial,
			String diaFinal, String mesInicial, String mesFinal,
			String añoInicial, String añoFinal, String nombreDependencia,
			String codigoCurso, String nombreCurso, String modalidadCurso,
			String numeroGrupo, String tipoActividad, String horario,
			int numeroHora) {
		super();
		this.fechaAct = fechaAct;
		this.actividad = actividad;
		this.contrato = contrato;
		this.cargo = cargo;
		this.nombreCompletoContratista = nombreCompletoContratista;
		this.diaInicial = diaInicial;
		this.diaFinal = diaFinal;
		this.mesInicial = mesInicial;
		this.mesFinal = mesFinal;
		this.añoInicial = añoInicial;
		this.añoFinal = añoFinal;
		this.nombreDependencia = nombreDependencia;
		this.codigoCurso = codigoCurso;
		this.nombreCurso = nombreCurso;
		this.modalidadCurso = modalidadCurso;
		this.numeroGrupo = numeroGrupo;
		this.tipoActividad = tipoActividad;
		this.horario = horario;
		this.numeroHora = numeroHora;
	}




	
	public String getDiaInicial() {
		return diaInicial;
	}

	public void setDiaInicial(String diaInicial) {
		this.diaInicial = diaInicial;
	}

	public String getDiaFinal() {
		return diaFinal;
	}

	public void setDiaFinal(String diaFinal) {
		this.diaFinal = diaFinal;
	}

	public String getMesInicial() {
		return mesInicial;
	}

	public void setMesInicial(String mesInicial) {
		this.mesInicial = mesInicial;
	}

	public String getMesFinal() {
		return mesFinal;
	}

	public void setMesFinal(String mesFinal) {
		this.mesFinal = mesFinal;
	}

	public String getAñoInicial() {
		return añoInicial;
	}

	public void setAñoInicial(String añoInicial) {
		this.añoInicial = añoInicial;
	}

	public String getAñoFinal() {
		return añoFinal;
	}

	public void setAñoFinal(String añoFinal) {
		this.añoFinal = añoFinal;
	}

	public String getNombreDependencia() {
		return nombreDependencia;
	}

	public void setNombreDependencia(String nombreDependencia) {
		this.nombreDependencia = nombreDependencia;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getNombreCompletoContratista() {
		return nombreCompletoContratista;
	}

	public void setNombreCompletoContratista(String nombreCompletoContratista) {
		this.nombreCompletoContratista = nombreCompletoContratista;
	}

	

	public String getContrato() {
		return contrato;
	}

	public void setContrato(String contrato) {
		this.contrato = contrato;
	}

	
	
	public String getActividad() {
		return actividad;
	}

	public void setActividad(String actividad) {
		this.actividad = actividad;
	}

	public String getCodigoCurso() {
		return codigoCurso;
	}



	public void setCodigoCurso(String codigoCurso) {
		this.codigoCurso = codigoCurso;
	}



	public String getNombreCurso() {
		return nombreCurso;
	}



	public void setNombreCurso(String nombreCurso) {
		this.nombreCurso = nombreCurso;
	}



	public String getModalidadCurso() {
		return modalidadCurso;
	}



	public void setModalidadCurso(String modalidadCurso) {
		this.modalidadCurso = modalidadCurso;
	}



	public String getNumeroGrupo() {
		return numeroGrupo;
	}



	public void setNumeroGrupo(String numeroGrupo) {
		this.numeroGrupo = numeroGrupo;
	}



	public String getHorario() {
		return horario;
	}



	public void setHorario(String horario) {
		this.horario = horario;
	}

	public Date getFechaAct() {
		return fechaAct;
	}




	public void setFechaAct(Date fechaAct) {
		this.fechaAct = fechaAct;
	}
	

	public String getTipoActividad() {
		return tipoActividad;
	}




	public void setTipoActividad(String tipoActividad) {
		this.tipoActividad = tipoActividad;
	}

	public int getNumeroHora() {
		return numeroHora;
	}



	public void setNumeroHora(int numeroHora) {
		this.numeroHora = numeroHora;
	}
	
	

	public void addResumenTipoActividad(Resumen resumen)   
    {       
        this.actividades.add(resumen);   
    } 
	
	
	public List<Resumen> getActividades() {
		return actividades;
	}





	public void setActividades(List<Resumen> actividades) {
		this.actividades = actividades;
	}





	public JRDataSource getMateriasDS()   
    {       
        return new JRBeanCollectionDataSource(actividades);   
    } 


	
}

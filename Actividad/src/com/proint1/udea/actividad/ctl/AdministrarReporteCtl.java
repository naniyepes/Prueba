package com.proint1.udea.actividad.ctl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.sf.jasperreports.engine.JRException;

import org.apache.log4j.Logger;
import org.zkoss.util.media.AMedia;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Iframe;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Messagebox;

import com.proint1.udea.actividad.dao.RegistrarActividadDTO;
import com.proint1.udea.actividad.ngc.OperacionesSumaryGruposInterfaceDAO;
import com.proint1.udea.actividad.ngc.ReportePersonalInt;

import com.proint1.udea.actividad.reportes.FormatoActividad;
import com.proint1.udea.actividad.reportes.Resumen;
import com.proint1.udea.administracion.dto.SumaryGruposDTO;
import com.proint1.udea.administracion.entidades.seguridad.Usuario;
import com.proint1.udea.administracion.entidades.terceros.Docente;

/**
 * Permite crear un reporte a el usuario que de ha logueado
 * @author jhan farley restrepo
 * @since 01/12/2014
 */


public class AdministrarReporteCtl extends GenericForwardComposer {
	Iframe frmReporte;
	Combobox comboReporte;
	Combobox comboReporteAgrupado;
	
	private static Logger logger=Logger.getLogger(AdministrarReporteCtl.class);
	
	/**DAO*/
	private OperacionesSumaryGruposInterfaceDAO actDocenteGrupoInt;
	
	private ReportePersonalInt reportePersonalInt;
	

	
	/**DTo ppal del curso la que se estan registrando tiempos*/
	private SumaryGruposDTO sumaryGruposDto;
	/**DTO para el registro de actividades*/
	private RegistrarActividadDTO registrarActividadDTO;
	/** Nro de registros */
	private Usuario usuario;
	
	public ReportePersonalInt getReportePersonalInt() {
		return reportePersonalInt;
	}
	public void setReportePersonalInt(ReportePersonalInt reportePersonalInt) {
		this.reportePersonalInt = reportePersonalInt;
	}
	
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		logger.info("cargando ventana de registrar actividades");         
		sumaryGruposDto = (SumaryGruposDTO) Executions.getCurrent().getArg().get("dtoSumaryGrupos");
		if (sumaryGruposDto==null){
			Messagebox.show("No selecciono un curso", "Informacion", Messagebox.OK, Messagebox.INFORMATION);
			self.detach();
		}else{
			logger.info("cargando ventana de registrar actividades");   	
		}
	}
	public void onCreate() {
		definirModelo();
	}
	private void definirModelo() {
			
		String [ ] listaMeses = {"00-TODO","01-ENERO","02-FEBRERO","03-MARZO","04-ABRIL","05-MAYO","06-JUNIO","07-JULIO","08-AGOSTO","09-SEPTIEMBRE","10-OCTUBRE","11-NOVIEMBRE","12-DICIEMBRE" };
		comboReporte.setModel(new ListModelList(listaMeses));
		
	}
	// empieza a ca
	//luego formo la lista
	//no yo lo ordeno
	/*public void onSelect$comboReporteAgrupado(Event event)  throws JRException, IOException {
		List<RegistrarActividadDTO> listaActividades = actDocenteGrupoInt.getActividadesList(sumaryGruposDto.getIdn());
		ArrayList <FormatoActividad>  lista = new ArrayList< FormatoActividad> ();
		String descripcion;
		String mes = comboReporte.getValue().substring(0, 2);
		usuario = (Usuario) Sessions.getCurrent().getAttribute("user");
		System.out.println(sumaryGruposDto.getModalidadCurso()+"laura");
		if(!mes.equals("00")){
			
			listaActividades = reportePersonalInt.listarActividadesMes(listaActividades, mes);
			
			
		}
		
		if(!listaActividades.isEmpty()){
		listaActividades = reportePersonalInt.ordenarActividades(listaActividades);
	
		frmReporte.setVisible(true);// contarActividades es el resumen
		//esa lista es la que tengo que pasar con el resumen
		
		List<Resumen> cantidadTipoActividad = reportePersonalInt.sumarTipoActividades(listaActividades);
		System.out.println(listaActividades.get(0).getDescripcion());
		//System.out.println(listaActividades.get(0).getTipoActividad().getNombre());
		int tamaño = listaActividades.size();
		String fechaInicial = String.valueOf(listaActividades.get(0).getFecha());
		
		String fechaFinal = String.valueOf(listaActividades.get(tamaño-1).getFecha());
		listaActividades = reportePersonalInt.agruparActividades(listaActividades);
		//int tamaño = listaActividades.size();
		System.out.println("llego hasta aqui");
		 for (int i = 0; i < tamaño; i++) 
	        { 
			 	descripcion = "["+listaActividades.get(i).getFecha().getDate()+"]  "+listaActividades.get(i).getDescripcion();
	        	FormatoActividad formato = new FormatoActividad(listaActividades.get(i).getFecha(), listaActividades.get(i).getDescripcion(), usuario.getIdentificacion(), "Docente Catedra", usuario.getApellidos() +" "+ usuario.getNombres()
	        			, fechaInicial.substring(8,10),fechaFinal.substring(8,10),fechaInicial.substring(5,7),
	        			fechaFinal.substring(5,7)+"",fechaInicial.substring(0,4),fechaFinal.substring(0,4),
	        			"Departamento de Ingenieria de Sistemas",sumaryGruposDto.getCodigoCurso(),sumaryGruposDto.getNombreCurso(),sumaryGruposDto.getModalidadCurso(), sumaryGruposDto.getGrupoNumero(),listaActividades.get(i).getNombreTipo(), sumaryGruposDto.getHorario(),2);
	        	System.out.println("tipo actividad"+listaActividades.get(i).getNombreTipo());
	        	lista.add(formato);
	        	
	        	for (int j = 0; j< cantidadTipoActividad.size();j++){
	        		formato.addResumenTipoActividad(cantidadTipoActividad.get(j));
	        	}
	        	
	        	
	        } 
	        
	          
	        byte[] buf;
	 
				buf = reportePersonalInt.generarInforme(lista,2);
				
				final AMedia amedia = new AMedia("FirstReport1.pdf", "pdf", "application/pdf", buf);
				
				frmReporte.setContent(amedia);
				
				
			
		}else{
			
			frmReporte.setVisible(false);
		}
	}*/
	
	
	public void onSelect$comboReporte(Event event)  throws JRException, IOException {
		List<RegistrarActividadDTO> listaActividades = actDocenteGrupoInt.getActividadesList(sumaryGruposDto.getIdn());
		ArrayList <FormatoActividad>  lista = new ArrayList< FormatoActividad> ();
		String descripcion;
		String mes = comboReporte.getValue().substring(0, 2);
		usuario = (Usuario) Sessions.getCurrent().getAttribute("user");
		System.out.println(sumaryGruposDto.getModalidadCurso()+"laura");
		if(!mes.equals("00")){
			
			listaActividades = reportePersonalInt.listarActividadesMes(listaActividades, mes);
			
			
		}
		
		if(!listaActividades.isEmpty()){
		listaActividades = reportePersonalInt.ordenarActividades(listaActividades);
	
		frmReporte.setVisible(true);// contarActividades es el resumen
		//esa lista es la que tengo que pasar con el resumen
		
		List<Resumen> cantidadTipoActividad = reportePersonalInt.sumarTipoActividades(listaActividades);
		System.out.println(listaActividades.get(0).getDescripcion());
		//System.out.println(listaActividades.get(0).getTipoActividad().getNombre());
		int tamaño = listaActividades.size();
		String fechaInicial = String.valueOf(listaActividades.get(0).getFecha());
		
		String fechaFinal = String.valueOf(listaActividades.get(tamaño-1).getFecha());
		//listaActividades = reportePersonalInt.agruparActividades(listaActividades);
		//int tamaño = listaActividades.size();
		System.out.println("llego hasta aqui");
		 for (int i = 0; i < tamaño; i++) 
	        { 
			 	descripcion = "["+listaActividades.get(i).getFecha().getDate()+"]  "+listaActividades.get(i).getDescripcion();
	        	FormatoActividad formato = new FormatoActividad(listaActividades.get(i).getFecha(), listaActividades.get(i).getDescripcion(), usuario.getIdentificacion(), "Docente Catedra", usuario.getApellidos() +" "+ usuario.getNombres()
	        			, fechaInicial.substring(8,10),fechaFinal.substring(8,10),fechaInicial.substring(5,7),
	        			fechaFinal.substring(5,7)+"",fechaInicial.substring(0,4),fechaFinal.substring(0,4),
	        			"Departamento de Ingenieria de Sistemas",sumaryGruposDto.getCodigoCurso(),sumaryGruposDto.getNombreCurso(),sumaryGruposDto.getModalidadCurso(), sumaryGruposDto.getGrupoNumero(),listaActividades.get(i).getNombreTipo(), sumaryGruposDto.getHorario(),2);
	        	System.out.println("tipo actividad"+listaActividades.get(i).getNombreTipo());
	        	lista.add(formato);
	        	
	        	/*for (int j = 0; j< cantidadTipoActividad.size();j++){
	        		formato.addResumenTipoActividad(cantidadTipoActividad.get(j));
	        	}*/
	        	
	        	
	        } 
	        
	          
	        byte[] buf;
	 
				buf = reportePersonalInt.generarInforme(lista,1);
				
				final AMedia amedia = new AMedia("FirstReport1.pdf", "pdf", "application/pdf", buf);
				
				frmReporte.setContent(amedia);
				
				
			
		}else{
			
			frmReporte.setVisible(false);
		}

	}
	
	public OperacionesSumaryGruposInterfaceDAO getActDocenteGrupoInt() {
		return actDocenteGrupoInt;
	}

	public void setActDocenteGrupoInt(OperacionesSumaryGruposInterfaceDAO actDocenteGrupoInt) {
		this.actDocenteGrupoInt = actDocenteGrupoInt;
	}	

	

}

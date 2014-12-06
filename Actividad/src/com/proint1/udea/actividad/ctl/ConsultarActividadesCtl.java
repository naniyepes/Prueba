package com.proint1.udea.actividad.ctl;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import net.sf.jasperreports.engine.JRException;

import org.apache.log4j.Logger;
import org.zkoss.util.media.AMedia;
import org.zkoss.zhtml.Messagebox;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Div;
import org.zkoss.zul.Iframe;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;
import org.zkoss.zul.Window;

import com.proint1.udea.actividad.ngc.ReportesActividadesInt;
import com.proint1.udea.actividad.reportes.DataSetDocente;

/**
 * 
 * @author YHR
 *
 */
public class ConsultarActividadesCtl extends GenericForwardComposer implements ListitemRenderer {

private static Logger logger=Logger.getLogger(ConsultarActividadesCtl.class);
	
	Combobox comboSemestre;
	Combobox comboCurso;
	Combobox comboGrupo;
	Combobox comboPensum;
	Combobox comboModalidad;
	Combobox comboTipoActividad;
	Datebox dateBoxInicio;
	Datebox dateBoxFin;
	
	Combobox comboUsuario;
	
	
	Listbox listActividades;
	
	Iframe frmReporte;
	
	Div divCenter;
	
	ReportesActividadesInt reportesActividadesInt;
	
	public ReportesActividadesInt getReportesActividadesInt() {
		return reportesActividadesInt;
	}

	public void setReportesActividadesInt(ReportesActividadesInt reportesActividadesInt) {
		this.reportesActividadesInt = reportesActividadesInt;
	}

	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		logger.info("cargando ventana Consultar Actividades...");         

	}
	
	public void onCreate() {
		definirModelo();
	}
	
	private void definirModelo() {
		List listaSemestre = new ArrayList();
		listaSemestre = reportesActividadesInt.getSemestres();
		List listaPeriodo = new ArrayList();
		listaPeriodo = reportesActividadesInt.getPeriodos();
		List listaSemestrePerido = new ArrayList();
		
		Iterator iteratorSemestre = listaSemestre.iterator();
		Iterator iteratorPeriodo = listaPeriodo.iterator();
		
		while(iteratorSemestre.hasNext() || iteratorPeriodo.hasNext()){
			String semestre = String.valueOf(iteratorSemestre.next()) + " - "  
					+ String.valueOf(iteratorPeriodo.next());
			listaSemestrePerido.add(semestre);
		}
		
		comboSemestre.setModel(new ListModelList(listaSemestrePerido));
		comboCurso.setModel(new ListModelList(reportesActividadesInt.getCursos()));
		comboGrupo.setModel(new ListModelList(reportesActividadesInt.getGrupos()));
		comboPensum.setModel(new ListModelList(reportesActividadesInt.getPensum()));
		comboModalidad.setModel(new ListModelList(reportesActividadesInt.getModalidad()));
		comboTipoActividad.setModel(new ListModelList(reportesActividadesInt.getTipoActividad()));
		
	}
	
	@Override
	public void render(Listitem arg0, Object arg1, int arg2) throws Exception {
		
	}
	
	public void onClick$btnImprimir(Event event) throws JRException, IOException, ParseException{
		DataSetDocente dataSetDocente = new DataSetDocente();
		
		String anioSemestre = "";
		String periodo = "";
		
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
		String fechaInicialStr = dateFormat.format(dateBoxInicio.getValue());
		String fechaFinalStr = dateFormat.format(dateBoxFin.getValue());
		
		Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(fechaInicialStr);
		Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse(fechaFinalStr);
		
		try{
			anioSemestre = String.valueOf(comboSemestre.getValue().substring(0, 4));
			periodo = String.valueOf(comboSemestre.getValue().charAt(comboSemestre.getValue().length() - 1));
			
			if (date1.compareTo(date2) == 0) {
				List listaDatosReporte = reportesActividadesInt.getDatosReporte(anioSemestre, periodo, comboCurso.getValue(), comboGrupo.getValue(), 
						comboPensum.getValue(), comboModalidad.getValue(), "", "", comboTipoActividad.getValue());
				dataSetDocente.setLista(listaDatosReporte);
				AMedia aMedia = reportesActividadesInt.generarReporteDocente(dataSetDocente);
				frmReporte.setContent(aMedia);
			} else{
				if (date1.compareTo(date2) < 0) {
					List listaDatosReporte = reportesActividadesInt.getDatosReporte(anioSemestre, periodo, comboCurso.getValue(), comboGrupo.getValue(), 
							comboPensum.getValue(), comboModalidad.getValue(), fechaInicialStr, fechaFinalStr, comboTipoActividad.getValue());
					dataSetDocente.setLista(listaDatosReporte);
					AMedia aMedia = reportesActividadesInt.generarReporteDocente(dataSetDocente);
					frmReporte.setContent(aMedia);
				} else {
					Messagebox.show("Por favor ingrese la fecha inicial sea menor que la fecha final", "Aviso", Messagebox.OK, Messagebox.EXCLAMATION);
				}
			}
		}catch (StringIndexOutOfBoundsException e){
			if (date1.compareTo(date2) == 0) {
				List listaDatosReporte = reportesActividadesInt.getDatosReporte(anioSemestre, periodo, comboCurso.getValue(), comboGrupo.getValue(), 
						comboPensum.getValue(), comboModalidad.getValue(), "", "", comboTipoActividad.getValue());
				dataSetDocente.setLista(listaDatosReporte);
				AMedia aMedia = reportesActividadesInt.generarReporteDocente(dataSetDocente);
				frmReporte.setContent(aMedia);
			} else{
				if (date1.compareTo(date2) < 0) {
					List listaDatosReporte = reportesActividadesInt.getDatosReporte(anioSemestre, periodo, comboCurso.getValue(), comboGrupo.getValue(), 
							comboPensum.getValue(), comboModalidad.getValue(), fechaInicialStr, fechaFinalStr, comboTipoActividad.getValue());
					dataSetDocente.setLista(listaDatosReporte);
					AMedia aMedia = reportesActividadesInt.generarReporteDocente(dataSetDocente);
					frmReporte.setContent(aMedia);
				} else {
					Messagebox.show("Por favor ingrese la fecha inicial sea menor que la fecha final", "Aviso", Messagebox.OK, Messagebox.EXCLAMATION);
				}
			}
		}	
	}
	
	public void onClick$btnDetalle(Event event){
		
	}
	
	public void onClick$listActividades(Event event) throws IOException{
		Listitem l = listActividades.getSelectedItem();
		List g = l.getChildren();
		java.io.InputStream zulInput = this.getClass().getClassLoader().getResourceAsStream("com/proint1/udea/actividad/vista/visualizarConsultaActividades.zul") ;
		java.io.Reader zulReader = new java.io.InputStreamReader(zulInput);
		Window windowCenter= (Window)Executions.createComponentsDirectly(zulReader,"zul",divCenter,new HashMap()) ;
		windowCenter.doModal();
	}
	
	public void onClick$btnBuscar(Event event) {
		//TODO: Realizar mantenimiento...
		String anioSemestre = comboSemestre.getValue();
		String periodo = comboSemestre.getValue();
		
		if ( (dateBoxInicio.getText().toString().equals("")) || (dateBoxFin.getText().toString().equals("")) 
				|| (anioSemestre.equals("")) ) {
			List listaDatosReporte = reportesActividadesInt.getDatosReporte(anioSemestre, periodo, comboCurso.getValue(), 
					comboGrupo.getValue(), comboPensum.getValue(), comboModalidad.getValue(), dateBoxInicio.getValue().toString(), 
					dateBoxFin.getValue().toString(), comboTipoActividad.getValue());
			ListModel listModel = new ListModelList(listaDatosReporte);
			listActividades.setModel(listModel);
			listActividades.setItemRenderer(this);
		} else {
			if (dateBoxInicio.getValue().compareTo(dateBoxFin.getValue()) < 0) {
				try{
					anioSemestre = String.valueOf(anioSemestre.substring(0, 4));
					periodo = String.valueOf(periodo.charAt(periodo.length() - 1));	
				}
				catch (StringIndexOutOfBoundsException e){}
				
				//List<ResultadoReporte> listaDatosReporte = temporalInt.getDatosReporte("", "", "", "", "");
				List listaDatosReporte = reportesActividadesInt.getDatosReporte(anioSemestre, periodo, comboCurso.getValue(), 
						comboGrupo.getValue(), comboPensum.getValue(), comboModalidad.getValue(), dateBoxInicio.getValue().toString(), 
						dateBoxFin.getValue().toString(), comboTipoActividad.getValue());
				ListModel listModel = new ListModelList(listaDatosReporte);
				listActividades.setModel(listModel);
				listActividades.setItemRenderer(this);
			} else {
				//TODO: MENSAJE QUE LA FECHA DE INICIO NO PUEDE SER MAYOR QUE LA FECHA FINAL
			}
		}
		

	}
	
	public void onChange$comboSemestre(Event event) {
		if (comboSemestre.getValue().equals("")) {
			comboCurso.setModel(new ListModelList(reportesActividadesInt.getCursos()));
		} else {
			comboCurso.setModel(new ListModelList(reportesActividadesInt.filtroMateriasXSemestre(comboSemestre.getValue())));
		}
	}
	
	public void onChange$comboCurso(Event event) {
		if (comboCurso.getValue().equals("")) {
			comboGrupo.setModel(new ListModelList(reportesActividadesInt.getGrupos()));
		} else {
			comboGrupo.setModel(new ListModelList(reportesActividadesInt.filtroGrupoXMateria(comboCurso.getValue())));
		}
	}
	
	
	public void onClick$btnPrueba(Event event) throws IOException{
		self.detach();
		if(divCenter==null){
			divCenter = (Div)Sessions.getCurrent().getAttribute("divPrincipalCtl");
		}
		java.io.InputStream zulInput = this.getClass().getClassLoader().getResourceAsStream("com/proint1/udea/actividad/vista/visualizarConsultaActividades.zul") ;
		java.io.Reader zulReader = new java.io.InputStreamReader(zulInput);
		Window windowCenter= (Window)Executions.createComponentsDirectly(zulReader,"zul",divCenter,new HashMap()) ;	
		windowCenter.doEmbedded();
	}

}

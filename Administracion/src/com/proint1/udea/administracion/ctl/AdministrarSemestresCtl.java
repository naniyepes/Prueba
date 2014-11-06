package com.proint1.udea.administracion.ctl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Toolbarbutton;
import org.zkoss.zul.Window;

import com.proint1.udea.administracion.dao.SemestreDTO;
import com.proint1.udea.administracion.ngc.SemestreOperacionesIntDAO;

public class AdministrarSemestresCtl extends GenericForwardComposer implements ListitemRenderer {

	Toolbarbutton btnCrear;
	Toolbarbutton btnEditar;
	Toolbarbutton btnEliminar;
	Listbox lsxSemestre;
	


	private static Logger logger=Logger.getLogger(AdministrarSemestresCtl.class);

	//interface que sirve como guia para implementar la funciones de la clase grupo
	SemestreOperacionesIntDAO semestresOpInt;

	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		logger.info("cargando ventana de Semestres");         

	}

	//cuando se este creando se implementa el metodo definirModelo.
	public void onCreate() {
		definirModelo();
	}
	
	private void definirModelo() {
		List<SemestreDTO> listaSemestres = semestresOpInt.getSemestreList();
		ListModel model = new ListModelList(listaSemestres);
		lsxSemestre.setModel(model);
		lsxSemestre.setItemRenderer(this);
	}

	@Override
	public void render(Listitem arg0, Object arg1, int arg2) throws Exception {
		SemestreDTO sem = (SemestreDTO)arg1;
		Listcell lcAgno = new Listcell(Integer.toString(sem.getAgno()));
		Listcell lcPeriodo = new Listcell(Integer.toString(sem.getPeriodo()));
		Listcell lcEstadoSem = new Listcell(sem.getEstadoSemestre());
		Listcell lcDependencia = new Listcell(sem.getNombreDependencia());
		arg0.appendChild(lcAgno);
		arg0.appendChild(lcPeriodo);
		arg0.appendChild(lcEstadoSem);
		arg0.appendChild(lcDependencia);
	}

	public void onClick$btnCrear(Event ev) {	

		java.io.InputStream zulInput = this.getClass().getClassLoader().getResourceAsStream("com/proint1/udea/administracion/vista/CrearSemestre.zul") ;
		java.io.Reader zulReader = new java.io.InputStreamReader(zulInput);
		try {
			Component c = Executions.createComponentsDirectly(zulReader,"zul",null,new HashMap<String, Object>()) ;
			Window win = (Window)c;
			win.doModal();
			System.out.println("despues del do");
			definirModelo();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error("ERROR",e);
		}		
	}		


	public void onClick$btnEliminar(Event ev) {		
		
		if (lsxSemestre.getSelectedIndex() == -1)
		{
			Messagebox.show("Debe seleccionar un item de la lista", "Información", Messagebox.OK, Messagebox.INFORMATION);			
		}
		else
		{
			Messagebox.show("¿Desea eliminar el semestre seleccionado?", "Confirmación", Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION, new org.zkoss.zk.ui.event.EventListener() {
			    public void onEvent(Event evt) throws InterruptedException {
			        if (evt.getName().equals("onOK")) {
			        	SemestreDTO dto =(SemestreDTO) lsxSemestre.getModel().getElementAt(lsxSemestre.getSelectedIndex());
			        	semestresOpInt.eliminarSemestre(dto);
			    		alert("Semestre Eliminado");	
			        } 
			    }
			});
			
			List<SemestreDTO> listaSemestres = semestresOpInt.getSemestreList();
			ListModel model = new ListModelList(listaSemestres);
			lsxSemestre.setModel(model);
			lsxSemestre.setItemRenderer(this);			
		}
		
		
	}

	public void onClick$btnEditar(Event ev) {	
		
		
		
		if (lsxSemestre.getSelectedIndex() == -1)
		{
			Messagebox.show("Debe seleccionar un item de la lista", "Información", Messagebox.OK, Messagebox.INFORMATION);
			
		}
		else
		{
			SemestreDTO dto =(SemestreDTO) lsxSemestre.getModel().getElementAt(lsxSemestre.getSelectedIndex());	
			
			HashMap<String, Object> params = new HashMap<String, Object>();
			params.put("dtoSemestre", dto);		
			
			java.io.InputStream zulInput = this.getClass().getClassLoader().getResourceAsStream("com/proint1/udea/administracion/vista/EditarSemestre.zul") ;
			java.io.Reader zulReader = new java.io.InputStreamReader(zulInput);
			try {
				Component c = Executions.createComponentsDirectly(zulReader,"zul",null,params) ;
				Window win = (Window)c;
				win.doModal();
				System.out.println("despues del do");
				definirModelo();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				logger.error("ERROR",e);
			}
		}				
	}

	public SemestreOperacionesIntDAO getSemestresOpInt() {
		return semestresOpInt;
	}

	public void setSemestresOpInt(SemestreOperacionesIntDAO semestresOpInt) {
		this.semestresOpInt = semestresOpInt;
	}



}

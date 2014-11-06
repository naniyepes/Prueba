package com.proint1.udea.actividad.ctl;

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

import com.proint1.udea.actividad.dao.DocGrupoDTO;
import com.proint1.udea.actividad.entidades.TipoActividad;
import com.proint1.udea.actividad.ngc.DocGrupoOperacionesIntDAO;
import com.proint1.udea.actividad.ngc.TipoActividadInterfaceDAO;

public class AdministrarTipoActividadesCtl extends GenericForwardComposer implements ListitemRenderer {

	Toolbarbutton btnCrear;
	Toolbarbutton btnEditar;
	Toolbarbutton btnEliminar;
	Listbox lsxTipoAct;	


	private static Logger logger=Logger.getLogger(AdministrarTipoActividadesCtl.class);

	//interface que sirve como guia para implementar la funciones de la clase grupo
	TipoActividadInterfaceDAO tipoActOpInt;

	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		logger.info("cargando ventana de Tipo Actividades");         

	}

	//cuando se este creando se implementa el metodo definirModelo.
	public void onCreate() {
		definirModelo();
	}
	
	private void definirModelo() {
		List<TipoActividad> listaTipoActividades = tipoActOpInt.getTipoActividadList();
		ListModel model = new ListModelList(listaTipoActividades);
		lsxTipoAct.setModel(model);
		lsxTipoAct.setItemRenderer(this);
	}

	@Override
	public void render(Listitem arg0, Object arg1, int arg2) throws Exception {
		TipoActividad tipoAct = (TipoActividad)arg1;
		Listcell lcNombre = new Listcell(tipoAct.getNombre());
		Listcell lcDescripcion = new Listcell(tipoAct.getDescripcion());
		arg0.appendChild(lcNombre);
		arg0.appendChild(lcDescripcion);
	}

	public void onClick$btnCrear(Event ev) {	

		java.io.InputStream zulInput = this.getClass().getClassLoader().getResourceAsStream("com/proint1/udea/actividad/vista/CrearTipoActividad.zul") ;
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
		
		if (lsxTipoAct.getSelectedIndex() == -1)
		{
			Messagebox.show("Debe seleccionar un item de la lista", "Información", Messagebox.OK, Messagebox.INFORMATION);			
		}
		else
		{
			Messagebox.show("¿Desea eliminar el tipo de actividad seleccionado?", "Confirmación", Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION, new org.zkoss.zk.ui.event.EventListener() {
			    public void onEvent(Event evt) throws InterruptedException {
			        if (evt.getName().equals("onOK")) {
			        	TipoActividad dto =(TipoActividad) lsxTipoAct.getModel().getElementAt(lsxTipoAct.getSelectedIndex());			
			        	tipoActOpInt.eliminarTipoActividad(dto);
			    		alert("Tipo Actividad Eliminado");	
			        } 
			    }
			});
			
			List<TipoActividad> listaTipoAct = tipoActOpInt.getTipoActividadList();
			ListModel model = new ListModelList(listaTipoAct);
			lsxTipoAct.setModel(model);
			lsxTipoAct.setItemRenderer(this);			
		}		
	}

	public void onClick$btnEditar(Event ev) {	
		
		
		
		if (lsxTipoAct.getSelectedIndex() == -1)
		{
			Messagebox.show("Debe seleccionar un item de la lista", "Información", Messagebox.OK, Messagebox.INFORMATION);
			
		}
		else
		{
			TipoActividad dto =(TipoActividad) lsxTipoAct.getModel().getElementAt(lsxTipoAct.getSelectedIndex());		
			
			HashMap<String, Object> params = new HashMap<String, Object>();
			params.put("dtoTipoAct", dto);		
			
			java.io.InputStream zulInput = this.getClass().getClassLoader().getResourceAsStream("com/proint1/udea/actividad/vista/EditarTipoActividad.zul") ;
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

	public TipoActividadInterfaceDAO getTipoActOpInt() {
		return tipoActOpInt;
	}

	public void setTipoActOpInt(TipoActividadInterfaceDAO tipoActOpInt) {
		this.tipoActOpInt = tipoActOpInt;
	}
	
	


}

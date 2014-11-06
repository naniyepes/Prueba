package com.proint1.udea.actividad.ctl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Toolbarbutton;
import org.zkoss.zul.Window;

import com.proint1.udea.actividad.dao.DocGrupoDTO;
import com.proint1.udea.actividad.ngc.DocGrupoOperacionesIntDAO;
import com.proint1.udea.administracion.dto.SumaryGruposDTO;
import com.proint1.udea.administracion.entidades.academico.Curso;

public class AdministrarDocGruposCtl extends GenericForwardComposer implements ListitemRenderer {

	Toolbarbutton btnCrear;
	Toolbarbutton btnEditar;
	Toolbarbutton btnEliminar;
	Listbox lsxDocGrupo;	


	private static Logger logger=Logger.getLogger(AdministrarDocGruposCtl.class);

	//interface que sirve como guia para implementar la funciones de la clase grupo
	DocGrupoOperacionesIntDAO docGruposOpInt;

	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		logger.info("cargando ventana de Docente por Grupos");         

	}

	//cuando se este creando se implementa el metodo definirModelo.
	public void onCreate() {
		definirModelo();
	}
	
	private void definirModelo() {
		List<DocGrupoDTO> listaGrupos = docGruposOpInt.getDocGrupoList();
		ListModel model = new ListModelList(listaGrupos);
		lsxDocGrupo.setModel(model);
		lsxDocGrupo.setItemRenderer(this);
	}

	@Override
	public void render(Listitem arg0, Object arg1, int arg2) throws Exception {
		DocGrupoDTO docGrupo = (DocGrupoDTO)arg1;
		Listcell lcIdCurso = new Listcell(docGrupo.getIdCurso());
		Listcell lcNomCurso = new Listcell(docGrupo.getNombreCurso());
		Listcell lcNomDocente = new Listcell(docGrupo.getNombreDocente());
		Listcell lcNumGrupo = new Listcell(docGrupo.getNumeroGrupo());
		arg0.appendChild(lcIdCurso);
		arg0.appendChild(lcNomCurso);
		arg0.appendChild(lcNomDocente);
		arg0.appendChild(lcNumGrupo);
	}

	public void onClick$btnCrear(Event ev) {	

		java.io.InputStream zulInput = this.getClass().getClassLoader().getResourceAsStream("com/proint1/udea/actividad/vista/CrearDocGrupo.zul") ;
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
		
		if (lsxDocGrupo.getSelectedIndex() == -1)
		{
			Messagebox.show("Debe seleccionar un item de la lista", "Información", Messagebox.OK, Messagebox.INFORMATION);			
		}
		else
		{
			Messagebox.show("¿Desea eliminar el docente por grupo seleccionado?", "Confirmación", Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION, new org.zkoss.zk.ui.event.EventListener() {
			    public void onEvent(Event evt) throws InterruptedException {
			        if (evt.getName().equals("onOK")) {
			        	DocGrupoDTO dto =(DocGrupoDTO) lsxDocGrupo.getModel().getElementAt(lsxDocGrupo.getSelectedIndex());			
			        	docGruposOpInt.eliminarDocGrupo(dto);
			    		alert("Curso Eliminado");	
			        } 
			    }
			});
			
			List<DocGrupoDTO> listaGrupos = docGruposOpInt.getDocGrupoList();
			ListModel model = new ListModelList(listaGrupos);
			lsxDocGrupo.setModel(model);
			lsxDocGrupo.setItemRenderer(this);			
		}		
	}

	public void onClick$btnEditar(Event ev) {	
		
		
		
		if (lsxDocGrupo.getSelectedIndex() == -1)
		{
			Messagebox.show("Debe seleccionar un item de la lista", "Información", Messagebox.OK, Messagebox.INFORMATION);
			
		}
		else
		{
			DocGrupoDTO dto =(DocGrupoDTO) lsxDocGrupo.getModel().getElementAt(lsxDocGrupo.getSelectedIndex());		
			
			HashMap<String, Object> params = new HashMap<String, Object>();
			params.put("dtoDocGrupo", dto);		
			
			java.io.InputStream zulInput = this.getClass().getClassLoader().getResourceAsStream("com/proint1/udea/actividad/vista/EditarDocGrupo.zul") ;
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

	public DocGrupoOperacionesIntDAO getDocGruposOpInt() {
		return docGruposOpInt;
	}

	public void setDocGruposOpInt(DocGrupoOperacionesIntDAO docGruposOpInt) {
		this.docGruposOpInt = docGruposOpInt;
	}
	
	



}

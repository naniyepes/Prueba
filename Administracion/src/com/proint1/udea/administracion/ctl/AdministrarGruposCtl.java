package com.proint1.udea.administracion.ctl;

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

import com.proint1.udea.administracion.dao.GrupoDTO;
import com.proint1.udea.administracion.dto.SumaryGruposDTO;
import com.proint1.udea.administracion.entidades.academico.Curso;
import com.proint1.udea.administracion.ngc.CursoIntDAO;
import com.proint1.udea.administracion.ngc.CursoOperacionesIntDAO;
import com.proint1.udea.administracion.ngc.GrupoOperacionesIntDAO;

public class AdministrarGruposCtl extends GenericForwardComposer implements ListitemRenderer {

	Toolbarbutton btnCrear;
	Toolbarbutton btnEditar;
	Toolbarbutton btnEliminar;
	Listbox lsxGrupo;
	


	private static Logger logger=Logger.getLogger(AdministrarGruposCtl.class);

	//interface que sirve como guia para implementar la funciones de la clase grupo
	GrupoOperacionesIntDAO grupoOpInt;

	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		logger.info("cargando ventana de Grupos");         

	}

	//cuando se este creando se implementa el metodo definirModelo.
	public void onCreate() {
		definirModelo();
	}
	
	private void definirModelo() {
		List<GrupoDTO> listaGrupos = grupoOpInt.getGrupoList();
		ListModel model = new ListModelList(listaGrupos);
		lsxGrupo.setModel(model);
		lsxGrupo.setItemRenderer(this);
	}

	@Override
	public void render(Listitem arg0, Object arg1, int arg2) throws Exception {
		GrupoDTO grupo = (GrupoDTO)arg1;
		//Listcell lcSemestre = new Listcell(Integer.toString(grupo.getAgno()));
		Listcell lcSemestre = new Listcell(grupo.getAgno());
		Listcell lcNumCurso = new Listcell(grupo.getIdCurso());
		Listcell lcNombreCurso = new Listcell(grupo.getNombre());
		Listcell lcNumGrupo = new Listcell(grupo.getNumeroGrupo());
		Listcell lcHorario = new Listcell(grupo.getHorario());
		arg0.appendChild(lcSemestre);
		arg0.appendChild(lcNumCurso);
		arg0.appendChild(lcNombreCurso);
		arg0.appendChild(lcNumGrupo);
		arg0.appendChild(lcHorario);
	}

	public void onClick$btnCrear(Event ev) {	

		java.io.InputStream zulInput = this.getClass().getClassLoader().getResourceAsStream("com/proint1/udea/administracion/vista/CrearGrupo.zul") ;
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
		
		if (lsxGrupo.getSelectedIndex() == -1)
		{
			Messagebox.show("Debe seleccionar un item de la lista", "Información", Messagebox.OK, Messagebox.INFORMATION);			
		}
		else
		{
			Messagebox.show("¿Desea eliminar el curso seleccionado?", "Confirmación", Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION, new org.zkoss.zk.ui.event.EventListener() {
			    public void onEvent(Event evt) throws InterruptedException {
			        if (evt.getName().equals("onOK")) {
			        	GrupoDTO dto =(GrupoDTO) lsxGrupo.getModel().getElementAt(lsxGrupo.getSelectedIndex());			
			    		grupoOpInt.eliminarGrupo(dto);
			    		alert("Curso Eliminado");	
			        } 
			    }
			});
			
			List<GrupoDTO> listaGrupos = grupoOpInt.getGrupoList();
			ListModel model = new ListModelList(listaGrupos);
			lsxGrupo.setModel(model);
			lsxGrupo.setItemRenderer(this);			
		}
		
		
	}

	public void onClick$btnEditar(Event ev) {	
		
		
		
		if (lsxGrupo.getSelectedIndex() == -1)
		{
			Messagebox.show("Debe seleccionar un item de la lista", "Información", Messagebox.OK, Messagebox.INFORMATION);
			
		}
		else
		{
			GrupoDTO dto =(GrupoDTO) lsxGrupo.getModel().getElementAt(lsxGrupo.getSelectedIndex());
			logger.info(dto.getAgno());			
			
			HashMap<String, Object> params = new HashMap<String, Object>();
			params.put("dtoGrupo", dto);		
			
			java.io.InputStream zulInput = this.getClass().getClassLoader().getResourceAsStream("com/proint1/udea/administracion/vista/EditarGrupo.zul") ;
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

	public GrupoOperacionesIntDAO getGrupoOpInt() {
		return grupoOpInt;
	}

	public void setGrupoOpInt(GrupoOperacionesIntDAO grupoOpInt) {
		this.grupoOpInt = grupoOpInt;
	}



}

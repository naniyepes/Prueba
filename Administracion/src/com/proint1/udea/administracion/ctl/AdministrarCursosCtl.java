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

import com.proint1.udea.administracion.dao.CursoDTO;
import com.proint1.udea.administracion.ngc.CursoOperacionesIntDAO;

public class AdministrarCursosCtl extends GenericForwardComposer implements ListitemRenderer {

	Toolbarbutton btnCrear;
	Toolbarbutton btnEditar;
	Toolbarbutton btnEliminar;
	Toolbarbutton btnGuardar;
	Listbox lsxCurso;
	Listbox lsxBusqueda;


	private static Logger logger=Logger.getLogger(AdministrarCursosCtl.class);

	CursoOperacionesIntDAO cursoOpInt;

	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		logger.info("cargando ventana de consultar personas");         

	}

	public void onCreate() {
		definirModelo();
	}
	
	private void definirModelo() {
		List<CursoDTO> listaCursos = cursoOpInt.getCursoList();
		ListModel model = new ListModelList(listaCursos);
		lsxCurso.setModel(model);
		lsxCurso.setItemRenderer(this);
	}

	@Override
	public void render(Listitem arg0, Object arg1, int arg2) throws Exception {
		CursoDTO curso = (CursoDTO)arg1;
		Listcell lcIDCurso = new Listcell(curso.getIdCurso());
		Listcell lcNombre = new Listcell(curso.getNombreCurso());
		Listcell lcDependencia = new Listcell(curso.getNombreDependencia());
		arg0.appendChild(lcIDCurso);
		arg0.appendChild(lcNombre);
		arg0.appendChild(lcDependencia);
	}

	public void onClick$btnCrear(Event ev) {	

		java.io.InputStream zulInput = this.getClass().getClassLoader().getResourceAsStream("com/proint1/udea/administracion/vista/CrearCurso.zul") ;
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
		
		if (lsxCurso.getSelectedIndex() == -1)
		{
			Messagebox.show("Debe seleccionar un item de la lista", "Información", Messagebox.OK, Messagebox.INFORMATION);			
		}
		else
		{
			Messagebox.show("¿Desea eliminar el curso seleccionado?", "Confirmación", Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION, new org.zkoss.zk.ui.event.EventListener() {
			    public void onEvent(Event evt) throws InterruptedException {
			        if (evt.getName().equals("onOK")) {
			        	CursoDTO dto =(CursoDTO) lsxCurso.getModel().getElementAt(lsxCurso.getSelectedIndex());			
			    		cursoOpInt.eliminarCurso(dto);
			    		Messagebox.show("Curso Eliminado", "Confirmación", Messagebox.OK, Messagebox.INFORMATION);
			        } 
			    }
			});
			
			List<CursoDTO> listaCursos = cursoOpInt.getCursoList();
			ListModel model = new ListModelList(listaCursos);
			lsxCurso.setModel(model);
			lsxCurso.setItemRenderer(this);			
		}
		
		
	}

	public void onClick$btnEditar(Event ev) {	
		
		
		
		if (lsxCurso.getSelectedIndex() == -1)
		{
			Messagebox.show("Debe seleccionar un item de la lista", "Información", Messagebox.OK, Messagebox.INFORMATION);
			
		}
		else
		{
			CursoDTO dto =(CursoDTO) lsxCurso.getModel().getElementAt(lsxCurso.getSelectedIndex());
			
			logger.info(dto.getIdn());
			
			HashMap<String, Object> params = new HashMap<String, Object>();
			params.put("dtoCurso", dto);		
			
			java.io.InputStream zulInput = this.getClass().getClassLoader().getResourceAsStream("com/proint1/udea/administracion/vista/EditarCurso.zul") ;
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

	/**
	 * @return the cursoOpInt
	 */
	public CursoOperacionesIntDAO getCursoOpInt() {
		return cursoOpInt;
	}

	/**
	 * @param cursoOpInt the cursoOpInt to set
	 */
	public void setCursoOpInt(CursoOperacionesIntDAO cursoOpInt) {
		this.cursoOpInt = cursoOpInt;
	}
	
	

}

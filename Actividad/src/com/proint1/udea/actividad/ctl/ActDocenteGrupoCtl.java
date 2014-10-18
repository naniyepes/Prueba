package com.proint1.udea.actividad.ctl;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

import com.proint1.udea.actividad.dao.RegistrarActividadDTO;
import com.proint1.udea.actividad.ngc.OperacionesSumaryGruposInterfaceDAO;
import com.proint1.udea.administracion.dto.SumaryGruposDTO;

public class ActDocenteGrupoCtl extends GenericForwardComposer implements ListitemRenderer {
	
	/**serialVersionUID**/
	private static final long serialVersionUID = 5871637228805348166L;

	/**Lista de actividades*/
	Listbox lsxActividades;
	
	private static Logger logger=Logger.getLogger(ActDocenteGrupoCtl.class);
	
	/**DAO*/
	private OperacionesSumaryGruposInterfaceDAO actDocenteGrupoInt;
	
	/**DTo ppal del curso la que se estan registrando tiempos*/
	private SumaryGruposDTO sumaryGruposDto;
	/**DTO para el registro de actividades*/
	private RegistrarActividadDTO registrarActividadDTO;
	/** Nro de registros */
	private int nroRegistros = 0;
	
	public void onCreate() {
		definirModelo();
	}
	
	/**
	 * 
	 */
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
	
	/**
	 * Define el modelo del la vista
	 */
	private void definirModelo() {
		List<RegistrarActividadDTO> listaActividades = actDocenteGrupoInt.getActividadesList(sumaryGruposDto.getIdn());
		if(listaActividades==null){
			listaActividades = new ArrayList<RegistrarActividadDTO>();
		}
		ListModel model = new ListModelList(listaActividades);
		lsxActividades.setModel(model);
		nroRegistros = 0;
		lsxActividades.setItemRenderer(this);
	}

	@Override
	public void render(Listitem arg0, Object arg1, int arg2) throws Exception {
		RegistrarActividadDTO regActividades = (RegistrarActividadDTO)arg1;
		
		nroRegistros++;
		Listcell lc0 = new Listcell(String.valueOf(nroRegistros));
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Listcell lcFecha = new Listcell(formatter.format(regActividades.getFecha()));
		Listcell lcTipoActividad = new Listcell(regActividades.getNombreTipo());
		Listcell lcDescripcion = new Listcell(regActividades.getDescripcion());
		Button btEditar = new Button("Editar");
		btEditar.addEventListener(Events.ON_CLICK, new EventListener<Event>() {
			@Override
			public void onEvent(Event arg0) throws Exception {
				editarActividadEvent();
			}
		});
		
		Listcell lcEditar = new Listcell();
		btEditar.setParent(lcEditar);
		
		Button btEliminar = new Button("Eliminar");
		btEliminar.addEventListener(Events.ON_CLICK, new EventListener<Event>() {
			@Override
			public void onEvent(Event arg0) throws Exception {
				eliminarActividadEvent();
			}
		});
		
		Listcell lcEliminar = new Listcell();
		btEliminar.setParent(lcEliminar);
		
		arg0.appendChild(lc0);
		arg0.appendChild(lcFecha);
		arg0.appendChild(lcTipoActividad);
		arg0.appendChild(lcDescripcion);
		arg0.appendChild(lcEditar);
		arg0.appendChild(lcEliminar);
	}

	
	protected void eliminarActividadEvent() {
		RegistrarActividadDTO dto =(RegistrarActividadDTO) lsxActividades.getModel().getElementAt(lsxActividades.getSelectedItem().getIndex());
		actDocenteGrupoInt.eliminarActividad(dto.getIdn());
		Messagebox.show("El registro ha sido eliminado satisfactoriamente", "Información", Messagebox.OK, Messagebox.INFORMATION);
		definirModelo();
	}

	/**
	 * Editar una actividad
	 */
	protected void editarActividadEvent() {
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("dtoSumaryGrupos", sumaryGruposDto);		
		RegistrarActividadDTO dto =(RegistrarActividadDTO) lsxActividades.getModel().getElementAt(lsxActividades.getSelectedIndex());
		params.put("registrarActividadDTO", dto);
		java.io.InputStream zulInput = this.getClass().getClassLoader().getResourceAsStream("com/proint1/udea/actividad/vista/AdministrarActividad.zul") ;
		java.io.Reader zulReader = new java.io.InputStreamReader(zulInput);
		try {
			Component c = Executions.createComponentsDirectly(zulReader,"zul",null,params) ;
			Window win = (Window)c;
			win.doModal();
			definirModelo();
		} catch (IOException e) {
			logger.error("ERROR",e);
		}
	}


	/**
	 * Evento para crear una nueva actividad
	 * @param ev
	 */
	public void onClick$btnCrear(Event ev) {	
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("dtoSumaryGrupos", sumaryGruposDto);		
		java.io.InputStream zulInput = this.getClass().getClassLoader().getResourceAsStream("com/proint1/udea/actividad/vista/AdministrarActividad.zul") ;
		java.io.Reader zulReader = new java.io.InputStreamReader(zulInput);
		try {
			Component c = Executions.createComponentsDirectly(zulReader,"zul",null,params) ;
			Window win = (Window)c;
			win.doModal();
			definirModelo();
		} catch (IOException e) {
			logger.error("ERROR",e);
		}
	}
	

	public OperacionesSumaryGruposInterfaceDAO getActDocenteGrupoInt() {
		return actDocenteGrupoInt;
	}

	public void setActDocenteGrupoInt(OperacionesSumaryGruposInterfaceDAO actDocenteGrupoInt) {
		this.actDocenteGrupoInt = actDocenteGrupoInt;
	}	
	
	

}

package com.proint1.udea.actividad.ctl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

import com.proint1.udea.actividad.dao.DocGrupoDTO;
import com.proint1.udea.actividad.entidades.TipoActividad;
import com.proint1.udea.actividad.ngc.DocGrupoOperacionesIntDAO;
import com.proint1.udea.actividad.ngc.TipoActividadInterfaceDAO;
import com.proint1.udea.administracion.entidades.academico.Curso;
import com.proint1.udea.administracion.entidades.academico.Grupo;
import com.proint1.udea.administracion.entidades.academico.Semestre;
import com.proint1.udea.administracion.entidades.dependencias.DependenciaAcademica;
import com.proint1.udea.administracion.entidades.terceros.Docente;

public class CrearTipoActividadCtl extends GenericForwardComposer {
	
	Textbox txtNombre;
	Textbox txtDescripcion;
	
	TipoActividadInterfaceDAO tipoActOpInt;
	
	TipoActividad tipoActividad;
	
	private static Logger logger = Logger.getLogger(CrearTipoActividadCtl.class);

	
	
	public CrearTipoActividadCtl() {
		super();
	}

	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		logger.info("cargando ventana de crear Tipo de Actividades");

	}	

	public void onCreate() {
		
	}
	
	
	
	public void onClick$btnOk(Event ev) {

		
				
		if (txtDescripcion.getValue()!="" && txtNombre.getValue()!="" )
		{
			tipoActividad= new TipoActividad();
			tipoActividad.setNombre(txtNombre.getValue());
			tipoActividad.setDescripcion(txtDescripcion.getValue());

			tipoActOpInt.crearTipoActividad(tipoActividad);
			
			Messagebox.show("Tipo Actividad guardada", "Informacion", Messagebox.OK,Messagebox.INFORMATION);
			self.detach();
		}
		else
		{
			Messagebox.show("Debe ingresar todos los datos", "Informacion", Messagebox.OK,Messagebox.INFORMATION);
		}
	}


	public void onClick$btnCancelar(Event ev) {
		self.detach();
	}

	public TipoActividadInterfaceDAO getTipoActOpInt() {
		return tipoActOpInt;
	}

	public void setTipoActOpInt(TipoActividadInterfaceDAO tipoActOpInt) {
		this.tipoActOpInt = tipoActOpInt;
	}

	public TipoActividad getTipoActividad() {
		return tipoActividad;
	}

	public void setTipoActividad(TipoActividad tipoActividad) {
		this.tipoActividad = tipoActividad;
	}

	
}

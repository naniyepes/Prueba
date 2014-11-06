package com.proint1.udea.actividad.ctl;

import java.util.List;

import org.apache.log4j.Logger;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

import com.proint1.udea.actividad.dao.DocGrupoDTO;
import com.proint1.udea.actividad.entidades.TipoActividad;
import com.proint1.udea.actividad.ngc.DocGrupoOperacionesIntDAO;
import com.proint1.udea.actividad.ngc.TipoActividadInterfaceDAO;
import com.proint1.udea.administracion.entidades.academico.Grupo;
import com.proint1.udea.administracion.entidades.terceros.Docente;

public class EditarTipoActividadCtl extends GenericForwardComposer {

	Textbox txtNombre;
	Textbox txtDescripcion;
	private long idnTipoActividad;
	
	TipoActividadInterfaceDAO tipoActOpInt;
	
	TipoActividad tipoActividad;
	
	private static Logger logger = Logger.getLogger(EditarTipoActividadCtl.class);

		
	
	
	public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        logger.info("cargando ventana de editar Tipo Actividades");         
        tipoActividad = (TipoActividad) Executions.getCurrent().getArg().get("dtoTipoAct");
         
        if (tipoActividad==null)
        {
    		Messagebox.show("No selecciono un Docente por grupo", "Informacion", Messagebox.OK, Messagebox.INFORMATION);
    		self.detach();
        }
        else
        {
        
        	txtNombre.setValue(tipoActividad.getNombre());
        	txtDescripcion.setValue(tipoActividad.getDescripcion());
        	idnTipoActividad = tipoActividad.getNbTacIdn();
        }
        
            
   }
	
	public void onCreate() {
			
	}
	
	public void onClick$btnAceptar(Event ev) {			
		
		
		if (txtDescripcion.getValue()!="" && txtNombre.getValue()!="" )
		{

			tipoActividad= new TipoActividad();
			tipoActividad.setNombre(txtNombre.getValue());
			tipoActividad.setDescripcion(txtDescripcion.getValue());
			tipoActividad.setNbTacIdn(idnTipoActividad);
			
			tipoActOpInt.editarTipoActividad(tipoActividad);
			
			Messagebox.show("Tipo Actividad editado", "Informacion", Messagebox.OK, Messagebox.INFORMATION);
			
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

	public TipoActividad getTipoActividad() {
		return tipoActividad;
	}

	public void setTipoActividad(TipoActividad tipoActividad) {
		this.tipoActividad = tipoActividad;
	}

	public TipoActividadInterfaceDAO getTipoActOpInt() {
		return tipoActOpInt;
	}

	public void setTipoActOpInt(TipoActividadInterfaceDAO tipoActOpInt) {
		this.tipoActOpInt = tipoActOpInt;
	}
	
	
}

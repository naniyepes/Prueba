package com.proint1.udea.actividad.ctl;

import java.text.SimpleDateFormat;
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
import org.zkoss.zul.Textbox;

import com.proint1.udea.actividad.dao.RegistrarActividadDTO;
import com.proint1.udea.actividad.ngc.OperacionesSumaryGruposInterfaceDAO;
import com.proint1.udea.administracion.dto.SumaryGruposDTO;

public class ActDocenteGrupoCtl extends GenericForwardComposer implements ListitemRenderer {
	
	Listbox lsxActividades;
	
	
	private static Logger logger=Logger.getLogger(ActDocenteGrupoCtl.class);
	
	//CursoDTO cursoDTO; 
	//	CursoOperacionesIntDAO cursoOpInt;
	
	OperacionesSumaryGruposInterfaceDAO actDocenteGrupoInt;
	
	SumaryGruposDTO sumaryGruposDto;
	RegistrarActividadDTO registrarActividadDTO;
	
	public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        logger.info("cargando ventana de registrar actividades");         
        sumaryGruposDto = (SumaryGruposDTO) Executions.getCurrent().getArg().get("dtoSumaryGrupos");
         
        if (sumaryGruposDto==null)
        {
    		Messagebox.show("No selecciono un curso", "Informacion", Messagebox.OK, Messagebox.INFORMATION);
    		self.detach();
        }
        else
        {
        	logger.info("cargando ventana de registrar actividades");   
        }
        
            
   }
	
	
	private void definirModelo() {
		List<RegistrarActividadDTO> listaActividades = actDocenteGrupoInt.getRegistrarActividadDTO(sumaryGruposDto.getIdn());
		ListModel model = new ListModelList(listaActividades);
		lsxActividades.setModel(model);
		lsxActividades.setItemRenderer(this);
	}

	@Override
	public void render(Listitem arg0, Object arg1, int arg2) throws Exception {
		RegistrarActividadDTO regActividades = (RegistrarActividadDTO)arg1;
		Listcell lcIDN = new Listcell(Long.toString(regActividades.getIdnDOG()));
		Listcell lcTipoActividad = new Listcell(regActividades.getNombreTipo());
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Listcell lcFecha = new Listcell(formatter.format(regActividades.getFecha()));
		Listcell lcDescripcion = new Listcell(regActividades.getDescripcion());
		arg0.appendChild(lcIDN);
		arg0.appendChild(lcTipoActividad);
		arg0.appendChild(lcFecha);
		arg0.appendChild(lcDescripcion);
	}

	
	public void onCreate() {
		definirModelo();
		
	}
	
	public void onClick$btnAceptar(Event ev) {	
		
		//CursoDTO cursoDTO = new CursoDTO();
		//cursoDTO.setIdCurso(txtIdCurso.getValue());
		//cursoDTO.setNombreCurso(txtNombreCurso.getValue());
		//DependenciaAcademica dtodep =cmbDep.getSelectedItem().getValue();
		//cursoDTO.setIdnDependencia(dtodep.getIdn());
		//cursoDTO.setIdn(Long.parseLong(txtIdn.getValue()));
		//cursoOpInt.editarCurso(cursoDTO);
		Messagebox.show("Curso editado", "Informacion", Messagebox.OK, Messagebox.INFORMATION);
		
		self.detach();
		
	}
	
	public void onClick$btnCancelar(Event ev) {
		self.detach();
	}

	public OperacionesSumaryGruposInterfaceDAO getActDocenteGrupoInt() {
		return actDocenteGrupoInt;
	}

	public void setActDocenteGrupoInt(
			OperacionesSumaryGruposInterfaceDAO actDocenteGrupoInt) {
		this.actDocenteGrupoInt = actDocenteGrupoInt;
	}	
	
	

}

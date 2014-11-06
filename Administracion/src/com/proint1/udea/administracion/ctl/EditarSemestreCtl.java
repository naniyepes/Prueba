package com.proint1.udea.administracion.ctl;

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

import com.proint1.udea.administracion.dao.SemestreDTO;
import com.proint1.udea.administracion.entidades.academico.EstadoSemestre;
import com.proint1.udea.administracion.entidades.academico.Grupo;
import com.proint1.udea.administracion.entidades.terceros.Docente;
import com.proint1.udea.administracion.ngc.SemestreOperacionesIntDAO;

public class EditarSemestreCtl extends GenericForwardComposer {
	/**
	 * 
	 */
	private static final long serialVersionUID = -365686300332483471L;
	
	Textbox txtAgno;
	Textbox txtPeriodo;
	Textbox txtDependencia;
	Combobox cmbEstSem;
	private long idnDependencia;
	private long idnSemestre;
	
	private static Logger logger=Logger.getLogger(AdministrarCursosCtl.class);

	SemestreOperacionesIntDAO semestresOpInt;		

	
	SemestreDTO semestreDTO;
	
	public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        logger.info("cargando ventana de editar cursos");         
        semestreDTO = (SemestreDTO) Executions.getCurrent().getArg().get("dtoSemestre");
         
        if (semestreDTO==null)
        {
    		Messagebox.show("No selecciono un curso", "Informacion", Messagebox.OK, Messagebox.INFORMATION);
    		self.detach();
        }
        else
        {
        	txtAgno.setValue(Integer.toString(semestreDTO.getAgno()));
        	txtPeriodo.setValue(Integer.toString(semestreDTO.getPeriodo()));
        	cmbEstSem.setValue(semestreDTO.getEstadoSemestre());
        	idnDependencia = semestreDTO.getIdnDependencia();
        	idnSemestre = semestreDTO.getIdnSemestre();
        	txtDependencia.setValue(semestreDTO.getNombreDependencia()); 
        }
        
            
   }
	
	public void onCreate() {
		List<EstadoSemestre> listaEstadoSemestre = semestresOpInt.getEstadoSemestreList();		
		ListModel model = new ListModelList(listaEstadoSemestre );
		cmbEstSem.setModel(model);		
	}
	
	public void onClick$btnAceptar(Event ev) {	
		
		if (cmbEstSem.getSelectedItem()!=null )
		{
			SemestreDTO semDTO = new SemestreDTO();
			EstadoSemestre estSem = cmbEstSem.getSelectedItem().getValue();		
			
			semDTO.setAgno(Integer.parseInt(txtAgno.getValue()));
			semDTO.setEstadoSemestre(estSem.getDescripcion());
			semDTO.setIdnDependencia(idnDependencia);
			semDTO.setIdnEstadoSemestre(estSem.getIdn());
			semDTO.setIdnSemestre(idnSemestre);
			semDTO.setNombreDependencia(txtDependencia.getValue());
			semDTO.setPeriodo(Integer.parseInt(txtPeriodo.getValue()));
			
			semestresOpInt.editarSemestre(semDTO);
			
			Messagebox.show("Semestre editado", "Informacion", Messagebox.OK, Messagebox.INFORMATION);
			
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

	public SemestreOperacionesIntDAO getSemestresOpInt() {
		return semestresOpInt;
	}

	public void setSemestresOpInt(SemestreOperacionesIntDAO semestresOpInt) {
		this.semestresOpInt = semestresOpInt;
	}

	public SemestreDTO getSemestreDTO() {
		return semestreDTO;
	}

	public void setSemestreDTO(SemestreDTO semestreDTO) {
		this.semestreDTO = semestreDTO;
	}
}

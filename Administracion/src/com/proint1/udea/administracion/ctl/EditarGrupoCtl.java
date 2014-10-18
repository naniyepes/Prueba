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

import com.proint1.udea.administracion.dao.CursoDTO;
import com.proint1.udea.administracion.dao.GrupoDTO;
import com.proint1.udea.administracion.entidades.academico.Curso;
import com.proint1.udea.administracion.entidades.dependencias.DependenciaAcademica;
import com.proint1.udea.administracion.ngc.CursoOperacionesIntDAO;
import com.proint1.udea.administracion.ngc.GrupoOperacionesIntDAO;

public class EditarGrupoCtl extends GenericForwardComposer {
	Textbox txtNumeroGrupo;
	Textbox txtHorario;
	Textbox txtIDCurso;
	Textbox txtNombreCurso;
	
	long idnGrupo;
	
	private static Logger logger=Logger.getLogger(AdministrarCursosCtl.class);
	
	GrupoDTO grupoDTO;
	
	GrupoOperacionesIntDAO grupoOpInt;
	
	
	public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        logger.info("cargando ventana de editar cursos");         
        grupoDTO = (GrupoDTO) Executions.getCurrent().getArg().get("dtoGrupo");
         
        if (grupoDTO==null)
        {
    		Messagebox.show("No selecciono un grupo", "Informacion", Messagebox.OK, Messagebox.INFORMATION);
    		self.detach();
        }
        else
        {
        	txtNumeroGrupo.setValue(grupoDTO.getNumeroGrupo());
        	txtHorario.setValue(grupoDTO.getHorario());
        	txtIDCurso.setValue(grupoDTO.getIdCurso());
        	txtNombreCurso.setValue(grupoDTO.getNombre());
        	idnGrupo = grupoDTO.getIdn();        	  
        	//logger.info(grupoDTO.getIdn());   
    		
        }
        
            
   }
	
	public void onCreate() {
			
	}
	
	public void onClick$btnAceptar(Event ev) {			
		
		
		if (txtNumeroGrupo.getValue()!="" && txtHorario.getValue()!="")
		{
			GrupoDTO grupoDTO = new GrupoDTO();
			
			grupoDTO.setIdn(idnGrupo);		
			grupoDTO.setNumeroGrupo(txtNumeroGrupo.getValue());
			grupoDTO.setHorario(txtHorario.getValue());
			grupoDTO.setIdCurso(txtIDCurso.getValue());   
			grupoDTO.setNombre(txtNombreCurso.getValue());
			
			
			
			grupoOpInt.editarGrupo(grupoDTO);
			
			Messagebox.show("Grupo editado", "Informacion", Messagebox.OK, Messagebox.INFORMATION);
			
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
	

	public GrupoDTO getGrupoDTO() {
		return grupoDTO;
	}

	public void setGrupoDTO(GrupoDTO grupoDTO) {
		this.grupoDTO = grupoDTO;
	}

	public GrupoOperacionesIntDAO getGrupoOpInt() {
		return grupoOpInt;
	}

	public void setGrupoOpInt(GrupoOperacionesIntDAO grupoOpInt) {
		this.grupoOpInt = grupoOpInt;
	}

	

}

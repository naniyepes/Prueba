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
import com.proint1.udea.actividad.ngc.DocGrupoOperacionesIntDAO;
import com.proint1.udea.administracion.entidades.academico.Grupo;
import com.proint1.udea.administracion.entidades.terceros.Docente;

public class EditarDocGrupoCtl extends GenericForwardComposer {
	Textbox txtIDCurso;
	Textbox txtNombreCurso;
	Combobox cmbDocente;
	Combobox cmbGrupo;
	private long idnDocente;
	private long idnGrupo;
	private long idnDocGrupo;
	
	DocGrupoDTO docGrupoDTO;
	
	private static Logger logger = Logger.getLogger(EditarDocGrupoCtl.class);

	
	
	//interface que sirve como guia para implementar la funciones de la clase grupo
	DocGrupoOperacionesIntDAO docGruposOpInt;
		
	
	
	public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        logger.info("cargando ventana de editar docentes por grupo");         
        docGrupoDTO = (DocGrupoDTO) Executions.getCurrent().getArg().get("dtoDocGrupo");
         
        if (docGrupoDTO==null)
        {
    		Messagebox.show("No selecciono un Docente por grupo", "Informacion", Messagebox.OK, Messagebox.INFORMATION);
    		self.detach();
        }
        else
        {
        	txtIDCurso.setValue(docGrupoDTO.getIdCurso());
        	txtNombreCurso.setValue(docGrupoDTO.getNombreCurso());
        	cmbDocente.setValue(docGrupoDTO.getNombreDocente());
        	cmbGrupo.setValue(docGrupoDTO.getNumeroGrupo());
        	idnDocente = docGrupoDTO.getIdnDocente();
        	idnGrupo = docGrupoDTO.getIdnGrupo();
        	idnDocGrupo = docGrupoDTO.getIdnDocGrupo();    		
        }
        
            
   }
	
	public void onCreate() {
		List<Docente> listaDocente = docGruposOpInt.getDocenteList();		
		ListModel model1 = new ListModelList(listaDocente);
		cmbDocente.setModel(model1);	
		
		List<Grupo> listaGrupo = docGruposOpInt.getGrupoList(txtNombreCurso.getValue());		
		ListModelList model2 = new ListModelList(listaGrupo);
		model2.addSelection(model2.get(0));
		cmbGrupo.setModel(model2);
			
	}
	
	public void onClick$btnAceptar(Event ev) {			
		
		
		if (cmbDocente.getSelectedItem()!=null && cmbGrupo.getSelectedItem()!=null )
		{
			DocGrupoDTO docGrupoDTO = new DocGrupoDTO();
			Docente docente = cmbDocente.getSelectedItem().getValue();
			Grupo grupo = cmbGrupo.getSelectedItem().getValue();			
			
			docGrupoDTO.setIdCurso(txtIDCurso.getValue());
			docGrupoDTO.setIdnDocente(docente.getIdn());
			docGrupoDTO.setIdnGrupo(grupo.getIdn());
			docGrupoDTO.setNombreCurso(txtNombreCurso.getValue());
			docGrupoDTO.setNombreDocente(docente.getNombreCompleto());
			docGrupoDTO.setNumeroGrupo(grupo.getNumeroGrupo());
			docGrupoDTO.setIdnDocGrupo(idnDocGrupo);
			
			
			docGruposOpInt.editarDocGrupo(docGrupoDTO);
			
			Messagebox.show("Docente por Grupo editado", "Informacion", Messagebox.OK, Messagebox.INFORMATION);
			
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

	public DocGrupoDTO getDocGrupoDTO() {
		return docGrupoDTO;
	}

	public void setDocGrupoDTO(DocGrupoDTO docGrupoDTO) {
		this.docGrupoDTO = docGrupoDTO;
	}

	public DocGrupoOperacionesIntDAO getDocGruposOpInt() {
		return docGruposOpInt;
	}

	public void setDocGruposOpInt(DocGrupoOperacionesIntDAO docGruposOpInt) {
		this.docGruposOpInt = docGruposOpInt;
	}
}

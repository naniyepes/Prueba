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
import com.proint1.udea.actividad.ngc.DocGrupoOperacionesIntDAO;
import com.proint1.udea.administracion.entidades.academico.Curso;
import com.proint1.udea.administracion.entidades.academico.Grupo;
import com.proint1.udea.administracion.entidades.academico.Semestre;
import com.proint1.udea.administracion.entidades.dependencias.DependenciaAcademica;
import com.proint1.udea.administracion.entidades.terceros.Docente;

public class CrearDocGrupoCtl extends GenericForwardComposer {
	
	Combobox cmbCurso;
	Combobox cmbDocente;
	Combobox cmbGrupo;
	
	DocGrupoDTO docGrupoDTO;
	
	private static Logger logger = Logger.getLogger(CrearDocGrupoCtl.class);

	
	
	//interface que sirve como guia para implementar la funciones de la clase grupo
	DocGrupoOperacionesIntDAO docGruposOpInt;
		

	/**
	 * 
	 */
	public CrearDocGrupoCtl() {
		super();
	}

	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		logger.info("cargando ventana de crear Docentes por grupos");

	}	

	public void onCreate() {
		List<Curso> listaSemCurso = docGruposOpInt.getSemCursoList();		
		ListModelList model = new ListModelList(listaSemCurso);
		model.addSelection(model.get(0));
		cmbCurso.setModel(model);	
				
		List<Docente> listaDocente = docGruposOpInt.getDocenteList();		
		ListModel model1 = new ListModelList(listaDocente);
		cmbDocente.setModel(model1);	
		onSelect$cmbCurso(null);
	}
	
	public void onSelect$cmbCurso(Event ev){
		if (cmbCurso.getSelectedItem()!=null )
		{
			Curso curso = cmbCurso.getSelectedItem().getValue();
			List<Grupo> listaGrupo = docGruposOpInt.getGrupoList(curso.getNombre());		
			ListModelList model2 = new ListModelList(listaGrupo);
			model2.addSelection(model2.get(0));
			cmbGrupo.setModel(model2);
		}
	}

	public void onClick$btnValidar(Event ev) {
		if (cmbCurso.getSelectedItem()!=null )
		{
			Curso curso = cmbCurso.getSelectedItem().getValue();
			List<Grupo> listaGrupo = docGruposOpInt.getGrupoList(curso.getNombre());		
			ListModelList model2 = new ListModelList(listaGrupo);
			model2.addSelection(model2.get(0));
			cmbGrupo.setModel(model2);
		}
	}
	
	
	
	public void onClick$btnAceptar(Event ev) {

		if(docGrupoDTO==null){
			docGrupoDTO = new DocGrupoDTO();
		}
		
				
		if (cmbCurso.getSelectedItem()!=null && cmbDocente.getSelectedItem()!=null && cmbGrupo.getSelectedItem()!=null )
		{
			Curso curso = cmbCurso.getSelectedItem().getValue();
			Docente docente = cmbDocente.getSelectedItem().getValue();
			Grupo grupo = cmbGrupo.getSelectedItem().getValue();
			
			docGrupoDTO.setIdCurso(curso.getIdCurso());
			docGrupoDTO.setIdnGrupo(grupo.getIdn());
			docGrupoDTO.setNombreCurso(curso.getNombre());
			docGrupoDTO.setNombreDocente(docente.getNombreCompleto());
			docGrupoDTO.setNumeroGrupo(grupo.getNumeroGrupo());		
			docGrupoDTO.setIdnDocente(docente.getIdn());
			docGruposOpInt.almacenarDocGrupo(docGrupoDTO);
			
			Messagebox.show("Docente por Grupo guardado", "Informacion", Messagebox.OK,Messagebox.INFORMATION);
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

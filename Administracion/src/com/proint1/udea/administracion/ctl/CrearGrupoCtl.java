package com.proint1.udea.administracion.ctl;

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

import com.proint1.udea.administracion.dao.CursoDTO;
import com.proint1.udea.administracion.dao.GrupoDTO;
import com.proint1.udea.administracion.entidades.academico.Curso;
import com.proint1.udea.administracion.entidades.academico.Semestre;
import com.proint1.udea.administracion.entidades.dependencias.DependenciaAcademica;
import com.proint1.udea.administracion.entidades.terceros.Docente;
import com.proint1.udea.administracion.ngc.CursoOperacionesIntDAO;
import com.proint1.udea.administracion.ngc.GrupoOperacionesIntDAO;

public class CrearGrupoCtl extends GenericForwardComposer {
	
	Textbox txtNumeroGrupo;
	Textbox txtHorario;
	Combobox cmbCurso;
	
	GrupoDTO grupoDTO;
	
	private static Logger logger = Logger.getLogger(AdministrarGruposCtl.class);

	
	
	//interface que sirve como guia para implementar la funciones de la clase grupo
	GrupoOperacionesIntDAO grupoOpInt;
		

	/**
	 * 
	 */
	public CrearGrupoCtl() {
		super();
	}

	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		logger.info("cargando ventana de crear grupos");

	}	

	public void onCreate() {
		List<Curso> listaSemCurso = grupoOpInt.getSemCursoList();		
		ListModel model = new ListModelList(listaSemCurso);
		cmbCurso.setModel(model);		
	}
	
	
	
	public void onClick$btnAceptar(Event ev) {

		if(grupoDTO==null){
			grupoDTO = new GrupoDTO();
		}
		
				
		if (txtNumeroGrupo.getValue()!="" && txtHorario.getValue()!="" && cmbCurso.getSelectedItem()!=null )
		{
			Curso dtoCurso = cmbCurso.getSelectedItem().getValue();
			
			grupoDTO.setNumeroGrupo(txtNumeroGrupo.getValue());
			grupoDTO.setHorario(txtHorario.getValue());
			grupoDTO.setIdCurso(dtoCurso.getIdCurso());
			grupoDTO.setNombre(dtoCurso.getNombre());
			
			grupoOpInt.almacenarGrupo(grupoDTO);
			
/*			grupoDTO.setAgno(agno)
			grupoDTO.setIdCurso(txtIdCurso.getValue());
			cursoDTO.setNombreCurso(txtNombreCurso.getValue());		
			DependenciaAcademica dtodep =cmbDep.getSelectedItem().getValue();
			cursoDTO.setIdnDependencia(dtodep.getIdn());
			cursoOpInt.almacenarCurso(cursoDTO);*/
			
			Messagebox.show("Grupo guardado", "Informacion", Messagebox.OK,Messagebox.INFORMATION);
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

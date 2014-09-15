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
import com.proint1.udea.administracion.entidades.academico.Curso;
import com.proint1.udea.administracion.entidades.dependencias.DependenciaAcademica;
import com.proint1.udea.administracion.entidades.terceros.Docente;
import com.proint1.udea.administracion.ngc.CursoOperacionesIntDAO;

public class CrearCursoCtl extends GenericForwardComposer {
	Textbox txtIdCurso;
	Textbox txtNombreCurso;
	Combobox cmbDep;

	CursoDTO cursoDTO; 
	
	private static Logger logger = Logger.getLogger(AdministrarCursosCtl.class);

	CursoOperacionesIntDAO cursoOpInt;		

	/**
	 * 
	 */
	public CrearCursoCtl() {
		super();
		//capturamos los parámetros enviados
		cursoDTO = (CursoDTO) Executions.getCurrent().getArg().get("dtoCurso");
       if(cursoDTO!=null){
    	   String al = cursoDTO.getIdCurso();    	   
    	   loadCurso();    	   
       }
	}

	private void loadCurso() {
		txtNombreCurso.setValue(cursoDTO.getNombreCurso());
		txtIdCurso.setValue(cursoDTO.getIdCurso());
		cmbDep.setValue(cursoDTO.getNombreDependencia());		
	}

	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		logger.info("cargando ventana de crear cursos");

	}	

	public void onCreate() {
		List<DependenciaAcademica> listaDependencia = cursoOpInt.getDependenciaList();		
		ListModel model = new ListModelList(listaDependencia);
		cmbDep.setModel(model);
	}
	
	public void onClick$btnAceptar(Event ev) {

		if(cursoDTO==null){
		 cursoDTO = new CursoDTO();
		}
		
		cursoDTO.setIdCurso(txtIdCurso.getValue());
		cursoDTO.setNombreCurso(txtNombreCurso.getValue());		
		DependenciaAcademica dtodep =cmbDep.getSelectedItem().getValue();
		cursoDTO.setIdnDependencia(dtodep.getIdn());
		cursoOpInt.almacenarCurso(cursoDTO);
		Messagebox.show("Curso guardado", "Informacion", Messagebox.OK,Messagebox.INFORMATION);
		self.detach();
	}


	public void onClick$btnCancelar(Event ev) {
		self.detach();
	}

	/**
	 * @return the cursoOpInt
	 */
	public CursoOperacionesIntDAO getCursoOpInt() {
		return cursoOpInt;
	}

	/**
	 * @param cursoOpInt
	 *            the cursoOpInt to set
	 */
	public void setCursoOpInt(CursoOperacionesIntDAO cursoOpInt) {
		this.cursoOpInt = cursoOpInt;
	}

	/**
	 * @return the cursoDTO
	 */
	public CursoDTO getCursoDTO() {
		return cursoDTO;
	}

	/**
	 * @param cursoDTO the cursoDTO to set
	 */
	public void setCursoDTO(CursoDTO cursoDTO) {
		this.cursoDTO = cursoDTO;
	}

	
	
}

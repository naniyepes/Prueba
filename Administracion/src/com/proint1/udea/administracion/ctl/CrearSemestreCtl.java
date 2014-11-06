package com.proint1.udea.administracion.ctl;

import java.util.List;

import org.apache.log4j.Logger;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

import com.proint1.udea.administracion.dao.EstadoSemestreDAO;
import com.proint1.udea.administracion.dao.SemestreDTO;
import com.proint1.udea.administracion.entidades.academico.EstadoSemestre;
import com.proint1.udea.administracion.entidades.dependencias.DependenciaAcademica;
import com.proint1.udea.administracion.ngc.SemestreOperacionesIntDAO;

public class CrearSemestreCtl extends GenericForwardComposer {
	Textbox txtAgno;
	Textbox txtPeriodo;
	Combobox cmbEstSem;
	Combobox cmbDep;

	
	
	private static Logger logger = Logger.getLogger(CrearSemestreCtl.class);

	SemestreOperacionesIntDAO semestresOpInt;		

	
	SemestreDTO semestreDTO;
	
	/**
	 * 
	 */
	public CrearSemestreCtl() {
		super();
	}

	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		logger.info("cargando ventana de crear semestres");

	}	

	public void onCreate() {
		List<DependenciaAcademica> listaDependencia = semestresOpInt.getDependenciaList();		
		ListModel model = new ListModelList(listaDependencia);
		cmbDep.setModel(model);
		
		List<EstadoSemestre> listaEstadoSemestre = semestresOpInt.getEstadoSemestreList();		
		ListModel model1 = new ListModelList(listaEstadoSemestre );
		cmbEstSem.setModel(model1);
	}
	
	public void onClick$btnAceptar(Event ev) {

		if(semestreDTO==null){
			semestreDTO = new SemestreDTO();
		}
		
		if (txtAgno.getValue()!="" && txtPeriodo.getValue()!="" && cmbDep.getSelectedItem()!=null && cmbEstSem.getSelectedItem()!=null)
		{
			EstadoSemestre estSem = cmbEstSem.getSelectedItem().getValue();
			DependenciaAcademica dtodep =cmbDep.getSelectedItem().getValue();
			
			semestreDTO.setAgno(Integer.parseInt(txtAgno.getValue()));
			semestreDTO.setIdnEstadoSemestre(estSem.getIdn());
			semestreDTO.setEstadoSemestre(estSem.getDescripcion());
			semestreDTO.setIdnDependencia(dtodep.getIdn());
			semestreDTO.setNombreDependencia(dtodep.getNombre());
			semestreDTO.setPeriodo(Integer.parseInt(txtPeriodo.getValue()));
			
			semestresOpInt.almacenarSemestre(semestreDTO);
			
			Messagebox.show("Semestre guardado", "Informacion", Messagebox.OK,Messagebox.INFORMATION);
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

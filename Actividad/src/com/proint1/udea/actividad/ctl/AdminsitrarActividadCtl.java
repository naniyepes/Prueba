package com.proint1.udea.actividad.ctl;

import java.util.Date;
import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

import com.proint1.udea.actividad.dao.RegistrarActividadDTO;
import com.proint1.udea.actividad.entidades.TipoActividad;
import com.proint1.udea.actividad.ngc.OperacionesSumaryGruposInterfaceDAO;
import com.proint1.udea.administracion.dto.SumaryGruposDTO;

public class AdminsitrarActividadCtl extends GenericForwardComposer {

	/**serialVersionUID**/
	private static final long serialVersionUID = -5549658693144054872L;
	
	/** dao de operaciones*/
	@WireVariable
	private OperacionesSumaryGruposInterfaceDAO operacionesInt;
	
	/**DTo ppal del curso la que se estan registrando tiempos*/
	private SumaryGruposDTO sumaryGruposDto;
	
	
	@Wire
	private Datebox fechaActividadDateBox;
	
	@Wire
	private Combobox tipoActividadCombo;
	
	@Wire
	private Textbox descripcionTextBox;
	
	/**DTO para registrar o editar una actividad**/
	private RegistrarActividadDTO registrarActividadDTO;
	
	
	/**
	 * 
	 */
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		Selectors.wireComponents(comp, this, false);
		sumaryGruposDto = (SumaryGruposDTO) Executions.getCurrent().getArg().get("dtoSumaryGrupos");
		registrarActividadDTO = (RegistrarActividadDTO) Executions.getCurrent().getArg().get("registrarActividadDTO");
		if(registrarActividadDTO!=null){
			cargarActividad();
		}else{
			fechaActividadDateBox.setValue(new Date());
		}
	}
	
	
	/**
	 * Carga una actividad para edición
	 */
	private void cargarActividad() {
		fechaActividadDateBox.setValue(registrarActividadDTO.getFecha());
		tipoActividadCombo.setValue(registrarActividadDTO.getNombreTipo());
		descripcionTextBox.setValue(registrarActividadDTO.getDescripcion());
	}



	public void onCreate() {
		List<TipoActividad> tipoActividadList = operacionesInt.getTipoActividadesList();		
		ListModel model = new ListModelList(tipoActividadList);
		tipoActividadCombo.setModel(model);
	}

	/**
	 * Evento para guardar una actividad
	 * @param ev
	 */
	public void onClick$BtnGuardar(Event ev) {
		if(registrarActividadDTO==null){
			registrarActividadDTO = new RegistrarActividadDTO();
			registrarActividadDTO.setIdnDOG(sumaryGruposDto.getIdn());
			registrarActividadDTO.setFecha(fechaActividadDateBox.getValue());
			registrarActividadDTO.setDescripcion(descripcionTextBox.getText());
			registrarActividadDTO.setTipoActividad((TipoActividad)tipoActividadCombo.getSelectedItem().getValue());
			operacionesInt.guardarActividad(registrarActividadDTO);
		}else{
			registrarActividadDTO.setFecha(fechaActividadDateBox.getValue());
			registrarActividadDTO.setDescripcion(descripcionTextBox.getText());
			registrarActividadDTO.setTipoActividad((TipoActividad)tipoActividadCombo.getSelectedItem().getValue());
			operacionesInt.actualizarActividad(registrarActividadDTO);
		}
		Messagebox.show("La actividad ha sido guardada", "Información", Messagebox.OK, Messagebox.INFORMATION);
		self.detach();
	}
	
    public void onClick$BtnCancelar(Event ev) {
    	self.detach();
	}
	
	
	/**
	 * @return the operacionesInt
	 */
	public OperacionesSumaryGruposInterfaceDAO getOperacionesInt() {
		return operacionesInt;
	}

	/**
	 * @param operacionesInt the operacionesInt to set
	 */
	public void setOperacionesInt(OperacionesSumaryGruposInterfaceDAO operacionesInt) {
		this.operacionesInt = operacionesInt;
	}
}

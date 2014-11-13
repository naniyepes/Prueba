package com.proint1.udea.actividad.ctl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.SelectEvent;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;
import org.zkoss.zul.Toolbarbutton;
import org.zkoss.zul.Window;

import com.proint1.udea.actividad.ngc.OperacionesSumaryGruposInterfaceDAO;
import com.proint1.udea.administracion.dto.SumaryGruposDTO;
import com.proint1.udea.administracion.entidades.terceros.Docente;

/**
 * Permite crear un Sumario de grupos asignados a un {@link Docente} logueado
 * @author Juan Cardona
 * @since 23/06/2014
 */
public class SumaryGrupoCtl extends GenericForwardComposer implements ListitemRenderer<Object> {

	/** serialVersionUID **/
	private static final long serialVersionUID = -7024470034429612586L;
	private static Logger logger = Logger.getLogger(SumaryGrupoCtl.class);

	/** Docente activo */
	private Docente docenteActivo;

	Toolbarbutton btnVerResumen;
	Toolbarbutton btnRegistrarActividad;
	
	/**
	 * dao de operaciones
	 */
	@WireVariable
	OperacionesSumaryGruposInterfaceDAO sumaryGrupoInt;
	@Wire
	Listbox listaGrupos;

	/** Nro de registros */
	private int nroRegistros = 0;

	@AfterCompose
	public void afterCompose(@ContextParam(ContextType.VIEW) Component view) {
		Selectors.wireComponents(view, this, false);
		definirModelo();
	}

	/**
	 * Constructor
	 */
	public SumaryGrupoCtl() {
		super();
		// capturamos los parámetros enviados
		docenteActivo = (Docente) Executions.getCurrent().getArg().get("docente");
	}

	/**
	 * @param separator
	 */
	public SumaryGrupoCtl(char separator) {
		super(separator);
	}

	public void onCreate() {
		definirModelo();
	}

	/**
	 * Define los datos de la lista
	 */
	private void definirModelo() {
		List<SumaryGruposDTO> listaSumaryGrupo = sumaryGrupoInt.getSumariGrupoDTOPorDocenteIdn(getDocenteActivo().getIdn());
		ListModel<SumaryGruposDTO> model = new ListModelList<SumaryGruposDTO>(listaSumaryGrupo);
		listaGrupos.setModel(model);
		listaGrupos.setItemRenderer(this);
		listaGrupos.setMultiple(false);
		nroRegistros = 0;
	}

	public void onSelect$listaGrupos(SelectEvent evt) {
	}
	
	@Override
	/**
	 * Evento que alimenta la lsista
	 */
	public void render(Listitem lista, Object arg1, int arg2) throws Exception {
		SumaryGruposDTO dto = (SumaryGruposDTO) arg1;
		nroRegistros++;
		Listcell lc0 = new Listcell(String.valueOf(nroRegistros));
		Listcell lcDependencia = new Listcell(dto.getNombreDependencia());
		Listcell lcSemestre = new Listcell(dto.getSemestre());
		Listcell lcCodCurso = new Listcell(dto.getCodigoCurso());
		Listcell lcNomCurso = new Listcell(dto.getNombreCurso());
		Listcell lcModCurso = new Listcell(dto.getModalidadCurso());
		Listcell lcnGruponro = new Listcell(dto.getGrupoNumero());
		Listcell lcnHorario = new Listcell(dto.getHorario());
		
		Button btnAdministrar = new Button("Administrar");
		btnAdministrar.addEventListener(Events.ON_CLICK, new EventListener<Event>() {
			@Override
			public void onEvent(Event arg0) throws Exception {
				Listitem liSelected = (Listitem)arg0.getTarget().getParent().getParent();
				administrarActividades(liSelected);
			}
		});
		
		Listcell lcAdministrar = new Listcell();
		btnAdministrar.setParent(lcAdministrar);
		// Se llena la lista con las celdas anteriores
		lista.appendChild(lc0);
		lista.appendChild(lcDependencia);
		lista.appendChild(lcSemestre);
		lista.appendChild(lcCodCurso);
		lista.appendChild(lcNomCurso);
		lista.appendChild(lcModCurso);
		lista.appendChild(lcnGruponro);
		lista.appendChild(lcnHorario);
		lista.appendChild(lcAdministrar);
	}
	

	/**
	 * Administra las actividades de un registro seleccionado
	 */
	public void administrarActividades(Listitem liSelected){
//		SumaryGruposDTO dto =(SumaryGruposDTO) listaGrupos.getModel().getElementAt(listaGrupos.getSelectedItem().getIndex());
		SumaryGruposDTO dto =(SumaryGruposDTO) listaGrupos.getModel().getElementAt(liSelected.getIndex());
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("dtoSumaryGrupos", dto);		
		java.io.InputStream zulInput = this.getClass().getClassLoader().getResourceAsStream("com/proint1/udea/actividad/vista/ActDocenteGrupo.zul") ;
		java.io.Reader zulReader = new java.io.InputStreamReader(zulInput);
		try {
			Component c = Executions.createComponentsDirectly(zulReader,"zul",null,params) ;
			Window win = (Window)c;
			win.doModal();
			definirModelo();
		} catch (IOException e) {
			logger.error("ERROR",e);
		}
	}

	
	/**
	 * @return the sumaryGrupoInt
	 */
	public OperacionesSumaryGruposInterfaceDAO getSumaryGrupoInt() {
		return sumaryGrupoInt;
	}

	/**
	 * @param sumaryGrupoInt
	 *            the sumaryGrupoInt to set
	 */
	public void setSumaryGrupoInt(OperacionesSumaryGruposInterfaceDAO sumaryGrupoInt) {
		this.sumaryGrupoInt = sumaryGrupoInt;
	}

	/**
	 * @return the docenteActivo
	 */
	public Docente getDocenteActivo() {
		return docenteActivo;
	}

	/**
	 * @param docenteActivo
	 *            the docenteActivo to set
	 */
	public void setDocenteActivo(Docente docenteActivo) {
		this.docenteActivo = docenteActivo;
	}

}

package com.proint1.udea.administracion.ctl;

import java.util.List;

import org.apache.log4j.Logger;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;
import org.zkoss.zul.Messagebox;

import com.proint1.udea.administracion.dao.SemestreDAO;
import com.proint1.udea.administracion.entidades.academico.Semestre;
import com.proint1.udea.administracion.entidades.terceros.Docente;



/**
 * Sumario de grupos asignados a un {@link Docente} logueado
 * @author Juan Cardona
 * @since 23/06/2014
 */
public class SumarySemestresCtl extends GenericForwardComposer implements ListitemRenderer<Object> {

	/**serialVersionUID **/
	private static final long serialVersionUID = -7024470034429612586L;
	private static Logger logger=Logger.getLogger(SumarySemestresCtl.class);
	
	/** dao de operaciones*/
	@WireVariable
	SemestreDAO semestreDAO;
	@Wire
	Listbox listaDatos;
	/** Nro de registros*/
	private int nroRegistros = 0;
	

	@AfterCompose
	public void afterCompose(@ContextParam(ContextType.VIEW) Component view){
		Selectors.wireComponents(view, this, false);
		definirModelo();
	}
	
	
	/**
	 * Constructor
	 */
	public SumarySemestresCtl() {
		super();
	}


	/**
	 * @param separator
	 */
	public SumarySemestresCtl(char separator) {
		super(separator);
	}

	public void onCreate() {
		definirModelo();
	}


	/**
	 * Define los datos de la lista
	 */
	private void definirModelo() {
		List<Semestre> listaSumaryDatos = semestreDAO.getSemestreList();
		ListModel<Semestre> model = new ListModelList<Semestre>(listaSumaryDatos);
		nroRegistros=0;
		listaDatos.setModel(model);
		listaDatos.setItemRenderer(this);
	}

	@Override
	/**
	 * Evento que alimenta la lsista
	 */
	public void render(Listitem lista, Object arg1, int arg2) throws Exception {
		Semestre dto = (Semestre)arg1;
		nroRegistros++;
		Listcell lc0 = new Listcell(String.valueOf(nroRegistros));
		Listcell lc1 = new Listcell(dto.getDependenciaAcademica().getNombre());
		Listcell lc2 = new Listcell(String.valueOf(dto.getAgno()));
		Listcell lc3 = new Listcell(String.valueOf(dto.getPeriodo()));
		Listcell lc4 = new Listcell(dto.getEstadoSemestre().getDescripcion());
		
		//Se llena la lista con las celdas anteriores
		lista.appendChild(lc0);
		lista.appendChild(lc1);
		lista.appendChild(lc2);
		lista.appendChild(lc3);
		lista.appendChild(lc4);
	}

	
	@Command
	public void  actualizarLink(){
		definirModelo();
	}
	
	@Command
	public void  agregarLink(){
		Messagebox.show("agregarLink","Validación exitosa",Messagebox.OK,Messagebox.INFORMATION);
	}

	
	@Command
	public void  editarLink(){
		Messagebox.show("editarLink","Validación exitosa",Messagebox.OK,Messagebox.INFORMATION);
	}

	
	@Command
	public void  eliminarLink(){
		Messagebox.show("eliminarLink","Validación exitosa",Messagebox.OK,Messagebox.INFORMATION);
	}
}

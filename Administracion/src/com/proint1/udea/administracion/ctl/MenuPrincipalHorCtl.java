package com.proint1.udea.administracion.ctl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Tabpanels;
import org.zkoss.zul.Tabs;

/**
 * Controlador del menú y pantalla principal de la app
 * @author Juan Cardona
 * @since 26/05/2014
 */
public class MenuPrincipalHorCtl implements Serializable {
	
	/**serialVersionUID**/
	private static final long serialVersionUID = -591475821326375416L;
	private static Logger logger=Logger.getLogger(MenuPrincipalHorCtl.class);
	//Componentes UI
	@Wire
	private Tabbox tb_tabbox;
	
	
	@AfterCompose
	public void afterCompose(@ContextParam(ContextType.VIEW) Component view){
		Selectors.wireComponents(view, this, false);
		logger.info("cargando MenuPrincipalHorCtl");  
	}
	
	@Command
	public void administracionLink(){
		//agregarTab("Consultar Persona 1", "v1", "V1.zul");
	}
	
	
	@Command
	public void regActividadesLink(){
		if(validarUsuario()){
			if(validarDocente()){
				Map<String, Object> arguments = new HashMap<String, Object>();
				arguments.put("docente",  WebSessionAccesor.getDocente());
				agregarTab("Sumario Grupos", "sg1", "SumaryGrupos.zul",arguments);
			}else{
				Messagebox.show("El usuario actual no es un docente","Opción no accesible",Messagebox.OK,Messagebox.EXCLAMATION);
			}
		}
	}
	
	
	@Command
	public void admSemestresLink(){
		if(validarUsuario()){
			agregarTab("Administar Semestres", "ads1", "SumarySemestres.zul",null);
		}
	}
	
	@Command
	public void admCursosLink(){
		if(validarUsuario()){
			agregarTab("Administar Cursos", "admc1", "AdministrarCursos.zul",null);
		}
	}
	
	
	

	/**
	 * Valida si hay un docente activo en la aplicación
	 * @return
	 */
	private boolean validarDocente() {
		return WebSessionAccesor.getDocente()!=null;
	}

	/**
	 * Funcion que valida que haya un usuario autenticado
	 */
	private boolean validarUsuario() {
		if(WebSessionAccesor.getUsuario()==null){
			agregarTab("Login", "login1", "Login.zul",null);
			return false;
		}
		return true;
	}

	/**
	 * Funcionalidad para agregar un tab al tabbcontrol 
	 * @param titulo Titulo del tab
	 * @param id Identificador unico para no permitir mas de una instancia
	 * @param zul Uri del archivo zul
	 */
	private void agregarTab(String titulo, String id, String zul, Map<String, Object> arguments) {
		if(arguments==null){
			arguments = new HashMap<String, Object>();
		}
		Tabpanel tabpanel = new Tabpanel();
		Tab tab = new Tab(titulo);
		tab.setId(id);
		//Validar que el tab no este instanciado
		if(getTb_tabbox().hasFellow(id)){
			Messagebox.show("Ya esta abierta la ventana!");
			return;
		}

		tab.setClosable(true);
		tab.setSelected(true);
		if (getTb_tabbox().getTabs() == null){
			getTb_tabbox().appendChild(new Tabs());   
			getTb_tabbox().appendChild(new Tabpanels());   
		}

		getTb_tabbox().getTabs().appendChild(tab);
		//Agrgar argumento para el id
		arguments.put("tabularIndex", tab.getIndex());
		getTb_tabbox().getTabpanels().appendChild(tabpanel);
		getTb_tabbox().invalidate();

		//Crear el nuevo tab y su respectivo panel
		Executions.createComponents(zul, tabpanel, arguments);
	}

	/**
	 * Valida si el tabbox esta null en caso tal lo instancia
	 * @return
	 */
	Tabbox getTb_tabbox() {
		if(tb_tabbox==null){
			tb_tabbox = (Tabbox)Sessions.getCurrent().getAttribute("tb_tabboxCtl");
		}
		return tb_tabbox;
	}
}

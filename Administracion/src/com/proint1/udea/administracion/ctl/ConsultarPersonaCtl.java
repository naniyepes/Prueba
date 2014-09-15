package com.proint1.udea.administracion.ctl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;
import org.zkoss.zul.Window;

import com.proint1.udea.administracion.PersonaEjemplo;
import com.proint1.udea.administracion.ngc.PersonaInt;

public class ConsultarPersonaCtl extends GenericForwardComposer implements ListitemRenderer {

Listbox lsxPersona;
Button btnCrear;

private static Logger logger=Logger.getLogger(ConsultarPersonaCtl.class);

PersonaInt personaInt;
	
    public PersonaInt getPersonaInt() {
	return personaInt;
}

public void setPersonaInt(PersonaInt personaInt) {
	this.personaInt = personaInt;
}

	public void doAfterCompose(Component comp) throws Exception {
         super.doAfterCompose(comp);
         logger.info("cargando ventana de consultar personas");         
       
    }
	
	public void onCreate() {
		 definirModelo();
	}

	private void definirModelo() {
		List<PersonaEjemplo> listaPersonas = personaInt.getPersonas();
		 ListModel model = new ListModelList(listaPersonas);
		 lsxPersona.setModel(model);
		 lsxPersona.setItemRenderer(this);
	}

	@Override
	public void render(Listitem arg0, Object arg1, int arg2) throws Exception {
		PersonaEjemplo persona = (PersonaEjemplo)arg1;
		Listcell lcNombre = new Listcell(persona.getVrNombre());
		Listcell lcApellido = new Listcell(persona.getVrApellido());
		arg0.appendChild(lcNombre);
		arg0.appendChild(lcApellido);
	}
	
	public void onClick$btnCrear(Event ev) {
		java.io.InputStream zulInput = this.getClass().getClassLoader().getResourceAsStream("com/proint1/udea/administracion/vista/crearPersona.zul") ;
		java.io.Reader zulReader = new java.io.InputStreamReader(zulInput);
		try {
			Component c = Executions.createComponentsDirectly(zulReader,"zul",null,new HashMap<String, Object>()) ;
			Window win = (Window)c;
			win.doModal();
			System.out.println("despues del do");
			definirModelo();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error("ERROR",e);
		}		
	}
}

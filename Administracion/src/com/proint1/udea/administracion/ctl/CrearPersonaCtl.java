package com.proint1.udea.administracion.ctl;

import org.apache.log4j.Logger;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

import com.proint1.udea.administracion.PersonaEjemplo;
import com.proint1.udea.administracion.ngc.PersonaInt;
import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;

public class CrearPersonaCtl extends GenericForwardComposer {
	Textbox txtNombre;
	Textbox txtApellido;
	PersonaInt personaInt;
	
    public PersonaInt getPersonaInt() {
		return personaInt;
	}
	
	public void setPersonaInt(PersonaInt personaInt) {
		this.personaInt = personaInt;
	}

	
	private static Logger logger=Logger.getLogger(CrearPersonaCtl.class);
	
	public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        logger.info("cargando ventana de crear personas");         
     }
	
	public void onCreate() {
		
	}
	
	public void onClick$btnAceptar(Event ev) {		
		PersonaEjemplo persona = new PersonaEjemplo();
		persona.setVrApellido(txtApellido.getValue());
		persona.setVrNombre(txtNombre.getValue());
		personaInt.almacenarPersona(persona);
		 Messagebox.show("Persona guardada", "Informacion", Messagebox.OK, Messagebox.INFORMATION);
		self.detach();
		
	}

}

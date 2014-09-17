package com.proint1.udea.administracion.ngc;

import java.util.List;

import com.proint1.udea.administracion.PersonaEjemplo;

public interface PersonaInt {
	
	public List getPersonas();
	
	public void almacenarPersona(PersonaEjemplo persona);
}

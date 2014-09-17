package com.proint1.udea.administracion.ctl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.zhtml.Label;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Textbox;


/**
 * Control princial del index de la app
 * @author Juan Cardona
 * @since 26/05/2014
 */
public class PrincipalCtl implements Serializable{
	/**serialVersionUID **/
	private static final long serialVersionUID = 1739644010794512867L;
	
	/**control del login*/
	@Autowired
	private LoginCtl loginCtl;
	
	
	//Componentes UI
	@Wire 
	Tabbox tb_tabbox;
	
	@Wire
	Textbox nombreUsuario;
	
	@AfterCompose
	public void afterCompose(@ContextParam(ContextType.VIEW) Component view){
		Selectors.wireComponents(view, this, false);
		//Se agrega referencia del tb_tabbox contenedor de la app
		Sessions.getCurrent().setAttribute("tb_tabboxCtl", tb_tabbox);
		Sessions.getCurrent().setAttribute("textboxUsuario", nombreUsuario);
	}
	
	@Command
	public void loginServiceLink(){
		loginCtl.loginServiceLink();
	}

	/**
	 * @return the loginCtl
	 */
	public LoginCtl getLoginCtl() {
		return loginCtl;
	}

	/**
	 * @param loginCtl the loginCtl to set
	 */
	public void setLoginCtl(LoginCtl loginCtl) {
		this.loginCtl = loginCtl;
	}
}
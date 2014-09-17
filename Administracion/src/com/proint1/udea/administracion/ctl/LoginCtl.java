package com.proint1.udea.administracion.ctl;

import java.io.Serializable;

import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

import com.proint1.udea.administracion.entidades.seguridad.Usuario;
import com.proint1.udea.administracion.entidades.terceros.Docente;
import com.proint1.udea.administracion.ngc.LoginNgc;

/**
 * Control del login
 * @author Juan Cardona
 * @since 22/06/2014
 */
public class LoginCtl extends GenericForwardComposer implements Serializable {

	/**serialVersionUID**/
	private static final long serialVersionUID = -4666121412075313388L;
	
	//Componentes UI
	@Wire
	Textbox usuarioTextBox;
	@Wire
	Textbox passwordTextBox;
	
	/**Dao para el login*/
	@WireVariable
	private LoginNgc loginNgc;
	
	/**
	 * 
	 */
	public LoginCtl() {
		super();
		WebSessionAccesor.getUsuarioTextbox().setDisabled(true);
	}


	@AfterCompose
	public void afterCompose(@ContextParam(ContextType.VIEW) Component view){
		Selectors.wireComponents(view, this, false);
	}
	
	
	@Command
	public void loginServiceLink(){
		
		if(usuarioTextBox.getText()==null){
			Messagebox.show("El usuario es obligatorio","Campo Requerido",Messagebox.OK,Messagebox.EXCLAMATION);
			return;
		}
				
		if(passwordTextBox.getText()==null){
			Messagebox.show("La contraseña es obligatoria","Campo Requerido",Messagebox.OK,Messagebox.EXCLAMATION);
			return;
		}	
		validarUsuarioYPassword(usuarioTextBox.getText(),passwordTextBox.getText());
	}

	
	/**
	 * Valdia usuario y contra en bd
	 * @param text
	 * @param text2
	 */
	private void validarUsuarioYPassword(String usuario, String password) {
		Usuario usuarioProy = getLoginNgc().validarUsuario(usuario, password);
		if(usuarioProy==null){
			Messagebox.show("Usuario y/o contraseña incorrectos","Datos inválidos",Messagebox.OK,Messagebox.ERROR);
			usuarioTextBox.setText(null);
			passwordTextBox.setText(null);
			usuarioTextBox.setFocus(true);
		}else{
			WebSessionAccesor.setUsuario(usuarioProy);
			validarUsuarioDocente(usuarioProy);
			WebSessionAccesor.getTabboxAplication().getSelectedTab().detach();
			WebSessionAccesor.getUsuarioTextbox().setValue("Usuario: " + usuarioProy.getNombreCompleto());
			WebSessionAccesor.getUsuarioTextbox().setDisabled(true);
			Messagebox.show("Autenticación exitosa, favor seleccionar nuevamente la opción requerida","Validación exitosa",Messagebox.OK,Messagebox.INFORMATION);
		}
	}


	/**
	 * Busca si hay un decente asosciado a este usuario
	 * @param usuarioProy
	 */
	private void validarUsuarioDocente(Usuario usuario) {
		Docente docente = getLoginNgc().buscarDocente(usuario.getIdentificacion());
		if(docente!=null){
			WebSessionAccesor.setDocente(docente);
		}
	}


	/**
	 * @return the loginNgc
	 */
	public LoginNgc getLoginNgc() {
		return loginNgc;
	}


	/**
	 * @param loginNgc the loginNgc to set
	 */
	public void setLoginNgc(LoginNgc loginNgc) {
		this.loginNgc = loginNgc;
	}
}

package com.proint1.udea.administracion.ctl;

import java.io.Serializable;

import org.zkoss.zhtml.Label;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Textbox;

import com.proint1.udea.administracion.entidades.seguridad.Usuario;
import com.proint1.udea.administracion.entidades.terceros.Docente;


/**
 * Clase para acceder a variable de session como el usuario
 * @author Juan Cardona
 * @since 22/06/2014
 */
public class WebSessionAccesor implements Serializable {

	/**serialVersionUID**/
	private static final long serialVersionUID = 5895060754327960433L;
	/**Variable para identificar el atributo de la session**/
	private static final String USER_ATRIBUTO = "user";
	/**Variable para identifica<r si el el suario actual es un docente*/
	private static final String DOCENTE_ATRIBUTO = "docente";

		
	
	/**
	 * Consulta el usuario logeuado en el sistema
	 * @return {@link Usuario} autenticado en el sistema
	 */
	public static Usuario getUsuario(){
		return (Usuario) Sessions.getCurrent().getAttribute(USER_ATRIBUTO);
	}



	/**
	 * Set de para el usuario actual
	 * @param usuario
	 */
	public static void setUsuario(Usuario usuario) {
		Sessions.getCurrent().setAttribute(USER_ATRIBUTO, usuario);
	}
	
	/**
	 * Docente del sistema
	 * @return
	 */
	public static Docente getDocente(){
		return (Docente) Sessions.getCurrent().getAttribute(DOCENTE_ATRIBUTO);
	}
	
	/**
	 * Set para el docente
	 * @param docente
	 */
	public static void setDocente(Docente docente) {
		Sessions.getCurrent().setAttribute(DOCENTE_ATRIBUTO, docente);
	}
	
	/**
	 * Retorna la referencia del tabbox contenedor de pantallas
	 * @return
	 */
	public static  Tabbox getTabboxAplication(){
		return (Tabbox) Sessions.getCurrent().getAttribute("tb_tabboxCtl");
		
	}
	
	/**
	 * Lbl del usuario
	 * @return
	 */
	public static Textbox getUsuarioTextbox(){
		return (Textbox) Sessions.getCurrent().getAttribute("textboxUsuario");
	}
	
}

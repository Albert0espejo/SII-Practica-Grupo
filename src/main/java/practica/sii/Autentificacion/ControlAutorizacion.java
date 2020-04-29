/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practica.sii.Autentificacion;

import javax.inject.Named;

import practica.sii.Clases.Usuario;

import javax.enterprise.context.SessionScoped;

import java.io.Serializable;
import javax.faces.context.FacesContext;

@Named(value = "controlAutorizacion")
@SessionScoped
public class ControlAutorizacion implements Serializable {

    private Usuario usuario;

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String home() {
        // Implementar el método
        // Devuelve la página Home dependiendo del rol del usuario
        // Si no hay usuario debe devolver la página de login
        // Si el usuario es el administrador debe devolver la página admin.xhtml
        // Si el usuario es un usuario normal debe devolver la página normal.xhtml
    	if(usuario == null) {
        	return "login.xhtml";
        }else if(usuario.getRol().equals(Usuario.Rol.ALUMNO)){
        	return "alumno.xhtml";
        }else if(usuario.getRol().equals(Usuario.Rol.ONG)) {
        	return "ong.xhtml";
        }else if(usuario.getRol().equals(Usuario.Rol.PAS)) {
        	return "pas.xhtml";
        }else if(usuario.getRol().equals(Usuario.Rol.PDI)) {
        	return "pdi.xhtml";
        }else if(usuario.getRol().equals(Usuario.Rol.ADMINISTRADOR)){
        	return "admin.xhtml";
        }else {
        	return "login.xhtml";
        }
    }
    
    public String logout()
    {
        // Destruye la sesión (y con ello, el ámbito de este bean)
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.getExternalContext().invalidateSession();
        usuario = null;
        return "login.xhtml";
    }

    /**
     * Creates a new instance of ControlAutorizacion
     */
    public ControlAutorizacion() {
    }
}

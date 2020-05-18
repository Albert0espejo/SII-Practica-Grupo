/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practica.sii.Autentificacion;

import javax.inject.Inject;
import javax.inject.Named;

import practica.sii.Clases.Alumno;
import practica.sii.Clases.PAS;
import practica.sii.Clases.Usuario;

import javax.enterprise.context.SessionScoped;

import java.io.Serializable;
import javax.faces.context.FacesContext;

@Named(value = "controlAutorizacion")
@SessionScoped
public class ControlAutorizacion implements Serializable {
	
    private Usuario usuario;
    @Inject
    private ControlPAS controlPas;
    @Inject
    private ControlONG controlONG;
    @Inject
    private ControlPDI controlPDI;
    @Inject
    private ControlAlumno controlAlumno;
    
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
    	if(usuario.getRol().equals(Usuario.Rol.ADMINISTRADOR)) {
        	return "admin.xhtml"; 
        }else if(usuario.getRol().equals(Usuario.Rol.ALUMNO)){
        	controlAlumno.setMiUsuario(usuario);
        	return "alumno.xhtml";
        }else if(usuario.getRol().equals(Usuario.Rol.ONG)) {
        	controlONG.setMiUsuario(usuario);
        	return "ong.xhtml";
        }else if(usuario.getRol().equals(Usuario.Rol.PAS)) {
        	controlPas.setMiusuario(usuario);
        	return "pas.xhtml";
        }else if(usuario.getRol().equals(Usuario.Rol.PDI)) {
        	controlPDI.setMiusuario(usuario);
        	return "pdi.xhtml";
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

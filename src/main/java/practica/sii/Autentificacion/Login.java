/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practica.sii.Autentificacion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import practica.sii.Clases.Usuario;


/**
 *
 * @author francis
 */
@Named(value = "login")
@RequestScoped
public class Login {

    private String usuario;
    private String contrasenia;
    private List<Usuario> usuarios;
    
    @Inject
    private ControlAutorizacion ctrl;

    /**
     * Creates a new instance of Login
     */
    public Login() {
        usuarios = new ArrayList<Usuario>();
      /*  usuarios.add(new Usuario("pepe", "asdf", Tipo.NORMAL));
        usuarios.add(new Usuario("manolo", "qwer", Rol.ADMINISTRADOR));*/
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String autenticar() {
        // Implementar este método
    	FacesContext ctx = FacesContext.getCurrentInstance();
        
        boolean encontrado = false;
        Iterator i = usuarios.iterator();
        Usuario aux = null;
        
        while(i.hasNext() && !encontrado) {
        	aux = (Usuario) i.next();
        	if(aux.getUsuario().equals(usuario)) {
        		encontrado = true;
        	}
        }
        
        if(encontrado) {
        	if(aux.getContrasena().equals(contrasenia)) {
        		ctrl.setUsuario(aux);
        		return ctrl.home();
        	}else {
                ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Contraseña incorrecta", "Contraseña incorrecta"));
        	}
        }else {
        	ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario no encontrado", "Usuario no encontrado" ));
        }
        return null;
    }
}

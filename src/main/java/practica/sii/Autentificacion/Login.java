/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practica.sii.Autentificacion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import practica.sii.Clases.Address;
import practica.sii.Clases.Estado;
import practica.sii.Clases.Noticias;
import practica.sii.Clases.Proyecto;
import practica.sii.Clases.Demanda;
import practica.sii.Clases.Universidad;
import practica.sii.Clases.Usuario;
import practica.sii.Clases.Usuario.Rol;
import practica.sii.ejb.BaseDeDatosLocal;



@Named(value = "login")
@SessionScoped
public class Login implements Serializable{

	@Inject
	private BaseDeDatosLocal bbdd;
	
	private String usuario;
    private String contrasenia;
    private List<Usuario> usuarios;

    
    @Inject
    private ControlAutorizacion ctrl;

    /**
     * Creates a new instance of Login
     */
    public Login() {

    }

    public void setUsuarios(List<Usuario> usuarios) { 
		this.usuarios = usuarios;
	}

	public String getUsuario() {
        return usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }
    
    public List<Usuario> getUsuarios(){
    	return usuarios;
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
        
    	usuarios = bbdd.todoUsuarios();
    	
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

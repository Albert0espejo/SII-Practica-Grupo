/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practica.sii.Autentificacion;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import practica.sii.Clases.Address;
import practica.sii.Clases.Estado;
import practica.sii.Clases.Noticias;
import practica.sii.Clases.Proyecto;
import practica.sii.Clases.Solicitud;
import practica.sii.Clases.Universidad;
import practica.sii.Clases.Usuario;
import practica.sii.Clases.Usuario.Rol;



@Named(value = "login")
@RequestScoped
public class Login {

    private String usuario;
    private String contrasenia;
    private List<Usuario> usuarios;
	private List<Solicitud> listaSolicitudes;
	private List<Universidad> listaUniversidades;
	private List<Noticias> listaNoticias;
	private List<Proyecto> listaProyectos;
    
    @Inject
    private ControlAutorizacion ctrl;

    /**
     * Creates a new instance of Login
     */
    public Login() {
    	Date finicio = new Date(01/06/2020);
    	Date ffinal = new Date(21/07/2020);
    	Universidad Malaga = new Universidad(1L,"Malaga", new Address("Avd.Cervantes","","Malaga","Andalucia",29010L,"España"),"uma.es","Malaga",29010L);
        Proyecto ProyectoA = new Proyecto(1L , "Hospital Carlos Haya", finicio, ffinal, "Descripcion del proyecto", Estado.En_Espera);
        //Proyecto ProyectoB = new Proyecto(2L , "Casa de la Juventud", 15/12/2020, 08/02/2021, "Descripcion del proyecto", 1);
    	usuarios = new ArrayList<Usuario>();
    	listaSolicitudes = new ArrayList<Solicitud>();
    	listaProyectos = new ArrayList<Proyecto>();
    	listaUniversidades = new ArrayList<Universidad>();
        usuarios.add(new Usuario(1L,"pepe", "asdf","pepe@uma.es", Rol.ALUMNO, Malaga));
        usuarios.add(new Usuario(2L,"manolo", "qwer", "manolo@uma.es",Rol.ADMINISTRADOR,Malaga));
        usuarios.add(new Usuario(3L,"pasprueba","asdf","pasprueba@uma.es", Rol.PAS, Malaga));
        usuarios.add(new Usuario(4L,"pdiprueba","zxcv","pdiprueba@uma.es", Rol.PDI, Malaga));
        listaSolicitudes.add(new Solicitud(1L, Estado.En_Espera, Malaga, ProyectoA));
        long i = 2;
        listaSolicitudes.add(new Solicitud(i, null, Malaga, null));
        listaUniversidades.add(Malaga);

    }

    public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Solicitud> getListaSolicitudes() {
		return listaSolicitudes;
	}

	public void setListaSolicitudes(List<Solicitud> listaSolicitudes) {
		this.listaSolicitudes = listaSolicitudes;
	}

	public List<Universidad> getListaUniversidades() {
		return listaUniversidades;
	}

	public void setListaUniversidades(List<Universidad> listaUniversidades) {
		this.listaUniversidades = listaUniversidades;
	}

	public List<Noticias> getListaNoticias() {
		return listaNoticias;
	}

	public void setListaNoticias(List<Noticias> listaNoticias) {
		this.listaNoticias = listaNoticias;
	}

	public List<Proyecto> getListaProyectos() {
		return listaProyectos;
	}

	public void setListaProyectos(List<Proyecto> listaProyectos) {
		this.listaProyectos = listaProyectos;
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

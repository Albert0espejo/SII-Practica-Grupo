package practica.sii.Autentificacion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import practica.sii.Clases.Address;
import practica.sii.Clases.Noticias;
import practica.sii.Clases.Proyecto;
import practica.sii.Clases.Solicitud;
import practica.sii.Clases.Universidad;
import practica.sii.Clases.Usuario;
import practica.sii.Clases.Usuario.Rol;

@Named(value = "controlAdmin")
@SessionScoped
public class ControlAdmin implements Serializable{
	
	
	private List<Usuario> listaUsuarios;
	private List<Solicitud> listaSolicitudes;
	private List<Universidad> listaUniversidades;
	private List<Noticias> listaNoticias;
	private List<Proyecto> listaProyectos;
	private List<Rol> listaRoles;
	
	private Boolean showtableUsuarios = false;
	private Boolean showtableSolicitudes = false;
	private Boolean showtableUniversidades = false;
	private Boolean showtableNoticias = false;
	private Boolean showtableProyectos = false;
	
	private Usuario selectedUsuario;
	
	private Login listas;
	private Usuario user;
	
	
	public ControlAdmin() {
		listas = new Login();
		user = new Usuario();
		listaUsuarios = new ArrayList<Usuario>();
		listaNoticias = new ArrayList<Noticias>();
		listaProyectos = new ArrayList<Proyecto>();
		listaSolicitudes = new ArrayList<Solicitud>();
		listaUniversidades = new ArrayList<Universidad>();
		listaRoles = Arrays.asList(Rol.values());
	}
	
	public Usuario getSelectedUsuario() {
		return selectedUsuario;
	}


	public void setSelectedUsuario(Usuario selectedUsuario) {
		this.selectedUsuario = selectedUsuario;
	}

	public List<Rol> getListaRoles() {
		return listaRoles;
	}

	public List<Usuario> getListaUsuarios(){
		listaUsuarios = listas.getUsuarios();
		
		return listaUsuarios;
	}

	public List<Solicitud> getListaSolicitudes() {
		listaSolicitudes = listas.getListaSolicitudes();
		
		return listaSolicitudes;
	}

	public List<Universidad> getListaUniversidades() {
		listaUniversidades = listas.getListaUniversidades();
		
		return listaUniversidades;
	}

	public List<Noticias> getListaNoticias() {
		listaNoticias = listas.getListaNoticias();
		
		return listaNoticias;
	}

	public List<Proyecto> getListaProyectos() {
		listaProyectos = listas.getListaProyectos();
		
		return listaProyectos;
	}
	
	public Boolean getShowtableUsuarios() {
		return showtableUsuarios;
	}
	
	public Boolean getShowtableSolicitudes() {
		return showtableSolicitudes;
	}

	public Boolean getShowtableUniversidades() {
		return showtableUniversidades;
	}

	public Boolean getShowtableNoticias() {
		return showtableNoticias;
	}

	public Boolean getShowtableProyectos() {
		return showtableProyectos;
	}

	public void enabletableUsuarios() {
		if(showtableNoticias || showtableSolicitudes || showtableProyectos || showtableUniversidades) {
			showtableNoticias = false;
			showtableSolicitudes = false;
			showtableProyectos = false;
			showtableUniversidades = false;
		}

		showtableUsuarios = !showtableUsuarios;
	}
	
	public void enabletableSolicitudes() {
		if(showtableNoticias || showtableUsuarios || showtableProyectos || showtableUniversidades) {
			showtableNoticias = false;
			showtableUsuarios = false;
			showtableProyectos = false;
			showtableUniversidades = false;
		}
		
		showtableSolicitudes = !showtableSolicitudes;
	}
	
	public void enabletableUniversidades() {
		if(showtableNoticias || showtableUsuarios || showtableProyectos || showtableSolicitudes) {
			showtableNoticias = false;
			showtableUsuarios = false;
			showtableProyectos = false;
			showtableSolicitudes = false;
		}
		
		showtableUniversidades = !showtableUniversidades;
	}
	
	public void enabletableNoticias() {
		if(showtableUniversidades || showtableUsuarios || showtableProyectos || showtableSolicitudes) {
			showtableUniversidades = false;
			showtableUsuarios = false;
			showtableProyectos = false;
			showtableSolicitudes = false;
		}
		
		showtableNoticias = !showtableNoticias;
	}
	
	public void enabletableProyectos() {
		if(showtableNoticias || showtableUsuarios || showtableUniversidades || showtableSolicitudes) {
			showtableNoticias = false;
			showtableUsuarios = false;
			showtableUniversidades = false;
			showtableSolicitudes = false;
		}
		
		showtableProyectos = !showtableProyectos;
	}
	
	public void borrarUsuario() {
		listaUsuarios.remove(selectedUsuario);
		selectedUsuario = null;
		listas.setUsuarios(listaUsuarios);
	}
	
	public void borrarSolicitudes(Solicitud u) {
		listaSolicitudes.remove(u);
		listas.setListaSolicitudes(listaSolicitudes);
	}
	
	public void borrarUniversidades(Universidad u) {
		listaUniversidades.remove(u);
		listas.setListaUniversidades(listaUniversidades);
	}
	
	public void borrarNoticias(Noticias u) {
		listaNoticias.remove(u);
		listas.setListaNoticias(listaNoticias);
	}
	
	public void borrarProyectos(Proyecto u) {
		listaProyectos.remove(u);
		listas.setListaProyectos(listaProyectos);
	}
	
	public void setUser(Usuario u) {
		user = u;
	}
	
	public Usuario getUser() {
		return user;
	}
	
	public void crearUsuario() {
		listaUsuarios.add(user);
		listas.setUsuarios(listaUsuarios);
	}
	
	
}

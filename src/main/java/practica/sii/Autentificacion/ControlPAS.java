package practica.sii.Autentificacion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import practica.sii.Clases.Noticias;
import practica.sii.Clases.Proyecto;
import practica.sii.Clases.Solicitud;
import practica.sii.Clases.Universidad;
import practica.sii.Clases.Usuario;
import practica.sii.Clases.Usuario.Rol;

@Named(value = "controlPAS")
@SessionScoped
public class ControlPAS implements Serializable{
	
	
	private List<Usuario> listaUsuarios;
	private List<Solicitud> listaSolicitudes;
	private List<Universidad> listaUniversidades;
	private List<Noticias> listaNoticias;
	private List<Proyecto> listaProyectos;
	private List<Usuario> listaProfesores;
	
	private Boolean showtableUsuarios = false;
	private Boolean showtableSolicitudes = false;
	private Boolean showtableUniversidades = false;
	private Boolean showtableNoticias = false;
	private Boolean showtableProyectos = false;
	
	private Login listas;
	private Usuario miusuario;
	
	public ControlPAS() {
		listas = new Login();
		
		listaProfesores = new ArrayList<Usuario>();
		listaUsuarios = new ArrayList<Usuario>();
		listaNoticias = new ArrayList<Noticias>();
		listaProyectos = new ArrayList<Proyecto>();
		listaSolicitudes = new ArrayList<Solicitud>();
		listaUniversidades = new ArrayList<Universidad>();
	}
	
	public Usuario getMiusuario() {
		return miusuario;
	}

	public void setMiusuario(Usuario miusuario) {
		this.miusuario = miusuario;
	}

	public List<Usuario> getListaUsuarios(){
		this.listaUsuarios = listas.getUsuarios();
		return listaUsuarios;
	}

	public List<Solicitud> getListaSolicitudes() {
		List<Solicitud> aux = listas.getListaSolicitudes();
		for(int i=0; i < aux.size();i++) {
			if(aux.get(i).getUniversidad().equals(miusuario.getUniversidad())) {
				listaSolicitudes.add(aux.get(i));
			}
		}
		return listaSolicitudes;
	}

	public List<Universidad> getListaUniversidades() {
		return listaUniversidades;
	}
	
	public List<Usuario> getListaProfesores(){
		List<Usuario> aux = listas.getUsuarios();
		for(int i=0; i < aux.size();i++) {
			if(aux.get(i).getUniversidad().equals(miusuario.getUniversidad()) && aux.get(i).getRol().equals(Rol.PDI)) {
				listaProfesores.add(aux.get(i));
			}
		}
		return listaProfesores;
	}

	public List<Noticias> getListaNoticias() {
		return listaNoticias;
	}

	public List<Proyecto> getListaProyectos() {
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
	
	public void borrarSolicitudes(Solicitud s) {
		listaSolicitudes.remove(s);
		listas.setListaSolicitudes(listaSolicitudes);
	}
	
}

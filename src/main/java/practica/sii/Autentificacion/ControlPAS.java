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
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; 
	private List<Usuario> listaUsuarios;
	private List<Solicitud> listaSolicitudes;
	private List<Usuario> listaProfesores;
	
	private Boolean showtableUsuarios = false;
	private Boolean showtableSolicitudes = false;
	
	private Login listas;
	private Usuario miusuario;
	
	public ControlPAS() {
		listas = new Login();
		
		listaProfesores = new ArrayList<Usuario>();
		listaUsuarios = new ArrayList<Usuario>();
		listaSolicitudes = new ArrayList<Solicitud>();
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

	
	public List<Usuario> getListaProfesores(){
		List<Usuario> aux = listas.getUsuarios();
		for(int i=0; i < aux.size();i++) {
			if(aux.get(i).getUniversidad().equals(miusuario.getUniversidad()) && aux.get(i).getRol().equals(Rol.PDI)) {
				listaProfesores.add(aux.get(i));
			}
		}
		return listaProfesores; //prueba
	}

	
	public Boolean getShowtableUsuarios() {
		return showtableUsuarios;
	}
	
	public Boolean getShowtableSolicitudes() {
		return showtableSolicitudes;
	}
	
	public void enabletableSolicitudes() {
		if(showtableUsuarios) {
			showtableUsuarios = false;
		}
		
		showtableSolicitudes = !showtableSolicitudes;
	}
	
	
	public void borrarSolicitudes(Solicitud s) {
		listaSolicitudes.remove(s);
		listas.setListaSolicitudes(listaSolicitudes);
	}
	
}

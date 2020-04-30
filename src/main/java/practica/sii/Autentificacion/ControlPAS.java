package practica.sii.Autentificacion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


import practica.sii.Clases.Solicitud;
import practica.sii.Clases.Usuario;
import practica.sii.Clases.Usuario.Rol;

@Named(value = "controlPAS")
@SessionScoped
public class ControlPAS implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; 
	private List<Solicitud> listaSolicitudes;
	private List<Usuario> listaProfesores;
	
	private Boolean showtablePerfil = false;
	private Boolean showtableSolicitudes = false;
	
	private Login listas;
	private Usuario miusuario;
	private Solicitud selectedSolicitud;
	
	public ControlPAS() {
		listas = new Login();
		
		listaProfesores = new ArrayList<Usuario>();
		listaSolicitudes = new ArrayList<Solicitud>();
	}
	
	public Solicitud getSelectedSolicitud() {
		return selectedSolicitud;
	}

	public void setSelectedSolicitud(Solicitud selectedSolicitud) {
		this.selectedSolicitud = selectedSolicitud;
	}

	public Usuario getMiusuario() {
		return miusuario;
	}

	public void setMiusuario(Usuario miusuario) {
		this.miusuario = miusuario;
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
		return showtablePerfil;
	}
	
	public Boolean getShowtableSolicitudes() {
		return showtableSolicitudes;
	}
	
	public void enabletableSolicitudes() {
		if(showtablePerfil) {
			showtablePerfil = false;
		}
		
		showtableSolicitudes = !showtableSolicitudes;
	}
	
	public void enabletablePerfil() {
		if(showtableSolicitudes) {
			showtableSolicitudes = false;
		}
		
		showtablePerfil= !showtablePerfil;
	}
	
	public void enviarA() {
		selectedSolicitud = null;
	}
	
}

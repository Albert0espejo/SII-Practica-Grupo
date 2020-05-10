package practica.sii.Autentificacion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import practica.sii.Clases.PAS;
import practica.sii.Clases.PDI;
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
	private List<PDI> listaProfesores;
	
	private Boolean showtablePerfil = false;
	private Boolean showtableSolicitudes = false;
	
	private Login listas;
	private PAS miusuario;
	private Solicitud selectedSolicitud;
	private PDI supervisor;
	private Usuario selectedUsuario;
	
	public ControlPAS() {
		listas = new Login();
		supervisor = new PDI();
		listaProfesores = new ArrayList<PDI>();
		listaSolicitudes = new ArrayList<Solicitud>();
	}
	
	
	
	public Usuario getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(PDI supervisor) {
		this.supervisor = supervisor;
	}

	
	
	public Usuario getSelectedUsuario() {
		return selectedUsuario;
	}



	public void setSelectedUsuario(Usuario selectedUsuario) {
		this.selectedUsuario = selectedUsuario;
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

	public void setMiusuario(PAS miusuario) {
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

	public List<PDI> getListaProfesores(){
		List<Usuario> aux = listas.getUsuarios();
		for(int i=0; i < aux.size();i++) {
			if(aux.get(i).getRol().equals(Rol.PDI)) {
				listaProfesores.add((PDI)aux.get(i));
			}
		}
		return listaProfesores; //prueba
	}

	public Boolean getShowtablePerfil() {
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
		selectedSolicitud.setPdi(supervisor);
		selectedSolicitud = null;
	}
	
}

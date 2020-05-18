package practica.sii.Autentificacion;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import practica.sii.Clases.PAS;
import practica.sii.Clases.PDI;
import practica.sii.Clases.Solicitud;
import practica.sii.Clases.Usuario;
import practica.sii.Clases.Usuario.Rol;

@Named(value = "controlPAS")
@RequestScoped
public class ControlPAS{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; 
	private List<Solicitud> listaSolicitudes;
	private List<Usuario> listaProfesores;
	
	private Boolean showtableSolicitudes = false;
	
	private Login listas;
	private Usuario miusuario;
	private PAS miPAS;
	private Solicitud selectedSolicitud;
	private PDI supervisor;
	private Usuario selectedUsuario;
	
	public ControlPAS() {
		listas = new Login();
		supervisor = new PDI();
		listaProfesores = new ArrayList<Usuario>();
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

	public void setMiusuario(Usuario miusuario) {
		this.miusuario = miusuario;
		this.miPAS = new PAS(miusuario.getId(),miusuario.getUsuario(),miusuario.getContrasena(),miusuario.getCorreo(),miusuario.getRol(),miusuario.getUniversidad(),null,null,null,null,null);
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
			if(aux.get(i).getRol().equals(Rol.PDI)) {
				listaProfesores.add(aux.get(i));
			}
		}
		return listaProfesores;
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
	
	public String enabletablePerfil() {
		return "editarPerfil.xhtml";
	}
	
	public void enviarA() {
		selectedSolicitud.setPdi(supervisor);
		selectedSolicitud = null;
	}
	
}

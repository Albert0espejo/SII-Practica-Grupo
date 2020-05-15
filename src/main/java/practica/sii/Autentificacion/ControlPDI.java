package practica.sii.Autentificacion;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import practica.sii.Clases.Estado;
import practica.sii.Clases.Solicitud;
import practica.sii.Clases.Usuario;


@Named(value = "controlPDI")
@RequestScoped

public class ControlPDI implements Serializable{
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Solicitud> listaSolicitudes;
	private List<Estado> listaEstado;
	
	private Boolean showtablePerfil = false;
	private Boolean showtableSolicitudes = false;
	
	private Solicitud selectedSolicitud;
	private Usuario selectedUsuario;
	@Inject
	private Login listas;
	private Usuario miusuario;
	
	public ControlPDI() {
		listaSolicitudes = new ArrayList<Solicitud>();
		listaEstado = Arrays.asList(Estado.values());
	}
	
	public Usuario getMiusuario() {
		return miusuario;
	}

	public void setMiusuario(Usuario miusuario) {
		this.miusuario = miusuario;
	}

	public Solicitud getSelectedSolicitud() {
		return selectedSolicitud;
	}

	public void setSelectedSolicitud(Solicitud selectedSolicitud) {
		this.selectedSolicitud = selectedSolicitud;
	}
	
	public Usuario getSelectedUsuario() {
		return selectedUsuario;
	}

	public void setSelectedUsuario(Usuario selectedUsuario) {
		this.selectedUsuario = selectedUsuario;
	}
	
	public List<Estado> getListaEstado() {
		return listaEstado;
	}
	
	public List<Solicitud> getListaSolicitudes() {
		List<Solicitud> aux = listas.getListaSolicitudes();
		for(int i=0; i < aux.size();i++) {
			if(aux.get(i).getPdi().equals(miusuario)) {
				listaSolicitudes.add(aux.get(i));
			}
		} 

		return listaSolicitudes;
	}
	
	public Boolean getShowtableSolicitudes() {
		return showtableSolicitudes;
	}
	
	public Boolean getShowtablePerfil() {
		return showtablePerfil;
	}
	
	public void enabletableSolicitudes() {
		if(showtablePerfil) {
			showtablePerfil = false;
		}
		
		showtableSolicitudes = !showtableSolicitudes;
	}
	
	public void enabletablePerfil() {
		if( showtableSolicitudes) {
			showtableSolicitudes = false;
		}

		showtablePerfil = !showtablePerfil;
	}

}

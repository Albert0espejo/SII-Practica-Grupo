package practica.sii.Autentificacion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import practica.sii.Clases.Estado;
import practica.sii.Clases.Solicitud;
import practica.sii.Clases.Usuario;


@Named(value = "controlPDI")
@SessionScoped
public class ControlPDI implements Serializable{
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Solicitud> listaSolicitudes;
	private List<Estado> listaEstado;
	private List<Usuario> listaUsuarios;
	
	private Boolean showtablePerfil = false;
	private Boolean showtableSolicitudes = false;
	private Boolean showtableUniversidades = false;
	private Boolean showtableNoticias = false;
	private Boolean showtableProyectos = false;

	
	private Solicitud selectedSolicitud;
	private Usuario selectedUsuario;
	@Inject
	private Login listas;
	private Usuario miusuario;
	
	public ControlPDI() {
		listaSolicitudes = new ArrayList<Solicitud>();
		listaEstado = Arrays.asList(Estado.values());
		listaUsuarios = new ArrayList<Usuario>();
	}


	public void setMiUsuario(Usuario miusuario) {
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
		listaSolicitudes = listas.getListaSolicitudes();	
		return listaSolicitudes;
	}
	
	
	
	public Boolean getShowtableSolicitudes() {
		return showtableSolicitudes;
	}
	
	public Boolean getShowtablePerfil() {
		return showtablePerfil;
	}
	
	
	
	
	public void enabletableSolicitudes() {
		if(showtableNoticias || showtablePerfil || showtableProyectos || showtableUniversidades) {
			showtableNoticias = false;
			showtablePerfil = false;
			showtableProyectos = false;
			showtableUniversidades = false;
		}
		
		showtableSolicitudes = !showtableSolicitudes;
	}
	
	public void enabletablePerfil() {
		if(showtableNoticias || showtableSolicitudes || showtableProyectos || showtableUniversidades) {
			showtableNoticias = false;
			showtableSolicitudes = false;
			showtableProyectos = false;
			showtableUniversidades = false;
		}

		showtablePerfil = !showtablePerfil;
	}

}

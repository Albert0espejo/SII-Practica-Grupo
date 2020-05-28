package practica.sii.Autentificacion;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import practica.sii.Clases.Estado;
import practica.sii.Clases.Demanda;
import practica.sii.Clases.Usuario;


@Named(value = "controlPDI")
@RequestScoped
public class ControlPDI implements Serializable{
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Demanda> listaSolicitudes;
	private List<Estado> listaEstado;
	
	private Boolean showtablePerfil = false;
	private Boolean showtableSolicitudes = false;
	
	private Demanda selectedSolicitud;
	private Usuario selectedUsuario;
	@Inject
	private Login listas;
	private Usuario miusuario;
	
	public ControlPDI() {
		listaSolicitudes = new ArrayList<Demanda>();
		listaEstado = Arrays.asList(Estado.values());
	}
	
	public Usuario getMiusuario() {
		return miusuario;
	}

	public void setMiusuario(Usuario miusuario) {
		this.miusuario = miusuario;
	}

	public Demanda getSelectedSolicitud() {
		return selectedSolicitud;
	}

	public void setSelectedSolicitud(Demanda selectedSolicitud) {
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
	
	public List<Demanda> getListaSolicitudes() {
		List<Demanda> aux = listas.getListaSolicitudes();
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
	
	public String enabletableSolicitudes() {
		return "tablaSolicitudesPDI.xhtml";
	}
	
	public String enabletablePerfil() {
		return "editarPerfil.xhtml";
	}

}

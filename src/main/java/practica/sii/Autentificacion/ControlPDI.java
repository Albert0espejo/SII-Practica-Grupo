package practica.sii.Autentificacion;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import practica.sii.Clases.Estado;
import practica.sii.Clases.PAS;
import practica.sii.Clases.PDI;
import practica.sii.Clases.Proyecto;
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
	private List<Proyecto> listaProyectos;
	
	
	private Demanda selectedSolicitud;
	private Usuario selectedUsuario;
	private Proyecto selectedProyecto;
	@Inject
	private Login listas;
	private Usuario miusuario;
	private PDI miPDI;
	
	public ControlPDI() {
		listaSolicitudes = new ArrayList<Demanda>();
		listaEstado = Arrays.asList(Estado.values());
		listaProyectos = new ArrayList<Proyecto>();
	}
	
	public Usuario getMiusuario() {
		return miusuario;
	}

	public void setMiusuario(Usuario miusuario) {
		this.miusuario = miusuario;
		this.miPDI = new PDI(miusuario.getId(),miusuario.getUsuario(),miusuario.getContrasena(),miusuario.getCorreo(),miusuario.getRol(), null ,null,null,null,null,null,null);

	}

	public Demanda getSelectedSolicitud() {
		return selectedSolicitud;
	}

	public void setSelectedSolicitud(Demanda selectedSolicitud) {
		this.selectedSolicitud = selectedSolicitud;
	}
	
	public PDI getMiPDI() {
		return miPDI;
	}

	public void setMiPDI(PDI miPDI) {
		this.miPDI = miPDI;
	}

	
	public Usuario getSelectedUsuario() {
		return selectedUsuario;
	}

	public void setSelectedUsuario(Usuario selectedUsuario) {
		this.selectedUsuario = selectedUsuario;
	}
	
	public Proyecto getSelectedProyecto() {
		return selectedProyecto;
	}


	public void setSelectedProyecto(Proyecto selectedProyecto) {
		this.selectedProyecto = selectedProyecto;
	}
	
	public List<Estado> getListaEstado() {
		return listaEstado;
	}
	
	public List<Demanda> getListaSolicitudes() {
		/*
		List<Demanda> aux = listas.getListaSolicitudes();
		for(int i=0; i < aux.size();i++) {
			if(aux.get(i).getUniversidad().equals(null)) {
				listaSolicitudes.add(aux.get(i));
			}
		} 
		*/
		listaSolicitudes = listas.getListaSolicitudes();

		return listaSolicitudes;
	}
	
	public List<Proyecto> getListaProyectos() {
		/*
		List<Proyectos> aux = listas.getListaProyectos();
		for(int i=0; i < aux.size();i++) {
			if(aux.get(i).getUniversidad().equals(null)) {
				listaProyectos.add(aux.get(i));
			}
		} 
		*/
		listaProyectos = listas.getListaProyectos();
		
		return listaProyectos;
	}
	

	
	public String enabletableSolicitudes() {
		return "tablaSolicitudesPDI.xhtml";
	}
	
	public String enabletablePerfil() {
		return "editarPerfil.xhtml";
	}

	public String enabletableProyectos() {
		return "tablaProyectosPDI.xhtml";
	}


	
}

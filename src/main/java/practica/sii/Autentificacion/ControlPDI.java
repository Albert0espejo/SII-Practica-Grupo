package practica.sii.Autentificacion;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.RowEditEvent;

import practica.sii.Clases.Estado;
import practica.sii.Clases.Noticias;
import practica.sii.Clases.PAS;
import practica.sii.Clases.PDI;
import practica.sii.Clases.Proyecto;
import practica.sii.Clases.Universidad;
import practica.sii.Clases.Demanda;
import practica.sii.Clases.Usuario;
import practica.sii.Clases.Usuario.Rol;
import practica.sii.ejb.BaseDeDatosLocal;


@Named(value = "controlPDI")
@RequestScoped
public class ControlPDI implements Serializable{
	
	@Inject
	private BaseDeDatosLocal bbdd;
	
	private List<Usuario> listaUsuarios;
	private List<Demanda> listaSolicitudes;
	private List<Proyecto> listaProyectos;
	private List<Rol> listaRoles;
	private List<Estado> listaEstado;
	
	
	private Usuario selectedUsuario;
	private Demanda selectedSolicitud;
	private Proyecto selectedProyecto;
	
	private Usuario miusuario;
	private PDI miPDI;
	
	
	
	
	public ControlPDI() {
		listaProyectos = new ArrayList<Proyecto>();
		listaSolicitudes = new ArrayList<Demanda>();
		listaRoles = Arrays.asList(Rol.values());
		listaEstado = Arrays.asList(Estado.values());
	}

	public List<Usuario> getTodosUsuarios() {
		return bbdd.todoUsuarios();
	}

	public List<Demanda> getListaSolicitudes() {
		return bbdd.todoSolicitudes();
	}

	public List<Proyecto> getListaProyectos() {
		return bbdd.todoProyectos();
	}

	public List<Rol> getListaRoles() {
		return listaRoles;
	}

	public List<Estado> getListaEstado() {
		return listaEstado;
	}
	
	/**/
	
	public Usuario getSelectedUsuario() {
		return selectedUsuario;
	}

	public void setSelectedUsuario(Usuario selectedUsuario) {
		this.selectedUsuario = selectedUsuario;
	}
	
	public Demanda getSelectedSolicitud() {
		return selectedSolicitud;
	}

	public void setSelectedSolicitud(Demanda selectedSolicitud) {
		this.selectedSolicitud = selectedSolicitud;
	}

	public Proyecto getSelectedProyecto() {
		return selectedProyecto;
	}

	public void setSelectedProyecto(Proyecto selectedProyecto) {
		this.selectedProyecto = selectedProyecto;
	}

	/**/
	
	public Usuario getMiusuario() {
		return miusuario;
	}

	public void setMiusuario(Usuario miusuario) {
		this.miusuario = miusuario;
		this.setMiPDI(new PDI(miusuario.getId(),miusuario.getUsuario(),miusuario.getContrasena(),miusuario.getCorreo(),miusuario.getRol(), null ,null,null,null,null,null,null));

	}

	public PDI getMiPDI() {
		return miPDI;
	}
	
	public void setMiPDI(PDI miPDI) {
		this.miPDI = miPDI;
	}
	
	/***********************************************************/
	
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

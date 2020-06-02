package practica.sii.Autentificacion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.RowEditEvent;

import practica.sii.Clases.Alumno;
import practica.sii.Clases.Estado;
import practica.sii.Clases.Noticias;
import practica.sii.Clases.PDI;
import practica.sii.Clases.Proyecto;
import practica.sii.Clases.Demanda;
import practica.sii.Clases.Universidad;
import practica.sii.Clases.Usuario;
import practica.sii.Clases.Usuario.Rol;
import practica.sii.ejb.BaseDeDatosLocal;

@Named(value = "controlAlumno")
@RequestScoped
public class ControlAlumno implements Serializable{
	
	@Inject
	private BaseDeDatosLocal bbdd;
	
	
	private List<Demanda> listaSolicitudes;
	private List<Noticias> listaNoticias;
	private List<Proyecto> listaProyectos;
	
	private Boolean showtablePerfil = false;
	private Boolean showtableSolicitudes = false;
	private Boolean showtableNoticias = false;
	private Boolean showtableProyectos = false;
	    
	private Login listas;
	private Usuario miUsuario;
	private Alumno miAlumno;
	
	public Alumno getMiAlumno() {
		return miAlumno;
	}

	public void setMiAlumno(Alumno miAlumno) {
		this.miAlumno = miAlumno;
	}

	private Demanda solicitud;
	private Proyecto selectedProyecto;
	
	public ControlAlumno() {
		listas = new Login();
		solicitud = new Demanda();
		listaNoticias = new ArrayList<Noticias>();
		listaProyectos = new ArrayList<Proyecto>();
		listaSolicitudes = new ArrayList<Demanda>();
	}

	public List<Demanda> getListaSolicitudes() {
		listaSolicitudes = listas.getListaSolicitudes();
		
		return listaSolicitudes;
	}

	public Usuario getMiUsuario() {
		return miUsuario;
	}

	public void setMiUsuario(Usuario miUsuario) {
		this.miUsuario = miUsuario;
		this.miAlumno=new Alumno(miUsuario.getId(), miUsuario.getUsuario(),miUsuario.getContrasena(),miUsuario.getCorreo(),miUsuario.getRol(), null);
	}

	public Proyecto getSelectedProyecto() {
		return selectedProyecto;
	}

	public Boolean getShowtablePerfil() {
		return showtablePerfil;
	}

	public void setSelectedProyecto(Proyecto selectedProyecto) {
		this.selectedProyecto = selectedProyecto;
	}
	
	public List<Noticias> getListaNoticias() {
		return bbdd.todoNoticias();
	}
 
	public List<Proyecto> getListaProyectos() {
		listaProyectos = listas.getListaProyectos();
		
		return listaProyectos;
	}
		
	public Boolean getShowtableSolicitudes() {
		return showtableSolicitudes;
	}

	public Boolean getShowtableNoticias() {
		return showtableNoticias;
	}

	public Boolean getShowtableProyectos() {
		return showtableProyectos;
	}
	
	public void enabletableSolicitudes() {
		if(showtableNoticias || showtableProyectos || showtablePerfil) {
			showtableNoticias = false;
			showtableProyectos = false;
			showtablePerfil = false;
		}
		
		showtableSolicitudes = !showtableSolicitudes;
	}
	
	public void enabletableNoticias() {
		if(showtableProyectos || showtableSolicitudes || showtablePerfil) {
			showtableProyectos = false;
			showtableSolicitudes = false;
			showtablePerfil = false;
		}
		
		showtableNoticias = !showtableNoticias;
	}
	
	public void enabletableProyectos() {
		if(showtableNoticias || showtableSolicitudes || showtablePerfil) {
			showtableNoticias = false;
			showtableSolicitudes = false;
			showtablePerfil = false;
		}
		
		showtableProyectos = !showtableProyectos;
	}
	
	public void enabletablePerfil() {
		if(showtableNoticias || showtableSolicitudes || showtableProyectos) {
			showtableNoticias = false;
			showtableSolicitudes = false;
			showtableProyectos = false;
		}
		
		showtablePerfil = !showtablePerfil;
	}
	
	public String enableEditPerfil() {
		return "editarPerfil.xhtml";
	}
	
	public void crearSolicitud() {
		solicitud = new Demanda(new Random().nextLong(), Estado.En_Espera, null, selectedProyecto);
		listas.getListaSolicitudes().add(solicitud);
		
	}
	
}

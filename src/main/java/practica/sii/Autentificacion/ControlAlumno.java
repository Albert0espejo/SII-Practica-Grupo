package practica.sii.Autentificacion;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import practica.sii.Clases.Alumno;
import practica.sii.Clases.Estado;
import practica.sii.Clases.Noticias;
import practica.sii.Clases.Proyecto;
import practica.sii.Clases.Demanda;
import practica.sii.Clases.Universidad;
import practica.sii.Clases.Usuario;
import practica.sii.ejb.BaseDeDatosLocal;

@Named(value = "controlAlumno")
@RequestScoped
public class ControlAlumno implements Serializable{
	
	@EJB
	private BaseDeDatosLocal bbdd;
	
	private Boolean showtablePerfil = false;
	private Boolean showtableSolicitudes = false;
	private Boolean showtableNoticias = false;
	private Boolean showtableProyectos = false;
	

	private Demanda solicitud;
	private Proyecto selectedProyecto;	
	private Usuario miUsuario;
	private Alumno miAlumno;
	private Universidad miUni;
	

	public Alumno getMiAlumno() {
		return miAlumno;
	}

	public void setMiAlumno(Alumno miAlumno) {
		this.miAlumno = miAlumno;
	}
	
	public ControlAlumno() {
		solicitud = new Demanda();
	}

	public void setMiUsuario(Usuario miUsuario) {
		this.miUsuario = miUsuario;
		this.miAlumno=new Alumno(miUsuario.getId(), miUsuario.getUsuario(),miUsuario.getContrasena(),miUsuario.getCorreo(),miUsuario.getRol(), null);
	}
	
	public List<Demanda> getListaSolicitudes() {
		return this.bbdd.todoSolicitudes();
	}

	public Usuario getMiUsuario() {
		return miUsuario;
	}

	public Universidad getMiUni() {
		return miUni;
	}

	public void setMiUni(Universidad miUni) {
		this.miUni = miUni;
	}
	
	public List<Universidad> getUni() {
		return this.bbdd.todoUniversidad();
	}

	public void setUni(Universidad uni) {
		this.bbdd.aniadirUniversidad(uni);;
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
		return this.bbdd.todoNoticias();
	}
 
	public List<Proyecto> getListaProyectos() {
		return this.bbdd.todoProyectos();
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
	
	public String crearSolicitud() {
		Proyecto aux = this.bbdd.findProyecto(selectedProyecto.getID_Proyecto());
		solicitud = new Demanda( Estado.En_Espera, null, aux);
		
		//List<Demanda> solicitudes=aux.getSolicitud();
		//solicitudes.add(solicitud);
		//aux.setSolicitud(solicitudes);
		
		this.bbdd.aniadirSolicitud(solicitud);
		selectedProyecto=new Proyecto();
		bbdd.actualizarProyecto(aux);
		return "alumno.xhtml";
	}
	
}

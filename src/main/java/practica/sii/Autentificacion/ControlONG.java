package practica.sii.Autentificacion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import practica.sii.Clases.Address;
import practica.sii.Clases.Demanda;
import practica.sii.Clases.Estado;
import practica.sii.Clases.Noticias;
import practica.sii.Clases.ONG;
import practica.sii.Clases.Proyecto;
import practica.sii.Clases.Usuario;
import practica.sii.ejb.BaseDeDatosLocal;


@Named(value = "controlONG") 
@RequestScoped

public class ControlONG {
	
	@Inject
	private BaseDeDatosLocal bbdd;

	private List<Noticias> listaNoticias;
	private List<Proyecto> listaProyectos;
	private List<Demanda> listaSolicitudes; 
	private List<Estado> listaEstado;
	
	private Boolean showtableNoticias = false;
	private Boolean showtableProyectos = false;
	private Boolean showtablePerfil = false;
	private Boolean showtableSolicitudes = false;
	
	private Noticias selectedNoticia; 
	private Proyecto selectedProyecto;
	private Demanda  selectedSolicitud;

	private Usuario miUsuario;
	private ONG miUsuarioONG;
	private Noticias news;
	private Proyecto project;
	private Address direccion;
	private Estado estado_AUX;
	
	@Inject
	private Login listas;
	
	public ControlONG() {
		news = new Noticias();
		project = new Proyecto();
		miUsuarioONG = new ONG();
		listaNoticias = new ArrayList<Noticias>();
		listaProyectos = new ArrayList<Proyecto>();
		listaSolicitudes = new ArrayList<Demanda>();
		direccion = new Address();
		
		listaEstado = Arrays.asList(Estado.values());

	}
	
	/*Geters and Seters*/
	
	public List<Demanda> getListaSolicitudes() {
		return bbdd.todoSolicitudes();
	}
	
	public Proyecto getProject() {
		return project;
	}

	public void setProject(Proyecto project) {
		this.project = project;
	}

	public Usuario getMiUsuario() {
		return miUsuario;
	}

	public void setMiUsuario(Usuario miUsuario) {
		this.miUsuario = miUsuario;
	}

	public Noticias getNews() {
		return news;
	}

	public void setNews(Noticias news) {
		this.news = news;
	}

	public List<Proyecto> getListaProyectos() {
		return bbdd.todoProyectos();
	}
	
	public Noticias getSelectedNoticia() {
		return selectedNoticia;
	}

	public void setSelectedNoticia(Noticias selectedNoticia) {
		this.selectedNoticia = selectedNoticia;
	}

	public List<Noticias> getListaNoticias() {
		return bbdd.todoNoticias();
	}
	
	public Proyecto getSelectedProyecto() {
		return selectedProyecto;
	}

	public void setSelectedProyecto(Proyecto selectedProyecto) {
		this.selectedProyecto = selectedProyecto;
	}
	
	public Demanda getSelectedSolicitud() {
		return this.selectedSolicitud;
	}

	public void setSelectedSolicitud(Demanda selectedSolicitud) {
		this.selectedSolicitud = selectedSolicitud;
	}

	public ONG getMiUsuarioONG() {
		return miUsuarioONG;
	}

	public void setMiUsuarioONG(ONG miUsuarioONG) {
		this.miUsuarioONG = miUsuarioONG;
	}
	
	public Address getDireccion() {
		return direccion;
	}

	public void setDireccion(Address direccion) {
		this.direccion = direccion;
	}
	
	public Estado getEstado_AUX() {
		return estado_AUX;
	}

	public void setEstado_AUX(Estado estado_AUX) {
		this.estado_AUX = estado_AUX;
	}

	public List<Estado> getListaEstado() {
		return listaEstado;
	}
	
	/*ShowTables*/

	public Boolean getShowtableSolicitudes() {
		return showtableSolicitudes;
	}
	
	public Boolean getShowtablePerfil() {
		return showtablePerfil;
	}

	public Boolean getShowtableNoticias() {
		return showtableNoticias;
	}

	public Boolean getShowtableProyectos() {
		return showtableProyectos;
	}
	
	/*Activacion Tablas*/
	
	
	public void enabletableNoticias() {
		if(showtableProyectos || showtablePerfil || showtableSolicitudes) {
			showtableProyectos = false;
			showtablePerfil = false;
		}
		
		showtableNoticias = !showtableNoticias;
	}
	
	public void enabletableProyectos() {
		if(showtableNoticias || showtablePerfil || showtableSolicitudes) {
			showtableNoticias = false;
			showtablePerfil = false;
		}
		
		showtableProyectos = !showtableProyectos;
	}
	
	public void enabletablePerfil() {
		if(showtableNoticias || showtableProyectos || showtableSolicitudes) {
			showtableNoticias = false;
			showtableProyectos = false;
		}
		
		showtablePerfil = !showtablePerfil;
	}
	
	public void enabletableSolicitudes() {
		if(showtableNoticias || showtableProyectos || showtablePerfil) {
			showtableNoticias = false;
			showtableProyectos = false;
			showtablePerfil = false;
		}
		
		showtableSolicitudes = !showtableSolicitudes;
	}
	
	/*Metodos*/

	public void borrarNoticias() {
		if(selectedNoticia != null) {
			bbdd.eliminarNoticia(selectedNoticia);
			selectedNoticia = null;
		}
	}
	
	public void borrarProyectos() {
		if(selectedProyecto != null) {
			bbdd.eliminarProyecto(selectedProyecto);
			selectedProyecto = null;
		}
	}
	
	public void crearNoticia() {
		bbdd.aniadirNoticia(news);
		news = new Noticias();
	}
	
	public void crearProyecto() {
		project.setEstado(estado_AUX);
		bbdd.aniadirProyecto(project);
		project = new Proyecto();
		project.setOng(new ONG());
	}
	
	public void crearOng() {
		miUsuarioONG.setDireccion(direccion);
		bbdd.aniadirONG(miUsuarioONG);
		miUsuarioONG = new ONG();
		direccion = new Address();
	}
	
	public void modificarComentario() {
		bbdd.actualizarSolicitud(selectedSolicitud);
	}
	
	public String enableEditarPerfil() {
		return "editarPerfil.xhtml";
	}
	
	public void modificarOng() {
		
	}
}

package practica.sii.Autentificacion;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import practica.sii.Clases.Demanda;
import practica.sii.Clases.Noticias;
import practica.sii.Clases.ONG;
import practica.sii.Clases.Proyecto;
import practica.sii.Clases.Usuario;


@Named(value = "controlONG") 
@RequestScoped

public class ControlONG {

	private List<Noticias> listaNoticias;
	private List<Proyecto> listaProyectos;
	private List<Demanda> listaSolicitudes; 
	
	private Boolean showtableNoticias = false;
	private Boolean showtableProyectos = false;
	private Boolean showtablePerfil = false;
	private Boolean showtableSolicitudes = false;
	
	private Noticias selectedNoticia; 
	private Proyecto selectedProyecto;

	private Usuario miUsuario;
	private ONG miUsuarioONG;
	private Noticias news;
	private Proyecto project;
	@Inject
	private Login listas;
	
	public ControlONG() {
		news = new Noticias();
		project = new Proyecto();
		miUsuarioONG = new ONG();
		listaNoticias = new ArrayList<Noticias>();
		listaProyectos = new ArrayList<Proyecto>();
		listaSolicitudes = new ArrayList<Demanda>();

	}
	
	
	public List<Demanda> getListaSolicitudes() {
		listaSolicitudes = listas.getListaSolicitudes();
		
		return listaSolicitudes;
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
		listaProyectos = listas.getListaProyectos();
		
		return listaProyectos;
	}
	
	public Noticias getSelectedNoticia() {
		return selectedNoticia;
	}

	public void setSelectedNoticia(Noticias selectedNoticia) {
		this.selectedNoticia = selectedNoticia;
	}

	public List<Noticias> getListaNoticias() {

		listaNoticias = listas.getListaNoticias();
		return listaNoticias;
	}
	
	public Proyecto getSelectedProyecto() {
		return selectedProyecto;
	}

	public void setSelectedProyecto(Proyecto selectedProyecto) {
		this.selectedProyecto = selectedProyecto;
	}

	public ONG getMiUsuarioONG() {
		return miUsuarioONG;
	}



	public void setMiUsuarioONG(ONG miUsuarioONG) {
		this.miUsuarioONG = miUsuarioONG;
	}

	
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

	public void borrarNoticias() {
		listaNoticias.remove(selectedNoticia);
		selectedNoticia = null;
		listas.setListaNoticias(listaNoticias);
	}
	
	public void borrarProyectos() {
		listaProyectos.remove(selectedProyecto);
		selectedProyecto = null;
		listas.setListaProyectos(listaProyectos);
	}
	
	public void crearNoticia() {
		listaNoticias.add(news);
	}
	
	public void crearProyecto() {
		listaProyectos.add(project);
	}
}

package practica.sii.Autentificacion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import practica.sii.Clases.Noticias;
import practica.sii.Clases.ONG;
import practica.sii.Clases.Proyecto;
import practica.sii.Clases.Solicitud;
import practica.sii.Clases.Universidad;
import practica.sii.Clases.Usuario;
import practica.sii.Clases.Usuario.Rol;


@Named(value = "controlONG") 
@RequestScoped

public class ControlONG implements Serializable{

	private List<Noticias> listaNoticias;
	private List<Proyecto> listaProyectos;
	
	private Boolean showtableNoticias = false;
	private Boolean showtableProyectos = false;
	private Boolean showtablePerfil = false;
	
	private Noticias selectedNoticia;
	private Proyecto selectedProyecto;

	private Usuario miUsuario;
	private ONG miUsuarioONG;
	private Noticias news;
	private Proyecto project;
	private Login listas;
	
	public ControlONG() {
		listas = new Login();
		news = new Noticias();
		project = new Proyecto();
		miUsuarioONG = new ONG();
		listaNoticias = new ArrayList<Noticias>();
		listaProyectos = new ArrayList<Proyecto>();

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
		listaProyectos = miUsuarioONG.getProyecto();
		
		return listaProyectos;
	}
	
	public Noticias getSelectedNoticia() {
		return selectedNoticia;
	}

	public void setSelectedNoticia(Noticias selectedNoticia) {
		this.selectedNoticia = selectedNoticia;
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



	public List<Noticias> getListaNoticias() {
		/*List<Noticias> aux = listas.getListaNoticias();
		for (int i = 0; i < aux.size(); i++) {
			if (aux.get(i).getOng().equals(miUsuario)) {
				listaNoticias.add(aux.get(i));
			}
		}*/
		
		listaNoticias = miUsuarioONG.getNoticias();
		return listaNoticias;
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
		if(showtableProyectos || showtablePerfil) {
			showtableProyectos = false;
			showtablePerfil = false;
		}
		
		showtableNoticias = !showtableNoticias;
	}
	
	public void enabletableProyectos() {
		if(showtableNoticias || showtablePerfil) {
			showtableNoticias = false;
			showtablePerfil = false;
		}
		
		showtableProyectos = !showtableProyectos;
	}
	
	public void enabletablePerfil() {
		if(showtableNoticias || showtableProyectos) {
			showtableNoticias = false;
			showtableProyectos = false;
		}
		
		showtablePerfil = !showtablePerfil;
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

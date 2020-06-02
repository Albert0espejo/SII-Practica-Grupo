package practica.sii.Autentificacion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import practica.sii.Clases.Estado;

import practica.sii.Clases.Noticias;
import practica.sii.Clases.Proyecto;
import practica.sii.Clases.Demanda;
import practica.sii.Clases.Universidad;
import practica.sii.Clases.Usuario;
import practica.sii.Clases.Usuario.Rol;
import practica.sii.ejb.BaseDeDatosLocal;

@Named(value = "controlAdmin")
@RequestScoped
public class ControlAdmin{
	
	@Inject
	private BaseDeDatosLocal bbdd;
	
	private List<Usuario> listaUsuarios;
	private List<Demanda> listaSolicitudes;
	private List<Universidad> listaUniversidades;
	private List<Noticias> listaNoticias;
	private List<Proyecto> listaProyectos;
	private List<Rol> listaRoles;
	private List<Estado> listaEstado;
	
	private Usuario selectedUsuario;
	private Demanda selectedSolicitud;
	private Universidad selectedUniversidad;
	private Noticias selectedNoticia;
	private Proyecto selectedProyecto;
	
	private Login listas;
	
	private Usuario user;
	private Demanda sol;
	private Universidad uni;
	private Noticias news;
	private Proyecto project;
	
	
	public ControlAdmin() {
		user = new Usuario();
		sol = new Demanda();
		uni = new Universidad();
		news = new Noticias();
		project = new Proyecto();
		listas = new Login();
		listaNoticias = new ArrayList<Noticias>();
		listaProyectos = new ArrayList<Proyecto>();
		listaSolicitudes = new ArrayList<Demanda>();
		listaUniversidades = new ArrayList<Universidad>();
		listaRoles = Arrays.asList(Rol.values());
		listaEstado = Arrays.asList(Estado.values());
	}
	
	public Demanda getSelectedSolicitud() {
		return selectedSolicitud;
	}


	public void setSelectedSolicitud(Demanda selectedSolicitud) {
		this.selectedSolicitud = selectedSolicitud;
	}


	public Universidad getSelectedUniversidad() {
		return selectedUniversidad;
	}


	public void setSelectedUniversidad(Universidad selectedUniversidad) {
		this.selectedUniversidad = selectedUniversidad;
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


	public Usuario getSelectedUsuario() {
		return selectedUsuario;
	}


	public void setSelectedUsuario(Usuario selectedUsuario) {
		this.selectedUsuario = selectedUsuario;
	}

	public List<Estado> getListaEstado() {
		return listaEstado;
	}

	public List<Rol> getListaRoles() {
		return listaRoles;
	}

	public List<Usuario> getTodosUsuarios(){
		
		return bbdd.todoUsuarios();
	}

	public List<Demanda> getListaSolicitudes() {
		
		return bbdd.todoSolicitudes();
	}

	public List<Universidad> getListaUniversidades() {
		
		return bbdd.todoUniversidad();
	}

	public List<Noticias> getListaNoticias() {
		
		return bbdd.todoNoticias();
	}

	public List<Proyecto> getListaProyectos() {
		
		return bbdd.todoProyectos();
	}
	
	public void borrarUsuario() {
		bbdd.eliminarUsuario(selectedUsuario);
		selectedUsuario = null;
	}
	
	public void borrarSolicitudes(Demanda solicitud) {
		listaSolicitudes.remove(solicitud);
		selectedSolicitud = null;
		listas.setListaSolicitudes(listaSolicitudes);
	}
	
	public void borrarUniversidades() {
		listaUniversidades.remove(selectedUniversidad);
		selectedUniversidad = null;
		listas.setListaUniversidades(listaUniversidades);
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
	
	public void setUser(Usuario u) {
		user = u;
	}
	
	public Usuario getUser() {
		return user;
	}
	
	public Demanda getSol() {
		return sol;
	}

	public void setSol(Demanda sol) {
		this.sol = sol;
	}

	public Universidad getUni() {
		return uni;
	}

	public void setUni(Universidad uni) {
		this.uni = uni;
	}

	public Noticias getNews() {
		return news;
	}

	public void setNews(Noticias news) {
		this.news = news;
	}

	public Proyecto getProject() {
		return project;
	}

	public void setProject(Proyecto project) {
		this.project = project;
	}

	public void crearUsuario() {
		bbdd.aniadirUsuario(user);
		user = new Usuario();
	}
	
	public void crearSolicitud() {
		listaSolicitudes.add(sol);
	}
	
	public void crearUniversidad() {
		listaUniversidades.add(uni);
	}
	
	public void crearNoticia() {
		listaNoticias.add(news);
	}
	
	public void crearProyecto() {
		listaProyectos.add(project);
	}
}

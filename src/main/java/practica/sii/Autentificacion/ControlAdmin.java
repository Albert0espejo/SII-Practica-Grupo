package practica.sii.Autentificacion;

import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import practica.sii.Clases.Estado;

import practica.sii.Clases.Noticias;
import practica.sii.Clases.ONG;
import practica.sii.Clases.PAS;
import practica.sii.Clases.PDI;
import practica.sii.Clases.Proyecto;
import practica.sii.Clases.Address;
import practica.sii.Clases.Alumno;
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
	
	private List<Rol> listaRoles;
	private List<Estado> listaEstado;
	
	private Usuario selectedUsuario;
	private Demanda selectedSolicitud;
	private Universidad selectedUniversidad;
	private Noticias selectedNoticia;
	private Proyecto selectedProyecto;
	
	private Usuario user;
	private Alumno alumno;
	private PAS pas;
	private PDI pdi;
	private ONG ong;
	private Demanda sol;
	private Universidad uni;
	private Noticias news;
	private Proyecto project;
	private Address direccion;
	private Estado estado_AUX;
	
	
	public ControlAdmin() {
		user = new Usuario();
		alumno = new Alumno();
		pas = new PAS();
		pdi = new PDI();
		ong = new ONG();
		sol = new Demanda();
		sol.setAlumno(new Alumno());
		sol.setProyecto(new Proyecto());
		sol.setUniversidad(new Universidad());
		uni = new Universidad();
		
		news = new Noticias();
		news.setOng(new Usuario());
		
		project = new Proyecto();
		project.setOng(new ONG());
		
		direccion = new Address();

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
	
	public List<Usuario> getListaONG() {
		return bbdd.todoONG();
	}

	public List<Usuario> getListaPDI() {
		return bbdd.todoPDI();
	}

	public List<Usuario> getListaPAS() {
		return bbdd.todoPAS();
	}

	public List<Usuario> getListaAlumno() {
		return bbdd.todoAlumnos();
	}

	public void borrarUsuario() {
		if(selectedUsuario != null) {
			bbdd.eliminarUsuario(selectedUsuario);
			selectedUsuario = null;
		}
	}
	
	public void borrarSolicitudes() {
		if(selectedSolicitud != null) {
			bbdd.eliminarSolicitud(selectedSolicitud);
			selectedSolicitud = null;
		}
	}
	
	public void borrarUniversidades() {
		if(selectedUniversidad != null) {
			bbdd.eliminarUniversidad(selectedUniversidad);
			selectedUniversidad = null;
		}
	}
	
	public void borrarNoticias() {
		if(selectedNoticia != null) {
			bbdd.eliminarNoticia(selectedNoticia);
			selectedNoticia = null;
		}
	}
	
	public void borrarProyectos() {
		if(selectedProyecto != null) {
			bbdd.eliminarProyecto(selectedProyecto);;
			selectedProyecto = null;
		}
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

	public void crearUsuario() {
		if (user.getRol().equals(Rol.ALUMNO)) {
			alumno.setContrasena(user.getContrasena());
			alumno.setCorreo(user.getCorreo());
			alumno.setRol(user.getRol());
			alumno.setUsuario(user.getUsuario());
			bbdd.aniadirAlumno(alumno);
			user = new Usuario();
			alumno = new Alumno();
		}else if(user.getRol().equals(Rol.ONG)) {
			ong.setContrasena(user.getContrasena());
			ong.setCorreo(user.getCorreo());
			ong.setRol(user.getRol());
			ong.setUsuario(user.getUsuario());
			bbdd.aniadirONG(ong);
			user = new Usuario();
			ong = new ONG();
		}else if(user.getRol().equals(Rol.PAS)) {
			pas.setContrasena(user.getContrasena());
			pas.setCorreo(user.getCorreo());
			pas.setRol(user.getRol());
			pas.setUsuario(user.getUsuario());
			bbdd.aniadirPAS(pas);
			user = new Usuario();
			pas = new PAS();
		}else if(user.getRol().equals(Rol.PDI)) {
			pdi.setContrasena(user.getContrasena());
			pdi.setCorreo(user.getCorreo());
			pdi.setRol(user.getRol());
			pdi.setUsuario(user.getUsuario());
			bbdd.aniadirPDI(pdi);
			user = new Usuario();
			pdi = new PDI();
		}else {
			bbdd.aniadirUsuario(user);
			user = new Usuario();
		}
	}
	
	public void crearSolicitud() {
		sol.setEstado(estado_AUX);
		bbdd.aniadirSolicitud(sol);
		sol = new Demanda();
		sol.setAlumno(new Alumno());
		sol.setProyecto(new Proyecto());
	}
	
	public void crearUniversidad() {
		uni.setDireccion(direccion);
		bbdd.aniadirUniversidad(uni);
		uni = new Universidad();
		direccion = new Address();
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
	
	public void actualizarUsuario(Usuario u) {
		bbdd.actualizarUsuario(u);
	}
	
}

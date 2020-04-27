package practica.sii.Autentificacion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import practica.sii.Clases.Noticias;
import practica.sii.Clases.Proyecto;
import practica.sii.Clases.Solicitud;
import practica.sii.Clases.Universidad;
import practica.sii.Clases.Usuario;
import practica.sii.Autentificacion.Login;


@Named(value = "controlAdmin")
@SessionScoped
public class ControlAdmin implements Serializable{
	
	
	private List<Usuario> listaUsuarios;
	private List<Solicitud> listaSolicitudes;
	private List<Universidad> listaUniversidades;
	private List<Noticias> listaNoticias;
	private List<Proyecto> listaProyectos;
	
	private Boolean showtableUsuarios = false;
	private Boolean showtableSolicitudes = false;
	private Boolean showtableUniversidades = false;
	private Boolean showtableNoticias = false;
	private Boolean showtableProyectos = false;
	
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public ControlAdmin() {
		emf = Persistence.createEntityManagerFactory("practica.sii");
		em = emf.createEntityManager();

		
		Query query = (Query) em.createNamedQuery("todosUsuarios");
		
		listaUsuarios = query.getResultList();
		listaNoticias = new ArrayList<Noticias>();
		listaProyectos = new ArrayList<Proyecto>();
		listaSolicitudes = new ArrayList<Solicitud>();
		listaUniversidades = new ArrayList<Universidad>();
	}
	
	public List<Usuario> getListaUsuarios(){
		return listaUsuarios;
	}

	public List<Solicitud> getListaSolicitudes() {
		return listaSolicitudes;
	}

	public List<Universidad> getListaUniversidades() {
		return listaUniversidades;
	}

	public List<Noticias> getListaNoticias() {
		return listaNoticias;
	}

	public List<Proyecto> getListaProyectos() {
		return listaProyectos;
	}

	public void ListaUsuarios() {
		/*emf = Persistence.createEntityManagerFactory("Practoca-SII");
        em=emf.createEntityManager();
		Query query = (Query) em.createNamedQuery("todosUsuarios");
    	listaUsuarios = query.getResultList();
    	emf.close();
    	em.close();*/
	}
	
	public Boolean getShowtableUsuarios() {
		return showtableUsuarios;
	}
	
	public Boolean getShowtableSolicitudes() {
		return showtableSolicitudes;
	}

	public Boolean getShowtableUniversidades() {
		return showtableUniversidades;
	}

	public Boolean getShowtableNoticias() {
		return showtableNoticias;
	}

	public Boolean getShowtableProyectos() {
		return showtableProyectos;
	}

	public void enabletableUsuarios() {
		if(showtableNoticias || showtableSolicitudes || showtableProyectos || showtableUniversidades) {
			showtableNoticias = false;
			showtableSolicitudes = false;
			showtableProyectos = false;
			showtableUniversidades = false;
		}
		
		showtableUsuarios = !showtableUsuarios;
	}
	
	public void enabletableSolicitudes() {
		if(showtableNoticias || showtableUsuarios || showtableProyectos || showtableUniversidades) {
			showtableNoticias = false;
			showtableUsuarios = false;
			showtableProyectos = false;
			showtableUniversidades = false;
		}
		
		showtableSolicitudes = !showtableSolicitudes;
	}
	
	public void enabletableUniversidades() {
		if(showtableNoticias || showtableUsuarios || showtableProyectos || showtableSolicitudes) {
			showtableNoticias = false;
			showtableUsuarios = false;
			showtableProyectos = false;
			showtableSolicitudes = false;
		}
		
		showtableUniversidades = !showtableUniversidades;
	}
	
	public void enabletableNoticias() {
		if(showtableUniversidades || showtableUsuarios || showtableProyectos || showtableSolicitudes) {
			showtableUniversidades = false;
			showtableUsuarios = false;
			showtableProyectos = false;
			showtableSolicitudes = false;
		}
		
		showtableNoticias = !showtableNoticias;
	}
	
	public void enabletableProyectos() {
		if(showtableNoticias || showtableUsuarios || showtableUniversidades || showtableSolicitudes) {
			showtableNoticias = false;
			showtableUsuarios = false;
			showtableUniversidades = false;
			showtableSolicitudes = false;
		}
		
		showtableProyectos = !showtableProyectos;
	}
	
	public void borrarUsuario(Integer id) {
		for(int i = 0; i > listaUsuarios.size(); i++) {
			if(id.equals(listaUsuarios.get(i).getId())) {
				listaUsuarios.remove(i);
			}
		}
	}
	
}

package practica.sii.Autentificacion;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

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
	
	public ControlAdmin() {
		Login aux= new Login();
		listaUsuarios = aux.getUsuarios();
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
		showtableUsuarios = !showtableUsuarios;
	}
	
	public void enabletableSolicitudes() {
		showtableSolicitudes = !showtableSolicitudes;
	}
	
	public void enabletableUniversidades() {
		showtableUniversidades = !showtableUniversidades;
	}
	
	public void enabletableNoticias() {
		showtableNoticias = !showtableNoticias;
	}
	
	public void enabletableProyectos() {
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

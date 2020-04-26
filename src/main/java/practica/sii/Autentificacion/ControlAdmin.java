package practica.sii.Autentificacion;

import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Query;

 
import practica.sii.Clases.Usuario;
import practica.sii.Autentificacion.Login;
@Named(value = "controlAdmin")
@SessionScoped
public class ControlAdmin {
	
	private EntityManager em;
	
	public enum Vistas {
		USUARIOS,
		SOLICITUDES,
		PROYECTO,
		NOTICIAS
	};
	
	private List<Usuario> listaUsuarios;
	private Vistas actual = null;
	
	public void setActual (Vistas vista) {
		actual = vista;
	}
	
	public Vistas getActual () {
		return actual;
	}
	
	public void vistaUsuario() {
		actual = Vistas.USUARIOS;
		listaUsuarios = Login.getUsuarios();
	}
	
	public List<Usuario> getListaUsuarios(){
		return listaUsuarios;
	}
	
	public void ListaUsuarios() {
		/*Query query = (Query) em.createNamedQuery("todosUsuarios");
    	List<Usuario> res = query.getResultList();
        return res;*/
	}
}

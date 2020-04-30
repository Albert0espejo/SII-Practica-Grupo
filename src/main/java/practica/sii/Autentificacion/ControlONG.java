package practica.sii.Autentificacion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import practica.sii.Clases.Noticias;
import practica.sii.Clases.Proyecto;
import practica.sii.Clases.Solicitud;
import practica.sii.Clases.Universidad;
import practica.sii.Clases.Usuario;
import practica.sii.Clases.Usuario.Rol;


@Named(value = "controlONG") 
 
@SessionScoped

public class ControlONG implements Serializable{

	private List<Noticias> listaNoticias;
	private List<Proyecto> listaProyectos;
	
	private Boolean showtableNoticias = false;
	private Boolean showtableProyectos = false;
	private Boolean showtableUsuarios = false;
	private Boolean showtableSolicitudes = false;
	private Boolean showtableUniversidades = false;

	private Usuario miUsuario;
	
	private Login listas;
	
	public ControlONG() {
		listas = new Login();

		listaNoticias = new ArrayList<Noticias>();
		listaProyectos = new ArrayList<Proyecto>();

	}
	
	public Usuario getMiUsuario() {
		return miUsuario;
	}

	public void setMiUsuario(Usuario miUsuario) {
		this.miUsuario = miUsuario;
	}

	public List<Proyecto> getListaProyectos() {
		listaProyectos = listas.getListaProyectos();
		
		return listaProyectos;
	}
	
	public List<Noticias> getListaNoticias() {
		listaNoticias = listas.getListaNoticias();
		
		return listaNoticias;
	}
	
	
	public Boolean getShowtableNoticias() {
		return showtableNoticias;
	}

	public Boolean getShowtableProyectos() {
		return showtableProyectos;
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
	
	public void borrarNoticias(Noticias u) {
		listaNoticias.remove(u);
		listas.setListaNoticias(listaNoticias);
	}
	
	public void borrarProyectos(Proyecto u) {
		listaProyectos.remove(u);
		listas.setListaProyectos(listaProyectos);
	}
	
}

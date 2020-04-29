package practica.sii.Autentificacion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import practica.sii.Clases.Address;
import practica.sii.Clases.Noticias;
import practica.sii.Clases.Proyecto;
import practica.sii.Clases.Solicitud;
import practica.sii.Clases.Universidad;
import practica.sii.Clases.Usuario;
import practica.sii.Clases.Usuario.Rol;

@Named(value = "controlPDI")
@SessionScoped
public class ControlPDI implements Serializable{

	private List<Solicitud> listaSolicitudes;
	private List<Universidad> listaUniversidades;
	private List<Noticias> listaNoticias;
	private List<Proyecto> listaProyectos;
	
	private Boolean showtableSolicitudes = false;
	private Boolean showtableUniversidades = false;
	private Boolean showtableNoticias = false;
	private Boolean showtableProyectos = false;
	
	private Login listas;

    public ControlPDI() {
    	listas = new Login();
    	
    	listaNoticias = new ArrayList<Noticias>();
    	listaProyectos = new ArrayList<Proyecto>();
    	listaSolicitudes = new ArrayList<Solicitud>();
    	listaUniversidades = new ArrayList<Universidad>();
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
	
	public void enabletableSolicitudes() {
		if(showtableNoticias || showtableProyectos || showtableUniversidades) {
			showtableNoticias = false;
			showtableProyectos = false;
			showtableUniversidades = false;
		}
		
		showtableSolicitudes = !showtableSolicitudes;
	}
	
	public void enabletableUniversidades() {
		if(showtableNoticias || showtableProyectos || showtableSolicitudes) {
			showtableNoticias = false;
			showtableProyectos = false;
			showtableSolicitudes = false;
		}
		
		showtableUniversidades = !showtableUniversidades;
	}
	
	public void enabletableNoticias() {
		if(showtableUniversidades || showtableProyectos || showtableSolicitudes) {
			showtableUniversidades = false;
			showtableProyectos = false;
			showtableSolicitudes = false;
		}
		
		showtableNoticias = !showtableNoticias;
	}
	
	public void enabletableProyectos() {
		if(showtableNoticias || showtableUniversidades || showtableSolicitudes) {
			showtableNoticias = false;
			showtableUniversidades = false;
			showtableSolicitudes = false;
		}
		
		showtableProyectos = !showtableProyectos;
	}

}

	

	

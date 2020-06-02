package practica.sii.Autentificacion;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.NamedQuery;

import practica.sii.Clases.PAS;
import practica.sii.Clases.PDI;
import practica.sii.Clases.Demanda;
import practica.sii.Clases.Usuario;
import practica.sii.Clases.Usuario.Rol;
import practica.sii.ejb.BaseDeDatosLocal;

@Named(value = "controlPAS")
@NamedQuery(name = "listaSolicitudes.todos", query="select c from Demanda where Universidad = 'Universidad de Malaga'")
@NamedQuery(name = "listaProfesores.todos", query="select c from PDI where Universidad = 'Universidad de Malaga'")
@RequestScoped
public class ControlPAS{
	private BaseDeDatosLocal bbdd;
	
	private List<Demanda> listaSolicitudes;
	private List<Usuario> listaProfesores;
	
	private Boolean showtableSolicitudes = false;
	
	private Login listas;
	private Usuario miusuario;
	private PAS miPAS;
	private Demanda selectedSolicitud;
	private PDI supervisor;
	private Usuario selectedUsuario;
	
	public ControlPAS() {
		listas = new Login();
		supervisor = new PDI();
		listaProfesores = new ArrayList<Usuario>();
		listaSolicitudes = new ArrayList<Demanda>();
	}
	
	
	
	public Usuario getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(PDI supervisor) {
		this.supervisor = supervisor;
	}

	
	
	public Usuario getSelectedUsuario() {
		return selectedUsuario;
	}



	public void setSelectedUsuario(Usuario selectedUsuario) {
		this.selectedUsuario = selectedUsuario;
	}



	public Demanda getSelectedSolicitud() {
		return selectedSolicitud;
	}

	public void setSelectedSolicitud(Demanda selectedSolicitud) {
		this.selectedSolicitud = selectedSolicitud;
	}

	public Usuario getMiusuario() {
		return miusuario;
	}

	public void setMiusuario(Usuario miusuario) {
		this.miusuario = miusuario;
		this.miPAS = new PAS(miusuario.getId(),miusuario.getUsuario(),miusuario.getContrasena(),miusuario.getCorreo(),miusuario.getRol(), null ,null,null,null,null,null);
	}

	public PAS getMiPAS() {
		return miPAS;
	}

	public void setMiPAS(PAS miPAS) {
		this.miPAS = miPAS;
	}

	public List<Demanda> getListaSolicitudes() {
		return bbdd.listaSolicitudes();
	}

	public List<Usuario> getListaProfesores(){
		return bbdd.listaProfesores();
	}

	
	public Boolean getShowtableSolicitudes() {
		return showtableSolicitudes;
	}
	
	public void enabletableSolicitudes() {
		
		showtableSolicitudes = !showtableSolicitudes;
	}
	
	public String enabletablePerfil() {
		return "editarPerfil.xhtml";
	}
	
	public void enviarA() {
		selectedSolicitud.setPdi(supervisor);
		selectedSolicitud = null;
	}
	public void aplicarCambios() {
		setMiusuario(miusuario);
		miPAS.setContrasena(miPAS.getContrasena());
		miPAS.setCorreo(miPAS.getCorreo());
		miPAS.setDireccion(miPAS.getDireccion());
		miPAS.setFacultad(miPAS.getFacultad());
		miPAS.setRepresentante(miPAS.getRepresentante());
		miPAS.setTelefono(miPAS.getTelefono());
	}
	
}

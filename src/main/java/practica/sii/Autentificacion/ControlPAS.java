package practica.sii.Autentificacion;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Init;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.NamedQuery;

import org.primefaces.event.RowEditEvent;

import practica.sii.Clases.PAS;
import practica.sii.Clases.PDI;
import practica.sii.Clases.Demanda;
import practica.sii.Clases.Usuario;
import practica.sii.Clases.Usuario.Rol;
import practica.sii.ejb.BaseDeDatosLocal;

@Named(value = "controlPAS")
@RequestScoped
public class ControlPAS{
	@Inject
	private BaseDeDatosLocal bbdd; 
	
	private List<Demanda> listaSolicitudes;
	private List<Usuario> listaProfesores;
	
	private Boolean showtableSolicitudes = false;
	
	private Login listas;
	private Usuario miusuario;
	private PAS miPAS;
	private Demanda selectedSolicitud;
	private PDI selectedPDI;
	
	public PDI getSelectedPDI() {
		return selectedPDI;
	}
	
	public void setSelectedPDI(PDI selectedPDI) {
		this.selectedPDI = selectedPDI;
	}
	
	public ControlPAS() {
		listas = new Login();
		listaProfesores = new ArrayList<Usuario>();
		listaSolicitudes = new ArrayList<Demanda>();
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
		return bbdd.todoSolicitudes();
	}

	public List<Usuario> getListaProfesores(){
		return bbdd.todoPDI();
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
	
	public void enviarA(PDI supervisor) {
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

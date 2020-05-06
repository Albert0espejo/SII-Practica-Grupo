package practica.sii.Clases;

import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import practica.sii.Clases.Usuario.Rol;

/**
 * Entity implementation class for Entity: PDI
 *
 */
@Entity
public class PDI extends Usuario implements Serializable {

	
	private String Nombre;
	private String Apellidos;
	private String DNI;
	private String Departamento;
	private String Telefono;
	private String Es_Gestor;
	@ManyToOne
	private Universidad universidad;
	@ElementCollection
	@CollectionTable(name = "Solicitudes")
	@Column(name = "Solicitud")
	@OneToMany (mappedBy = "pdi")
	private List<Solicitud> solicitudes = new ArrayList<Solicitud>();
	private static final long serialVersionUID = 1L;

	public PDI() {
		super();
	}
	
	public PDI(Long id, String usuario, String contrasena, String correo, Rol rol, Universidad universidad ,String Nombre, String Apellidos, String DNI, String Departamento, String Telefono, String Es_Gestor) {
		super(id, usuario, contrasena, correo, rol, universidad);
		this.Nombre = Nombre;
		this.Apellidos = Apellidos;
		this.DNI = DNI;
		this.Departamento = Departamento;
		this.Telefono = Telefono;
		this.Es_Gestor = Es_Gestor;
	}   
	
	public String getNombre() {
		return this.Nombre;
	}

	public void setNombre(String Nombre) {
		this.Nombre = Nombre;
	}   
	public String getApellidos() {
		return this.Apellidos;
	}

	public void setApellidos(String Apellidos) {
		this.Apellidos = Apellidos;
	}   
	public String getDNI() {
		return this.DNI;
	}

	public void setDNI(String DNI) {
		this.DNI = DNI;
	}   
	public String getDepartamento() {
		return this.Departamento;
	}

	public void setDepartamento(String Departamento) {
		this.Departamento = Departamento;
	}   
	public String getTelefono() {
		return this.Telefono;
	}

	public void setTelefono(String Telefono) {
		this.Telefono = Telefono;
	}   
	public String getEs_Gestor() {
		return this.Es_Gestor;
	}

	public void setEs_Gestor(String Es_Gestor) {
		this.Es_Gestor = Es_Gestor;
	}
	public Universidad getUniversidad() {
		return universidad;
	}
	public void setUniversidad(Universidad universidad) {
		this.universidad = universidad;
	}
	public String toString() {
		return Nombre + Apellidos;
	}

	public List<Solicitud> getSolicitudes() {
		return solicitudes;
	}

	public void setSolicitudes(List<Solicitud> solicitudes) {
		this.solicitudes = solicitudes;
	}
	
}

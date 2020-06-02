package practica.sii.Clases;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Alumno
 *
 */
@Entity
@Table(name="Alumno")
public class Alumno extends Usuario implements Serializable {
 
	
	private String Nombre;
	private String Apellido;
	private String DNI;
	@ElementCollection
	private List<Paises> Destinos_Deseados = new ArrayList<Paises>();
	private String Direccion=null;
	@ElementCollection
	private List<Paises> Idiomas = new ArrayList<Paises>();
	private Integer Numero_Expediente;
	@ManyToOne
	private Universidad universidad;
	@ElementCollection
	@OneToMany (mappedBy = "alumno") 
	private List<Demanda> solicitudes = new ArrayList<Demanda>();
	private static final long serialVersionUID = 1L;

	public Alumno() {
		super();
	}   
	
	public Alumno(Long id, String usuario, String contrasena, String correo, Rol rol, Universidad universidad) {
		super(id,usuario,contrasena,correo,rol);
	}
	
	public String getNombre() {
		return this.Nombre;
	}

	public void setNombre(String Nombre) {
		this.Nombre = Nombre;
	}   
	public String getApellido() {
		return this.Apellido;
	}

	public void setApellido(String Apellido) {
		this.Apellido = Apellido;
	}   
	public String getDNI() {
		return this.DNI;
	}

	public void setDNI(String DNI) {
		this.DNI = DNI;
	}   
	public List<Paises> getDestinos_Deseados() {
		return this.Destinos_Deseados;
	}

	public void setDestinos_Deseados(List<Paises> Destinos_Deseados) {
		this.Destinos_Deseados = Destinos_Deseados;
	}   
	public String getDireccion() {
		return this.Direccion;
	}

	public void setDireccion(String Direccion) {
		this.Direccion = Direccion;
	}   
	public List<Paises> getIdiomas() {
		return this.Idiomas;
	}

	public void setIdiomas(List<Paises> Idiomas) {
		this.Idiomas = Idiomas;
	}   
	public Integer getNumero_Expediente() {
		return this.Numero_Expediente;
	}

	public void setNumero_Expediente(Integer Numero_Expediente) {
		this.Numero_Expediente = Numero_Expediente;
	}
	public Universidad getUniversidad() {
		return universidad;
	}
	public void setUniversidad(Universidad universidad) {
		this.universidad = universidad;
	}
	public List<Demanda> getSolicitudes() {
		return solicitudes;
	}
	public void setSolicitudes(List<Demanda> solicitudes) {
		this.solicitudes = solicitudes;
	}
	
}

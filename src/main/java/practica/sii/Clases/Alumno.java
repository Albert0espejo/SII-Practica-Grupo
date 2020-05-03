package practica.sii.Clases;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Alumno
 *
 */
@Entity
public class Alumno extends Usuario implements Serializable {

	
	private String Nombre;
	private String Alumno;
	private String DNI;
	private List<Paises> Destinos_Deseados;
	private String Direccion;
	private List<Paises> Idiomas;
	private Integer Numero_Expediente;
	@ManyToOne
	private Universidad universidad;
	@OneToMany (mappedBy = "alumno")
	private List<Solicitud> solicitudes;
	private static final long serialVersionUID = 1L;

	public Alumno() {
		super();
	}   
	public String getNombre() {
		return this.Nombre;
	}

	public void setNombre(String Nombre) {
		this.Nombre = Nombre;
	}   
	public String getAlumno() {
		return this.Alumno;
	}

	public void setAlumno(String Alumno) {
		this.Alumno = Alumno;
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
	public List<Solicitud> getSolicitudes() {
		return solicitudes;
	}
	public void setSolicitudes(List<Solicitud> solicitudes) {
		this.solicitudes = solicitudes;
	}
	
}

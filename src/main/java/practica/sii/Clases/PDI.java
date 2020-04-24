package practica.sii.Clases;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: PDI
 *
 */
@Entity
@DiscriminatorValue("PDI")
public class PDI extends Usuario implements Serializable {

	
	private String Nombre;
	private String Apellidos;
	private String DNI;
	private String Departamento;
	private String Telefono;
	private String Es_Gestor;
	@ManyToOne
	private Universidad universidad;
	private static final long serialVersionUID = 1L;

	public PDI() {
		super();
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
}

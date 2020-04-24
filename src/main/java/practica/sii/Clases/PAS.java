package practica.sii.Clases;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: PAS
 *
 */
@Entity
public class PAS extends Usuario implements Serializable {

	
	private String Facultad;
	private String Servicio;
	@Embedded
	private Address Direccion;
	private String Representante;
	private String Telefono;
	@ManyToOne
	private Universidad universidad;
	private static final long serialVersionUID = 1L;

	public PAS() {
		super();
	}   
	public String getFacultad() {
		return this.Facultad;
	}

	public void setFacultad(String Facultad) {
		this.Facultad = Facultad;
	}   
	public String getServicio() {
		return this.Servicio;
	}

	public void setServicio(String Servicio) {
		this.Servicio = Servicio;
	}   
	public Address getDireccion() {
		return this.Direccion;
	}

	public void setDireccion(Address Direccion) {
		this.Direccion = Direccion;
	}   
	public String getRepresentante() {
		return this.Representante;
	}

	public void setRepresentante(String Representante) {
		this.Representante = Representante;
	}   
	public String getTelefono() {
		return this.Telefono;
	}

	public void setTelefono(String Telefono) {
		this.Telefono = Telefono;
	}
	public Universidad getUniversidad() {
		return universidad;
	}
	public void setUniversidad(Universidad universidad) {
		this.universidad = universidad;
	}
	
}

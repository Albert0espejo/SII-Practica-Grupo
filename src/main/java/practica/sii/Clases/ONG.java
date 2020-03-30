package practica.sii.Clases;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: ONG
 *
 */
@Entity

public class ONG implements Serializable {

	
	private String Nombre;
	private String Descripcion;
	private String Direccion;
	private Integer Telefono;
	private String Representante;
	private String Direccion_Web;
	private static final long serialVersionUID = 1L;

	public ONG() {
		super();
	}   
	public String getNombre() {
		return this.Nombre;
	}

	public void setNombre(String Nombre) {
		this.Nombre = Nombre;
	}   
	public String getDescripcion() {
		return this.Descripcion;
	}

	public void setDescripcion(String Descripcion) {
		this.Descripcion = Descripcion;
	}   
	public String getDireccion() {
		return this.Direccion;
	}

	public void setDireccion(String Direccion) {
		this.Direccion = Direccion;
	}   
	public Integer getTelefono() {
		return this.Telefono;
	}

	public void setTelefono(Integer Telefono) {
		this.Telefono = Telefono;
	}   
	public String getRepresentante() {
		return this.Representante;
	}

	public void setRepresentante(String Representante) {
		this.Representante = Representante;
	}   
	public String getDireccion_Web() {
		return this.Direccion_Web;
	}

	public void setDireccion_Web(String Direccion_Web) {
		this.Direccion_Web = Direccion_Web;
	}
   
}

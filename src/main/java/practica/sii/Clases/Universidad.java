package practica.sii.Clases;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
* Entity implementation class for Entity: Universidad
*
*/
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Universidad implements Serializable{

	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id_Universidad;
	private String Nombre;
	private String Direccion;
	private String Direccion_Web;
	private String Ciudad;
	private Long Codigo_Postal;
	private static final long serialVersionUID = 1L;
	
	public Universidad() {
		super();
	}
	public Long getId_Universidad() {
		return this.Id_Universidad;
	}
	public void setId_Universidad(Long Id_Universidad) {
		this.Id_Universidad = Id_Universidad;
	}
	public String getNombre() {
		return this.Nombre;
	}
	public void setNombre(String Nombre) {
		this.Nombre = Nombre;
	}
	public String getDireccion() {
		return this.Nombre;
	}
	public void setDireccion(String Direccion) {
		this.Direccion = Direccion;
	}
	public String getDireccion_Web() {
		return this.Direccion_Web;
	}
	public void setDireccion_Web(String Direccion_Web) {
		this.Direccion_Web = Direccion_Web;
	}
	public String getCiudad() {
		return this.Ciudad;
	}
	public void setCiudad(String Ciudad) {
		this.Ciudad = Ciudad;
	}
	public Long getCodigo_Postal() {
		return this.Codigo_Postal;
	}
	public void setCodigo_Postal(Long Codigo_Postal) {
		this.Codigo_Postal= Codigo_Postal;
	}
	
}

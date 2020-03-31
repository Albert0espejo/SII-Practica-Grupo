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
	@Embedded
	private Address Direccion;
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
	public Address getDireccion() {
		return this.Direccion;
	}
	public void setDireccion(Address Direccion) {
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id_Universidad == null) ? 0 : Id_Universidad.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Universidad other = (Universidad) obj;
		if (Id_Universidad == null) {
			if (other.Id_Universidad != null)
				return false;
		} else if (!Id_Universidad.equals(other.Id_Universidad))
			return false;
		return true;
	}
}

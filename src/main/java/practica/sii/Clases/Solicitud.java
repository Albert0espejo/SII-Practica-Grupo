package practica.sii.Clases;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Solicitud
 *
 */
@Entity

public class Solicitud implements Serializable {

	   
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id_Solicitud;
	@Enumerated(EnumType.STRING)
	private Estado Estado;
	private static final long serialVersionUID = 1L;

	public Solicitud() {
		super();
	}   
	public Long getId_Solicitud() {
		return this.Id_Solicitud;
	}

	public void setId_Solicitud(Long Id_Solicitud) {
		this.Id_Solicitud = Id_Solicitud;
	}   
	public Estado getEstado() {
		return this.Estado;
	}

	public void setEstado(Estado Estado) {
		this.Estado = Estado;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id_Solicitud == null) ? 0 : Id_Solicitud.hashCode());
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
		Solicitud other = (Solicitud) obj;
		if (Id_Solicitud == null) {
			if (other.Id_Solicitud != null)
				return false;
		} else if (!Id_Solicitud.equals(other.Id_Solicitud))
			return false;
		return true;
	}
}

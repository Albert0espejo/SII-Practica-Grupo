package practica.sii.Clases;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Voluntariado
 *
 */
@Entity

public class Voluntariado extends Proyecto implements Serializable {

	
	private String Nombre_Voluntariado;
	private static final long serialVersionUID = 1L;

	public Voluntariado() {
		super();
	}   
	public String getNombre_Voluntariado() {
		return this.Nombre_Voluntariado;
	}

	public void setNombre_Voluntariado(String Nombre_Voluntariado) {
		this.Nombre_Voluntariado = Nombre_Voluntariado;
	}
   
}

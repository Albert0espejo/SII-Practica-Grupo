package practica.sii.Clases;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Actividades
 *
 */
@Entity

public class Actividades implements Serializable {

	
	private String Nombre_Actividad;
	private Integer Capacidad_Alumnos;
	private String Reconocimientos;
	private static final long serialVersionUID = 1L;

	public Actividades() {
		super();
	}   
	public String getNombre_Actividad() {
		return this.Nombre_Actividad;
	}

	public void setNombre_Actividad(String Nombre_Actividad) {
		this.Nombre_Actividad = Nombre_Actividad;
	}   
	public Integer getCapacidad_Alumnos() {
		return this.Capacidad_Alumnos;
	}

	public void setCapacidad_Alumnos(Integer Capacidad_Alumnos) {
		this.Capacidad_Alumnos = Capacidad_Alumnos;
	}   
	public String getReconocimientos() {
		return this.Reconocimientos;
	}

	public void setReconocimientos(String Reconocimientos) {
		this.Reconocimientos = Reconocimientos;
	}
   
}

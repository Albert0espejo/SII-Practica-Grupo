package practica.sii.Clases;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import java.sql.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Proyecto
 *
 */
@Entity

public class Proyecto implements Serializable {

	   
	@Id
	private Long ID_Proyecto;
	private String Lugar;
	private Date Fecha_Inicio;
	private Date Fecha_Final;
	private String Descripcion;
	private String Estado;
	private static final long serialVersionUID = 1L;

	public Proyecto() {
		super();
	}   
	public Long getID_Proyecto() {
		return this.ID_Proyecto;
	}

	public void setID_Proyecto(Long ID_Proyecto) {
		this.ID_Proyecto = ID_Proyecto;
	}   
	public String getLugar() {
		return this.Lugar;
	}

	public void setLugar(String Lugar) {
		this.Lugar = Lugar;
	}   
	public Date getFecha_Inicio() {
		return this.Fecha_Inicio;
	}

	public void setFecha_Inicio(Date Fecha_Inicio) {
		this.Fecha_Inicio = Fecha_Inicio;
	}   
	public Date getFecha_Final() {
		return this.Fecha_Final;
	}

	public void setFecha_Final(Date Fecha_Final) {
		this.Fecha_Final = Fecha_Final;
	}   
	public String getDescripcion() {
		return this.Descripcion;
	}

	public void setDescripcion(String Descripcion) {
		this.Descripcion = Descripcion;
	}   
	public String getEstado() {
		return this.Estado;
	}

	public void setEstado(String Estado) {
		this.Estado = Estado;
	}
   
}

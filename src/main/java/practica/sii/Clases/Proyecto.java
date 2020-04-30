package practica.sii.Clases;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Proyecto
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Proyecto implements Serializable {

	   
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long ID_Proyecto;
	private String Lugar;
	@Temporal(TemporalType.DATE)
	private Date Fecha_Inicio;
	@Temporal(TemporalType.DATE)
	private Date Fecha_Final;
	private String Descripcion;
	@Enumerated(EnumType.STRING)
	private Estado Estado;
	@OneToMany(mappedBy = "proyecto")
	private List<Solicitud> solicitudes;
	

	private static final long serialVersionUID = 1L;
	
	@ManyToMany
	private List<Usuario> ong;
	//private List<ONG> ong; Cambiamos List<ONG> a List<Usuario> solo en esta tarea 2 para las vista. Esto se implementará en la tarea 3
	
	
	public Proyecto() {
		super();
	}
	
	public Proyecto(Long ID_Proyecto, String Lugar, Date Fecha_Inicio, Date Fecha_Final, String Descripcion, Estado Estado) {
		this.ID_Proyecto = ID_Proyecto;
		this.Lugar = Lugar;
		this.Fecha_Inicio = Fecha_Inicio;
		this.Fecha_Final = Fecha_Final;
		this.Descripcion = Descripcion;
		this.Estado = Estado;
	}
	
	public List<Solicitud> getSolicitudes() {
		return solicitudes;
	}
	
	public void setSolicitudes(List<Solicitud> solicitudes) {
		this.solicitudes = solicitudes;
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
		result = prime * result + ((ID_Proyecto == null) ? 0 : ID_Proyecto.hashCode());
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
		Proyecto other = (Proyecto) obj;
		if (ID_Proyecto == null) {
			if (other.ID_Proyecto != null)
				return false;
		} else if (!ID_Proyecto.equals(other.ID_Proyecto))
			return false;
		return true;
	}
	/*public List<ONG> getOng() {
		return ong;
	}
	public void setOng(List<ONG> ong) {
		this.ong = ong;
	}*/
	
	public List<Usuario> getOng() {
		return ong;
	}
	public void setOng(List<Usuario> ong) {
		this.ong = ong;
	}
}

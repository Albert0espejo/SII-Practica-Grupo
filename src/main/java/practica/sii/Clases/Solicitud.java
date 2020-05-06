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
	@ManyToOne
	private Universidad universidad;
	@ManyToOne
	private Proyecto proyecto;
	@ManyToOne
	private PDI pdi;
	@ManyToOne
	private PAS pas;
	@ManyToOne
	private Alumno alumno;
	@OneToOne
    @JoinColumn(name = "fk_feedback")
	private FeedBack comentarios;
	private static final long serialVersionUID = 1L;
	
	public Solicitud() {
		super();
	}

	public Solicitud(Long Id_Solicitud, Estado Estado, Universidad universidad, Proyecto proyecto) {
		this.Id_Solicitud = Id_Solicitud;
		this.Estado = Estado;
		this.universidad = universidad;
		this.proyecto = proyecto;
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

	public PDI getPdi() {
		return pdi;
	}

	public void setPdi(PDI pdi) {
		this.pdi = pdi;
	}

	public PAS getPas() {
		return pas;
	}

	public void setPas(PAS pas) {
		this.pas = pas;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	public FeedBack getComentarios() {
		return comentarios;
	}

	public void setComentarios(FeedBack comentarios) {
		this.comentarios = comentarios;
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
	public Universidad getUniversidad() {
		return universidad;
	}
	public void setUniversidad(Universidad universidad) {
		this.universidad = universidad;
	}
	public Proyecto getProyecto() {
		return proyecto;
	}
	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}
	
}

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

public class Demanda implements Serializable {

	   
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
	private String Comentarios_Profesor;
	private String Comentarios_Alumno;
	private String Comentarios_ONG;
	private Float Nota;
	
	public String getComentarios_Profesor() {
		return Comentarios_Profesor;
	}

	public void setComentarios_Profesor(String comentarios_Profesor) {
		Comentarios_Profesor = comentarios_Profesor;
	}

	public String getComentarios_Alumno() {
		return Comentarios_Alumno;
	}

	public void setComentarios_Alumno(String comentarios_Alumno) {
		Comentarios_Alumno = comentarios_Alumno;
	}

	public String getComentarios_ONG() {
		return Comentarios_ONG;
	}

	public void setComentarios_ONG(String comentarios_ONG) {
		Comentarios_ONG = comentarios_ONG;
	}

	public Float getNota() {
		return Nota;
	}

	public void setNota(Float nota) {
		Nota = nota;
	}
	private static final long serialVersionUID = 1L;
	
	public Demanda() {
		super();
	}

	public Demanda(Long Id_Solicitud, Estado Estado, Universidad universidad, Proyecto proyecto) {
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
		Demanda other = (Demanda) obj;
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
	public String toString() {
		return "Id:" + this.Id_Solicitud + "/" +this.proyecto.getDescripcion() +" Universidad:" + this.universidad.getNombre()  + " Estado:" + this.Estado;
		
	}
	
}

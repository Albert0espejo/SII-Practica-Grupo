package practica.sii.Clases;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: FeedBack
 *
 */
@Entity

public class FeedBack implements Serializable {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id_FeedBack;	
	private String Comentario_Profesor;
	private Integer Nota_ONG;
	private String Comentario_ONG;
	private String Comentario_Alumno;
	private static final long serialVersionUID = 1L;

	public FeedBack() {
		super();
	}
	
	public Long getId_FeedBack() {
		return Id_FeedBack;
	}

	public void setId_FeedBack(Long id_FeedBack) {
		Id_FeedBack = id_FeedBack;
	}

	public String getComentario_Profesor() {
		return this.Comentario_Profesor;
	}

	public void setComentario_Profesor(String Comentario_Profesor) {
		this.Comentario_Profesor = Comentario_Profesor;
	}   
	public Integer getNota_ONG() {
		return this.Nota_ONG;
	}

	public void setNota_ONG(Integer Nota_ONG) {
		this.Nota_ONG = Nota_ONG;
	}   
	public String getComentario_ONG() {
		return this.Comentario_ONG;
	}

	public void setComentario_ONG(String Comentario_ONG) {
		this.Comentario_ONG = Comentario_ONG;
	}   
	public String getComentario_Alumno() {
		return this.Comentario_Alumno;
	}

	public void setComentario_Alumno(String Comentario_Alumno) {
		this.Comentario_Alumno = Comentario_Alumno;
	}
   
}

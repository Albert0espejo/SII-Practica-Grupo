package practica.sii.Clases;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import java.sql.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Noticias
 *
 */
@Entity

public class Noticia implements Serializable {

	   
	@Id @GeneratedValue
	private Long ID_Noticia;
	private String Titulo;
	private String Texto;
	private String Autor;
	private Date Fecha_Publicacion;
	private static final long serialVersionUID = 1L;

	public Noticia() {
		super();
	}   
	public Long getID_Noticia() {
		return this.ID_Noticia;
	}

	public void setID_Noticia(Long ID_Noticia) {
		this.ID_Noticia = ID_Noticia;
	}   
	public String getTitulo() {
		return this.Titulo;
	}

	public void setTitulo(String Titulo) {
		this.Titulo = Titulo;
	}   
	public String getTexto() {
		return this.Texto;
	}

	public void setTexto(String Texto) {
		this.Texto = Texto;
	}   
	public String getAutor() {
		return this.Autor;
	}

	public void setAutor(String Autor) {
		this.Autor = Autor;
	}   
	public Date getFecha_Publicacion() {
		return this.Fecha_Publicacion;
	}

	public void setFecha_Publicacion(Date Fecha_Publicacion) {
		this.Fecha_Publicacion = Fecha_Publicacion;
	}
   
}

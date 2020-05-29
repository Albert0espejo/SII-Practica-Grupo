package practica.sii.Clases;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Noticias
 *
 */
@NamedQuery(name = "Noticias.todos", query="select c from Noticias c")
@Entity
@Table(name = "Noticias")
public class Noticias implements Serializable {

	   
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id_Noticia;
	private String Titulo;
	private String Texto;
	@Temporal(TemporalType.DATE)
	private Date Fecha_Publicacion;
	private String Autor;
	@ManyToOne
	private Usuario ong;	
	private static final long serialVersionUID = 1L;

	//private ONG ong; Cambio para que sea funcional la vista. Solo hace falta implementar ya que usamos la clase Usuario como general
	//y deberiamos usar ONG. Este solo es un cambio para la tarea 2.

	public Noticias() {
		super();
	}   
	
	public Noticias(Long ID,String Titulo,String Texto,String Autor, Date F_public,Usuario ONG) {
		this.Id_Noticia=ID;
		this.Titulo=Titulo;
		this.Texto=Texto;
		this.Fecha_Publicacion=F_public;
		this.Autor=Autor;
		this.ong=ONG;
	}
	
	public Long getId_Noticia() {
		return this.Id_Noticia;
	}

	public void setId_Noticia(Long Id_Noticia) {
		this.Id_Noticia = Id_Noticia;
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
	public Date getFecha_Publicacion() {
		return this.Fecha_Publicacion;
	}

	public void setFecha_Publicacion(Date Fecha_Publicacion) {
		this.Fecha_Publicacion = Fecha_Publicacion;
	}   
	public String getAutor() {
		return this.Autor;
	}

	public void setAutor(String Autor) {
		this.Autor = Autor;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id_Noticia == null) ? 0 : Id_Noticia.hashCode());
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
		Noticias other = (Noticias) obj;
		if (Id_Noticia == null) {
			if (other.Id_Noticia != null)
				return false;
		} else if (!Id_Noticia.equals(other.Id_Noticia))
			return false;
		return true;
	}
/*	public ONG getOng() {
		return ong;
	}
	public void setOng(ONG ong) {
		this.ong = ong;
	}*/
	public Usuario getOng() {
		return ong;
	}
	public void setOng(Usuario ong) {
		this.ong = ong;
	}
}

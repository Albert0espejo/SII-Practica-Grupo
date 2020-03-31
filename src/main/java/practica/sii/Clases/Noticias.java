package practica.sii.Clases;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import java.sql.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Noticias
 *
 */
@Entity

public class Noticias implements Serializable {

	   
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id_Noticia;
	private String Titulo;
	private String Texto;
	@Temporal(TemporalType.DATE)
	private Date Fecha_Publicacion;
	private String Autor;
	private static final long serialVersionUID = 1L;
	
	@OneToMany (mappedBy="noticias")
	private List<ONG> ong;

	public Noticias() {
		super();
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
	public List<ONG> getOng() {
		return ong;
	}
	public void setOng(List<ONG> ong) {
		this.ong = ong;
	}
}

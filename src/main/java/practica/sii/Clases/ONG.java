package practica.sii.Clases;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


/**
 * Entity implementation class for Entity: ONG
 *
 */
@Entity
public class ONG extends Usuario implements Serializable {

	
	private String Nombre;
	private String Descripcion;
	@Embedded
	private Address Direccion;
	private Integer Telefono;
	private String Representante;
	private String Direccion_Web;
	@ElementCollection
	@CollectionTable(name = "Proyectos")
	@Column(name = "Proyecto")
	@ManyToMany (mappedBy="ong")
	private List<Proyecto> proyecto = new ArrayList<Proyecto>();
	@ElementCollection
	@CollectionTable(name = "Noticias")
	@Column(name = "Noticia")
	@OneToMany (mappedBy = "ong")
	private List<Noticias> noticias = new ArrayList<Noticias>();	
	private static final long serialVersionUID = 1L;
	
	
	public List<Proyecto> getProyecto() {
		return proyecto;
	}
	public void setProyecto(List<Proyecto> proyecto) {
		this.proyecto = proyecto;
	}
	public List<Noticias> getNoticias() {
		return noticias;
	}
	public void setNoticias(List<Noticias> noticias) {
		this.noticias = noticias;
	}
	public ONG() {
		super();
	}   
	public String getNombre() {
		return this.Nombre;
	}

	public void setNombre(String Nombre) {
		this.Nombre = Nombre;
	}   
	public String getDescripcion() {
		return this.Descripcion;
	}

	public void setDescripcion(String Descripcion) {
		this.Descripcion = Descripcion;
	}   
	public Address getDireccion() {
		return this.Direccion;
	}

	public void setDireccion(Address Direccion) {
		this.Direccion = Direccion;
	}   
	public Integer getTelefono() {
		return this.Telefono;
	}

	public void setTelefono(Integer Telefono) {
		this.Telefono = Telefono;
	}   
	public String getRepresentante() {
		return this.Representante;
	}

	public void setRepresentante(String Representante) {
		this.Representante = Representante;
	}   
	public String getDireccion_Web() {
		return this.Direccion_Web;
	}

	public void setDireccion_Web(String Direccion_Web) {
		this.Direccion_Web = Direccion_Web;
	}
   
}

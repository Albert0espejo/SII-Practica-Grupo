package practica.sii.Clases;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: usuario
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQueries ({
    @NamedQuery(name="todosUsuarios", query="SELECT c FROM Usuario c")
})
public class Usuario implements Serializable {

	public enum Rol {
	      ADMINISTRADOR,
	      PAS,
	      PDI,
	      ONG,
	      ALUMNO
	};
	   
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	private String usuario;
	private String contrasena;
	private String correo;
	private Rol rol;
	@ManyToOne
	private Universidad universidad;
	private static final long serialVersionUID = 1L;

	public Usuario() {
		super();
	}
	
	public Usuario(Long id, String usuario, String contrasena, Rol rol) {
		this.Id = id;
		this.usuario = usuario;
		this.contrasena = contrasena;
		this.rol = rol;
	}
	
	public Long getId() {
		return this.Id;
	}

	public void setId(Long Id) {
		this.Id = Id;
	}   
	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}   
	public String getContrasena() {
		return this.contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}   
	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public Universidad getUniversidad() {
		return universidad;
	}
	public void setUniversidad(Universidad universidad) {
		this.universidad = universidad;
	}
	public Rol getRol() {
		return rol;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
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
		Usuario other = (Usuario) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		return true;
	}
}

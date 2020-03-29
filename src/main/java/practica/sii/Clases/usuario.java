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
class usuario implements Serializable {

	   
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	private String usuario;
	private String contraseña;
	private String correo;
	private static final long serialVersionUID = 1L;

	public usuario() {
		super();
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
	public String getContraseña() {
		return this.contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}   
	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
   
}

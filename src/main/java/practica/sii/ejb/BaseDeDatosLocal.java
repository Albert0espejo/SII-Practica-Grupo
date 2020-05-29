package practica.sii.ejb;

import java.util.List;

import javax.ejb.Local;

import practica.sii.Clases.Usuario;

@Local
public interface BaseDeDatosLocal {
	List<Usuario> todoUsuarios();
	void aniadirUsuario(Usuario c);
	void eliminarUsuario(Usuario c);
}

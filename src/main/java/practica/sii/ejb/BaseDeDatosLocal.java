package practica.sii.ejb;

import java.util.List;

import javax.ejb.Local;

import practica.sii.Clases.Usuario;

@Local
public interface BaseDeDatosLocal {
	List<Usuario> todoContactos();
	void aniadirContacto(Usuario c);
	void eliminarContacto(Usuario c);
}

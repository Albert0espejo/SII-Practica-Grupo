package practica.sii.ejb;

import java.util.List;

import javax.ejb.Local;

import practica.sii.Clases.Demanda;
import practica.sii.Clases.Noticias;
import practica.sii.Clases.Proyecto;
import practica.sii.Clases.Universidad;
import practica.sii.Clases.Usuario;

@Local
public interface BaseDeDatosLocal {
	List<Usuario> todoUsuarios();
	void aniadirUsuario(Usuario c);
	void eliminarUsuario(Usuario c);
	List<Demanda> todoSolicitudes();
	List<Universidad> todoUniversidad();
	List<Noticias> todoNoticias();
	List<Proyecto> todoProyectos();
}

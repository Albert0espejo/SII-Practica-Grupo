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
	void eliminarSolicitud(Demanda c);
	List<Universidad> todoUniversidad();
	void eliminarUniversidad(Universidad c);
	List<Noticias> todoNoticias();
	void eliminarNoticia(Noticias c);
	List<Proyecto> todoProyectos();
	void eliminarProyecto(Proyecto c);
}

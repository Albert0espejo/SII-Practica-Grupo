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
	void actualizarUsuario(Usuario c);
	List<Demanda> todoSolicitudes();
	void aniadirSolicitud(Demanda c);
	void eliminarSolicitud(Demanda c);
	List<Universidad> todoUniversidad();
	void aniadirUniversidad(Universidad c);
	void eliminarUniversidad(Universidad c);
	List<Noticias> todoNoticias();
	void aniadirNoticia(Noticias c);
	void eliminarNoticia(Noticias c);
	List<Proyecto> todoProyectos();
	void aniadirProyecto(Proyecto c);
	void eliminarProyecto(Proyecto c);
	List<Demanda> listaSolicitudes();
	List<Usuario> listaProfesores();
}

package practica.sii.ejb;

import java.util.List;

import javax.ejb.Local;

import practica.sii.Clases.Alumno;
import practica.sii.Clases.Demanda;
import practica.sii.Clases.Noticias;
import practica.sii.Clases.ONG;
import practica.sii.Clases.PAS;
import practica.sii.Clases.PDI;
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
	List<Demanda> listaSolicitudes();//solicitudes de la uma
	void aniadirSolicitud(Demanda c);
	void eliminarSolicitud(Demanda c);
	void actualizarSolicitud(Demanda c);
	
	List<Universidad> todoUniversidad();
	void aniadirUniversidad(Universidad c);
	void eliminarUniversidad(Universidad c);
	void actualizarUniversidad(Universidad c);
	Universidad findUni(Long id);
	
	List<Noticias> todoNoticias();
	void aniadirNoticia(Noticias c);
	void eliminarNoticia(Noticias c);
	void actualizarNoticia(Noticias c);
	
	List<Proyecto> todoProyectos();
	void aniadirProyecto(Proyecto c);
	void eliminarProyecto(Proyecto c);
	void actualizarProyecto(Proyecto c);
	Proyecto findProyecto(Long id);
	
	List<Usuario> todoONG();
	void aniadirONG(ONG c);
	void actualizarONG(ONG c);
	
	List<Usuario> listaProfesores();

	List<Usuario> todoPDI();
	void aniadirPDI(PDI c);
	void actualizarPDI(PDI c);
	
	List<Usuario> todoPAS();
	void aniadirPAS(PAS c);
	void actualizarPAS(PAS c);
	
	List<Usuario> todoAlumnos();
	void aniadirAlumno(Alumno c);
	void actualizarAlumno(Alumno c);
	
}

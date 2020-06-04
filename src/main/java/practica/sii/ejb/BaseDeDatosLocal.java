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
	Usuario findUsuario(Long c);
	
	
	List<Demanda> todoSolicitudes();
	List<Demanda> listaSolicitudes();//solicitudes de la uma
	void aniadirSolicitud(Demanda c);
	void eliminarSolicitud(Demanda c);
	void actualizarSolicitud(Demanda c);
	Demanda findSolicitud(Long c);
	
	List<Universidad> todoUniversidad();
	void aniadirUniversidad(Universidad c);
	void eliminarUniversidad(Universidad c);
	void actualizarUniversidad(Universidad c);
	Universidad findUni(Long id);
	
	List<Noticias> todoNoticias();
	void aniadirNoticia(Noticias c);
	void eliminarNoticia(Noticias c);
	void actualizarNoticia(Noticias c);
	Noticias findNoticia(Long id);
	
	List<Proyecto> todoProyectos();
	void aniadirProyecto(Proyecto c);
	void eliminarProyecto(Proyecto c);
	void actualizarProyecto(Proyecto c);
	Proyecto findProyecto(Long id);
	
	List<Usuario> todoONG();//sacar todos los usuarios con roll ONG
	List<ONG> todoONGTablaONG();//sacar todas las entidades ONG
	void aniadirONG(ONG c);
	void eliminarONG(ONG c);
	void actualizarONG(ONG c);
	ONG findONG(Long id);
	
	
	List<Usuario> todoPDI();//sacar todos los usuarios con roll PDI
	List<PDI> todoPDITablaPDI();//sacar todas las entidades PDI
	void aniadirPDI(PDI c);
	void eliminarPDI(PDI c);
	void actualizarPDI(PDI c);
	PDI findPDI(Long id);
	
	List<Usuario> todoPAS();//sacar todos los usuarios con roll PAS
	List<PAS> todoPASTablaPAS();//sacar todas las entidades PAS
	void aniadirPAS(PAS c);
	void eliminarPAS(PAS c);
	void actualizarPAS(PAS c);
	PAS findPAS(Long id);
	
	List<Usuario> todoAlumnos();//sacar todos los usuarios con roll Alumno
	List<Alumno> todoAlumnosTablaAlumno();//sacar todas las entidades Alumno
	void aniadirAlumno(Alumno c);
	void eliminarAlumno(Alumno c);
	void actualizarAlumno(Alumno c);
	Alumno findAlumno(Long id);
	
	
	
	
		
}

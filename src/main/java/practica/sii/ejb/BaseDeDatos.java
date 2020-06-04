package practica.sii.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import practica.sii.Autentificacion.ControlPAS;
import practica.sii.Clases.Alumno;
import practica.sii.Clases.Demanda;
import practica.sii.Clases.Noticias;
import practica.sii.Clases.ONG;
import practica.sii.Clases.PAS;
import practica.sii.Clases.PDI;
import practica.sii.Clases.Proyecto;
import practica.sii.Clases.Universidad;
import practica.sii.Clases.Usuario;

/**
 * Session Bean implementation class BaseDeDatos
 */
@Stateless
public class BaseDeDatos implements BaseDeDatosLocal {
	
	@PersistenceContext(unitName = "practica.sii")
	private EntityManager em;
	
	@Override
	public List<Usuario> todoUsuarios() {
		return em.createNamedQuery("Usuario.todos", Usuario.class).getResultList();
	}

	@Override
	public void aniadirUsuario(Usuario c) {
		em.persist(c);
		
	}

	@Override
	public void eliminarUsuario(Usuario c) {
		em.remove(em.merge(c));
	}

	@Override
	public void actualizarUsuario(Usuario c) {
		em.merge(c);
		
	}
	
	@Override
	public List<Universidad> todoUniversidad() {
		return em.createNamedQuery("Universidad.todos", Universidad.class).getResultList();
	}
	
	@Override
	public void aniadirUniversidad(Universidad c) {
		em.persist(c);
		
	}
	
	@Override
	public void eliminarUniversidad(Universidad c) {
		em.remove(em.merge(c));
	}
	
	@Override
	public List<Demanda> todoSolicitudes() {
		return em.createNamedQuery("Demanda.todos", Demanda.class).getResultList();
	}
	
	@Override
	public void aniadirSolicitud(Demanda c) {
		em.persist(c);
		
	}
	
	@Override
	public void editSolicitud(Demanda c){
        em.merge(c);
    }
	
	@Override
	public void eliminarSolicitud(Demanda c) {
		em.remove(em.merge(c));
	}
	
	@Override
	public List<Noticias> todoNoticias() {
		return em.createNamedQuery("Noticias.todos", Noticias.class).getResultList();
	}
	
	@Override
	public void aniadirNoticia(Noticias c) {
		em.persist(c);
		
	}
	
	@Override
	public void eliminarNoticia(Noticias c) {
		em.remove(em.merge(c));
	}
	
	@Override
	public List<Proyecto> todoProyectos() {
		return em.createNamedQuery("Proyecto.todos", Proyecto.class).getResultList();
	}
	
	@Override
	public void aniadirProyecto(Proyecto c) {
		em.persist(c);
		
	}
	
	@Override
	public void editProyecto(Proyecto c){
        em.merge(c);
    }
	
	@Override
	public void eliminarProyecto(Proyecto c) {
		em.remove(em.merge(c));
	}

	@Override
	public List<Demanda> listaSolicitudes() {
		return em.createNamedQuery("listaSolicitudes.todos", Demanda.class).getResultList();
	}

	@Override
	public List<Usuario> listaProfesores() {
		return em.createNamedQuery("Usuario.PDI", Usuario.class).getResultList();
	}
	
	@Override
	public List<Usuario> todoONG() {
		return em.createNamedQuery("Usuario.ong", Usuario.class).getResultList();
	}

	@Override
	public List<Usuario> todoPAS() {
		return em.createNamedQuery("Usuario.pas", Usuario.class).getResultList();
	}

	@Override
	public List<Usuario> todoPDI() {
		return em.createNamedQuery("Usuario.pdi", Usuario.class).getResultList();
	}

	@Override
	public List<Usuario> todoAlumnos() {
		return em.createNamedQuery("Usuario.alumno", Usuario.class).getResultList();
	}
	
	@Override
	public Proyecto findProyecto(Long id) {
        return em.find(Proyecto.class, id);
    }
	
	@Override
	public void aniadirONG(ONG c) {
		em.persist(c);
	}
	
	@Override
	public void aniadirAlumno(Alumno c) {
		em.persist(c);
	}
	
	@Override
	public void aniadirPDI(PDI c) {
		em.persist(c);
	}
	
	@Override
	public void aniadirPAS(PAS c) {
		em.persist(c);
	}
}

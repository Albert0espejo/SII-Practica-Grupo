package practica.sii.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import practica.sii.Clases.Demanda;
import practica.sii.Clases.Noticias;
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
	public void eliminarProyecto(Proyecto c) {
		em.remove(em.merge(c));
	}

}

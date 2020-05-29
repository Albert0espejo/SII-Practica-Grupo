package practica.sii.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

}

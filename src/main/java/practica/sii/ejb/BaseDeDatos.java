package practica.sii.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
	public Usuario findUsuario(Long id) {
        return em.find(Usuario.class, id);
		
	}
	
	
	
	
	
	@Override
	public List<Demanda> todoSolicitudes() {
		return em.createNamedQuery("Demanda.todos", Demanda.class).getResultList();
	}
	
	@Override
	public List<Demanda> listaSolicitudes() {
		return em.createNamedQuery("listaSolicitudes.todos", Demanda.class).getResultList();  
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
	public void actualizarSolicitud(Demanda c) {
		em.merge(c);
		
	}
	
	@Override
	public Demanda findSolicitud(Long id) {
        return em.find(Demanda.class, id);
		
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
	public void actualizarUniversidad(Universidad c) {
		em.merge(c);
		
	}
	
	@Override
	public Universidad findUni(Long id) {
        return em.find(Universidad.class, id);
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
	public void actualizarNoticia(Noticias c) {
		em.merge(c);
		
	}
	
	@Override
	public Noticias findNoticia(Long id) {
        return em.find(Noticias.class, id);
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
	
	@Override
	public void actualizarProyecto(Proyecto c) {
		em.merge(c);
		
	}
	
	@Override
	public Proyecto findProyecto(Long id) {
        return em.find(Proyecto.class, id);
    }
	
	
	
	
	
	
	@Override
	public List<Usuario> todoONG() {
		return em.createNamedQuery("Usuario.ong", Usuario.class).getResultList();
	}

	@Override
	public List<ONG> todoONGTablaONG() {
		return em.createNamedQuery("ONG.todos", ONG.class).getResultList();
	}
	
	@Override
	public void aniadirONG(ONG c) {
		em.persist(c);
	}
	
	@Override
	public void eliminarONG(ONG c) {
		em.remove(em.merge(c));
	}
	
	@Override
	public void actualizarONG(ONG c) {
		em.merge(c);
		
	}
	
	@Override
	public ONG findONG(Long id) {
        return em.find(ONG.class, id);
    }
	
	
	
	
	
	
	
	
	
	@Override
	public List<Usuario> todoPDI() {
		return em.createNamedQuery("Usuario.pdi", Usuario.class).getResultList();
	}
	
	@Override
	public List<PDI> todoPDITablaPDI() {
		return em.createNamedQuery("PDI.todos", PDI.class).getResultList();
	}
	
	@Override
	public void aniadirPDI(PDI c) {
		em.persist(c);
	}
	
	@Override
	public void eliminarPDI(PDI c) {
		em.remove(em.merge(c));
	}
	
	@Override
	public void actualizarPDI(PDI c) {
		em.merge(c);
		
	}
	
	@Override
	public PDI findPDI(Long id) {
        return em.find(PDI.class, id);
    }
	
	
	
	
	@Override
	public List<Usuario> todoPAS() {
		return em.createNamedQuery("Usuario.pas", Usuario.class).getResultList();
	}

	@Override
	public List<PAS> todoPASTablaPAS() {
		return em.createNamedQuery("PAS.todos", PAS.class).getResultList();
	}
	
	@Override
	public void aniadirPAS(PAS c) {
		em.persist(c);
	}
	
	@Override
	public void eliminarPAS(PAS c) {
		em.remove(em.merge(c));
	}
	
	@Override
	public void actualizarPAS(PAS c) {
		em.merge(c);
		
	}
	
	@Override
	public PAS findPAS(Long id) {
        return em.find(PAS.class, id);
    }
	
	
	
	
	@Override
	public List<Usuario> todoAlumnos() {
		return em.createNamedQuery("Usuario.alumno", Usuario.class).getResultList();
	}
	
	@Override
	public List<Alumno> todoAlumnosTablaAlumno() {
		return em.createNamedQuery("Alumno.todos", Alumno.class).getResultList();
	}
	
	@Override
	public void aniadirAlumno(Alumno c) {
		em.persist(c);
	}
	
	@Override
	public void eliminarAlumno(Alumno c) {
		em.remove(em.merge(c));
	}
	
	@Override
	public void actualizarAlumno(Alumno c) {
		em.merge(c);
		
	}
	
	@Override
	public Alumno findAlumno(Long id) {
        return em.find(Alumno.class, id);
    }
	
	
	
	
	
	
}

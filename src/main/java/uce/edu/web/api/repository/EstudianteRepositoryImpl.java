package uce.edu.web.api.repository;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import uce.edu.web.api.repository.modelo.Estudiante;


@Transactional
@ApplicationScoped
public class EstudianteRepositoryImpl implements IEstudianteRepository {
      @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Estudiante buscarPorId(Integer id) {
        return this.entityManager.find(Estudiante.class, id);
    }

    @Override
    public void insertar(Estudiante persona) {
        this.entityManager.persist(persona);

    }

    @Override
    public void actualizar(Estudiante persona) {
        this.entityManager.merge(persona);

    }

    @Override
    public void eliminar(Integer id) {
        this.entityManager.remove(this.buscarPorId(id));


    }

    @Override
    public List<Estudiante> buscarTodos() {
        return this.entityManager.createQuery("SELECT p FROM Estudiante p", Estudiante.class).getResultList();
    }

    @Override
    public List<Estudiante> buscarPorApellido(String apellido) {
        return this.entityManager.createQuery("SELECT p FROM Estudiante p WHERE p.apellido = :apellido", Estudiante.class)
                .setParameter("apellido", apellido).getResultList();
    }

    @Override
    public List<Estudiante> buscarPorApellidoyEdad(String apellido, Integer edad) {
        return this.entityManager.createQuery("SELECT p FROM Estudiante p WHERE p.apellido = :apellido AND p.edad = :edad", Estudiante.class)
                .setParameter("apellido", apellido).setParameter("edad", edad).getResultList();
    }

   
}

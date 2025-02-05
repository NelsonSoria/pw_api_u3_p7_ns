package uce.edu.web.api.repository;

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

}

package uce.edu.web.api.repository;

import uce.edu.web.api.repository.modelo.Estudiante;

public interface IEstudianteRepository {

    public Estudiante buscarPorId(Integer id);
    public void insertar(Estudiante persona);
    public void actualizar(Estudiante persona);
    public void eliminar(Integer id);

}
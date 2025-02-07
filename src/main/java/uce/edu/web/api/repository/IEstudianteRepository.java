package uce.edu.web.api.repository;

import java.util.List;

import uce.edu.web.api.repository.modelo.Estudiante;

public interface IEstudianteRepository {

    public Estudiante buscarPorId(Integer id);
    public void insertar(Estudiante persona);
    public void actualizar(Estudiante persona);
    public void eliminar(Integer id);
    public List<Estudiante> buscarTodos();
    public List<Estudiante> buscarPorApellido(String apellido);
    public List<Estudiante> buscarPorApellidoyEdad(String apellido, Integer edad);

}
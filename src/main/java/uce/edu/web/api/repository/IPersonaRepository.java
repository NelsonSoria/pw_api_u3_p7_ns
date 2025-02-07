package uce.edu.web.api.repository;

import java.util.List;

import uce.edu.web.api.repository.modelo.Persona;

public interface IPersonaRepository {
    public Persona buscarPorId(Integer id);
    public void insertar(Persona persona);
    public void actualizar(Persona persona);
    public void eliminar(Integer id);
    public List<Persona> buscarTodos();
    public List<Persona> buscarTodosPorNombre(String nombre);
    public List<Persona> buscarTodosPorNombreyApellido(String nombre, String apellido);

}

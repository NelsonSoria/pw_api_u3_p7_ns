package uce.edu.web.api.service;

import java.util.List;

import uce.edu.web.api.repository.modelo.Estudiante;
import uce.edu.web.api.service.to.EstudianteTo;

public interface IEstudianteService {

    public EstudianteTo buscarPorId(Integer id);

    public void guardar(EstudianteTo persona);

    public void actualizar(EstudianteTo persona);

    public void borrar(Integer id);

    public List<EstudianteTo> buscarTodos();

    public List<EstudianteTo> buscarPorApellido(String apellido);

    public List<EstudianteTo> buscarPorApellidoyEdad(String apellido, Integer edad);

}

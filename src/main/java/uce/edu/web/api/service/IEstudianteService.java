package uce.edu.web.api.service;

import uce.edu.web.api.service.to.EstudianteTo;

public interface IEstudianteService {

    public EstudianteTo buscarPorId(Integer id);
    public void guardar(EstudianteTo persona);
    public void actualizar(EstudianteTo persona);
    public void borrar(Integer id);

}

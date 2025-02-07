package uce.edu.web.api.service;

import java.util.List;
import java.util.function.Function;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import uce.edu.web.api.repository.IEstudianteRepository;
import uce.edu.web.api.repository.modelo.Estudiante;
import uce.edu.web.api.service.to.EstudianteTo;


@ApplicationScoped
public class EstudianteServiceImp implements IEstudianteService {
    @Inject
    private IEstudianteRepository iEstudianteRepository;

     private Function<Estudiante, EstudianteTo> mapTo = e -> {
        EstudianteTo eTo =new EstudianteTo(e.getId(), e.getNombre(), e.getApellido(), e.getCedula(),e.getEdad());  
        return eTo;  
    };

    
    private Function<EstudianteTo, Estudiante> mapEstudiante = es-> {
        Estudiante e =new Estudiante(es.getId(), es.getNombre(), es.getApellido(), es.getCedula(),es.getEdad());  
        return e;  
    };

    @Override
    public EstudianteTo buscarPorId(Integer id) {
        Estudiante e = this.iEstudianteRepository.buscarPorId(id);
        return this.mapTo.apply(e);
    }

    @Override
    public void guardar(EstudianteTo persona) {
      this.iEstudianteRepository.insertar(this.mapEstudiante.apply(persona));
    }

    @Override
    public void actualizar(EstudianteTo persona) {
        this.iEstudianteRepository.actualizar(this.mapEstudiante.apply(persona));
       
    }

    @Override
    public void borrar(Integer id) {
        this.iEstudianteRepository.eliminar(id);
       
    }

    @Override
    public List<EstudianteTo> buscarTodos() {
        List<Estudiante> estudiantes = this.iEstudianteRepository.buscarTodos();
        List<EstudianteTo> estudiantesTo = estudiantes.stream().map(this.mapTo).toList();
        return estudiantesTo;
    }

    @Override
    public List<EstudianteTo> buscarPorApellido(String apellido) {
        List<Estudiante> estudiantes = this.iEstudianteRepository.buscarPorApellido(apellido);
        List<EstudianteTo> estudiantesTo = estudiantes.stream().map(this.mapTo).toList();
        return estudiantesTo;
    }

    @Override
    public List<EstudianteTo> buscarPorApellidoyEdad(String apellido, Integer edad) {
        List<Estudiante> estudiantes = this.iEstudianteRepository.buscarPorApellidoyEdad(apellido, edad);
        List<EstudianteTo> estudiantesTo = estudiantes.stream().map(this.mapTo).toList();
        return estudiantesTo;
    }

 
}

package uce.edu.web.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import uce.edu.web.api.repository.IPersonaRepository;
import uce.edu.web.api.repository.modelo.Persona;
import uce.edu.web.api.service.to.PersonaTo;


@ApplicationScoped
public class PersonaServiceImpl implements IPersonaService {
    
    @Inject
    private IPersonaRepository iPersonaRepository;

    private Function<Persona, PersonaTo> mapTo = p -> {
        PersonaTo pTo =new PersonaTo(p.getId(), p.getNombre(), p.getApellido(), p.getFechaNacimiento());  
        return pTo;  
    };

    
    private Function<PersonaTo, Persona> mapPersona = p -> {
        Persona pTo =new Persona(p.getId(), p.getNombre(), p.getApellido(), p.getFechaNacimiento());  
        return pTo;  
    };


    @Override
    public PersonaTo buscarPorId(Integer id) {
        try {
            this.iPersonaRepository.buscarPorId(id);
        } catch (Exception e) {
            PersonaTo p = new PersonaTo();
            System.out.println("Error: " + e.getMessage());
        }
        return null;
 
    }

    @Override
    public void guardar(PersonaTo persona) {
        this.iPersonaRepository.insertar(this.mapPersona.apply(persona));

    }

    @Override
    public void actualizar(PersonaTo persona) {
        Persona per = this.mapPersona.apply(persona);
        this.iPersonaRepository.actualizar(per);
    }

    @Override
    public void borrar(Integer id) {
        this.iPersonaRepository.eliminar(id);

    }

    @Override
    public List<PersonaTo> buscarTodos() {
        List<Persona> personas = this.iPersonaRepository.buscarTodos();
        List<PersonaTo> personasTo = new ArrayList<>();
        for (Persona persona : personas) {
            personasTo.add(this.mapTo.apply(persona));
        }
        //return personas.stream().map(this.mapTo).toList();
        return personasTo;
    }

    @Override
    public List<PersonaTo> buscarPorNombre(String nombre) {
        List<Persona> personas = this.iPersonaRepository.buscarPorNombre(nombre);
        return personas.stream().map(this.mapTo).toList();
    }

    @Override
    public List<PersonaTo> buscarPorNombreyApellido(String nombre, String apellido) {
       List<Persona> personas = this.iPersonaRepository.buscarPorNombreyApellido(nombre, apellido);
       List<PersonaTo> personasTo = new ArrayList<>();
       for (Persona persona : personas) {
            personasTo.add(this.mapTo.apply(persona));
        }
       return personasTo;
    }

}

package uce.edu.web.api.controller;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.criteria.CriteriaBuilder.In;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import uce.edu.web.api.service.IPersonaService;
import uce.edu.web.api.service.to.PersonaTo;

@Path("/personas")
public class PersonaController {

    @Inject
    private IPersonaService personaService;

    @Path("/guardar")
    public void guardarPersona(PersonaTo personaTo) {
        this.personaService.guardar(personaTo);
    
    }
    @Path("/actualizar")
    public void actualizarPersona(PersonaTo personaTo) {
        this.personaService.actualizar(personaTo);
    }
    @Path("/borrar")
    public void borrarPersona(Integer id) {
        this.personaService.borrar(id);
    }
    @GET
    @Path("/buscarPorId")
    public Response buscarPorId() {
        Integer id = 1;
        PersonaTo p= this.personaService.buscarPorId(id);
        System.out.println(p.getNombre());
        return Response.ok(this.personaService.buscarPorId(id)).build();
    }
		
}

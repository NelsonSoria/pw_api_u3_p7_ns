package uce.edu.web.api.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import uce.edu.web.api.service.IPersonaService;
import uce.edu.web.api.service.to.PersonaTo;

@Path("/personas")
public class PersonaController {

    @Inject
    private IPersonaService personaService;

    @POST
    @Path("/guardar")
    public void guardarPersona(PersonaTo personaTo) {
        this.personaService.guardar(personaTo);

    }

    @PUT
    @Path("/actualizar")
    public void actualizarPersona(PersonaTo personaTo) {
        this.personaService.actualizar(personaTo);
    }

    @DELETE
    @Path("/borrar")
    public void borrarPersona(Integer id) {
        this.personaService.borrar(id);
    }

    @GET
    @Path("/buscarPorId")
    public PersonaTo buscarPorId() {
        Integer id = 1;
        PersonaTo p = this.personaService.buscarPorId(id);

        // return Response.ok(this.personaService.buscarPorId(id)).build();
        return p;
    }

    @PATCH
    @Path("/actualizar/parcial") // Request body, solo puede haber uno, si quiero tener varios debo tener un
                                 // objeto wraper
    // el retorno de la capacidad se pone la respuesta del body del response
    public void actualizarParcial(PersonaTo persona) {
        PersonaTo tmp = this.personaService.buscarPorId(persona.getId());
        tmp.setNombre(persona.getNombre());
        this.personaService.actualizar(tmp);
    }

}

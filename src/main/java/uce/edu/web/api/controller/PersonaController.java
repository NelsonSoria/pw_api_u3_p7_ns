package uce.edu.web.api.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import uce.edu.web.api.service.IPersonaService;
import uce.edu.web.api.service.to.PersonaTo;

@Path("/personas")
public class PersonaController {

    @Inject
    private IPersonaService personaService;

    @POST
    @Path("") 
    public void guardarPersona(PersonaTo personaTo) {
        this.personaService.guardar(personaTo);

    }

    @PUT
    @Path("/{id}") 
    public void actualizarPersona(PersonaTo personaTo, @PathParam("id") Integer id) {
        personaTo.setId(id);
        this.personaService.actualizar(personaTo);
    }

    @DELETE
    @Path("/{id}") 
    public void borrarPersona( @PathParam("id") Integer id) {
        this.personaService.borrar(id);
    }

    //recibir ese valor como un argumento
    //A lo que va ahcer un path variable ponemos la anotacion @PathParam
    @GET
    @Path("/{id}") 
    public PersonaTo buscarPorId(@PathParam("id") Integer id) {
        PersonaTo p = this.personaService.buscarPorId(id);
        // return Response.ok(this.personaService.buscarPorId(id)).build();
        return p;
    }

    @PATCH
    @Path("/{id}/nuevo/{cedula}") // Request body, solo puede haber uno, si quiero tener varios debo tener un
                                 // objeto wraper
    // el retorno de la capacidad se pone la respuesta del body del response
    public void actualizarParcial(PersonaTo persona, @PathParam("id") Integer id, @PathParam("cedula") String cedula) {
        System.out.println(cedula);
        PersonaTo tmp = this.personaService.buscarPorId(id);
        tmp.setNombre(persona.getNombre());
        this.personaService.actualizar(tmp);
    }

}

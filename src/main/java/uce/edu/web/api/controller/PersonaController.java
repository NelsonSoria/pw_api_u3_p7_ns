package uce.edu.web.api.controller;

import java.util.List;


import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import uce.edu.web.api.service.IPersonaService;
import uce.edu.web.api.service.to.PersonaTo;

@Path("/personas")
public class PersonaController {

    @Inject
    private IPersonaService personaService;

    @POST
    @Path("")
    @Consumes(MediaType.APPLICATION_XML)
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
    public void borrarPersona(@PathParam("id") Integer id) {
        this.personaService.borrar(id);
    }

    // recibir ese valor como un argumento
    // A lo que va ahcer un path variable ponemos la anotacion @PathParam
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarPorId(@PathParam("id") Integer id) {
        return Response.status(240).header("Mensaje", "Persona Creada pero en proceso de validacion...")
                .header("Valor1", 500).entity(this.personaService.buscarPorId(id)).build();
        // PersonaTo p = this.personaService.buscarPorId(id);
        // return Response.ok(this.personaService.buscarPorId(id)).build();
    }

    @PATCH
    @Path("/{id}") // Request body, solo puede haber uno, si quiero tener varios debo tener un
                                  // objeto wraper
    // el retorno de la capacidad se pone la respuesta del body del response
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public PersonaTo actualizarParcial(PersonaTo persona, @PathParam("id") Integer id) {
        PersonaTo tmp = this.personaService.buscarPorId(id);
        tmp.setNombre(persona.getNombre());
        this.personaService.actualizar(tmp);
        return tmp;
    }

    @GET
    @Path("")
    public List<PersonaTo> buscarTodos() {
        return this.personaService.buscarTodos();
    }

    @GET
    @Path("/porNombre")
    public List<PersonaTo> buscarPorNombre(@QueryParam("nombre") String nombre) {
        return this.personaService.buscarPorNombre(nombre);
    }

    @GET
    @Path("/porNombreyApellido")
    public List<PersonaTo> buscarPorNombreyApellido(@QueryParam("nombre") String nombre,
            @QueryParam("apellido") String apellido) {
        return this.personaService.buscarPorNombreyApellido(nombre, apellido);
    }
}

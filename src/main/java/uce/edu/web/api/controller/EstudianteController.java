package uce.edu.web.api.controller;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import uce.edu.web.api.service.IEstudianteService;
import uce.edu.web.api.service.to.EstudianteTo;

@Path("/estudiantes")
public class EstudianteController {
    @Inject
    private IEstudianteService estudianteService;

    @GET
    @Path("/{id}")
    public EstudianteTo buscarPorId(@PathParam("id") Integer id) {
        EstudianteTo p = this.estudianteService.buscarPorId(id);
        return p;

    }

    @POST
    @Path("")
    public void guardar(EstudianteTo estudiante) {
        this.estudianteService.guardar(estudiante);

    }

    @PUT
    @Path("/{id}")
    public void actualizar(EstudianteTo estudianteTo, @PathParam("id") Integer id) {
        estudianteTo.setId(id);
        this.estudianteService.actualizar(estudianteTo);

    }

    @DELETE
    @Path("/{id}")
    public void borrar(@PathParam("id") Integer id) {
        this.estudianteService.borrar(id);

    }

    @PATCH
    @Path("/{id}/nuevo/{cedula}")
    public void actualizarParcial(EstudianteTo estudiante, @PathParam("id") Integer id,
            @PathParam("cedula") String cedula) {
        EstudianteTo tmp = this.estudianteService.buscarPorId(estudiante.getId());
        tmp.setNombre(estudiante.getNombre());
        tmp.setCedula(cedula);
        this.estudianteService.actualizar(tmp);
    }

    @GET
    @Path("")
    public List<EstudianteTo> buscarTodos() {
        return this.estudianteService.buscarTodos();
    }

    @GET
    @Path("/porApellido")
    public List<EstudianteTo> buscarPorApellido(@QueryParam("apellido") String apellido) {
        return this.estudianteService.buscarPorApellido(apellido);
    }

    @GET
    @Path("/porApellidoEdad")
    // http://localhost:8080/matriculaAPI/v1.1/estudiantes/porApellidoCedula?apellido=Gonzalez&cedula=123456
    public List<EstudianteTo> buscarPorApellidoyEdad(@QueryParam("apellido") String apellido,
            @QueryParam("edad") Integer edad) {
        return this.estudianteService.buscarPorApellidoyEdad(apellido, edad);
    }
}

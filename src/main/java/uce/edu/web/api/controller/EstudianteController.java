package uce.edu.web.api.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import uce.edu.web.api.service.IEstudianteService;
import uce.edu.web.api.service.to.EstudianteTo;

@Path("/estudiantes")
public class EstudianteController {
    @Inject
    private IEstudianteService estudianteService;

    @GET
    @Path("/buscarPorId")
    public EstudianteTo buscarPorId() {
        Integer id = 1;
        EstudianteTo p = this.estudianteService.buscarPorId(id);
        return p;

    }

    @POST
    @Path("/guardar")
    public void guardar(EstudianteTo estudiante) {
        this.estudianteService.guardar(estudiante);

    }

    @PUT
    @Path("/actualizar")
    public void actualizar(EstudianteTo estudiante) {
        this.estudianteService.actualizar(estudiante);

    }

    @DELETE
    @Path("/borrar")
    public void borrar() {
        Integer id = 1;
        this.estudianteService.borrar(id);

    }

    @PATCH
    @Path("/actualizar/parcial")
    public void actualizarParcial(EstudianteTo estudiante) {
        EstudianteTo tmp = this.estudianteService.buscarPorId(estudiante.getId());
        tmp.setNombre(estudiante.getNombre());
        this.estudianteService.actualizar(tmp);
    }

}

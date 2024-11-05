package com.example.rest;

import com.example.controls.dao.services.GestorProyectos;
import com.example.models.GeneracionEnergia;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

// Definir la ruta base para los endpoints de proyectos
@Path("proyectos")
public class MyResource {
    private GestorProyectos gestorProyectos = new GestorProyectos(); // Inicializar el gestor de proyectos

    // Endpoint para agregar un nuevo proyecto (HTTP POST)
    @POST
    @Consumes(MediaType.APPLICATION_JSON) // Especifica que el contenido de la solicitud es JSON
    @Produces(MediaType.APPLICATION_JSON) // Especifica que la respuesta será en formato JSON
    public Response agregarProyecto(GeneracionEnergia proyecto) {
        gestorProyectos.agregarProyecto(proyecto); // Agrega el nuevo proyecto usando el gestor de proyectos
        return Response.status(Response.Status.CREATED).entity(proyecto).build(); // Devuelve una respuesta HTTP 201 Created con el proyecto agregado
    }

    // Endpoint para obtener todos los proyectos (HTTP GET)
    @GET
    @Produces(MediaType.APPLICATION_JSON) // Especifica que la respuesta será en formato JSON
    public Response obtenerProyectos() {
        GeneracionEnergia[] proyectos = gestorProyectos.obtenerTodosLosProyectos(); // Obtiene todos los proyectos usando el gestor de proyectos
        return Response.ok(proyectos).build(); // Devuelve una respuesta HTTP 200 OK con la lista de proyectos
    }
}

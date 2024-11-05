package com.example.rest;

// Importaciones necesarias para las anotaciones y tipos de datos de JAX-RS
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

// Importaciones de clases de otros paquetes del proyecto
import com.example.controls.dao.services.GestorProyectos;
import com.example.models.GeneracionEnergia;

/**
 * Clase MyResource que define los endpoints para la API REST.
 * La clase estará disponible en la ruta "proyectos".
 */
@Path("proyectos")
public class MyResource {

    // Instancia de la clase GestorProyectos que maneja la lógica de los proyectos.
    private GestorProyectos gestorProyectos = new GestorProyectos();

    // Método GET para obtener todos los proyectos.
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public GeneracionEnergia[] getAllProyectos() {
        return gestorProyectos.obtenerTodosLosProyectos(); // Retorna el array de proyectos
    }

    // Método POST para crear un nuevo proyecto.
    @POST
    @Consumes(MediaType.APPLICATION_JSON) // Define que el método consume datos en formato JSON.
    @Produces(MediaType.APPLICATION_JSON) // Define que el método produce datos en formato JSON.
    public GeneracionEnergia createProyecto(GeneracionEnergia proyecto) {
        // Añade el nuevo proyecto a la lista de proyectos.
        gestorProyectos.agregarProyecto(proyecto);
        // Devuelve el proyecto recién creado.
        return proyecto; // Retorna el proyecto creado
    }
}

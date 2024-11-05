package com.example.rest;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.grizzly.http.server.HttpServer;
import com.example.models.GeneracionEnergia;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Date;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MyResourceTest {

    private HttpServer server;
    private WebTarget target;

    @Before
    public void setUp() throws Exception {
        // Iniciar el servidor
        server = Main.startServer();
        // Crear el cliente
        Client c = ClientBuilder.newClient();
        target = c.target(Main.BASE_URI);
    }

    @After
    public void tearDown() throws Exception {
        server.stop();
    }

    @Test
    public void testGetAllProyectos() {
        // Llamar al endpoint GET /proyectos
        Response response = target.path("proyectos").request().get();
        assertEquals(200, response.getStatus());  // Verificar que el estado es 200 OK
        
        List<?> proyectos = response.readEntity(List.class);
        assertNotNull(proyectos);  // Asegurar que la lista de proyectos no es nula
    }

    @Test
    public void testCreateProyecto() {
        // Crear un objeto ProyectoGeneracionEnergia de prueba
        // Suponiendo valores de ejemplo para todos los parámetros
        GeneracionEnergia proyecto = new GeneracionEnergia(
            "Proyecto Solar",          // nombre
            500000.0,                  // inversion
            new Date(),                // fechaInicioConstruccion
            new Date(),                // fechaFinConstruccion
            25,                        // tiempoVida
            Arrays.asList("Inversionista1"),  // inversionistas
            1000.0,                    // electricidadGeneradaPorDia
            "Ubicacion Ejemplo",       // ubicacion
            "Solar"                    // tipoEnergia
        );

        
        // Llamar al endpoint POST /proyectos
        Response response = target.path("proyectos")
                                  .request(MediaType.APPLICATION_JSON)
                                  .post(Entity.entity(proyecto, MediaType.APPLICATION_JSON));

        assertEquals(200, response.getStatus());  // Verificar que el estado es 200 OK
        GeneracionEnergia responseProyecto = response.readEntity(GeneracionEnergia.class);
        assertEquals("Proyecto Solar", responseProyecto.getNombre());  // Verificar el nombre del proyecto
    }
}

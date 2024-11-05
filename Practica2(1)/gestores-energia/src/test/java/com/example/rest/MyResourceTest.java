package com.example.rest;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.example.models.GeneracionEnergia;
import java.util.Arrays;
import java.util.Date;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MyResourceTest {

    private HttpServer server;
    private WebTarget target;

    @Before
    public void setUp() throws Exception {
        // Iniciar el servidor
        server = startServer();
        // Crear el cliente
        Client client = ClientBuilder.newClient();
        target = client.target(Main.BASE_URI);
    }

    @After
    public void tearDown() throws Exception {
        server.stop();
    }

    private HttpServer startServer() {
        final ResourceConfig rc = new ResourceConfig().packages("com.example.rest");
        return GrizzlyHttpServerFactory.createHttpServer(Main.BASE_URI, rc);
    }

    @Test
    public void testGetAllProyectos() {
        // Llamar al endpoint GET /proyectos
        Response response = target.path("proyectos").request().get();
        assertEquals(200, response.getStatus());  // Verificar que el estado es 200 OK

        GeneracionEnergia[] proyectos = response.readEntity(GeneracionEnergia[].class);
        assertNotNull(proyectos);  // Asegurar que el array de proyectos no es nulo
        // Asegurar que la lista de proyectos esté vacía inicialmente
        assertEquals(0, proyectos.length);
    }

    @Test
    public void testCreateProyecto() {
        // Crear un objeto GeneracionEnergia de prueba
        GeneracionEnergia proyecto = new GeneracionEnergia(
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

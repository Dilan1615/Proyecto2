package com.example.rest;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;

/**
 * Clase principal para iniciar el servidor HTTP utilizando Grizzly y Jersey.
 */
public class Main {
    // URL base para la aplicación
    public static final String BASE_URI = "http://localhost:8081/myapp/";

    /**
     * Método para iniciar el servidor HTTP.
     * 
     * @return instancia del servidor HttpServer.
     */
    public static HttpServer startServer() {
        // Configuración de los recursos para la aplicación
        final ResourceConfig rc = new ResourceConfig().packages("com.example.rest");
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }

    /**
     * Método principal para ejecutar la aplicación.
     * 
     * @param args argumentos de línea de comandos.
     * @throws IOException si hay un problema al leer la entrada.
     */
    public static void main(String[] args) throws IOException {
        // Inicia el servidor
        final HttpServer server = startServer();
        System.out.println(String.format("Jersey app started with WADL available at "
                + "%sapplication.wadl\nHit enter to stop it...", BASE_URI));

        // Espera a que el usuario presione Enter para detener el servidor
        System.in.read();
        server.shutdownNow(); // Detiene el servidor de manera segura
    }
}


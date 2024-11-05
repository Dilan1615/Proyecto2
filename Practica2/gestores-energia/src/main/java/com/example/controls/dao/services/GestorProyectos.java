package com.example.controls.dao.services;

import com.example.models.GeneracionEnergia;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.File;
import java.io.IOException;

public class GestorProyectos {
    private ProyectoLista proyectos; // Lista para almacenar proyectos
    private static final String CARPETA_PROYECTOS = "data"; // Carpeta donde se guardarán los archivos JSON
    private ObjectMapper objectMapper; // Objeto para manejar la conversión a JSON

    // Constructor
    public GestorProyectos() {
        this.proyectos = new ProyectoLista();
        this.objectMapper = new ObjectMapper(); // Inicializa ObjectMapper
        this.objectMapper.enable(SerializationFeature.INDENT_OUTPUT); // Para que la salida JSON sea más legible
        cargarProyectos(); // Carga los proyectos desde la carpeta 'data'
    }

    // Método para agregar un nuevo proyecto
    public void agregarProyecto(GeneracionEnergia proyecto) {
        proyectos.agregar(proyecto); // Añade el proyecto a la lista
        guardarProyecto(proyecto); // Guarda el proyecto en un archivo JSON
    }

    // Método para obtener todos los proyectos
    public GeneracionEnergia[] obtenerTodosLosProyectos() {
        return proyectos.obtenerTodos(); // Devuelve todos los proyectos en forma de array
    }

    // Método privado para guardar un proyecto en un archivo JSON
    private void guardarProyecto(GeneracionEnergia proyecto) {
        try {
            File carpeta = new File(CARPETA_PROYECTOS);
            if (!carpeta.exists()) {
                carpeta.mkdir(); // Crea la carpeta si no existe
            }
            String nombreArchivo = CARPETA_PROYECTOS + "/" + proyecto.getNombre().replaceAll(" ", "_") + ".json";
            objectMapper.writeValue(new File(nombreArchivo), proyecto); // Escribe el proyecto en un archivo JSON
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Cargar todos los proyectos desde la carpeta 'data'
    private void cargarProyectos() {
        try {
            File carpeta = new File(CARPETA_PROYECTOS);
            if (carpeta.exists()) {
                File[] archivos = carpeta.listFiles((dir, name) -> name.endsWith(".json"));
                if (archivos != null) {
                    for (File archivo : archivos) {
                        System.out.println("Cargando archivo: " + archivo.getName());
                        GeneracionEnergia proyecto = objectMapper.readValue(archivo, GeneracionEnergia.class);
                        proyectos.agregar(proyecto); // Añade cada proyecto a la lista
                        System.out.println("Proyecto cargado: " + proyecto.getNombre());
                    }
                } else {
                    System.out.println("No se encontraron archivos JSON en la carpeta.");
                }
            } else {
                System.out.println("La carpeta 'data' no existe.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

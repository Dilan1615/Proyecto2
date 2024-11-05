package com.example.controls.dao.services;

import com.example.models.GeneracionEnergia;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.File;
import java.io.IOException;

public class GestorProyectos {
    private ProyectoLista proyectos;
    private static final String CARPETA_PROYECTOS = "data";
    private ObjectMapper objectMapper;

    public GestorProyectos() {
        this.proyectos = new ProyectoLista();
        this.objectMapper = new ObjectMapper();
        this.objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        cargarProyectos();
    }

    public void agregarProyecto(GeneracionEnergia proyecto) {
        proyectos.agregar(proyecto);
        guardarProyecto(proyecto);
    }

    public GeneracionEnergia[] obtenerTodosLosProyectos() {
        return proyectos.obtenerTodos();
    }

    private void guardarProyecto(GeneracionEnergia proyecto) {
        try {
            File carpeta = new File(CARPETA_PROYECTOS);
            if (!carpeta.exists()) {
                carpeta.mkdir();
            }
            String nombreArchivo = CARPETA_PROYECTOS + "/" + proyecto.getNombre().replaceAll(" ", "_") + ".json";
            objectMapper.writeValue(new File(nombreArchivo), proyecto);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void cargarProyectos() {
        try {
            File carpeta = new File(CARPETA_PROYECTOS);
            if (carpeta.exists()) {
                File[] archivos = carpeta.listFiles((dir, name) -> name.endsWith(".json"));
                if (archivos != null) {
                    for (File archivo : archivos) {
                        System.out.println("Cargando archivo: " + archivo.getName());
                        GeneracionEnergia proyecto = objectMapper.readValue(archivo, GeneracionEnergia.class);
                        proyectos.agregar(proyecto);
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

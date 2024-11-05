package com.example.controls.dao.services;

import com.example.models.GeneracionEnergia;

public class ProyectoLista {
    private GeneracionEnergia[] proyectos;
    private int contador;

    public ProyectoLista() {
        proyectos = new GeneracionEnergia[99]; // 
        contador = 0;
    }

    public void agregar(GeneracionEnergia proyecto) {
        if (contador == proyectos.length) {            
            GeneracionEnergia[] nuevosProyectos = new GeneracionEnergia[proyectos.length * 2];
            System.arraycopy(proyectos, 0, nuevosProyectos, 0, proyectos.length);
            proyectos = nuevosProyectos;
        }
        proyectos[contador++] = proyecto; // Agregar el nuevo proyecto
    }

    public GeneracionEnergia[] obtenerTodos() {
        GeneracionEnergia[] proyectosActivos = new GeneracionEnergia[contador];
        System.arraycopy(proyectos, 0, proyectosActivos, 0, contador);
        return proyectosActivos; // Retornar solo los proyectos activos
    }
}

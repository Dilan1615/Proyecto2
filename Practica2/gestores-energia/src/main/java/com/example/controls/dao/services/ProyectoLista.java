package com.example.controls.dao.services;

import com.example.models.GeneracionEnergia;

public class ProyectoLista {
    private ProyectoNodo cabeza; // Nodo inicial (cabeza) de la lista enlazada

    public ProyectoLista() {
        this.cabeza = null; // Inicializa la lista vacía
    }

    // Método para agregar un proyecto al final de la lista
    public void agregar(GeneracionEnergia proyecto) {
        ProyectoNodo nuevoNodo = new ProyectoNodo(proyecto); // Crea un nuevo nodo con el proyecto
        if (cabeza == null) { // Si la lista está vacía, el nuevo nodo es la cabeza
            cabeza = nuevoNodo;
        } else { // De lo contrario, recorre la lista hasta el último nodo y agrega el nuevo nodo
            ProyectoNodo actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
    }

    // Método para obtener todos los proyectos en un arreglo
    public GeneracionEnergia[] obtenerTodos() {
        int tamaño = contarNodos(); // Obtén el tamaño de la lista
        GeneracionEnergia[] proyectos = new GeneracionEnergia[tamaño]; // Crea un arreglo para almacenar los proyectos
        
        ProyectoNodo actual = cabeza; // Empieza desde la cabeza de la lista
        int index = 0;
        while (actual != null) { // Recorre la lista y añade cada proyecto al arreglo
            proyectos[index++] = actual.proyecto;
            actual = actual.siguiente;
        }
        
        return proyectos; // Devuelve el arreglo con todos los proyectos
    }

    // Método auxiliar para contar los nodos en la lista
    private int contarNodos() {
        int contador = 0;
        ProyectoNodo actual = cabeza; // Empieza desde la cabeza de la lista
        while (actual != null) { // Recorre la lista y cuenta cada nodo
            contador++;
            actual = actual.siguiente;
        }
        return contador; // Devuelve el número total de nodos
    }
    
    // Clase interna para los nodos de la lista
    private static class ProyectoNodo {
        private GeneracionEnergia proyecto; // Proyecto contenido en el nodo
        private ProyectoNodo siguiente; // Referencia al siguiente nodo en la lista

        public ProyectoNodo(GeneracionEnergia proyecto) {
            this.proyecto = proyecto; // Inicializa el nodo con un proyecto
            this.siguiente = null; // El siguiente nodo es null por defecto
        }
    }
}

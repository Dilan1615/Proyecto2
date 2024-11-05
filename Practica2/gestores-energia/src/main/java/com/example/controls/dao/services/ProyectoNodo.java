package com.example.controls.dao.services;

import com.example.models.GeneracionEnergia;

public class ProyectoNodo {
    public GeneracionEnergia proyecto; // Proyecto contenido en el nodo
    public ProyectoNodo siguiente; // Referencia al siguiente nodo en la lista enlazada

    // Constructor
    public ProyectoNodo(GeneracionEnergia proyecto) {
        this.proyecto = proyecto; // Inicializa el nodo con un proyecto
        this.siguiente = null; // El siguiente nodo es null por defecto
    }
}

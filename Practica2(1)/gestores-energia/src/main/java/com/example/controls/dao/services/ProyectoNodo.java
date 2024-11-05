package com.example.controls.dao.services;

import com.example.models.GeneracionEnergia;

public class ProyectoNodo {
    public GeneracionEnergia proyecto;
    public ProyectoNodo siguiente;

    public ProyectoNodo(GeneracionEnergia proyecto) {
        this.proyecto = proyecto;
        this.siguiente = null;
    }
}

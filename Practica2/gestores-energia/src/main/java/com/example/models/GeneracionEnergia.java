package com.example.models;

import java.util.Date;
import java.util.List;

public class GeneracionEnergia {
    private String nombre;
    private double inversion;
    private Date fechaInicioConstruccion;
    private Date fechaFinConstruccion;
    private int tiempoVida;
    private List<String> inversionistas;
    private double electricidadGeneradaPorDia;
    private String ubicacion;
    private String tipoEnergia;

    public GeneracionEnergia() {

    }

    public GeneracionEnergia(String nombre, double inversion, Date fechaInicioConstruccion, Date fechaFinConstruccion, int tiempoVida, List<String> inversionistas,
                             double electricidadGeneradaPorDia, String ubicacion, String tipoEnergia) {
        this.nombre = nombre;
        this.inversion = inversion;
        this.fechaInicioConstruccion = fechaInicioConstruccion;
        this.fechaFinConstruccion = fechaFinConstruccion;
        this.tiempoVida = tiempoVida;
        this.inversionistas = inversionistas;
        this.electricidadGeneradaPorDia = electricidadGeneradaPorDia;
        this.ubicacion = ubicacion;
        this.tipoEnergia = tipoEnergia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getInversion() {
        return inversion;
    }

    public void setInversion(double inversion) {
        this.inversion = inversion;
    }

    public Date getFechaInicioConstruccion() {
        return fechaInicioConstruccion;
    }

    public void setFechaInicioConstruccion(Date fechaInicioConstruccion) {
        this.fechaInicioConstruccion = fechaInicioConstruccion;
    }

    public Date getFechaFinConstruccion() {
        return fechaFinConstruccion;
    }

    public void setFechaFinConstruccion(Date fechaFinConstruccion) {
        this.fechaFinConstruccion = fechaFinConstruccion;
    }

    public int getTiempoVida() {
        return tiempoVida;
    }

    public void setTiempoVida(int tiempoVida) {
        this.tiempoVida = tiempoVida;
    }

    public List<String> getInversionistas() {
        return inversionistas;
    }

    public void setInversionistas(List<String> inversionistas) {
        this.inversionistas = inversionistas;
    }

    public double getElectricidadGeneradaPorDia() {
        return electricidadGeneradaPorDia;
    }

    public void setElectricidadGeneradaPorDia(double electricidadGeneradaPorDia) {
        this.electricidadGeneradaPorDia = electricidadGeneradaPorDia;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getTipoEnergia() {
        return tipoEnergia;
    }

    public void setTipoEnergia(String tipoEnergia) {
        this.tipoEnergia = tipoEnergia;
    }

    public String mostrarInformacion() {
        return "Nombre: " + nombre + "\n" +
                "Inversión: " + inversion + "\n" +
                "Fecha de Inicio: " + fechaInicioConstruccion + "\n" +
                "Fecha de Fin: " + fechaFinConstruccion + "\n" +
                "Tiempo de Vida: " + tiempoVida + " años\n" +
                "Inversionistas: " + String.join(", ", inversionistas) + "\n" +
                "Electricidad Generada por Día: " + electricidadGeneradaPorDia + " kWh\n" +
                "Ubicación: " + ubicacion + "\n" +
                "Tipo de Energía: " + tipoEnergia;
    }
}

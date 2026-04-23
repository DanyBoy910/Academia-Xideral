package Semana_1.Ejercicio6.Modelos;

import Semana_1.Ejercicio6.Servicios.Arrancable;

public abstract class Vehiculo implements Arrancable {
    protected String marca;
    protected String modelo;
    protected int anio;

    public Vehiculo(String marca, String modelo, int anio) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
    }

    public abstract String tipoVehiculo();

    public String info() {
        return tipoVehiculo() + ": " + marca + " "
                + modelo + " (" + anio + ")";
    }
}
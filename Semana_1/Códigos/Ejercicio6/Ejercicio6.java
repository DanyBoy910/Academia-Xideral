package Semana_1.Ejercicio6;
/*
Daniel Rodríguez Orozco 22/04/2026
* Ejercicio 6: Herencia de Vehículos
Objetivo
Diseñar una jerarquía de clases con clase abstracta, interfaz y polimorfismo.

Requisitos
Interfaz Arrancable con arrancar() y detener().
Clase abstracta Vehiculo implements Arrancable: atributos marca, modelo, anio; método abstracto tipoVehiculo(); método concreto info().
Clase Auto extends Vehiculo: atributo extra numPuertas.
Clase Moto extends Vehiculo: atributo extra cilindrada.
Clase VehiculoElectrico extends Auto: atributo autonomiaKm, sobrescribe arrancar().
En main: ArrayList<Vehiculo> con polimorfismo, iterar, contar por tipo.
* */
import Semana_1.Ejercicio6.Modelos.Auto;
import Semana_1.Ejercicio6.Modelos.Moto;
import Semana_1.Ejercicio6.Modelos.Vehiculo;
import Semana_1.Ejercicio6.Modelos.VehiculoElectrico;

import java.util.ArrayList;
public class Ejercicio6 {
    public static void main(String[] args) {
        ArrayList<Vehiculo> flota = new ArrayList<>();
        flota.add(new Auto("Toyota", "Corolla", 2024, 4));
        flota.add(new Moto("Honda", "CBR600", 2023, 600));
        flota.add(new VehiculoElectrico("Tesla", "Model 3",
                2025, 4, 580));
        flota.add(new Auto("Ford", "Mustang", 2024, 2));
        flota.add(new Moto("Yamaha", "MT-07", 2024, 689));

        System.out.println("=== Flota de Vehiculos ===");
        for (Vehiculo v : flota) {
            System.out.println(v);
            v.arrancar();
            v.detener();
            System.out.println();
        }

        // TODO: Contar por tipo usando instanceof
        int autos = 0, motos = 0, electricos = 0;
        for (Vehiculo v : flota) {
            if (v instanceof VehiculoElectrico) electricos++;
            else if (v instanceof Auto) autos++;
            else if (v instanceof Moto) motos++;
        }
        System.out.println("=== Resumen ===");
        System.out.println("Autos: " + autos);
        System.out.println("Motos: " + motos);
        System.out.println("Electricos: " + electricos);
    }

}

package Semana_1.Ejercicio5.Modelos;

import java.util.ArrayList;

public class Estudiante {
    private String nombre;
    private String matricula;
    private ArrayList<Double> calificaciones;

    // TODO: constructor
    public Estudiante(String nombre, String matricula) {
        this.nombre = nombre;
        this.matricula = matricula;
        this.calificaciones = new ArrayList<>();
    }

    // TODO: getters
    public String getNombre() { return nombre; }
    public String getMatricula() { return matricula; }

    // TODO: agregar calificacion con validacion
    public void agregarCalificacion(double cal) {
        if (cal >= 0 && cal <= 100) {  // validar rango 0-100
            calificaciones.add(cal);
        } else {
            System.out.println("Calificacion invalida: " + cal);
        }
    }

    // TODO: calcular promedio
    public double calcularPromedio() {
        if (calificaciones.isEmpty()) return 0.0;

        double suma = 0;
        // TODO: sumar todas las calificaciones
        for(double cal : calificaciones){
            suma += cal;
        }
        return suma / calificaciones.size();
    }

    @Override
    public String toString() {
        return String.format(
                "Estudiante{nombre='%s', matricula='%s', promedio=%.2f}",
                nombre, matricula, calcularPromedio());
    }
}
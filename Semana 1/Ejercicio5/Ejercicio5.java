package Semana_1.Ejercicio5;
/*
*Daniel Rodríguez Orozco 22/04/2026
* Ejercicio 5: Gestión de Estudiantes
Objetivo
Aplicar encapsulación con private + getters/setters y usar ArrayList.

Requisitos
Clase Estudiante con atributos privados: nombre, matricula, calificaciones (ArrayList<Double>).
Constructor, getters, y agregarCalificacion(double cal) con validación (0-100).
Método calcularPromedio().
Sobrescribir toString().
En main: crear estudiantes, agregar notas, encontrar el mejor promedio.
 */

import Semana_1.Ejercicio5.Modelos.Estudiante;

import java.util.ArrayList;
public class Ejercicio5 {

        public static void main(String[] args) {
            Estudiante e1 = new Estudiante("Ana Garcia", "A001");
            Estudiante e2 = new Estudiante("Carlos Lopez", "A002");
            Estudiante e3 = new Estudiante("Maria Torres", "A003");

            e1.agregarCalificacion(95);
            e1.agregarCalificacion(88);
            e1.agregarCalificacion(92);

            e2.agregarCalificacion(78);
            e2.agregarCalificacion(85);
            e2.agregarCalificacion(90);

            e3.agregarCalificacion(100);
            e3.agregarCalificacion(96);
            e3.agregarCalificacion(98);

            ArrayList<Estudiante> lista = new ArrayList<>();
            lista.add(e1); lista.add(e2); lista.add(e3);

            System.out.println("=== Lista de Estudiantes ===");
            Estudiante mejor = lista.get(0);
            for (Estudiante e : lista) {
                System.out.println(e);
                // TODO: actualizar 'mejor' si e tiene mayor promedio
                if(e.calcularPromedio() > mejor.calcularPromedio()) mejor = e;
            }
            System.out.println("\nMejor promedio: " + mejor.getNombre()
                    + " (" + String.format("%.2f", mejor.calcularPromedio())
                    + ")");
        }
    }
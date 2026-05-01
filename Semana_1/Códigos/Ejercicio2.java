package Semana_1;
/*
Daniel Rodríguez Orozco 21/04/2026

Ejercicio 2: Calculadora Básica
Objetivo
Practicar sobrecarga de métodos (method overloading).

Requisitos
Crear una clase Calculadora con métodos sumar sobrecargados:
sumar(int a, int b) — suma de dos enteros.
sumar(double a, double b) — suma de dos decimales.
sumar(int a, int b, int c) — suma de tres enteros.
sumar(int[] numeros) — suma de un array de enteros.
Demostrar cada sobrecarga en main.
*/

public class Ejercicio2 {

    // TODO: sumar dos enteros
    public static int sumar(int a, int b) {
        return a+b;
    }

    // TODO: sumar dos doubles
    public static double sumar(double a, double b) {
        return a+b;
    }

    // TODO: sumar tres enteros
    public static int sumar(int a, int b, int c) {
        return a+b+c;
    }

    // TODO: sumar un array de enteros
    public static int sumar(int[] numeros) {
        int total = 0;
        for(int num : numeros){
            total += num;
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println("2 + 3 = " + sumar(2, 3));
        System.out.println("2.5 + 3.7 = " + sumar(2.5, 3.7));
        System.out.println("1 + 2 + 3 = " + sumar(1, 2, 3));

        int[] nums = {10, 20, 30, 40};
        System.out.println("Array suma = " + sumar(nums));
    }
}

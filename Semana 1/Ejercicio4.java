package Semana_1;
/*
Daniel Rodríguez Orozco 22/04/2026
* Ejercicio 4: Manipulador de Strings
Objetivo
Dominar StringBuilder y métodos de String.

Requisitos
Crear invertir(String s) usando StringBuilder.
Crear esPalindromo(String s) ignorando mayúsculas y espacios.
Crear contarVocales(String s) que cuente a, e, i, o, u.
Crear construirPiramide(int niveles) con asteriscos usando StringBuilder.
* */
public class Ejercicio4 {
    public static String invertir(String s) {
        // TODO: usar StringBuilder.reverse()
        StringBuilder s0 = new StringBuilder(s);
        s0.reverse();
        return s0.toString();
    }

    public static boolean esPalindromo(String s) {
        // TODO: limpiar (toLowerCase, replaceAll espacios)
        s = s.toLowerCase();
        s = s.replace(" ","");
        // TODO: comparar con su version invertida
        return s.equals(invertir(s));
    }

    public static int contarVocales(String s) {
        int count = 0;
        String vocales = "aeiou";
        s = s.toLowerCase();
        // TODO: recorrer cada caracter, verificar si es vocal
        for(char a: vocales.toCharArray()){
            for(char p: s.toCharArray()){
                if(a == p) count++;
            }
        }
        return count;
    }

    public static String construirPiramide(int niveles) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= niveles; i++) {
            // TODO: agregar espacios (niveles - i)
            sb.repeat(" ",niveles-i);
            // TODO: agregar asteriscos (2*i - 1)
            sb.repeat("*",2*i - 1);
            // TODO: agregar salto de linea
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("Invertir 'Hola Mundo': "
                + invertir("Hola Mundo"));
        System.out.println("'Anita lava la tina' es palindromo: "
                + esPalindromo("Anita lava la tina"));
        System.out.println("Vocales en 'Murcielago': "
                + contarVocales("Murcielago"));
        System.out.println("Piramide de 5 niveles:");
        System.out.println(construirPiramide(5));
    }
}

package Semana_2;
/*
Daniel Rodríguez Orozco 27-04-2026
Ejercicio 2: Iterador con Inner Class — SimpleStack
Objetivo
Practicar clases anidadas (static nested e inner class) implementando un stack con iterador.

Requisitos
Crear clase genérica SimpleStack<T> que implemente Iterable<T>.
Crear static nested class Node<T> con campos data y next.
Implementar push(T), pop(), peek(), isEmpty() y size().
Crear inner class StackIterator que implemente Iterator<T> (recorrido LIFO).
pop() en stack vacío debe lanzar NoSuchElementException.
Demostrar uso con for-each (posible gracias a Iterable).
* */
import java.util.Iterator;
import java.util.NoSuchElementException;

class SimpleStack<T> implements Iterable<T> {

    // Static nested class: no necesita acceso a la instancia
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<T> top;
    private int size;

    public void push(T item) {
        // TODO: crear nuevo nodo que apunte al top actual
        Node<T> nuevo_nodo = new Node<>(item,top);
        // TODO: actualizar top y size
        top = nuevo_nodo;
        size++;
    }

    public T pop() {
        // TODO: si esta vacio lanzar NoSuchElementException
        if (isEmpty()) throw new NoSuchElementException("Stack vacio");
        // TODO: guardar dato del top, avanzar top, decrementar size
        T data = top.data;
        top = top.next;
        size --;
        return data;
    }

    public T peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack vacio");
        return top.data;
    }

    public boolean isEmpty() { return size == 0; }
    public int size() { return size; }

    // Inner class: necesita acceso al top del stack externo
    private class StackIterator implements Iterator<T> {
        private Node<T> current = top;  // TODO: iniciar en top

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            // TODO: guardar dato, avanzar current, retornar dato
            T data = current.data;
            current = current.next;
            return data;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Stack[");
        Node<T> current = top;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) sb.append(" -> ");
            current = current.next;
        }
        return sb.append("]").toString();
    }

}

public class Ejercicio2 {
    public static void main(String[] args) {
        SimpleStack<Integer> stack = new SimpleStack<>();

        System.out.println("=== Stack de Enteros ===");
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Despues de push 10, 20, 30: " + stack);
        System.out.println("Peek: " + stack.peek());
        System.out.println("Size: " + stack.size());

        System.out.print("Iterando (LIFO): ");
        for (Integer n : stack) {
            System.out.print(n + " ");
        }
        System.out.println();

        System.out.println("Pop: " + stack.pop());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Peek despues de pops: " + stack.peek());
        System.out.println("Size: " + stack.size());

        System.out.println("\n=== Stack de Strings ===");
        SimpleStack<String> palabras = new SimpleStack<>();
        palabras.push("Hola");
        palabras.push("Mundo");
        palabras.push("Java");

        System.out.print("For-each: ");
        for (String s : palabras) {
            System.out.print(s + " ");
        }
        System.out.println();

        System.out.println("\n=== Error: pop en stack vacio ===");
        SimpleStack<Integer> vacio = new SimpleStack<>();
        try {
            vacio.pop();
        } catch (NoSuchElementException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.uner.fcad.ed.edlineales;

import ar.edu.uner.fcad.ed.edlineales.colas.ColaPorEnlaces;
import ar.edu.uner.fcad.ed.edlineales.colas.ColaPorPosicion;
import ar.edu.uner.fcad.ed.edlineales.pilas.PilaPorEnlaces;
import ar.edu.uner.fcad.ed.edlineales.pilas.PilaPorPosicion;
import ar.edu.uner.fcad.ed.edlineales.iteradores.Iterador;
import javax.annotation.Generated;

/**
 *
 * @author nacho
 */
@Generated("ClienteEDLineales")
public class ClienteEDLineales {

    public static void testListaEnlazadaOrdenadaIterador() {
        try {
            ListaEnlazadaOrdenada<Integer> lista = new ListaEnlazadaOrdenada<>();
            lista.add(5);
            lista.add(4);
            lista.add(3);
            lista.add(2);
            lista.add(1);
            lista.add(6);

            System.out.println("Lista:" + lista);

            System.out.println("Lista - Utilizando iterador():");
            int i = 1;
            Iterador<Integer> iterador = lista.iterador();
            while (iterador.existeSiguiente()) {
                System.out.println("Posición " + i++ + ": " + iterador.siguiente());
            }
            
            for (int j = 0; j < lista.size(); j++) {
                System.out.println(lista.get(j));                
            }
        } catch (Exception ex) {
            System.err.println(ex.toString());
        }
    }

    public static void testListaEnlazadaOrdenada() {
        try {
            ListaEnlazadaOrdenada<Integer> lista = new ListaEnlazadaOrdenada();
            lista.add(5);
            lista.add(4);
            lista.add(3);
            lista.add(2);
            lista.add(1);
            lista.add(6);

            System.out.println("Lista completa: " + lista);
            lista.removeFirst();
            System.out.println("Lista (removeFirst()): " + lista);
            lista.removeLast();
            System.out.println("Lista (removeLast()): " + lista);
            lista.remove(Integer.valueOf(3));
            System.out.println("Lista (remove(3)): " + lista);
        } catch (Exception ex) {
            System.err.println(ex.toString());
        }
    }

    public static void testListaEnlazadaNoOrdenada() {
        try {
            ListaEnlazadaNoOrdenada<Integer> lista = new ListaEnlazadaNoOrdenada();
            lista.addToRear(5);
            lista.addToRear(4);
            lista.addToRear(3);
            lista.addToRear(2);
            lista.addToRear(1);
            lista.addAfter(Integer.valueOf(23), Integer.valueOf(3));

            System.out.println("Lista (completa): " + lista);
            lista.removeFirst();
            System.out.println("Lista (removeFirst()): " + lista);
            lista.removeLast();
            System.out.println("Lista (removeLast()): " + lista);
            lista.remove(Integer.valueOf(3));
            System.out.println("Lista (remove(3)): " + lista);
        } catch (Exception ex) {
            System.err.println(ex.toString());
        }
    }

    public static void testListaPorPosicionOrdenada() {
        try {
            ListaPorPosicionOrdenada<Integer> lista = new ListaPorPosicionOrdenada(Integer.class);
            lista.add(5);
            lista.add(4);
            lista.add(3);
            lista.add(2);
            lista.add(1);
            lista.add(6);

            System.out.println("Lista por posición (completa):" + lista);

            lista.removeFirst();
            System.out.println("Lista (removeFirst()): " + lista);

            lista.removeLast();
            System.out.println("Lista (removeLast(): " + lista);

            lista.remove(Integer.valueOf(5));
            System.out.println("Lista (remove(5): " + lista);
        } catch (Exception ex) {
            System.err.println(ex.toString());
        }
    }

    public static void testPilaPorEnlaces() {
        PilaPorEnlaces<Integer> pila = new PilaPorEnlaces();
        pila.push(1);
        pila.push(2);
        pila.push(3);
        pila.push(4);
        pila.push(5);

        System.out.println("Pila por Enlaces (completa): " + pila.toString());

        System.out.println("Pila (vaciado):");
        while (!pila.isEmpty()) {
            System.out.println(pila.top().toString());
            pila.pop();
        }

    }

    public static void testPilaPorPosicion() {
        PilaPorPosicion<Integer> pila = new PilaPorPosicion(Integer.class);
        pila.push(1);
        pila.push(2);
        pila.push(3);
        pila.push(4);
        pila.push(5);

        System.out.println("Pila por Posición (completa): " + pila);

        System.out.println("Pila (vaciado): ");
        while (!pila.isEmpty()) {
            System.out.println(pila.top().toString());
            pila.pop();
        }
    }

    public static void testColaPorEnlaces() {
        ColaPorEnlaces<Integer> cola = new ColaPorEnlaces();
        cola.enqueue(1);
        cola.enqueue(2);
        cola.enqueue(3);
        cola.enqueue(4);
        cola.enqueue(5);

        System.out.println("Cola por Enlaces (completa): " + cola);

        System.out.println("Cola. Vaciado de estructura: ");
        while (!cola.isEmpty()) {
            System.out.println(cola.getFront().toString());
            cola.dequeue();
        }

        System.out.println("cola.enqueue(20): ");
        cola.enqueue(20);
        System.out.println(cola.getFront().toString());
    }

    public static void testColaPorPosicion() {
        ColaPorPosicion<Integer> cola = new ColaPorPosicion(Integer.class);
        cola.enqueue(1);
        cola.enqueue(2);
        cola.enqueue(3);
        cola.enqueue(4);
        cola.enqueue(5);

        System.out.println("Cola por Posición: " + cola);

        System.out.println("Cola. Vaciado de estructura: ");
        while (!cola.isEmpty()) {
            System.out.println(cola.getFront().toString());
            cola.dequeue();
        }

        System.out.println("cola.enqueue(20): ");
        cola.enqueue(20);
        System.out.println(cola.getFront().toString());
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Lista Por Posición Ordenada");
        System.out.println("====================================");
        testListaPorPosicionOrdenada();

        System.out.println("Lista Enlazada No Ordenada");
        System.out.println("====================================");
        testListaEnlazadaNoOrdenada();

        System.out.println("Lista Enlazada Ordenada");
        System.out.println("====================================");
        testListaEnlazadaOrdenada();

        System.out.println("Pila - Implementación por enlaces");
        System.out.println("====================================");
        testPilaPorEnlaces();
        
        System.out.println("Pila - Implementación por posición");
        System.out.println("====================================");
        testPilaPorPosicion();
        
        System.out.println("Cola - Implementación por enlaces");
        System.out.println("====================================");
        testColaPorEnlaces();
        
        System.out.println("Cola - Implementación por posición");
        System.out.println("====================================");
        testColaPorPosicion();
        
        System.out.println("Lista Enlazada Ordenada");
        System.out.println("====================================");
        testListaEnlazadaOrdenadaIterador();
        
        System.out.println("Iterador - Lista Enlazada Ordenada");
        System.out.println("====================================");
        testListaEnlazadaOrdenadaIterador();
    }

}

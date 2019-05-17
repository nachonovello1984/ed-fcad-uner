/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.uner.fcad.ed.arbolesbinariosyheaps;

import ar.edu.uner.fcad.ed.edlineales.Iterador;

/**
 *
 * @author nacho
 */
public class ClienteArbolBinarioHeap {

    private static void pruebaHeap() {
        try {

            //Heap
            System.out.println("Heap");
            System.out.println("===========");
            Heap<Integer> heap = new Heap<>();
            heap.addElement(3);
            System.out.println("Insertar (3): " + heap.toString());
            heap.addElement(5);
            System.out.println("Insertar (5): " + heap.toString());
            heap.addElement(4);
            System.out.println("Insertar (4): " + heap.toString());
            heap.addElement(8);
            System.out.println("Insertar (8): " + heap.toString());
            heap.addElement(7);
            System.out.println("Insertar (7): " + heap.toString());
            heap.addElement(9);
            System.out.println("Insertar (9): " + heap.toString());
            heap.addElement(2);
            System.out.println("Insertar (2): " + heap.toString());
            heap.removeMin();
            System.out.println("Remover Mínimo: " + heap.toString());
            System.out.println("Exists 3?: " + heap.exists(3));
            System.out.println();
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
    }

//    private static void pruebaArbolBinario(){
//        try {
//            ArbolBinario<Integer> arbolBinario = new ArbolBinario();
//            
//            NodoArbolBinario<Integer> nodo20 = new NodoArbolBinario(20);
//            NodoArbolBinario<Integer> nodo15 = new NodoArbolBinario(15);
//            NodoArbolBinario<Integer> nodo10 = new NodoArbolBinario(10);
//            NodoArbolBinario<Integer> nodo5 = new NodoArbolBinario(5);
//            NodoArbolBinario<Integer> nodo25 = new NodoArbolBinario(25);
//            NodoArbolBinario<Integer> nodo30 = new NodoArbolBinario(30);
//            NodoArbolBinario<Integer> nodo35 = new NodoArbolBinario(35);
//            
//            arbolBinario.agregarHijoIzquierdo(null, nodo20);
//            arbolBinario.agregarHijoIzquierdo(nodo20, nodo10);
//            arbolBinario.agregarHijoDerecho(nodo20, nodo30);
//            arbolBinario.agregarHijoIzquierdo(nodo10, nodo5);
//            arbolBinario.agregarHijoDerecho(nodo10, nodo15);
//            arbolBinario.agregarHijoIzquierdo(nodo30, nodo25);
//            arbolBinario.agregarHijoDerecho(nodo30, nodo35);
//            arbolBinario.agregarHijoDerecho(nodo35, new NodoArbolBinario(45));
//            
//            System.out.println("Árbol completo: " + arbolBinario);
//            
//            System.out.println("Árbol completo (en preorden): ");
//            
//            Iterador<Integer> iteradorPreorden = arbolBinario.iteradorPreorden();
//            
//            while(iteradorPreorden.existeSiguiente()) {
//                System.out.print(iteradorPreorden.siguiente() + ", ");
//            }
//            
//            System.out.println("");
//            
//            System.out.print("Elimino nodo hoja (Nodo 15): ");
//            arbolBinario.remove(nodo15.valor);
//            System.out.println(arbolBinario);
//            
//            System.out.print("Elimino nodo con 1 hijo (Nodo 35): ");
//            arbolBinario.remove(nodo35.valor);
//            System.out.println(arbolBinario);
//                       
//            System.out.print("Eliminar raíz (Nodo 20): ");
//            arbolBinario.remove(nodo20.valor);
//            System.out.println(arbolBinario);
//            
//            
//        } catch (Exception ex) {
//            System.err.print(ex);
//        }
//    }
    private static void pruebaArbolBinario() {
        try {
            System.out.println("Árbol Binario");
            System.out.println("===========");
            NodoArbolBinario<Integer> nodo33 = new NodoArbolBinario(33);
            NodoArbolBinario<Integer> nodo43 = new NodoArbolBinario(43);
            NodoArbolBinario<Integer> nodo23 = new NodoArbolBinario(23);
            NodoArbolBinario<Integer> nodo64 = new NodoArbolBinario(64);

            ArbolBinario<Integer> arbol = new ArbolBinario();

            arbol.agregarHijoIzquierdo(null, nodo33);
            arbol.agregarHijoIzquierdo(nodo33, nodo43);
            arbol.agregarHijoIzquierdo(nodo43, nodo23);
            arbol.agregarHijoDerecho(nodo33, nodo64);

            System.out.println("arbol = " + arbol);

            Iterador<Integer> iterador = arbol.iteradorPreorden();
            while (iterador.existeSiguiente()) {
                System.out.println("iterador = " + iterador.siguiente());
            }
        } catch (Exception exc) {
            System.out.println(exc);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Arbol Binario
        pruebaArbolBinario();

        //Heap
        pruebaHeap();
    }

}

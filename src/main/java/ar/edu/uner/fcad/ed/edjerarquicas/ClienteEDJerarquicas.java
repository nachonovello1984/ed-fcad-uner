/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ar.edu.uner.fcad.ed.edjerarquicas;

/**
 *
 * @author Nacho
 */
public class ClienteEDJerarquicas {

    private static void pruebaApuntadoresAlPadre() throws Exception {
        InterfazArbol<Integer> arbol = new ArbolApuntadoresPadre(Integer.class);

        NodoArbol<Integer> nodo20 = new NodoArbolApuntadorPadre(20);
        NodoArbol<Integer> nodo10 = new NodoArbolApuntadorPadre(10);
        NodoArbol<Integer> nodo15 = new NodoArbolApuntadorPadre(15);
        NodoArbol<Integer> nodo12 = new NodoArbolApuntadorPadre(12);
        NodoArbol<Integer> nodo17 = new NodoArbolApuntadorPadre(17);
        NodoArbol<Integer> nodo30 = new NodoArbolApuntadorPadre(30);

        arbol.insertaHijo(null, nodo20);
        arbol.insertaHijo(nodo20, nodo10);

        arbol.insertaHijo(nodo10, new NodoArbolApuntadorPadre<Integer>(5));
        arbol.insertaHijo(nodo10, new NodoArbolApuntadorPadre<Integer>(7));
        arbol.insertaHijo(nodo10, nodo15);

        arbol.insertaHijo(nodo15, nodo12);
        arbol.insertaHermano(nodo12, nodo17);
        arbol.insertaHermano(nodo17, new NodoArbolApuntadorPadre<Integer>(18));

        arbol.insertaHermano(nodo10, nodo30);
        arbol.insertaHijo(nodo30, new NodoArbolApuntadorPadre<Integer>(40));

        String strRecorrido = arbol.toString();

        System.out.println(strRecorrido);
    }

    private static void pruebaListaHijos() throws Exception {
        InterfazArbol<Integer> arbol = new ArbolListaHijos();

        NodoArbol<Integer> nodo20 = new NodoArbolListaHijos(20);
        NodoArbol<Integer> nodo10 = new NodoArbolListaHijos(10);
        NodoArbol<Integer> nodo15 = new NodoArbolListaHijos(15);
        NodoArbol<Integer> nodo12 = new NodoArbolListaHijos(12);
        NodoArbol<Integer> nodo17 = new NodoArbolListaHijos(17);
        NodoArbol<Integer> nodo30 = new NodoArbolListaHijos(30);

        arbol.insertaHijo(null, nodo20);
        arbol.insertaHijo(nodo20, nodo10);

        arbol.insertaHijo(nodo10, new NodoArbolListaHijos(5));
        arbol.insertaHijo(nodo10, new NodoArbolListaHijos(7));
        arbol.insertaHijo(nodo10, nodo15);

        arbol.insertaHijo(nodo15, nodo12);
        arbol.insertaHermano(nodo12, nodo17);
        arbol.insertaHermano(nodo17, new NodoArbolListaHijos(18));

        arbol.insertaHermano(nodo10, nodo30);
        arbol.insertaHijo(nodo30, new NodoArbolListaHijos(40));

        System.out.println(arbol.toString());
    }

    private static void pruebaHiHd() throws Exception {
        InterfazArbol<Integer> arbol = new ArbolHiHd();

        NodoArbol<Integer> nodo20 = new NodoArbolHiHd(20);
        NodoArbol<Integer> nodo10 = new NodoArbolHiHd(10);
        NodoArbol<Integer> nodo15 = new NodoArbolHiHd(15);
        NodoArbol<Integer> nodo12 = new NodoArbolHiHd(12);
        NodoArbol<Integer> nodo17 = new NodoArbolHiHd(17);
        NodoArbol<Integer> nodo30 = new NodoArbolHiHd(30);

        arbol.insertaHijo(null, nodo20);
        arbol.insertaHijo(nodo20, nodo10);

        arbol.insertaHijo(nodo10, new NodoArbolHiHd<Integer>(5));
        arbol.insertaHijo(nodo10, new NodoArbolHiHd<Integer>(7));
        arbol.insertaHijo(nodo10, nodo15);

        arbol.insertaHijo(nodo15, nodo12);
        arbol.insertaHermano(nodo12, nodo17);
        arbol.insertaHermano(nodo17, new NodoArbolHiHd<Integer>(18));

        arbol.insertaHermano(nodo10, nodo30);
        arbol.insertaHijo(nodo30, new NodoArbolHiHd<Integer>(40));

        System.out.println(arbol.toString());
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            System.out.println("Prueba Arreglo apuntadores al padre");
            System.out.println("====================================");
            pruebaApuntadoresAlPadre();

            System.out.println("Prueba Lista de Hijos");
            System.out.println("====================================");
            pruebaListaHijos();

            System.out.println("Prueba Hijo Izquierdo - Hermano Derecho");
            System.out.println("====================================");
            pruebaHiHd();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
    
}

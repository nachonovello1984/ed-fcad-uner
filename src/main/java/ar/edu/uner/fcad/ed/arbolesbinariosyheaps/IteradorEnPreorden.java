/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.uner.fcad.ed.arbolesbinariosyheaps;

import ar.edu.uner.fcad.ed.edlineales.Iterador;
import ar.edu.uner.fcad.ed.edlineales.ListaEnlazadaNoOrdenada;

/**
 *
 * @author nacho
 * @param <T>
 */
public class IteradorEnPreorden <T> implements Iterador<T> {
    
    private final Iterador<T> iterador;
    /**
     * Arma una ListaEnlazadaNoOrdenada y crea sobre la misma un iterador.
     * @param nodo 
     */
    public IteradorEnPreorden(NodoArbolBinario<T> nodo) {
        this.iterador = armarLista(nodo).iterador();
    }
    
    /**
     * Recorre en preorden el árbol e inserta los elementos de los nodos en
     * una ListaEnlazadaNoOrdenada
     * @param nodo
     * @return 
     */
    private ListaEnlazadaNoOrdenada<T> armarLista(NodoArbolBinario<T> nodo) {
        ListaEnlazadaNoOrdenada<T> resultado = new ListaEnlazadaNoOrdenada<T>();
        
        //Agrego la raíz del subárbol
        resultado.addToRear(nodo.getValor());
        
        //Recorro en preorden el subárbol izquierdo
        if (nodo.tieneHijoIzquierdo()) {
            agregarTodos(resultado, armarLista(nodo.getHijoIzquierdo()));
        }
        
        //Recorro en preorden el subárbol derecho
        if (nodo.tieneHijoDerecho()) {
            agregarTodos(resultado, armarLista(nodo.getHijoDerecho()));
        }
        
        return resultado;
    }

    /**
     * Encapsula el método existeSiguiente() del Iterador de lista.
     * @return 
     */
    @Override
    public boolean existeSiguiente() {
        return iterador.existeSiguiente();
    }

    /**
     * Encapsula el método siguiente() del Iterador de lista.
     * @return 
     */
    @Override
    public T siguiente() {
        return iterador.siguiente();
    }

    /**
     * Agrega a lista1 todos los elementos de lista2.
     * @param lista1
     * @param lista2 
     */
    private void agregarTodos(ListaEnlazadaNoOrdenada<T> lista1, ListaEnlazadaNoOrdenada<T> lista2) {
        if (lista2 == null) {
            return;
        }
        
        Iterador<T> iteradorLista = lista2.iterador();
        
        while(iteradorLista.existeSiguiente()) {
            lista1.addToRear(iteradorLista.siguiente());
        }
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.uner.fcad.ed.arbolesabbyavl;

import ar.edu.uner.fcad.ed.edlineales.ColaPorEnlaces;
import ar.edu.uner.fcad.ed.edlineales.Iterador;
import ar.edu.uner.fcad.ed.edlineales.ListaEnlazadaNoOrdenada;

/**
 *
 * @author Nacho
 * @param <T>
 */
public class ArbolABBIteratorNiveles<T> implements Iterador<T> {
    private final Iterador<T> iterador;

    public ArbolABBIteratorNiveles(ArbolABB<T> arbolAbb) {
        this.iterador = generarRecorrido(arbolAbb).iterador();
    }

    private ListaEnlazadaNoOrdenada<T> generarRecorrido(ArbolABB<T> arbolAbb) {
        ListaEnlazadaNoOrdenada<T> resultado = new ListaEnlazadaNoOrdenada();
        
        ColaPorEnlaces<NodoABB<T>> cola = new ColaPorEnlaces();
        cola.enqueue(arbolAbb.getRaiz());
        
        while (!cola.isEmpty()) {
            NodoABB<T> nodoActual = cola.getFront();
            T valorActual = nodoActual.getValor();
            cola.dequeue();

            resultado.addToRear(valorActual);

            if (nodoActual.getTieneHijoIzquierdo()) {
                cola.enqueue(nodoActual.getHijoIzquierdo());
            }
            
            if (nodoActual.getTieneHijoDerecho()) {
                cola.enqueue(nodoActual.getHijoDerecho());
            }
        }

        return resultado;
    }

    public boolean existeSiguiente() {
        return iterador.existeSiguiente();
    }

    @Override
    public T siguiente() {
        return iterador.siguiente();
    }
}

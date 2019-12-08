/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.uner.fcad.ed.edjerarquicas;

import ar.edu.uner.fcad.ed.edlineales.ListaEnlazadaNoOrdenada;
import ar.edu.uner.fcad.ed.edlineales.colas.ColaPorEnlaces;
import ar.edu.uner.fcad.ed.edlineales.iteradores.Iterador;

/**
 *
 * @author Usuario
 * @param <T>
 */
public class ArbolHiHdIteradorPorNiveles<T> implements Iterador<T> {

    private final Iterador<T> iterador;

    public ArbolHiHdIteradorPorNiveles(NodoArbolHiHd<T> raiz) {
        this.iterador = armarRecorrido(raiz).iterador();
    }

    @Override
    public boolean existeSiguiente() {
        return iterador.existeSiguiente();
    }

    @Override
    public T siguiente() {
        if (!iterador.existeSiguiente()) {
            throw new IllegalStateException("No existen más elementos.");
        }

        return iterador.siguiente();
    }

    private ListaEnlazadaNoOrdenada<T> armarRecorrido(NodoArbolHiHd<T> raiz) {
        ListaEnlazadaNoOrdenada<T> resultado = new ListaEnlazadaNoOrdenada();

        ColaPorEnlaces<NodoArbolHiHd<T>> cola = new ColaPorEnlaces();
        cola.enqueue(raiz);
        while (!cola.isEmpty()) {
            NodoArbolHiHd<T> nodoActual = cola.getFront();
            resultado.addToRear(nodoActual.getValor());

            if (nodoActual.hijoIzquierdo != null) {
                NodoArbolHiHd<T> nodoHijo = nodoActual.hijoIzquierdo;
                while (nodoHijo != null) {
                    cola.enqueue(nodoHijo);
                    nodoHijo = nodoHijo.hnoDerecho;
                }
            }
            cola.dequeue();
        }

        return resultado;
    }
}

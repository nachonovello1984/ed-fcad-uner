package ar.edu.uner.fcad.ed.edjerarquicas;

import ar.edu.uner.fcad.ed.edlineales.iteradores.Iterador;
import ar.edu.uner.fcad.ed.edlineales.ListaEnlazadaNoOrdenada;

/**
 *
 * @author ignnov
 * @param <T>
 */
public class ArbolHiHdIteradorInorden<T> implements ArbolHiHdIterador<T> {

    private final Iterador<T> iterador;

    public ArbolHiHdIteradorInorden(NodoArbolHiHd<T> raiz) {
        this.iterador = armarRecorrido(raiz).iterador();
    }

    private ListaEnlazadaNoOrdenada<T> armarRecorrido(NodoArbolHiHd<T> raiz) {
        ListaEnlazadaNoOrdenada<T> resultado = new ListaEnlazadaNoOrdenada();

        resultado.addAll(agregarSubArbol(raiz));

        return resultado;
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

    private ListaEnlazadaNoOrdenada<T> agregarSubArbol(NodoArbolHiHd<T> nodoActual) {
        ListaEnlazadaNoOrdenada<T> resultado = new ListaEnlazadaNoOrdenada();

        if (nodoActual.getHijoIzquierdo() != null) {
            resultado.addAll(agregarSubArbol(nodoActual.getHijoIzquierdo()));

            resultado.addToRear(nodoActual.getValor());
            
            
            if (nodoActual.getHijoIzquierdo().getHnoDerecho() != null) {
                NodoArbolHiHd<T> nodoHijoDerechoActual = nodoActual.getHijoIzquierdo().getHnoDerecho();
                while(nodoHijoDerechoActual != null){
                    resultado.addAll(agregarSubArbol(nodoHijoDerechoActual));
                    nodoHijoDerechoActual = nodoHijoDerechoActual.getHnoDerecho();
                }
            }
        } else {
            resultado.addToRear(nodoActual.getValor());
        }
        return resultado;
    }
}

package ar.edu.uner.fcad.ed.arbolesabbyavl;

import ar.edu.uner.fcad.ed.edlineales.iteradores.Iterador;
import ar.edu.uner.fcad.ed.edlineales.ListaEnlazadaNoOrdenada;

/**
 *
 * @author Nacho
 * @param <T>
 */
public class ArbolABBIteradorInOrden <T extends Comparable<T>> implements Iterador<T> {
    private final Iterador<T> iterador;

    public ArbolABBIteradorInOrden(NodoABB<T> raiz){
        this.iterador = generarRecorrido(raiz).iterador();
    }

    private ListaEnlazadaNoOrdenada<T> generarRecorrido(NodoABB<T> raiz) {
        ListaEnlazadaNoOrdenada<T> resultado = new ListaEnlazadaNoOrdenada();

        resultado.addAll(agregarNodos(raiz));

        return resultado;
    }

    private ListaEnlazadaNoOrdenada<T> agregarNodos(NodoABB<T> nodo){
        ListaEnlazadaNoOrdenada<T> resultado = new ListaEnlazadaNoOrdenada();

        if(nodo.tieneHijoIzquierdo()){
            resultado.addAll(agregarNodos(nodo.getHijoIzquierdo()));
        }
        
        resultado.addToRear(nodo.getValor());

        if(nodo.tieneHijoDerecho()){
            resultado.addAll(agregarNodos(nodo.getHijoDerecho()));
        }

        return resultado;
    }

    @Override
    public boolean existeSiguiente() {
        return iterador.existeSiguiente();
    }

    @Override
    public T siguiente() {
        return iterador.siguiente();
    }
}

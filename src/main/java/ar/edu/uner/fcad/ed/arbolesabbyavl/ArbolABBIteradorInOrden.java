package ar.edu.uner.fcad.ed.arbolesabbyavl;

import ar.edu.uner.fcad.ed.edlineales.iteradores.Iterador;
import ar.edu.uner.fcad.ed.edlineales.ListaEnlazadaNoOrdenada;

/**
 *
 * @author Nacho
 * @param <T>
 */
public class ArbolABBIteradorInOrden <T extends Comparable<? super T>> implements Iterador<T> {
    private final Iterador<T> iterador;

    public ArbolABBIteradorInOrden(ArbolABB<T> arbolAbb){
        this.iterador = generarRecorrido(arbolAbb).iterador();
    }

    private ListaEnlazadaNoOrdenada<T> generarRecorrido(ArbolABB<T> arbolAbb) {
        ListaEnlazadaNoOrdenada<T> resultado = new ListaEnlazadaNoOrdenada();

        resultado.addAll(agregarNodos(arbolAbb.getRaiz()));

        return resultado;
    }

    private ListaEnlazadaNoOrdenada<T> agregarNodos(NodoABB<T> nodo){
        ListaEnlazadaNoOrdenada<T> resultado = new ListaEnlazadaNoOrdenada();

        if(nodo.getTieneHijoIzquierdo()){
            resultado.addAll(agregarNodos(nodo.getHijoIzquierdo()));
        }
        
        resultado.addToRear(nodo.getValor());

        if(nodo.getTieneHijoDerecho()){
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

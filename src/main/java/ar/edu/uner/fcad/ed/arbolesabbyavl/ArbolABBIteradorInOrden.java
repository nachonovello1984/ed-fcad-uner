package ar.edu.uner.fcad.ed.arbolesabbyavl;

import ar.edu.uner.fcad.ed.edlineales.iteradores.Iterador;
import ar.edu.uner.fcad.ed.edlineales.ListaEnlazadaNoOrdenada;

/**
 *
 * @author Nacho
 * @param <T>
 */
public class ArbolABBIteradorInOrden<T> implements Iterador<T> {
    private final Iterador<T> iterador;

    public ArbolABBIteradorInOrden(ArbolABB<T> arbolAbb){
        this.iterador = generarRecorrido(arbolAbb).iterador();
    }

    private ListaEnlazadaNoOrdenada<T> generarRecorrido(ArbolABB<T> arbolAbb) {
        ListaEnlazadaNoOrdenadaExt<T> resultado = new ListaEnlazadaNoOrdenadaExt();

        resultado.agregarTodos(agregarNodos(arbolAbb.getRaiz()));

        return resultado;
    }

    private ListaEnlazadaNoOrdenada<T> agregarNodos(NodoABB<T> nodo){
        ListaEnlazadaNoOrdenadaExt<T> resultado = new ListaEnlazadaNoOrdenadaExt();

        if(nodo.getTieneHijoIzquierdo()){
            resultado.agregarTodos(agregarNodos(nodo.getHijoIzquierdo()));
        }
        
        resultado.addToRear(nodo.getValor());

        if(nodo.getTieneHijoDerecho()){
            resultado.agregarTodos(agregarNodos(nodo.getHijoDerecho()));
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

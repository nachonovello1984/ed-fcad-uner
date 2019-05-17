/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.uner.fcad.ed.arbolesabbyavl;

import ar.edu.uner.fcad.ed.edlineales.Iterador;
import ar.edu.uner.fcad.ed.edlineales.ListaEnlazadaNoOrdenada;


/**
 *
 * @author Nacho
 * @param <T>
 */
public class ArbolABBIteradorPosOrden<T> implements Iterador<T>{
    
    private final Iterador <T> iterador;
    
    public ArbolABBIteradorPosOrden(ArbolABB<T> arbolAbb){
        this.iterador = generarRecorrido(arbolAbb).iterador();
    }

    private ListaEnlazadaNoOrdenada<T> generarRecorrido(ArbolABB<T> arbolAbb) {
        ListaEnlazadaNoOrdenadaExt<T> resultado = new ListaEnlazadaNoOrdenadaExt();

        resultado.agregarTodos(agregarSubArbol(arbolAbb.getRaiz()));

        return resultado;
    }

    private ListaEnlazadaNoOrdenada<T> agregarSubArbol(NodoABB<T> nodoActual){
        ListaEnlazadaNoOrdenadaExt<T> resultado = new ListaEnlazadaNoOrdenadaExt();

        if(nodoActual.getTieneHijoIzquierdo()){
            resultado.agregarTodos(agregarSubArbol(nodoActual.getHijoIzquierdo()));
        }
        
        if(nodoActual.getTieneHijoDerecho()){
            resultado.agregarTodos(agregarSubArbol(nodoActual.getHijoDerecho()));
        }
        
        resultado.addToRear(nodoActual.getValor());

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

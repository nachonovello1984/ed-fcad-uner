/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.uner.fcad.ed.arbolesabbyavl;


import ar.edu.uner.fcad.ed.edlineales.iteradores.Iterador;
import ar.edu.uner.fcad.ed.edlineales.ListaEnlazadaNoOrdenada;

/**
 *
 * @author Nacho
 */
public class ArbolABBIteratorPreorden<T> implements Iterador<T>{
    private final Iterador <T> iterador;
    
    public ArbolABBIteratorPreorden(ArbolABB<T> arbolAbb){
        this.iterador = generarRecorrido(arbolAbb).iterador();
    }

    private ListaEnlazadaNoOrdenada<T> generarRecorrido(ArbolABB<T> arbolAbb) {
        ListaEnlazadaNoOrdenada<T> resultado = new ListaEnlazadaNoOrdenada();

        resultado.addAll(agregarSubArbol(arbolAbb.getRaiz()));

        return resultado;
    }

    private ListaEnlazadaNoOrdenada<T> agregarSubArbol(NodoABB<T> nodoActual){
        ListaEnlazadaNoOrdenada<T> resultado = new ListaEnlazadaNoOrdenada();

        resultado.addToRear(nodoActual.getValor());

        if(nodoActual.getTieneHijoIzquierdo()){
            resultado.addAll(agregarSubArbol(nodoActual.getHijoIzquierdo()));
        }
        
        if(nodoActual.getTieneHijoDerecho()){
            resultado.addAll(agregarSubArbol(nodoActual.getHijoDerecho()));
        }

        return resultado;
    }

    public boolean existeSiguiente() {
        return iterador.existeSiguiente();
    }

    public T siguiente() {
        return iterador.siguiente();
    }
}

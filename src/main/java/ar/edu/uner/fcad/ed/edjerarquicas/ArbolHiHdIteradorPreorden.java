/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.uner.fcad.ed.edjerarquicas;

import ar.edu.uner.fcad.ed.edlineales.iteradores.Iterador;
import ar.edu.uner.fcad.ed.edlineales.ListaEnlazadaNoOrdenada;

/**
 *
 * @author Nacho
 * @param <T>
 */
public class ArbolHiHdIteradorPreorden <T> implements Iterador <T> {
    
    private final Iterador<T> iterador;
    
    public ArbolHiHdIteradorPreorden(NodoArbolHiHd<T> raiz){
        this.iterador = armarRecorrido(raiz).iterador();
    }
    
    private ListaEnlazadaNoOrdenada<T> armarRecorrido(NodoArbolHiHd<T> raiz){
        ListaEnlazadaNoOrdenada <T> resultado = new ListaEnlazadaNoOrdenada();
        
        resultado.addAll(agregarSubArbol(raiz));
        
        return resultado;
    }
    
    @Override
    public boolean existeSiguiente() {
        return iterador.existeSiguiente();
    }

    @Override
    public T siguiente() {
        
        if(!iterador.existeSiguiente()){
            throw new IllegalStateException("No existen más elementos.");
        }
        
        return iterador.siguiente();
    }

    private ListaEnlazadaNoOrdenada<T> agregarSubArbol(NodoArbolHiHd<T> nodoActual) {
        ListaEnlazadaNoOrdenada<T> resultado = new ListaEnlazadaNoOrdenada();

        resultado.addToRear(nodoActual.getValor());

        if(nodoActual.getHijoIzquierdo() != null) {
            resultado.addAll(agregarSubArbol(nodoActual.getHijoIzquierdo()));
        }
        
        if(nodoActual.getHnoDerecho() != null){
            resultado.addAll(agregarSubArbol(nodoActual.getHnoDerecho()));
        }

        return resultado;
    }
}

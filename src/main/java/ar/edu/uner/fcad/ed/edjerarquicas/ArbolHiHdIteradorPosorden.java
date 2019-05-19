/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.uner.fcad.ed.edjerarquicas;

import ar.edu.uner.fcad.ed.edlineales.iteradores.Iterador;
import ar.edu.uner.fcad.ed.edlineales.ListaEnlazadaNoOrdenada;

/**
 *
 * @author ignnov
 * @param <T>
 */
public class ArbolHiHdIteradorPosorden <T> implements ArbolHiHdIterador <T> {
    
    private Iterador<T> iterador;
    
    public ArbolHiHdIteradorPosorden(NodoArbolHiHd<T> raiz){
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
    public T siguiente() throws EDJerarquicasException {
        
        if(!iterador.existeSiguiente()){
            throw new EDJerarquicasException("No existen más elementos.");
        }
        
        return iterador.siguiente();
    }

    private ListaEnlazadaNoOrdenada<T> agregarSubArbol(NodoArbolHiHd<T> nodoActual) {
        ListaEnlazadaNoOrdenada<T> resultado = new ListaEnlazadaNoOrdenada();

        if(nodoActual.getHijoIzquierdo() != null) {
            resultado.addAll(agregarSubArbol(nodoActual.getHijoIzquierdo()));
        }
        
        resultado.addToRear(nodoActual.getValor());
        
        if(nodoActual.getHnoDerecho() != null){
            resultado.addAll(agregarSubArbol(nodoActual.getHnoDerecho()));
        }

        return resultado;
    }
}

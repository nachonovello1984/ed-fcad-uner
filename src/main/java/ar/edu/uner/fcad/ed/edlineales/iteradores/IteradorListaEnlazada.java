/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.uner.fcad.ed.edlineales.iteradores;

import ar.edu.uner.fcad.ed.edlineales.NodoLista;


/**
 *
 * @author Nacho
 * @param <T>
 */
public class IteradorListaEnlazada<T> implements Iterador<T>{
    private NodoLista<T> nodoActual;
    
    public IteradorListaEnlazada(NodoLista<T> header){
        this.nodoActual = header;
    }

    @Override
    public boolean existeSiguiente() {
        return nodoActual.getSiguiente() != null;
    }

    @Override
    public T siguiente() {
        T resultado = null;
        
        if(existeSiguiente()){
            nodoActual = nodoActual.getSiguiente();
            resultado = nodoActual.getElemento();
        }
     
        return resultado;
    }
    
}

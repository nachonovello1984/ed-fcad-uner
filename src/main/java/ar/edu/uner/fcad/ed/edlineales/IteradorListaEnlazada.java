/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.uner.fcad.ed.edlineales;


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
        return nodoActual.siguiente != null;
    }

    @Override
    public T siguiente() {
        T resultado = null;
        
        if(existeSiguiente()){
            nodoActual = nodoActual.siguiente;
            resultado = nodoActual.elemento;
        }
     
        return resultado;
    }
    
}

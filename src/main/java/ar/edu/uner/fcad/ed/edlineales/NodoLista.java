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
public class NodoLista <T>{
    protected T elemento;
    protected NodoLista<T> siguiente;
    
    public NodoLista(T elemento){
        this(elemento, null);
    }
    
    public NodoLista(T elemento, NodoLista<T> siguiente){
        this.elemento = elemento;
        this.siguiente = siguiente;
    }

    /**
     * @return the elemento
     */
    public T getElemento() {
        return elemento;
    }

    /**
     * @param elemento the elemento to set
     */
    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    /**
     * @return the siguiente
     */
    public NodoLista<T> getSiguiente() {
        return siguiente;
    }

    /**
     * @param siguiente the siguiente to set
     */
    public void setSiguiente(NodoLista<T> siguiente) {
        this.siguiente = siguiente;
    }

    @Override
    public String toString() {
        return "[" + ((elemento != null)? elemento.toString() : "") + "]";
    }
}

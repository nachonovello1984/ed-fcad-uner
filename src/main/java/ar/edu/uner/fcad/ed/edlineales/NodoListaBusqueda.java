/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ar.edu.uner.fcad.ed.edlineales;

/**
 *
 * @author nacho
 * @param <T>
 */
public class NodoListaBusqueda<T> {
    protected NodoLista<T> nodoAnterior;
    protected NodoLista<T> nodoActual;

    public NodoListaBusqueda() {
        this(null, null);
    }

    public NodoListaBusqueda(NodoLista<T> nodoAnterior, NodoLista<T> nodoActual) {
        this.nodoAnterior = nodoAnterior;
        this.nodoActual = nodoActual;
    }

    public void setNodoAnterior(NodoLista<T> nodoAnterior) {
        this.nodoAnterior = nodoAnterior;
    }

    public void setNodoActual(NodoLista<T> nodoActual) {
        this.nodoActual = nodoActual;
    }
    
}

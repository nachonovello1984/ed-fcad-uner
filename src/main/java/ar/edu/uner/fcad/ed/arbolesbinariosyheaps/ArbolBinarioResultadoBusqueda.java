/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.uner.fcad.ed.arbolesbinariosyheaps;

/**
 *
 * @author Nacho
 */
public class ArbolBinarioResultadoBusqueda<T> {
    protected NodoArbolBinario<T> padre;
    protected NodoArbolBinario<T> nodoBuscado;

    public ArbolBinarioResultadoBusqueda() {
        this.padre = null;
        this.nodoBuscado = null;
    }

    public ArbolBinarioResultadoBusqueda(NodoArbolBinario<T> padre, NodoArbolBinario<T> nodoBuscado) {
        this.padre = padre;
        this.nodoBuscado = nodoBuscado;
    }

    public NodoArbolBinario<T> getNodoBuscado() {
        return nodoBuscado;
    }

    public void setNodoBuscado(NodoArbolBinario<T> nodoBuscado) {
        this.nodoBuscado = nodoBuscado;
    }

    public NodoArbolBinario<T> getPadre() {
        return padre;
    }

    public void setPadre(NodoArbolBinario<T> padre) {
        this.padre = padre;
    }
}

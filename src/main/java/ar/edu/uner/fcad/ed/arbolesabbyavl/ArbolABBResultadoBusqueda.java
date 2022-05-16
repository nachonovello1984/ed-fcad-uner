/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.uner.fcad.ed.arbolesabbyavl;

/**
 *
 * @author Nacho
 * @param <T>
 */
public class ArbolABBResultadoBusqueda <T extends Comparable<T>> {
    protected NodoABB<T> padre;
    protected NodoABB<T> nodoBuscado;

    public ArbolABBResultadoBusqueda() {
        this.padre = null;
        this.nodoBuscado = null;
    }

    public ArbolABBResultadoBusqueda(NodoABB<T> padre, NodoABB<T> nodoBuscado) {
        this.padre = padre;
        this.nodoBuscado = nodoBuscado;
    }

    public NodoABB<T> getNodoBuscado() {
        return nodoBuscado;
    }

    public void setNodoBuscado(NodoABB<T> nodoBuscado) {
        this.nodoBuscado = nodoBuscado;
    }

    public NodoABB<T> getPadre() {
        return padre;
    }

    public void setPadre(NodoABB<T> padre) {
        this.padre = padre;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.uner.fcad.ed.arbolesbinariosyheaps;

/**
 *
 * @author Nacho
 * @param <T>
 */
public class NodoHeap<T> extends NodoArbolBinario<T>{
    
    public NodoHeap<T> padre;
    
    public NodoHeap(T valor){
        super(valor);
    }

    public NodoHeap<T> getPadre() {
        return padre;
    }

    public void setPadre(NodoHeap<T> padre) {
        this.padre = padre;
    }
}

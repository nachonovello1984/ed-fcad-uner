package ar.edu.uner.fcad.ed.arbolesabbyavl;

import ar.edu.uner.fcad.ed.arbolesbinariosyheaps.NodoArbolBinario;
import java.util.Objects;

/**
 *
 * @author Nacho
 * @param <T>
 */
public class NodoABB <T extends Comparable<T>> extends NodoArbolBinario <T>{
    public NodoABB(T valor){
        super(valor);
    }
    
    @Override
    public NodoABB<T> getHijoIzquierdo() {
        return (NodoABB<T>) this.hijoIzquierdo;
    }

    @Override
    public NodoABB<T> getHijoDerecho() {
        return (NodoABB<T>) hijoDerecho;
    }
}

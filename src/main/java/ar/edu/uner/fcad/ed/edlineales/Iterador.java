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
public interface Iterador<T> {
    /**
     * Indica si existe un nodo siguiente al actual
     * @return 
     */
    public boolean existeSiguiente();
    
    /**
     * Obtiene el siguiente elemento de la estructura.
     * @return 
     */
    public T siguiente();
}







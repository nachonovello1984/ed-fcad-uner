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
public interface Cola<T> {

    /**
     * Indica si la estructura está vacía
     *
     * @return
     */
    public boolean isEmpty();

    /**
     * Indica si la estructura está llena
     *
     * @return
     */
    public boolean isFull();

    /**
     * Obtiene el elemento ubicado en el frente
     *
     * @return
     */
    public T getFront();

    /**
     * Quita el elemento ubicado en el frente.
     */
    public void dequeue();

    /**
     * Agrega un elemento al final de la estructura
     *
     * @param elemento
     */
    public void enqueue(T elemento);

    /**
     * Vacía la estructura
     */
    public void makeEmpty();
    
}

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
public interface ColaAleatoria<T> {

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
     * Obtiene un elemento aleatoriamente de la estructura
     *
     * @return
     */
    public T random();

    /**
     * Quita un elemento aleatoriamente de la estructura. 
     */
    public void removeRandom();

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

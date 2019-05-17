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
public interface Pila<T> {
    /**
     * Indica si la estructura está vacía
     * @return 
     */
    public boolean isEmpty();

    /**
     * Indica si la estructura está llena
     * @return 
     */
    public boolean isFull();

    /**
     * Retorna el elemento ubicado en la posición tope de la pila.
     * @return 
     */
    public T top();

    /**
     * Quita la posición ubicada en el tope de la pila.
     */
    public void pop();

    /**
     * Agrega el elemento pasado por parámetro en el tope de la pila.
     * @param elemento 
     */
    public void push(T elemento);

    /**
     * Vacía la estructura
     */
    public void makeEmpty();
    
    /**
     * Concatena todos el resultado de aplicar toString() a cada uno de los elementos
     * de la pila.
     * @return 
     */
    @Override
    public String toString();
}

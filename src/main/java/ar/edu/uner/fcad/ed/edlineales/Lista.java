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
public interface Lista<T> {

    /**
     * Elimina y devuelve el primer elemento de la lista
     * @return 
     */
    public T removeFirst();

    /**
     * Elimina y devuelve el último elemento de la lista
     * @return 
     */
    public T removeLast();

    /**
     * Elimina y devuelve el elemento especificado de la lista
     * @param element
     * @return
     */
    public T remove(T element);

    /**
     * Devuelve una referencia al primer elemento de la lista
     * @return 
     */
    public T first();
    
    /**
     * Devuelve el elemento del nodo ubicado en la posición indicada
     * por el parámetro position.
     * 
     * @param position
     * @return 
     */
    public T get(int position);
    
    /**
     * Establece element como nuevo valor del nodo ubicado en position.
     * Arroja excepción cuando position es inválido.
     * 
     * @param element
     * @param position 
     */
    public void set(T element, int position);

    /**
     * Devuelve una referencia al último elemento de la lista
     * @return 
     */
    public T last();

    /**
     * Devuelve true si esta lista contiene el elemento especificado
     * @param target
     * @return 
     */
    public boolean contains(T target);
    
    /**
     * Devuelve la posición en la lista del elemento pasado por parámetro.
     * @param target
     * @return 
     */
    public int indexOf(T target);

    /**
     * Devuelve true si esta lista no contiene ningún elemento
     * @return 
     */
    public boolean isEmpty();

    /**
     * Devuelve el número de elementos de la lista
     * @return 
     */
    public int size();
    
    /**
     * Devuelve una representación de la lista en forma de cadena de caracteres
     * @return 
     */
    @Override
    public String toString();
}

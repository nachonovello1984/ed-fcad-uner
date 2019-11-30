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
public interface ListaOrdenada <T extends Comparable<? super T>> extends Lista<T> {

    /**
     * Añade un elemento especificado a la lista en la ubicación adecuada.
     * 
     * @param element
     */
    public void add(T element);
}

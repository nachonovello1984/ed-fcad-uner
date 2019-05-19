/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.uner.fcad.ed.edlineales.iteradores;

/**
 *
 * @author Nacho
 * @param <T>
 */
public interface Iterable<T> {
    /**
     * Retorna un iterador obtenido a partir de la estructura.
     * @return 
     */
    public Iterador<T> iterador();
}

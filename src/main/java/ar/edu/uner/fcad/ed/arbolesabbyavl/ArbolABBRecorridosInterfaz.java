/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.uner.fcad.ed.arbolesabbyavl;

import ar.edu.uner.fcad.ed.edlineales.iteradores.Iterador;

/**
 *
 * @author Nacho
 * @param <T>
 */
public interface ArbolABBRecorridosInterfaz<T> {
    /**
     * Devuelve un iterador que recorre el árbol por niveles
     * @return
     * @throws Exception: Arroja excepción cuando el árbol está vacío
     */
    public Iterador<T> iteradorPorNiveles() throws Exception;

    /**
     * Devuelve un iterador que recorre el árbol en preorden
     * @return
     * @throws Exception: Arroja excepción cuando el árbol está vacío
     */
    public Iterador<T> iteradorEnPreOrden() throws Exception;

    /**
     * Devuelve un iterador que recorre el árbol inorden
     * @return
     * @throws Exception: Arroja excepción cuando el árbol está vacío
     */
    public Iterador<T> iteradorEnInOrden() throws Exception;

    /**
     * Devuelve un iterador que recorre el árbol en posorden
     * @return
     * @throws Exception: Arroja excepción cuando el árbol está vacío
     */
    public Iterador<T> iteradorEnPosOrden() throws Exception;
}

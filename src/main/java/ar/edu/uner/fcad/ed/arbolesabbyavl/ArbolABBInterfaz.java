/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ar.edu.uner.fcad.ed.arbolesabbyavl;

/**
 *
 * @author Nacho
 * @param <T>
 */
public interface ArbolABBInterfaz <T>{
    /**
     * Indica si el árbol está vacío.
     * @return
     */
    public boolean isEmpty();

    /**
     * Indica si existe en el árbol un nodo con igual valor que el
     * que se indica por parámetro.
     * @param valor
     * @return
     */
    public boolean exists(T valor);

    /**
     * Devuelve el valor del nodo cuya clave se especifica por
     * parámetro.
     * @param valor
     * @return
     */
    public T get(T valor);

    /**
     * Agrega un nuevo nodo al árbol cumpliendo las reglas de árbol
     * binario y de búsqueda.
     * @param valor
     * @throws java.lang.Exception arroja excepción cuando ya existe un
     * nodo con igual valor al que se quiere agregar.
     */
    public void add(T valor) throws Exception;

    /**
     * Elimina un nodo del árbol.
     * @param valor
     * @throws java.lang.Exception arroja excepción cuando el árbol está vacío o
     * el nodo que se quiere borrar no existe.
     */
    public void remove(T valor) throws Exception;

    /**
     * Transforma el árbol en un String disponiendo los nodos de cada nivel en
     * una línea
     * @return
     */
    public String toString();
}
package ar.edu.uner.fcad.ed.arbolesbinariosyheaps;

/**
 * Estructura de Datos
 *
 * @author Nacho
 * @param <T>
 */
public interface ArbolBinarioInterfaz<T> {

    /**
     * Indica si la estructura está vacía.
     * @return 
     */
    public boolean vacio();

    /**
     * Devuelve el valor del nodo raíz del árbol
     * @return 
     */
    public T raiz();

    /**
     * Indica si el nodo cuyo valor de clave es pasado por parámetro 
     * existe en el árbol.
     * @param nodo
     * @return 
     */
    public boolean existe(NodoArbolBinario<T> nodo);

    /**
     * Devuelve el valor del nodo cuya clave se pasa por parámetro.
     * @param valor
     * @return 
     */
    public T get(T valor);

    /**
     * Agrega al árbol el nodo hijo como hijo izquierdo de su padre.
     * @param padre
     * @param hijo
     * @throws Exception 
     */
    public void agregarHijoIzquierdo(NodoArbolBinario<T> padre, NodoArbolBinario<T> hijo) throws Exception;

    /**
     * Agrega al árbol el nodo hijo como hijo derecho de su padre.
     * @param padre
     * @param hijo
     * @throws Exception 
     */
    public void agregarHijoDerecho(NodoArbolBinario<T> padre, NodoArbolBinario<T> hijo) throws Exception;

    /**
     * Quita el nodo cuyo valor de clave es pasado por parámetro.
     * @param valor
     * @throws Exception 
     */
    public void remove(T valor) throws Exception;

    /**
     * Concatena en una única cadena de caracteres los nodos del árbol.
     * @return 
     */
    @Override
    public String toString();
}

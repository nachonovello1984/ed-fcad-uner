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
     */
    public void add(T valor);

    /**
     * Elimina un nodo del árbol.
     * @param valor
     */
    public void remove(T valor);

    /**
     * Transforma el árbol en un String disponiendo los nodos de cada nivel en
     * una línea
     * @return
     */
    @Override
    public String toString();
}
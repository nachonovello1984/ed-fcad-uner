package ar.edu.uner.fcad.ed.arbolesmultivia;

/**
 *
 * @author nacho
 * @param <K>
 * @param <V>
 */
public interface ArbolBInterfaz <K extends Comparable<K>, V> {

    public boolean isEmpty();

    public int size();

    public void clear();

    public int height();

    public V get(K key);

    public void insert(K key, V value);

    public V delete(K key);

    @Override
    public String toString();
}

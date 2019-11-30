package ar.edu.uner.fcad.ed.arbolesbinariosyheaps;

/**
 *
 * @author Nacho
 * @param <T>
 */
public interface HeapInterfaz<T> {
    
    public boolean isEmpty();
    
    public void addElement(T valor);
    
    public T removeMin();
    
    public T findMin();
    
    @Override
    public String toString();
}

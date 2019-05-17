/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.uner.fcad.ed.arbolesbinariosyheaps;

/**
 *
 * @author Nacho
 */
public interface HeapInterfaz<T> {
    
    public boolean isEmpty();
    
    public void addElement(T valor) throws Exception;
    
    public T removeMin() throws Exception;
    
    public T findMin();
    
    @Override
    public String toString();
}

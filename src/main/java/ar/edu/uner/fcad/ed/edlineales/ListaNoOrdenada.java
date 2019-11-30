package ar.edu.uner.fcad.ed.edlineales;

/**
 *
 * @author Nacho
 * @param <T>
 */
public interface ListaNoOrdenada <T> extends Lista <T>{
    /**
     * Añade el elemento especificado al principio de la lista
     * @param element 
     */
    public void addToFront(T element);

    /**
     * Añade el elemento especificado al final de la lista
     * @param element 
     */
    public void addToRear(T element);

    /**
     * Añade el elemento especificado después del elemento especificado como objetivo
     * 
     * @param element
     * @param target
     */
    public void addAfter(T element, T target);
}

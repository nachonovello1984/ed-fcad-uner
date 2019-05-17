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
public class IteradorListaPorPosicion<T> implements Iterador<T>{
    private int ultimaPosicion;
    private final int posicionesOcupadas;
    private final T[] arreglo;
    
    public IteradorListaPorPosicion(T [] arreglo, int ultimaPosicion){
        this.posicionesOcupadas = ultimaPosicion;
        this.ultimaPosicion = -1;
        this.arreglo = arreglo;
    }

    /**
     * Indica si existe un nodo siguiente al actual
     * @return 
     */
    @Override
    public boolean existeSiguiente() {
        return ultimaPosicion + 1 <= posicionesOcupadas;
    }

    /**
     * Obtiene el siguiente elemento de la estructura.
     * @return 
     */
    @Override
    public T siguiente() {
        T resultado = null;
        
        if(existeSiguiente()){
            resultado = arreglo[++ultimaPosicion];
        }
        
        return resultado;
    }
    
}

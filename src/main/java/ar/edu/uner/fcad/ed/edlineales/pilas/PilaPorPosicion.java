/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.uner.fcad.ed.edlineales.pilas;

import java.lang.reflect.Array;

/**
 *
 * @author Nacho
 * @param <T>
 */
public class PilaPorPosicion <T> implements Pila<T>{

    private static final int CAPACIDAD = 10;
    
    protected T[] arreglo;
    protected int tope;
    protected int capacidad;
    
    public PilaPorPosicion(Class<T> clazz){
        this.capacidad = CAPACIDAD;
        this.arreglo = nuevoArreglo(clazz, capacidad);
        makeEmpty();
    }
    
    private T[] nuevoArreglo(Class<T> clazz, int capacidad) {
        return (T[]) Array.newInstance(clazz, capacidad);
    }

    /**
     * Indica si la estructura está vacía
     * @return 
     */
    @Override
    public boolean isEmpty() {
        return tope == -1;
    }

    /**
     * Indica si la estructura está llena
     * @return 
     */
    @Override
    public boolean isFull() {
        return tope == CAPACIDAD - 1;
    }

    /**
     * Retorna el elemento ubicado en la posición tope de la pila.
     * @return 
     */
    @Override
    public T top() {
        if (isEmpty()) {
            return null;
        }
        
        return arreglo[tope];
    }

    /**
     * Quita la posición ubicada en el tope de la pila.
     */
    @Override
    public void pop() {
        this.tope--;
    }

    /**
     * Agrega el elemento pasado por parámetro en el tope de la pila.
     * @param elemento 
     */
    @Override
    public void push(T elemento) {
        if(!isFull()){
            this.arreglo[++tope] = elemento;
        }
    }

    /**
     * Vacía la estructura
     */
    @Override
    public final void makeEmpty() {
        this.tope = -1;
    }
    
    
    @Override
    public String toString(){
        String resultado = "";
        
        for(int i = tope; i >= 0; i--){
            resultado += ", " + arreglo[i].toString();
        }
        
        if(resultado.length() > 0){
            resultado = resultado.substring(2);
        }
        
        return resultado;
    }
    
}

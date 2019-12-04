/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.uner.fcad.ed.edlineales.colas;

import java.lang.reflect.Array;

/**
 *
 * @author Nacho
 * @param <T>
 */
public class ColaPorPosicion<T> implements Cola<T> {

    protected static final int CAPACIDAD_DEFAULT = 10;
    
    protected T[] arreglo;
    protected int tamanioActual;
    protected int capacidad;
    protected int front;
    protected int back;

    public ColaPorPosicion(Class<T> clazz) {
        this(clazz, CAPACIDAD_DEFAULT);
    }
    
    public ColaPorPosicion(Class<T> clazz, int capacidad) {
        this.capacidad = capacidad;
        this.arreglo = nuevoArreglo(clazz, this.capacidad);
        makeEmpty();
    }

    private T[] nuevoArreglo(Class<T> clazz, int capacidad) {
        return (T[]) Array.newInstance(clazz, capacidad);
    }

    /**
     * Indica si la estructura está vacía
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return this.tamanioActual == 0;
    }

    /**
     * Indica si la estructura está llena
     *
     * @return
     */
    @Override
    public boolean isFull() {
        return this.tamanioActual == this.capacidad;
    }

    /**
     * Obtiene el elemento ubicado en el frente
     *
     * @return
     */
    @Override
    public T getFront() {
        if (isEmpty()) {
            return null;
        }

        return this.arreglo[front];
    }

    /**
     * Quita el elemento ubicado en el frente.
     */
    @Override
    public void dequeue() {
        this.front = incrementar(this.front);
        this.tamanioActual--;
    }

    /**
     * Agrega un elemento al final de la estructura
     *
     * @param elemento
     */
    @Override
    public void enqueue(T elemento) {
        if (isFull()) {
            return;
        }
        
        this.back = incrementar(back);
        this.arreglo[back] = elemento;
        this.tamanioActual++;
    }

    /**
     * Vacía la estructura
     */
    @Override
    public final void makeEmpty() {
        this.tamanioActual = 0;
        this.front = 0;
        this.back = -1;
    }
    
    @Override
    public String toString() {
        String resultado = "";
                
        if (isEmpty()) {
            return resultado;
        }
        
        for (int i = front, j = 0; j < tamanioActual; i = incrementar(i), j++) {
            resultado += ", [" + arreglo[i].toString() + "]";
        }
        
        resultado = resultado.substring(2);
        
        return resultado;
        
    }

    private int incrementar(int x) {
        x++;
        if (x == arreglo.length) {
            x = 0;
        }
        return x;
    }
}

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
public class ColaPorEnlaces<T> implements Cola<T>{

    protected NodoLista<T> front;
    protected NodoLista<T> back;

    public ColaPorEnlaces() {
        makeEmpty();
    }

    /**
     * Indica si la estructura está vacía
     * @return 
     */
    @Override
    public boolean isEmpty() {
        return front == null;
    }

    /**
     * Indica si la estructura está llena
     * @return siempre retorna false.
     */
    @Override
    public boolean isFull() {
        return false;
    }

    /**
     * Obtiene el elemento ubicado en el frente
     * @return 
     */
    @Override
    public T getFront() {
        T resultado = null;

        if (!isEmpty()) {
            resultado = front.elemento;
        }

        return resultado;
    }

    /**
     * Quita el elemento ubicado en el frente.
     */
    @Override
    public void dequeue() {
        if (!isEmpty()) {
            this.front = this.front.siguiente;
        }
    }

    /**
     * Agrega un elemento al final de la estructura
     * @param elemento 
     */
    @Override
    public void enqueue(T elemento) {
        NodoLista<T> nuevoNodo = new NodoLista(elemento);
        if (isEmpty()) {
            this.front = nuevoNodo;
            this.back = nuevoNodo;
        } else {
            this.back.siguiente = nuevoNodo;
            this.back = back.siguiente;
        }
    }

    /**
     * Vacía la estructura
     */
    @Override
    public final void makeEmpty() {
        this.front  = this.back = null;
    }

    @Override
    public String toString(){
        String resultado = "";
        
        NodoLista<T> nodoActual = this.front;
        
        while(nodoActual != null){
            resultado += ", " + nodoActual.toString();
            nodoActual = nodoActual.siguiente;
        }
        
        if(resultado.length() > 0){
            resultado = resultado.substring(2);
        }
        
        return resultado;
    }
}

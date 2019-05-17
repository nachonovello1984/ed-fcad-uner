package ar.edu.uner.fcad.ed.edlineales;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Nacho
 * @param <T>
 */
public class PilaPorEnlaces<T> implements Pila<T> {

    protected NodoLista<T> tope;

    public PilaPorEnlaces() {
        makeEmpty();
    }

    /**
     * Indica si la estructura está vacía
     * @return 
     */
    @Override
    public boolean isEmpty() {
        return tope == null;
    }

    /**
     * Indica si la estructura está llena
     * @return 
     */
    @Override
    public boolean isFull() {
        return false;
    }

    /**
     * Retorna el elemento ubicado en la posición tope de la pila.
     * @return 
     */
    @Override
    public T top() {
        return tope.elemento;
    }

    /**
     * Quita la posición ubicada en el tope de la pila.
     */
    @Override
    public void pop() {
        this.tope = this.tope.siguiente;
    }

    /**
     * Agrega el elemento pasado por parámetro en el tope de la pila. 
     * @param x
     */
    @Override
    public void push(T x) {
        if (isEmpty()) {
            this.tope = new NodoLista(x);
        } else {
            NodoLista<T> nuevoNodo = new NodoLista(x);
            nuevoNodo.siguiente = tope;
            this.tope = nuevoNodo;
        }
    }

    /**
     * Vacía la estructura
     */
    @Override
    public final void makeEmpty() {
        this.tope = null;
    }
    
    @Override
    public String toString(){
        String resultado = "";
        
        NodoLista<T> nodoActual = tope;
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

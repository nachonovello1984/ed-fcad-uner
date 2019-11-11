package ar.edu.uner.fcad.ed.arbolesbinariosyheaps;

import java.util.Objects;

/**
 * 
 * @author Nacho
 * @param <T>
 */
public class NodoArbolBinario<T> {
    
    protected T valor;
    protected NodoArbolBinario<T> hijoIzquierdo;
    protected NodoArbolBinario<T> hijoDerecho;

    public NodoArbolBinario(T valor) {
        this(valor, null, null);
    }

    public NodoArbolBinario(T valor, NodoArbolBinario<T> hijoIzquierdo, NodoArbolBinario<T> hijoDerecho) {
        this.valor = valor;
        this.hijoIzquierdo = hijoIzquierdo;
        this.hijoDerecho = hijoDerecho;
    }
    
    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public NodoArbolBinario<T> getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    public void setHijoIzquierdo(NodoArbolBinario<T> hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    public NodoArbolBinario<T> getHijoDerecho() {
        return hijoDerecho;
    }

    public void setHijoDerecho(NodoArbolBinario<T> hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }
    
    public boolean tieneHijoIzquierdo(){
        return hijoIzquierdo != null;
    }
    
    public boolean tieneHijoDerecho(){
        return hijoDerecho != null;
    }
    
    public int getCantidadHijos() {
        int resultado = 0;
        
        resultado += (this.hijoIzquierdo != null) ? 1 : 0;
        resultado += (this.hijoDerecho != null) ? 1 : 0;

        return resultado;
    }
    
    public boolean esHijoIzquierdo(NodoArbolBinario<T> nodoHijo) {
        return this.hijoIzquierdo == nodoHijo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.valor);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final NodoArbolBinario<?> other = (NodoArbolBinario<?>) obj;
        if (!Objects.equals(this.valor, other.valor)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[" + valor + "]";
    }
}

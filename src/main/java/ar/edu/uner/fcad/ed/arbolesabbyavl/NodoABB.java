package ar.edu.uner.fcad.ed.arbolesabbyavl;

import java.util.Objects;


/**
 *
 * @author Nacho
 * @param <T>
 */
public class NodoABB <T extends Comparable<? super T>> {
    protected T valor;
    protected NodoABB<T> hijoIzquierdo;
    protected NodoABB<T> hijoDerecho;

    public NodoABB(T valor){
        this.valor = valor;
        this.hijoIzquierdo = null;
        this.hijoDerecho = null;
    }
    
    public T getValor() {
        return this.valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public NodoABB<T> getHijoIzquierdo() {
        return this.hijoIzquierdo;
    }

    public void setHijoIzquierdo(NodoABB<T> hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    public NodoABB<T> getHijoDerecho() {
        return hijoDerecho;
    }

    public void setHijoDerecho(NodoABB<T> hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }

    public boolean getTieneHijoIzquierdo(){
        return this.getHijoIzquierdo() != null;
    }

    public boolean getTieneHijoDerecho(){
        return this.getHijoDerecho() != null;
    }
    
    public int getCantidadHijos() {
        int resultado = 0;
        
        resultado += (this.hijoIzquierdo != null) ? 1 : 0;
        resultado += (this.hijoDerecho != null) ? 1 : 0;

        return resultado;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.valor);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final NodoABB<?> other = (NodoABB<?>) obj;
        if (!Objects.equals(this.valor, other.valor)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString(){
        return valor.toString();
    }
}

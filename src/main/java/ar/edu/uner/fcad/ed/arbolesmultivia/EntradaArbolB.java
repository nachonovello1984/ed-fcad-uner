/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.uner.fcad.ed.arbolesmultivia;

import java.util.Objects;

/**
 *
 * @author nacho
 * @param <K>
 */
public class EntradaArbolB<K extends Comparable<K>, V> {

    protected Comparable clave;
    protected V valor;
    protected NodoArbolB<K, V> siguiente;
    
    public EntradaArbolB(Comparable clave) {
        this(clave, null, null);
    }

    public EntradaArbolB(Comparable clave, V valor, NodoArbolB<K, V> siguiente) {
        this.clave = clave;
        this.valor = valor;
        this.siguiente = siguiente;
    }

    public Comparable getClave() {
        return clave;
    }

    public void setClave(Comparable clave) {
        this.clave = clave;
    }

    public V getValor() {
        return valor;
    }

    public void setValor(V valor) {
        this.valor = valor;
    }

    public NodoArbolB<K, V> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoArbolB<K, V> siguiente) {
        this.siguiente = siguiente;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.clave);
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
        final EntradaArbolB<?, ?> other = (EntradaArbolB<?, ?>) obj;
        if (!Objects.equals(this.clave, other.clave)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntradaArbolB{" + "clave=" + clave + ", valor=" + valor + ", siguiente=" + siguiente + '}';
    }
}

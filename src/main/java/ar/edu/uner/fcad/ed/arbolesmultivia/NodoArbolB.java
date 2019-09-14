package ar.edu.uner.fcad.ed.arbolesmultivia;

import ar.edu.uner.fcad.ed.edlineales.ListaEnlazadaNoOrdenada;

/**
 *
 * @author nacho
 * @param <K>
 * @param <V>
 */
public class NodoArbolB<K extends Comparable<K>, V> {

    protected int m;
    protected ListaEnlazadaNoOrdenada<EntradaArbolB<K, V>> hijos;
    
    public NodoArbolB(int m) {
        this.m = m;
        this.hijos = null;
    }

    public NodoArbolB(int m, ListaEnlazadaNoOrdenada<EntradaArbolB<K, V>> hijos) {
        this.m = m;
        this.hijos = hijos;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public ListaEnlazadaNoOrdenada<EntradaArbolB<K, V>> getHijos() {
        return hijos;
    }

    public void setHijos(ListaEnlazadaNoOrdenada<EntradaArbolB<K, V>> hijos) {
        this.hijos = hijos;
    }

    @Override
    public String toString() {
        return "NodoArbolB{" + "m=" + m + ", hijos=" + hijos + '}';
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.uner.fcad.ed.arbolesabbyavl;

import ar.edu.uner.fcad.ed.edlineales.ListaEnlazadaNoOrdenada;
import java.util.ArrayList;

/**
 *
 * @author Nacho
 * @param <T>
 */
public class ListaAVL <T extends Comparable<? super T>> {

    protected ListaEnlazadaNoOrdenada<NodoAVL<T>> nodos;
    protected T valorBuscado;

    public ListaAVL(T valor) {
        this.nodos = new ListaEnlazadaNoOrdenada();
        this.valorBuscado = valor;
    }

    /**
     * @return the nodos
     */
    public ListaEnlazadaNoOrdenada<NodoAVL<T>> getNodos() {
        return nodos;
    }

    public NodoAVL<T> getPadreNodoPivote() {
        NodoAVL<T> resultado = null;

        try {
            for (int i = nodos.size() - 1; i >= 0; i--) {
                if (nodos.get(i).factorBalance != 0) {
                    if (i - 1 >= 0) {
                        resultado = nodos.get(i - 1);
                    } else {
                        resultado = null;
                    }
                    break;
                }
            }

        } catch (Exception exc) {

        }

        return resultado;
    }

    public NodoAVL<T> getNodoPivote() {
        NodoAVL<T> resultado = null;
        try {
            for (int i = nodos.size() - 1; i >= 0; i--) {
                if (nodos.get(i).factorBalance != 0) {
                    resultado = nodos.get(i);
                    break;
                }
            }
        } catch (Exception exc) {

        }
        return resultado;
    }

    public NodoAVL<T> getNodoA() {
        NodoAVL<T> nodoA = null;
        NodoAVL<T> nodoB = getNodoPivote();

        NodoAVL<T> hijoIzqB = (NodoAVL<T>) nodoB.getHijoIzquierdo();
        NodoAVL<T> hijoDerB = (NodoAVL<T>) nodoB.getHijoDerecho();

        if (hijoIzqB != null && this.nodos.contains(hijoIzqB)) {
            nodoA = hijoIzqB;
        } else {
            if (hijoDerB != null && this.nodos.contains(hijoDerB)) {
                nodoA = hijoDerB;
            }
        }
        return nodoA;
    }

    public NodoAVL<T> getPadreNodoBuscado() {
        NodoAVL<T> resultado = null;
        ListaEnlazadaNoOrdenada<NodoAVL<T>> lista = getNodoPorValor(valorBuscado);

        try {
            resultado = lista.get(0);
        } catch (Exception exc) {
            resultado = null;
        }

        return resultado;
    }

    public NodoAVL<T> getNodoBuscado() {
        NodoAVL<T> resultado = null;
        
        ListaEnlazadaNoOrdenada<NodoAVL<T>> lista = getNodoPorValor(valorBuscado);

        try {
            resultado = lista.get(1);
        } catch (Exception exc) {
            resultado = null;
        }

        return resultado;
    }

    protected ListaEnlazadaNoOrdenada<NodoAVL<T>> getNodoPorValor(T valor) {
        ListaEnlazadaNoOrdenada<NodoAVL<T>> resultado = new ListaEnlazadaNoOrdenada();

        NodoAVL<T> nodoPadre = null;
        NodoAVL<T> nodoHijo = null;

        try {
            int posicion = nodos.indexOf(new NodoAVL(valor));
            if (posicion >= 0) {
                nodoHijo = nodos.get(posicion);

                if (posicion - 1 >= 0) {
                    nodoPadre = nodos.get(posicion - 1);
                }
            } else {
                nodoPadre = nodos.get(nodos.size() - 1);
            }

            resultado.addToRear(nodoPadre);
            resultado.addToRear(nodoHijo);
            
        } catch (Exception exc) {

        }
        return resultado;
    }
}

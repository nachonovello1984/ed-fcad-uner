/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.uner.fcad.ed.edjerarquicas;

import ar.edu.uner.fcad.ed.edlineales.colas.ColaPorEnlaces;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Usuario
 * @param <T>
 */
public class ArbolHiHdIteradorPorNiveles<T> implements ArbolHiHdIterador<T> {

    private final Iterator<T> iterador;

    public ArbolHiHdIteradorPorNiveles(NodoArbolHiHd<T> raiz) {
        this.iterador = armarRecorrido(raiz).iterator();
    }

    @Override
    public boolean existeSiguiente() {
        return iterador.hasNext();
    }

    @Override
    public T siguiente() throws EDJerarquicasException {
        if(!iterador.hasNext()){
            throw new EDJerarquicasException("No existen más elementos.");
        }
        
        return iterador.next();
    }

    private List<T> armarRecorrido(NodoArbolHiHd<T> raiz) {
        List<T> resultado = new ArrayList();

        try {
            ColaPorEnlaces<NodoArbolHiHd<T>> cola = new ColaPorEnlaces();
            cola.enqueue(raiz);
            while (!cola.isEmpty()) {
                NodoArbolHiHd<T> nodoActual = cola.getFront();
                resultado.add(nodoActual.getValor());

                if (nodoActual.hijoIzquierdo != null) {
                    NodoArbolHiHd<T> nodoHijo = nodoActual.hijoIzquierdo;
                    while (nodoHijo != null) {
                        cola.enqueue(nodoHijo);
                        nodoHijo = nodoHijo.hnoDerecho;
                    }
                }
                cola.dequeue();
            }
        } catch (Exception ex) {
            resultado = new ArrayList();
        }

        return resultado;
    }
}
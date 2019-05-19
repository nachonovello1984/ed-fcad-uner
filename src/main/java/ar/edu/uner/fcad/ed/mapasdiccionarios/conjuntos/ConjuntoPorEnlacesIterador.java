/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.uner.fcad.ed.mapasdiccionarios.conjuntos;

import ar.edu.uner.fcad.ed.edlineales.iteradores.Iterador;
import ar.edu.uner.fcad.ed.edlineales.NodoLista;


/**
 *
 * @author nacho
 * @param <T>
 */
public class ConjuntoPorEnlacesIterador <T> implements Iterador<T>{
    
    private NodoLista<T> nodoActual;
    
    public ConjuntoPorEnlacesIterador(NodoLista<T> nodoInicio){
        this.nodoActual = nodoInicio;
    }

    @Override
    public boolean existeSiguiente() {
        return this.nodoActual.getSiguiente() != null;
    }

    @Override
    public T siguiente() {
        this.nodoActual = this.nodoActual.getSiguiente();
        return this.nodoActual.getElemento();
    }
    
}

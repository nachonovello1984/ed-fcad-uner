/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.uner.fcad.ed.mapasdiccionarios.conjuntos;

import ar.edu.uner.fcad.ed.edlineales.Iterador;
import ar.edu.uner.fcad.ed.edlineales.NodoLista;

/**
 *
 * @author nacho
 * @param <T>
 */
public class ConjuntoPorEnlaces<T> implements ConjuntoInterfaz<T> {

    protected int cantidadNodos;
    protected NodoLista<T> header;

    public ConjuntoPorEnlaces() {
        this.cantidadNodos = 0;
        this.header = new NodoLista(null);
    }

    @Override
    public void insert(T element) {
        if (member(element)) {
            return;
        }

        NodoLista<T> nuevoNodo = new NodoLista(element);
        if (isEmpty()) {
            this.header.setSiguiente(nuevoNodo);
        } else {
            nuevoNodo.setSiguiente(this.header.getSiguiente());
            this.header.setSiguiente(nuevoNodo);
        }
    }

    @Override
    public void delete(T element) throws Exception {

        if (isEmpty()) {
            throw new Exception("El conjunto es vacío.");
        }

        boolean encontrado = false;

        NodoLista<T> nodoAnterior = null;
        NodoLista<T> nodo = this.header.getSiguiente();

        while (nodo.getSiguiente() != null) {

            if (nodo.getElemento().equals(element)) {
                encontrado = true;
                break;
            }

            nodoAnterior = nodo;
            nodo = nodo.getSiguiente();
        }

        if (!encontrado) {
            throw new Exception("El elemento especificado no pertenece al conjunto");
        }

        if (nodoAnterior != null) {
            nodoAnterior.setSiguiente(nodo.getSiguiente());
        } else {
            this.header.setSiguiente(null);
        }
        
        cantidadNodos--;
    }

    @Override
    public boolean isEmpty() {
        return this.header.getSiguiente() == null;
    }

    @Override
    public boolean member(T element) {
        NodoLista<T> nodo = this.header.getSiguiente();

        while (nodo != null) {

            if (nodo.getElemento().equals(element)) {
                return true;
            }

            nodo = nodo.getSiguiente();
        }

        return false;
    }

    @Override
    public ConjuntoInterfaz<T> intersection(ConjuntoInterfaz<T> conjuntoParam) {
        ConjuntoPorEnlaces<T> resultado = new ConjuntoPorEnlaces();

        Iterador<T> iterador = this.iterador();

        while (iterador.existeSiguiente()) {
            T elemento = iterador.siguiente();

            if (conjuntoParam.member(elemento)) {
                resultado.insert(elemento);
            }
        }

        return resultado;
    }

    @Override
    public ConjuntoInterfaz<T> union(ConjuntoInterfaz<T> conjuntoParam) {
        ConjuntoPorEnlaces<T> resultado = new ConjuntoPorEnlaces();

        Iterador<T> iterador = this.iterador();

        while (iterador.existeSiguiente()) {
            T elemento = iterador.siguiente();
            resultado.insert(elemento);
        }
        
        iterador = conjuntoParam.iterador();

        while (iterador.existeSiguiente()) {
            T elemento = iterador.siguiente();
            resultado.insert(elemento);
        }

        return resultado;
    }

    @Override
    public String toString() {
        String resultado = "";

        Iterador<T> iterador = this.iterador();

        while (iterador.existeSiguiente()) {

            resultado += ", " + iterador.siguiente();
        }

        return '{' + resultado.substring(2) + '}';
    }

    @Override
    public Iterador<T> iterador() {
        return new ConjuntoPorEnlacesIterador(this.header);
    }
}

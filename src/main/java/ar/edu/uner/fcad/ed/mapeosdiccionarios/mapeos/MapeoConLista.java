/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.uner.fcad.ed.mapeosdiccionarios.mapeos;

import ar.edu.uner.fcad.ed.edlineales.iteradores.Iterador;
import ar.edu.uner.fcad.ed.edlineales.ListaEnlazadaNoOrdenada;
import ar.edu.uner.fcad.ed.mapeosdiccionarios.conjuntos.ConjuntoPorEnlaces;
import ar.edu.uner.fcad.ed.mapeosdiccionarios.Entrada;
import ar.edu.uner.fcad.ed.mapeosdiccionarios.conjuntos.ConjuntoInterfaz;

/**
 *
 * @author nacho
 * @param <K>
 * @param <V>
 */
public class MapeoConLista<K, V> implements MapeoInterfaz<K, V> {

    protected ListaEnlazadaNoOrdenada<Entrada<K, V>> lista;

    public MapeoConLista() {
        lista = new ListaEnlazadaNoOrdenada();
    }

    @Override
    public int size() {
        return lista.size();
    }

    @Override
    public boolean isEmpty() {
        return lista.isEmpty();
    }

    @Override
    public V get(K key) {
        if (isEmpty()) {
            return null;
        }

        Iterador<Entrada<K, V>> iterador = lista.iterador();

        while (iterador.existeSiguiente()) {
            Entrada<K, V> actual = iterador.siguiente();
            if (actual.getKey().equals(key)) {
                return actual.getValue();
            }
        }

        return null;
    }

    @Override
    public V put(K key, V value) {
        Iterador<Entrada<K, V>> iterador = lista.iterador();

        while (iterador.existeSiguiente()) {
            Entrada<K, V> actual = iterador.siguiente();
            if (actual.getKey().equals(key)) {
                V aux = actual.getValue();
                actual.setValue(value);
                return aux;
            }
        }

        lista.addToRear(new Entrada(key, value));
        return null;
    }

    @Override
    public V remove(K key) {
        
        if (isEmpty()) {
            throw new IllegalStateException ("El mapeo está vacío. No se puede llevar a cabo esta acción");
        }
                
        Iterador<Entrada<K, V>> iterador = lista.iterador();

        while (iterador.existeSiguiente()) {
            Entrada<K, V> actual = iterador.siguiente();
            if (actual.getKey().equals(key)) {
                V resultado = actual.getValue();

                lista.remove(actual);

                return resultado;
            }
        }
        
        throw new IllegalArgumentException ("No se encontró ninguna entrada con la clave especificada.");
    }

    @Override
    public ConjuntoInterfaz<K> keySet() {
        ConjuntoPorEnlaces<K> resultado = new ConjuntoPorEnlaces();

        Iterador<Entrada<K, V>> iterador = lista.iterador();

        while (iterador.existeSiguiente()) {
            Entrada<K, V> entrada = iterador.siguiente();
            resultado.insert(entrada.getKey());
        }

        return resultado;
    }

    @Override
    public ConjuntoInterfaz<V> values() {
        ConjuntoPorEnlaces<V> resultado = new ConjuntoPorEnlaces();

        Iterador<Entrada<K, V>> iterador = lista.iterador();

        while (iterador.existeSiguiente()) {
            Entrada<K, V> entrada = iterador.siguiente();
            resultado.insert(entrada.getValue());
        }

        return resultado;
    }

    @Override
    public ConjuntoInterfaz<Entrada<K, V>> entrySet() {
        ConjuntoPorEnlaces<Entrada<K, V>> resultado = new ConjuntoPorEnlaces();

        Iterador<Entrada<K, V>> iterador = lista.iterador();

        while (iterador.existeSiguiente()) {
            Entrada<K, V> entrada = iterador.siguiente();
            resultado.insert(entrada);
        }

        return resultado;
    }

    @Override
    public String toString() {
        String resultado = "";

        Iterador<Entrada<K, V>> iterador = lista.iterador();

        while (iterador.existeSiguiente()) {
            Entrada<K, V> actual = iterador.siguiente();
            resultado += ", " + actual.toString();
        }

        return '{' + resultado.substring(2) + '}';
    }

}

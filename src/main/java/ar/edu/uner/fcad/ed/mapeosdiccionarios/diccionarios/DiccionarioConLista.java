/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.uner.fcad.ed.mapeosdiccionarios.diccionarios;

import ar.edu.uner.fcad.ed.edlineales.iteradores.Iterador;
import ar.edu.uner.fcad.ed.edlineales.iteradores.Iterable;
import ar.edu.uner.fcad.ed.edlineales.ListaEnlazadaNoOrdenada;
import ar.edu.uner.fcad.ed.mapeosdiccionarios.Entrada;

/**
 *
 * @author nacho
 * @param <K>
 * @param <V>
 */
public class DiccionarioConLista<K, V> implements DiccionarioInterfaz<K, V> {

    protected ListaEnlazadaNoOrdenada<Entrada<K, V>> lista;

    public DiccionarioConLista() {
        this.lista = new ListaEnlazadaNoOrdenada();
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
    public Entrada<K, V> find(K key) {
        if (isEmpty()) {
            return null;
        }

        Iterador<Entrada<K, V>> iterador = lista.iterador();

        while (iterador.existeSiguiente()) {
            Entrada<K, V> actual = iterador.siguiente();
            if (actual.getKey().equals(key)) {
                return actual;
            }
        }

        return null;
    }

    @Override
    public Iterable<Entrada<K, V>> findAll(K key) {
        ListaEnlazadaNoOrdenada<Entrada<K, V>> resultado = new ListaEnlazadaNoOrdenada();

        Iterador<Entrada<K, V>> iterador = lista.iterador();

        while (iterador.existeSiguiente()) {
            Entrada<K, V> entrada = iterador.siguiente();

            if (entrada.getKey().equals(key)) {
                resultado.addToRear(entrada);
            }
        }

        return resultado;
    }

    @Override
    public Entrada<K, V> insert(K key, V value) {
        Entrada<K, V> entrada = new Entrada<K, V>(key, value);
        lista.addToRear(entrada);
        return entrada;
    }

    @Override
    public Entrada<K, V> remove(K key) throws Exception {
        
        if (isEmpty()) {
            throw new Exception ("El mapa está vacío. No se puede llevar a cabo esta acción");
        }
        
        Iterador <Entrada<K, V>> iterador = lista.iterador();
        
        while (iterador.existeSiguiente()) {
            Entrada<K, V> entrada = iterador.siguiente();
            
            if (entrada.getKey().equals(key)) {
                lista.remove(entrada);
                return entrada;
            }
        }
        
        throw new Exception ("No existe ninguna entrada con la clave especificada.");
    }

    @Override
    public Iterable<Entrada<K, V>> entries() {
        ListaEnlazadaNoOrdenada<Entrada<K, V>> resultado = new ListaEnlazadaNoOrdenada();

        Iterador<Entrada<K, V>> iterador = lista.iterador();

        while (iterador.existeSiguiente()) {
            Entrada<K, V> entrada = iterador.siguiente();
            resultado.addToRear(entrada);
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

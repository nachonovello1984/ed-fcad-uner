/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.uner.fcad.ed.mapeosdiccionarios.mapeos;

import ar.edu.uner.fcad.ed.mapeosdiccionarios.Entrada;
import ar.edu.uner.fcad.ed.mapeosdiccionarios.conjuntos.ConjuntoInterfaz;

/**
 *
 * @author nacho
 * @param <K>
 * @param <V>
 */
public interface MapeoInterfaz<K, V> {

    /**
     * Indica la cantidad de entradas que hay en el mapeo.
     *
     * @return
     */
    public int size();

    /**
     * Indica si la estructura está vacía.
     *
     * @return
     */
    public boolean isEmpty();

    /**
     * Devuelve el valor asociado a key.
     *
     * @param key
     * @return
     */
    public V get(K key);

    /**
     * Inserta una nueva entrada clave key y valor value.
     *
     * @param key
     * @param value
     * @return
     */
    public V put(K key, V value);

    /**
     * Remueve la entrada con clave key
     *
     * @param key
     * @return
     */
    public V remove(K key);

    /**
     * Devuelve un conjunto con todas las claves del mapeo.
     *
     * @return
     */
    public ConjuntoInterfaz<K> keySet();

    /**
     * Devuelve todos las valores del mapeo.
     *
     * @return
     */
    public ConjuntoInterfaz<V> values();

    /**
     * Devuelve un conjunto con todas las entradas del mapeo.
     * @return 
     */
    public ConjuntoInterfaz<Entrada<K, V>> entrySet();

    /**
     * Concatena en un String el estado actual de la estructura.
     * @return 
     */
    @Override
    public String toString();
}

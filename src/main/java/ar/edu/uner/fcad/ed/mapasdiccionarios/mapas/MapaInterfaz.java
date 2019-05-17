/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.uner.fcad.ed.mapasdiccionarios.mapas;

import ar.edu.uner.fcad.ed.mapasdiccionarios.Entrada;
import ar.edu.uner.fcad.ed.mapasdiccionarios.conjuntos.ConjuntoInterfaz;

/**
 *
 * @author nacho
 * @param <K>
 * @param <V>
 */
public interface MapaInterfaz <K, V>{

    public int size();

    public boolean isEmpty();
    
    public V get(K key);
    
    public V put(K key, V value);
    
    public V remove(K key) throws Exception;
    
    public ConjuntoInterfaz<K> keySet();
    
    public ConjuntoInterfaz<V> values();
    
    public ConjuntoInterfaz<Entrada<K, V>> entrySet();
    
    @Override
    public String toString();
}

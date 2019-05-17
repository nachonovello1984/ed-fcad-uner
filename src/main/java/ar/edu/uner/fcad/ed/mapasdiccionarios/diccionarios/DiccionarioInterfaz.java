/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.uner.fcad.ed.mapasdiccionarios.diccionarios;

import ar.edu.uner.fcad.ed.mapasdiccionarios.Entrada;

import ar.edu.uner.fcad.ed.edlineales.Iterable;

/**
 *
 * @author nacho
 * @param <K>
 * @param <V>
 */
public interface DiccionarioInterfaz <K, V>{
    public int size();
    
    public boolean isEmpty();
    
    public Entrada<K,V> find(K key);
    
    public Iterable<Entrada<K,V>> findAll(K key);
    
    public Entrada<K, V> insert(K key, V value);
    
    public Entrada<K, V> remove(K key) throws Exception;
    
    public Iterable<Entrada<K, V>> entries();
    
    @Override
    public String toString();
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.uner.fcad.ed.mapeosdiccionarios.conjuntos;

import ar.edu.uner.fcad.ed.edlineales.iteradores.Iterable;

/**
 *
 * @author nacho
 * @param <T>
 */
public interface ConjuntoInterfaz <T> extends Iterable<T>{
    
    public void insert(T element);
    
    public void delete(T element);
    
    public boolean isEmpty();
    
    public boolean member(T element);
    
    public ConjuntoInterfaz<T> intersection(ConjuntoInterfaz<T> conjuntoParam);
    
    public ConjuntoInterfaz<T> union(ConjuntoInterfaz<T> conjuntoParam);
    
    @Override
    public String toString();
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.uner.fcad.ed.edjerarquicas;

/**
 *
 * @author ignnov
 */
public interface ArbolHiHdIterador <T> {
    
    public boolean existeSiguiente();
    
    public T siguiente() throws EDJerarquicasException;
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.uner.fcad.ed.arbolesabbyavl;


/**
 *
 * @author Nacho
 */
public interface NodoABBInterfaz<T> {
    /**
     * @return the valor
     */
    public T getValor();

    /**
     * @param valor the valor to set
     */
    public void setValor(T valor);

    /**
     * @return the hijoIzquierdo
     */
    public NodoABB <T> getHijoIzquierdo();

    /**
     * @param hijoIzquierdo the hijoIzquierdo to set
     */
    public void setHijoIzquierdo(NodoABB <T> hijoIzquierdo);

    /**
     * @return the hijoDerecho
     */
    public NodoABB <T> getHijoDerecho();

    /**
     * @param hijoDerecho the hijoDerecho to set
     */
    public void setHijoDerecho(NodoABB <T> hijoDerecho);
}
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.uner.fcad.ed.edjerarquicas;

/**
 *
 * @author Nacho
 * @param <T>
 */
public class NodoArbolHiHd<T> extends NodoArbol<T> {
    
    protected NodoArbolHiHd<T> hijoIzquierdo;
    protected NodoArbolHiHd<T> hnoDerecho;
        
    public NodoArbolHiHd(T valor){
        super(valor);
        this.etiqueta = ROTULADOR.siguienteEtiqueta();
    }

    public NodoArbolHiHd<T> getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    public void setHijoIzquierdo(NodoArbolHiHd<T> hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    public NodoArbolHiHd<T> getHnoDerecho() {
        return hnoDerecho;
    }

    public void setHnoDerecho(NodoArbolHiHd<T> hnoDerecho) {
        this.hnoDerecho = hnoDerecho;
    }
    
    public boolean tieneHijos(){
        return this.hijoIzquierdo != null;
    }
}

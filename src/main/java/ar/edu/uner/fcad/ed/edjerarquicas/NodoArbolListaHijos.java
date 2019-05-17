package ar.edu.uner.fcad.ed.edjerarquicas;

import ar.edu.uner.fcad.ed.edlineales.ListaEnlazadaNoOrdenada;


/**
 *
 * @author Nacho
 * @param <T>
 */
public class NodoArbolListaHijos<T> extends NodoArbol<T> {
    
    protected ListaEnlazadaNoOrdenada<NodoArbolListaHijos<T>> hijos;
  
    public NodoArbolListaHijos(T valor){
        super(valor);
        this.etiqueta = ROTULADOR.siguienteEtiqueta();
        this.hijos = new ListaEnlazadaNoOrdenada();
    }

    public ListaEnlazadaNoOrdenada<NodoArbolListaHijos<T>> getHijos() {
        return hijos;
    }

    public void setHijos(ListaEnlazadaNoOrdenada<NodoArbolListaHijos<T>> hijos) {
        this.hijos = hijos;
    }
    
    public boolean tieneHijos() {
        return hijos != null && hijos.size() > 0;
    }

    
}

package ar.edu.uner.fcad.ed.arbolesabbyavl;

import ar.edu.uner.fcad.ed.edlineales.iteradores.Iterador;
import ar.edu.uner.fcad.ed.edlineales.ListaEnlazadaNoOrdenada;

/**
 *
 * @author nacho
 * @param <T>
 */
public class ListaEnlazadaNoOrdenadaExt <T> extends ListaEnlazadaNoOrdenada<T>{
    
    public void agregarTodos(ListaEnlazadaNoOrdenada<T> listaParam) {
        Iterador<T> iterador = listaParam.iterador();
        
        while(iterador.existeSiguiente()){
            this.addToRear(iterador.siguiente());
        }
    }
}

package ar.edu.uner.fcad.ed.edjerarquicas;

/**
 *
 * @author Nacho
 * @param <T>
 */
public class NodoArbolApuntadorPadre<T> extends NodoArbol<T>{
    
    protected int etiquetaPadre;
    
    /**
     * Crea un nuevo nodo que conformará parte de un árbol 
     * implementado a través de apuntadores al padre.
     * @param valor es el valor del nodo.
     */
    public NodoArbolApuntadorPadre(T valor){
        super(valor);
        this.etiqueta = ROTULADOR.siguienteEtiqueta();
        this.etiquetaPadre = 0;
    }
    
    /**
     * Devuelve la etiqueta del padre del nodo.
     * @return la etiqueta del padre del nodo.
     */
    public int getEtiquetaPadre() {
        return etiquetaPadre;
    }
    
    /**
     * Establece un nuevo padre para el nodo a través de una nueva etiqueta.
     * @param etiquetaPadre es la etiqueta del nuevo padre del nodo.
     */
    public void setEtiquetaPadre(int etiquetaPadre) {
        this.etiquetaPadre = etiquetaPadre;
    }
}

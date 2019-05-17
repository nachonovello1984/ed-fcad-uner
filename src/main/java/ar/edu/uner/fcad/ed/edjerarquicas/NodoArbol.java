package ar.edu.uner.fcad.ed.edjerarquicas;

/**
 *
 * @author Nacho
 * @param <T>
 */
public abstract class NodoArbol<T> {
    
    protected static final NodoArbolRotulador ROTULADOR = new NodoArbolRotulador(1);

    
    protected T valor;
    protected int etiqueta;
    
    /**
     * Crea un nuevo objeto de tipo NodoArbol con valor igual al pasado por 
     * parámetro.
     * @param valor
     */
    public NodoArbol(T valor){
        this.valor = valor;
    }

    public int getEtiqueta() {
        return etiqueta;
    }
    
    /**
     * Devuelve el valor actual del nodo.
     * @return es el valor que contiene el nodo actualmente.
     */
    public T getValor() {
        return valor;
    }
    /**
     * Establece un nuevo valor para el nodo.
     * @param valor es el nuevo valor del nodo.
     */
    public void setValor(T valor) {
        this.valor = valor;
    }

    /**
     * Indica si dos nodos son iguales. Dos nodos son iguales cuando tienen
     * igual etiqueta.
     * @return devuelve verdadero si los dos nodos tienen igual etiqueta.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final NodoArbol<T> other = (NodoArbol<T>) obj;
        if (this.etiqueta != other.etiqueta) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + this.etiqueta;
        return hash;
    }
    
    @Override
    public String toString(){
        return valor.toString();
    }
}

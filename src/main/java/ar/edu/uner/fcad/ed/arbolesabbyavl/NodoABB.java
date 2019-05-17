package ar.edu.uner.fcad.ed.arbolesabbyavl;


/**
 *
 * @author Nacho
 */
public class NodoABB <T> implements NodoABBInterfaz <T> {
    protected T valor;
    protected NodoABB<T> hijoIzquierdo;
    protected NodoABB<T> hijoDerecho;

    public NodoABB(T valor){
        this.valor = valor;
        this.hijoIzquierdo = null;
        this.hijoDerecho = null;
    }
    
    public T getValor() {
        return this.valor;
    }

    @Override
    public void setValor(T valor) {
        this.valor = valor;
    }

    @Override
    public NodoABB<T> getHijoIzquierdo() {
        return this.hijoIzquierdo;
    }

    @Override
    public void setHijoIzquierdo(NodoABB<T> hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    @Override
    public NodoABB<T> getHijoDerecho() {
        return hijoDerecho;
    }

    @Override
    public void setHijoDerecho(NodoABB<T> hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }

    public boolean getTieneHijoIzquierdo(){
        return this.getHijoIzquierdo() != null;
    }

    public boolean getTieneHijoDerecho(){
        return this.getHijoDerecho() != null;
    }
    
    public int getCantidadHijos() {
        int resultado = 0;
        
        resultado += (this.hijoIzquierdo != null) ? 1 : 0;
        resultado += (this.hijoDerecho != null) ? 1 : 0;

        return resultado;
    }

    @Override
    public boolean equals(Object obj) {
        boolean resultado = false;

        if(obj != null && getClass() == obj.getClass()){
            NodoABB<T> param = (NodoABB<T>) obj;
            T paramValor = (T) param.getValor();
            Comparable<T> thisValor = (Comparable<T>) this.getValor();

            resultado = thisValor.compareTo(paramValor) == 0;
        }

        return resultado;
    }
    
    @Override
    public String toString(){
        return valor.toString();
    }
}

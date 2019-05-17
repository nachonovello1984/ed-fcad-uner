package ar.edu.uner.fcad.ed.edjerarquicas;

/**
 *
 * @author Nacho
 */
public class NodoArbolRotulador {
    protected int proximaEtiqueta;
    
    public NodoArbolRotulador(){
        this.proximaEtiqueta = 0;
    }
    
    public NodoArbolRotulador(int inicio){
        this.proximaEtiqueta = inicio;
    }
    
    public int siguienteEtiqueta(){
        return proximaEtiqueta++;
    }
}

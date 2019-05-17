package ar.edu.uner.fcad.ed.edjerarquicas;

/**
 *
 * @author Nacho
 * @param <T>
 */
public interface InterfazArbol<T> {
    /**
     * Devuelve cierto si el árbol es vacío, y falso en caso contrario.
     * 
     * @return 
     */
    public boolean vacio(); 
    
    /**
     * Devuelve cierto si el árbol está lleno, y falso en caso contrario.
     * 
     * @return 
     */
    public boolean lleno(); 
    
    /**
     * Devuelve el nodo raíz del árbol. Si el árbol está vacío, devuelve null. 
     * 
     * @return 
     */
    public NodoArbol<T> raiz(); 
    
    
    /**
     * Devuelve el padre de "nodo". Si "nodo" es la raíz del árbol devuelve null.
     * Requerimientos: El árbol no está vacío y "nodo" existe.
     * 
     * @param nodo
     * @return 
     * @throws ar.edu.uner.fcad.ed.edjerarquicas.EDJerarquicasException
     */
    public NodoArbol<T> padre(NodoArbol<T> nodo) throws EDJerarquicasException; 
    
    /**
     * Devuelve el nodo hijo más a la izquierda de "nodo". 
     * Si "nodo" no tiene hijos, devuelve null.
     * Requerimientos: El árbol no está vacío y "nodo" existe.
     * 
     * @param nodo
     * @return 
     * @throws ar.edu.uner.fcad.ed.edjerarquicas.EDJerarquicasException
     */
    public NodoArbol<T> hijoIzquierdo(NodoArbol<T> nodo)throws EDJerarquicasException;
    
    /**
     * Devuelve el nodo hermano derecho de "nodo". 
     * Si "nodo" no tiene hermano derecho, devuelve null.
     * 
     * Requerimientos: El árbol está vacío. "nodo" existe.
     * @param nodo
     * @return 
     * @throws ar.edu.uner.fcad.ed.edjerarquicas.EDJerarquicasException
     */
    public NodoArbol<T> hermanoDerecho(NodoArbol<T> nodo) throws EDJerarquicasException; 

    /**
     * Devuelve un objeto de tipo Object con el contenido del nodo en "nodo".
     * Requerimientos: El árbol no está vacío. "nodo" existe
     * 
     * @param nodo
     * @return 
     * @throws ar.edu.uner.fcad.ed.edjerarquicas.EDJerarquicasException
     */
    public T info(NodoArbol<T> nodo) throws EDJerarquicasException;

    /**
     * Añade "nodo" como hijo más a la izquierda de "padre".
     * Si el árbol está vacío, entonces "nodo" es la raíz del árbol.
     * @param padre
     * @param nodo
     * @throws ar.edu.uner.fcad.ed.edjerarquicas.EDJerarquicasException
     */
    public void insertaHijo(NodoArbol<T> padre, NodoArbol<T> nodo)throws EDJerarquicasException;

    /**
     * Añade "nodo" como hermano derecho de "nodoIzquierdo".
     * Requerimientos: El árbol es no vacío. "nodoIzquierdo" existe.
     * 
     * @param nodoIzquierdo
     * @param nodo
     * @throws ar.edu.uner.fcad.ed.edjerarquicas.EDJerarquicasException
     */
    public void insertaHermano(NodoArbol<T> nodoIzquierdo, NodoArbol<T> nodo) throws EDJerarquicasException;
    
    /**
     * Suprime el hijo más a la izquierda de "nodo" y todos sus descendientes.
     * 
     * Requerimientos: El árbol no es vacío. "nodo" existe.
     * 
     * @param nodo
     * @throws ar.edu.uner.fcad.ed.edjerarquicas.EDJerarquicasException
     */
    public void suprimeHijoIzquierdo(NodoArbol<T> nodo) throws EDJerarquicasException;
  
    /**
     * Suprime el hermano a la derecha de "nodo" y todos sus descendientes.
     * 
     * Requerimientos: El árbol no es vacío. "nodo" existe.
     * 
     * @param nodo
     * @throws ar.edu.uner.fcad.ed.edjerarquicas.EDJerarquicasException
     */
    public void suprimeHermanoDerecho(NodoArbol<T> nodo) throws EDJerarquicasException;
    
    /**
     * El árbol es no vacío. "nodo" existe.
     * 
     * Modifica el elemento de "nodo" en el árbol, cambiándolo por el nuevo contenido.
     * 
     * @param nodo
     * @param valor
     * @throws ar.edu.uner.fcad.ed.edjerarquicas.EDJerarquicasException
     */
    public void modifica(NodoArbol<T> nodo, T valor) throws EDJerarquicasException;
                
    /**
     * Devuelve cierto si "nodo" existe, y falso en caso contrario.
     * @param nodo
     * @return 
     */
    public boolean existe(NodoArbol<T> nodo);
    
    /**
     * Transforma el árbol en un String
     * @return 
     */ 
    @Override
    public String toString();
}

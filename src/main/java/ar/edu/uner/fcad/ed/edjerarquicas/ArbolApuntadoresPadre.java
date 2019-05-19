package ar.edu.uner.fcad.ed.edjerarquicas;

import ar.edu.uner.fcad.ed.edlineales.colas.ColaPorEnlaces;
import ar.edu.uner.fcad.ed.edlineales.ListaEnlazadaNoOrdenada;

/**
 *
 * @author Admin
 * @param <T>
 */
public class ArbolApuntadoresPadre<T> implements InterfazArbol<T> {

    public final static int CAPACIDAD = 10;

    protected int cantidadNodos;
    protected NodoArbolApuntadorPadre<T>[] arreglo;

    /**
     * Crea un nuevo Árbol implementado a través de un arreglo de apuntadores al
     * padre con capacidad de 10 nodos.
     *
     * @param clazz
     */
    public ArbolApuntadoresPadre(Class<T> clazz) {
        this.arreglo = new NodoArbolApuntadorPadre[CAPACIDAD];
        this.cantidadNodos = 0;
    }

    /**
     * Devuelve TRUE si el árbol es vacío, y falso en caso contrario.
     *
     * @return
     */
    @Override
    public boolean vacio() {
        return !(this.cantidadNodos > 0);
    }

    /**
     * Devuelve TRUE si el árbol está lleno, y falso en caso contrario.
     *
     * @return
     */
    @Override
    public boolean lleno() {
        return this.cantidadNodos == CAPACIDAD;
    }

    /**
     * Devuelve el nodo raíz del árbol. Si el árbol está vacío, devuelve null. 
     *
     * @return
     */
    @Override
    public NodoArbol<T> raiz() {
        NodoArbolApuntadorPadre<T> resultado = null;

        //Si el árbol no está vacío.
        if (!vacio()) {
            for (NodoArbolApuntadorPadre<T> nodo : arreglo) {
                //obtengo el nodo cuya etiqueta es 0 es decir la raíz
                if (nodo != null && nodo.etiquetaPadre == 0) {
                    resultado = nodo;
                    break;
                }
            }
        }

        return resultado;
    }

    /**
     * Devuelve el padre de nodo. Si nodo es la raíz del árbol devuelve null. El
     * árbol no debe estar vacío y nodo debe existir.
     *
     * @param nodo
     * @return
     * @throws EDJerarquicasException
     */
    @Override
    public NodoArbol<T> padre(NodoArbol<T> nodo) throws EDJerarquicasException {
        NodoArbolApuntadorPadre<T> resultado = null;
        NodoArbolApuntadorPadre<T> nodoAp = getAsNodoArbolApuntadorPadre(nodo);
        int etiquetaResultado = -1;

        //Si el árbol es vacío no se puede llevar a cabo la operación
        if (vacio()) {
            throw new EDJerarquicasException("Árbol vacío");
        }

        //Si no existe el nodo del que se quiere buscar el padre no se puede
        //llevar a cabo la operación.
        if (!existe(nodoAp)) {
            throw new EDJerarquicasException("Nodo no existe en el Árbol");
        }

        //Busco el nodo en el arreglo.
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] != null && arreglo[i].etiqueta == nodoAp.etiqueta) {
                etiquetaResultado = arreglo[i].etiquetaPadre;
                break;
            }
        }

        //Una vez encontrado busco el nodo que tenga etiqueta igual a la etiquetaPadre
        //de nodoAP.
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] != null && arreglo[i].etiqueta == etiquetaResultado) {
                resultado = arreglo[i];
                break;
            }
        }
        return resultado;
    }

    /**
     * Devuelve el nodo hijo más a la izquierda de nodo. Si nodo no tiene hijos,
     * devuelve null. El árbol no está vacío y nodo existe.
     *
     * @param nodo
     * @return
     * @throws EDJerarquicasException
     */
    @Override
    public NodoArbol<T> hijoIzquierdo(NodoArbol<T> nodo) throws EDJerarquicasException {
        NodoArbol<T> resultado = null;
        NodoArbolApuntadorPadre<T> nodoAp = getAsNodoArbolApuntadorPadre(nodo);

        //Si el árbol está vacío no se puede llevar a cabo la operación.
        if (vacio()) {
            throw new EDJerarquicasException("Árbol vacío");
        }

        //Si no existe el nodo del que quiero conocer el hijo izquierdo => no se puede llevar a cabo la operación.
        if (!existe(nodoAp)) {
            throw new EDJerarquicasException("Nodo no existe en el Árbol");
        }

        //De todos los nodos del arreglo busco aquel que tenga como etiquetaPadre
        //la etiqueta de nodoAp.
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] != null && arreglo[i].etiquetaPadre == nodoAp.etiqueta) {
                resultado = arreglo[i];
                break;
            }
        }
        return resultado;
    }

    /**
     * Devuelve el nodo hermano derecho de nodo. Si nodo no tiene hermano
     * derecho, devuelve null. Requerimientos: El árbol está vacío y nodo
     * existe.
     *
     * @param nodo
     * @return
     * @throws EDJerarquicasException
     */
    @Override
    public NodoArbol<T> hermanoDerecho(NodoArbol<T> nodo) throws EDJerarquicasException {
        NodoArbol<T> resultado = null;
        NodoArbolApuntadorPadre<T> nodoAp = getAsNodoArbolApuntadorPadre(nodo);

        //Si el árbol está vacío no se puede llevar a cabo la operación.
        if (vacio()) {
            throw new EDJerarquicasException("Árbol vacío");
        }

        //Si no existe el nodo no se puede llevar a cabo la operación.
        if (!existe(nodoAp)) {
            throw new EDJerarquicasException("Nodo no existe en el Árbol");
        }

        //Busco el nodo que tenga el mismo padre que el nodo pasasdo por parámetro
        //que no sea el mismo nodo que el pasado por parámetro y
        //que esté más a la derecha.
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] != null && arreglo[i].etiquetaPadre == nodoAp.etiquetaPadre
                    && arreglo[i].etiqueta != nodoAp.etiqueta) {
                if (i > getPosicion(nodoAp)) {//esto quiere decir cripac con que las operaciones hermano no están bien definidas.
                    resultado = arreglo[i];
                    break;
                }
            }
        }
        return resultado;
    }

    /**
     * Devuelve un objeto de tipo T con el contenido del nodo. Requerimientos:
     * El árbol no está vacío y nodo debe existir
     *
     * @param nodo
     * @return
     * @throws EDJerarquicasException
     */
    @Override
    public T info(NodoArbol<T> nodo) throws EDJerarquicasException {
        T resultado = null;
        NodoArbolApuntadorPadre<T> nodoAp = getAsNodoArbolApuntadorPadre(nodo);

        //Si el nodo está vacío no se puede llevar a cabo la operación.
        if (vacio()) {
            throw new EDJerarquicasException("Árbol vacío");
        }

        //Si no existe el nodo no se puede llevar a cabo la operación.
        if (!existe(nodoAp)) {
            throw new EDJerarquicasException("Nodo no existe en el Árbol");
        }

        //Busco en el arreglo el nodo que tenga igual etiqueta a la del nodo pasado por parámetro.
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] != null && arreglo[i].equals(nodoAp)) {
                resultado = arreglo[i].valor;
            }
        }

        return resultado;
    }

    /**
     * Añade nodo como hijo más a la izquierda de padre. Si el árbol está vacío,
     * entonces "nodo" es la raíz del árbol. Requerimientos: Si el árbol no está
     * vacío, "padre" debe existir.
     *
     * @param padre
     * @param nodo
     * @throws EDJerarquicasException
     */
    @Override
    public void insertaHijo(NodoArbol<T> padre, NodoArbol<T> nodo) throws EDJerarquicasException {
        NodoArbolApuntadorPadre<T> nodoAp = getAsNodoArbolApuntadorPadre(nodo);
        boolean vacio = vacio();

        //Si no tiene padre tiene que ser la raíz
        if (padre == null) {
            if (!vacio) {
                throw new EDJerarquicasException("Árbol no vacío. La operación no se puede llevar a cabo");
            }
            nodoAp.etiquetaPadre = 0;
            arreglo[0] = nodoAp;
        } else {

            //Si especificó un padre me fijo que exista y si puedo agregar un nodo a la estructura.
            NodoArbolApuntadorPadre<T> padreAp = getAsNodoArbolApuntadorPadre(padre);

            //Si el árbol está vacío no se puede llevar a cabo la operación.
            if (vacio) {
                throw new EDJerarquicasException("Árbol vacío. La operación no se puede llevar a cabo");
            }

            //Si el árbol está lleno no se puede llevar a cabo la operación.
            if (lleno()) {
                throw new EDJerarquicasException("Árbol lleno. La operación no se puede llevar a cabo");
            }

            //Si el padre especificado no existe en el árbol no se puede llevar a cabo la operación.
            if (!existe(padreAp)) {
                throw new EDJerarquicasException("El Nodo Padre no existe en el Árbol");
            }

            //Asigno como etiquetaPadre la etiqueta del padre especificado.
            nodoAp.etiquetaPadre = padreAp.etiqueta;

            //lo asigno a la primera posición libre que encuentro.
            arreglo[posLibre()] = nodoAp;
        }

        this.cantidadNodos++;
    }

    /**
     * Añade nodo como hermano derecho de nodoIzquierdo. Requerimientos: El
     * árbol es no vacío. nodoIzquierdo existe.
     *
     * @param nodoIzquierdo
     * @param nodo
     * @throws EDJerarquicasException
     */
    @Override
    public void insertaHermano(NodoArbol<T> nodoIzquierdo, NodoArbol<T> nodo) throws EDJerarquicasException {
        NodoArbolApuntadorPadre<T> izqAp = getAsNodoArbolApuntadorPadre(nodoIzquierdo);
        NodoArbolApuntadorPadre<T> nodoAp = getAsNodoArbolApuntadorPadre(nodo);

        //Si el árbol está vacío no se puede llevar a cabo la operación.
        if (vacio()) {
            throw new EDJerarquicasException("Árbol vacío");
        }

        //Si el árbol está lleno no se puede llevar a cabo la operación.
        if (lleno()) {
            throw new EDJerarquicasException("Árbol lleno. La operación no se puede llevar a cabo");
        }

        //Si no existe el hermano izquierdo no se puede llevar a cabo la operación.
        if (!existe(izqAp)) {
            throw new EDJerarquicasException("Nodo Izquierdo no existe en el Árbol");
        }

        //Si nodoIzquierdo es la raíz no puedo insertar un hermano.
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] != null && arreglo[i].equals(izqAp)) {
                if (arreglo[i].etiquetaPadre == 0) {
                    throw new EDJerarquicasException("Nodo no existe en el Árbol");
                }
            }
        }

        //Busco el padre de los nodos.
        NodoArbolApuntadorPadre<T> padre = (NodoArbolApuntadorPadre<T>) (padre(izqAp));

        //Establezco como etiquetaPadre la etiqueta del padre.
        nodoAp.etiquetaPadre = padre.etiqueta;

        //Asgino el nodo a la primera posición disponible.
        arreglo[posLibre()] = nodoAp;

        this.cantidadNodos++;
    }

    /**
     * Borra el subárbol del cual raiz es el nodo raíz Requerimientos: el árbol
     * no debe estar vacío y raiz debe existir.
     *
     * @param raiz
     * @throws EDJerarquicasException
     */
    private void suprimeArbol(NodoArbol<T> raiz) throws EDJerarquicasException {

        if (vacio()) {
            throw new EDJerarquicasException("Árbol vacío");
        }

        if (!existe(raiz)) {
            throw new EDJerarquicasException("Nodo que se intenta eliminar no existe en el Árbol");
        }

        ListaEnlazadaNoOrdenada<NodoArbolApuntadorPadre<T>> eliminar = new ListaEnlazadaNoOrdenada();
        ColaPorEnlaces<NodoArbolApuntadorPadre<T>> cola = new ColaPorEnlaces();
        NodoArbolApuntadorPadre<T> nodoAp = (NodoArbolApuntadorPadre<T>) raiz;

        try {
            cola.enqueue(nodoAp);
            NodoArbolApuntadorPadre<T> nodoActual = (NodoArbolApuntadorPadre<T>) cola.getFront();
            while (nodoActual != null) {
                eliminar.addToRear(nodoActual);

                NodoArbolApuntadorPadre<T> hijoNodoActual = (NodoArbolApuntadorPadre<T>) this.hijoIzquierdo(nodoActual);
                while (hijoNodoActual != null) {
                    cola.enqueue(hijoNodoActual);
                    hijoNodoActual = (NodoArbolApuntadorPadre<T>) this.hermanoDerecho(hijoNodoActual);
                }
                cola.dequeue();
                nodoActual = (NodoArbolApuntadorPadre<T>) cola.getFront();
            }

            for (int i = 0; i < eliminar.size(); i++) {
                for (int j = 0; j < arreglo.length; j++) {
                    if (((NodoArbolApuntadorPadre<T>) eliminar.get(i)).equals(arreglo[j])) {
                        arreglo[j] = null;
                        this.cantidadNodos--;
                    }
                }
            }

        } catch (Exception ex) {
            throw new EDJerarquicasException(ex.getMessage());
        }
    }

    /**
     * Suprime el hijo más a la izquierda de "nodo" y todos sus descendientes.
     * Requerimientos: El árbol no es vacío. nodo existe.
     *
     * @param nodo
     * @throws EDJerarquicasException
     */
    @Override
    public void suprimeHijoIzquierdo(NodoArbol<T> nodo) throws EDJerarquicasException {
        suprimeArbol(hijoIzquierdo(nodo));
    }

    /**
     * Suprime el hermano a la derecha de "nodo" y todos sus descendientes.
     * Requerimientos: El árbol no es vacío. "nodo" existe.
     *
     * @param nodo
     * @throws EDJerarquicasException
     */
    @Override
    public void suprimeHermanoDerecho(NodoArbol<T> nodo) throws EDJerarquicasException {
        suprimeArbol(hermanoDerecho(nodo));
    }

    /**
     * Modifica el elemento de nodo en el árbol, cambiándolo por el nuevo
     * contenido. El árbol es no vacío. "nodo" existe.
     *
     * @param nodo
     * @param valor
     * @throws EDJerarquicasException
     */
    @Override
    public void modifica(NodoArbol<T> nodo, T valor) throws EDJerarquicasException {
        NodoArbolApuntadorPadre<T> nodoAp = getAsNodoArbolApuntadorPadre(nodo);
        if (!existe(nodoAp)) {
            throw new EDJerarquicasException("Nodo Izquierdo no existe en el Árbol");
        }

        //Busco nodoAp en el array
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] != null && arreglo[i].equals(nodoAp)) {
                arreglo[i].valor = valor;
                break;
            }
        }
    }

    /**
     * Devuelve cierto si "nodo" existe, y falso en caso contrario.
     */
    @Override
    public boolean existe(NodoArbol<T> nodo) {
        try {
            NodoArbolApuntadorPadre<T> nodoAp = getAsNodoArbolApuntadorPadre(nodo);

            //Si el árbol no está vacío...
            if (vacio()) {
                return false;
            }

            //Busco el nodo en el array.
            for (int i = 0; i < arreglo.length; i++) {
                if (arreglo[i] != null && arreglo[i].equals(nodoAp)) {
                    return true;
                }
            }
        } catch (EDJerarquicasException exc) {
            return false;
        }
        return false;
    }

    @Override
    public String toString() {
        String resultado = "";

        if (vacio()) {
            return resultado;
        }

        ColaPorEnlaces<NodoArbol<T>> cola = new ColaPorEnlaces();

        try {
            cola.enqueue(this.raiz());
            NodoArbolApuntadorPadre<T> nodoActual = (NodoArbolApuntadorPadre<T>) cola.getFront();
            while (nodoActual != null) {
                NodoArbolApuntadorPadre<T> hijoNodoActual = (NodoArbolApuntadorPadre<T>) this.hijoIzquierdo(nodoActual);

                while (hijoNodoActual != null) {
                    cola.enqueue(hijoNodoActual);
                    hijoNodoActual = (NodoArbolApuntadorPadre<T>) this.hermanoDerecho(hijoNodoActual);
                }

                resultado += "[" + nodoActual.getValor() + "] ";
                cola.dequeue();
                nodoActual = (NodoArbolApuntadorPadre<T>) cola.getFront();
            }
        } catch (EDJerarquicasException ex) {
            resultado = "";
        }
        
        return resultado;
    }

    /**
     * Devuelve la primer posición libre del arreglo
     *
     * @return
     */
    private int posLibre() {
        int resultado = -1;
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] == null) {
                resultado = i;
                break;
            }
        }
        return resultado;
    }

    /**
     * Indica la posición donde se encuentra ubicado el nodo pasado por
     * parámetro
     *
     * @param nodo
     * @return
     */
    private int getPosicion(NodoArbolApuntadorPadre<T> nodo) {
        int resultado = 0;
        for (int i = 0; i < arreglo.length; i++) {
            if (nodo.equals(arreglo[i])) {
                resultado = i;
            }
        }
        return resultado;
    }

    /**
     *
     * @param nodo
     * @return
     * @throws EDJerarquicasException
     */
    private NodoArbolApuntadorPadre<T> getAsNodoArbolApuntadorPadre(NodoArbol<T> nodo) throws EDJerarquicasException {
        NodoArbolApuntadorPadre<T> resultado = null;

        try {
            resultado = (NodoArbolApuntadorPadre<T>) nodo;
        } catch (Exception exc) {
            throw new EDJerarquicasException("El nodo no es de tipo NodoHiHd");
        }

        return resultado;
    }
}

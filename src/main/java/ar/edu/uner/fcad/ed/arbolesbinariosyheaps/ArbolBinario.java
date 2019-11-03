package ar.edu.uner.fcad.ed.arbolesbinariosyheaps;

import ar.edu.uner.fcad.ed.edlineales.colas.ColaPorEnlaces;
import ar.edu.uner.fcad.ed.edlineales.iteradores.Iterador;

/**
 * Estructura de Datos
 *
 * @author Nacho
 * @param <T>
 */
public class ArbolBinario<T> implements ArbolBinarioInterfaz<T> {

    protected NodoArbolBinario<T> raiz;

    public ArbolBinario() {
        this.raiz = null;
    }

    /**
     * Indica si la estructura está vacía.
     *
     * @return
     */
    @Override
    public boolean vacio() {
        return raiz == null;
    }

    /**
     * Devuelve el valor del nodo raíz del árbol
     *
     * @return
     */
    @Override
    public T raiz() {
        T resultado = null;

        if (!vacio()) {
            resultado = raiz.valor;
        }

        return resultado;
    }

    /**
     * Indica si el nodo cuyo valor de clave es pasado por parámetro existe en
     * el árbol.
     *
     * @param nodo
     * @return
     */
    @Override
    public boolean existe(NodoArbolBinario<T> nodo) {
        return obtenerNodo(nodo, raiz) != null;
    }

    /**
     * Busca desde la raíz un nodo que almacene un elemento cuyo valor de clave
     * coincida con el pasado por parámetro.
     *
     * @param valor
     * @return
     */
    protected NodoArbolBinario<T> obtenerNodo(T valor) {
        return obtenerNodo(new NodoArbolBinario(valor), raiz);
    }

    /**
     * Busca utilizando un enfoque recursivo y primero en profundidad el nodo
     * que almacene un elemento cuyo valor de clave coincida con el de
     * nodoParam.
     *
     * @param nodoParam
     * @param nodoOrigen
     * @return
     */
    protected NodoArbolBinario<T> obtenerNodo(NodoArbolBinario<T> nodoParam,
            NodoArbolBinario<T> nodoOrigen) {
        //Si la clave del elemento del nodo en el que estoy parado coincide 
        //con el de nodoParam => encontré el nodo que estaba buscando
        if (nodoOrigen.equals(nodoParam)) {
            return nodoOrigen;
        }

        NodoArbolBinario<T> resultado = null;

        //Si el nodo que estoy visitando tiene un subárbol a la izquierda, voy
        //al hijo izquierdo
        if (nodoOrigen.tieneHijoIzquierdo()) {
            resultado = obtenerNodo(nodoParam, nodoOrigen.hijoIzquierdo);
        }

        //Si el nodo que estoy visitando tiene un subárbol a la izquierda, voy
        //al hijo izquierdo
        if (resultado == null && nodoOrigen.tieneHijoDerecho()) {
            resultado = obtenerNodo(nodoParam, nodoOrigen.hijoDerecho);
        }

        return resultado;
    }

    /**
     * Devuelve el valor del nodo cuya clave se pasa por parámetro.
     *
     * @param valor
     * @return
     */
    @Override
    public T get(T valor) {
        T resultado = null;
        NodoArbolBinario<T> nodo = obtenerNodo(valor);

        if (nodo != null) {
            resultado = nodo.valor;
        }

        return resultado;
    }

    /**
     * Agrega al árbol el nodo hijo como hijo izquierdo o derecho según el valor
     * del parámetro esHijoIzquierdo.
     *
     * @param padre
     * @param hijo
     * @throws Exception
     */
    private void agregarHijo(NodoArbolBinario<T> padre,
            NodoArbolBinario<T> hijo,
            boolean esHijoIzquierdo) throws Exception {
        boolean vacio = vacio();

        if (vacio && padre != null) {
            throw new Exception("Árbol vacío y padre != null");
        }

        if (!vacio) {
            if (padre == null) {
                throw new Exception("Árbol no vacío y padre == null");
            }

            //Verifico si nodoPadre existe en el árbol
            NodoArbolBinario<T> nodoPadre = obtenerNodo(padre.getValor());
            if (nodoPadre == null) {
                throw new Exception("Árbol no vacío y padre no existe");
            }

            //Verifico si el nodo padre ya tiene un hijo izquierdo
            if ((esHijoIzquierdo && nodoPadre.tieneHijoIzquierdo())
                    || (!esHijoIzquierdo && nodoPadre.tieneHijoDerecho())) {
                throw new Exception("El nodo padre ya tiene un hijo");
            }

            //Si el nodo a insertar ya existe en el árbol
            if (existe(hijo)) {
                throw new Exception("El nodo a insertar ya existe en el árbol");
            }

            if (esHijoIzquierdo) {
                nodoPadre.hijoIzquierdo = hijo;
            } else {
                nodoPadre.hijoDerecho = hijo;
            }
        } else {
            raiz = hijo;
        }
    }

    /**
     * Agrega al árbol el nodo hijo como hijo izquierdo de su padre.
     *
     * @param padre
     * @param hijo
     * @throws Exception
     */
    @Override
    public void agregarHijoIzquierdo(NodoArbolBinario<T> padre, NodoArbolBinario<T> hijo) throws Exception {
        agregarHijo(padre, hijo, true);
    }

    /**
     * Agrega al árbol el nodo hijo como hijo derecho de su padre.
     *
     * @param padre
     * @param hijo
     * @throws Exception
     */
    @Override
    public void agregarHijoDerecho(NodoArbolBinario<T> padre, NodoArbolBinario<T> hijo) throws Exception {
        agregarHijo(padre, hijo, false);
    }

    /**
     * Elimina un nodo del árbol.
     *
     * @param valor
     * @throws java.lang.Exception arroja excepción cuando el árbol está vacío o
     * el nodo que se quiere borrar no existe.
     */
    @Override
    public void remove(T valor) throws Exception {
        NodoArbolBinario<T> nodoABorrar = obtenerNodo(valor);

        if (nodoABorrar == null) {
            throw new Exception("No existe en el árbol un nodo con valor igual al especificado");
        }

        NodoArbolBinario<T> nodoPadre = padre(nodoABorrar);

        borrarNodo(nodoPadre, nodoABorrar);
    }

    protected void borrarNodo(NodoArbolBinario<T> nodoPadre, NodoArbolBinario<T> nodoABorrar) throws Exception {
        int cantidadHijos = nodoABorrar.getCantidadHijos();
        boolean esHijoIzquierdo = nodoPadre != null && nodoPadre.esHijoIzquierdo(nodoABorrar);

        //Caso 1 de Eliminación Arbol Binario => El nodo a eliminar no tiene hijos.
        if (cantidadHijos == 0) {
            //Si nodoPadre es null => nodoABorrar es raíz del árbol
            if (nodoPadre == null) {
                raiz = null;
                return;
            }

            if (esHijoIzquierdo) {
                nodoPadre.hijoIzquierdo = null;
            } else {
                nodoPadre.hijoDerecho = null;
            }

            return;
        }

        //Caso 2 de Eliminación de Arbol Binario => El nodo a eliminar tiene 1 hijo.
        if (cantidadHijos == 1) {
            
            //Me quedo con la referencia al hijo
            NodoArbolBinario<T> hijo = (nodoABorrar.hijoIzquierdo != null) ? nodoABorrar.hijoIzquierdo : nodoABorrar.hijoDerecho;
            
            //Si nodoPadre es null => nodoABorrar es raíz del árbol
            if (nodoPadre == null) {
                raiz = hijo;
            } else {
                if (esHijoIzquierdo) { //Si es hijo izquierdo de nodoPadre...
                    nodoPadre.hijoIzquierdo = hijo;
                } else { //Si es hijo derecho de nodoPadre...
                    nodoPadre.hijoDerecho = hijo;
                }
            }
            return;
        }

        //Caso 3 de Eliminación de Arbol Binario => El nodo a eliminar tiene 2 hijos.
        if (cantidadHijos == 2) {
            NodoArbolBinario<T> reemplazo = buscarReemplazoEliminacion();

            remove(reemplazo.valor);

            nodoABorrar.setValor(reemplazo.valor);
        }
    }

    /**
     * Concatena en una única cadena de caracteres los nodos del árbol.
     *
     * @return
     */
    @Override
    public String toString() {
        String resultado = "";

        ColaPorEnlaces<NodoArbolBinario<T>> cola = new ColaPorEnlaces();
        cola.enqueue(raiz);

        while (!cola.isEmpty()) {
            NodoArbolBinario<T> nodoActual = cola.getFront();
            resultado += ", " + nodoActual.toString();

            if (nodoActual.tieneHijoIzquierdo()) {
                cola.enqueue(nodoActual.hijoIzquierdo);
            }

            if (nodoActual.tieneHijoDerecho()) {
                cola.enqueue(nodoActual.hijoDerecho);
            }

            cola.dequeue();
        }

        resultado = resultado.substring(2);

        return resultado;
    }

    /**
     * Recorre el árbol en anchura buscando un nodo que tenga como hijo izquierdo
     * o derecho al nodo pasado como parámetro.
     * @param nodo
     * @return 
     */
    public NodoArbolBinario<T> padre(NodoArbolBinario<T> nodo) {
        NodoArbolBinario<T> resultado = null;

        //Agrego la raíz a una cola
        ColaPorEnlaces<NodoArbolBinario<T>> cola = new ColaPorEnlaces();
        cola.enqueue(raiz);

        busqueda:
        {
            while (!cola.isEmpty()) {
                NodoArbolBinario<T> nodoActual = cola.getFront();

                //Si nodoActual tiene un hijo izquierdo... 
                if (nodoActual.tieneHijoIzquierdo()) {
                    //Si el hijoIzquierdo es el nodo del que estoy 
                    //buscando el padre...
                    if (nodoActual.hijoIzquierdo.equals(nodo)) {
                        resultado = nodoActual;
                        break busqueda;
                    }

                    cola.enqueue(nodoActual.hijoIzquierdo);
                }

                //Si nodoActual tiene un hijo derecho... 
                if (nodoActual.tieneHijoDerecho()) {
                    //Si el hijoDerecho es el nodo del que estoy 
                    //buscando el padre...
                    if (nodoActual.hijoDerecho.equals(nodo)) {
                        resultado = nodoActual;
                        break busqueda;
                    }

                    cola.enqueue(nodoActual.hijoDerecho);
                }

                cola.dequeue();
            }
        };

        return resultado;
    }

    /**
     * Establece como reemplazo el nodo más a la izquierda que se pueda
     * encontrar del árbol
     */
    private NodoArbolBinario<T> buscarReemplazoEliminacion() {
        NodoArbolBinario<T> resultado = raiz;

        while (resultado != null && resultado.getCantidadHijos() > 0) {
            if (resultado.tieneHijoIzquierdo()) {
                resultado = resultado.hijoIzquierdo;
            } else {
                resultado = resultado.hijoDerecho;
            }
        }

        return resultado;
    }

    /**
     * Devuelve un iterador en preorden sobre la estructura
     * @return 
     */
    public Iterador<T> iteradorPreorden() {
        return new IteradorEnPreorden(raiz);
    }
}

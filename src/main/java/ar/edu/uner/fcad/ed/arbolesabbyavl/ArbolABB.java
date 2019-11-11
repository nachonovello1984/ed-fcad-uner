/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.uner.fcad.ed.arbolesabbyavl;

import ar.edu.uner.fcad.ed.edlineales.iteradores.Iterador;

/**
 *
 * @author Nacho
 * @param <T>
 */
public class ArbolABB <T extends Comparable<? super T>> implements ArbolABBInterfaz<T>, ArbolABBRecorridosInterfaz<T> {

    protected NodoABB<T> raiz;

    public ArbolABB() {
        this.raiz = null;
    }

    protected NodoABB<T> getRaiz() {
        return raiz;
    }

    /**
     * Indica si el árbol está vacío.
     * @return
     */
    @Override
    public boolean isEmpty() {
        return raiz == null;
    }

    private ArbolABBResultadoBusqueda<T> buscarNodos(T valor) {
        ArbolABBResultadoBusqueda<T> resultado = new ArbolABBResultadoBusqueda();

        NodoABB<T> nodoAuxPadre = null;
        NodoABB<T> nodoAux = raiz;

        while (nodoAux != null) {
            if (valor.compareTo(nodoAux.valor) == 0) {
                break;
            } else {
                if (valor.compareTo(nodoAux.valor) < 0) {
                    nodoAuxPadre = nodoAux;
                    nodoAux = nodoAux.hijoIzquierdo;
                } else {
                    nodoAuxPadre = nodoAux;
                    nodoAux = nodoAux.hijoDerecho;
                }
            }
        }

        resultado.setPadre(nodoAuxPadre);
        resultado.setNodoBuscado(nodoAux);

        return resultado;
    }

    /**
     * Indica si existe en el árbol un nodo con igual valor que el
     * que se indica por parámetro.
     * @param valor
     * @return
     */
    @Override
    public boolean exists(T valor) {
        ArbolABBResultadoBusqueda<T> nodos = buscarNodos(valor);
        return nodos.getNodoBuscado() != null;
    }

    /**
     * Devuelve el valor del nodo cuya clave se especifica por
     * parámetro.
     * @param valor
     * @return
     */
    @Override
    public T get(T valor) {
        T resultado = null;
        ArbolABBResultadoBusqueda<T> nodos = buscarNodos(valor);

        if (nodos.getNodoBuscado() != null) {
            resultado = nodos.getNodoBuscado().valor;
        }

        return resultado;
    }

    /**
     * Agrega un nuevo nodo al árbol cumpliendo las reglas de árbol
     * binario y de búsqueda.
     * @param valor
     * @throws java.lang.Exception arroja excepción cuando ya existe un
     * nodo con igual valor al que se quiere agregar.
     */
    @Override
    public void add(T valor) throws Exception {
        if (isEmpty()) {
            raiz = new NodoABB(valor);
        } else {
            ArbolABBResultadoBusqueda<T> nodos = buscarNodos(valor);
            NodoABB<T> nodoPadre = nodos.getPadre();
            NodoABB<T> nodoBuscado = nodos.getNodoBuscado();

            if (nodoPadre == null) {
                throw new Exception("Error! No existe nodo padre");
            }

            if (nodoBuscado != null) {
                throw new Exception("Ya existe un elemento en el árbol con igual valor");
            }

            if (valor.compareTo(nodoPadre.valor) > 0) {
                nodoPadre.hijoDerecho = new NodoABB(valor);
            } else {
                nodoPadre.hijoIzquierdo = new NodoABB(valor);
            }
        }
    }

    private NodoABB<T> buscarMayorEntreMenores(NodoABB<T> raizSubArbol) {
        NodoABB<T> resultado = null;
        NodoABB<T> nodoActual = raizSubArbol.hijoIzquierdo;

        while (nodoActual != null) {
            resultado = nodoActual;
            nodoActual = nodoActual.hijoDerecho;
        }

        return resultado;
    }

    /**
     * Elimina un nodo del árbol.
     * @param valor
     * @throws java.lang.Exception arroja excepción cuando el árbol está vacío o
     * el nodo que se quiere borrar no existe.
     */
    @Override
    public void remove(T valor) throws Exception {
        ArbolABBResultadoBusqueda<T> nodos = buscarNodos(valor);
        NodoABB<T> nodoPadre = nodos.getPadre();
        NodoABB<T> nodoABorrar = nodos.getNodoBuscado();

        if (nodoABorrar == null) {
            throw new Exception("No existe en el árbol un nodo con valor igual al especificado");
        }

        borrarNodo(nodoPadre, nodoABorrar);
    }

    protected void borrarNodo(NodoABB<T> nodoPadre, NodoABB<T> nodoABorrar) throws Exception {
        int cantidadHijos = nodoABorrar.getCantidadHijos();
        boolean esHijoIzquierdo = (nodoPadre != null) ? nodoABorrar.valor.compareTo(nodoPadre.valor) < 0 : false;

        //Caso eliminación ABB 1. El nodo a eliminar es nodo hoja.
        if (cantidadHijos == 0) {
            if (nodoPadre != null) {
                if (esHijoIzquierdo) {
                    nodoPadre.hijoIzquierdo = null;
                } else {
                    nodoPadre.hijoDerecho = null;
                }
            } else {
                raiz = null;
            }
        }

        //Caso de eliminación ABB 2. El nodo a eliminar tiene un hijo
        if (cantidadHijos == 1) {
            if (nodoPadre != null) {
                if (esHijoIzquierdo) {
                    nodoPadre.hijoIzquierdo = (nodoABorrar.hijoIzquierdo != null) ? nodoABorrar.hijoIzquierdo : nodoABorrar.hijoDerecho;
                } else {
                    nodoPadre.hijoDerecho = (nodoABorrar.hijoIzquierdo != null) ? nodoABorrar.hijoIzquierdo : nodoABorrar.hijoDerecho;
                }
            } else {
                if (esHijoIzquierdo) {
                    raiz = (nodoABorrar.hijoIzquierdo != null) ? nodoABorrar.hijoIzquierdo : nodoABorrar.hijoDerecho;
                } else {
                    raiz = (nodoABorrar.hijoIzquierdo != null) ? nodoABorrar.hijoIzquierdo : nodoABorrar.hijoDerecho;
                }
            }
        }

        //Caso de eliminación ABB 3. El nodo a eliminar tiene 2 hijos.
        if (cantidadHijos == 2) {
            NodoABB<T> mayorMenores = buscarMayorEntreMenores(nodoABorrar);

            remove(mayorMenores.valor);

            nodoABorrar.setValor(mayorMenores.valor);
        }
    }

    /**
     * Transforma el árbol en un String disponiendo los nodos de cada nivel en
     * una línea
     * @return
     */
    @Override
    public String toString() {
        String resultado = "";

        try {
            Iterador<T> iterador = iteradorPorNiveles();
            while (iterador.existeSiguiente()) {
                resultado += ", " + iterador.siguiente().toString();
            }

            if (resultado.length() > 0) {
                resultado = resultado.substring(2);
            }
        } catch (Exception exc) {
            resultado = "";
        }

        return resultado;
    }

    @Override
    public Iterador<T> iteradorPorNiveles() throws Exception {
        if (isEmpty()) {
            throw new Exception("Arbol vacío");
        }

        Iterador<T> resultado = new ArbolABBIteratorNiveles(this);
        return resultado;
    }

    @Override
    public Iterador<T> iteradorEnPreOrden() throws Exception {
        if (isEmpty()) {
            throw new Exception("Arbol vacío");
        }

        Iterador<T> resultado = new ArbolABBIteratorPreorden(this);
        return resultado;
    }

    @Override
    public Iterador<T> iteradorEnInOrden() throws Exception {
        if (isEmpty()) {
            throw new Exception("Arbol vacío");
        }

        Iterador<T> resultado = new ArbolABBIteradorInOrden(this);
        return resultado;
    }

    @Override
    public Iterador<T> iteradorEnPosOrden() throws Exception {
        if (isEmpty()) {
            throw new Exception("Arbol vacío");
        }
        
        Iterador<T> resultado = new ArbolABBIteradorPosOrden(this);
        return resultado;
    }
}

package ar.edu.uner.fcad.ed.arbolesabbyavl;

import ar.edu.uner.fcad.ed.edlineales.iteradores.Iterador;

/**
 *
 * @author Nacho
 * @param <T>
 */
public class ArbolABB<T extends Comparable<? super T>> implements ArbolABBInterfaz<T>, ArbolABBRecorridosInterfaz<T> {

    protected NodoABB<T> raiz;

    public ArbolABB() {
        this.raiz = null;
    }

    protected NodoABB<T> getRaiz() {
        return raiz;
    }

    /**
     * Indica si el árbol está vacío.
     *
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
            if (valor.compareTo(nodoAux.getValor()) == 0) {
                break;
            } else {
                if (valor.compareTo(nodoAux.getValor()) < 0) {
                    nodoAuxPadre = nodoAux;
                    nodoAux = nodoAux.getHijoIzquierdo();
                } else {
                    nodoAuxPadre = nodoAux;
                    nodoAux = nodoAux.getHijoDerecho();
                }
            }
        }

        resultado.setPadre(nodoAuxPadre);
        resultado.setNodoBuscado(nodoAux);

        return resultado;
    }

    /**
     * Indica si existe en el árbol un nodo con igual valor que el que se indica
     * por parámetro.
     *
     * @param valor
     * @return
     */
    @Override
    public boolean exists(T valor) {
        ArbolABBResultadoBusqueda<T> nodos = buscarNodos(valor);
        return nodos.getNodoBuscado() != null;
    }

    /**
     * Devuelve el valor del nodo cuya clave se especifica por parámetro.
     *
     * @param valor
     * @return
     */
    @Override
    public T get(T valor) {
        T resultado = null;
        ArbolABBResultadoBusqueda<T> nodos = buscarNodos(valor);

        if (nodos.getNodoBuscado() != null) {
            resultado = nodos.getNodoBuscado().getValor();
        }

        return resultado;
    }

    /**
     * Agrega un nuevo nodo al árbol cumpliendo las reglas de árbol binario y de
     * búsqueda.
     *
     * @param valor
     */
    @Override
    public void add(T valor) {
        if (isEmpty()) {
            raiz = new NodoABB(valor);
        } else {
            ArbolABBResultadoBusqueda<T> nodos = buscarNodos(valor);
            NodoABB<T> nodoPadre = nodos.getPadre();
            NodoABB<T> nodoBuscado = nodos.getNodoBuscado();

            if (nodoPadre == null) {
                throw new IllegalArgumentException("No existe nodo padre");
            }

            if (nodoBuscado != null) {
                throw new IllegalArgumentException("Ya existe un elemento en el árbol con igual valor");
            }

            if (valor.compareTo(nodoPadre.getValor()) > 0) {
                nodoPadre.setHijoDerecho(new NodoABB(valor));
            } else {
                nodoPadre.setHijoIzquierdo(new NodoABB(valor));
            }
        }
    }

    private NodoABB<T> buscarMayorEntreMenores(NodoABB<T> raizSubArbol) {
        NodoABB<T> resultado = null;
        NodoABB<T> nodoActual = raizSubArbol.getHijoIzquierdo();

        while (nodoActual != null) {
            resultado = nodoActual;
            nodoActual = nodoActual.getHijoDerecho();
        }

        return resultado;
    }

    /**
     * Elimina un nodo del árbol.
     *
     * @param valor
     * @throws java.lang.Exception arroja excepción cuando el árbol está vacío o
     * el nodo que se quiere borrar no existe.
     */
    @Override
    public void remove(T valor) {
        ArbolABBResultadoBusqueda<T> nodos = buscarNodos(valor);
        NodoABB<T> nodoPadre = nodos.getPadre();
        NodoABB<T> nodoABorrar = nodos.getNodoBuscado();

        if (nodoABorrar == null) {
            throw new IllegalArgumentException("No existe en el árbol un nodo con valor igual al especificado");
        }

        borrarNodo(nodoPadre, nodoABorrar);
    }

    protected void borrarNodo(NodoABB<T> nodoPadre, NodoABB<T> nodoABorrar) {
        int cantidadHijos = nodoABorrar.getCantidadHijos();
        boolean esHijoIzquierdo = (nodoPadre != null) ? nodoABorrar.getValor().compareTo(nodoPadre.getValor()) < 0 : false;

        //Caso eliminación ABB 1. El nodo a eliminar es nodo hoja.
        if (cantidadHijos == 0) {
            if (nodoPadre != null) {
                if (esHijoIzquierdo) {
                    nodoPadre.setHijoIzquierdo(null);
                } else {
                    nodoPadre.setHijoDerecho(null);
                }
            } else {
                raiz = null;
            }
        }

        //Caso de eliminación ABB 2. El nodo a eliminar tiene un hijo
        if (cantidadHijos == 1) {
            if (nodoPadre != null) {
                if (esHijoIzquierdo) {
                    nodoPadre.setHijoIzquierdo(((nodoABorrar.getHijoIzquierdo()) != null) ? nodoABorrar.getHijoIzquierdo() : nodoABorrar.getHijoDerecho());
                } else {
                    nodoPadre.setHijoDerecho((nodoABorrar.getHijoIzquierdo() != null) ? nodoABorrar.getHijoIzquierdo() : nodoABorrar.getHijoDerecho());
                }
            } else {
                if (esHijoIzquierdo) {
                    raiz = (nodoABorrar.tieneHijoIzquierdo()) ? nodoABorrar.getHijoIzquierdo() : nodoABorrar.getHijoDerecho();
                } else {
                    raiz = (nodoABorrar.tieneHijoDerecho()) ? nodoABorrar.getHijoIzquierdo() : nodoABorrar.getHijoDerecho();
                }
            }
        }

        //Caso de eliminación ABB 3. El nodo a eliminar tiene 2 hijos.
        if (cantidadHijos == 2) {
            NodoABB<T> mayorMenores = buscarMayorEntreMenores(nodoABorrar);

            remove(mayorMenores.getValor());

            nodoABorrar.setValor(mayorMenores.getValor());
        }
    }

    /**
     * Transforma el árbol en un String disponiendo los nodos de cada nivel en
     * una línea
     *
     * @return
     */
    @Override
    public String toString() {
        String resultado = "";

        Iterador<T> iterador = iteradorPorNiveles();
        while (iterador.existeSiguiente()) {
            resultado += ", " + iterador.siguiente().toString();
        }

        if (resultado.length() > 0) {
            resultado = resultado.substring(2);
        }

        return resultado;
    }

    @Override
    public Iterador<T> iteradorPorNiveles() {
        if (isEmpty()) {
            throw new IllegalStateException("Arbol vacío");
        }

        Iterador<T> resultado = new ArbolABBIteratorNiveles(this);
        return resultado;
    }

    @Override
    public Iterador<T> iteradorEnPreOrden() {
        if (isEmpty()) {
            throw new IllegalStateException("Arbol vacío");
        }

        Iterador<T> resultado = new ArbolABBIteratorPreorden(this);
        return resultado;
    }

    @Override
    public Iterador<T> iteradorEnInOrden() {
        if (isEmpty()) {
            throw new IllegalStateException("Arbol vacío");
        }

        Iterador<T> resultado = new ArbolABBIteradorInOrden(this);
        return resultado;
    }

    @Override
    public Iterador<T> iteradorEnPosOrden() {
        if (isEmpty()) {
            throw new IllegalStateException("Arbol vacío");
        }

        Iterador<T> resultado = new ArbolABBIteradorPosOrden(this);
        return resultado;
    }
}

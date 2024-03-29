/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.uner.fcad.ed.arbolesbinariosyheaps;

import ar.edu.uner.fcad.ed.edlineales.colas.ColaPorEnlaces;
import ar.edu.uner.fcad.ed.edlineales.iteradores.Iterador;

/**
 *
 * @author Nacho
 * @param <T>
 */
public class Heap <T extends Comparable<T>>
        extends ArbolBinario<T> 
        implements HeapInterfaz<T> {

    protected int cantidadNodos;
    protected NodoHeap<T> ultimoNodo;

    public Heap() {
        super();
        this.cantidadNodos = 0;
        this.ultimoNodo = null;
    }

    @Override
    public void remove(T valor) {
        throw new UnsupportedOperationException("Operación no soportada");
    }

    @Override
    public void agregarHijoDerecho(NodoArbolBinario<T> padre, NodoArbolBinario<T> hijo) {
        throw new UnsupportedOperationException("Operación no soportada");
    }

    @Override
    public void agregarHijoIzquierdo(NodoArbolBinario<T> padre, NodoArbolBinario<T> hijo) {
        throw new UnsupportedOperationException("Operación no soportada");
    }

    @Override
    public Iterador<T> iteradorPreorden() {
        throw new UnsupportedOperationException("Operación no soportada");
    }

    @Override
    public T get(T valor) {
        throw new UnsupportedOperationException("Operación no soportada");
    }

    /**
     * Dado un valor de clave busca el nodo en el árbol haciendo un recorrido
     * en anchura
     * @param valor
     * @return 
     */
    protected ArbolBinarioResultadoBusqueda<T> buscarNodos(T valor) {
        ArbolBinarioResultadoBusqueda<T> resultado = new ArbolBinarioResultadoBusqueda();

        ColaPorEnlaces<NodoHeap<T>> cola = new ColaPorEnlaces();
        cola.enqueue((NodoHeap<T>) raiz);

        while (!cola.isEmpty()) {
            NodoHeap<T> nodoAux = cola.getFront();

            if (valor.compareTo(nodoAux.valor) == 0) {
                resultado.setNodoBuscado(nodoAux);
                break;
            } else {
                if (nodoAux.tieneHijoIzquierdo()) {
                    cola.enqueue((NodoHeap<T>) nodoAux.hijoIzquierdo);
                }

                if (nodoAux.tieneHijoDerecho()) {
                    cola.enqueue((NodoHeap<T>) nodoAux.hijoDerecho);
                }
            }

            cola.dequeue();
        }

        return resultado;
    }

    /**
     * Busca el padre del próximo nodo a insertar
     * @return 
     */
    private NodoHeap<T> getProximoPadre() {
        NodoHeap<T> resultado = ultimoNodo;

        while ((resultado != raiz) && (resultado.padre.hijoIzquierdo != resultado)) {
            resultado = resultado.padre;
        }

        if (resultado != raiz) {
            if (resultado.padre.hijoDerecho == null) {
                resultado = resultado.padre;
            } else {
                resultado = (NodoHeap<T>) resultado.padre.hijoDerecho;
                while (resultado.hijoIzquierdo != null) {
                    resultado = (NodoHeap<T>) resultado.hijoIzquierdo;
                }
            }
        } else {
            while (resultado.hijoIzquierdo != null) {
                resultado = (NodoHeap<T>) resultado.hijoIzquierdo;
            }

        }

        return resultado;
    }

    /**
     * Ubica el nuevo nodo insertado en la posición correcta en relación a 
     * sus ancestros.
     */
    private void heapAdd() {
        T valorAux;

        NodoHeap<T> siguienteNodo = ultimoNodo;
        while (siguienteNodo != raiz
                && siguienteNodo.valor.compareTo(siguienteNodo.padre.valor) < 0) {
            valorAux = siguienteNodo.valor;
            siguienteNodo.valor = siguienteNodo.padre.valor;
            siguienteNodo.padre.valor = valorAux;
            siguienteNodo = siguienteNodo.padre;
        }
    }

    /**
     * Indica si la estructura está vacía o no.
     * @return 
     */
    @Override
    public boolean isEmpty() {
        return this.raiz == null;
    }

    /**
     * Indica si el valor de clave pasado por parámetro existe en la estructura.
     * @param valor
     * @return 
     */
    public boolean exists(T valor) {
        return buscarNodos(valor).getNodoBuscado() != null;
    }

    /**
     * Agrega un nuevo nodo al Heap con el valor pasado por parámetro.
     * Se hacen las actualizaciones de referencias para preservar la condición
     * de Heap Mínimo
     * @param valor
     */
    @Override
    public void addElement(T valor) {
        NodoHeap<T> nuevoNodo = new NodoHeap(valor);

        if (this.isEmpty()) {
            this.raiz = nuevoNodo;
        } else {

            NodoHeap<T> nodoPadre = getProximoPadre();
            if (!nodoPadre.tieneHijoIzquierdo()) {
                nodoPadre.hijoIzquierdo = nuevoNodo;
            } else {
                nodoPadre.hijoDerecho = nuevoNodo;
            }

            nuevoNodo.padre = nodoPadre;
        }
        this.ultimoNodo = nuevoNodo;
        this.cantidadNodos++;
        if (cantidadNodos > 1) {
            heapAdd();
        }
    }

    /**
     * Calcula el nuevo último nodo de la estructura.
     * @return 
     */
    private NodoHeap<T> getNuevoUltimoNodo() {
        NodoHeap<T> resultado = ultimoNodo;

        while ((resultado != raiz) && (resultado.padre.hijoIzquierdo == resultado)) {
            resultado = resultado.padre;
        }

        if (resultado != raiz) {
            resultado = (NodoHeap<T>) resultado.padre.hijoIzquierdo;
        }

        while (resultado.getHijoDerecho() != null) {
            resultado = (NodoHeap<T>) resultado.hijoDerecho;
        }

        return resultado;
    }

    /**
     * Preserva la condición de Heap Mínimo ubicando el nodo reemplazo en el 
     * lugar correcto.
     */
    private void heapifyRemove() {
        T temp;
        NodoHeap<T> nodo = (NodoHeap<T>) raiz;
        NodoHeap<T> izq = (NodoHeap<T>) nodo.hijoIzquierdo;
        NodoHeap<T> der = (NodoHeap<T>) nodo.hijoDerecho;
        NodoHeap<T> siguiente;

        if ((izq == null) && (der == null)) {
            siguiente = null;
        } else {
            if (izq == null) {
                siguiente = der;
            } else {
                if (der == null) {
                    siguiente = izq;
                } else {
                    if (izq.valor.compareTo(der.valor) < 0) {
                        siguiente = izq;
                    } else {
                        siguiente = der;
                    }
                }
            }
        }

        while ((siguiente != null) && (siguiente.valor.compareTo(nodo.valor) < 0)) {
            temp = nodo.valor;
            nodo.valor = siguiente.valor;
            siguiente.valor = temp;
            nodo = siguiente;
            izq = (NodoHeap<T>) nodo.hijoIzquierdo;
            der = (NodoHeap<T>) nodo.hijoDerecho;
            if ((izq == null) && (der == null)) {
                siguiente = null;
            } else {
                if (izq == null) {
                    siguiente = der;
                } else {
                    if (der == null) {
                        siguiente = izq;
                    } else {
                        if (izq.valor.compareTo(der.valor) < 0) {
                            siguiente = izq;
                        } else {
                            siguiente = der;
                        }
                    }
                }
            }
        }
    }

    /**
     * Quita el nodo ubicado en la raíz del árbol buscando su reemplazo para
     * que prevalezca la condición de Heap Mínimo.
     * @return
     */
    @Override
    public T removeMin() {

        if (isEmpty()) {
            throw new IllegalStateException("El montículo/cúmulo está vacío");
        }

        T resultado = findMin();

        if (this.cantidadNodos == 1) {
            this.raiz = null;
            this.ultimoNodo = null;
        } else {
            //Obtengo un siguiente ultimoNodo.
            NodoHeap<T> proximoUltimo = getNuevoUltimoNodo();
            //Elimino ultimoNodo.
            if (ultimoNodo.padre.hijoIzquierdo == ultimoNodo) {
                ultimoNodo.padre.hijoIzquierdo = null;
            } else {
                ultimoNodo.padre.hijoDerecho = null;
            }

            this.raiz.valor = ultimoNodo.valor;
            this.ultimoNodo = proximoUltimo;
            heapifyRemove();
        }

        this.cantidadNodos--;
        return resultado;
    }

    /**
     * Devuelve el valor de la raíz
     * @return 
     */
    @Override
    public T findMin() {
        T resultado = null;

        if (!isEmpty()) {
            resultado = raiz.valor;
        }

        return resultado;
    }
}

/*
 * ArbolListaHijos.java
 *
 * Created on 8 de octubre de 2008, 09:28
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package ar.edu.uner.fcad.ed.edjerarquicas;

import ar.edu.uner.fcad.ed.edlineales.colas.ColaPorEnlaces;
import ar.edu.uner.fcad.ed.edlineales.iteradores.IteradorListaEnlazada;
import ar.edu.uner.fcad.ed.edlineales.ListaEnlazadaNoOrdenada;

/**
 *
 * @author ignnov
 * @param <T>
 */
public class ArbolListaHijos<T> implements InterfazArbol<T> {

    protected ListaEnlazadaNoOrdenada<NodoArbolListaHijos<T>> lista;

    public ArbolListaHijos() {
        this.lista = new ListaEnlazadaNoOrdenada();
    }

    /**
     * Devuelve cierto si el árbol es vacío, y falso en caso contrario.
     *
     * @return
     */
    @Override
    public boolean vacio() {
        return this.lista.isEmpty();
    }

    /**
     * Devuelve cierto si el árbol está lleno, y falso en caso contrario.
     *
     * @return
     */
    @Override
    public boolean lleno() {
        return false;
    }

    /**
     * Devuelve el nodo raíz del árbol. Si el árbol está vacío, devuelve null. 
     *
     * @return
     */
    @Override
    public NodoArbol<T> raiz() {
        NodoArbol<T> resultado = null;

        if (!vacio()) {
            try {
                resultado = lista.get(0);
            } catch (Exception exc) {

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
        NodoArbol<T> resultado = null;
        NodoArbolListaHijos<T> nodoParam = null;

        if (vacio()) {
            throw new EDJerarquicasException("La operación no se puede realizar. El árbol está vacío");
        }

        if (!existe(nodo)) {
            throw new EDJerarquicasException("La operación no se puede realizar. El nodo especificado no forma parte del árbol");
        }

        busqueda:
        {
            //Si no lo puedo referenciar con una referencia de tipo NodoListaHijos...
            //entonces arrojo una Excepción.
            try {
                nodoParam = getAsNodoArbolListaHijos(nodo);

                IteradorListaEnlazada<NodoArbolListaHijos<T>> iterador = (IteradorListaEnlazada<NodoArbolListaHijos<T>>) lista.iterador();
                while (iterador.existeSiguiente()) {
                    NodoArbolListaHijos<T> nodoActual = iterador.siguiente();
                    IteradorListaEnlazada<NodoArbolListaHijos<T>> iteradorHijos = (IteradorListaEnlazada<NodoArbolListaHijos<T>>) nodoActual.getHijos().iterador();
                    while (iteradorHijos.existeSiguiente()) {
                        NodoArbolListaHijos<T> nodoHijo = iteradorHijos.siguiente();
                        if (nodoHijo.equals(nodoParam)) {
                            resultado = nodoActual;
                            break busqueda;
                        }
                    }
                }
            } catch (Exception exc) {
                throw new EDJerarquicasException(exc.getMessage());
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
        NodoArbolListaHijos<T> nodoParam = null;

        if (vacio()) {
            throw new EDJerarquicasException("La operación no se puede realizar. El árbol está vacío");
        }

        if (!existe(nodo)) {
            throw new EDJerarquicasException("La operación no se puede realizar. El nodo especificado no forma parte del árbol");
        }

        try {

            //Si no lo puedo referenciar con una referencia de tipo NodoListaHijos...
            //entonces arrojo una Excepción.
            nodoParam = getAsNodoArbolListaHijos(nodo);
            IteradorListaEnlazada<NodoArbolListaHijos<T>> iterador = (IteradorListaEnlazada<NodoArbolListaHijos<T>>) lista.iterador();
            while (iterador.existeSiguiente()) {
                NodoArbolListaHijos<T> nodoActual = iterador.siguiente();
                if (nodoActual.equals(nodoParam)) {
                    resultado = (nodoActual.hijos != null) ? nodoActual.hijos.get(0) : null;
                }
            }

        } catch (Exception exc) {
            throw new EDJerarquicasException(exc.getMessage());
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
        NodoArbolListaHijos<T> padre = null;
        NodoArbolListaHijos<T> nodoParam = null;
        NodoArbolListaHijos<T> nodoAnterior = null;

        try {

            padre = getAsNodoArbolListaHijos(padre(nodo));

            if (padre.tieneHijos()) {
                NodoArbolListaHijos<T> nodoBuscado = null;

                IteradorListaEnlazada<NodoArbolListaHijos<T>> iterador = (IteradorListaEnlazada<NodoArbolListaHijos<T>>) padre.hijos.iterador();
                while (iterador.existeSiguiente()) {
                    NodoArbolListaHijos<T> nodoActual = iterador.siguiente();
                    nodoAnterior = nodoBuscado;
                    nodoBuscado = nodoActual;

                    if (nodoAnterior.equals(nodoParam)) {
                        break;
                    }
                }

                resultado = nodoBuscado;
            }
        } catch (EDJerarquicasException exc) {
            throw exc;
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

        if (vacio()) {
            throw new EDJerarquicasException("La operación no se puede realizar. El árbol está vacío");
        }

        if (!existe(nodo)) {
            throw new EDJerarquicasException("La operación no se puede realizar. El nodo especificado no forma parte del árbol");
        }

        try {
            for (int i = 0; i < lista.size(); i++) {
                NodoArbolListaHijos<T> nodoActual = lista.get(i);
                if (nodoActual.equals(nodo)) {
                    resultado = nodoActual.getValor();
                    break;
                }
            }
        } catch (Exception exc) {
            throw new EDJerarquicasException("Error al intentar acceder a una posición inexistente.");
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
        NodoArbolListaHijos<T> padreParam = null;
        NodoArbolListaHijos<T> nodoParam = null;

        if (vacio() && padre != null) {
            throw new EDJerarquicasException("La operación no se puede realizar. El árbol está vacío. 'padre' no forma parte de la estructura");
        }

        if (!vacio() && padre == null) {
            throw new EDJerarquicasException("La operación no se puede realizar. El árbol no está vacío y no se ha especificado un nodo padre");
        }

        if (padre != null && !existe(padre)) {
            throw new EDJerarquicasException("La operación no se puede realizar. El nodo especificado como padre no forma parte del árbol");
        }

        try {

            //Si no lo puedo referenciar con una referencia de tipo NodoListaHijos...
            //entonces arrojo una Excepción.
            padreParam = getAsNodoArbolListaHijos(padre);
            nodoParam = getAsNodoArbolListaHijos(nodo);

            lista.addToRear(nodoParam);
            if (padreParam != null) {
                padreParam.hijos.addToRear(nodoParam);
            }

        } catch (Exception exc) {
            throw new EDJerarquicasException(exc.getMessage());
        }
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
        if (vacio()) {
            throw new EDJerarquicasException("La operación no se puede realizar. El árbol está vacío");
        }

        if (!existe(nodoIzquierdo)) {
            throw new EDJerarquicasException("La operación no se puede realizar. El nodo izquierdo no forma parte del árbol.");
        }

        try {

            NodoArbolListaHijos<T> nodoParam = getAsNodoArbolListaHijos(nodo);
            NodoArbolListaHijos<T> nodoPadre = getAsNodoArbolListaHijos(padre(nodoIzquierdo));
            nodoPadre.hijos.addToRear(nodoParam);
            lista.addToRear(nodoParam);

        } catch (Exception exc) {
            throw new EDJerarquicasException(exc.getMessage());
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
        NodoArbolListaHijos<T> nodoParam = null;

        if (vacio()) {
            throw new EDJerarquicasException("La operación no se puede realizar. El árbol está vacío");
        }

        if (!existe(nodo)) {
            throw new EDJerarquicasException("La operación no se puede realizar. El nodo especificado no forma parte del árbol");
        }

        try {
            for (int i = 0; i < lista.size(); i++) {
                NodoArbolListaHijos<T> nodoActual = lista.get(i);
                if (nodoActual.equals(nodo)) {
                    nodoParam = nodoActual;
                    break;
                }
            }

            if (nodoParam.tieneHijos()) {
                lista.remove(nodoParam.hijos.get(0));
                nodoParam.hijos.remove(0);
            }

        } catch (Exception exc) {
            throw new EDJerarquicasException(exc.getMessage());
        }
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
        try {
            NodoArbolListaHijos<T> nodoEliminar = getAsNodoArbolListaHijos(this.hermanoDerecho(nodo));
            NodoArbolListaHijos<T> padre = getAsNodoArbolListaHijos(this.padre(nodo));

            padre.hijos.remove(nodoEliminar);
            lista.remove(nodoEliminar);

        } catch (Exception ex) {
            throw new EDJerarquicasException(ex.getMessage());
        }
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
        if (vacio()) {
            throw new EDJerarquicasException("La operación no se puede realizar. El árbol está vacío");
        }

        if (!existe(nodo)) {
            throw new EDJerarquicasException("La operación no se puede realizar. El nodo especificado no forma parte del árbol");
        }

        nodo.setValor(valor);
    }

    /**
     * Devuelve cierto si "nodo" existe, y falso en caso contrario.
     */
    @Override
    public boolean existe(NodoArbol<T> nodo) {
        boolean resultado = false;

        try {
            NodoArbolListaHijos<T> nodoParam = getAsNodoArbolListaHijos(nodo);

            IteradorListaEnlazada<NodoArbolListaHijos<T>> iterador = (IteradorListaEnlazada<NodoArbolListaHijos<T>>) lista.iterador();
            while (iterador.existeSiguiente()) {
                NodoArbolListaHijos<T> nodoActual = iterador.siguiente();
                resultado = nodoActual.equals(nodoParam);

                if (resultado) {
                    break;
                }
            }
        } catch (Exception exc) {
            resultado = false;
        }

        return resultado;
    }

    /**
     * Transforma una referencia de tipo NodoArbol<T> a una referencia
     * NodoArbolListaHijos<T>
     *
     * @param nodo
     * @return
     * @throws Exception
     */
    private NodoArbolListaHijos<T> getAsNodoArbolListaHijos(NodoArbol<T> nodo) throws EDJerarquicasException {
        NodoArbolListaHijos<T> resultado = null;

        try {

            resultado = (NodoArbolListaHijos<T>) nodo;

        } catch (Exception exc) {
            throw new EDJerarquicasException("El nodo no se puede convertir a un NodoArbolListaHijos");
        }

        return resultado;
    }

    @Override
    public String toString() {
        String resultado = "";

        if (vacio()) {
            return resultado;
        }

        try {
            ColaPorEnlaces<NodoArbolListaHijos<T>> cola = new ColaPorEnlaces();
            cola.enqueue(lista.get(0));

            while (!cola.isEmpty()) {
                NodoArbolListaHijos<T> nodoActual = cola.getFront();

                resultado += "[" + nodoActual.getValor() + "] ";

                if (nodoActual.tieneHijos()) {
                    IteradorListaEnlazada<NodoArbolListaHijos<T>> iteradorHijos = (IteradorListaEnlazada<NodoArbolListaHijos<T>>) nodoActual.hijos.iterador();
                    while (iteradorHijos.existeSiguiente()) {
                        NodoArbolListaHijos<T> nodoHijo = iteradorHijos.siguiente();
                        cola.enqueue(nodoHijo);
                    }
                }

                cola.dequeue();
            }

        } catch (Exception exc) {
            resultado = "";
        }

        return resultado;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.uner.fcad.ed.edlineales;

/**
 *
 * @author Nacho
 * @param <T>
 */
public class ListaEnlazadaOrdenada 
        <T extends Comparable<? super T>>
        implements ListaOrdenada<T>, Iterable<T> {

    protected NodoLista<T> header;

    public ListaEnlazadaOrdenada() {
        this.header = new NodoLista(null);
    }

    /**
     * Agrega un elemento en su posición
     *
     * @param element
     * @throws Exception
     */
    @Override
    public void add(T element) throws Exception {
        NodoLista<T> nuevoNodo = new NodoLista(element);

        if (isEmpty()) {
            this.header.siguiente = nuevoNodo;
        } else {
            NodoLista<T> previo = ((NodoListaBusqueda<T>) getNodoPorElemento(element)).nodoAnterior;
            if (previo != null) {
                nuevoNodo.siguiente = previo.siguiente;
                previo.siguiente = nuevoNodo;
            } else {
                nuevoNodo.siguiente = this.header.siguiente;
                this.header.siguiente = nuevoNodo;
            }
        }
    }

    /**
     * Elimina y devuelve el primer elemento de la lista
     *
     * @return
     */
    @Override
    public T removeFirst() {

        if (isEmpty()) {
            return null;
        }

        NodoLista<T> nodoAux = this.header.siguiente;
        T resultado = nodoAux.elemento;
        this.header.siguiente = nodoAux.siguiente;

        return resultado;
    }

    /**
     * Elimina y devuelve el último elemento de la lista
     *
     * @return
     */
    @Override
    public T removeLast() {
        NodoListaBusqueda<T> nodosLista = getUltimos2Nodos();
        NodoLista<T> anteUltimoNodo = nodosLista.nodoAnterior;
        NodoLista<T> ultimoNodo = nodosLista.nodoActual;

        if (anteUltimoNodo != null) {
            anteUltimoNodo.siguiente = null;
        } else {
            this.header.siguiente = null;
        }

        return ultimoNodo.elemento;
    }

    /**
     * Elimina y devuelve el elemento especificado de la lista
     *
     * @param element
     * @return
     * @throws Exception
     */
    @Override
    public T remove(T element) throws Exception {
        NodoListaBusqueda<T> nodosLista = getNodoPorElemento(element);
        NodoLista<T> nodoPrevio = nodosLista.nodoAnterior;
        NodoLista<T> nodoBuscado = nodosLista.nodoActual;

        if (nodoBuscado == null) {
            throw new Exception("El elemento especificado no forma parte de la estructura");
        }

        if (nodoPrevio != null) {
            nodoPrevio.siguiente = nodoBuscado.siguiente;
        } else {
            this.header.siguiente = nodoBuscado.siguiente;
        }

        return nodoBuscado.elemento;
    }

    /**
     * Devuelve una referencia al elemento especificado de la lista
     *
     * @return
     */
    @Override
    public T first() {

        if (isEmpty()) {
            return null;
        }

        return header.siguiente.elemento;
    }

    /**
     * Devuelve el elemento ubicado en el nodo ubicado en la posición indicada
     * por el parámetro position. Arroja excepción cuando position es inválido.
     *
     * @param position
     * @return
     * @throws java.lang.Exception
     */
    @Override
    public T get(int position) throws Exception {
        if (position < 0 || position > size()) {
            throw new Exception("Parámetro position es inválido. ");
        }

        NodoLista<T> nodoActual = header.siguiente;
        for (int i = 0; i < position; i++) {
            nodoActual = nodoActual.siguiente;
        }

        return nodoActual.elemento;
    }

    @Override
    public void set(T element, int position) throws Exception {
        if (position < 0 || position > size()) {
            throw new Exception("Parámetro position es inválido.");
        }

        NodoLista<T> nodoActual = header.siguiente;
        for (int i = 0; i < position; i++) {
            nodoActual = nodoActual.siguiente;
        }

        nodoActual.elemento = element;
    }

    /**
     * Devuelve una referencia al último elmeento de la lista
     *
     * @return
     */
    @Override
    public T last() {
        if (isEmpty()) {
            return null;
        }

        NodoListaBusqueda<T> nodosLista = getUltimos2Nodos();
        return nodosLista.nodoActual.elemento;
    }

    /**
     * Devuelve true si esta lista contiene el elemento especificado
     *
     * @param target
     * @return
     */
    @Override
    public boolean contains(T target) {
        return indexOf(target) >= 0;
    }

    /**
     * Devuelve la posición en la lista del elemento pasado por parámetro.
     *
     * @param target
     * @return
     */
    @Override
    public int indexOf(T target) {

        if (isEmpty()) {
            return -1;
        }

        int resultado = -1;
        int indiceActual = -1;

        NodoLista<T> nodoActual = header;
        do {

            nodoActual = nodoActual.siguiente;
            indiceActual++;

            if (nodoActual.elemento.equals(target)) {
                resultado = indiceActual;
                break;
            }

        } while (nodoActual.siguiente != null);

        return resultado;
    }

    /**
     * Devuelve true si esta lista no contiene ningún elemento
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return this.header.siguiente == null;
    }

    /**
     * Devuelve el número de elementos de la lista
     *
     * @return
     */
    @Override
    public int size() {
        int resultado = 0;
        NodoLista nodoActual = header.siguiente;

        while (nodoActual != null) {
            resultado++;
            nodoActual = nodoActual.siguiente;
        }

        return resultado;
    }

    /**
     * Devuelve el nodo cuyo elemento coincide con el pasado por parámetro y su
     * nodo antecesor.
     *
     * @param elemento
     * @return
     */
    private NodoListaBusqueda<T> getNodoPorElemento(T elemento) {
        boolean encontrado = false;

        NodoLista<T> nodoAnterior = null;
        NodoLista<T> nodoActual = header.siguiente;

        while (nodoActual != null) {
            int compare = nodoActual.elemento.compareTo(elemento);
            if (compare < 0) {
                nodoAnterior = nodoActual;
                nodoActual = nodoActual.siguiente;
            } else {
                encontrado = compare == 0;
                break;
            }
        }

        NodoListaBusqueda<T> resultado = new NodoListaBusqueda();
        resultado.nodoAnterior = nodoAnterior;
        resultado.nodoActual = (encontrado) ? nodoActual : null;

        return resultado;
    }

    /**
     * Obtiene los dos últimos nodos de la lista y los retorna en un array.
     *
     * @return
     */
    private NodoListaBusqueda getUltimos2Nodos() {
        NodoLista nodoAnterior = null;
        NodoLista nodoActual = header.siguiente;

        while (nodoActual.siguiente != null) {
            nodoAnterior = nodoActual;
            nodoActual = nodoActual.siguiente;
        }

        NodoListaBusqueda<T> resultado = new NodoListaBusqueda();

        resultado.setNodoAnterior(nodoAnterior);
        resultado.setNodoActual(nodoActual);

        return resultado;
    }

    /**
     * Devuelve una representación de la lista en forma de cadena de caracteres
     */
    @Override
    public String toString() {
        String resultado = "";

        if (isEmpty()) {
            return resultado;
        }

        NodoLista<T> nodoActual = this.header.siguiente;
        while (nodoActual != null) {
            resultado += ", " + nodoActual.toString();
            nodoActual = nodoActual.siguiente;
        }

        if (resultado.length() > 0) {
            resultado = resultado.substring(2);
        }

        return resultado;
    }

    @Override
    public Iterador<T> iterador() {
        return new IteradorListaEnlazada(this.header);
    }
}

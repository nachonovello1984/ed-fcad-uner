package ar.edu.uner.fcad.ed.edlineales;

import ar.edu.uner.fcad.ed.edlineales.iteradores.Iterable;
import ar.edu.uner.fcad.ed.edlineales.iteradores.Iterador;
import ar.edu.uner.fcad.ed.edlineales.iteradores.IteradorListaEnlazada;

/**
 *
 * @author Nacho
 * @param <T>
 */
public class ListaEnlazadaNoOrdenada<T>
        implements ListaNoOrdenada<T>, Iterable<T> {

    protected NodoLista<T> header;

    public ListaEnlazadaNoOrdenada() {
        this.header = new NodoLista(null);
    }

    /**
     * Añade el elemento especificado al principio de la lista
     *
     * @param element
     */
    @Override
    public void addToFront(T element) {
        NodoLista<T> nuevoNodo = new NodoLista(element);

        if (isEmpty()) {
            this.header.siguiente = nuevoNodo;
        } else {
            nuevoNodo.siguiente = this.header.siguiente;
            this.header.siguiente = nuevoNodo;
        }
    }

    /**
     * Añade el elemento especificado al final de la lista
     *
     * @param element
     */
    @Override
    public void addToRear(T element) {
        NodoLista<T> nuevoNodo = new NodoLista(element);

        if (isEmpty()) {
            this.header.siguiente = nuevoNodo;
        } else {
            NodoLista<T> ultimoNodo = ((NodoListaBusqueda<T>) getUltimos2Nodos()).nodoActual;
            ultimoNodo.siguiente = nuevoNodo;
        }
    }

    /**
     * Añade el elemento especificado después del elemento especificado como
     * objetivo
     *
     * @param element
     * @param target
     */
    @Override
    public void addAfter(T element, T target) {
        NodoLista<T> nuevoNodo = new NodoLista(element);
        NodoLista<T> targetNodo = ((NodoListaBusqueda<T>) getNodoPorElemento(target)).nodoActual;

        if (targetNodo == null) {
            throw new IllegalArgumentException("La operación no se puede realizar. El elemento especificado no existe");
        }

        if (targetNodo.siguiente != null) {
            nuevoNodo.siguiente = targetNodo.siguiente;
        }

        targetNodo.siguiente = nuevoNodo;
    }

    /**
     * Agrega todos los elementos de listaParam al final de la estructura.
     *
     * @param listaParam
     */
    public void addAll(ListaEnlazadaNoOrdenada<T> listaParam) {
        if (listaParam == null || listaParam.isEmpty()) {
            return;
        }

        Iterador<T> iterador = listaParam.iterador();
        while (iterador.existeSiguiente()) {
            this.addToRear(iterador.siguiente());
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

        NodoLista<T> nodoResultado = this.header.siguiente;
        T resultado = nodoResultado.elemento;

        this.header.siguiente = this.header.siguiente.siguiente;

        return resultado;
    }

    /**
     * Elimina y devuelve el último elemento de la lista
     *
     * @return
     */
    @Override
    public T removeLast() {

        if (isEmpty()) {
            return null;
        }

        NodoListaBusqueda<T> listaNodos = getUltimos2Nodos();

        if (listaNodos.nodoAnterior != null) {
            listaNodos.nodoAnterior.siguiente = null;
        } else {
            this.header.siguiente = null;
        }

        return listaNodos.nodoActual.elemento;
    }

    /**
     * Elimina y devuelve el elemento especificado de la lista
     *
     * @param element
     * @return
     */
    @Override
    public T remove(T element) {
        NodoListaBusqueda<T> nodosBusqueda = getNodoPorElemento(element);

        NodoLista<T> previo = nodosBusqueda.nodoAnterior;
        NodoLista<T> buscado = nodosBusqueda.nodoActual;

        if (buscado == null) {
            throw new IllegalArgumentException("El elemento especificado no se encuentra en la lista");
        }

        if (previo != null) {
            previo.siguiente = buscado.siguiente;
        } else {
            this.header.siguiente = buscado.siguiente;
        }

        return buscado.elemento;
    }

    public T remove(int indice) {

        if (indice < 0 || indice > size()) {
            throw new IllegalArgumentException("Índice fuera de intervalo");
        }

        NodoLista<T> nodoActual = header.siguiente;
        for (int i = 0; i < indice; i++) {
            nodoActual = nodoActual.siguiente;
        }

        return remove(nodoActual.elemento);
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
     */
    @Override
    public T get(int position) {
        if (position < 0 || position > size()) {
            throw new IllegalArgumentException("Parámetro position es inválido. ");
        }

        NodoLista<T> nodoActual = header.siguiente;
        for (int i = 0; i < position; i++) {
            nodoActual = nodoActual.siguiente;
        }

        return nodoActual.elemento;
    }

    /**
     * Establece element como valor del nodo ubicado en position.
     *
     * @param element
     * @param position
     */
    @Override
    public void set(T element, int position) {
        if (position < 0 || position > size()) {
            throw new IllegalArgumentException("Parámetro position es inválido.");
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

        NodoLista<T> ultimoNodo = ((NodoListaBusqueda<T>) getUltimos2Nodos()).nodoActual;
        return ultimoNodo.elemento;
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
        int tamanio = 0;
        NodoLista<T> nodoActual = header.siguiente;

        while (nodoActual != null) {
            tamanio++;
            nodoActual = nodoActual.siguiente;
        }

        return tamanio;
    }

    /**
     * Devuelve el nodo cuyo elemento coincide con el pasado por parámetro y su
     * nodo antecesor.
     *
     * @param elemento
     * @return
     */
    protected NodoListaBusqueda<T> getNodoPorElemento(T elemento) {
        boolean encontrado = false;

        NodoLista<T> nodoAnterior = null;
        NodoLista<T> nodoActual = header.siguiente;

        while (nodoActual != null) {
            if (!nodoActual.elemento.equals(elemento)) {
                nodoAnterior = nodoActual;
                nodoActual = nodoActual.siguiente;
            } else {
                encontrado = true;
                break;
            }
        }

        NodoListaBusqueda<T> resultado = new NodoListaBusqueda();
        if (encontrado) {
            resultado.nodoAnterior = nodoAnterior;
            resultado.nodoActual = nodoActual;
        }

        return resultado;
    }

    /**
     * Obtiene los dos últimos nodos de la lista y los retorna en un array.
     *
     * @return
     */
    protected NodoListaBusqueda<T> getUltimos2Nodos() {
        NodoLista<T> nodoAnterior = null;
        NodoLista<T> nodoActual = header.siguiente;

        while (nodoActual.siguiente != null) {
            nodoAnterior = nodoActual;
            nodoActual = nodoActual.siguiente;
        }

        NodoListaBusqueda<T> resultado = new NodoListaBusqueda();

        resultado.nodoAnterior = nodoAnterior;
        resultado.nodoActual = nodoActual;

        return resultado;
    }

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

package ar.edu.uner.fcad.ed.edlineales;

import ar.edu.uner.fcad.ed.edlineales.iteradores.Iterable;
import ar.edu.uner.fcad.ed.edlineales.iteradores.Iterador;
import ar.edu.uner.fcad.ed.edlineales.iteradores.IteradorListaPorPosicion;
import java.lang.reflect.Array;

/**
 *
 * @author Nacho
 * @param <T>
 */
public class ListaPorPosicionOrdenada<T extends Comparable<? super T>>
        implements ListaOrdenada<T>, Iterable<T> {

    private static final int CAPACIDAD = 10;
    protected T[] arreglo;
    protected Class<T> clase;
    protected int capacidad;
    protected int ultimaPosicion;

    public ListaPorPosicionOrdenada(Class<T> clase) {
        this.capacidad = CAPACIDAD;
        this.arreglo = nuevoArreglo(clase, capacidad);
        this.clase = clase;
        this.ultimaPosicion = -1;
    }

    public ListaPorPosicionOrdenada(Class<T> clase, int capacidad) {
        this.capacidad = capacidad;
        this.arreglo = nuevoArreglo(clase, capacidad);
        this.clase = clase;
        this.ultimaPosicion = -1;
    }

    /**
     * Añade un elemento especificado a la lista en la ubicación adecuada.
     *
     * @param element
     */
    @Override
    public void add(T element) {
        if (ultimaPosicion + 1 >= capacidad) {
            throw new IllegalStateException("La estructura está llena. La operación solicitada no se llevará a cabo.");
        }

        int indiceInsercion = determinarIndiceInsercion(element);

        ultimaPosicion++;

        //No hay elementos o el insertado es el mayor => va último
        if (indiceInsercion == -1) {
            arreglo[ultimaPosicion] = element;
        } else {
            for (int i = ultimaPosicion - 1; i >= indiceInsercion; i--) {
                arreglo[i + 1] = arreglo[i];
            }

            arreglo[indiceInsercion] = element;
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

        T resultado = this.arreglo[0];
        excluirPosicion(0);
        ultimaPosicion--;

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

        T resultado = this.arreglo[ultimaPosicion];
        excluirPosicion(ultimaPosicion);
        ultimaPosicion--;

        return resultado;
    }

    /**
     * Elimina y devuelve el elemento especificado de la lista
     *
     * @param element
     * @return
     */
    @Override
    public T remove(T element) {
        int posicion = indexOf(element);
        if (posicion < 0) {
            throw new IllegalArgumentException("El elemento especificado no forma parte de la estructura. La operación no se puede llevar a cabo.");
        }

        T resultado = this.arreglo[posicion];

        excluirPosicion(posicion);
        ultimaPosicion--;

        return resultado;
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
        return arreglo[0];
    }

    /**
     * Devuelve el elemento ubicado en el nodo ubicado en la posición indicada
     * por el parámetro position.
     *
     * @param position
     * @return
     */
    @Override
    public T get(int position) {
        if (position < 0 || position > size()) {
            throw new IllegalArgumentException("Parámetro position es inválido. ");
        }

        return arreglo[position];
    }

    @Override
    public void set(T element, int position) {
        if (position < 0 || position > size()) {
            throw new IllegalArgumentException("Parámetro position es inválido.");
        }

        arreglo[position] = element;
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

        return arreglo[ultimaPosicion];
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
     * Indica la posición donde se ubica el elemento pasado por parámetro. En
     * caso no estar el elemento en la estructura retorna -1.
     *
     * @return
     */
    @Override
    public int indexOf(T target) {
        for (int i = 0; i <= ultimaPosicion; i++) {
            if (target.equals(arreglo[i])) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Devuelve true si esta lista no contiene ningún elemento
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return ultimaPosicion == -1;
    }

    /**
     * Devuelve el número de elementos de la lista
     *
     * @return
     */
    @Override
    public int size() {
        return ultimaPosicion + 1;
    }

    private T[] nuevoArreglo(Class<T> clazz, int capacidad) {
        return (T[]) Array.newInstance(clazz, capacidad);
    }

    private void excluirPosicion(int excluir) {
        int indice;
        for (indice = excluir; indice < ultimaPosicion; indice++) {
            arreglo[indice] = arreglo[indice + 1];
        }

        arreglo[indice + 1] = null;
    }

    /**
     * Devuelve una representación de la lista en forma de cadena de caracteres
     */
    @Override
    public String toString() {
        String resultado = "";

        for (int i = 0; i <= ultimaPosicion; i++) {
            resultado += ", [" + arreglo[i] + "]";
        }

        if (resultado.length() > 0) {
            resultado = resultado.substring(2);
        }

        return resultado;
    }

    @Override
    public Iterador<T> iterador() {
        return new IteradorListaPorPosicion(arreglo, ultimaPosicion);
    }

    /**
     * Devuelve la posición dentro del arreglo que tiene ocupar el nuevo
     * elemento.
     *
     * @param element
     * @return
     */
    private int determinarIndiceInsercion(T element) {
        int resultado = -1;

        //Determino la posición definitiva del nuevo elemento.
        for (int i = 0; i <= ultimaPosicion; i++) {
            if (element.compareTo(arreglo[i]) <= 0) {
                resultado = i;
                break;
            }
        }

        return resultado;
    }
}

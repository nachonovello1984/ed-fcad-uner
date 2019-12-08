package ar.edu.uner.fcad.ed.edjerarquicas;

import ar.edu.uner.fcad.ed.edlineales.colas.ColaPorEnlaces;
import ar.edu.uner.fcad.ed.edlineales.ListaEnlazadaNoOrdenada;
import ar.edu.uner.fcad.ed.edlineales.iteradores.Iterador;
import java.lang.reflect.Array;
import java.util.Objects;

/**
 *
 * @author Nacho
 * @param <T>
 */
public class ArbolHiHd<T> implements InterfazArbol<T> {

    protected NodoArbolHiHd<T> raiz;

    public ArbolHiHd() {
        this.raiz = null;
    }

    /**
     *
     * @return
     */
    @Override
    public boolean vacio() {
        return raiz == null;
    }

    @Override
    public boolean lleno() {
        return false;
    }

    @Override
    public NodoArbol<T> raiz() {
        return raiz;
    }

    @Override
    public NodoArbol<T> padre(NodoArbol<T> nodo) {
        NodoArbol<T> resultado;

        if (vacio()) {
            throw new IllegalStateException("Árbol vacío");
        }

        NodoArbol<T>[] nodoResultado = getNodo(nodo.valor);

        resultado = nodoResultado[0];

        return resultado;
    }

    @Override
    public NodoArbol<T> hijoIzquierdo(NodoArbol<T> nodo) {
        if (vacio()) {
            throw new IllegalStateException("Árbol vacío");
        }

        NodoArbolHiHd<T> nodoHiHd = getAsNodoHiHd(nodo);
        if (!existe(nodoHiHd)) {
            throw new IllegalArgumentException("El nodo no pertenece a la estructura");
        }

        return nodoHiHd.getHijoIzquierdo();
    }

    @Override
    public NodoArbol<T> hermanoDerecho(NodoArbol<T> nodo) {
        if (vacio()) {
            throw new IllegalStateException("Árbol vacío");
        }

        NodoArbolHiHd<T> nodoHiHd = getAsNodoHiHd(nodo);
        if (!existe(nodoHiHd)) {
            throw new IllegalArgumentException("El nodo no pertenece en la estructura");
        }

        return nodoHiHd.getHnoDerecho();
    }

    @Override
    public T info(NodoArbol<T> nodo) {
        if (vacio()) {
            throw new IllegalStateException("Árbol vacío");
        }

        NodoArbolHiHd<T> nodoHiHd = getAsNodoHiHd(nodo);
        if (!existe(nodoHiHd)) {
            throw new IllegalArgumentException("El nodo no pertenece en la estructura");
        }

        return nodoHiHd.getValor();
    }

    @Override
    public void insertaHijo(NodoArbol<T> padre, NodoArbol<T> nodo) {
        if (vacio() && padre != null) {
            throw new IllegalArgumentException("Si el árbol está vacío no puede especificarse un nodo padre");
        }

        if (!vacio() && padre == null) {
            throw new IllegalArgumentException("Si el árbol no está vacío debe especificarse un nodo padre");
        }

        if (padre != null && !existe(padre)) {
            throw new IllegalArgumentException("El nodo especificado como padre no forma parte del árbol");
        }

        NodoArbolHiHd<T> padreHiHd = getAsNodoHiHd(padre);
        NodoArbolHiHd<T> nodoHiHd = getAsNodoHiHd(nodo);

        if (padre == null) {
            raiz = nodoHiHd;
        } else {
            NodoArbolHiHd<T> hnoAnterior = null;
            NodoArbolHiHd<T> hijoHiHd = padreHiHd.getHijoIzquierdo();

            while (hijoHiHd != null) {
                hnoAnterior = hijoHiHd;
                hijoHiHd = hijoHiHd.getHnoDerecho();
            }

            //Si hnoAnterior es distinto de null entonces padre tenía hijos. 
            if (hnoAnterior != null) {
                //Inserto el nodo como hijo más a la derecha
                hnoAnterior.hnoDerecho = nodoHiHd;
            } else {
                //El nodo es el primer hijo de padre.
                padreHiHd.hijoIzquierdo = nodoHiHd;
            }
        }
    }

    @Override
    public void insertaHermano(NodoArbol<T> nodoIzquierdo, NodoArbol<T> nodo) {
        if (vacio() && nodoIzquierdo != null) {
            throw new IllegalArgumentException("Si el árbol está vacío no puede especificarse un nodo hermano izquierdo");
        }

        if (!vacio() && nodoIzquierdo == null) {
            throw new IllegalArgumentException("Si el árbol no está vacío debe especificarse un nodo hermano izquierdo");
        }

        if (!existe(nodoIzquierdo)) {
            throw new IllegalArgumentException("El nodo especificado como hermano izquierdo no forma parte del árbol");
        }

        NodoArbolHiHd<T> nodoHnoIzq = getAsNodoHiHd(nodoIzquierdo);
        NodoArbolHiHd<T> nodoHiHd = getAsNodoHiHd(nodo);

        nodoHnoIzq.hnoDerecho = nodoHiHd;
    }

    @Override
    public void suprimeHijoIzquierdo(NodoArbol<T> nodo) {
        if (vacio()) {
            throw new IllegalStateException("El árbol está vacío. No hay nodos por eliminar");
        }

        if (nodo == null) {
            throw new IllegalArgumentException("El nodo especificado no puede ser null");
        }

        if (!existe(nodo)) {
            throw new IllegalArgumentException("El nodo no existe en la estructura");
        }

        NodoArbolHiHd<T> nodoHiHd = getAsNodoHiHd(nodo);
        NodoArbolHiHd<T> nodoHijo = getAsNodoHiHd(nodo);

        if (nodoHijo != null) {
            nodoHiHd.hijoIzquierdo = nodoHijo.getHnoDerecho();
        }
    }

    @Override
    public void suprimeHermanoDerecho(NodoArbol<T> nodo) {
        if (vacio()) {
            throw new IllegalStateException("El árbol está vacío. No hay nodos por eliminar");
        }

        if (nodo == null) {
            throw new IllegalArgumentException("El nodo especificado no puede ser null");
        }

        if (!existe(nodo)) {
            throw new IllegalArgumentException("El nodo no existe en la estructura");
        }

        NodoArbolHiHd<T> nodoHiHd = getAsNodoHiHd(nodo);
        NodoArbolHiHd<T> nodoHno = nodoHiHd.getHnoDerecho();

        if (nodoHno != null) {
            nodoHiHd.hnoDerecho = nodoHno.getHnoDerecho();
        }
    }

    @Override
    public void modifica(NodoArbol<T> nodo, T valor) {
        NodoArbolHiHd<T> nodoHiHd = getAsNodoHiHd(nodo);

        if (vacio()) {
            throw new IllegalStateException("Árbol vacío");
        }

        if (!existe(nodoHiHd)) {
            throw new IllegalArgumentException("El nodo no pertenece en la estructura");
        }

        nodoHiHd.valor = valor;

    }

    @Override
    public boolean existe(NodoArbol<T> nodo) {
        boolean resultado = false;

        NodoArbol<T>[] nodoResultado = getNodo(nodo.getValor());

        if (nodoResultado != null) {
            resultado = nodoResultado[1] != null;
        }

        return resultado;
    }

    private NodoArbolHiHd<T> getAsNodoHiHd(NodoArbol<T> nodo) {
        return (NodoArbolHiHd<T>) nodo;
    }

    private NodoArbol<T>[] getNodo(T valor) {
        NodoArbol<T>[] resultado = null;

        busquedaValor:
        {
            if (!vacio()) {
                ColaPorEnlaces<NodoArbolHiHd<T>> filaCompleta = new ColaPorEnlaces();
                ColaPorEnlaces<NodoArbolHiHd<T>> filaParcial = null;

                filaCompleta.enqueue(raiz);

                while (!filaCompleta.isEmpty()) {
                    filaParcial = new ColaPorEnlaces();
                    NodoArbolHiHd<T> nodoActual = filaCompleta.getFront();

                    if (nodoActual.getHijoIzquierdo() != null) {
                        nodoActual = nodoActual.getHijoIzquierdo();

                        while (nodoActual != null) {
                            filaParcial.enqueue(nodoActual);
                            nodoActual = nodoActual.getHnoDerecho();
                        }
                    }

                    //Si la fila parcial no tiene valores y nodoActual es el tiene por valor 
                    //el valor pasado por parámetro entonces se trataba de la raíz
                    if (filaParcial.isEmpty() && nodoActual.getValor().equals(valor)) {
                        resultado = (NodoArbolHiHd[]) Array.newInstance(NodoArbolHiHd.class, 2);
                        resultado[0] = null;
                        resultado[1] = nodoActual;

                        break busquedaValor;
                    }

                    while (!filaParcial.isEmpty()) {
                        NodoArbolHiHd<T> compActual = filaParcial.getFront();

                        if (compActual.getValor().equals(valor)) {
                            resultado = (NodoArbolHiHd[]) Array.newInstance(NodoArbolHiHd.class, 2);
                            resultado[0] = nodoActual;
                            resultado[1] = compActual;

                            break busquedaValor;
                        }

                        filaCompleta.enqueue(compActual);
                        filaParcial.dequeue();
                    }

                    filaCompleta.dequeue();
                }
            }
        }

        return resultado;
    }

    public Iterador<T> iteradorPreorden() {
        if (this.vacio()) {
            throw new IllegalStateException("Árbol vacío. La operación no se puede llevar a cabo.");
        }

        return new ArbolHiHdIteradorPreorden(raiz);
    }

    public Iterador<T> iteradorPosorden() {
        if (this.vacio()) {
            throw new IllegalStateException("Árbol vacío. La operación no se puede llevar a cabo.");
        }

        return new ArbolHiHdIteradorPosorden(raiz);
    }

    public Iterador<T> iteradorPorNiveles() {
        if (this.vacio()) {
            throw new IllegalStateException("Árbol vacío. La operación no se puede llevar a cabo.");
        }
        return new ArbolHiHdIteradorPorNiveles(raiz);
    }

    public Iterador<T> iteradorInorden() {
        if (this.vacio()) {
            throw new IllegalStateException("Árbol vacío. La operación no se puede llevar a cabo.");
        }

        return new ArbolHiHdIteradorInorden(raiz);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ArbolHiHd<T> other = (ArbolHiHd<T>) obj;
        Iterador<T> thisIterador = this.iteradorPreorden();
        Iterador<T> otherIterador = other.iteradorPreorden();
                
        while(thisIterador.existeSiguiente() || otherIterador.existeSiguiente()) {
            //Controlo si los árboles no tienen la misma cantidad de nodos => no son iguales
            if ( (thisIterador.existeSiguiente() && !otherIterador.existeSiguiente()) ||
                 (!thisIterador.existeSiguiente() && otherIterador.existeSiguiente())) {
                return false;
            }
            
            T thisElement = thisIterador.siguiente();
            T otherElement = otherIterador.siguiente();
            
            if (!Objects.equals(thisElement, otherElement)) {
                return false;
            }
        }
        
        return true;
    }
    
    

    @Override
    public String toString() {
        String resultado = "";

        if (vacio()) {
            return resultado;
        }

        ColaPorEnlaces<NodoArbolHiHd<T>> cola = new ColaPorEnlaces();
        cola.enqueue(raiz);
        while (!cola.isEmpty()) {
            NodoArbolHiHd<T> nodoActual = cola.getFront();
            resultado += ", [" + nodoActual.valor + "]";

            if (nodoActual.tieneHijos()) {
                NodoArbolHiHd<T> nodoHijo = nodoActual.hijoIzquierdo;
                while (nodoHijo != null) {
                    cola.enqueue(nodoHijo);
                    nodoHijo = nodoHijo.hnoDerecho;
                }
            }
            cola.dequeue();
        }

        return resultado.substring(2);
    }

    public ListaEnlazadaNoOrdenada<NodoArbolHiHd<T>> buscarCaminoANodo(T valor) {
        if (valor == null) {
            return null;
        }

        return buscarCaminoANodo(raiz, valor);
    }

    private ListaEnlazadaNoOrdenada<NodoArbolHiHd<T>> buscarCaminoANodo(NodoArbolHiHd<T> nodoActual, T valor) {
        ListaEnlazadaNoOrdenada<NodoArbolHiHd<T>> resultado = new ListaEnlazadaNoOrdenada();
        if (valor == null) {
            return resultado;
        }

        if (nodoActual.getValor().equals(valor)) {
            resultado.addToRear(nodoActual);
        } else {
            NodoArbolHiHd<T> hijoIzquierdo = nodoActual.getHijoIzquierdo();

            if (hijoIzquierdo != null) {

                resultado = buscarCaminoANodo(hijoIzquierdo, valor);

                if (resultado.size() > 0) {
                    resultado.addToRear(nodoActual);
                }

                hijoIzquierdo = hijoIzquierdo.getHnoDerecho();
                while (hijoIzquierdo != null && !(resultado.size() > 0)) {

                    resultado = buscarCaminoANodo(hijoIzquierdo, valor);

                    if (resultado.size() > 0) {
                        resultado.addToRear(nodoActual);
                        break;
                    }

                    hijoIzquierdo = hijoIzquierdo.getHnoDerecho();
                }
            }

        }

        return resultado;
    }
}

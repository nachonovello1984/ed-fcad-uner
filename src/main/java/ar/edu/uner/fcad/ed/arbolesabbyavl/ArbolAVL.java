/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.uner.fcad.ed.arbolesabbyavl;

import ar.edu.uner.fcad.ed.edlineales.colas.ColaPorEnlaces;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Nacho
 */
public class ArbolAVL<T> extends ArbolABB<T> {

    private boolean imprimirConFBs;

    public ArbolAVL() {
        this(false);
    }

    public ArbolAVL(boolean imprimirConFBs) {
        super();
        this.imprimirConFBs = imprimirConFBs;
    }

    private ListaAVL<T> buscarNodos(T valor) {
        return buscarNodos((NodoAVL<T>) getRaiz(), valor);
    }

    private ListaAVL<T> buscarNodos(NodoAVL<T> nodoInicio, T valor) {
        ListaAVL<T> resultado = new ListaAVL(valor);
        Comparable<T> valorComparable = (Comparable<T>) valor;

        int resComparacion = -1;

        NodoAVL<T> nodoActual = nodoInicio;

        while (nodoActual != null) {
            resultado.getNodos().add(nodoActual);

            resComparacion = valorComparable.compareTo(nodoActual.valor);

            if (resComparacion < 0) {
                nodoActual = (NodoAVL) nodoActual.hijoIzquierdo;
            }

            if (resComparacion > 0) {
                nodoActual = (NodoAVL) nodoActual.hijoDerecho;
            }

            if (resComparacion == 0) {
                break;
            }
        }

        return resultado;
    }

    @Override
    public void add(T valor) throws Exception {
        Comparable<T> valorComparable = (Comparable<T>) valor;
        if (isEmpty()) {
            raiz = new NodoAVL(valor);
        } else {
            ListaAVL<T> lista = buscarNodos(valor);

            NodoAVL<T> nodoPadre = lista.getPadreNodoBuscado();
            NodoAVL<T> nodoActual = lista.getNodoBuscado();

            if (nodoActual != null) {
                throw new Exception("Ya existe en el árbol un nodo con igual valor");
            }

            //Creo el nuevo nodo.
            NodoAVL<T> nuevoNodo = new NodoAVL(valor);

            //Determino a qué lado del nodoPadre debe ir
            int resComparacion = valorComparable.compareTo(nodoPadre.valor);

            if (resComparacion < 0) {
                nodoPadre.hijoIzquierdo = nuevoNodo;
            }

            if (resComparacion > 0) {
                nodoPadre.hijoDerecho = nuevoNodo;
            }

            lista.getNodos().add(nuevoNodo);

            //Rebalanceo.
            if (lista.getNodoPivote() != null) {
                insercionRebalanceo(lista, nuevoNodo);
            }

            //Actualizar Factores de Balance
            actualizarFBs((NodoAVL) getRaiz());
        }
    }

    @Override
    public void remove(T valor) throws Exception {
        ListaAVL<T> lista = buscarNodos(valor);
        NodoAVL<T> nodoB = lista.getPadreNodoBuscado();

        int[] bHArboles = getAlturaSubArboles(nodoB);
        NodoAVL<T> nodoABorrar = lista.getNodoBuscado();

        boolean entroWhile = false;
        boolean continuar = true;

        if (nodoABorrar == null) {
            throw new Exception("No existe en el árbol un nodo con valor igual al especificado");
        }

        super.borrarNodo(nodoB, nodoABorrar);

        //Caso 1         
        while (nodoB != null && nodoB.factorBalance != 0) {
            entroWhile = true;

            NodoAVL<T> nodoBPadre = lista.getNodoPorValor(nodoB.getValor()).get(0);

            //Caso 2. Si la h(subárbol-izquierdo) > h(subárbol-derecho) 
            if (bHArboles[0] > bHArboles[1]) {
                int[] bHArbolesNuevo = getAlturaSubArboles(nodoB);
                //Si se redujo en 1 la altura del subárbol izquierdo 
                if (bHArboles[0] > bHArbolesNuevo[0]) {
                    this.actualizarFBs(nodoB);
                } else {
                    //Caso 3. 
                    NodoAVL<T> nodoA = (NodoAVL<T>) nodoB.hijoIzquierdo;
                    continuar = rotacionRemoveAVL(nodoBPadre, nodoB, nodoA, true);
                    actualizarFBs(nodoB);
                }
            }

            //Caso 2. Si la h(subárbol-izquierdo) < h(subárbol-derecho)
            if (bHArboles[0] < bHArboles[1]) {
                int[] bHArbolesNuevo = getAlturaSubArboles(nodoB);
                //Si se redujo en 1 la altura del subárbol derecho 
                if (bHArboles[1] > bHArbolesNuevo[1]) {
                    this.actualizarFBs(nodoB);
                } else {
                    //Caso 3. 
                    NodoAVL<T> nodoA = (NodoAVL<T>) nodoB.hijoDerecho;
                    continuar = rotacionRemoveAVL(nodoBPadre, nodoB, nodoA, false);
                    actualizarFBs(nodoA);
                }
            }

            if (bHArboles[1] == bHArboles[0]) {
                actualizarFBs(nodoB);
            }

            if (!continuar) {
                break;
            }

            nodoB = nodoBPadre;
            if (nodoB != null) {
                bHArboles = getAlturaSubArboles(nodoB);
            }
        }

        if (!entroWhile) {
            actualizarFBs(nodoB);
        }
    }

    private boolean rotacionRemoveAVL(NodoAVL<T> nodoPadreB, NodoAVL<T> nodoB, NodoAVL<T> nodoA, boolean aEsHijoIzquierdo) {
        boolean continuar = false;

        int[] hNodoA = getAlturaSubArboles(nodoA);
        int fbA = hNodoA[1] - hNodoA[0];

        int[] hNodoB = getAlturaSubArboles(nodoB);
        int fbB = hNodoB[1] - hNodoB[0];

        boolean existePadreB = nodoPadreB != null;
        boolean bEsHijoDerecho = estaALaDerecha(nodoPadreB, nodoB);

        //Caso 3.1 o Caso 3.2
        if (fbA == 0 || (fbA < 0 && fbB < 0) || (fbA > 0 && fbB > 0)) {

            //Rotación Simple Derecha
            if (aEsHijoIzquierdo) {
                nodoB.hijoIzquierdo = nodoA.hijoDerecho;
                nodoA.hijoDerecho = nodoB;
            } else {
                //Rotación Simple Izquierda
                nodoB.hijoDerecho = nodoA.hijoIzquierdo;
                nodoA.hijoIzquierdo = nodoB;
            }

            conectarPadreB(existePadreB, bEsHijoDerecho, nodoPadreB, nodoA);

            //Determino si corresponde seguir chequeando (Caso 3.2)
            hNodoA = getAlturaSubArboles(nodoA);
            fbA = hNodoA[1] - hNodoA[0];
            continuar = fbA == 0;
        } else {
            //Caso 3.3
            NodoAVL<T> nodoC = (NodoAVL<T>) ((fbA > 0) ? nodoA.hijoDerecho : nodoA.hijoIzquierdo);

            if (aEsHijoIzquierdo) {
                //Rotación Doble Derecha
                nodoB.hijoIzquierdo = nodoC.hijoDerecho;
                nodoC.hijoDerecho = nodoB;
                nodoA.hijoDerecho = nodoC.hijoIzquierdo;
                nodoC.hijoIzquierdo = nodoA;
            } else {
                //Rotación Doble Izquierda
                nodoB.hijoDerecho = nodoC.hijoIzquierdo;
                nodoC.hijoIzquierdo = nodoB;
                nodoA.hijoIzquierdo = nodoC.hijoDerecho;
                nodoC.hijoDerecho = nodoA;
            }

            conectarPadreB(existePadreB, bEsHijoDerecho, nodoPadreB, nodoC);

            continuar = true;
        }

        return continuar;
    }

    private void insercionRebalanceo(ListaAVL<T> lista, NodoAVL<T> nuevo) {
        NodoAVL<T> nodoPadreB = lista.getPadreNodoPivote();
        NodoAVL<T> nodoB = lista.getNodoPivote();
        NodoAVL<T> nodoA = lista.getNodoA();
        NodoAVL<T> nodoC;

        boolean existePadreB = nodoPadreB != null;
        boolean bEsHijoDerecho = estaALaDerecha(nodoPadreB, nodoB);

        //Rotación Simple Izquierda
        if (nodoB.factorBalance == 1 && nodoA.factorBalance == 0
                && estaALaDerecha(nodoB, nodoA) && estaALaDerecha(nodoA, nuevo)) {

            nodoB.hijoDerecho = nodoA.hijoIzquierdo;
            nodoA.hijoIzquierdo = nodoB;

            conectarPadreB(existePadreB, bEsHijoDerecho, nodoPadreB, nodoA);
            return;
        }

        //Rotación Simple Derecha
        if (nodoB.factorBalance == -1 && nodoA.factorBalance == 0
                && !estaALaDerecha(nodoB, nodoA) && !estaALaDerecha(nodoA, nuevo)) {

            nodoB.hijoIzquierdo = nodoA.hijoDerecho;
            nodoA.hijoDerecho = nodoB;

            conectarPadreB(existePadreB, bEsHijoDerecho, nodoPadreB, nodoA);
        }

        //Rotación Doble Izquierda
        if (nodoB.factorBalance == 1 && nodoA.factorBalance == 0
                && estaALaDerecha(nodoB, nodoA) && !estaALaDerecha(nodoA, nuevo)) {

            nodoC = (NodoAVL) nodoA.hijoIzquierdo;
            nodoB.hijoDerecho = nodoC.hijoIzquierdo;
            nodoC.hijoIzquierdo = nodoB;
            nodoA.hijoIzquierdo = nodoC.hijoDerecho;
            nodoC.hijoDerecho = nodoA;

            conectarPadreB(existePadreB, bEsHijoDerecho, nodoPadreB, nodoC);
        }

        //Rotación Doble Derecha
        if (nodoB.factorBalance == -1 && nodoA.factorBalance == 0
                && !estaALaDerecha(nodoB, nodoA) && estaALaDerecha(nodoA, nuevo)) {

            nodoC = (NodoAVL<T>) nodoA.hijoDerecho;
            nodoB.hijoIzquierdo = nodoC.hijoDerecho;
            nodoC.hijoDerecho = nodoB;
            nodoA.hijoDerecho = nodoC.hijoIzquierdo;
            nodoC.hijoIzquierdo = nodoA;

            conectarPadreB(existePadreB, bEsHijoDerecho, nodoPadreB, nodoC);
        }
    }

    private void actualizarFBs(NodoAVL<T> nodo) {
        NodoAVL nodoActual;
        ColaPorEnlaces<NodoAVL<T>> cola = new ColaPorEnlaces<NodoAVL<T>>();
        cola.enqueue(nodo);

        while (!cola.isEmpty()) {
            nodoActual = cola.getFront();

            if (nodoActual.getTieneHijoIzquierdo()) {
                cola.enqueue((NodoAVL<T>) nodoActual.hijoIzquierdo);
            }

            if (nodoActual.getTieneHijoDerecho()) {
                cola.enqueue((NodoAVL<T>) nodoActual.hijoDerecho);
            }

            nodoActual.setFactorBalance(getFactorBalance(nodoActual));
            cola.dequeue();
        }
    }

    private int[] getAlturaSubArboles(NodoAVL<T> nodo) {
        int resultado[] = new int[2];

        int resultadoIzq = 0;
        int resultadoDer = 0;

        if (nodo.hijoIzquierdo != null) {
            int[] izq = getAlturaSubArboles((NodoAVL) nodo.hijoIzquierdo);
            resultadoIzq += 1 + ((izq[0] > 0 || izq[1] > 0) ? Math.max(izq[0], izq[1]) : 0);
        }

        if (nodo.hijoDerecho != null) {
            int[] der = getAlturaSubArboles((NodoAVL) nodo.hijoDerecho);
            resultadoDer += 1 + ((der[0] > 0 || der[1] > 0) ? Math.max(der[0], der[1]) : 0);
        }

        resultado[0] = resultadoIzq;
        resultado[1] = resultadoDer;

        return resultado;
    }

    private int getFactorBalance(NodoAVL<T> nodo) {
        int[] subArboles = getAlturaSubArboles(nodo);

        return subArboles[1] - subArboles[0];
    }

    private boolean estaALaDerecha(NodoAVL<T> nodoPadre, NodoAVL<T> nodoHijo) {
        boolean resultado = false;

        if (nodoPadre != null && nodoPadre.hijoDerecho != null) {
            ListaAVL<T> lista = buscarNodos((NodoAVL<T>) nodoPadre.hijoDerecho, nodoHijo.valor);

            resultado = lista.getNodos().contains(nodoHijo);
        }

        return resultado;
    }

    private void conectarPadreB(boolean existePadreB, boolean bEsHijoDerecho, NodoAVL nodoPadreB, NodoAVL nuevoHijoPadreB) {
        if (existePadreB) {
            if (bEsHijoDerecho) {
                nodoPadreB.hijoDerecho = nuevoHijoPadreB;
            } else {
                nodoPadreB.hijoIzquierdo = nuevoHijoPadreB;
            }
        } else {
            raiz = nuevoHijoPadreB;
        }
    }

    @Override
    public String toString() {
        String resultado = "";
        String strSeparador = ((imprimirConFBs) ? "\n" : ", ");
        ColaPorEnlaces<NodoABB<T>> cola = new ColaPorEnlaces();
        cola.enqueue(this.raiz);

        while (!cola.isEmpty()) {
            NodoAVL<T> nodoActual = (NodoAVL<T>) cola.getFront();
            T valorActual = nodoActual.getValor();

            resultado += strSeparador + valorActual.toString() + ((imprimirConFBs) ? " -> " + nodoActual.factorBalance : "");

            if (nodoActual.getTieneHijoIzquierdo()) {
                cola.enqueue(nodoActual.getHijoIzquierdo());
            }

            if (nodoActual.getTieneHijoDerecho()) {
                cola.enqueue(nodoActual.getHijoDerecho());
            }

            cola.dequeue();
        }

        if (resultado.length() > 0) {
            resultado = resultado.substring(strSeparador.length());
        }

        return resultado;
    }
}

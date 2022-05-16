package ar.edu.uner.fcad.ed.arbolesmultivia;

import ar.edu.uner.fcad.ed.edlineales.ListaEnlazadaNoOrdenada;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nacho
 * @param <K>
 * @param <V>
 */
public final class ArbolB<K extends Comparable<K>, V> implements ArbolBInterfaz<K, V> {

    protected static final int DEFAULT_M = 4;

    protected int arbolM;
    protected int tamanio;
    protected int altura;
    protected NodoArbolB<K, V> raiz;

    public ArbolB() {
        clear(DEFAULT_M);
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return tamanio;
    }

    @Override
    public final void clear() {
        this.clear(DEFAULT_M);
    }

    public void clear(int initialM) {
        this.arbolM = initialM;
        this.tamanio = 0;
        this.altura = 0;
        this.raiz = new NodoArbolB(0);
    }

    @Override
    public int height() {
        return altura;
    }

    @Override
    public V get(K key) {
        if (key == null) {
            throw new IllegalArgumentException("key no puede ser null");
        }

        return search(raiz, key, altura);
    }

    private V search(NodoArbolB<K, V> nodoActual, K clave, int altura) {
        try {
            ListaEnlazadaNoOrdenada<EntradaArbolB<K, V>> hijos = nodoActual.getHijos();

            if (altura == 0) { // Nodo externo (raiz o nodo hoja)
                for (int j = 0; j < nodoActual.m; j++) {
                    if (clave.equals(hijos.get(j).clave)) {
                        return hijos.get(j).valor;
                    }
                }
            } else { // Nodo interno
                for (int j = 0; j < nodoActual.m; j++) {
                    if (j + 1 == nodoActual.m || menor(clave, hijos.get(j + 1).clave)) {
                        return search(hijos.get(j).siguiente, clave, altura - 1);
                    }
                }
            }

        } catch (Exception exc) {
            exc.printStackTrace();
        }

        return null;

    }

    @Override
    public void insert(K key, V value) {
        try {
            if (key == null) {
                throw new IllegalArgumentException("key no puede ser null");
            }
            NodoArbolB<K, V> u = insert(raiz, key, value, altura);
            tamanio++;
            if (u == null) {
                return;
            }

            // need to split root
            NodoArbolB<K, V> t = new NodoArbolB(2);
            t.hijos.set(new EntradaArbolB(raiz.hijos.get(0).clave, null, raiz), 0);
            t.hijos.set(new EntradaArbolB(u.hijos.get(0).clave, null, u), 1);
            raiz = t;
            altura++;
        } catch (Exception ex) {
            Logger.getLogger(ArbolB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public NodoArbolB<K, V> insert(NodoArbolB<K, V> nodoActual, K key, V value, int ht) throws Exception {

        int j;
        EntradaArbolB<K, V> t = new EntradaArbolB(key, value, null);

        if (ht == 0) { // external node
            for (j = 0; j < nodoActual.m; j++) {
                if (menor(key, nodoActual.hijos.get(j).clave)) {
                    break;
                }
            }
        } else { // internal node
            for (j = 0; j < nodoActual.m; j++) {
                if ((j + 1 == nodoActual.m) || menor(key, nodoActual.hijos.get(j + 1).clave)) {
                    NodoArbolB<K, V> u = insert(nodoActual.hijos.get(j++).siguiente, key, value, ht - 1);
                    if (u == null) {
                        return null;
                    }
                    t.clave = u.hijos.get(0).clave;
                    t.siguiente = u;
                    break;
                }
            }
        }

        for (int i = nodoActual.m; i > j; i--) {
            nodoActual.hijos.set(nodoActual.hijos.get(i - 1), i);
        }
        nodoActual.hijos.set(t, j);
        nodoActual.m++;
        if (nodoActual.m < this.arbolM) {
            return null;
        } else {
            return split(nodoActual);
        }
    }

    // split node in half
    private NodoArbolB<K,V> split(NodoArbolB<K,V> nodoActual) {
        NodoArbolB<K,V> t = new NodoArbolB(arbolM / 2);
        nodoActual.m = arbolM / 2;
//        for (int j = 0; j < arbolM / 2; j++) {
//            t.hijos.set(nodoActual.hijos.get(arbolM / 2 + j), j);
//        }
        return t;
    }

    @Override
    public V delete(K key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return toString(raiz, altura, "") + "\n";
    }

    protected String toString(NodoArbolB<K, V> nodoActual, int altura, String identacion) {
        StringBuilder s = new StringBuilder();
        ListaEnlazadaNoOrdenada<EntradaArbolB<K, V>> hijos = nodoActual.hijos;

        try {
            if (altura == 0) {
                for (int j = 0; j < nodoActual.m; j++) {
                    s.append(identacion);
                    s.append(hijos.get(j).clave.toString());
                    s.append(" ");
                    s.append(hijos.get(j).valor);
                    s.append("\n");
                }
            } else {
                for (int j = 0; j < nodoActual.m; j++) {
                    if (j > 0) {
                        s.append(identacion);
                        s.append("(");
                        s.append(hijos.get(j).clave);
                        s.append(")\n");
                    }
                    s.append(toString(hijos.get(j).siguiente, altura - 1, identacion + "     "));
                }
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }

        return s.toString();
    }

    private boolean menor(Comparable k1, Comparable k2) {
        return k1.compareTo(k2) < 0;
    }
}

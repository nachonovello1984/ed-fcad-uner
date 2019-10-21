/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.uner.fcad.ed.grafos;

/**
 *
 * @author nacho
 */
public interface GrafoNoDirigidoInterfaz<T> {

    public void agregarVertice(T vertice);

    public void quitarVertice(T vertice);

    public void agregarArista(T vertice1, T vertice2);

    public void quitarArista(T vertice1, T vertice2);

    public boolean vacio();

    public int tamanio();

    @Override
    public String toString();
}

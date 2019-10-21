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
public class ClienteGrafos {
    public static void main(String[] args) {
        GrafoNoDirigidoMatrizAdyacencia<String> grafo = new GrafoNoDirigidoMatrizAdyacencia(String.class);
        
        grafo.agregarVertice("A");
        grafo.agregarVertice("B");
        grafo.agregarVertice("C");
        grafo.agregarVertice("D");
        grafo.agregarVertice("E");
        grafo.agregarVertice("F");
        grafo.agregarVertice("G");
        
        grafo.agregarArista("A", "B");
        grafo.agregarArista("A", "C");
        grafo.agregarArista("A", "D");
        
        grafo.agregarArista("B", "D");
        grafo.agregarArista("B", "G");
        
        grafo.agregarArista("C", "D");
        grafo.agregarArista("C", "E");
        
        grafo.agregarArista("G", "D");
        grafo.agregarArista("G", "F");
        
        grafo.agregarArista("E", "D");
        grafo.agregarArista("E", "F");
        
        System.out.println(grafo);
    }
}

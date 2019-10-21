/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.uner.fcad.ed.grafos;

import java.lang.reflect.Array;

/**
 *
 * @author nacho
 */
public class GrafoNoDirigidoMatrizAdyacencia <T> implements GrafoNoDirigidoInterfaz <T>{
    
    public static final int CAPACIDAD_DEFAULT = 10;
    protected int cantidadVertices;
    protected boolean [][] matrizAdyacencia;
    protected T [] vertices;
    
    public GrafoNoDirigidoMatrizAdyacencia(Class<T> clase) {
        this.cantidadVertices = 0;
        this.matrizAdyacencia = new boolean[CAPACIDAD_DEFAULT][CAPACIDAD_DEFAULT];
        this.vertices = nuevoArreglo(clase, CAPACIDAD_DEFAULT);
    }
    
    private T[] nuevoArreglo(Class<T> clazz, int capacidad) {
        return (T[]) Array.newInstance(clazz, capacidad);
    }

    @Override
    public void agregarVertice(T vertice) {
        if (vertice == null) {
            return;
        }
        
        if (this.cantidadVertices == CAPACIDAD_DEFAULT) {
            return;
        }
                
        this.vertices[this.cantidadVertices] = vertice;
        
        for (int i = 0; i < matrizAdyacencia.length; i++) {
            this.matrizAdyacencia[this.cantidadVertices][i] = false;
            this.matrizAdyacencia[i][this.cantidadVertices] = false;
        }
        
        this.matrizAdyacencia[this.cantidadVertices][this.cantidadVertices] = true;
        this.cantidadVertices++;
    }

    @Override
    public void quitarVertice(T vertice) {
        if (vertice == null) {
            return;
        }
        
        int indice = indice(vertice);
        
        if (indice < 0) {
            return;
        }
        
        this.vertices[indice] = null;
        
        for(int i = 0; i < this.matrizAdyacencia.length; i++) {
            this.matrizAdyacencia[indice][i] = false;
            this.matrizAdyacencia[i][indice] = false;
        }
        
        this.cantidadVertices--;
    }

    @Override
    public void agregarArista(T vertice1, T vertice2) {
        
        if (vertice1 == null || vertice2 == null) {
            return;
        }
        
        int indiceVertice1 = indice(vertice1);
        int indiceVertice2 = indice(vertice2);
        
        if (indiceVertice1 < 0 && indiceVertice2 < 0) {
            return;
        }
        
        this.matrizAdyacencia[indiceVertice1][indiceVertice2] = true;
        this.matrizAdyacencia[indiceVertice2][indiceVertice1] = true;
    }

    @Override
    public void quitarArista(T vertice1, T vertice2) {
        if (vertice1 == null || vertice2 == null) {
            return;
        }
        
        int indiceVertice1 = indice(vertice1);
        int indiceVertice2 = indice(vertice2);
        
        if (!(indiceVertice1 >= 0 && indiceVertice2 >= 0)) {
            return;
        }
        
        this.matrizAdyacencia[indiceVertice1][indiceVertice2] = false;
        this.matrizAdyacencia[indiceVertice2][indiceVertice1] = false;
    }

    @Override
    public boolean vacio() {
        return this.cantidadVertices > 0;
    }

    @Override
    public int tamanio() {
        return this.cantidadVertices;
    }
    
    private int indice(T vertice) {
        for (int i = 0; i < this.vertices.length; i++) {
            if (this.vertices[i] != null && this.vertices[i].equals(vertice)) {
                return i;
            }
        }
        return -1;
    }
    
    public String toString() {
        String resultado = "";
        
        for(int i = 0; i < this.vertices.length; i++) {
            if (this.vertices[i] == null) {
                continue;
            }
            
            resultado += this.vertices[i].toString() + ": " + strVerticesAdyacentes(i) + "\n";
        }
        
        return resultado;
    }
    
    private String strVerticesAdyacentes(int indice) {
        String resultado = "";
        
        for(int i = 0; i < this.matrizAdyacencia.length; i++) {
            if (this.matrizAdyacencia[indice][i]) {
                resultado += '[' + this.vertices[i].toString() + "], ";
            }
        }
        
        return resultado;
    }
}

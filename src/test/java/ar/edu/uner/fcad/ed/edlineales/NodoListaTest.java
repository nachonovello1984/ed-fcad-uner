/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.uner.fcad.ed.edlineales;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author nacho
 */
public class NodoListaTest {
    
    @Test
    public void testGetElemento() {
        System.out.println("getElemento");
        NodoLista<Integer> instance = new NodoLista(4);
        Integer expResult = 4;
        Integer result = instance.getElemento();
        assertEquals(expResult, result, "El elemento no es el esperado");
    }

    @Test
    public void testSetElemento() {
        System.out.println("setElemento");
        NodoLista<Integer> instance = new NodoLista(4);
        instance.setElemento(2);
        Integer expResult = 2;
        Integer result = instance.getElemento();
        
        assertEquals(expResult, result, "El elemento no es el esperado");
    }

    @Test
    public void testGetSiguiente() {
        System.out.println("getSiguiente");
        NodoLista<Integer> instance = new NodoLista(1);
        NodoLista<Integer> siguiente = new NodoLista(2);
        instance.setSiguiente(siguiente);
        NodoLista<Integer> expResult = siguiente;
        NodoLista<Integer> result = instance.getSiguiente();
        assertEquals(expResult, result, "El siguiente nodo no es el esperado");
    }

    @Test
    public void testSetSiguiente() {
        System.out.println("setSiguiente");
        NodoLista<Integer> instance = new NodoLista(1);
        NodoLista<Integer> siguiente = new NodoLista(2);
        instance.setSiguiente(siguiente);
        NodoLista<Integer> expResult = siguiente;
        NodoLista<Integer> result = instance.getSiguiente();
        assertEquals(expResult.getElemento(), result.getElemento(), "El siguiente nodo no es el esperado");
    }

    @Test
    public void testToString1() {
        System.out.println("toString");
        NodoLista<Integer> instance = new NodoLista(2);
        String expResult = "[2]";
        String result = instance.toString();
        assertEquals(expResult, result, "toString() no se comporta como se esperaba");
    }
    
    @Test
    public void testToString2() {
        System.out.println("toString");
        NodoLista<Integer> instance = new NodoLista(null);
        String expResult = "[]";
        String result = instance.toString();
        assertEquals(expResult, result, "toString() no se comporta como se esperaba");
    }
    
}

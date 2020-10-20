/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.uner.fcad.ed.mapeosdiccionarios;

import ar.edu.uner.fcad.ed.edlineales.ListaEnlazadaNoOrdenada;
import ar.edu.uner.fcad.ed.mapeosdiccionarios.diccionarios.DiccionarioConLista;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import ar.edu.uner.fcad.ed.edlineales.iteradores.Iterable;
import ar.edu.uner.fcad.ed.edlineales.iteradores.Iterador;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 *
 * @author nacho
 */
public class DiccionarioConListaTest {

    //*********
    //*********
    // size()
    //*********
    //*********
    @Test
    public void testSize_shouldReturnZero() {
        System.out.println("testSize_shouldReturnZero");

        DiccionarioConLista<Integer, Integer> instance = new DiccionarioConLista();
        Integer expected = 0;
        Integer actual = instance.size();

        assertEquals(expected, actual, "El método size() no funciona correctamente");
    }

    //*********
    //*********
    // size()
    //*********
    //*********
    @Test
    public void testSize_shouldReturnGreaterThanZero() {
        System.out.println("testSize_shouldReturnGreaterThanZero");

        DiccionarioConLista<Integer, Integer> instance = new DiccionarioConLista();
        Integer expected = new Random().nextInt(100);
        for (int i = 0; i < expected; i++) {
            instance.insert(i, i);
        }
        Integer actual = instance.size();

        assertEquals(expected, actual, "El método size() no funciona correctamente");
    }

    //*********
    //*********
    // isEmpty()
    //*********
    //*********
    @Test
    public void testIsEmpty_shouldReturnTrue() {
        System.out.println("testIsEmpty_shouldReturnTrue");

        DiccionarioConLista<Integer, Integer> instance = new DiccionarioConLista();
        Boolean resultado = instance.isEmpty();

        assertTrue(resultado, "El método isEmpty() no funciona correctamente");
    }

    //*********
    //*********
    // isEmpty()
    //*********
    //*********
    @Test
    public void testIsEmpty_shouldReturnFalse() {
        System.out.println("testIsEmpty_shouldReturnFalse");

        DiccionarioConLista<Integer, Integer> instance = new DiccionarioConLista();
        Integer expected = new Random().nextInt(10);
        for (int i = 0; i < expected; i++) {
            instance.insert(i, i);
        }

        assertTrue(!instance.isEmpty(), "El método isEmpty() no funciona correctamente");
    }

    //*************
    //*************
    //find(K key);
    //*************
    //*************
    @Test
    public void testFind_shouldReturnNull() {
        System.out.println("testFind_shouldReturnNull");
        
        DiccionarioConLista<Integer, Integer> instance = new DiccionarioConLista();
        for (int i = 0; i < 5; i++) {
            instance.insert(i, i);
        }
        Entrada<Integer, Integer> expected = null;
        Entrada<Integer, Integer> actual = instance.find(30);
        assertEquals(expected, actual, "testFind_shouldReturnNull - Los elementos deberían ser null");
    }

    @Test
    public void testFind_shouldReturnNullOnEmptyDS() {
        DiccionarioConLista<Integer, Integer> instance = new DiccionarioConLista();
        Entrada<Integer, Integer> expected = null;
        Entrada<Integer, Integer> actual = instance.find(30);
        assertEquals(expected, actual, "testFind_shouldReturnNullOnEmptyDS - Los elementos deberían ser null");
    }

    @Test
    public void testFind_shouldReturnNotNull() {
        DiccionarioConLista<Integer, Integer> instance = new DiccionarioConLista();
        for (int i = 0; i < 5; i++) {
            instance.insert(i, i);
        }
        Entrada<Integer, Integer> expected = new Entrada(3, 3);
        Entrada<Integer, Integer> actual = instance.find(3);
        assertEquals(expected, actual, "testFind_shouldReturnNotNull - Los elementos no son iguales");
    }

    //*************
    //*************
    //findAll(K key);
    //*************
    //*************
    @Test
    public void testFindAll_shouldReturnEmptySet() {
        DiccionarioConLista<Integer, Integer> instance = new DiccionarioConLista();

        for (int i = 0; i < 5; i++) {
            instance.insert(i, i);
            instance.insert(i, i * 2);
        }

        Iterable<Entrada<Integer, Integer>> actual = instance.findAll(30);
        assertFalse(actual.iterador().existeSiguiente(), "testFindAll_shouldReturnEmptySet");
    }

    @Test
    public void testFindAll_shouldReturnNonEmptySet() {
        DiccionarioConLista<Integer, Integer> instance = new DiccionarioConLista();
        for (int i = 0; i < 5; i++) {
            instance.insert(i, i);
            instance.insert(i, i * 2);
        }
        ListaEnlazadaNoOrdenada<Entrada<Integer, Integer>> lista = new ListaEnlazadaNoOrdenada();
        lista.addToRear(new Entrada(3, 3));
        lista.addToRear(new Entrada(3, 6));

        Iterador<Entrada<Integer, Integer>> expected = lista.iterador();
        Iterador<Entrada<Integer, Integer>> actual = instance.findAll(3).iterador();

        assertEquals(expected.siguiente(), actual.siguiente(), "testFindAll_shouldReturnNonEmptySet - Los resultados no son iguales");
        assertEquals(expected.siguiente(), actual.siguiente(), "testFindAll_shouldReturnNonEmptySet - Los resultados no son iguales");
    }

    //*************
    //*************
    //insert(K key, V value);
    //*************
    //*************
    @Test
    public void testInsert_shouldAddEntry() {
        DiccionarioConLista<Integer, Integer> instance = new DiccionarioConLista();
        instance.insert(1, 1);

        int expected = 1;
        int actual = instance.size();

        assertEquals(expected, actual, "testInsert_shouldAddOne - Deberían tener igual longitud");
    }

    //*************
    //*************
    //remove(K key);
    //*************
    //*************
    @Test
    public void testRemove_shouldThrowsIllegalStateException1() {
        System.out.println("testRemove_shouldThrowsIllegalStateException1");
        boolean entroCatch = false;
        try {
            DiccionarioConLista<Integer, Integer> instance = new DiccionarioConLista();
            instance.remove(3);
        } catch (Exception ex) {
            entroCatch = true;
        }

        assertTrue(entroCatch, "testRemove_shouldThrowsIllegalStateException1 - Deberían haber producido excepción");
    }

    @Test
    public void testRemove_shouldThrowsIllegalStateException2() {
        System.out.println("testRemove_shouldThrowsIllegalStateException2");
        boolean entroCatch = false;
        try {
            DiccionarioConLista<Integer, Integer> instance = new DiccionarioConLista();
            for (int i = 0; i < 5; i++) {
                instance.insert(i, i);
            }
            instance.remove(30);
        } catch (Exception ex) {
            entroCatch = true;
        }

        assertTrue(entroCatch, "testRemove_shouldThrowsIllegalStateException1 - Deberían haber producido excepción");
    }

    @Test
    public void testRemove_shouldReturnNotNull() {
        System.out.println("testSize_shouldReturnGreaterThanZero");

        DiccionarioConLista<Integer, Integer> instance = new DiccionarioConLista();
        for (int i = 0; i < 5; i++) {
            instance.insert(i, i);
        }
        Entrada<Integer, Integer> expected = new Entrada(3, 3);
        Entrada<Integer, Integer> actual = instance.remove(3);

        assertEquals(expected, actual, "testRemove_shouldReturnNotNull - Elementos diferentes");
    }

    //*********
    //*********
    //entries()
    //*********
    //*********
    @Test
    public void testEntries_shouldReturnEmptySet() {
        System.out.println("testEntries_shouldReturnEmptySet");

        Iterable<Entrada<Integer, Integer>> expected = new ListaEnlazadaNoOrdenada();
        Iterable<Entrada<Integer, Integer>> actual = new DiccionarioConLista().entries();

        assertTrue(!expected.iterador().existeSiguiente() && !actual.iterador().existeSiguiente(), "El método entries() no funciona correctamente");
    }

    @Test
    public void testEntries_shouldReturnNonEmptySet() {
        System.out.println("testEntries_shouldReturnNonEmptySet");

        ListaEnlazadaNoOrdenada<Entrada<Integer, Integer>> lista = new ListaEnlazadaNoOrdenada();
        lista.addToRear(new Entrada(1, 1));
        lista.addToRear(new Entrada(2, 2));
        lista.addToRear(new Entrada(3, 3));

        DiccionarioConLista<Integer, Integer> diccionario = new DiccionarioConLista();
        diccionario.insert(1, 1);
        diccionario.insert(2, 2);
        diccionario.insert(3, 3);

        Iterador<Entrada<Integer, Integer>> expected = lista.iterador();
        Iterador<Entrada<Integer, Integer>> actual = diccionario.entries().iterador();

        while (expected.existeSiguiente() || actual.existeSiguiente()) {
            assertEquals(expected.existeSiguiente(), actual.existeSiguiente(), "testEntries() - Los resultados difieren en longitud");

            assertEquals(expected.siguiente(), actual.siguiente(), "testEntries() - Los resultados difieren");
        }
    }

    //*********
    //*********
    //toString()
    //*********
    //*********
    @Test
    public void testToString_shouldReturnEmptyString() {
        System.out.println("testToString_shouldReturnEmptyString");

        DiccionarioConLista<Integer, Integer> instance = new DiccionarioConLista();

        assertEquals("", instance.toString(), "El método toString() no funciona correctamente");
    }

    @Test
    public void testToString_shouldReturnNonEmptyString() {
        System.out.println("testToString_shouldReturnNonEmptyString");

        String expected = "{(0,0), (1,1), (2,2), (3,3), (4,4), (5,5)}";
        DiccionarioConLista<Integer, Integer> instance = new DiccionarioConLista();
        for (int i = 0; i <= 5; i++) {
            instance.insert(i, i);
        }
        String actual = instance.toString();
        System.out.println("actual: " + actual);
        assertEquals(expected, actual, "El método toString() no funciona correctamente");
    }
}

package ar.edu.uner.fcad.ed.edlineales;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 *
 * @author nacho
 */
public class ListaEnlazadaNoOrdenadaTest {
    
    //*********
    //*********
    //addToFront()
    //*********
    //*********
    @Test
    public void testAddToFront_shouldAddElementFirst() {
        System.out.println("testAddToFront_shouldAddElement1");
        String expected = "[2], [1]";
        ListaEnlazadaNoOrdenada<Integer> instance = new ListaEnlazadaNoOrdenada();
        instance.addToRear(1);
        instance.addToFront(2);
        assertEquals(expected, instance.toString(), "addToFront() no funciona correctamente.");
    }
    
    @Test
    public void testAddToFront_shouldNotBeEmpty() {
        System.out.println("testAddToFront_shouldNotBeEmpty");
        ListaEnlazadaNoOrdenada<Integer> instance = new ListaEnlazadaNoOrdenada();
        instance.addToFront(1);
        assertFalse(instance.isEmpty(), "addToFront() debería dejar NO vacía la estructura.");
    }
    
    //*********
    //*********
    //addToRear()
    //*********
    //*********
    @Test
    public void testAddToRear_shouldAddElementLast() {
        System.out.println("testAddToRear_shouldAddElementLast");
        Integer expected = 100;
        ListaEnlazadaNoOrdenada<Integer> instance = new ListaEnlazadaNoOrdenada();
        instance.addToRear(10);
        instance.addToRear(100);
        assertEquals(expected, instance.last(), "addToRear() debería agregar el elemento al final de la estructura.");
    }
    
    @Test
    public void testAddToRear_shouldNotBeEmpty() {
        System.out.println("testAddToRear_shouldNotBeEmpty");
        ListaEnlazadaNoOrdenada<Integer> instance = new ListaEnlazadaNoOrdenada();
        instance.addToRear(10);
        assertFalse(instance.isEmpty(), "addToRear() debería dejar NO vacía la estructura.");
    }

    //*********
    //*********
    //addAfter()
    //*********
    //*********
    
    @Test
    public void testAddAfter_shouldAddElementAt() {
        System.out.println("testAddAfter_shouldAddElementAt");
        
        Integer expected = 5;
        
        ListaEnlazadaNoOrdenada<Integer> instance = new ListaEnlazadaNoOrdenada();
        for (int i = 1; i <= 10; i++) {
            instance.addToRear(i * 2);
        }
        
        instance.addAfter(5, 4);
        
    }

    //*********
    //*********
    //removeFirst()
    //*********
    //*********
//    @Test
//    public void removeFirst();

    //*********
    //*********
    //removeLast()
    //*********
    //*********
//    @Test
//    public void removeLast();

    //*********
    //*********
    //remove()
    //*********
    //*********
//    @Test    
//    public void remove();

    //*********
    //*********
    //first()
    //*********
    //*********
//    @Test
//    public T first();

    //*********
    //*********
    //get()
    //*********
    //*********
//    @Test
//    public T get();

    //*********
    //*********
    //set()
    //*********
    //*********
//    @Test    
//    public void set();
    
    
    //*********
    //*********
    //last()
    //*********
    //*********
    @Test
    public void testLast_shouldReturnNull() {
        System.out.println("testLast_shouldReturnNull");
        Integer expected = null;
        ListaEnlazadaNoOrdenada<Integer> instance = new ListaEnlazadaNoOrdenada();
        assertEquals(expected, instance.last(), "last() debería devolver null.");
    }
    
    @Test
    public void testLast_shouldReturnLastElement() {
        System.out.println("testLast_shouldReturnLastElement");
        
        Integer expected = 100;
        
        ListaEnlazadaNoOrdenada<Integer> instance = new ListaEnlazadaNoOrdenada();
        instance.addToRear(10);
        instance.addToRear(100);
        
        assertEquals(expected, instance.last(), "last() debería devolver 100.");
    }
    
    //*********
    //*********
    //contains()
    //*********
    //*********
    @Test    
    public void testContains_shouldReturnFalse() {
        System.out.println("testContains_shouldReturnFalse");
        
        ListaEnlazadaNoOrdenada<Integer> instance = new ListaEnlazadaNoOrdenada();
        instance.addToRear(10);
        
        assertFalse(instance.contains(100), "contains() debería devolver false.");
    }
    
    @Test    
    public void testContains_shouldReturnTrue() {
        System.out.println("testContains_shouldReturnTrue");
        
        ListaEnlazadaNoOrdenada<Integer> instance = new ListaEnlazadaNoOrdenada();
        instance.addToRear(10);
        instance.addToRear(100);
        
        assertTrue(instance.contains(100), "contains() debería devolver true.");
    }
    
    //*********
    //*********
    //indexOf()
    //*********
    //*********
    @Test    
    public void testIndexOf_shouldReturnNegativeValue() {
        System.out.println("testIndexOf_shouldReturnNegativeValue");
        Integer expected = -1;
        ListaEnlazadaNoOrdenada<Integer> instance = new ListaEnlazadaNoOrdenada();
        instance.addToRear(10);
        assertEquals(expected, instance.indexOf(100), "indexOf() debería devolver -1.");
    }
    
    @Test    
    public void testIndexOf_shouldReturnGraterThanZero() {
        System.out.println("testIndexOf_shouldReturnGraterThanZero");
        Integer expected = 1;
        ListaEnlazadaNoOrdenada<Integer> instance = new ListaEnlazadaNoOrdenada();
        instance.addToRear(10);
        instance.addToRear(100);
        assertEquals(expected, instance.indexOf(100), "indexOf() debería devolver 1.");
    }
    
    //*********
    //*********
    //isEmpty()
    //*********
    //*********
    @Test    
    public void testIsEmpty_shouldReturnFalse() {
        System.out.println("testIsEmpty_shouldReturnFalse");
        ListaEnlazadaNoOrdenada<Integer> instance = new ListaEnlazadaNoOrdenada();
        instance.addToRear(10);
        assertFalse(instance.isEmpty(), "isEmpty() debería devolver false.");
    }
    
    @Test    
    public void testIsEmpty_shouldReturnTrue() {
        System.out.println("testIsEmpty_shouldReturnTrue");
        ListaEnlazadaNoOrdenada<Integer> instance = new ListaEnlazadaNoOrdenada();
        assertTrue(instance.isEmpty(), "isEmpty() debería devolver true.");
    }
    
    //*********
    //*********
    //size()
    //*********
    //*********
    @Test    
    public void testSize_shouldReturnZero() {
        System.out.println("testSize_shouldReturnZero");
        Integer expected = 0;
        ListaEnlazadaNoOrdenada<Integer> instance = new ListaEnlazadaNoOrdenada();
        assertEquals(expected, instance.size(), "size() debe ser 0.");
    }
    
    @Test    
    public void testSize_shouldReturnGreaterThanZero() {
        System.out.println("testSize_shouldReturnGreaterThanZero");
        Integer expected = 10;
        ListaEnlazadaNoOrdenada<Integer> instance = new ListaEnlazadaNoOrdenada();
        for (int i = 1; i <= 10; i++) {
            instance.addToRear(i);
        }
        assertEquals(expected, instance.size(), "size() debe ser 0.");
    }
    
    //*********
    //*********
    //toString()
    //*********
    //*********
    @Test    
    public void testToString_shouldReturnEmptyString() {
        System.out.println("testToString_shouldReturnEmptyString");
        String expected = "";
        ListaEnlazadaNoOrdenada<Integer> instance = new ListaEnlazadaNoOrdenada();
        assertEquals(expected, instance.toString(), "Debería retornar el String vacío.");
    }
    
    @Test    
    public void testToString_shouldReturnNotEmptyString() {
        System.out.println("testToString_shouldReturnNotEmptyString");
        String expected = "[1], [2], [3], [4], [5], [6], [7], [8], [9], [10]";
        ListaEnlazadaNoOrdenada<Integer> instance = new ListaEnlazadaNoOrdenada();
        for (int i = 1; i <= 10; i++) {
            instance.addToRear(i);
        }
        assertEquals(expected, instance.toString(), "toString() no funciona como debería.");
    }

}

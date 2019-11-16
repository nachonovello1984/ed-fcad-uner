package ar.edu.uner.fcad.ed.edlineales.pilas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author nacho
 */
public class PilaPorEnlacesTest {

    @Test
    public void testIsEmpty_shouldReturnTrue() {
        System.out.println("testIsEmpty_shouldReturnTrue");
        boolean expResult = true;
        PilaPorEnlaces<Integer> instance = new PilaPorEnlaces();
        boolean result = instance.isEmpty();
        assertEquals(expResult, result, "Se esperaba que la Pila fuera vacía");
    }

    @Test
    public void testIsEmptyAfterPushPop_shouldReturnTrue() {
        System.out.println("testIsEmptyAfterPushPop_shouldReturnTrue");
        boolean expResult = true;
        PilaPorEnlaces<Integer> instance = new PilaPorEnlaces();
        for (int i = 0; i < 100; i++) {
            instance.push(i);
        }
        for (int i = 0; i < 100; i++) {
            instance.pop();
        }
        boolean result = instance.isEmpty();
        assertEquals(expResult, result, "Se esperaba que la Pila fuera vacía");
    }

    @Test
    public void testIsEmpty_shouldReturnFalse() {
        System.out.println("testIsEmpty_shouldReturnFalse");
        boolean expResult = false;
        PilaPorEnlaces<Integer> instance = new PilaPorEnlaces();
        instance.push(100);
        boolean result = instance.isEmpty();
        assertEquals(expResult, result, "Se esperaba que la Pila NO fuera vacía");
    }

    @Test
    public void testIsFull_shouldReturnFalse() {
        System.out.println("testIsFull_shouldReturnFalse");
        boolean expResult = false;
        PilaPorEnlaces<Integer> instance = new PilaPorEnlaces();
        boolean result = instance.isFull();
        assertEquals(expResult, result, "Una PilaPorEnlaces almacenará tantos elementos como lo permita la memoria asignada a la JRE.");
    }

    @Test
    public void testTop() {
        System.out.println("testTop");
        PilaPorEnlaces<Integer> instance = new PilaPorEnlaces();
        instance.push(50);
        instance.push(100);
        Integer expResult = 100;
        Integer result = instance.top();
        assertEquals(expResult, result, "Se esperaba que top() devuelva 100");
    }

    @Test
    public void testTop_shouldReturnNull() {
        Integer expResult = null;
        System.out.println("testTop_shouldFail");
        PilaPorEnlaces<Integer> instance = new PilaPorEnlaces();
        Integer result = instance.top();
        assertEquals(expResult, result, "El resultado debería ser null");
    }

    @Test
    public void testPop_shouldRemoveLastest() {
        System.out.println("testPop_shouldRemoveOne");
        PilaPorEnlaces<Integer> instance = new PilaPorEnlaces();
        for (int i = 1; i <= 10; i++) {
            instance.push(i);
        }
        boolean found = false;
        Integer top = instance.top();
        instance.pop();
        while (!instance.isEmpty()) {
            Integer aux = instance.top();
            if (aux.equals(top)) {
                found = true;
                break;
            }
            instance.pop();
        }
        assertFalse(found, "El método pop() debería quitar elemento en la cima de la estructura.");
    }

    @Test
    public void testPop_shouldRemoveOne() {
        System.out.println("testPop_shouldRemoveOne");
        int contador = 0;
        PilaPorEnlaces<Integer> instance = new PilaPorEnlaces();
        for (int i = 1; i <= 10; i++) {
            instance.push(i);
            contador++;
        }
        instance.pop();
        while (!instance.isEmpty()) {
            instance.pop();
            contador--;
        }
        assertTrue(contador == 1, "El método pop() debería quitar un elemento de la estructura.");
    }

    @Test
    public void testPush_shouldNotBeEmpty() {
        System.out.println("testPush_shouldNotBeEmpty");
        PilaPorEnlaces<Integer> instance = new PilaPorEnlaces();
        instance.push(100);
        assertFalse(instance.isEmpty(), "Luego de un push() una pila debería no tener al menos un elemento.");
    } 

    @Test
    public void testMakeEmpty_shouldBeEmpty() {
        System.out.println("testMakeEmpty_shouldBeEmpty");
        PilaPorEnlaces<Integer> instance = new PilaPorEnlaces();
        for (int i = 1; i <= 10; i++) {
            instance.push(i);
        }
        instance.makeEmpty();
        assertTrue(instance.isEmpty(), "Luego de invocar a makeEmpty() la pila debería estar vacía.");
    }

    @Test
    public void testToString_shouldReturnEmptyString() {
        System.out.println("testToString_shouldReturnEmptyString");
        String expResult = "";
        PilaPorEnlaces<Integer> instance = new PilaPorEnlaces();
        String result = instance.toString();
        assertEquals(expResult, result, "El resultado de toString() debería ser el String vacío.");
    }

    @Test
    public void testToString_shouldReturnNotEmptyString() {
        System.out.println("testToString_shouldReturnNotEmptyString");
        String expResult = "[10], [9], [8], [7], [6], [5], [4], [3], [2], [1]";
        PilaPorEnlaces<Integer> instance = new PilaPorEnlaces();
        for (int i = 1; i <= 10; i++) {
            instance.push(i);
        }
        String result = instance.toString();
        assertEquals(expResult, result, "El resultado de toString() debería ser: " + expResult);
    }

}

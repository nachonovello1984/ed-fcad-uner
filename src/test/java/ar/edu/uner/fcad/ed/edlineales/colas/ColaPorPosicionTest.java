package ar.edu.uner.fcad.ed.edlineales.colas;

import ar.edu.uner.fcad.ed.edlineales.ListaEnlazadaNoOrdenada;
import ar.edu.uner.fcad.ed.edlineales.iteradores.Iterador;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 *
 * @author nacho
 */
public class ColaPorPosicionTest {
    
    @Test
    public void testIsEmpty_shouldReturnTrue() {
        System.out.println("testIsEmpty_shouldReturnTrue");
        boolean expResult = true;
        ColaPorPosicion<Integer> instance = new ColaPorPosicion(Integer.class);
        boolean result = instance.isEmpty();
        assertEquals(expResult, result, "Se esperaba que la Cola fuera vacía");
    }
    
    @Test
    public void testIsEmptyAfterEnqueueDequeue_shouldReturnTrue() {
        System.out.println("testIsEmptyAfterEnqueueDequeue_shouldReturnTrue");
        boolean expResult = true;
        ColaPorPosicion<Integer> instance = new ColaPorPosicion(Integer.class, 100);
        for (int i = 0; i < 100; i++) {
            instance.enqueue(i);
        }
        for (int i = 0; i < 100; i++) {
            instance.dequeue();
        }
        boolean result = instance.isEmpty();
        assertEquals(expResult, result, "Se esperaba que la Cola fuera vacía");
    }
    
    @Test
    public void testIsEmpty_shouldReturnFalse() {
        System.out.println("testIsEmpty_shouldReturnFalse");
        boolean expResult = false;
        ColaPorPosicion<Integer> instance = new ColaPorPosicion(Integer.class);
        instance.enqueue(100);
        boolean result = instance.isEmpty();
        assertEquals(expResult, result, "Se esperaba que la Cola NO fuera vacía");
    }
    
    @Test
    public void testIsFull_shouldReturnFalse() {
        System.out.println("testIsFull_shouldReturnFalse");
        boolean expResult = false;
        ColaPorPosicion<Integer> instance = new ColaPorPosicion(Integer.class);
        boolean result = instance.isFull();
        assertEquals(expResult, result, "Una ColaPorPosicion almacenará tantos elementos como lo permita la memoria asignada a la JRE.");
    } 
    
    @Test
    public void testGetFront_shouldReturnNull() {
        System.out.println("testGetFront_shouldReturnNull");
        Integer expResult = null;
        ColaPorPosicion<Integer> instance = new ColaPorPosicion(Integer.class);
        Integer result = instance.getFront();
        assertEquals(expResult, result, "Cuando no hay elementos en la estructura getFront() debería devolver null.");
    }
    
    @Test
    public void testGetFront_shouldReturnFirstElement() {
        System.out.println("testGetFront_shouldReturnNull");
        Integer expResult = 99;
        ColaPorPosicion<Integer> instance = new ColaPorPosicion(Integer.class);
        instance.enqueue(99);
        Integer result = instance.getFront();
        assertEquals(expResult, result, "Se esperaba recuperar el elemento 99.");
    }
    
    @Test
    public void testGetFront_shouldReturnElementsInOrder() {
        System.out.println("testGetFront_shouldReturnElementsInOrder");
        
        ColaPorPosicion<Integer> instance = new ColaPorPosicion(Integer.class, 100);
        ListaEnlazadaNoOrdenada<Integer> expResult = new ListaEnlazadaNoOrdenada();
        for (int i = 1; i <= 100; i++) {
            expResult.addToRear(i);
            instance.enqueue(i);
        }
        
        ListaEnlazadaNoOrdenada<Integer> result = new ListaEnlazadaNoOrdenada();
        
        while (!instance.isEmpty()) {
            result.addToRear(instance.getFront());
            instance.dequeue();
        }
        
        Iterador<Integer> iExpResult = expResult.iterador();
        Iterador<Integer> iResult = result.iterador();
        while(iExpResult.existeSiguiente() && iResult.existeSiguiente()) {
            Integer exp = iExpResult.siguiente();
            Integer res = iResult.siguiente();
            
            assertEquals(exp, res, "Las estructuras no son idénticas.");
        }
        
    }
    
    // **************
    // **************
    // dequeue()
    // **************
    // **************
    @Test
    public void testDequeue_shouldRemoveFirst() {
        System.out.println("testDequeue_shouldRemoveFirst");
        
        Integer expected = 1;
        
        ColaPorPosicion<Integer> instance = new ColaPorPosicion(Integer.class);
        instance.enqueue(0);
        for (int i = 1; i <= 10; i++) {
            instance.enqueue(i);
        }
        
        instance.dequeue();
        
        assertEquals(expected, instance.getFront(), "Los elementos no son removidos en el orden correcto.");
    }

    @Test
    public void testDequeue_shouldDoNothing() {
        System.out.println("testDequeue_shouldDoNothing");
        
        ColaPorEnlaces<Integer> instance = new ColaPorEnlaces();
        instance.dequeue();
        
        assertTrue(instance.isEmpty(), "Cuando la estructura está vacía y se invoca a dequeue() no debería suceder nada.");
    }
    
    @Test
    public void testDequeue_shouldBeEmptyAtLast() {
        System.out.println("testDequeue_shouldBeEmptyAtLast");
        
        ColaPorPosicion<Integer> instance = new ColaPorPosicion(Integer.class, 10);
        for (int i = 1; i <= 10; i++) {
            instance.enqueue(i);
        }
        
        for (int i = 1; i <= 10; i++) {
            instance.dequeue();
        }
        
        assertTrue(instance.isEmpty(), "La estructura debería estar vacía.");
    }
    // **************
    // **************
    // enqueue()
    // **************
    // **************
    @Test
    public void testEnqueue_shouldNotBeEmpty() {
        System.out.println("testEnqueue_shouldNotBeEmpty");
        
        ColaPorPosicion<Integer> instance = new ColaPorPosicion(Integer.class);
        instance.enqueue(10);
        
        assertTrue(!instance.isEmpty(), "La estructura debería tener un elemento.");
    }

    // **************
    // **************
    // makeEmpty()
    // **************
    // **************
    @Test
    public void testMakeEmpty_shouldNotBeEmpty() {
        System.out.println("testMakeEmpty_shouldNotBeEmpty");
        
        ColaPorPosicion<Integer> instance = new ColaPorPosicion(Integer.class);
        for (int i = 1; i <= 10; i++) {
            instance.enqueue(i);
        }
        
        instance.makeEmpty();
        
        assertTrue(instance.isEmpty(), "La estructura debería estar vacía.");
    }

    @Test
    public void testToString_shouldReturnEmptyString() {
        System.out.println("testToString_shouldReturnEmptyString");
        
        String expected = "";
        ColaPorPosicion<Integer> cola = new ColaPorPosicion(Integer.class);
        assertEquals(expected, cola.toString(), "Si la estructura es vacía el resultado de toString() debe ser el String vacío");
    }
    
    @Test
    public void testToSring_shouldReturnNotEmptyString(){
        System.out.println("testToSring_shouldReturnNotEmptyString");
        
        String expected = "[1], [2], [3], [4], [5], [6], [7], [8], [9], [10]";
        ColaPorPosicion<Integer> cola = new ColaPorPosicion(Integer.class);
        for (int i = 1; i <= 10; i++) {
            cola.enqueue(i);
        }
        
        assertEquals(expected, cola.toString(), "El método toString() no funciona como se requiere");
    }
}

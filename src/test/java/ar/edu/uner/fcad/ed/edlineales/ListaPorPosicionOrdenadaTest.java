package ar.edu.uner.fcad.ed.edlineales;

import ar.edu.uner.fcad.ed.edlineales.iteradores.Iterador;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 *
 * @author nacho
 */
public class ListaPorPosicionOrdenadaTest {

    //*********
    //*********
    //add()
    //*********
    //*********
    @Test
    public void testAdd_shouldAddElementInOrder() {
        System.out.println("testAdd_shouldAddElementInOrder");
        ListaPorPosicionOrdenada<Integer> instance = new ListaPorPosicionOrdenada(Integer.class, 11);
        for (int i = 10; i >= 0; i--) {
            instance.add(i);
        }
        
        Integer expected = 0;
        Iterador<Integer> iterador = instance.iterador();
        while (iterador.existeSiguiente()) {
            assertEquals(expected++, iterador.siguiente(), "El método add() no funciona como se esperaba");
        }
    }
    
    @Test
    public void testAdd_shouldThrowIllegalStateException () {
        System.out.println("testAdd_shouldThrowIllegalStateException");
        ListaPorPosicionOrdenada<Integer> instance = new ListaPorPosicionOrdenada(Integer.class, 10);
        for (int i = 1; i <= 10; i++) {
            instance.add(i);
        }
        
        boolean entroACatch = false;
        try {
            instance.add(11);
        } catch(Exception ex) {
            entroACatch = true;
        }
        
        assertTrue(entroACatch, "No se produjo la excepción cuando era requerido.");
    }
    
    //*********
    //*********
    //removeFirst()
    //*********
    //*********
    @Test
    public void testRemoveFirst_shouldRemoveFirstElement1() {
        System.out.println("testRemoveFirst_shouldRemoveFirstElement1");

        //Inserto solo elementos pares
        ListaPorPosicionOrdenada<Integer> instance = new ListaPorPosicionOrdenada(Integer.class);
        for (int i = 0; i <= 10; i += 2) {
            instance.add(i);
        }

        Integer expected = instance.first();
        Integer actual = instance.removeFirst();

        assertEquals(expected, actual, "El método removeFirst() no funciona como se espera");
    }

    @Test
    public void testRemoveFirst_shouldRemoveFirstElement2() {
        System.out.println("testRemoveFirst_shouldRemoveFirstElement2");

        //Inserto solo elementos pares
        ListaPorPosicionOrdenada<Integer> instance = new ListaPorPosicionOrdenada(Integer.class);
        for (int i = 0; i <= 10; i += 2) {
            instance.add(i);
        }

        //Tomo el segundo elemento
        Integer expected = instance.get(1);
        //Quito el primer elemento
        instance.removeFirst();
        //Si el ahora primer elemento es igual al almacenado en expected => funcionó bien
        assertEquals(expected, instance.first(), "El método removeFirst() no funciona como se espera");
    }

    @Test
    public void testRemoveFirst_shouldReturnNull() {
        System.out.println("testRemoveFirst_shouldReturnNull");

        //Creo una lista vacía
        ListaPorPosicionOrdenada<Integer> instance = new ListaPorPosicionOrdenada(Integer.class);

        //Elimino el primero
        Integer resultado = instance.removeFirst();

        assertEquals(null, resultado, "Se esperaba null");
    }

    //*********
    //*********
    //removeLast()
    //*********
    //*********
    @Test
    public void testRemoveLast_shouldRemoveLastElement1() {
        System.out.println("testRemoveLast_shouldRemoveLastElement1");

        //Inserto solo elementos pares
        ListaPorPosicionOrdenada<Integer> instance = new ListaPorPosicionOrdenada(Integer.class);
        for (int i = 0; i <= 10; i += 2) {
            instance.add(i);
        }

        //Obtengo el último elemento
        Integer expected = instance.last();

        //Elimino el último
        Integer actual = instance.removeLast();

        //Si el elemento eliminado es igual al último => funcionó correctamente.
        assertEquals(expected, actual, "El método removeLast() no funciona como se espera");
    }

    @Test
    public void testRemoveLast_shouldRemoveLastElement2() {
        System.out.println("testRemoveLast_shouldRemoveLastElement2");

        //Inserto solo elementos pares
        ListaPorPosicionOrdenada<Integer> instance = new ListaPorPosicionOrdenada(Integer.class);
        for (int i = 0; i <= 10; i += 2) {
            instance.add(i);
        }

        //Obtengo el ante último elemento
        Integer expected = instance.get(instance.size() - 2);

        //Elimino el último
        instance.removeLast();

        assertEquals(expected, instance.last(), "El método removeLast() no funciona como se espera");
    }

    @Test
    public void testRemoveLast_shouldRemoveOnlyElement() {
        System.out.println("testRemoveLast_shouldRemoveOnlyElement");

        //Creo una lista vacía
        ListaPorPosicionOrdenada<Integer> instance = new ListaPorPosicionOrdenada(Integer.class);
        instance.add(100);

        //Obtengo el último elemento
        Integer expected = instance.last();
        //Elimino el primero
        Integer actual = instance.removeLast();

        assertEquals(expected, actual, "Se esperaba quitar el último elemento de la lista");
    }

    @Test
    public void testRemoveLast_shouldReturnNull() {
        System.out.println("testRemoveFirst_shouldReturnNull");

        //Creo una lista vacía
        ListaPorPosicionOrdenada<Integer> instance = new ListaPorPosicionOrdenada(Integer.class);

        //Elimino el primero
        Integer resultado = instance.removeLast();

        assertEquals(null, resultado, "Se esperaba null");
    }

    //*********
    //*********
    //remove()
    //*********
    //*********
    @Test
    public void testRemoveByElement_shouldRemoveElement1() {
        System.out.println("testRemoveByElement_shouldRemoveElement1");

        //Inserto solo elementos pares
        ListaPorPosicionOrdenada<Integer> instance = new ListaPorPosicionOrdenada(Integer.class);
        for (int i = 0; i <= 10; i += 2) {
            instance.add(i);
        }

        Integer expected = 6;
        Integer actual = instance.remove(new Integer(6));

        assertEquals(expected, actual, "El método remove() no funciona como se esperaba");

    }

    @Test
    public void testRemoveByElement_shouldRemoveElement2() {
        System.out.println("testRemoveByElement_shouldRemoveElement2");

        //Inserto solo elementos pares
        ListaPorPosicionOrdenada<Integer> instance = new ListaPorPosicionOrdenada(Integer.class);
        instance.add(100);

        Integer expected = 100;
        Integer actual = instance.remove(new Integer(100));

        assertEquals(expected, actual, "El método remove() no funciona como se esperaba");

    }

    @Test
    public void testRemoveByElement_shouldRemoveNone() {
        System.out.println("testRemoveByElement_shouldRemoveNone");
        boolean ingreso = false;

        //Inserto solo elementos pares
        ListaPorPosicionOrdenada<Integer> instance = new ListaPorPosicionOrdenada(Integer.class);
        instance.add(100);
        try {
            instance.remove(new Integer(1000));
        } catch (Exception exc) {
            ingreso = true;
        }

        assertTrue(ingreso, "El método remove() no funciona como se esperaba");

    }

    @Test
    public void testRemoveByPosition_shouldRemoveNone() {
        System.out.println("testRemoveByPosition_shouldRemoveNone");

        //Inserto solo elementos pares
        ListaPorPosicionOrdenada<Integer> instance = new ListaPorPosicionOrdenada(Integer.class);
        for (int i = 0; i <= 10; i += 2) {
            instance.add(i);
        }
        
        Integer expected = 0;
        Integer actual = instance.remove(0);

        assertEquals(expected, actual, "El método remove() no funciona como se esperaba");

    }

    //*********
    //*********
    //first()
    //*********
    //*********
    @Test
    public void testFirst_shouldReturnFirst() {
        System.out.println("testFirst_shouldReturnFirst");

        //Inserto solo elementos pares
        ListaPorPosicionOrdenada<Integer> instance = new ListaPorPosicionOrdenada(Integer.class);
        for (int i = 0; i <= 10; i += 2) {
            instance.add(i);
        }
        
        Integer expected = 0;
        Integer actual = instance.first();

        assertEquals(expected, actual, "El método first() no funciona como se esperaba");
    }
    
    @Test
    public void testFirst_shouldReturnNull() {
        System.out.println("testFirst_shouldReturnNull");

        //Inserto solo elementos pares
        ListaPorPosicionOrdenada<Integer> instance = new ListaPorPosicionOrdenada(Integer.class);
        
        Integer expected = null;
        Integer actual = instance.first();

        assertEquals(expected, actual, "El método first() no funciona como se esperaba");

    }
    
    //*********
    //*********
    //get()
    //*********
    //*********
    public void testGet_shouldReturnElement() {
        System.out.println("testGet_shouldReturnElement");
        
        //Inserto solo elementos pares
        ListaPorPosicionOrdenada<Integer> instance = new ListaPorPosicionOrdenada(Integer.class);
        for (int i = 0; i <= 10; i += 2) {
            instance.add(i);
        }
        
        Integer expected = 20;
        Integer actual = instance.get(10);
        assertEquals(expected, actual, "El método get() no funciona como se esperaba");
    }
    
    @Test
    public void testGet_shouldBeoutOfBounds() {
        System.out.println("testGet_shouldBeoutOfBounds");
        boolean ingreso = false;
        
        //Inserto solo elementos pares
        ListaPorPosicionOrdenada<Integer> instance = new ListaPorPosicionOrdenada(Integer.class);
        for (int i = 0; i <= 10; i += 2) {
            instance.add(i);
        }
        
        try {
            instance.get(100);
        } catch (Exception exc) { 
            ingreso = true;
        }
        
        assertTrue(ingreso, "El método get() no funciona como se esperaba");
        ingreso = false;
        
        try {
            instance.get(-100);
        } catch (Exception exc) { 
            ingreso = true;
        }
        
        assertTrue(ingreso, "El método get() no funciona como se esperaba");
    }
    
    //*********
    //*********
    //set()
    //*********
    //*********
    @Test
    public void testSet_shouldUpdateNode() {
        System.out.println("testSet_shouldUpdateNode");
        
        //Inserto solo elementos pares
        ListaPorPosicionOrdenada<Integer> instance = new ListaPorPosicionOrdenada(Integer.class);
        for (int i = 0; i <= 10; i += 2) {
            instance.add(i);
        }
        Integer expected = 5;
        instance.set(expected, 2);
        Integer actual = instance.get(2);
        
        assertEquals(expected, actual, "El método set() no funciona como se esperaba");
    }
    
    @Test
    public void testSet_shouldBeoutOfBounds() {
        System.out.println("testSet_shouldBeoutOfBounds");
        boolean ingreso = false;
        
        //Inserto solo elementos pares
        ListaPorPosicionOrdenada<Integer> instance = new ListaPorPosicionOrdenada(Integer.class);
        for (int i = 0; i <= 10; i += 2) {
            instance.add(i);
        }
        
        try {
            instance.set(5, 100);
        } catch (Exception exc) { 
            ingreso = true;
        }
        
        assertTrue(ingreso, "El método set() no funciona como se esperaba");
        ingreso = false;
        
        try {
            instance.set(5, -100);
        } catch (Exception exc) { 
            ingreso = true;
        }
        
        assertTrue(ingreso, "El método set() no funciona como se esperaba");
    }
    
    //*********
    //*********
    //last()
    //*********
    //*********
    @Test
    public void testLast_shouldReturnNull() {
        System.out.println("testLast_shouldReturnNull");
        Integer expected = null;
        ListaPorPosicionOrdenada<Integer> instance = new ListaPorPosicionOrdenada(Integer.class);
        assertEquals(expected, instance.last(), "last() debería devolver null.");
    }

    @Test
    public void testLast_shouldReturnLastElement() {
        System.out.println("testLast_shouldReturnLastElement");

        Integer expected = 100;

        ListaPorPosicionOrdenada<Integer> instance = new ListaPorPosicionOrdenada(Integer.class);
        instance.add(10);
        instance.add(100);

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

        ListaPorPosicionOrdenada<Integer> instance = new ListaPorPosicionOrdenada(Integer.class);
        instance.add(10);

        assertFalse(instance.contains(100), "contains() debería devolver false.");
    }

    @Test
    public void testContains_shouldReturnTrue() {
        System.out.println("testContains_shouldReturnTrue");

        ListaPorPosicionOrdenada<Integer> instance = new ListaPorPosicionOrdenada(Integer.class);
        instance.add(10);
        instance.add(100);

        assertTrue(instance.contains(100), "contains() debería devolver true.");
    }

    //*********
    //*********
    //indexOf()
    //*********
    //*********
    @Test
    public void testIndexOf_shouldReturnNegativeValue1() {
        System.out.println("testIndexOf_shouldReturnNegativeValue1");
        Integer expected = -1;
        ListaPorPosicionOrdenada<Integer> instance = new ListaPorPosicionOrdenada(Integer.class);
        instance.add(10);
        assertEquals(expected, instance.indexOf(100), "indexOf() debería devolver -1.");
    }

    @Test
    public void testIndexOf_shouldReturnNegativeValue2() {
        System.out.println("testIndexOf_shouldReturnNegativeValue2");
        Integer expected = -1;
        ListaPorPosicionOrdenada<Integer> instance = new ListaPorPosicionOrdenada(Integer.class);
        assertEquals(expected, instance.indexOf(100), "indexOf() debería devolver -1.");
    }

    @Test
    public void testIndexOf_shouldReturnGraterThanZero() {
        System.out.println("testIndexOf_shouldReturnGraterThanZero");
        Integer expected = 1;
        ListaPorPosicionOrdenada<Integer> instance = new ListaPorPosicionOrdenada(Integer.class);
        instance.add(10);
        instance.add(100);
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
        ListaPorPosicionOrdenada<Integer> instance = new ListaPorPosicionOrdenada(Integer.class);
        instance.add(10);
        assertFalse(instance.isEmpty(), "isEmpty() debería devolver false.");
    }

    @Test
    public void testIsEmpty_shouldReturnTrue() {
        System.out.println("testIsEmpty_shouldReturnTrue");
        ListaPorPosicionOrdenada<Integer> instance = new ListaPorPosicionOrdenada(Integer.class);
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
        ListaPorPosicionOrdenada<Integer> instance = new ListaPorPosicionOrdenada(Integer.class);
        assertEquals(expected, instance.size(), "size() debe ser 0.");
    }

    @Test
    public void testSize_shouldReturnGreaterThanZero() {
        System.out.println("testSize_shouldReturnGreaterThanZero");
        Integer expected = 10;
        ListaPorPosicionOrdenada<Integer> instance = new ListaPorPosicionOrdenada(Integer.class);
        for (int i = 1; i <= 10; i++) {
            instance.add(i);
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
        ListaPorPosicionOrdenada<Integer> instance = new ListaPorPosicionOrdenada(Integer.class);
        assertEquals(expected, instance.toString(), "Debería retornar el String vacío.");
    }

    @Test
    public void testToString_shouldReturnNotEmptyString() {
        System.out.println("testToString_shouldReturnNotEmptyString");
        String expected = "[1], [2], [3], [4], [5], [6], [7], [8], [9], [10]";
        ListaPorPosicionOrdenada<Integer> instance = new ListaPorPosicionOrdenada(Integer.class);
        for (int i = 1; i <= 10; i++) {
            instance.add(i);
        }
        assertEquals(expected, instance.toString(), "toString() no funciona como debería.");
    }

}


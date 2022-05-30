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

        int indexOf = instance.indexOf(4);

        assertEquals(expected, instance.get(indexOf + 1), "El elemento no es el esperado");
    }

    @Test
    public void testAddAfter_shouldAddElementAtLast() {
        System.out.println("testAddAfter_shouldAddElementAtLast");

        Integer expected = 5;

        ListaEnlazadaNoOrdenada<Integer> instance = new ListaEnlazadaNoOrdenada();
        for (int i = 1; i <= 10; i++) {
            instance.addToRear(i * 2);
        }

        instance.addAfter(5, 20);

        assertEquals(expected, instance.last(), "El elemento ubicado al final de la lista no es el esperado.");
    }

    @Test
    public void testAddAfter_shouldGenerateException() {
        System.out.println("testAddAfter_shouldGenerateException");

        boolean ingreso = false;
        try {
            ListaEnlazadaNoOrdenada<Integer> instance = new ListaEnlazadaNoOrdenada();
            for (int i = 1; i <= 10; i++) {
                instance.addToRear(i * 2);
            }
            //Intento insertar un elemento después de uno que no existe en la estructura.
            instance.addAfter(5, 7);

        } catch (Exception exc) {
            ingreso = true;
        }

        assertTrue(ingreso, "Debería haberse generado una excepción");
    }

    //*********
    //*********
    //addAll()
    //*********
    @Test
    public void testAddAll_shouldAddAllElements() {
        System.out.println("testAddAll_shouldAddAllElements");

        //Inserto solo elementos pares
        ListaEnlazadaNoOrdenada<Integer> todos = new ListaEnlazadaNoOrdenada();
        for (int i = 0; i <= 10; i += 2) {
            todos.addToRear(i);
        }

        //Inserto elementos impares
        ListaEnlazadaNoOrdenada<Integer> impares = new ListaEnlazadaNoOrdenada();
        for (int i = 1; i <= 10; i += 2) {
            impares.addToRear(i);
        }

        todos.addAll(impares);

        Iterador<Integer> iterador = impares.iterador();
        while (iterador.existeSiguiente()) {
            Integer elementoActual = iterador.siguiente();
            assertFalse(!todos.contains(elementoActual), "La lista debería contener todos los elementos de impares");
        }
    }

    @Test
    public void testAddAll_shouldAddNone1() {
        System.out.println("testAddAll_shouldAddNone1");

        //Inserto solo elementos pares
        ListaEnlazadaNoOrdenada<Integer> todos = new ListaEnlazadaNoOrdenada();
        for (int i = 0; i <= 10; i += 2) {
            todos.addToRear(i);
        }

        int expected = todos.size();

        ListaEnlazadaNoOrdenada<Integer> param = null;

        todos.addAll(param);

        assertEquals(expected, todos.size(), "La lista vacía no agrega elementos");
    }

    @Test
    public void testAddAll_shouldAddNone2() {
        System.out.println("testAddAll_shouldAddNone2");

        //Inserto solo elementos pares
        ListaEnlazadaNoOrdenada<Integer> todos = new ListaEnlazadaNoOrdenada();
        for (int i = 0; i <= 10; i += 2) {
            todos.addToRear(i);
        }

        int expected = todos.size();

        ListaEnlazadaNoOrdenada<Integer> param = new ListaEnlazadaNoOrdenada();

        todos.addAll(param);

        assertEquals(expected, todos.size(), "La lista vacía no agrega elementos");
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
        ListaEnlazadaNoOrdenada<Integer> instance = new ListaEnlazadaNoOrdenada();
        for (int i = 0; i <= 10; i += 2) {
            instance.addToRear(i);
        }

        Integer expected = instance.first();
        Integer actual = instance.removeFirst();

        assertEquals(expected, actual, "El método removeFirst() no funciona como se espera");
    }

    @Test
    public void testRemoveFirst_shouldRemoveFirstElement2() {
        System.out.println("testRemoveFirst_shouldRemoveFirstElement2");

        //Inserto solo elementos pares
        ListaEnlazadaNoOrdenada<Integer> instance = new ListaEnlazadaNoOrdenada();
        for (int i = 0; i <= 10; i += 2) {
            instance.addToRear(i);
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
        ListaEnlazadaNoOrdenada<Integer> instance = new ListaEnlazadaNoOrdenada();

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
        ListaEnlazadaNoOrdenada<Integer> instance = new ListaEnlazadaNoOrdenada();
        for (int i = 0; i <= 10; i += 2) {
            instance.addToRear(i);
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
        ListaEnlazadaNoOrdenada<Integer> instance = new ListaEnlazadaNoOrdenada();
        for (int i = 0; i <= 10; i += 2) {
            instance.addToRear(i);
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
        ListaEnlazadaNoOrdenada<Integer> instance = new ListaEnlazadaNoOrdenada();
        instance.addToRear(100);

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
        ListaEnlazadaNoOrdenada<Integer> instance = new ListaEnlazadaNoOrdenada();

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
        ListaEnlazadaNoOrdenada<Integer> instance = new ListaEnlazadaNoOrdenada();
        for (int i = 0; i <= 10; i += 2) {
            instance.addToRear(i);
        }

        Integer expected = 6;
        Integer actual = instance.remove(new Integer(6));

        assertEquals(expected, actual, "El método remove() no funciona como se esperaba");

    }

    @Test
    public void testRemoveByElement_shouldRemoveElement2() {
        System.out.println("testRemoveByElement_shouldRemoveElement2");

        //Inserto solo elementos pares
        ListaEnlazadaNoOrdenada<Integer> instance = new ListaEnlazadaNoOrdenada();
        instance.addToRear(100);

        Integer expected = 100;
        Integer actual = instance.remove(new Integer(100));

        assertEquals(expected, actual, "El método remove() no funciona como se esperaba");

    }

    @Test
    public void testRemoveByElement_shouldRemoveNone() {
        System.out.println("testRemoveByElement_shouldRemoveNone");
        boolean ingreso = false;

        //Inserto solo elementos pares
        ListaEnlazadaNoOrdenada<Integer> instance = new ListaEnlazadaNoOrdenada();
        instance.addToRear(100);
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
        ListaEnlazadaNoOrdenada<Integer> instance = new ListaEnlazadaNoOrdenada();
        for (int i = 0; i <= 10; i += 2) {
            instance.addToRear(i);
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
        ListaEnlazadaNoOrdenada<Integer> instance = new ListaEnlazadaNoOrdenada();
        for (int i = 0; i <= 10; i += 2) {
            instance.addToRear(i);
        }
        
        Integer expected = 0;
        Integer actual = instance.first();

        assertEquals(expected, actual, "El método first() no funciona como se esperaba");
    }
    
    @Test
    public void testFirst_shouldReturnNull() {
        System.out.println("testFirst_shouldReturnNull");

        //Inserto solo elementos pares
        ListaEnlazadaNoOrdenada<Integer> instance = new ListaEnlazadaNoOrdenada();
        
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
        ListaEnlazadaNoOrdenada<Integer> instance = new ListaEnlazadaNoOrdenada();
        for (int i = 0; i <= 10; i += 2) {
            instance.addToRear(i);
        }
        
        Integer expected = 10;
        Integer actual = instance.get(instance.size() - 1);
        assertEquals(expected, actual, "El método get() no funciona como se esperaba");
    }
    
    @Test
    public void testGet_shouldBeoutOfBounds() {
        System.out.println("testGet_shouldBeoutOfBounds");
        boolean ingreso = false;
        
        //Inserto solo elementos pares
        ListaEnlazadaNoOrdenada<Integer> instance = new ListaEnlazadaNoOrdenada();
        for (int i = 0; i <= 10; i += 2) {
            instance.addToRear(i);
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
        ListaEnlazadaNoOrdenada<Integer> instance = new ListaEnlazadaNoOrdenada();
        for (int i = 0; i <= 10; i += 2) {
            instance.addToRear(i);
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
        ListaEnlazadaNoOrdenada<Integer> instance = new ListaEnlazadaNoOrdenada();
        for (int i = 0; i <= 10; i += 2) {
            instance.addToRear(i);
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
    public void testIndexOf_shouldReturnNegativeValue1() {
        System.out.println("testIndexOf_shouldReturnNegativeValue1");
        Integer expected = -1;
        ListaEnlazadaNoOrdenada<Integer> instance = new ListaEnlazadaNoOrdenada();
        instance.addToRear(10);
        assertEquals(expected, instance.indexOf(100), "indexOf() debería devolver -1.");
    }

    @Test
    public void testIndexOf_shouldReturnNegativeValue2() {
        System.out.println("testIndexOf_shouldReturnNegativeValue2");
        Integer expected = -1;
        ListaEnlazadaNoOrdenada<Integer> instance = new ListaEnlazadaNoOrdenada();
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

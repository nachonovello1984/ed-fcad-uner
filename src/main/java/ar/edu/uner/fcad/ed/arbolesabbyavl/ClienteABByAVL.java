/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.uner.fcad.ed.arbolesabbyavl;

import ar.edu.uner.fcad.ed.edlineales.iteradores.Iterador;

/**
 *
 * @author Nacho
 */
public class ClienteABByAVL {

    private static void pruebaABB() {
        try {
            ArbolABB<Integer> arbol = new ArbolABB<>();
            arbol.add(4);
            arbol.add(2);
            arbol.add(11);
            arbol.add(3);
            arbol.add(5);
            arbol.add(23);

            System.out.println("Árbol ABB");
            System.out.println("=====================");
            System.out.println(arbol);
            System.out.println();
            System.out.println("Recorrido por niveles");
            System.out.println("=====================");
            Iterador<Integer> iterador = arbol.iteradorPorNiveles();
            while (iterador.existeSiguiente()) {
                System.out.print(iterador.siguiente().toString() + ", ");
            }
            System.out.println();
            System.out.println();
            System.out.println("Recorrido en preorden");
            System.out.println("=====================");
            iterador = arbol.iteradorEnPreOrden();
            while (iterador.existeSiguiente()) {
                System.out.print(iterador.siguiente().toString() + ", ");
            }
            System.out.println();
            System.out.println();
            System.out.println("Recorrido por inorden");
            System.out.println("=====================");
            iterador = arbol.iteradorEnInOrden();
            while (iterador.existeSiguiente()) {
                System.out.print(iterador.siguiente().toString() + ", ");
            }
            System.out.println();
            System.out.println();
            System.out.println("Recorrido por posorden");
            System.out.println("=====================");
            iterador = arbol.iteradorEnPosOrden();
            while (iterador.existeSiguiente()) {
                System.out.print(iterador.siguiente().toString() + ", ");
            }
            System.out.println();
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
    }

    private static void pruebaAVL() {
        ArbolAVL<Integer> arbol = new ArbolAVL<>();
        try {
//            arbol.add(29);
//            arbol.add(94);
//            arbol.add(79);
//            arbol.add(59);
//            arbol.add(49);
//            arbol.add(51);
//            arbol.add(88);
//            arbol.add(24);
//            arbol.add(86);
//            arbol.add(55);
//            arbol.add(05);
//            arbol.add(40);
//            arbol.add(90);
//            arbol.add(80);
//            arbol.add(65);
//            arbol.add(50);
//            arbol.add(30);
//            arbol.add(60);
            
//            arbol.remove(80);
//            arbol.remove(65);
//            arbol.remove(40);
//            arbol.add(48);
//            arbol.add(31);
//            arbol.add(39);
//            arbol.add(57);
//            arbol.add(2);
//            arbol.add(45);
//            arbol.add(99);
//            arbol.add(103);
//            arbol.add(95);
//            arbol.remove(38);
//            arbol.remove(79);
//            arbol.remove(60);
            
            
//            arbol.add(4);
//            arbol.add(11);
//            arbol.add(5);
//            arbol.add(50);
//            arbol.add(96);
//            arbol.add(79);
//            arbol.add(43);
//            arbol.add(44);

            System.out.println("Árbol AVL");
            System.out.println("===========");

            arbol.add(48);
            arbol.add(31);
            arbol.add(39);
            arbol.add(57);
            arbol.add(2);
            arbol.add(45);
            arbol.add(99);
            arbol.add(103);
            arbol.add(95);
            
            System.out.println(arbol);
            
            arbol.remove(31);
            arbol.remove(2);
            
            System.out.println(arbol);
            

//            System.out.println("");
//            System.out.println("Árbol AVL");
//            System.out.println("==============");
//            System.out.println(arbol);
//            
////            //Eliminación: Caso 1
////            System.out.println("Remove (44)");
////            arbol.remove(new Integer(44));
////            System.out.println(arbol);
////            //Eliminación: Caso 2
////            System.out.println("Remove (11)");
////            arbol.remove(new Integer(11));
////            System.out.println(arbol);
//            
////            Eliminación: Caso 3.1
//            System.out.println("Remove (4)");
//            arbol.remove(4);
//            System.out.println(arbol);
//            
//            //Eliminación: Caso 3.2
//            System.out.println("Remove (44)");
//            arbol.remove(44);
//            System.out.println(arbol);
//            System.out.println();
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Árbol ABB
        pruebaABB();
        
        //Árbol AVL
        pruebaAVL();
    }
}

package ar.edu.uner.fcad.ed;

import ar.edu.uner.fcad.ed.arbolesabbyavl.ClienteABByAVL;
import ar.edu.uner.fcad.ed.arbolesbinariosyheaps.ClienteArbolBinarioHeap;
import ar.edu.uner.fcad.ed.edjerarquicas.ClienteEDJerarquicas;
import ar.edu.uner.fcad.ed.edlineales.ClienteEDLineales;
import ar.edu.uner.fcad.ed.mapeosdiccionarios.ClienteMapeosDiccionarios;

/**
 *
 * @author Nacho
 */
public class Cliente {

    public static void main(String [] args) {
        
        //ED Lineales
        ClienteEDLineales.main(null);
        
        //ED Jerárquicas
        ClienteEDJerarquicas.main(null);
        
        //Árbol Binario y Heap
        ClienteArbolBinarioHeap.main(null);
        
        //ABB y AVL
        ClienteABByAVL.main(null);
        
        //Mapas y Diccionarios
        ClienteMapeosDiccionarios.main(null);
        
    }
}

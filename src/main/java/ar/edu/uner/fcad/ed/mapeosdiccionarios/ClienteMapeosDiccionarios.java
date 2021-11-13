package ar.edu.uner.fcad.ed.mapeosdiccionarios;

import ar.edu.uner.fcad.ed.edlineales.iteradores.Iterador;
import ar.edu.uner.fcad.ed.mapeosdiccionarios.diccionarios.DiccionarioConLista;
import ar.edu.uner.fcad.ed.mapeosdiccionarios.diccionarios.DiccionarioInterfaz;
import ar.edu.uner.fcad.ed.mapeosdiccionarios.mapeos.MapeoConLista;
import java.util.logging.Level;
import java.util.logging.Logger;
import ar.edu.uner.fcad.ed.mapeosdiccionarios.mapeos.MapeoInterfaz;

/**
 *
 * @author nacho
 */
public class ClienteMapeosDiccionarios {
    
    private static void mapeosTest() {
        try {
            System.out.println("Mapeo");
            System.out.println("====================================");
            MapeoInterfaz<String, Integer> mapeo = new MapeoConLista();
            
            mapeo.put("Chelsea", 34);
            mapeo.put("Liverpool", 37);
            mapeo.put("Manchester City", 70);
            mapeo.put("Arsenal", 50);
            mapeo.put("Aston Villa", 15);
            
            System.out.println("mapeo = " + mapeo);
            mapeo.remove("Aston Villa");
            
            System.out.println("mapeo.remove('Aston Villa') = " + mapeo);
            
            mapeo.put("Arsenal", 76);
            System.out.println("mapeo = " + mapeo);
            
            System.out.println("mapeo.keySet() = " + mapeo.keySet());
            System.out.println("mapeo.values() = " + mapeo.values());
            System.out.println("mapeo.entrySet() = " + mapeo.entrySet());
        } catch (Exception ex) {
            Logger.getLogger(ClienteMapeosDiccionarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static void diccionariosTest() {
        try {
            System.out.println("Diccionario");
            System.out.println("====================================");
            DiccionarioInterfaz<String, Integer> diccionario = new DiccionarioConLista();
            
            diccionario.insert("Chelsea", 34);
            diccionario.insert("Liverpool", 37);
            diccionario.insert("Manchester City", 70);
            diccionario.insert("Arsenal", 50);
            diccionario.insert("Aston Villa", 15);
            
            System.out.println("diccionario = " + diccionario);
            diccionario.remove("Aston Villa");
            
            System.out.println("diccionario.remove('Aston Villa') = " + diccionario);
            
            diccionario.insert("Arsenal", 76);
            System.out.println("diccionario = " + diccionario);
            
            System.out.println("diccionario.entries() = ");
            
            Iterador<Entrada<String, Integer>> iterador = diccionario.entries().iterador();
            while(iterador.existeSiguiente()) {
                System.out.print(iterador.siguiente());
            }
            
        } catch (Exception ex) {
            Logger.getLogger(ClienteMapeosDiccionarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        mapeosTest();
        
        diccionariosTest();
    }
    
}

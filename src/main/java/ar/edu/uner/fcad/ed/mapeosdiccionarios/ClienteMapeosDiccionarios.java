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
    
    private static void mapasTest() {
        try {
            System.out.println("Mapa");
            System.out.println("====================================");
            MapeoInterfaz<String, Integer> mapa = new MapeoConLista();
            
            mapa.put("Chelsea", 34);
            mapa.put("Liverpool", 37);
            mapa.put("Manchester City", 70);
            mapa.put("Arsenal", 50);
            mapa.put("Aston Villa", 15);
            
            System.out.println("mapa = " + mapa);
            mapa.remove("Aston Villa");
            
            System.out.println("mapa.remove('Aston Villa') = " + mapa);
            
            mapa.put("Arsenal", 76);
            System.out.println("mapa = " + mapa);
            
            System.out.println("mapa.keySet() = " + mapa.keySet());
            System.out.println("mapa.values() = " + mapa.values());
            System.out.println("mapa.entrySet() = " + mapa.entrySet());
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
        mapasTest();
        
        diccionariosTest();
    }
    
}

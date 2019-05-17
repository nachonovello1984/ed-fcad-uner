/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.uner.fcad.ed.edjerarquicas;

/**
 *
 * @author Nacho
 */
public class EDJerarquicasException extends Exception {

    private final String mensaje;

    /**
     * Crea una nueva excepción
     * @param mensaje es el mensaje de error que será mostrado
     */
    public EDJerarquicasException(String mensaje) {
        super();
        this.mensaje = mensaje;
    }

    /**
     * Devuelve el mensaje de error.
     * @return
     */
    @Override
    public String toString() {
        return mensaje;
    }
}

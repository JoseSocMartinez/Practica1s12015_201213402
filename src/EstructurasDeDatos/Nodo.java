/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EstructurasDeDatos;

/**
 *
 * @author Jose
 */
public class Nodo {

    Object dato;
    Nodo adelante;
    Nodo atras;

    public Nodo(Object entrada) {
        dato = entrada;
        adelante = atras = null;
    }
}

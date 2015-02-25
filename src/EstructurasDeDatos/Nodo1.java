/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EstructurasDeDatos;

/**
 *
 * @author Jose
 */
public class Nodo1 {

    Object dato;
    Nodo1 adelante;
    Nodo1 atras;

    public Nodo1(Object entrada) {
        dato = entrada;
        adelante = atras = null;
    }
}

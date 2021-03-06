/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EstructurasDeDatos;

/**
 *
 * @author Jose
 */
public class ListaDobleEnlazada {

    Nodo1 cabeza;

    public ListaDobleEnlazada insertarAdelante(Object entrada) {

        Nodo1 nuevo;
        nuevo = new Nodo1(entrada);
        nuevo.adelante = cabeza;
        if (cabeza != null) {
            cabeza.atras = nuevo;
        }
        cabeza = nuevo;

        return this;
    }

    public ListaDobleEnlazada insertaDespues(Nodo1 anterior, Object entrada) {
        Nodo1 nuevo;
        nuevo = new Nodo1(entrada);
        nuevo.adelante = anterior.adelante;
        if (anterior.adelante != null) {
            anterior.adelante.atras = nuevo;
        }
        anterior.adelante = nuevo;
        nuevo.atras = anterior;
        return this;
    }

    public void eliminar(Object entrada) {
        Nodo1 actual;
        boolean encontrado = false;
        actual = cabeza;
        while ((actual != null) && (!encontrado)) {
            encontrado = (actual.dato == entrada);
            if (!encontrado) {
                actual = actual.adelante;
            }
        }
        if (actual != null) {
            if (actual == cabeza) {
                cabeza = actual.adelante;
                if (actual.adelante != null) {
                    actual.adelante.atras = null;
                }
            } else if (actual.adelante != null) {
                actual.atras.adelante = actual.adelante;
                actual.adelante.atras = actual.atras;
            } else {
                actual.atras.adelante = null;
            }
            actual = null;
        }
    }
}

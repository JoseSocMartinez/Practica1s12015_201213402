/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EstructurasDeDatos;

import Entidades.Jugador;

/**
 *
 * @author Jose
 */
public class ListaSimple {

    public NodoSimple primerNodo;
    public NodoSimple ultimoNodo;

    public void agregarAlFinal(Object datos) {
        if (listaVacia()) {
            primerNodo = ultimoNodo = new NodoSimple(datos);
        } else {
            ultimoNodo = ultimoNodo.siguienteNodo = new NodoSimple(datos);
        }
    }

    public void agregarAlFrente(Object datos) {
        if (listaVacia()) {
            primerNodo = ultimoNodo = new NodoSimple(datos);
        } else {
            primerNodo = new NodoSimple(datos, primerNodo);
        }
    }

    public int tamanioDeLaLista() {
        NodoSimple nodo = primerNodo;
        int tamanioLista = 0;
        while (nodo != null) {
            tamanioLista++;
            nodo = nodo.siguienteNodo;
        }
        return tamanioLista;
    }

    boolean listaVacia() {
        return primerNodo == null;
    }

    // elimina el último nodo de la Lista
    public Object eliminarDelFinal() {


        Object elementoEliminado = ultimoNodo.datos; // obtiene los datos que se van eliminar

        // actualiza las referencias primerNodo y ultimoNodo
        if (primerNodo == ultimoNodo) {
            primerNodo = ultimoNodo = null;
        } else // localiza el nuevo último nodo
        {
            NodoSimple actual = primerNodo;

            // itera mientras el nodo actual no haga referencia a ultimoNodo
            while (actual.siguienteNodo != ultimoNodo) {
                actual = actual.siguienteNodo;
            }

            ultimoNodo = actual; // actual el nuevo ultimoNodo
            actual.siguienteNodo = null;
        } // fin de else

        return elementoEliminado; // devue
    }

    public Object eliminarDelFrente() {
        if (!listaVacia()) { // lanza excepción si la Lista está vacía


            Object elementoEliminado = primerNodo.datos; // obtiene los datos que se van aeliminar
            // actualiza las referencias primerNodo y ultimoNodo
            if (primerNodo == ultimoNodo) {
                primerNodo = ultimoNodo = null;
            } else {
                primerNodo = primerNodo.siguienteNodo;
            }
            return elementoEliminado; // devuelve los datos del nodo eliminado
        }else{
            return null;
        }// fin del método eliminarDelFrente
        
    }
    
    public Jugador buscarJugador(String tipo){
       NodoSimple nodo = primerNodo;
        Jugador jugadorBuscado = null;
        Jugador jugador;
        while (nodo != null) {
            jugador = (Jugador) nodo.datos;
            if (tipo.equalsIgnoreCase(jugador.getTipo())) {
                jugadorBuscado = jugador;
                break;
            }
            nodo = nodo.siguienteNodo;
        }

        return jugadorBuscado;
       
       
    }
}

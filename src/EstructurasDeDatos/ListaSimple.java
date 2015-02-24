/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EstructurasDeDatos;

import Entidades.Jugador;
import Entidades.Planta;
import Entidades.Zombi;

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
        } else {
            return null;
        }// fin del método eliminarDelFrente

    }

    public Jugador buscarJugador(String tipo) {
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

    public Planta buscarPlanta(int indice) {
        NodoSimple nodo = primerNodo;
        Planta PlantaBuscada = null;
        Planta planta;
        int i = 0;
        while (nodo != null) {

            planta = (Planta) nodo.datos;
            if (indice == i) {
                PlantaBuscada = planta;
                break;
            }
            nodo = nodo.siguienteNodo;
            i++;
        }

        return PlantaBuscada;


    }

    public Zombi buscarZombi(int indice) {
        NodoSimple nodo = primerNodo;
        Zombi zombiBuscado = null;
        Zombi zombi;
        int i = 0;
        while (nodo != null) {

            zombi = (Zombi) nodo.datos;
            if (indice == i) {
                zombiBuscado = zombi;
                break;
            }
            nodo = nodo.siguienteNodo;
            i++;
        }

        return zombiBuscado;


    }

    public void eliminarPlanta(int indice) {
        NodoSimple actual, anterior;
        actual = primerNodo;
        anterior = null;
        Planta planta;
        int i = 0;
        while (actual != null) {

            planta = (Planta) actual.datos;
            if (indice == i) {

                if (anterior != null) {
                    NodoSimple aux = actual;
                    actual = anterior;
                    actual.siguienteNodo = aux.siguienteNodo;

                } else {
                    NodoSimple aux = actual.siguienteNodo;
                    primerNodo = null;
                    primerNodo = aux;
                }
                break;
            }
            anterior = actual;
            actual = actual.siguienteNodo;
            i++;

        }

    }

    public void eliminarZombi(int indice) {
        NodoSimple actual, anterior;
        actual = primerNodo;
        anterior = null;
        Zombi zombi;
        int i = 0;
        while (actual != null) {

            zombi = (Zombi) actual.datos;
            if (indice == i) {

                if (anterior != null) {
                    NodoSimple aux = actual;
                    actual = anterior;
                    actual.siguienteNodo = aux.siguienteNodo;

                } else {
                    NodoSimple aux = actual.siguienteNodo;
                    primerNodo = null;
                    primerNodo = aux;
                }
                break;
            }
            anterior = actual;
            actual = actual.siguienteNodo;
            i++;

        }
    }

    public void eliminar(int indice) {
        NodoSimple actual, anterior;
        boolean encontrado;
//inicializa los apuntadores
        actual = primerNodo;
        anterior = null;
        encontrado = false;
        int i = 0;
// búsqueda del nodo y del anterior
        while ((actual != null) && (!(indice != i))) {
            encontrado = (i == indice);
            //con objetos: actual.dato.equals(indice)
            if (!encontrado) {
                anterior = actual;
                actual = actual.siguienteNodo;
            }
            i++;
        }
// Enlace del nodo anterior con el siguiente
        if (actual != null) {
            // Distingue entre que el nodo sea el cabecera,
            // o del resto de la lista
            if (actual == primerNodo) {
                primerNodo = actual.siguienteNodo;
            } else {
                anterior.siguienteNodo = actual.siguienteNodo;
            }
            actual = null; // no es necesario al ser una variable local
        }
    }
}

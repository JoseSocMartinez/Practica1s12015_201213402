/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EstructurasDeDatos;

/**
 *
 * @author Jose
 */
public class Cola {

    public NodoSimple primerNodo;
    public NodoSimple ultimoNodo;

    public void agregarACola(Object datos) {
        if (listaVacia()) {
            primerNodo = ultimoNodo = new NodoSimple(datos);
        } else {
            ultimoNodo = ultimoNodo.siguienteNodo = new NodoSimple(datos);
        }
    }

    public Object eliminar() {
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

    boolean listaVacia() {
        return primerNodo == null;
    }
}

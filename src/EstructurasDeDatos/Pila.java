/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EstructurasDeDatos;

/**
 *
 * @author Jose
 */
public class Pila{
   
    public NodoSimple primerNodo;
    public NodoSimple ultimoNodo;
    
    public void apilar(Object datos){
        if (listaVacia()) {
            primerNodo = ultimoNodo = new NodoSimple(datos);
        } else {
            primerNodo = new NodoSimple(datos, primerNodo);
        }
    };
    
    public Object eliminar(){
        if(!listaVacia()){
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
        }
    }
    
    
    boolean listaVacia() {
        return primerNodo == null;
    }
}

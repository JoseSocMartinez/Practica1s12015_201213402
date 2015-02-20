/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import EstructurasDeDatos.ListaSimple;

/**
 *
 * @author Jose
 */
public class Jugador {
    private String tipo;
    private String nombre;
    private int cantidad;
    private ListaSimple lista = new ListaSimple();

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the lista
     */
    public ListaSimple getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(ListaSimple lista) {
        this.lista = lista;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }
}

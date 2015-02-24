package EstructurasDeDatos;

import java.io.*;

public class NodoSimple {

    public NodoSimple siguienteNodo;
    public Object datos;

    NodoSimple(Object datos) {
        this(datos, null);

    }

    NodoSimple(Object datos, NodoSimple siguienteNodo) {

        this.datos = datos;
        this.siguienteNodo = siguienteNodo;
    }

    public NodoSimple getSiguienteNodo() {
        return siguienteNodo;
    }

    public Object getDatos() {
        return datos;
    }
}

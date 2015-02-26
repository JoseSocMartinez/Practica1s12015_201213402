/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphviz;

import Entidades.Jugador;
import Entidades.Planta;
import Entidades.Zombi;
import EstructurasDeDatos.Cola;
import EstructurasDeDatos.ListaSimple;
import EstructurasDeDatos.NodoSimple;
import EstructurasDeDatos.Pila;
import Interfaz.Inicio;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Jose
 */
public class Pintar {

    public void reporteCatalogoPlanta(String titulo) {

        String inicio = "digraph tabla {";
        String fin = "}";
        String nodo = "";
        String puntero = "";
        //this.titulo="node [shape=record];Titulo[label=\""+titulo+"\"];";
        String cadenaCompleta = "";
        ListaSimple lista = Inicio.catalogoPlanta;
        NodoSimple nodoLista = lista.primerNodo;

        for (int i = 0; i < lista.tamanioDeLaLista(); i++) {



            Planta planta = (Planta) nodoLista.datos;

            nodo = nodo + " node [shape=record];nodo" + i + "[label=\"" + "{Nombre|" + planta.getNombre() + "}|{Tipo|" + planta.getTipoAtaque() + "}|{Vida|" + planta.getVida() + "}|{Ataque|" + planta.getAtaque() + "}" + "\"];";
            puntero = puntero + "nodo" + (i) + "->";

            nodoLista = nodoLista.siguienteNodo;

        }
        nodo = nodo + "node [shape=record];nodoNull[label=\"NULL\"];";
        puntero = puntero + "nodoNull;";
        cadenaCompleta = inicio + nodo + puntero + fin;

        Pintar(titulo, cadenaCompleta);

    }

    public void reporteCatalogoZombi(String titulo) {

        String inicio = "digraph tabla {";
        String fin = "}";
        String nodo = "";
        String puntero = "";
        //this.titulo="node [shape=record];Titulo[label=\""+titulo+"\"];";
        String cadenaCompleta = "";
        ListaSimple lista = Inicio.catalogoZombi;
        NodoSimple nodoLista = lista.primerNodo;

        for (int i = 0; i < lista.tamanioDeLaLista(); i++) {



            Zombi zombi = (Zombi) nodoLista.datos;

            nodo = nodo + " node [shape=record];nodo" + i + "[label=\"" + "{Nombre|" + zombi.getNombre() + "}|{Tipo|" + zombi.getTipoAtaque() + "}|{Vida|" + zombi.getVida() + "}|{Ataque|" + zombi.getAtaque() + "}" + "\"];";
            puntero = puntero + "nodo" + (i) + "->";

            nodoLista = nodoLista.siguienteNodo;

        }
        nodo = nodo + "node [shape=record];nodoNull[label=\"NULL\"];";
        puntero = puntero + "nodoNull;";
        cadenaCompleta = inicio + nodo + puntero + fin;

        Pintar(titulo, cadenaCompleta);

    }

    public void reporteJugadores(String titulo) {

        String inicio = "digraph tabla {";
        String fin = "}";
        String nodo = "";
        String punteroi = "";
        String punteroj = "";
        //this.titulo="node [shape=record];Titulo[label=\""+titulo+"\"];";
        String cadenaCompleta = "";
        ListaSimple lista = Inicio.listaJugador;
        NodoSimple nodoLista = lista.primerNodo;

        for (int i = 0; i < lista.tamanioDeLaLista(); i++) {



            Jugador jugador = (Jugador) nodoLista.datos;
            nodo = nodo + " node [shape=record];nodo" + i + "[label=\"" + "{Nombre|" + jugador.getNombre() + "}|{Tipo|" + jugador.getTipo() + "}|{Cantidad de tropas|" + jugador.getCantidad() + "}" + "\"];";

            //punteroi=punteroi+"nodo"+i+"->";
            NodoSimple nodoCampos = jugador.getLista().primerNodo;
            String punteroTemporal = "";
            for (int j = 0; j < jugador.getLista().tamanioDeLaLista(); j++) {
                nodo = nodo + " node [shape=record];nodo" + i + "" + j + "[label=\"" + "{" + (String) nodoCampos.datos + "}\"];";

                punteroTemporal = punteroTemporal + "nodo" + (i) + "" + (j) + "->";
                nodoCampos = nodoCampos.siguienteNodo;
            }
            if (i == 0) {
                punteroi = punteroTemporal;
            } else {
                punteroj = punteroTemporal;
            }
            //nodo=nodo+" node [shape=record];nodo"+i+"[label=\""+"{Nombre|"+jugador.getNombre()+"}|{Tipo|"+jugador.getTipoAtaque()+"}|{Vida|"+jugador.getVida()+"}|{Ataque|"+jugador.getAtaque()+"}"+"\"];";
            //punteroi=punteroi+"nodo"+(i)+"->";

            nodoLista = nodoLista.siguienteNodo;

        }

        nodo = nodo + "node [shape=record];nodoNulli[label=\"NULL\"];node [shape=record];nodoNullj[label=\"NULL\"];";
        punteroi = "{nodo0 ->" + punteroi + "nodoNulli};";
        punteroj = "{nodo1 ->" + punteroj + "nodoNullj};";
        // punteroi=punteroi+"nodoNulli};{nodo0->nodo00};{nodo1->nodo10};";
        // punteroj=punteroj+"nodoNullj};";
        cadenaCompleta = inicio + nodo + punteroi + punteroj + fin;

        Pintar(titulo, cadenaCompleta);

    }

    public void reporteCola(String titulo) {

        String inicio = "digraph tabla {";
        String fin = "}";
        String nodo = "";
        String puntero = "";
        //this.titulo="node [shape=record];Titulo[label=\""+titulo+"\"];";
        String cadenaCompleta = "";
        Cola cola = Inicio.colaPlantas;
        NodoSimple nodoLista = cola.primerNodo;

        for (int i = 0; i < cola.tamanioDeLaCola(); i++) {



            Planta planta = (Planta) nodoLista.datos;

            nodo = nodo + " node [shape=record];nodo" + i + "[label=\"" + "{Nombre|" + planta.getNombre() + "}|{Tipo|" + planta.getTipoAtaque() + "}|{Vida|" + planta.getVida() + "}|{Ataque|" + planta.getAtaque() + "}" + "\"];";
            puntero = puntero + "nodo" + (i) + "->";

            nodoLista = nodoLista.siguienteNodo;

        }
        nodo = nodo + "node [shape=record];nodoNull[label=\"NULL\"];";
        puntero = puntero + "nodoNull;";
        cadenaCompleta = inicio + nodo + puntero + fin;

        Pintar(titulo, cadenaCompleta);

    }

    public void reportePila(String titulo) {

        String inicio = "digraph tabla {";
        String fin = "}";
        String nodo = "";
        String puntero = "";
        //this.titulo="node [shape=record];Titulo[label=\""+titulo+"\"];";
        String cadenaCompleta = "";
        Pila pila = Inicio.pilaZombis;
        NodoSimple nodoLista = pila.primerNodo;

        for (int i = 0; i < pila.tamanioDeLaPila(); i++) {



            Zombi zombi = (Zombi) nodoLista.datos;

            nodo = nodo + " node [shape=record];nodo" + i + "[label=\"" + "{Nombre|" + zombi.getNombre() + "}|{Tipo|" + zombi.getTipoAtaque() + "}|{Vida|" + zombi.getVida() + "}|{Ataque|" + zombi.getAtaque() + "}" + "\"];";
            puntero = puntero + "nodo" + (i) + "->";

            nodoLista = nodoLista.siguienteNodo;

        }
        nodo = nodo + "node [shape=record];nodoNull[label=\"NULL\"];";
        puntero = puntero + "nodoNull;";
        cadenaCompleta = inicio + nodo + puntero + fin;

        Pintar(titulo, cadenaCompleta);

    }

    public void Pintar(String titulo, String cadena) {


        //Escribimos un fichero
        try {
            //Abro stream, crea el fichero si no existe
            FileWriter file = new FileWriter(titulo + ".txt");
            //Escribimos en el fichero un String y un caracter 97 (a)
            file.write(cadena);
            //Cierro el stream
            file.close();

        } catch (IOException e) {
            System.out.println("Error E/S: " + e);
        }


        try {


            String dotPath = "C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe";

            String fileInputPath = titulo + ".txt";
            String fileOutputPath = "" + titulo + ".jpg";

            String tParam = "-Tjpg";
            String tOParam = "-o";

            String[] cmd = new String[5];
            cmd[0] = dotPath;
            cmd[1] = tParam;
            cmd[2] = fileInputPath;
            cmd[3] = tOParam;
            cmd[4] = fileOutputPath;

            Runtime rt = Runtime.getRuntime();

            rt.exec(cmd);

        } catch (Exception ex) {
            ex.printStackTrace();

        } finally {
            //      JOptionPane.showMessageDialog(, "Eliminado", "", JOptionPane.INFORMATION_MESSAGE);
//            JOptionPane.showMessageDialog(this,"Imagen generada con éxito en I:\\"+nomArchivo+".jpg"); 
        }

    }
}

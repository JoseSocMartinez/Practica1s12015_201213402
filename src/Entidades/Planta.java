/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import EstructurasDeDatos.NodoSimple;
import Interfaz.Inicio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Jose
 */
public class Planta extends JButton {

    private int ataque;
    private int vida;
    private String tipoAtaque;
    private String nombre;
    private String foto;

    /**
     * @return the ataque
     */
    public Planta() {
        // setIcon(new ImageIcon(getFoto()));
        // setSize(100, 100);
        evento();
    }

    public Planta(Boolean disparar) {

        //setIcon(new ImageIcon(getFoto()));
        setSize(100, 100);
        if (disparar) {
            //llama al metodo disparar
        }
    }

    public int getAtaque() {
        return ataque;
    }

    /**
     * @param ataque the ataque to set
     */
    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    /**
     * @return the vida
     */
    public int getVida() {
        return vida;
    }

    /**
     * @param vida the vida to set
     */
    public void setVida(int vida) {
        this.vida = vida;
    }

    /**
     * @return the tipoAtaque
     */
    public String getTipoAtaque() {
        return tipoAtaque;
    }

    /**
     * @param tipoAtaque the tipoAtaque to set
     */
    public void setTipoAtaque(String tipoAtaque) {
        this.tipoAtaque = tipoAtaque;
    }

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
     * @return the foto
     */
    public String getFoto() {
        return foto;
    }

    /**
     * @param foto the foto to set
     */
    public void setFoto(String foto) {
        this.foto = foto;
    }

    void evento() {
        addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setVisible(false);
                Inicio.colaPlantas.eliminar();

                NodoSimple nodoCola = Inicio.colaPlantas.primerNodo;
                for (int i = 0; i < Inicio.colaPlantas.tamanioDeLaCola(); i++) {

//            JButton b=new JButton();
//            b.setBounds(0, 0, 100,100);
//            panelPlanta.add(b);

                    Planta plantaCola = (Planta) nodoCola.datos;
                    plantaCola.setBounds(0, i * 100, 100, 100);


                    nodoCola = nodoCola.siguienteNodo;
                }

            }
        });

    }
}

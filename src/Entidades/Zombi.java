/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import EstructurasDeDatos.NodoSimple;
import Interfaz.Inicio;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Jose
 */
public class Zombi extends JButton {

    private int ataque;
    private int vida;
    private String tipoAtaque;
    private String nombre;
    private String foto;

    /**
     * @return the ataque
     */
    public Zombi() {

        evento();

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
                Inicio.pilaZombis.eliminar();

                NodoSimple nodoPila = Inicio.pilaZombis.primerNodo;
                for (int i = 0; i < Inicio.pilaZombis.tamanioDeLaPila(); i++) {

//            JButton b=new JButton();
//            b.setBounds(0, 0, 100,100);
//            panelPlanta.add(b);

                    Zombi plantaPila = (Zombi) nodoPila.datos;
                    plantaPila.setBounds(0, i * 100, 100, 100);


                    nodoPila = nodoPila.siguienteNodo;
                }

            }
        });

    }
}

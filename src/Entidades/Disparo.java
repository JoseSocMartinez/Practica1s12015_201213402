/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.awt.Color;
import static java.lang.Thread.sleep;
import javax.swing.*;

/**
 *
 * @author Jose
 */
public class Disparo extends JLabel {

    int danio;
    int velocidad;
    int x;
    int y;
    Thread hilo1;

    ;
    
    public Disparo(int danio, final int x, final int y) {

        setLocation(x, y);
        this.danio = danio;
        this.x = x;
        this.y = y;


    }

    public void disparar() {


        // this.x=x;
        // this.y=y;
        setSize(30, 30);
        setBackground(Color.red);

        hilo1 = new Thread() {
            @Override
            public void run() {
                Boolean estado = true;
                while (estado) {
                    if (getLocation().x < 500) {
                        setLocation(getLocation().x + 10, y);
                    } else {
                        estado = false;
                        hilo1.stop();
                    }

                    try {
                        sleep(1000);
                    } catch (Exception e) {
                    }
                }

            }
        };
        hilo1.start();
    }
}

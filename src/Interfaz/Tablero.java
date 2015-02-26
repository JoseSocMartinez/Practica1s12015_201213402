/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Entidades.Jugador;
import Entidades.Planta;
import Entidades.Zombi;
import EstructurasDeDatos.ListaSimple;
import EstructurasDeDatos.NodoSimple;
import static Interfaz.Inicio.catalogoPlanta;
import graphviz.Pintar;
import java.awt.Color;
import java.awt.Dimension;
import static java.lang.Thread.sleep;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Jose
 */
public class Tablero extends javax.swing.JFrame {

    /**
     * Creates new form Tablero
     */
    JPanel pPlanta = new JPanel();
    JPanel pZombi = new JPanel();

    public Tablero() {
        initComponents();
        setResizable(false);
        //panelPlanta.setLayout(null);
        //panelPlanta.setSize(100, 500);


//        NodoSimple nodoCatalogoPlanta = Inicio.catalogoPlanta.primerNodo;
//        for (int i = 0; i < Inicio.catalogoPlanta.tamanioDeLaLista(); i++) {
//
//            Planta zombi = (Planta) nodoCatalogoPlanta.datos;
//            Inicio.colaPlantas.agregarACola(zombi);
//            nodoCatalogoPlanta = nodoCatalogoPlanta.siguienteNodo;
//        }
//
//
//
//        NodoSimple nodoCola = Inicio.colaPlantas.primerNodo;
//        for (int i = 0; i < Inicio.colaPlantas.tamanioDeLaCola(); i++) {
//
////            JButton b=new JButton();
////            b.setBounds(0, 0, 100,100);
////            panelPlanta.add(b);
//
//            Planta plantaCola = (Planta) nodoCola.datos;
//            plantaCola.setBounds(0, i * 100, 100, 100);
//            pPlanta.add(plantaCola);
//
//            nodoCola = nodoCola.siguienteNodo;
//        }
//
//        pPlanta.setLayout(null);
//        pPlanta.setVisible(true);
//        pPlanta.setPreferredSize(new Dimension(100, Inicio.colaPlantas.tamanioDeLaCola() * 100));
//        scrolPlanta.setViewportView(pPlanta);
        agregarPlanta();
        agregarZombi();


        /*NodoSimple nodo = Inicio.catalogoZombi.primerNodo;
         for (int i = 0; i < Inicio.catalogoZombi.tamanioDeLaLista(); i++) {

         Zombi zombi = (Zombi) nodo.datos;
         Inicio.pilaZombis.apilar(zombi);
         nodo = nodo.siguienteNodo;
         }

         NodoSimple nodoPila = Inicio.pilaZombis.primerNodo;
         for (int i = 0; i < Inicio.pilaZombis.tamanioDeLaPila(); i++) {

         //            JButton b=new JButton();
         //            b.setBounds(0, 0, 100,100);
         //            panelPlanta.add(b);

         Zombi zombiPila = (Zombi) nodoPila.datos;
         zombiPila.setBounds(0, i * 100, 100, 100);
         pZombi.add(zombiPila);

         nodoPila = nodoPila.siguienteNodo;
         }
         pZombi.setLayout(null);
         pZombi.setVisible(true);
         pZombi.setPreferredSize(new Dimension(100, Inicio.pilaZombis.tamanioDeLaPila() * 100));
         scrolZombi.setViewportView(pZombi);//*/

    }

    public void agregarPlanta() {

        Thread hiloAgregarPlanta = new Thread() {
            @Override
            public void run() {

                Jugador jugadorPlanta = Inicio.listaJugador.buscarJugador("Planta");
                System.out.println("jugador " + jugadorPlanta.getTipo());
                ListaSimple catalogoPlantas = Inicio.catalogoPlanta;
                System.out.println("tamanio catalogo " + catalogoPlantas.tamanioDeLaLista());
                pPlanta.setPreferredSize(new Dimension(100, 8 * 100));
                Random random = new Random();
                if (jugadorPlanta.getCantidad() >= 5) {
                    for (int i = 0; i < 5; i++) {

                        int aleatorio = random.nextInt(catalogoPlantas.tamanioDeLaLista());
                        System.out.println("random " + aleatorio);
                        //planta = new Planta();
//                        if(aleatorio>1){
//                            aleatorio=-1;
//                        }else{
//                           
//                        }
                        Planta planta2 = new Planta();
                        planta2 = Inicio.catalogoPlanta.buscarPlanta(aleatorio);
                        Planta planta = new Planta();
                        planta.setNombre(planta2.getNombre());
                        planta.setVida(planta2.getVida());
                        planta.setAtaque(planta2.getAtaque());
                        planta.setFoto(planta2.getFoto());
                        if (planta2.getFoto() == null) {
                            planta.setIcon(new ImageIcon(getClass().getResource("/Imagenes/imganenNoDisponible.png")));
                        } else {
                            planta.setIcon(new ImageIcon(planta2.getFoto()));
                        }
                        System.out.println("nombre Planta " + planta.getNombre());
                        planta.setBounds(0, i * 100, 100, 100);
                        pPlanta.add(planta);
                        Inicio.colaPlantas.agregarACola(planta);
                        pPlanta.setBackground(Color.green);
                        pPlanta.setLayout(null);
                        pPlanta.setVisible(true);
                        //pPlanta.setPreferredSize(new Dimension(100, i * 100));
                        scrolPlanta.setViewportView(pPlanta);

                        try {
                            sleep(100);
                        } catch (InterruptedException ex) {
                            //Logger.getLogger(Tablero.class.getName()).log(Level.SEVERE, null, ex);
                        }


                    }
                    jugadorPlanta.setCantidad(jugadorPlanta.getCantidad() - 5);


                    //jugadorPlanta.setCantidad(jugadorZombi.getCantidad() - 5);
                } else {
                    jugadorPlanta.setCantidad(0);
                }



                while (jugadorPlanta.getCantidad() > 0) {
                    try {
                        sleep(5000);
                    } catch (InterruptedException ex) {
                        //Logger.getLogger(Tablero.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    //Random random = new Random();
                    int aleatorio = random.nextInt(catalogoPlantas.tamanioDeLaLista());
                    Planta planta2 = new Planta();
                    Planta planta = new Planta();
                    planta2 = catalogoPlantas.buscarPlanta(aleatorio);

                    planta.setNombre(planta2.getNombre());
                    planta.setVida(planta2.getVida());
                    planta.setAtaque(planta2.getAtaque());
                    planta.setFoto(planta2.getFoto());
                    if (planta2.getFoto() == null) {
                        planta.setIcon(new ImageIcon(getClass().getResource("/Imagenes/imganenNoDisponible.png")));
                    } else {
                        planta.setIcon(new ImageIcon(planta2.getFoto()));
                    }

                    planta.setBounds(0, Inicio.colaPlantas.tamanioDeLaCola() * 100, 100, 100);
                    pPlanta.add(planta);

                    Inicio.colaPlantas.agregarACola(planta);
                    pPlanta.setLayout(null);
                    pPlanta.setVisible(true);
                    //pPlanta.setPreferredSize(new Dimension(100, catalogoZombi.tamanioDeLaLista() * 100));
                    scrolPlanta.setViewportView(pPlanta);

                    jugadorPlanta.setCantidad(jugadorPlanta.getCantidad() - 1);

                    try {
                        sleep(5000);
                    } catch (InterruptedException ex) {
                        //Logger.getLogger(Tablero.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }//fin 

            }
        };
        hiloAgregarPlanta.start();


    }

    public void agregarZombi() {

        Thread hiloAgregarZombi = new Thread() {
            @Override
            public void run() {

                Jugador jugadorZombi = Inicio.listaJugador.buscarJugador("Zombi");
                //System.out.println("jugador "+jugadorZombi.getTipo());
                ListaSimple catalogoZombi = Inicio.catalogoZombi;
                //System.out.println("tamanio catalogo "+catalogoZombi.tamanioDeLaLista());
                pZombi.setPreferredSize(new Dimension(100, 8 * 100));
                Random random = new Random();
                if (jugadorZombi.getCantidad() >= 5) {
                    for (int i = 0; i < 5; i++) {

                        int aleatorio = random.nextInt(catalogoZombi.tamanioDeLaLista());
                        //System.out.println("random "+aleatorio);
                        //planta = new Planta();
//                        if(aleatorio>1){
//                            aleatorio=-1;
//                        }else{
//                           
//                        }
                        Zombi zombi2 = new Zombi();
                        zombi2 = Inicio.catalogoZombi.buscarZombi(aleatorio);
                        Zombi zombi = new Zombi();
                        zombi.setNombre(zombi2.getNombre());
                        zombi.setVida(zombi2.getVida());
                        zombi.setAtaque(zombi2.getAtaque());
                        zombi.setFoto(zombi2.getFoto());
                        if (zombi2.getFoto() == null) {
                            zombi.setIcon(new ImageIcon(getClass().getResource("/Imagenes/imganenNoDisponible.png")));
                        } else {
                            zombi.setIcon(new ImageIcon(zombi2.getFoto()));
                        }
                        //System.out.println("nombre Planta "+zombi.getNombre());
                        zombi.setBounds(0, i * 100, 100, 100);
                        pZombi.add(zombi);
                        Inicio.pilaZombis.apilar(zombi);
                        pZombi.setBackground(Color.ORANGE);
                        pZombi.setLayout(null);
                        pZombi.setVisible(true);
                        //pPlanta.setPreferredSize(new Dimension(100, i * 100));
                        scrolZombi.setViewportView(pZombi);

                        try {
                            sleep(100);
                        } catch (InterruptedException ex) {
                            //Logger.getLogger(Tablero.class.getName()).log(Level.SEVERE, null, ex);
                        }


                    }
                    jugadorZombi.setCantidad(jugadorZombi.getCantidad() - 5);


                    //jugadorPlanta.setCantidad(jugadorZombi.getCantidad() - 5);
                } else {
                    jugadorZombi.setCantidad(0);
                }



                while (jugadorZombi.getCantidad() > 0) {
                    try {
                        sleep(5000);
                    } catch (InterruptedException ex) {
                        //Logger.getLogger(Tablero.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    //Random random = new Random();
                    int aleatorio = random.nextInt(catalogoZombi.tamanioDeLaLista());
                    Zombi zombi2 = new Zombi();
                    Zombi zombi = new Zombi();
                    zombi2 = catalogoZombi.buscarZombi(aleatorio);

                    zombi.setNombre(zombi2.getNombre());
                    zombi.setVida(zombi2.getVida());
                    zombi.setAtaque(zombi2.getAtaque());
                    zombi.setFoto(zombi2.getFoto());
                    if (zombi2.getFoto() == null) {
                        zombi.setIcon(new ImageIcon(getClass().getResource("/Imagenes/imganenNoDisponible.png")));
                    } else {
                        zombi.setIcon(new ImageIcon(zombi2.getFoto()));
                    }

                    zombi.setBounds(0, Inicio.pilaZombis.tamanioDeLaPila() * 100, 100, 100);
                    pZombi.add(zombi);

                    Inicio.pilaZombis.apilar(zombi);
                    pZombi.setLayout(null);
                    pZombi.setVisible(true);
                    //pPlanta.setPreferredSize(new Dimension(100, catalogoZombi.tamanioDeLaLista() * 100));
                    scrolZombi.setViewportView(pZombi);

                    jugadorZombi.setCantidad(jugadorZombi.getCantidad() - 1);

                    try {
                        sleep(5000);
                    } catch (InterruptedException ex) {
                        //Logger.getLogger(Tablero.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }//fin 

            }
        };
        hiloAgregarZombi.start();


    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        scrolZombi = new javax.swing.JScrollPane();
        scrolPlanta = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setBackground(new java.awt.Color(0, 255, 0));
        jButton1.setText("Regresar ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addComponent(jButton1))
        );

        jPanel2.setBackground(new java.awt.Color(51, 255, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 598, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 598, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrolPlanta, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrolZombi, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scrolZombi, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scrolPlanta, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jMenu1.setText("Generar Reportes");

        jMenuItem1.setText("Catalogo zombis");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Catalogo Plantas");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Jugadores");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem4.setText("Cola Plantas");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem5.setText("Pila Zombis");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setVisible(false);
        Inicio inicio = new Inicio();
        inicio.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        if (catalogoPlanta.primerNodo != null) {
            Pintar pintar = new Pintar();
            pintar.reporteCatalogoPlanta("Catalogo de Plantas");
            JOptionPane.showMessageDialog(this, "Reporte generado exitosamente!", "", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "El catalogo de plantas esta vacio!", "", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        if (catalogoPlanta.primerNodo != null) {
            Pintar pintar = new Pintar();
            pintar.reporteCatalogoZombi("Catalogo de Zombis");
            JOptionPane.showMessageDialog(this, "Reporte generado exitosamente!", "", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "El catalogo de zombis esta vacio!", "", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        //if (catalogoPlanta.primerNodo != null) {
        Pintar pintar = new Pintar();
        pintar.reporteJugadores("Jugadores");
        JOptionPane.showMessageDialog(this, "Reporte generado exitosamente!", "", JOptionPane.INFORMATION_MESSAGE);
        //} else {
        //    JOptionPane.showMessageDialog(this, "El catalogo de plantas esta vacio!", "", JOptionPane.INFORMATION_MESSAGE);
        // }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        Pintar pintar = new Pintar();
        pintar.reporteCola("Cola Plantas");
        JOptionPane.showMessageDialog(this, "Reporte generado exitosamente!", "", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        Pintar pintar = new Pintar();
        pintar.reportePila("Pila zombis");
        JOptionPane.showMessageDialog(this, "Reporte generado exitosamente!", "", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_jMenuItem5ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tablero().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane scrolPlanta;
    private javax.swing.JScrollPane scrolZombi;
    // End of variables declaration//GEN-END:variables
}

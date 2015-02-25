/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Entidades.Planta;
import Entidades.Zombi;
import EstructurasDeDatos.NodoSimple;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Jose
 */
public class FormCatalogo extends javax.swing.JDialog {

    /**
     * Creates new form FormCatalogo
     */
    JFrame ventanaInicio;
    JDialog formCata;
    String tipo;

    public FormCatalogo(java.awt.Frame parent, boolean modal, String tipo) {
        this(parent, modal);

        this.tipo = tipo;

        ventanaInicio = (JFrame) parent;
        //formCata=this;
        //fondoPanelCatalogo.setLayout(null);
        fondoPanelCatalogo.setSize(660, 500);

        //PanelCatalogo.setLayout(null);
        //PanelCatalogo.setSize(620, 10000);
        //setResizable(false);
        setSize(645, 500);
        setResizable(false);
        JPanel panelCata = new JPanel();


        if (tipo.equalsIgnoreCase("Planta")) {

            setTitle("Catalogo " + tipo);

            NodoSimple nodo = Inicio.catalogoPlanta.primerNodo;
            for (int i = 0; i < Inicio.catalogoPlanta.tamanioDeLaLista(); i++) {

                FormComponeneteCatalogo componente = new FormComponeneteCatalogo(ventanaInicio, this);
                componente.setVisible(true);
                componente.setBounds(0, i * 105, 620, 100);
                componente.setIndice(i);
                componente.setTipo("Planta");
                panelCata.add(componente);



                //Planta plantaBuscada = null;
                Planta planta;

                planta = (Planta) nodo.datos;
                componente.lblNombre.setText(planta.getNombre());
                componente.lblVida.setText("" + planta.getVida());
                componente.lblataque.setText("" + planta.getAtaque());
                componente.lbltipo.setText(planta.getTipoAtaque());
                if (planta.getFoto() != null) {
                    componente.lblImagen.setIcon(new ImageIcon(planta.getFoto()));
                } else {
                    componente.lblImagen.setIcon(new ImageIcon(getClass().getResource("/Imagenes/imganenNoDisponible.png")));
                }

                nodo = nodo.siguienteNodo;


            }

            panelCata.setLayout(null);
            panelCata.setVisible(true);
            panelCata.setPreferredSize(new Dimension(100, Inicio.catalogoPlanta.tamanioDeLaLista() * 100));
            scrolCatalogo.setViewportView(panelCata);

        } else if (tipo.equalsIgnoreCase("Zombi")) {
            setTitle("Catalogo " + tipo);
            NodoSimple nodo = Inicio.catalogoZombi.primerNodo;
            for (int i = 0; i < Inicio.catalogoZombi.tamanioDeLaLista(); i++) {

                FormComponeneteCatalogo componente = new FormComponeneteCatalogo(ventanaInicio, this);
                componente.setVisible(true);
                componente.setBounds(0, i * 105, 620, 100);
                componente.setIndice(i);
                componente.setTipo("Zombi");
                panelCata.add(componente);



                //Planta plantaBuscada = null;
                Zombi zombi;

                zombi = (Zombi) nodo.datos;
                componente.lblNombre.setText(zombi.getNombre());
                componente.lblVida.setText("" + zombi.getVida());
                componente.lblataque.setText("" + zombi.getAtaque());
                componente.lbltipo.setText(zombi.getTipoAtaque());
                if (zombi.getFoto() != null) {
                    componente.lblImagen.setIcon(new ImageIcon(zombi.getFoto()));
                } else {
                    componente.lblImagen.setIcon(new ImageIcon(getClass().getResource("/Imagenes/imganenNoDisponible.png")));
                }

                nodo = nodo.siguienteNodo;


            }

            panelCata.setLayout(null);
            panelCata.setVisible(true);
            panelCata.setPreferredSize(new Dimension(100, Inicio.catalogoZombi.tamanioDeLaLista() * 100));
            scrolCatalogo.setViewportView(panelCata);
        }



    }

    public FormCatalogo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        //jScrollPane1.setViewportView(PanelCatalogo);
//        ventanaInicio=(JFrame)parent;
//        //formCata=this;
//        //fondoPanelCatalogo.setLayout(null);
//       fondoPanelCatalogo.setSize(660,500);
//       
//       PanelCatalogo.setLayout(null);
//       PanelCatalogo.setSize(620,10000);
//       //setResizable(false);
//       setSize(675,500);
//       
//        NodoSimple nodo = Inicio.catalogoPlanta.primerNodo;
//        for(int i=0;i<Inicio.catalogoPlanta.tamanioDeLaLista();i++){
//            
//            FormComponeneteCatalogo componente=new FormComponeneteCatalogo(ventanaInicio,this);
//            componente.setVisible(true);
//            componente.setBounds(0, i*105, 620, 100);
//            componente.setIndice(i);
//            PanelCatalogo.add(componente);
//            
//            
//            
//        //Planta plantaBuscada = null;
//        Planta zombi;
//        
//            zombi = (Planta) nodo.datos;
//            componente.lblNombre.setText(zombi.getNombre());
//            componente.lblVida.setText(""+zombi.getVida());
//            componente.lblataque.setText(""+zombi.getAtaque());
//            componente.lbltipo.setText(zombi.getTipoAtaque());
//            componente.lblImagen.setIcon(new ImageIcon(zombi.getFoto()));
//            nodo = nodo.siguienteNodo;
//        
//            
//        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondoPanelCatalogo = new javax.swing.JPanel();
        scrolCatalogo = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        javax.swing.GroupLayout fondoPanelCatalogoLayout = new javax.swing.GroupLayout(fondoPanelCatalogo);
        fondoPanelCatalogo.setLayout(fondoPanelCatalogoLayout);
        fondoPanelCatalogoLayout.setHorizontalGroup(
            fondoPanelCatalogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrolCatalogo, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        fondoPanelCatalogoLayout.setVerticalGroup(
            fondoPanelCatalogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoPanelCatalogoLayout.createSequentialGroup()
                .addComponent(scrolCatalogo, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(fondoPanelCatalogo);
        fondoPanelCatalogo.setBounds(0, 20, 640, 463);

        jLabel1.setText("Imagen");

        jLabel2.setText("Nombre");

        jLabel3.setText("Vida");

        jLabel4.setText("Ataque");

        jLabel5.setText("Tipo");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(98, 98, 98)
                .addComponent(jLabel2)
                .addGap(46, 46, 46)
                .addComponent(jLabel3)
                .addGap(65, 65, 65)
                .addComponent(jLabel4)
                .addGap(34, 34, 34)
                .addComponent(jLabel5)
                .addContainerGap(89, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(0, 6, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 500, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(FormCatalogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormCatalogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormCatalogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormCatalogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormCatalogo dialog = new FormCatalogo(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel fondoPanelCatalogo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane scrolCatalogo;
    // End of variables declaration//GEN-END:variables
}

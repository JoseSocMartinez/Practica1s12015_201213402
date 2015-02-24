/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Jose
 */
public class FormComponeneteCatalogo extends javax.swing.JPanel {

    /**
     * Creates new form FormComponeneteCatalogo
     */
    private int indice;
    private String tipo;
    JFrame ventanaInicio;
    JDialog formCatalogo;

    public FormComponeneteCatalogo(java.awt.Frame parent, JDialog formComponente) {
        initComponents();
        setSize(620, 100);
        ventanaInicio = (JFrame) parent;
        this.formCatalogo = formComponente;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        lblImagen = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblVida = new javax.swing.JLabel();
        lblataque = new javax.swing.JLabel();
        lbltipo = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        jButton2.setText("jButton2");

        setLayout(null);

        lblImagen.setText("Imagen");
        add(lblImagen);
        lblImagen.setBounds(10, 0, 100, 100);

        lblNombre.setText("nombre");
        add(lblNombre);
        lblNombre.setBounds(156, 50, 70, 14);

        lblVida.setText("vida");
        add(lblVida);
        lblVida.setBounds(250, 50, 50, 14);

        lblataque.setText("ataque");
        add(lblataque);
        lblataque.setBounds(330, 50, 50, 14);

        lbltipo.setText("Tipo");
        add(lbltipo);
        lbltipo.setBounds(390, 50, 70, 14);

        btnModificar.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        add(btnModificar);
        btnModificar.setBounds(470, 40, 73, 21);

        btnEliminar.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        add(btnEliminar);
        btnEliminar.setBounds(550, 40, 67, 21);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/FondoComponenteCatalogo.png"))); // NOI18N
        add(jLabel2);
        jLabel2.setBounds(0, 0, 620, 100);
    }// </editor-fold>//GEN-END:initComponents

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        //JOptionPane.showMessageDialog(this, "indice "+ getIndice(), "", JOptionPane.INFORMATION_MESSAGE);
        FormModificar modificar = new FormModificar(ventanaInicio, true, formCatalogo, getTipo(), getIndice());
        modificar.setVisible(true);

    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        if (tipo.equalsIgnoreCase("Planta")) {
            Inicio.catalogoPlanta.eliminarPlanta(getIndice());
            formCatalogo.setVisible(false);
        } else if (tipo.equalsIgnoreCase("Zombi")) {
            Inicio.catalogoZombi.eliminarZombi(getIndice());
            formCatalogo.setVisible(false);
        }
        JOptionPane.showMessageDialog(this, "Eliminado", "", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_btnEliminarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    public javax.swing.JLabel lblImagen;
    public javax.swing.JLabel lblNombre;
    public javax.swing.JLabel lblVida;
    public javax.swing.JLabel lblataque;
    public javax.swing.JLabel lbltipo;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the indice
     */
    public int getIndice() {
        return indice;
    }

    /**
     * @param indice the indice to set
     */
    public void setIndice(int indice) {
        this.indice = indice;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}

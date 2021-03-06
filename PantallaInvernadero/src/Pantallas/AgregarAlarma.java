/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pantallas;

import Dominio.Alarma;
import Dominio.Sensor;
import Dominio.Tipo;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

public class AgregarAlarma extends javax.swing.JFrame {

    public static ArrayList<Sensor> sensoresAlarma = new ArrayList<>();

    public AgregarAlarma() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.ORANGE);
        cargarLista();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        boxTipo = new javax.swing.JComboBox<>();
        boxSensores = new javax.swing.JComboBox<>();
        txtHasta = new javax.swing.JTextField();
        txtDesde = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        label_tipo1 = new javax.swing.JLabel();
        label_tipo2 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alarma");

        boxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Humedad", "Temperatura" }));
        boxTipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                boxTipoItemStateChanged(evt);
            }
        });

        jLabel1.setText("Desde");

        jLabel2.setText("Hasta");

        label_tipo1.setText("%");

        label_tipo2.setText("%");

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(boxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 14, Short.MAX_VALUE)
                        .addComponent(txtDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(label_tipo1)
                        .addGap(49, 49, 49)
                        .addComponent(txtHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(label_tipo2)
                        .addGap(88, 88, 88))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(jLabel1)
                        .addGap(119, 119, 119)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(64, 64, 64)
                    .addComponent(boxSensores, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(85, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(boxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_tipo1)
                    .addComponent(label_tipo2))
                .addGap(18, 18, 18)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(54, 54, 54)
                    .addComponent(boxSensores, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(249, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boxTipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_boxTipoItemStateChanged
        String tipo = (String) boxTipo.getSelectedItem();
        if (tipo.equals("Humedad")) {
            label_tipo1.setText("%");
            label_tipo2.setText("%");
        } else {
            label_tipo1.setText("C");
            label_tipo2.setText("C");
        }
    }//GEN-LAST:event_boxTipoItemStateChanged

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        String txtDesde = this.txtDesde.getText();
        String txtHasta = this.txtHasta.getText();
        Sensor s = (Sensor) boxSensores.getSelectedItem();
        String tipo = (String) boxTipo.getSelectedItem();
        Alarma alarma = null;

        if (tipo.equals("Humedad")) {
            alarma = new Alarma(s, Tipo.HUMEDAD, Float.valueOf(txtDesde), Float.valueOf(txtHasta));
        } else {
            alarma = new Alarma(s, Tipo.TEMPERATURA, Float.valueOf(txtDesde), Float.valueOf(txtHasta));
        }
        
        MostrarSensores.alarmas.add(alarma);
        
        this.dispose();
    }//GEN-LAST:event_btnAgregarActionPerformed

    public void cargarLista() {
        DefaultComboBoxModel<Sensor> sensoresCB = (DefaultComboBoxModel<Sensor>) boxSensores.getModel();
        for (Sensor sensor : sensoresAlarma) {
            sensoresCB.addElement(sensor);
        }
        //sensoresCB.addAll(sensoresAlarma);
        boxSensores.setSelectedIndex(0);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Sensor> boxSensores;
    private javax.swing.JComboBox<String> boxTipo;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel label_tipo1;
    private javax.swing.JLabel label_tipo2;
    private javax.swing.JTextField txtDesde;
    private javax.swing.JTextField txtHasta;
    // End of variables declaration//GEN-END:variables
}

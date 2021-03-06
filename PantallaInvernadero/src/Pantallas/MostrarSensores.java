/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pantallas;

import Cliente.Cliente;
import Dominio.Alarma;
import Dominio.Sensor;
import Server.Server;
import administrarsensores.ISensor;
import administrarsensores.SensorRest;

import java.awt.Color;
import java.awt.Component;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class MostrarSensores extends javax.swing.JFrame {

    public static ArrayList<Dominio.Sensor> sensores = new ArrayList<>();
    public static ArrayList<Dominio.Alarma> alarmas = new ArrayList<>();

    public MostrarSensores() {
        initComponents();
        this.getContentPane().setBackground(Color.ORANGE);
        this.setLocationRelativeTo(null);
        loopLista();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jlistSensores = new javax.swing.JList<>();
        btnAgregar = new javax.swing.JButton();
        btnDetectar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mostrar Sensores");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Sensores");

        jlistSensores.setModel(new DefaultListModel<>()
        );
        jScrollPane1.setViewportView(jlistSensores);

        btnAgregar.setBackground(new java.awt.Color(102, 255, 102));
        btnAgregar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnAgregar.setText("Agregar Alarma");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnDetectar.setBackground(new java.awt.Color(102, 255, 102));
        btnDetectar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnDetectar.setText("Detectar Sensores");
        btnDetectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetectarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDetectar)))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDetectar, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        DefaultListModel<Sensor> model = (DefaultListModel<Sensor>) jlistSensores.getModel();
        boolean isVoid = model.isEmpty();
        if (!isVoid) {
            AgregarAlarma.sensoresAlarma = this.sensores;
            new AgregarAlarma().setVisible(true);
            
        } else {
            JOptionPane.showMessageDialog(this, "La lista de sensores esta vacia",null,JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnDetectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetectarActionPerformed
        new DetectarSensores().setVisible(true);
    }//GEN-LAST:event_btnDetectarActionPerformed

    public static void simularSensores(ArrayList<Sensor> sensores) {
        Server servidor;
        Cliente cliente;
        final int PORT = 4444;
        try {
            servidor = new Server(PORT, sensores);
            cliente = new Cliente("localhost", PORT, sensores);
            new Thread(servidor).start();
            new Thread(cliente).start();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void loopLista() {
        Thread t = new Thread(() -> {
            while (true) {
                try {
                    ActualizarLista();
                    ActualizarAlarma();
                    
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }

            }
        });
        t.start();
    }

    private void ActualizarAlarma() {
        jlistSensores.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof Sensor) {
                    Sensor nextSensor = (Sensor) value;
                    for (Alarma alarma : alarmas) {
                        if (alarma.getSensor() == nextSensor) {
                            if (alarma.entraRango()) {
                                setBackground(Color.red);
                            } else {
                                setBackground(Color.white);
                            }
                            break;
                        }
                    }
                }
                return c;
            }

        });
    }

    private void ActualizarLista() {
        DefaultListModel<Sensor> model = (DefaultListModel<Sensor>) jlistSensores.getModel();
        if (model.isEmpty()) {
            for (Sensor sensor : sensores) {
                model.addElement(sensor);
            }
        }
        for (Sensor sensor : sensores) {
            model.setElementAt(sensor, sensores.indexOf(sensor));
        }
    }
    
    
    public static void enviarDatosRest(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                SensorRest rest = new SensorRest();
                
                while (true) {                    
                    try {
                        TimeUnit.MINUTES.sleep(1);
                        for (Sensor sensore : sensores) {
                            rest.Agregar(sensore);
                        }
                        System.out.println("Se envio informacion al servidor REST");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnDetectar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<Sensor> jlistSensores;
    // End of variables declaration//GEN-END:variables
}

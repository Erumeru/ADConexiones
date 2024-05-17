package com.mycompany.adpresentacion;

<<<<<<< HEAD
import com.itson.proyecto2_233410_233023.dominio.Cargo;
import com.itson.proyecto2_233410_233023.dominio.Cliente;
import com.itson.proyecto2_233410_233023.dominio.ContratoServicio;
import com.itson.proyecto2_233410_233023.implementaciones.ConexionBD;
import com.mycompany.adnegocio.CargoDAO;
import com.mycompany.adnegocio.ClienteDAO;
import com.mycompany.adnegocio.ContratoServicioDAO;
import interfaces.ICargoDAO;
import interfaces.IClienteDAO;
import interfaces.IContratoServicio;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
=======
import javax.swing.JButton;
>>>>>>> 4a52886f5ec7732e3e7e560575bb9749400e2370

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
<<<<<<< HEAD
=======

>>>>>>> 4a52886f5ec7732e3e7e560575bb9749400e2370
/**
 *
 * @author hoshi
 */
public class frmDetalleCliente extends javax.swing.JFrame {

<<<<<<< HEAD
    private IClienteDAO clientedao;
    private IContratoServicio contratoDAO;
    private ICargoDAO cargoDAO;
    private ContratoServicio contrato;
    private Long idSeleccionado = 0L;

    /**
     * Creates new form frmDetalleCliente
     */
    public frmDetalleCliente(ContratoServicio contrato) {
        initComponents();
        ConexionBD conexionBD = new ConexionBD("adconexiones");
        clientedao = new ClienteDAO(conexionBD);
        contratoDAO = new ContratoServicioDAO(conexionBD);
        cargoDAO = new CargoDAO(conexionBD);
        this.contrato = contrato;
        crearTablas();
        try {
            rellnarTablas();
        } catch (Exception ex) {
            Logger.getLogger(frmDetalleCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void crearTablas() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Monto");
        model.addColumn("Fecha");
        model.addColumn("atraso");
        tablCargo.setModel(model);
        tablCargo.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int filaSeleccionada = tablCargo.getSelectedRow();
                    if (filaSeleccionada != -1) {
                        idSeleccionado = (Long) tablCargo.getValueAt(filaSeleccionada, 0);
                    } else {
                        idSeleccionado = 0L;
                    }
                }
            }
        });
    }

    public void rellnarTablas() throws Exception {
        try {
            DefaultTableModel model = (DefaultTableModel) tablCargo.getModel();
            // Eliminar filas existentes en la tabla
            model.setRowCount(0);

            List<Cargo> contratos = cargoDAO.obtenerCargos(contrato);
            for (Cargo cargo : contratos) {

                Date d = cargo.getFecha();
                long diferenciaMilisegundos = new Date().getTime() - d.getTime();
                long diferenciaDias = diferenciaMilisegundos / (24 * 60 * 60 * 1000);
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                if (diferenciaDias < 0) {
                    diferenciaDias = 0;
                }
                Object[] rowData = {
                    cargo.getId(),
                    cargo.getDeuda(),
                    formatter.format(d),
                    diferenciaDias
                };
                model.addRow(rowData);
            }
        } catch (SQLException ex) {
            Logger.getLogger(frmRegistrarMensualidad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean abonar() {
        try {
            // Obtener el primer cargo asociado al contrato seleccionado
            Cargo c = cargoDAO.obtenerCargosPorContratoId(idSeleccionado).get(0);

            // Verificar si la deuda no es cero
            if (c.getDeuda() != 0) {
                // Solicitar la cantidad a abonar al usuario
                String cantidadStr = JOptionPane.showInputDialog(rootPane, "Ingrese la cantidad a abonar:", "Abonar Deuda", JOptionPane.PLAIN_MESSAGE);

                // Verificar si se ingresó una cantidad válida
                if (cantidadStr != null && !cantidadStr.isEmpty()) {
                    try {
                        // Convertir la cantidad a un valor numérico
                        double cantidad = Double.parseDouble(cantidadStr);

                        // Actualizar el precio del cargo (aquí asumimos que se está abonando a la deuda)
                        double nuevaDeuda = c.getDeuda() - cantidad;
                        if (nuevaDeuda < 0) {
                            JOptionPane.showMessageDialog(rootPane, "La cantidad a abonar excede la deuda actual.", "Error", JOptionPane.ERROR_MESSAGE);
                            return false;
                        }

                        c.setDeuda((float) nuevaDeuda);

                        // Usar CargoDAO para modificar el cargo en la base de datos
                        cargoDAO.modificarCargo(c);

                        // Confirmar la operación al usuario
                        JOptionPane.showMessageDialog(rootPane, "Pago realizado con éxito. Nueva deuda: " + nuevaDeuda);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(rootPane, "Cantidad inválida. Por favor ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Esta deuda está pagada.");
            }
        } catch (Exception ex) {
            Logger.getLogger(frmDetalleCliente.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(rootPane, "Ocurrió un error al realizar el abono.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
=======
    /**
     * Creates new form frmDetalleCliente
     */
    public frmDetalleCliente() {
        initComponents();
>>>>>>> 4a52886f5ec7732e3e7e560575bb9749400e2370
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
<<<<<<< HEAD
        tablCargo = new javax.swing.JTable();
=======
        tblResultados = new javax.swing.JTable();
>>>>>>> 4a52886f5ec7732e3e7e560575bb9749400e2370
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
<<<<<<< HEAD
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
=======
>>>>>>> 4a52886f5ec7732e3e7e560575bb9749400e2370
        jPanel1.setPreferredSize(new java.awt.Dimension(1250, 731));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mingcute_arrow-left-fill.png"))); // NOI18N
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(235, 168, 23));
        jButton2.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        jButton2.setText("Abonar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

<<<<<<< HEAD
        tablCargo.setModel(new javax.swing.table.DefaultTableModel(
=======
        tblResultados.setModel(new javax.swing.table.DefaultTableModel(
>>>>>>> 4a52886f5ec7732e3e7e560575bb9749400e2370
            new Object [][] {

            },
            new String [] {
                "Cargos", "Fecha", "Atraso"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
<<<<<<< HEAD
        tablCargo.setColumnSelectionAllowed(true);
        tablCargo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablCargoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablCargo);
=======
        tblResultados.setColumnSelectionAllowed(true);
        tblResultados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblResultadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblResultados);
>>>>>>> 4a52886f5ec7732e3e7e560575bb9749400e2370

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        jLabel2.setText("Nombre:");

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        jLabel1.setText("DETALLE CLIENTE");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
<<<<<<< HEAD
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(686, 686, 686))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 850, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(511, 511, 511)
                        .addComponent(jLabel1)))
                .addContainerGap(251, Short.MAX_VALUE))
=======
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(526, 526, 526))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(343, 343, 343)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(304, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 763, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(183, 183, 183))
>>>>>>> 4a52886f5ec7732e3e7e560575bb9749400e2370
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(35, 35, 35)
                    .addComponent(jButton1)
<<<<<<< HEAD
                    .addContainerGap(1195, Short.MAX_VALUE)))
=======
                    .addContainerGap(35, Short.MAX_VALUE)))
>>>>>>> 4a52886f5ec7732e3e7e560575bb9749400e2370
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
<<<<<<< HEAD
                .addGap(49, 49, 49)
                .addComponent(jLabel1)
                .addGap(62, 62, 62)
                .addComponent(jLabel2)
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(129, Short.MAX_VALUE))
=======
                .addGap(114, 114, 114)
                .addComponent(jLabel1)
                .addGap(42, 42, 42)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
>>>>>>> 4a52886f5ec7732e3e7e560575bb9749400e2370
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(34, 34, 34)
                    .addComponent(jButton1)
<<<<<<< HEAD
                    .addContainerGap(664, Short.MAX_VALUE)))
=======
                    .addContainerGap(666, Short.MAX_VALUE)))
>>>>>>> 4a52886f5ec7732e3e7e560575bb9749400e2370
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
<<<<<<< HEAD
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1262, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 743, Short.MAX_VALUE)
=======
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
>>>>>>> 4a52886f5ec7732e3e7e560575bb9749400e2370
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

<<<<<<< HEAD
    private void tablCargoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablCargoMouseClicked

    }//GEN-LAST:event_tablCargoMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

=======
    private void tblResultadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblResultadosMouseClicked
        // TODO add your handling code here:
        int columna;
        int row;
        //        int column = tblResultados.getColumnModel().getColumnIndexAtX(evt.getX());
        //        int row = evt.getY()/tblResultados.getRowHeight();
/**
        columna = tblResultados.getColumnModel().getColumnIndexAtX(evt.getX());
        row = evt.getY() / tblResultados.getRowHeight();

        if (columna <= tblResultados.getColumnCount() && columna >= 0 && row <= tblResultados.getRowCount() && row >= 0) {
            Object objeto = tblResultados.getValueAt(row, columna);
            if (objeto instanceof JButton) {
                ((JButton) objeto).doClick();
                JButton boton = (JButton) objeto;
                //if (boton.equals(btn)) {
                    //this.setVisible(false);
                   // frmDetalleCliente f= new frmDetalleCliente();
                   // f.setVisible(true);
                    //FrmPersona persona = new FrmPersona(resultados.get(row));
                    //persona.setVisible(true);
                   // this.dispose();

                }
            }
        }**/
    }//GEN-LAST:event_tblResultadosMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
>>>>>>> 4a52886f5ec7732e3e7e560575bb9749400e2370
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        frmRegistrarMensualidad f = new frmRegistrarMensualidad();
        this.dispose();
        f.setVisible(true);
<<<<<<< HEAD

=======
        
>>>>>>> 4a52886f5ec7732e3e7e560575bb9749400e2370
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
<<<<<<< HEAD
=======
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
            java.util.logging.Logger.getLogger(frmDetalleCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmDetalleCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmDetalleCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmDetalleCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmDetalleCliente().setVisible(true);
            }
        });
    }
>>>>>>> 4a52886f5ec7732e3e7e560575bb9749400e2370

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
<<<<<<< HEAD
    private javax.swing.JTable tablCargo;
=======
    private javax.swing.JTable tblResultados;
>>>>>>> 4a52886f5ec7732e3e7e560575bb9749400e2370
    // End of variables declaration//GEN-END:variables
}

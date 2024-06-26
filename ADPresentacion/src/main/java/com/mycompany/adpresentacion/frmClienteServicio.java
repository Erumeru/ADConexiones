/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.adpresentacion;

import com.itson.proyecto2_233410_233023.dominio.Cliente;
import com.itson.proyecto2_233410_233023.dominio.ContratoServicio;
import com.itson.proyecto2_233410_233023.implementaciones.ConexionBD;
import com.mycompany.adnegocio.ContratoServicioDAO;
import interfaces.IContratoServicio;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author diego
 */
public class frmClienteServicio extends javax.swing.JFrame {
    private IContratoServicio contratoDAO;
    private Long idCliente;
    /**
     * Creates new form frmClientes
     */
    public frmClienteServicio() {
        initComponents();
        crearTablas();
        ConexionBD conexionBD = new ConexionBD("adconexiones");
        contratoDAO = new ContratoServicioDAO(conexionBD);
    }

    public frmClienteServicio(Long idCliente) {
        this.idCliente=idCliente;
        initComponents();
        crearTablas();
         ConexionBD conexionBD = new ConexionBD("adconexiones");
        contratoDAO = new ContratoServicioDAO(conexionBD);
        llenarTablaServiciosCliente(idCliente);
    }

    public void crearTablas() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nombre Cliente");
        model.addColumn("Dirección Servicio");
        model.addColumn("Plan");
        model.addColumn("Fecha De Pago");
        tableServicios.setModel(model);
    }

    public void llenarTablaServiciosCliente(Long idCliente) {
        DefaultTableModel model = (DefaultTableModel) tableServicios.getModel();
        // Eliminar filas existentes en la tabla
        model.setRowCount(0);
        Cliente c= new Cliente();
        c.setId(idCliente);
        System.out.println(idCliente);
        try {
            // Obtener los servicios del cliente utilizando el ID proporcionado
            List<ContratoServicio> contratos = contratoDAO.obtenerContratos(c);

            // Recorrer la lista de servicios y agregar cada servicio a la tabla
            for (ContratoServicio servicio : contratos) {
                Object[] rowData = {
                    servicio.getId(),
                    servicio.getCliente().getNombreCliente(),
                    servicio.getCliente().getNombreCliente(),
                    "Velocidad: "+servicio.getPlan().getMegas()+" Costo: "+servicio.getPlan().getCostoMensualidad(),
                    servicio.getDiaAPagar()
                };
                model.addRow(rowData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejar la excepción según sea necesario
        } catch (Exception ex) {
            Logger.getLogger(frmClienteServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel7 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnPeriodo = new javax.swing.JButton();
        btnPeriodo1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableServicios = new javax.swing.JTable();
        btnPeriodo2 = new javax.swing.JButton();
        btnPeriodo3 = new javax.swing.JButton();
        btnPeriodo4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel7.setPreferredSize(new java.awt.Dimension(1280, 720));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel5.setText("Administrar Servicios");

        btnPeriodo.setBackground(new java.awt.Color(235, 168, 23));
        btnPeriodo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnPeriodo.setText("Registrar Servicio");
        btnPeriodo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnPeriodo.setMaximumSize(new java.awt.Dimension(70, 26));
        btnPeriodo.setMinimumSize(new java.awt.Dimension(70, 26));
        btnPeriodo.setPreferredSize(new java.awt.Dimension(70, 26));
        btnPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPeriodoActionPerformed(evt);
            }
        });

        btnPeriodo1.setText("Regresar");
        btnPeriodo1.setBackground(new java.awt.Color(235, 168, 23));
        btnPeriodo1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnPeriodo1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnPeriodo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPeriodo1ActionPerformed(evt);
            }
        });

        tableServicios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableServicios.setRowHeight(40);
        tableServicios.setRowSelectionAllowed(false);
        tableServicios.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tableServicios);

        btnPeriodo2.setBackground(new java.awt.Color(235, 168, 23));
        btnPeriodo2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnPeriodo2.setText("Consultar Servicio");
        btnPeriodo2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnPeriodo2.setEnabled(false);
        btnPeriodo2.setFocusable(false);
        btnPeriodo2.setMaximumSize(new java.awt.Dimension(70, 26));
        btnPeriodo2.setMinimumSize(new java.awt.Dimension(70, 26));
        btnPeriodo2.setPreferredSize(new java.awt.Dimension(70, 26));
        btnPeriodo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPeriodo2ActionPerformed(evt);
            }
        });

        btnPeriodo3.setBackground(new java.awt.Color(235, 168, 23));
        btnPeriodo3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnPeriodo3.setText("Eliminar Servicio");
        btnPeriodo3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnPeriodo3.setEnabled(false);
        btnPeriodo3.setFocusable(false);
        btnPeriodo3.setMaximumSize(new java.awt.Dimension(70, 26));
        btnPeriodo3.setMinimumSize(new java.awt.Dimension(70, 26));
        btnPeriodo3.setPreferredSize(new java.awt.Dimension(70, 26));
        btnPeriodo3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPeriodo3ActionPerformed(evt);
            }
        });

        btnPeriodo4.setBackground(new java.awt.Color(235, 168, 23));
        btnPeriodo4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnPeriodo4.setText("Editar Servicio");
        btnPeriodo4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnPeriodo4.setEnabled(false);
        btnPeriodo4.setFocusable(false);
        btnPeriodo4.setMaximumSize(new java.awt.Dimension(70, 26));
        btnPeriodo4.setMinimumSize(new java.awt.Dimension(70, 26));
        btnPeriodo4.setPreferredSize(new java.awt.Dimension(70, 26));
        btnPeriodo4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPeriodo4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(btnPeriodo1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 150, Short.MAX_VALUE)
                .addComponent(btnPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(141, 141, 141)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPeriodo2, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPeriodo3, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPeriodo4, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(182, 182, 182))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jLabel4)
                        .addGap(181, 181, 181)
                        .addComponent(jLabel5))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(28, 28, 28)))
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 21, Short.MAX_VALUE)
                .addComponent(btnPeriodo3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPeriodo2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPeriodo1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnPeriodo4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPeriodoActionPerformed
        this.dispose();
        frmServicio f = new frmServicio(idCliente);
        f.setVisible(true);
    }//GEN-LAST:event_btnPeriodoActionPerformed

    private void btnPeriodo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPeriodo1ActionPerformed
        this.dispose();
        frmAdministrarServicios f = new frmAdministrarServicios();
        f.setVisible(true);
    }//GEN-LAST:event_btnPeriodo1ActionPerformed

    private void btnPeriodo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPeriodo2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPeriodo2ActionPerformed

    private void btnPeriodo3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPeriodo3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPeriodo3ActionPerformed

    private void btnPeriodo4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPeriodo4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPeriodo4ActionPerformed

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
            java.util.logging.Logger.getLogger(frmClienteServicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmClienteServicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmClienteServicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmClienteServicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmClienteServicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPeriodo;
    private javax.swing.JButton btnPeriodo1;
    private javax.swing.JButton btnPeriodo2;
    private javax.swing.JButton btnPeriodo3;
    private javax.swing.JButton btnPeriodo4;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tableServicios;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.adpresentacion;

import com.itson.proyecto2_233410_233023.dominio.Cargo;
import com.itson.proyecto2_233410_233023.dominio.Cliente;
import com.itson.proyecto2_233410_233023.dominio.ContratoServicio;
import com.itson.proyecto2_233410_233023.implementaciones.ConexionBD;
import com.mycompany.adnegocio.ClienteDAO;
import com.mycompany.adnegocio.ContratoServicioDAO;
import interfaces.IClienteDAO;
import interfaces.IContratoServicio;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import reportes.JasperReporte;
import utils.JButtonTableCellRenderer;

/**
 *
 * @author hoshi
 */
public class frmRegistrarMensualidad extends javax.swing.JFrame {

    JButtonTableCellRenderer buttonRenderer = new JButtonTableCellRenderer();
    /**
     * btn
     */
    private IClienteDAO clientedao;
    private IContratoServicio contratoDAO;
    private Long idSeleccionado = 0L;

    /**
     * lista de resultados
     */
    //List<Cliente> resultados = new ArrayList<>();
    /**
     * Creates new form frmRegistrarMensualidad
     */
    public frmRegistrarMensualidad() {
        initComponents();

        ConexionBD conexionBD = new ConexionBD("adconexiones");
        clientedao = new ClienteDAO(conexionBD);
        contratoDAO = new ContratoServicioDAO(conexionBD);
        crearTablas();
        rellnarTablas();

        tblClienteCargos.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int filaSeleccionada = tblClienteCargos.getSelectedRow();
                    if (filaSeleccionada != -1) {
                        idSeleccionado = (Long) tblClienteCargos.getValueAt(filaSeleccionada, 0);
                    } else {
                        idSeleccionado = 0L;
                    }
                }
            }
        });
    }

    /**
     * Metodo que se encarga de mostrar la pantalla de persona
     */
    private void mostrarPantallaFrmPersona() {
        // Persona persona = new Persona();
        this.setVisible(false);
        //FrmPersona frmPersona = new FrmPersona(persona);
        //frmPersona.setVisible(true);
        this.dispose();
    }

    public void crearTablas() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nombre Cliente");
        model.addColumn("Cargo Total");
        model.addColumn("Fecha");
        model.addColumn("Atraso");
        tblClienteCargos.setModel(model);
    }

    public void rellnarTablas() {
        try {
            DefaultTableModel model = (DefaultTableModel) tblClienteCargos.getModel();
            // Eliminar filas existentes en la tabla
            model.setRowCount(0);

            List<Cliente> contratos = clientedao.obtenerClientesContratoCargos();
            for (Cliente servicio : contratos) {
                System.out.println(servicio.getContratosServicio().get(0).getId() + "idContrato");
                if (!servicio.getContratosServicio().get(0).getCargos().isEmpty()) {

                    ContratoServicio c = servicio.getContratosServicio().get(0);
                    Date d = c.getCargos().get(0).getFecha();
                    Cargo cargo = c.getCargos().get(0);
                    long diferenciaMilisegundos = new Date().getTime() - d.getTime();
                    long diferenciaDias = diferenciaMilisegundos / (24 * 60 * 60 * 1000);
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    if (diferenciaDias < 0) {
                        diferenciaDias = 0;
                    }
                    Object[] rowData = {
                        servicio.getId(),
                        servicio.getNombreCliente(),
                        cargo.getDeuda(),
                        formatter.format(d),
                        diferenciaDias
                    };
                    if (cargo.getDeuda() == 0) {
                        Object[] rowData2 = {
                            servicio.getId(),
                            servicio.getNombreCliente(),
                            "Sin Cargos",};
                        rowData = rowData2;
                    }

                    model.addRow(rowData);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(frmRegistrarMensualidad.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        txtBusqueda = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblClienteCargos = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        btnMensualidad = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1250, 731));

        txtBusqueda.setBackground(new java.awt.Color(229, 229, 232));
        txtBusqueda.setBorder(null);
        txtBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBusquedaActionPerformed(evt);
            }
        });
        txtBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBusquedaKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        jLabel1.setText("ADMINISTRAR CLIENTES");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo.png"))); // NOI18N

        tblClienteCargos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Cargo Total", "Fecha", "Atraso"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblClienteCargos.setColumnSelectionAllowed(true);
        tblClienteCargos.setRowHeight(40);
        tblClienteCargos.getTableHeader().setReorderingAllowed(false);
        tblClienteCargos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClienteCargosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblClienteCargos);

        jButton1.setBackground(new java.awt.Color(235, 168, 23));
        jButton1.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        jButton1.setText("Menu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnMensualidad.setBackground(new java.awt.Color(235, 168, 23));
        btnMensualidad.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        btnMensualidad.setText("Ver Mensualidad");
        btnMensualidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMensualidadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel4)
                        .addGap(269, 269, 269)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(392, 392, 392)
                        .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 881, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(236, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(345, 345, 345)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnMensualidad, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(245, 245, 245))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMensualidad, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(88, 88, 88))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(911, 911, 911))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBusquedaActionPerformed

    private void txtBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyReleased
        // TODO add your handling code here:
        //buscarPersonas();
    }//GEN-LAST:event_txtBusquedaKeyReleased

    private void tblClienteCargosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClienteCargosMouseClicked

    }//GEN-LAST:event_tblClienteCargosMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        frmPrincipal f = new frmPrincipal();
        this.dispose();
        f.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnMensualidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMensualidadActionPerformed

        if (idSeleccionado != null && idSeleccionado != 0) {
            try {
                List<ContratoServicio> d= contratoDAO.obtenerContrato();
                ContratoServicio s=null;
                for (ContratoServicio contratoServicio : d) {
                    if (contratoServicio.getCliente().getId()==idSeleccionado) {
                        s=contratoServicio;
                    }
                }
                if (s==null) {
                    System.out.println("es null");
                }
                frmDetalleCliente f = new frmDetalleCliente(s);
                this.dispose();
                f.setVisible(true);

            } catch (Exception ex) {
                Logger.getLogger(frmRegistrarMensualidad.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            // Manejar el caso cuando no se ha seleccionado ninguna fila
            JOptionPane.showMessageDialog(this, "Por favor, selecciona una fila primero.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnMensualidadActionPerformed

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
            java.util.logging.Logger.getLogger(frmRegistrarMensualidad.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmRegistrarMensualidad.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmRegistrarMensualidad.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmRegistrarMensualidad.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmRegistrarMensualidad().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMensualidad;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblClienteCargos;
    private javax.swing.JTextField txtBusqueda;
    // End of variables declaration//GEN-END:variables
}

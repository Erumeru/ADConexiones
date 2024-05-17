/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.adpresentacion;

<<<<<<< HEAD
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
=======
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
>>>>>>> 4a52886f5ec7732e3e7e560575bb9749400e2370
import utils.JButtonTableCellRenderer;

/**
 *
 * @author hoshi
 */
public class frmRegistrarMensualidad extends javax.swing.JFrame {

<<<<<<< HEAD
    JButtonTableCellRenderer buttonRenderer = new JButtonTableCellRenderer();
    /**
     * btn
     */
    private IClienteDAO clientedao;
    private IContratoServicio contratoDAO;
    private Long idSeleccionado=0L;
=======
    
     JButtonTableCellRenderer buttonRenderer = new JButtonTableCellRenderer();
    /**
     * btn
     */
    JButton btn = new JButton("Seleccion");
>>>>>>> 4a52886f5ec7732e3e7e560575bb9749400e2370
    /**
     * lista de resultados
     */
    //List<Cliente> resultados = new ArrayList<>();
    /**
     * Creates new form frmRegistrarMensualidad
     */
    public frmRegistrarMensualidad() {
        initComponents();
<<<<<<< HEAD

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
                }else{
                    idSeleccionado=0L;
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
=======
        
         tblResultados.setDefaultRenderer(Object.class, buttonRenderer);
    }
    
      /**
     * Metodo que se encarga de mostrar la pantalla de persona
     */
    private void mostrarPantallaFrmPersona() {
       // Persona persona = new Persona();
>>>>>>> 4a52886f5ec7732e3e7e560575bb9749400e2370
        this.setVisible(false);
        //FrmPersona frmPersona = new FrmPersona(persona);
        //frmPersona.setVisible(true);
        this.dispose();
    }

<<<<<<< HEAD
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
            
            List<Cliente> contratos = clientedao.obtenerClientesContrato();
             for (Cliente servicio : contratos) {
                 
                 ContratoServicio c = servicio.getContratosServicio().get(0);
                 Date d = c.getCargos().get(0).getFecha();
                 long diferenciaMilisegundos = new Date().getTime() - d.getTime();
                 long diferenciaDias = diferenciaMilisegundos / (24 * 60 * 60 * 1000);
                 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                 if (diferenciaDias<0) {
                     diferenciaDias=0;
                 }
                Object[] rowData = {
                    servicio.getId(),
                    servicio.getNombreCliente(),
                    c.getMontoPagar(),
                    formatter.format(d),
                    diferenciaDias
                };
                model.addRow(rowData);
            }
        } catch (SQLException ex) {
            Logger.getLogger(frmRegistrarMensualidad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    

=======
>>>>>>> 4a52886f5ec7732e3e7e560575bb9749400e2370
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
<<<<<<< HEAD
        tblClienteCargos = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        btnMensualidad = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
=======
        tblResultados = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(32767, 32767));
        setPreferredSize(new java.awt.Dimension(1250, 731));
>>>>>>> 4a52886f5ec7732e3e7e560575bb9749400e2370

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

<<<<<<< HEAD
        tblClienteCargos.setModel(new javax.swing.table.DefaultTableModel(
=======
        tblResultados.setModel(new javax.swing.table.DefaultTableModel(
>>>>>>> 4a52886f5ec7732e3e7e560575bb9749400e2370
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
<<<<<<< HEAD
        tblClienteCargos.setColumnSelectionAllowed(true);
        tblClienteCargos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClienteCargosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblClienteCargos);
=======
        tblResultados.setColumnSelectionAllowed(true);
        tblResultados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblResultadosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblResultados);
>>>>>>> 4a52886f5ec7732e3e7e560575bb9749400e2370

        jButton1.setBackground(new java.awt.Color(235, 168, 23));
        jButton1.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        jButton1.setText("Menu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

<<<<<<< HEAD
        btnMensualidad.setBackground(new java.awt.Color(235, 168, 23));
        btnMensualidad.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        btnMensualidad.setText("Ver Mensualidad");
        btnMensualidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMensualidadActionPerformed(evt);
            }
        });

=======
>>>>>>> 4a52886f5ec7732e3e7e560575bb9749400e2370
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
<<<<<<< HEAD
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
=======
                        .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(400, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 881, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(174, 174, 174))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53))))
>>>>>>> 4a52886f5ec7732e3e7e560575bb9749400e2370
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
<<<<<<< HEAD
                .addGap(41, 41, 41)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMensualidad, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(88, 88, 88))
=======
                .addGap(55, 55, 55)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
                .addGap(79, 79, 79)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
>>>>>>> 4a52886f5ec7732e3e7e560575bb9749400e2370
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

<<<<<<< HEAD
    private void tblClienteCargosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClienteCargosMouseClicked
        
    }//GEN-LAST:event_tblClienteCargosMouseClicked
=======
    private void tblResultadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblResultadosMouseClicked
        // TODO add your handling code here:
        int columna;
        int row;
        //        int column = tblResultados.getColumnModel().getColumnIndexAtX(evt.getX());
        //        int row = evt.getY()/tblResultados.getRowHeight();
        columna = tblResultados.getColumnModel().getColumnIndexAtX(evt.getX());
        row = evt.getY() / tblResultados.getRowHeight();

        if (columna <= tblResultados.getColumnCount() && columna >= 0 && row <= tblResultados.getRowCount() && row >= 0) {
            Object objeto = tblResultados.getValueAt(row, columna);
            if (objeto instanceof JButton) {
                ((JButton) objeto).doClick();
                JButton boton = (JButton) objeto;
                if (boton.equals(btn)) {
                    this.setVisible(false);
                    frmDetalleCliente f= new frmDetalleCliente();
                    f.setVisible(true);
                    //FrmPersona persona = new FrmPersona(resultados.get(row));
                    //persona.setVisible(true);
                    this.dispose();

                }
            }
        }
    }//GEN-LAST:event_tblResultadosMouseClicked
>>>>>>> 4a52886f5ec7732e3e7e560575bb9749400e2370

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        frmPrincipal f = new frmPrincipal();
        this.dispose();
        f.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

<<<<<<< HEAD
    private void btnMensualidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMensualidadActionPerformed
        try {
            ContratoServicio s = contratoDAO.obtenerContrato(idSeleccionado);  
            frmDetalleCliente   f=   new frmDetalleCliente(s);
            this.dispose();
            f.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(frmRegistrarMensualidad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnMensualidadActionPerformed

=======
>>>>>>> 4a52886f5ec7732e3e7e560575bb9749400e2370
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
            java.util.logging.Logger.getLogger(frmRegistrarMensualidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmRegistrarMensualidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmRegistrarMensualidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmRegistrarMensualidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
<<<<<<< HEAD
    private javax.swing.JButton btnMensualidad;
=======
>>>>>>> 4a52886f5ec7732e3e7e560575bb9749400e2370
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
<<<<<<< HEAD
    private javax.swing.JTable tblClienteCargos;
=======
    private javax.swing.JTable tblResultados;
>>>>>>> 4a52886f5ec7732e3e7e560575bb9749400e2370
    private javax.swing.JTextField txtBusqueda;
    // End of variables declaration//GEN-END:variables
}

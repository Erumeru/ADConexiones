/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.adpresentacion;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import utils.RegistroPrueba;
import utils.utilsGraficos;

/**
 *
 * @author diego
 */
public class frmListaDeCobros extends javax.swing.JFrame {

    private Dimension dim;
    private List<RegistroPrueba> regri = new ArrayList<>();

    /**
     * Creates new form frmListaDeCobros
     */
    public frmListaDeCobros() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        dim = toolkit.getScreenSize();
        initComponents();
        jPanel1.repaint();
        jLabel1.repaint();

        regri.add(new RegistroPrueba(1, "Juan", "Calle 123", "123456789", "2024-03-12", 0, 1000.0));
        regri.add(new RegistroPrueba(2, "María", "Avenida XYZ", "987654321", "2024-03-12", 2, 1500.0));
        regri.add(new RegistroPrueba(3, "Pedro", "Av. Principal", "456789123", "2024-03-12", 1, 1200.0));
        regri.add(new RegistroPrueba(4, "Ana", "Calle Secundaria", "321654987", "2024-03-12", 3, 1800.0));
        regri.add(new RegistroPrueba(5, "Luis", "Av. Central", "789123456", "2024-03-12", 0, 900.0));
        regri.add(new RegistroPrueba(6, "Lucía", "Calle Principal", "159357246", "2024-03-12", 2, 1300.0));
        regri.add(new RegistroPrueba(7, "Carlos", "Av. Grande", "753951486", "2024-03-12", 0, 1100.0));
        regri.add(new RegistroPrueba(8, "Laura", "Av. Pequeña", "852369147", "2024-03-12", 1, 1400.0));
        regri.add(new RegistroPrueba(9, "Miguel", "Calle Larga", "369852147", "2024-03-12", 4, 2000.0));
        regri.add(new RegistroPrueba(10, "Elena", "Calle Estrecha", "147258369", "2024-03-12", 0, 950.0));
        regri.add(new RegistroPrueba(11, "Mario", "Av. Angosta", "123789456", "2024-03-12", 2, 1600.0));
        regri.add(new RegistroPrueba(12, "Sofía", "Calle Ancha", "456123789", "2024-03-12", 1, 1350.0));
        regri.add(new RegistroPrueba(13, "Daniel", "Av. Amplia", "789456123", "2024-03-12", 0, 1050.0));
        regri.add(new RegistroPrueba(14, "Valeria", "Calle Cerrada", "369147852", "2024-03-12", 3, 1900.0));
        regri.add(new RegistroPrueba(15, "Jorge", "Av. Abierta", "147852369", "2024-03-12", 0, 1000.0));

        llenarTabla();
        tableCobros.getTableHeader().setOpaque(false);
        tableCobros.getTableHeader().setBackground(new Color(233, 42, 42));
        tableCobros.getTableHeader().setForeground(new Color(0, 0, 0));
        tableCobros.repaint();
    }

    public void crearTablas() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Dirección");
        model.addColumn("Teléfono");
        model.addColumn("Fecha");
        model.addColumn("Atraso");
        model.addColumn("Pago");
        tableCobros.setModel(model);
        tableCobrosAtrasados.setModel(model);

    }

    public void llenarTabla() {
        DefaultTableModel model = (DefaultTableModel) tableCobros.getModel();
        DefaultTableModel modelAtrasados = (DefaultTableModel) tableCobrosAtrasados.getModel();
        model.setRowCount(0);
        modelAtrasados.setRowCount(0);
        //Aqui en vez de Registro Prueba seria Cargo
        List<RegistroPrueba> registroPruebasAtrasados = regri;
        List<RegistroPrueba> registroPruebasNormales = regri;
        for (RegistroPrueba registro : registroPruebasNormales) {
            model.addRow(new Object[]{
                registro.getId(),
                registro.getNombre(),
                registro.getDireccion(),
                registro.getTelefono(),
                registro.getFecha(),
                registro.getAtraso(),
                registro.getPago()
            });
        }
        tableCobros.setModel(model);
        if (registroPruebasAtrasados.isEmpty()) {
            System.out.println("invisible");
            scrollAtrasados.setVisible(false);
        } else {
            for (RegistroPrueba registro : registroPruebasAtrasados) {
                modelAtrasados.addRow(new Object[]{
                    registro.getId(),
                    registro.getNombre(),
                    registro.getDireccion(),
                    registro.getTelefono(),
                    registro.getFecha(),
                    registro.getAtraso(),
                    registro.getPago()
                });
            }
        }

        tableCobrosAtrasados.setModel(model);
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
        jLabel1 = new javax.swing.JLabel();
        txtAtrasados = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableCobros = new javax.swing.JTable();
        scrollAtrasados = new javax.swing.JScrollPane();
        tableCobrosAtrasados = new javax.swing.JTable();
        btnPeriodo = new javax.swing.JButton();
        btnGenerarPdf = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1280, 720));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo.png"))); // NOI18N

        txtAtrasados.setBackground(new java.awt.Color(220, 222, 228));
        txtAtrasados.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtAtrasados.setForeground(new java.awt.Color(255, 51, 51));
        txtAtrasados.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAtrasados.setText("Clientes Atrasados");
        txtAtrasados.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtAtrasados.setFocusable(false);
        txtAtrasados.setRequestFocusEnabled(false);

        jTextField3.setBackground(new java.awt.Color(220, 222, 228));
        jTextField3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3.setText("De La Semana");
        jTextField3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField3.setFocusable(false);
        jTextField3.setRequestFocusEnabled(false);

        tableCobros.setModel(new javax.swing.table.DefaultTableModel(
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
        tableCobros.setRowHeight(40);
        tableCobros.setRowSelectionAllowed(false);
        tableCobros.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tableCobros);

        tableCobrosAtrasados.setModel(new javax.swing.table.DefaultTableModel(
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
        tableCobrosAtrasados.setRowHeight(40);
        tableCobrosAtrasados.setRowSelectionAllowed(false);
        tableCobrosAtrasados.getTableHeader().setReorderingAllowed(false);
        scrollAtrasados.setViewportView(tableCobrosAtrasados);

        btnPeriodo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BotonPeriodo.png"))); // NOI18N
        btnPeriodo.setBorderPainted(false);
        btnPeriodo.setContentAreaFilled(false);
        btnPeriodo.setFocusable(false);
        btnPeriodo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPeriodoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPeriodoMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnPeriodoMouseReleased(evt);
            }
        });

        btnGenerarPdf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BotonGenerarPdf.png"))); // NOI18N
        btnGenerarPdf.setBorderPainted(false);
        btnGenerarPdf.setContentAreaFilled(false);
        btnGenerarPdf.setFocusable(false);
        btnGenerarPdf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnGenerarPdfMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnGenerarPdfMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 1210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1213, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(txtAtrasados, javax.swing.GroupLayout.PREFERRED_SIZE, 1213, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnGenerarPdf, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(scrollAtrasados, javax.swing.GroupLayout.PREFERRED_SIZE, 1213, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(36, 36, 36))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(txtAtrasados, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(scrollAtrasados, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGenerarPdf)
                    .addComponent(btnPeriodo))
                .addGap(82, 82, 82))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPeriodoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPeriodoMouseEntered
        btnPeriodo.setIcon(new ImageIcon(getClass().getResource("/BotonPeriodoG.png")));
    }//GEN-LAST:event_btnPeriodoMouseEntered

    private void btnPeriodoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPeriodoMouseReleased

    }//GEN-LAST:event_btnPeriodoMouseReleased

    private void btnPeriodoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPeriodoMouseExited
        btnPeriodo.setIcon(new ImageIcon(getClass().getResource("/BotonPeriodo.png")));
    }//GEN-LAST:event_btnPeriodoMouseExited

    private void btnGenerarPdfMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGenerarPdfMouseEntered
        btnGenerarPdf.setIcon(new ImageIcon(getClass().getResource("/BotonGenerarPdfG.png")));
    }//GEN-LAST:event_btnGenerarPdfMouseEntered

    private void btnGenerarPdfMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGenerarPdfMouseExited
        btnGenerarPdf.setIcon(new ImageIcon(getClass().getResource("/BotonGenerarPdf.png")));
    }//GEN-LAST:event_btnGenerarPdfMouseExited

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
            java.util.logging.Logger.getLogger(frmListaDeCobros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmListaDeCobros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmListaDeCobros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmListaDeCobros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmListaDeCobros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerarPdf;
    private javax.swing.JButton btnPeriodo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JScrollPane scrollAtrasados;
    private javax.swing.JTable tableCobros;
    private javax.swing.JTable tableCobrosAtrasados;
    private javax.swing.JTextField txtAtrasados;
    // End of variables declaration//GEN-END:variables
}

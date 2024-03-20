/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.adpresentacion;

import com.itson.proyecto2_233410_233023.dominio.Cargo;
import com.itson.proyecto2_233410_233023.dominio.Cliente;
import com.itson.proyecto2_233410_233023.dominio.ContratoServicio;
import com.itson.proyecto2_233410_233023.implementaciones.ConexionBD;
import com.mycompany.adnegocio.CargoDAO;
import com.mycompany.adnegocio.ClienteDAO;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.InputStream;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import utils.utilsGraficos;

/**
 *
 * @author diego
 */
public class frmListaDeCobros extends javax.swing.JFrame {

    private Dimension dim;
    private ClienteDAO cliente;
    private List<Cliente> listaPDF;

    /**
     * Creates new form frmListaDeCobros
     */
    public frmListaDeCobros() {
        ConexionBD conexionBD = new ConexionBD("adconexiones");
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        dim = toolkit.getScreenSize();
        initComponents();

        cliente = new ClienteDAO(conexionBD);
        listaPDF = new ArrayList<Cliente>();

        jPanel1.repaint();
        jLabel1.repaint();
        crearTablas();
        llenarTabla();
        tableCobros.getTableHeader().setOpaque(false);
        tableCobros.getTableHeader().setBackground(new Color(233, 42, 42));
        tableCobros.getTableHeader().setForeground(new Color(0, 0, 0));
        tableCobros.repaint();
    }

    public void crearTablas() {
        DefaultTableModel model = new DefaultTableModel();
        DefaultTableModel mode2 = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Dirección");
        model.addColumn("Teléfono");
        model.addColumn("Fecha");
        model.addColumn("Atraso");
        model.addColumn("Pago");
        mode2.addColumn("ID");
        mode2.addColumn("Nombre");
        mode2.addColumn("Dirección");
        mode2.addColumn("Teléfono");
        mode2.addColumn("Fecha");
        mode2.addColumn("Atraso");
        mode2.addColumn("Pago");
        tableCobros.setModel(model);
        tableCobrosAtrasados.setModel(mode2);

    }

    public void llenarTabla() {
        DefaultTableModel model = (DefaultTableModel) tableCobros.getModel();
        DefaultTableModel modelAtrasados = (DefaultTableModel) tableCobrosAtrasados.getModel();
        model.setRowCount(0);
        modelAtrasados.setRowCount(0);
        //Aqui en vez de Registro Prueba seria Cargo

        List<Cliente> clientesAtrasados = new ArrayList<>();
        List<Cliente> clientesNormales = new ArrayList<>();
        try {
            clientesAtrasados = cliente.obtenerClientesAtrasados();
            clientesNormales = cliente.obtenerClientesSemana();
        } catch (SQLException ex) {
            Logger.getLogger(frmListaDeCobros.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Cliente clientes : clientesNormales) {

            List<ContratoServicio> contratos = clientes.getContratosServicio();
            for (ContratoServicio contrato : contratos) {
                List<Cargo> cargos = contrato.getCargos();
                float costo = 0;
                Date d = cargos.get(0).getFecha();
                for (Cargo cargo : cargos) {
                    costo += cargo.getDeuda();
                    if (d.before(cargo.getFecha())) {
                        d = cargo.getFecha();
                    }
                }
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                model.addRow(new Object[]{
                    clientes.getId(),
                    clientes.getNombreCliente(),
                    clientes.getNumeroCliente() + " " + clientes.getColoniaCliente() + " " + clientes.getCalleCliente(),
                    clientes.getTelefonoCliente(),
                    formatter.format(d),
                    0,
                    costo
                });
            }
        }
        for (Cliente clientes : clientesAtrasados) {
            System.out.println(clientes.getNombreCliente());
            List<ContratoServicio> contratos = clientes.getContratosServicio();
            for (ContratoServicio contrato : contratos) {
                List<Cargo> cargos = contrato.getCargos();
                if (cargos!=null||!cargos.isEmpty()) {
                if(cargos.get(0)!=null){
                float costo = 0;
                Date d = cargos.get(0).getFecha();
                for (Cargo cargo : cargos) {
                    costo += cargo.getDeuda();
                    if (d.before(cargo.getFecha())) {
                        d = cargo.getFecha();
                    }
                }
                long diferenciaMilisegundos = new Date().getTime() - d.getTime();
                long diferenciaDias = diferenciaMilisegundos / (24 * 60 * 60 * 1000);
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                modelAtrasados.addRow(new Object[]{
                    clientes.getId(),
                    clientes.getNombreCliente(),
                    clientes.getNumeroCliente() + " " + clientes.getColoniaCliente() + " " + clientes.getCalleCliente(),
                    clientes.getTelefonoCliente(),
                    formatter.format(d),
                    diferenciaDias,
                    costo
                });
                }}
            }
        }
        tableCobros.setModel(model);
        tableCobrosAtrasados.setModel(modelAtrasados);
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

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

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
        btnPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPeriodoActionPerformed(evt);
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
        btnGenerarPdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarPdfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                            .addComponent(scrollAtrasados, javax.swing.GroupLayout.PREFERRED_SIZE, 1213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel1)))
                .addGap(36, 36, 36))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
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

    private void btnGenerarPdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarPdfActionPerformed
       
        int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro de imprimir el pdf?", "Confirmar", JOptionPane.YES_NO_OPTION);

        if (opcion == JOptionPane.YES_OPTION) {
            List<JasperReporte> pdf = new ArrayList<JasperReporte>();
            if (listaPDF.isEmpty()) {
                JOptionPane.showMessageDialog(this, "La tabla esta vacia");
                return;
            }
            for (Cliente cliente : listaPDF) {
                 JasperReporte reporte = new JasperReporte();
                 
                 long id = cliente.getId();
                 String idS = String.valueOf(id);
                 
//                 String nombreCompleto = persona.getNombre()+" "+persona.getApellidoP()+" "+persona.getApellidoM();
                String direccion = cliente.getNumeroCliente()+" "+cliente.getCalleCliente()+" "+cliente.getColoniaCliente();

                reporte.setId(idS);
                reporte.setNombre(cliente.getNombreCliente());
                reporte.setDireccion(direccion);
                reporte.setTelefono(cliente.getTelefonoCliente());
//                reporte.setFecha();
//                reporte.setAtraso();
//                reporte.setPago();
//                reporte.setCosto(String.valueOf(tramite.getCosto()));
//                reporte.setPeriodo(tramite.getFechaExpedicion().toString());
                
                pdf.add(reporte);
            }
            try {
                
                Map parametro = new HashMap();
                
                LocalDateTime fechaHoraActual = LocalDateTime.now();
                DateTimeFormatter formatEscrito = DateTimeFormatter.ofPattern("dd 'de' MMMM 'de' yyyy, hh:mm a");
                String fechaHoraEscrita = fechaHoraActual.format(formatEscrito);
                parametro.put("fecha_generacion",fechaHoraEscrita);
                
                parametro.put("historial", "Reporte General");
                
                JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(pdf);

                 //Cargar el archivo JRXML del reporte
                InputStream reportFile = getClass().getResourceAsStream("/reportePDF_1.jrxml");
                JasperReport jasperReport = JasperCompileManager.compileReport(reportFile);

                 //Llenar el reporte con los datos
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,  parametro, beanColDataSource);
                
                
                JasperViewer visu= new JasperViewer(jasperPrint, false);
                visu.setVisible(true);
                // Visualizar el reporte
                JasperExportManager.exportReportToPdfFile(jasperPrint, "./reporteTramites.pdf");
            } catch (Exception e) {
                System.out.println(e);
            }
        }
                                                    

       
       
    }//GEN-LAST:event_btnGenerarPdfActionPerformed

    private void btnPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPeriodoActionPerformed
       JOptionPane.showMessageDialog(rootPane, "En construcion solo era el 40%");
    }//GEN-LAST:event_btnPeriodoActionPerformed

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

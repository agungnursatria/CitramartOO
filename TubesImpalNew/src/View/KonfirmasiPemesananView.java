/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
/**
 *
 * @author UJANG
 */
public class KonfirmasiPemesananView extends javax.swing.JFrame {

    /**
     * Creates new form KonfirmasiPemesanan
     */
    public KonfirmasiPemesananView() {
        initComponents();
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txfidpesanan_pemesanan = new javax.swing.JTextField();
        txfnamapesanan_pemesanan = new javax.swing.JTextField();
        txfpengaju_pemesanan = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelpesanan_pemesanan = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txftotalbiaya_pemesanan = new javax.swing.JTextField();
        txfstatus_pemesanan = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txfketerangan_pemesanan = new javax.swing.JTextArea();
        btnbatal_pesan = new javax.swing.JButton();
        btnkonfirmasi_pesan = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("ID Pesanan");

        jLabel2.setText("Nama Pesanan");

        jLabel3.setText("Pengaju");

        txfidpesanan_pemesanan.setEditable(false);

        txfnamapesanan_pemesanan.setEditable(false);

        txfpengaju_pemesanan.setEditable(false);

        tabelpesanan_pemesanan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "No", "ID Pemesanan", "Nama Pemesanan", "Jumlah", "Total Harga"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Long.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelpesanan_pemesanan);

        jLabel5.setText("Total Biaya");

        jLabel6.setText("Status");

        jLabel7.setText("Keterangan");

        txftotalbiaya_pemesanan.setEditable(false);

        txfstatus_pemesanan.setEditable(false);

        txfketerangan_pemesanan.setEditable(false);
        txfketerangan_pemesanan.setColumns(20);
        txfketerangan_pemesanan.setRows(5);
        jScrollPane2.setViewportView(txfketerangan_pemesanan);

        btnbatal_pesan.setText("Batal");

        btnkonfirmasi_pesan.setText("Konfirmasi");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txfidpesanan_pemesanan, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                            .addComponent(txfnamapesanan_pemesanan)
                            .addComponent(txfpengaju_pemesanan)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txftotalbiaya_pemesanan, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                                .addComponent(txfstatus_pemesanan))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnbatal_pesan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnkonfirmasi_pesan)))))
                .addContainerGap(41, Short.MAX_VALUE))
            .addComponent(jSeparator1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txfidpesanan_pemesanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txfnamapesanan_pemesanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txfpengaju_pemesanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txftotalbiaya_pemesanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txfstatus_pemesanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnbatal_pesan)
                    .addComponent(btnkonfirmasi_pesan))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public JButton getBtnBatal_pesan() {
        return btnbatal_pesan;
    }

    public void setBtnBatal_pesan(JButton batal_pesan) {
        this.btnbatal_pesan = batal_pesan;
    }

    public JButton getBtnKonfirmasi_pesan() {
        return btnkonfirmasi_pesan;
    }

    public void setBtnKonfirmasi_pesan(JButton konfirmasi_pesan) {
        this.btnkonfirmasi_pesan = konfirmasi_pesan;
    }

    public JTable getTabelpesanan_pemesanan() {
        return tabelpesanan_pemesanan;
    }

    public void setTabelpesanan_pemesanan(JTable tabelpesanan_pemesanan) {
        this.tabelpesanan_pemesanan = tabelpesanan_pemesanan;
    }

    public JTextField getTxfidpesanan_pemesanan() {
        return txfidpesanan_pemesanan;
    }

    public void setTxfidpesanan_pemesanan(JTextField txfidpesanan_pemesanan) {
        this.txfidpesanan_pemesanan = txfidpesanan_pemesanan;
    }

    public JTextArea getTxfketerangan_pemesanan() {
        return txfketerangan_pemesanan;
    }

    public void setTxfketerangan_pemesanan(JTextArea txfketerangan_pemesanan) {
        this.txfketerangan_pemesanan = txfketerangan_pemesanan;
    }

    public JTextField getTxfnamapesanan_pemesanan() {
        return txfnamapesanan_pemesanan;
    }

    public void setTxfnamapesanan_pemesanan(JTextField txfnamapesanan_pemesanan) {
        this.txfnamapesanan_pemesanan = txfnamapesanan_pemesanan;
    }

    public JTextField getTxfpengaju_pemesanan() {
        return txfpengaju_pemesanan;
    }

    public void setTxfpengaju_pemesanan(JTextField txfpengaju_pemesanan) {
        this.txfpengaju_pemesanan = txfpengaju_pemesanan;
    }

    public JTextField getTxfstatus_pemesanan() {
        return txfstatus_pemesanan;
    }

    public void setTxfstatus_pemesanan(JTextField txfstatus_pemesanan) {
        this.txfstatus_pemesanan = txfstatus_pemesanan;
    }

    public JTextField getTxftotalbiaya_pemesanan() {
        return txftotalbiaya_pemesanan;
    }

    public void setTxftotalbiaya_pemesanan(JTextField txftotalbiaya_pemesanan) {
        this.txftotalbiaya_pemesanan = txftotalbiaya_pemesanan;
    }
    
    public void addActionListener(ActionListener e){
        btnbatal_pesan.addActionListener(e);
        btnkonfirmasi_pesan.addActionListener(e);
    }
    
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
            java.util.logging.Logger.getLogger(KonfirmasiPemesananView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KonfirmasiPemesananView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KonfirmasiPemesananView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KonfirmasiPemesananView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KonfirmasiPemesananView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbatal_pesan;
    private javax.swing.JButton btnkonfirmasi_pesan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tabelpesanan_pemesanan;
    private javax.swing.JTextField txfidpesanan_pemesanan;
    private javax.swing.JTextArea txfketerangan_pemesanan;
    private javax.swing.JTextField txfnamapesanan_pemesanan;
    private javax.swing.JTextField txfpengaju_pemesanan;
    private javax.swing.JTextField txfstatus_pemesanan;
    private javax.swing.JTextField txftotalbiaya_pemesanan;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.Barang;
import Model.Database;
import Model.Pesanan;
import View.KonfirmasiPemesananView;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author User
 */
public class Controller_KonfirmasiPemesanan implements ActionListener{
    private Database db = new Database();
    private KonfirmasiPemesananView pemesanan;
    private Pesanan p;
    
    public Controller_KonfirmasiPemesanan(Pesanan p){
        pemesanan = new KonfirmasiPemesananView();
        pemesanan.addActionListener(this);
        pemesanan.setVisible(true);
        pemesanan.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../Image/ICON6.PNG")));
        pemesanan.setTitle("Citra-Mart");
        this.p = p;
        db.connect();
        
        pemesanan.getTxfidpesanan_pemesanan().setText(p.getIdPesanan()); //Set id pesanan
        
        // Set pengaju dan pemesan
        String pengaju = db.searchUser(db.searchNIPPesanan(p.getIdPesanan())).getNama();
        pemesanan.getTxfpengaju_pemesanan().setText(pengaju);
        pemesanan.getTxfnamapesanan_pemesanan().setText(pengaju);
        
        // Set isi tabel pesanan
        DefaultTableModel tabel = (DefaultTableModel) pemesanan.getTabelpesanan_pemesanan().getModel();
        tabel.setRowCount(0);
        int i = 0;
        while (p.getListpesanan(i) != null) {
            Barang b = p.getListpesanan(i);
            tabel.addRow(new Object[]{(i+1), b.getNamaBarang(), b.getJumlah(), b.getHarga()});
            i++;
        }
        // Set total biaya, status, dan keterangan
        pemesanan.getTxftotalbiaya_pemesanan().setText(p.getBiaya() + "");
        pemesanan.getTxfstatus_pemesanan().setText(p.getStatusPesanan());
        pemesanan.getTxfketerangan_pemesanan().setText(p.getKeterangan());
    }
    
    public void actionPerformed(ActionEvent ae){
        Object source = ae.getSource();
        try{
            if(source.equals(pemesanan.getBtnKonfirmasi_pesan())){
                p.setKonfirmasi(true);
                db.updateKonfirmasi(p);
            }
            pemesanan.dispose();
        }catch (Exception e){
          JOptionPane.showMessageDialog(pemesanan, e.getMessage());
        }
    }
}

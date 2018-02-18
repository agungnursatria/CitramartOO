/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import Model.Barang;
import Model.Transaksi;
import Model.Database;
import Model.Pegawai_Kasir;
import View.Pegawai_GudangView;
import View.Pegawai_KasirView;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author UJANG
 */
public class Controller_PegawaiKasir implements ActionListener {
    private Pegawai_KasirView kasir;
    private Database db = new Database();
    private Pegawai_Kasir pk;
    private int row = 0;
    private ArrayList<Barang> ListbarangDibeli = new ArrayList<>();
    private long totalHargaPesanan = 0;
    
    public Controller_PegawaiKasir(Pegawai_Kasir pk){
        db.connect();
        kasir = new Pegawai_KasirView();
        kasir.addActionListener(this);
        kasir.setVisible(true);
        kasir.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../Image/ICON6.PNG")));
        kasir.setTitle("Citra-Mart");
        this.pk = pk;
        kasir.getTxfnama_pegkasir().setText(pk.getNama());
        kasir.getTxfnip_pegkasir().setText(pk.getNip());
//        ArrayList<Transaksi> t = db.loadTransaksi();
//        kasir.gettxfnotransaksi_pegkasir().setText((t.size()+1) + "");
        
        ImageIcon icon = new ImageIcon(getClass().getResource("../Image/"+pk.getFoto()));
        Image image = icon.getImage().getScaledInstance(kasir.getImage().getWidth(), kasir.getImage().getHeight(), Image.SCALE_SMOOTH);
        kasir.getImage().setIcon(new ImageIcon(image));
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        try{
            if(source.equals(kasir.getBtnbatal_pegkasir())){
                kasir.reset();
                totalHargaPesanan = 0;
            } else if(source.equals(kasir.getBtnbayar_pegkasir())){
                String nomorTransaksi = kasir.getTxfnotransaksi_pegkasir().getText().toString();
                // ---- list barang dibeli dh dideklarisiin diawal
                long totalHarga = Long.parseLong(kasir.getTxftotalharga_pegkasir().getText().toString());
                String status;
                if(kasir.getCeklishutang_pegkasir().isSelected()){
                    status = "Hutang";
                }else{
                    status = "Lunas";
                }
                Date tglTransaksi = kasir.getTanggal_pegkasir().getDate();
                Transaksi t = new Transaksi(nomorTransaksi, ListbarangDibeli, totalHarga, status, tglTransaksi);
                if( nomorTransaksi != "" || totalHarga != 0 || tglTransaksi != null || ListbarangDibeli != null){
                    db.SaveTransaksi(t, nomorTransaksi);
                    db.SaveBarangDibeli(t);
                    // Pengurangan stok Barang karena telah dibeli
                    for (Barang barang : ListbarangDibeli) {
                        Barang barangAdaDiDatabase = db.searchBarang(barang.getNamaBarang());
                        barangAdaDiDatabase.setJumlah(barangAdaDiDatabase.getJumlah() - barang.getJumlah());
                        db.updateBarang(barangAdaDiDatabase);
                    }
                }
                kasir.reset();
                totalHargaPesanan = 0;
            } else if(source.equals(kasir.getBtnlogout_pegkasir())){
                kasir.dispose();
                new Controller_Login();
            } else if(source.equals(kasir.getBtntambahbarang_pegkasir())){
                Barang barangAdaDiDatabase = db.searchBarang(kasir.getTxfnamabarang_pegkasir().getText().toString());
                if(barangAdaDiDatabase != null){
                    Barang barangDibeli = barangAdaDiDatabase;
                    barangDibeli.setJumlah(Integer.parseInt(kasir.getTxijumlahbarang_pegkasir().getText().toString()));
                    if (barangAdaDiDatabase.getJumlah() > barangDibeli.getJumlah()) {
                        // Input Data Ke Tabel
                        kasir.getTabel_pegkasir().setValueAt(row+1, row, 0);
                        kasir.getTabel_pegkasir().setValueAt(barangDibeli.getNamaBarang(), row, 1);
                        kasir.getTabel_pegkasir().setValueAt(barangDibeli.getJumlah(), row, 2);
                        kasir.getTabel_pegkasir().setValueAt(barangDibeli.getHarga(), row, 3);
                        kasir.getTabel_pegkasir().setValueAt((barangDibeli.getJumlah()*barangDibeli.getHarga()), row, 4);
                        row++;
                        ListbarangDibeli.add(barangAdaDiDatabase);
                        totalHargaPesanan += barangDibeli.getJumlah()*barangDibeli.getHarga();
                        kasir.getTxftotalharga_pegkasir().setText(totalHargaPesanan + "");
                    }else{
                        JOptionPane.showMessageDialog(kasir, "stok kurang");
                    }
                } else {
                    JOptionPane.showMessageDialog(kasir, "Barang tidak ditemukan");
                }
                kasir.getTxijumlahbarang_pegkasir().setText("");
                kasir.getTxfnamabarang_pegkasir().setText("");
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(kasir, "terjadi kesalahan di view kasir");
        }
    }
}

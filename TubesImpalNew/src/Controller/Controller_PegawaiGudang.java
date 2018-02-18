/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Barang;
import Model.Database;
import Model.Pegawai_Gudang;
import Model.Pesanan;
import View.Pegawai_GudangView;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author UJANG
 */
public class Controller_PegawaiGudang implements ActionListener{
    private Pegawai_GudangView gudang;
    private Database db = new Database();
    private Pegawai_Gudang pg;
    private int row,rowp;
    private ArrayList<Barang> listbarang = new ArrayList<>();
    
    public Controller_PegawaiGudang(Pegawai_Gudang pg){
        db.connect();
        gudang = new Pegawai_GudangView();
        gudang.addActionListener(this);
        gudang.setVisible(true);
        gudang.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../Image/ICON6.PNG")));
        gudang.setTitle("Citra-Mart");
        this.pg = pg;
    
    
        ArrayList<Barang> b = db.loadBarang();
        row =0;
        //JOptionPane.showMessageDialog(keuanganview, p.get(0).getIdPesanan());
        for (Barang barang : b) {
                gudang.getTabelbarang_pegbarang().setValueAt(row+1, row, 0);
                gudang.getTabelbarang_pegbarang().setValueAt(barang.getNamaBarang(), row, 1);
                gudang.getTabelbarang_pegbarang().setValueAt(barang.getJumlah(), row, 2);
                gudang.getTabelbarang_pegbarang().setValueAt(barang.getHarga(), row, 3);
                row++;
            
        }
        
        ArrayList<Pesanan> p = db.loadPesanan();
        rowp =0;
        for (Pesanan pesanan : p) {
                gudang.getTabelpesanan_pegbarang().setValueAt(rowp+1, rowp, 0);
                gudang.getTabelpesanan_pegbarang().setValueAt(pesanan.getIdPesanan(), rowp, 1);
                gudang.getTabelpesanan_pegbarang().setValueAt(pesanan.getSizeListPesanan(), rowp, 2);
                gudang.getTabelpesanan_pegbarang().setValueAt(pesanan.getBiaya(), rowp, 3);
                gudang.getTabelpesanan_pegbarang().setValueAt(pesanan.getStatusPesanan(), rowp, 4);
                gudang.getTabelpesanan_pegbarang().setValueAt(pesanan.getKeterangan(), rowp, 5);
                rowp++;
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae){
        Object source = ae.getSource();
        try{
            if(source.equals(gudang.getBtntambahbarang_pegbarang())){
                String nmbarang = gudang.getTxinamabarang_pegbarang().getText().toString();
                int jmlh = Integer.parseInt(gudang.getTxijumlahbarang_pegbarang().getText().toString());
                int satuan = Integer.parseInt(gudang.getTxihargasatuan_pegbarang().getText().toString());
                Barang b = new Barang(nmbarang, jmlh, satuan);
                
                gudang.getTabelbarang_pegbarang().setValueAt(row+1, row, 0);
                gudang.getTabelbarang_pegbarang().setValueAt(b.getNamaBarang(), row, 1);
                gudang.getTabelbarang_pegbarang().setValueAt(b.getJumlah(), row, 2);
                gudang.getTabelbarang_pegbarang().setValueAt(b.getHarga(), row, 3);
                row++;
                
                db.SaveBarang(b);
                gudang.Reset();
                JOptionPane.showMessageDialog(gudang, "barang telah di tambahkan");
            } else if(source.equals(gudang.getBtnbatal_pegbarang())){
                gudang.Reset();
            } else if(source.equals(gudang.getBtnltambahpesanan_pegbarang())){
                String nmbarang = gudang.getTxinamabarangpesanan_pegbarang().getText().toString();
                int jmlh = Integer.parseInt(gudang.getTxihargasatuanpesanan_pegbarang().getText().toString());
                int satuan = Integer.parseInt(gudang.getTxitotalpesanan_pegbarang().getText().toString());
                listbarang.add(new Barang(nmbarang, jmlh, satuan));
                JOptionPane.showMessageDialog(gudang, listbarang.get(0).getNamaBarang());
                gudang.getTxinamabarangpesanan_pegbarang().setText("");
                gudang.getTxihargasatuanpesanan_pegbarang().setText("");
                gudang.getTxitotalpesanan_pegbarang().setText("");
            } else if(source.equals(gudang.getSelesaipesanan_Peggudang())){
                
                String idPesanan = gudang.getTxfidpesanan_pegbarang().getText().toString();
                String keterangan = gudang.getTxiketerangan_pegbarang().getText().toString();
                long total=0;
                for (Barang barang : listbarang) {
                    total+=barang.getHarga();
                }
                Pesanan p = new Pesanan(idPesanan, listbarang, "Lunas", total, keterangan, null, false);  // MASIH GK BENER
                gudang.getTabelpesanan_pegbarang().setValueAt(rowp+1, rowp, 0);
                gudang.getTabelpesanan_pegbarang().setValueAt(p.getIdPesanan(), rowp, 1);                
                gudang.getTabelpesanan_pegbarang().setValueAt(listbarang.size(), rowp, 2);
                gudang.getTabelpesanan_pegbarang().setValueAt(p.getBiaya(), rowp, 3);
                gudang.getTabelpesanan_pegbarang().setValueAt(p.getStatusPesanan(), rowp, 4);
                gudang.getTabelpesanan_pegbarang().setValueAt(p.getKeterangan(), rowp, 5);
                rowp++;
                db.SavePesanan(p, pg.getNip());
                gudang.Reset();
            } else if(source.equals(gudang.getBtnbatalpesanan_pegbarang())){
                gudang.Reset();
            } else if(source.equals(gudang.getBtnlogout_pegbarang())){
                gudang.dispose();
                new Controller_Login();
            }
        }catch (Exception e){
          JOptionPane.showMessageDialog(gudang, e.getMessage());
        }
    }
}

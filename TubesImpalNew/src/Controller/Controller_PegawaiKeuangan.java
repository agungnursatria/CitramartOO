/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.Transaksi;
import Model.Pegawai_Keuangan;
import Model.Database;
import Model.Pesanan;
import View.Pegawai_KeuanganView;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author User
 */
public class Controller_PegawaiKeuangan implements ActionListener{
    private Database db = new Database();
    private Pegawai_KeuanganView keuanganview;
    private Pegawai_Keuangan pk;
    
    public Controller_PegawaiKeuangan(Pegawai_Keuangan pk){
        keuanganview = new Pegawai_KeuanganView();
        keuanganview.addActionListener(this);
        keuanganview.setVisible(true);
        keuanganview.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../Image/ICON6.PNG")));
        keuanganview.setTitle("Citra-Mart");
        db.connect();
        this.pk = pk;
        long totalpiutang = 0;
        long totalhutang = 0;
        
            ArrayList<Pesanan> p = db.loadPesanan();
        int row =0;
        //JOptionPane.showMessageDialog(keuanganview, p.get(0).getIdPesanan());
        for (Pesanan pesanan : p) {
                keuanganview.getTabeltransaksipesanan_pegkeuangan().setValueAt(row+1, row, 0);
                keuanganview.getTabeltransaksipesanan_pegkeuangan().setValueAt(pesanan.getIdPesanan(), row, 1);
                keuanganview.getTabeltransaksipesanan_pegkeuangan().setValueAt(" ", row, 2);
                keuanganview.getTabeltransaksipesanan_pegkeuangan().setValueAt(pesanan.getBiaya(), row, 3);
                keuanganview.getTabeltransaksipesanan_pegkeuangan().setValueAt(pesanan.getTglPesan(), row, 4);
                keuanganview.getTabeltransaksipesanan_pegkeuangan().setValueAt(pesanan.getStatusPesanan(), row, 5);
                row++;
            
        }
        
        ArrayList<Transaksi> t = db.loadTransaksi();
        row = 0;
        for (Transaksi transaksi : t) {
            keuanganview.getTabelpenjualan_pegkeuangan().setValueAt(row+1, row, 0);
            keuanganview.getTabelpenjualan_pegkeuangan().setValueAt(transaksi.getIdTransaksi(), row, 1);
            keuanganview.getTabelpenjualan_pegkeuangan().setValueAt(transaksi.getTglTransaksi(), row, 2);
            keuanganview.getTabelpenjualan_pegkeuangan().setValueAt(" ", row, 3);
            keuanganview.getTabelpenjualan_pegkeuangan().setValueAt(transaksi.getTotalHarga(), row, 4);
            keuanganview.getTabelpenjualan_pegkeuangan().setValueAt(transaksi.getStatus(), row, 5);
            row++;
        }
        
        ArrayList<Transaksi> t2 = db.loadTransaksi();
        row = 0;
        for (Transaksi transaksi : t2) {
            if (transaksi.getStatus().equals("belum lunas")){
                keuanganview.getTabelpiutang_pegkeuangan().setValueAt(row+1, row, 0);
                keuanganview.getTabelpiutang_pegkeuangan().setValueAt(" ", row, 1);
                keuanganview.getTabelpiutang_pegkeuangan().setValueAt(transaksi.getIdTransaksi(), row, 2);
                keuanganview.getTabelpiutang_pegkeuangan().setValueAt(transaksi.getTglTransaksi(), row, 3);
                keuanganview.getTabelpiutang_pegkeuangan().setValueAt(transaksi.getTotalHarga(), row, 4);
                keuanganview.getTabelpiutang_pegkeuangan().setValueAt(transaksi.getStatus(), row, 5);
                totalpiutang = totalpiutang + transaksi.getTotalHarga();
                row++;
            }
        }
        keuanganview.getTxftotalpiutang_pegkeuangan().setText(totalpiutang + "");
        
        ArrayList<Pesanan> p2 = db.loadPesanan();
        row =0;
        for (Pesanan pesanan : p2) {
            if(pesanan.getStatusPesanan().equals("belum lunas")){
                keuanganview.getTabelhutang_pegkeuangan().setValueAt(row+1, row, 0);
                keuanganview.getTabelhutang_pegkeuangan().setValueAt(" ", row, 1);
                keuanganview.getTabelhutang_pegkeuangan().setValueAt(pesanan.getIdPesanan(), row, 2);
                //keuanganview.getTabelhutang_pegkeuangan().setValueAt(pesanan.getBiaya(), row, 3);
                keuanganview.getTabelhutang_pegkeuangan().setValueAt(pesanan.getTglPesan(), row, 3);
                keuanganview.getTabelhutang_pegkeuangan().setValueAt(pesanan.getStatusPesanan(), row, 4);
                totalhutang = totalhutang + pesanan.getBiaya();
                row++;
            }
        }
        keuanganview.getTxftotalhutang_pegkeuangan().setText(totalhutang + "");
    }
    
    public void actionPerformed(ActionEvent ae){
        Object source = ae.getSource();
        try{
            if(source.equals(keuanganview.getbtnLogout_pegkeuangan())){
                keuanganview.dispose();
                new Controller_Login();
            } else if(source.equals(keuanganview.getbtnPrint_pegkeuangan())){
                
            }
        }catch (Exception e){
          JOptionPane.showMessageDialog(keuanganview, e.getMessage());
        }
    }
}

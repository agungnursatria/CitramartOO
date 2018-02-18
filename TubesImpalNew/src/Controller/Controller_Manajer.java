/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Database;
import Model.Manajer;
import Model.Pesanan;
import Model.Transaksi;
import View.ManajerView;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Agung
 */
public class Controller_Manajer implements ActionListener{
    private ManajerView m;
    private Database db = new Database();
    private Manajer mnj;
    

    public Controller_Manajer(Manajer mnj){
        db.connect();
        m = new ManajerView();
        m.addActionListener(this);
        m.setVisible(true);
        m.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../Image/ICON6.PNG")));
        m.setTitle("Citra-Mart");
        this.mnj = mnj;
        
        m.getTxdjenislaporan_manajer().addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ie){
                Object source = ie.getItem();
                try {
                    DefaultTableModel tabel = (DefaultTableModel) m.getTabellaporan_manajer().getModel();
                    tabel.setRowCount(0);
                    int i = 0;
                    if(source.equals("Jurnal Keuangan")){
                        ArrayList<Transaksi> transaksi = db.loadTransaksi();
                        for (Transaksi t : transaksi) {
                            tabel.addRow(new Object[]{(i+1), t.getIdTransaksi(), t.getTglTransaksi(), t.getTotalHarga(), t.getStatus()});
                            i++;
                        }
                    }else if(source.equals("Laporan Hutang-Piutang")){
                        
                    }else if(source.equals("Laporan Rugi Laba")){
                        
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(m, e.getMessage());
                }
            }
        });
        
        
        DefaultTableModel tabel = (DefaultTableModel) m.getTabelpemesanan_manajer().getModel();
        tabel.setRowCount(0);
        int i = 0;
        ArrayList<Pesanan> pesanan = db.loadPesanan();
        for (Pesanan p : pesanan) {
            tabel.addRow(new Object[]{(i+1), p.getIdPesanan(), p.getTglPesan(), p.getKonfirmasi()});
            i++;
        }
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        try{
            if(source.equals(m.getBtnlogout_manajer())){
                m.dispose();
                new Controller_Login();
            } else if(source.equals(m.getBtnprintlaporan_manajer())){
                
            }
        } catch (Exception e){
          JOptionPane.showMessageDialog(m, e.getMessage());
        }
    }
    
}

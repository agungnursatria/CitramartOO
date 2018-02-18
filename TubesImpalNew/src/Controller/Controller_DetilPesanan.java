/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Barang;
import Model.Database;
import Model.Pesanan;
import View.DetilPesananView;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author UJANG
 */
public class Controller_DetilPesanan implements ActionListener{
    private DetilPesananView detil;
    private Database db = new Database();
    
    
    public Controller_DetilPesanan(Pesanan p){
        db.connect();
        detil = new DetilPesananView();
        detil.addActionListener(this);
        detil.setVisible(true);
        detil.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../Image/ICON6.PNG")));
        detil.setTitle("Citra-Mart");
        detil.getTxfidpesanan_detilpesanan().setText(p.getIdPesanan());
        detil.getTxftotalharga_detilpemesanan().setText(p.getBiaya() + "");
        
        DefaultTableModel tabel = (DefaultTableModel) detil.getTabel_detilpemesanan().getModel();
        tabel.setRowCount(0);
        int i = 0;
        while (p.getListpesanan(i) != null) {
            Barang b = p.getListpesanan(i);
            tabel.addRow(new Object[]{(i+1), b.getNamaBarang(), b.getJumlah(), b.getHarga()});
            i++;
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        try{
            if(source.equals(detil.getBtnok_detilpemesanan())){
                try{
                detil.dispose();
                }catch (Exception e){
                    JOptionPane.showMessageDialog(detil, "");
                }
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(detil, "");
        }
    }
}

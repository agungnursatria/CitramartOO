/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Barang;
import Model.User;
import Model.Transaksi;
import Model.Pegawai_Keuangan;
import Model.Admin;
import Model.Database;
import Model.Pegawai_Gudang;
import Model.Manajer;
import Model.Pesanan;
import Model.Pegawai_Kasir;
import View.AdminView;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import jdk.nashorn.internal.objects.NativeString;

/**
 *
 * @author Agung
 */
public class Controller_Admin implements ActionListener{
    private Database db = new Database();
    private AdminView adm;
    private Admin a;
    private int row =0;
    JFileChooser chooser = new JFileChooser();
    ArrayList<User> u;

    public Controller_Admin(Admin a) {
        db.connect();
        adm = new AdminView();
        adm.addActionListener(this);
        adm.setVisible(true);
        adm.getTanggal_kelolauser().setDateFormatString("yyyy-MM-dd");
        adm.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../Image/ICON6.PNG")));
        adm.setTitle("Citra-Mart");
        this.a = a;
        u = db.loadUser();
        for (User user : u) {
            if(adm.nomorNIP < Integer.parseInt(user.getNip().substring(2))){
                adm.nomorNIP = Integer.parseInt(user.getNip().substring(2));
            }
            // Mengisi JTable                   //isi , row , column
            adm.getTabel_kelolauser().setValueAt(row+1 , row, 0);
            adm.getTabel_kelolauser().setValueAt(user.getUsername(), row, 1);
            adm.getTabel_kelolauser().setValueAt(user.getNama(), row, 2);
            // Mengisi Combobox
            adm.getCbxUser().addItem(user.getUsername());
            row++;
        }
        adm.nomorNIP++;
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        User userBaru;
        Object source = ae.getSource();
        try{
            if(source.equals(adm.getBtnTambah_kelolauser())){
                String kodePegawai = NativeString.substring(adm.getTxfnip_kelolauser().getText().toString(), 0, 1);
                String nip = adm.getTxfnip_kelolauser().getText().toString();
                String nama = adm.getTxinama_kelolauser().getText().toString();
                String username = adm.getTxiusername_kelolauser().getText().toString();
                String password = adm.getTxipassword_kelolauser().getText().toString();
                String email = adm.getTxiemail_kelolauser().getText().toString();
                String alamat = adm.getTxialamat_kelolauser().getText().toString();
                String noHP = adm.getTxtNoHP().getText().toString();
                Date tgl = adm.getTanggal_kelolauser().getDate();
                
                if( nip == "" || nama == "" || username == "" || password == "" || email == "" || alamat == "" || noHP == "" || tgl == null || !isNumeric(noHP)){
                    JOptionPane.showMessageDialog(adm, "inputan salah");
                }else{
                    switch (kodePegawai.toUpperCase()) {
                        case "M":
                            userBaru = new Manajer(nip,nama,username,password,tgl,alamat,email,noHP,"QMark.png");
                            db.SaveManajer((Manajer) userBaru);
                            break;
                        case "G":
                            userBaru = new Pegawai_Gudang(nip,nama,username,password,tgl,alamat,email,noHP,"QMark.png");
                            db.SavePegawaiGudang((Pegawai_Gudang) userBaru);
                            break;
                        case "K":
                            userBaru = new Pegawai_Kasir(nip,nama,username,password,tgl,alamat,email,noHP,"QMark.png");
                            db.SavePegawaiKasir((Pegawai_Kasir) userBaru);
                            break;
                        case "U":
                            userBaru = new Pegawai_Keuangan(nip,nama,username,password,tgl,alamat,email,noHP,"QMark.png");
                            db.SavePegawaiKeuangan((Pegawai_Keuangan) userBaru);
                            break;
                        default:
                            break;
                    }
                    //Mengisi JTable
                    adm.getTabel_kelolauser().setValueAt(row+1, row, 0);
                    adm.getTabel_kelolauser().setValueAt(username, row, 1);
                    adm.getTabel_kelolauser().setValueAt(nama, row, 2);
                    // Mengisi Combobox
                    adm.getCbxUser().addItem(username);
                    //Penambahan nomor pegawai
                    adm.nomorNIP++;
                    //Penambahan baris
                    row++;
                }
                adm.Reset();
            } else if(source.equals(adm.getBtnBackup())){
                String direktori = chooser.getSelectedFile().getAbsolutePath();
                String jenis = adm.getTxdjenisdata_backup().toString();
                String namaFile = adm.getTxinama_backup().toString();
                if(direktori == null || jenis == null || namaFile == null){
                    JOptionPane.showMessageDialog(adm, "inputan salah");
                } else {
                    String location = adm.getTxtDirectory().getText().toString() + "/" + adm.getTxtnama_backup().getText().toString() + ".txt";
                    try {
                        FileWriter fw = new FileWriter(location);
                        BufferedWriter bw = new BufferedWriter(fw);
                        String query = "";
                        if (adm.getTxdjenisdata_backup().getSelectedItem().toString() == "Data User") {
                            ArrayList<User> u = db.loadUser();
                            // memasukkan query user kedalam file
                            for (User user : u) {
                                if( user instanceof Admin ){
                                    query = "INSERT INTO `admin`(`nip`, `nama`, `username`, `password`, `tglLahir`, `alamat`, `email`, `NoHP`, `foto`);"
                                            + "VALUES ('" + user.getNip() + "','" + user.getNama() + "','" + user.getUsername() + "','" + user.getPassword() + "','" 
                                            + user.getTglLahir() + "','" + user.getAlamat() + "','" + user.getEmail() + "','" + user.getNoHP() + "','" + user.getFoto()+"');";
                                } else if( user instanceof Manajer ){
                                    query = "INSERT INTO `manajer`(`nip`, `nama`, `username`, `password`, `tglLahir`, `alamat`, `email`, `NoHP`, `foto`) "
                                            + "VALUES ('" + user.getNip() + "','" + user.getNama() + "','" + user.getUsername() + "','" + user.getPassword() + "','" 
                                            + user.getTglLahir() + "','" + user.getAlamat() + "','" + user.getEmail() + "','" + user.getNoHP() + "','" + user.getFoto()+"');";
                                } else if( user instanceof Pegawai_Gudang ){
                                    query = "INSERT INTO `pegawai_gudang`(`nip`, `nama`, `username`, `password`, `tglLahir`, `alamat`, `email`, `NoHP`, `foto`) "
                                            + "VALUES ('" + user.getNip() + "','" + user.getNama() + "','" + user.getUsername() + "','" + user.getPassword() + "','" 
                                            + user.getTglLahir() + "','" + user.getAlamat() + "','" + user.getEmail() + "','" + user.getNoHP() + "','" + user.getFoto()+"');";
                                } else if( user instanceof Pegawai_Kasir ){
                                    query = "INSERT INTO `pegawai_kasir`(`nip`, `nama`, `username`, `password`, `tglLahir`, `alamat`, `email`, `NoHP`, `foto`) "
                                            + "VALUES ('" + user.getNip() + "','" + user.getNama() + "','" + user.getUsername() + "','" + user.getPassword() + "','" 
                                            + user.getTglLahir() + "','" + user.getAlamat() + "','" + user.getEmail() + "','" + user.getNoHP() + "','" + user.getFoto()+"');";
                                } else if( user instanceof Pegawai_Keuangan ){
                                    query = "INSERT INTO `pegawai_keuangan`(`nip`, `nama`, `username`, `password`, `tglLahir`, `alamat`, `email`, `NoHP`, `foto`) "
                                            + "VALUES ('" + user.getNip() + "','" + user.getNama() + "','" + user.getUsername() + "','" + user.getPassword() + "','" 
                                            + user.getTglLahir() + "','" + user.getAlamat() + "','" + user.getEmail() + "','" + user.getNoHP() + "','" + user.getFoto()+"');";
                                }
                                bw.write(query);
                                bw.newLine();
                            }
                        } else if(adm.getTxdjenisdata_backup().getSelectedItem().toString() == "Data Transaksi"){
                            ArrayList<Transaksi> t = db.loadTransaksi();
                            ArrayList<String> tampunganQuerybarangDibeli = new ArrayList<>();
                            for (Transaksi transaksi : t) {
                                String nip = db.searchNIPTransaksi(transaksi.getIdTransaksi());
                                // memasukkan query transaksi kedalam file
                                query="INSERT INTO `transaksi`(`nip`, `idTransaksi`, `totalHarga`, `status`, `tglTransaksi`) VALUES "
                                        + "('" + nip + "','" + transaksi.getIdTransaksi() + "'," +  transaksi.getTotalHarga() + ",'" + transaksi.getStatus() + "','" +  transaksi.getTglTransaksi() + "');";
                                bw.write(query);
                                bw.newLine();

                                //Barang dibeli pada transaksi ditampung didalam suatu arraylist string
                                //nantinya akan digunakan untuk memasukkan data ke file juga, namun agar dipisahkan barisnya tidak tercampur dengan query transaksi, disimpan dlu
                                ArrayList<Barang> barangDibeli = db.searchBarangDibeli(transaksi.getIdTransaksi());

                                for (Barang barang : barangDibeli) {
                                    query = "INSERT INTO `barangdibeli`(`idTransaksi`, `namaBarang`, `jumlah`, `totalHarga`) VALUES ('" 
                                            + transaksi.getIdTransaksi() + "','" + barang.getNamaBarang() + "'," +  barang.getJumlah() + "," +  barang.getHarga() + ");";
                                    tampunganQuerybarangDibeli.add(query);
                                }
                            }
                            // Memasukkan query barang dibeli kedalam file
                            for (String QueryDibeli : tampunganQuerybarangDibeli) {
                                bw.write(QueryDibeli);
                                bw.newLine();
                            }
                        } else if(adm.getTxdjenisdata_backup().getSelectedItem().toString() == "Data Pesanan"){
                            ArrayList<Pesanan> pesanan = db.loadPesanan();
                            ArrayList<String> tampunganQueryListPesanan = new ArrayList<>();
                            for (Pesanan p : pesanan) {
                                String nip = db.searchNIPPesanan(p.getIdPesanan());
                                // memasukkan query pesanan kedalam file
                                query="INSERT INTO `pesanan`(`nip`, `idPesanan`, `statusPesanan`, `biaya`, `keterangan`, `tglPesan`, `konfirmasi`) VALUES "
                                        + "('" + nip + "','" + p.getIdPesanan() + "','" + p.getStatusPesanan() + "'," +  p.getBiaya() + ",'" +  p.getKeterangan() + "','" +  p.getTglPesan() + "','" +  p.getKonfirmasi() + "');";
                                bw.write(query);
                                bw.newLine();

                                //Barang dibeli pada transaksi ditampung didalam suatu arraylist string
                                //nantinya akan digunakan untuk memasukkan data ke file juga, namun agar dipisahkan barisnya tidak tercampur dengan query transaksi, disimpan dlu
                                ArrayList<Barang> listPesanan = db.searchBarangDibeli(p.getIdPesanan());

                                for (Barang barang : listPesanan) {
                                    query = "INSERT INTO `listpesanan`(`idPesanan`, `namaBarang`, `jumlah`, `totalHarga`) VALUES ('" 
                                            + p.getIdPesanan()+ "','" + barang.getNamaBarang() + "'," +  barang.getJumlah() + "," +  barang.getHarga() + ");";
                                    tampunganQueryListPesanan.add(query);
                                }
                            }
                            // Memasukkan query barang dibeli kedalam file
                            for (String QueryDipesan : tampunganQueryListPesanan) {
                                bw.write(QueryDipesan);
                                bw.newLine();
                            }
                        } else if(adm.getTxdjenisdata_backup().getSelectedItem().toString() == "Data Barang"){
                            ArrayList<Barang> barang = db.loadBarang();
                            for (Barang b : barang) {
                                query = "INSERT INTO `barang`(`namaBarang`, `jumlah`, `harga`) VALUES ('" + b.getNamaBarang() + "'," + b.getJumlah() + "," + b.getHarga()+ ");";
                                bw.write(query);
                                bw.newLine();
                            }
                        }
                        bw.close();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(adm, e.getMessage());
                    }
                } 
                adm.Reset();
            } else if(source.equals(adm.getBtnDirBackup())){
                chooser = new JFileChooser(new File("D:\\"));
                chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int returnVal = chooser.showOpenDialog(adm);
                if(returnVal == JFileChooser.APPROVE_OPTION) {
                    adm.getTxtDirectory().setText(chooser.getSelectedFile().getAbsolutePath());
                }
            } else if (source.equals(adm.getBtnUpdate())){
                String nipUserYgdiUpdate = u.get(adm.getCbxUser().getSelectedIndex()).getNip();
                new Controller_UpdateProfil(nipUserYgdiUpdate);
            } else if (source.equals(adm.getBtnDelete())){
                User userYgdiDelete = u.get(adm.getCbxUser().getSelectedIndex());
                u.remove(userYgdiDelete);
                if(userYgdiDelete instanceof Manajer){
                    db.deleteManajer((Manajer) userYgdiDelete);
                } else if (userYgdiDelete instanceof Pegawai_Gudang){
                    db.deletePegawaiGudang((Pegawai_Gudang) userYgdiDelete);
                } else if (userYgdiDelete instanceof Pegawai_Kasir){
                    db.deletePegawaiKasir((Pegawai_Kasir) userYgdiDelete);
                } else if (userYgdiDelete instanceof Pegawai_Keuangan){
                    db.deletePegawaiKeuangan((Pegawai_Keuangan) userYgdiDelete);
                }
                row--;
                int selectedIndex = adm.getCbxUser().getSelectedIndex();
                DefaultTableModel tablekelolauser = (DefaultTableModel) adm.getTabel_kelolauser().getModel();
                tablekelolauser.removeRow(selectedIndex);
                
                adm.getCbxUser().removeItemAt(selectedIndex);
            } else if (source.equals(adm.getBtnlogout())) {
                adm.dispose();
                new Controller_Login();
            }
        } catch (Exception e){
          JOptionPane.showMessageDialog(adm, e.getMessage());
        }
    }   
    
    public static boolean isNumeric(String str) {
        for (char c : str.toCharArray()){
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }
}
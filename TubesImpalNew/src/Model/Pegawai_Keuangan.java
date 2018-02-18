package Model;


import java.util.ArrayList;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Agung
 */
public class Pegawai_Keuangan extends User{
    private ArrayList<Transaksi> transaksi;
    private ArrayList<Pesanan> pesanan;

    public Pegawai_Keuangan(String nip, String nama, String username, String password, Date tglLahir, String alamat, String email, String NoHP, String foto) {
        super(nip,nama,username,password,tglLahir,alamat,email,NoHP, foto);
        transaksi = new ArrayList<Transaksi>();
        pesanan = new ArrayList<Pesanan>();
    }

    public ArrayList<Transaksi> getTransaksi() {
        return transaksi;
    }

    public void addTransaksi(Transaksi transaksi) {
        this.transaksi.add(transaksi);
    }

    public ArrayList<Pesanan> getPesanan() {
        return pesanan;
    }

    public void addPesanan(Pesanan pesanan) {
        this.pesanan.add(pesanan);
    }
    
//    public void BacaDataTransaksi(){
//        
//    }
//    
//    public void BuatLaporanRugiLaba(){
//        
//    }
//    
//    public void buatLaporanHutangPiutang(){
//        
//    }
//    
//    public void BuatJurnalKeuangan(){
//        
//    }
//    
//    public void BacaDataKeuangan(){
//        
//    }
//    
//    public void BacaDataPesanan(){
//        
//    }
    
}

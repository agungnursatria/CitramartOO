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
public class Pegawai_Kasir extends User{
    public ArrayList<Transaksi> transaksi;
    
    public Pegawai_Kasir(String nip, String nama, String username, String password, Date tglLahir, String alamat, String email, String NoHP, String foto) {
        super(nip,nama,username,password,tglLahir,alamat,email,NoHP, foto);
        this.transaksi = new ArrayList<Transaksi>();
    }
    
    public void InputTransaksi(String idTransaksi, ArrayList<Barang> barangDibeli, long totalHarga, String status, Date tglTransaksi){
        this.transaksi.add(new Transaksi(idTransaksi, barangDibeli, totalHarga, status, tglTransaksi));
    }
    
//    public void catatPiutang(){
//        
//    }
    
    public ArrayList<Transaksi> getTransaksi() {
        return transaksi;
    }
}

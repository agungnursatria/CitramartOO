package Model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Agung
 */
public class Pegawai_Gudang extends User{
    private ArrayList<Pesanan> pesanan;
    private ArrayList<Barang> barang;

    public Pegawai_Gudang(String nip, String nama, String username, String password, Date tglLahir, String alamat, String email, String NoHP, String foto) {
        super(nip,nama,username,password,tglLahir,alamat,email,NoHP, foto);
        pesanan = new ArrayList<Pesanan>();
//        barang = new ArrayList<Barang>();
    }
    
    public void InputPesanan(String idPesanan, ArrayList<Barang> listpesanan, String statusPesanan, long biaya, String keterangan, Date tglPesan, boolean konfirmasi){
        this.pesanan.add(new Pesanan(idPesanan,listpesanan,statusPesanan,biaya,keterangan,tglPesan,konfirmasi));
    }
    
    public void InputBarang(Barang barang){
        this.barang.add(barang);
    }

    public ArrayList<Barang> getBarang() {
        return barang;
    }
    
//    public void BacaDataStok(Barang barang){
//        
//    }
    
//    public boolean BacaKonfirmasi(Pesanan pesanan){
//        return pesanan.getKonfirmasi();
//    }

    public ArrayList<Pesanan> getPesanan() {
        return pesanan;
    }
    
}
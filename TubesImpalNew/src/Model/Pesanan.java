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
public class Pesanan {
    private String idPesanan;
    private ArrayList<Barang> listpesanan;
    private String statusPesanan; // hutang atau lunas
    private long biaya; // biaya total dari pesanan
    private String keterangan; // semacam keterangan
    private Date tglPesan;
    private boolean konfirmasi; // sudah dikonfirmasi manajer atau belum

    public Pesanan(String idPesanan, ArrayList<Barang> listpesanan,String statusPesanan, long biaya, String keterangan, Date tglPesan, boolean konfirmasi) {
        this.idPesanan = idPesanan;
        this.listpesanan = listpesanan;
        this.statusPesanan = statusPesanan;
        this.biaya = biaya;
        this.keterangan = keterangan;
        this.tglPesan = tglPesan;
        this.konfirmasi = konfirmasi;
    }
    
    public String getIdPesanan() {
        return idPesanan;
    }

    public void setIdPesanan(String idPesanan) {
        this.idPesanan = idPesanan;
    }

    public Barang getListpesanan(int i) {
        return this.listpesanan.get(i);
    }

    public int getSizeListPesanan() {
        return listpesanan.size();
    }

    public void addListpesanan(Barang listpesanan) {
        this.listpesanan.add(listpesanan);
    }
    
    public String getStatusPesanan() {
        return statusPesanan;
    }

    public void setStatusPesanan(String statusPesanan) {
        this.statusPesanan = statusPesanan;
    }

    
    public long getBiaya() {
        return biaya;
    }

    public void setBiaya(long biaya) {
        this.biaya = biaya;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public Date getTglPesan() {
        return tglPesan;
    }

    public void setTglPesan(Date tglPesan) {
        this.tglPesan = tglPesan;
    }

    public boolean isKonfirmasi() {
        return konfirmasi;
    }

    public void setKonfirmasi(boolean konfirmasi) {
        this.konfirmasi = konfirmasi;
    }
    
    public boolean getKonfirmasi() {
        return konfirmasi;
    }
        
}

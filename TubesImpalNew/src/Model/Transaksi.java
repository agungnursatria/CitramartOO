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
public class Transaksi {
    private String idTransaksi;
    private ArrayList<Barang> barangDibeli;
    private long totalHarga;
    private String status; // Hutang atau tidak
    private Date tglTransaksi;

    public Transaksi(String idTransaksi, ArrayList<Barang> barangDibeli, long totalHarga, String status, Date tglTransaksi) {
        this.idTransaksi = idTransaksi;
        this.barangDibeli = barangDibeli;
        this.totalHarga = totalHarga;
        this.status = status;
        this.tglTransaksi = tglTransaksi;
    }
    
    public String getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(String idTransaksi) {
        this.idTransaksi = idTransaksi;
    }
    
    public void addBarangDibeli(Barang barang){
        this.barangDibeli.add(barang);
    }

    public Barang getBarangDibeli(int i){
        return this.barangDibeli.get(i);
    }
    
    public long getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(long totalHarga) {
        this.totalHarga = totalHarga;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getTglTransaksi() {
        return tglTransaksi;
    }

    public void setTglTransaksi(Date tglTransaksi) {
        this.tglTransaksi = tglTransaksi;
    }
    
    
}

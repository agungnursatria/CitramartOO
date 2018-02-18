/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author Agung
 */
public class Database {
    private final String server = "jdbc:mysql://localhost:3306/impaloo";
    private final String dbuser = "root";
    private final String dbpasswd = "";
    private Statement statement = null;
    private Connection connection = null;

    public void connect() {
        try {
            connection = DriverManager.getConnection(server, dbuser, dbpasswd);
            statement = connection.createStatement();
        } catch (Exception e) {
            throw new IllegalArgumentException("terjadi kesalahan saat koneksi");
        }
    }
  
    public User verifikasilogin(String username, String password){
        try{
            String query = "select * from `admin` Where username='" + username + "' AND password='" + password + "'";
            ResultSet rs = statement.executeQuery(query);
            if(rs.next()){
                return (new Admin(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9)));
            }else{
                query = "select * from `manajer` Where username='" + username + "' AND password='" + password + "'";
                rs = statement.executeQuery(query);
                if(rs.next()){
                    return (new Manajer(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9)));
                }else{
                    query = "select * from `pegawai_gudang` Where username='" + username + "' AND password='" + password + "'";
                    rs = statement.executeQuery(query);
                    if(rs.next()){
                        return (new Pegawai_Gudang(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9)));
                    }else{
                        query = "select * from `pegawai_kasir` Where username='" + username + "' AND password='" + password + "'";
                        rs = statement.executeQuery(query);
                        if(rs.next()){
                            return (new Pegawai_Kasir(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9)));
                        }else{
                            query = "select * from `pegawai_keuangan` Where username='" + username + "' AND password='" + password + "'";
                            rs = statement.executeQuery(query);
                            if(rs.next()){
                                return (new Pegawai_Keuangan(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9)));
                            }
                        }
                    }
                }
            }
            return null;
        } catch (Exception e){
            throw new IllegalArgumentException("terjadi kesalahan saat login");
        }
    }
    
    public void ResetPassword(String passwordBaru){
        try {
            //Rubah password Manajer
            statement.executeUpdate("update `manajer` set `password`='" + passwordBaru+ "' ");
            //Rubah password Pegawai Gudang
            statement.executeUpdate("update `pegawai_gudang` set `password`='" + passwordBaru+ "' ");
            //Rubah password Kasir
            statement.executeUpdate("update `pegawai_kasir` set `password`='" + passwordBaru+ "' ");
            //Rubah password Keuangan
            statement.executeUpdate("update `pegawai_keuangan` set `password`='" + passwordBaru+ "' ");
        } catch (Exception e) {
            throw new IllegalArgumentException("terjadi kesalahan saat reset password");
        }
    }
    
    public ArrayList<User> loadUser() {
        try {
            ArrayList<User> daftarUser = new ArrayList<>();
            String query = "select * from `admin`";
            ResultSet rs = statement.executeQuery(query);
            User p;
            while (rs.next()) {
                p = new Admin(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
                daftarUser.add(p);
            }
            query = "select * from `manajer`";
            rs = statement.executeQuery(query);
            while (rs.next()) {
                p = new Manajer(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
                daftarUser.add(p);
            }
            query = "select * from `pegawai_gudang`";
            rs = statement.executeQuery(query);
            while (rs.next()) {
                p = new Pegawai_Gudang(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
                daftarUser.add(p);
            }
            query = "select * from `pegawai_kasir`";
            rs = statement.executeQuery(query);
            while (rs.next()) {
                p = new Pegawai_Kasir(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
                daftarUser.add(p);
            }
            query = "select * from `pegawai_keuangan`";
            rs = statement.executeQuery(query);
            while (rs.next()) {
                p = new Pegawai_Keuangan(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
                daftarUser.add(p);
            }
            return daftarUser;
        } catch (Exception e) {
            throw new IllegalArgumentException("terjadi kesalahan saat load user");
        }
    }
        
    public ArrayList<Barang>  loadBarang(){
        try {
            ArrayList<Barang> daftarBarang = new ArrayList<>();
            String query = "select * from `barang`";
            ResultSet rs = statement.executeQuery(query);
            Barang p;
            while (rs.next()) {
                p = new Barang(rs.getString(1),rs.getInt(2),rs.getLong(3));
                daftarBarang.add(p);
            }
            return daftarBarang;
        } catch (Exception e) {
            throw new IllegalArgumentException("terjadi kesalahan saat load barang");
        }
    }
    
    public ArrayList<Pesanan> loadPesanan(){
        try {
            ArrayList<Pesanan> daftarPesanan = new ArrayList<>();
            String query = "select * from `pesanan`";
            ResultSet rs = statement.executeQuery(query);
            Pesanan p;
            while (rs.next()) {
                String query2 = "select * from `listpesanan` Where `idPesanan`='" + rs.getString(2) + "'";
                ResultSet rs2 = statement.executeQuery(query);
                ArrayList<Barang> b = new ArrayList<>();
                while (rs2.next()){
                    b.add(new Barang(rs.getString(1),rs.getInt(2),rs.getLong(3)));
                }
                p = new Pesanan(rs.getString(2),b, rs.getString(3), rs.getLong(4),rs.getString(5),rs.getDate(6),rs.getBoolean(7));
                daftarPesanan.add(p);
            }
            return daftarPesanan;
        } catch (Exception e) {
            throw new IllegalArgumentException("terjadi kesalahan saat load pesanan");
        }
    }
    
    public ArrayList<Transaksi> loadTransaksi(){
        try {
            ArrayList<Transaksi> daftarTransaksi = new ArrayList<>();
            String query = "select * from `transaksi`";
            ResultSet rs = statement.executeQuery(query);
            Transaksi p;
            while (rs.next()) {
                ArrayList<Barang> b = searchBarangDibeli(rs.getString(2));
                p = new Transaksi(rs.getString(2),b,rs.getLong(3),rs.getString(4),rs.getDate(5));
                daftarTransaksi.add(p);
            }
            return daftarTransaksi;
        } catch (Exception e) {
            throw new IllegalArgumentException("terjadi kesalahan saat load transaksi");
        }
    }
    
    public void SaveManajer(Manajer m){
        try {
            String query = "insert into `manajer`(`nip`, `nama`, `username`, `password`, `tglLahir`, `alamat`, `email`, `NoHP`, `foto`) values "
                    + "('" + m.getNip() + "','" 
                    + m.getNama()+ "','" 
                    + m.getUsername()+ "','" 
                    + m.getPassword()+ "','" 
                    + new SimpleDateFormat("yyyy-MM-dd").format(m.getTglLahir()) + "','" 
                    + m.getAlamat()+ "','" 
                    + m.getEmail()+ "','" 
                    + m.getNoHP()+ "','" 
                    + m.getFoto() + "')";
            statement.execute(query);
        } catch (Exception e) {
            throw new IllegalArgumentException("terjadi kesalahan saat save manajer");
        }
    }
   
    public void SavePegawaiGudang(Pegawai_Gudang p){
        try {
            String query = "insert into `pegawai_gudang`(`nip`, `nama`, `username`, `password`, `tglLahir`, `alamat`, `email`, `NoHP`, `foto`) values "
                    + "('" + p.getNip() + "','" 
                    + p.getNama()+ "','" 
                    + p.getUsername()+ "','" 
                    + p.getPassword()+ "','" 
                    + new SimpleDateFormat("yyyy-MM-dd").format(p.getTglLahir()) + "','" 
                    + p.getAlamat()+ "','" 
                    + p.getEmail()+ "','" 
                    + p.getNoHP()+ "','" 
                    + p.getFoto() + "')";
            statement.execute(query);
        } catch (Exception e) {
            throw new IllegalArgumentException("terjadi kesalahan saat save pegawai gudang");
        }
    }
    
    public void SavePegawaiKasir(Pegawai_Kasir p){
        try {
            String query = "insert into `pegawai_kasir`(`nip`, `nama`, `username`, `password`, `tglLahir`, `alamat`, `email`, `NoHP`, `foto`) values "
                    + "('" + p.getNip() + "','" 
                    + p.getNama()+ "','" 
                    + p.getUsername()+ "','" 
                    + p.getPassword()+ "','" 
                    + new SimpleDateFormat("yyyy-MM-dd").format(p.getTglLahir()) + "','" 
                    + p.getAlamat()+ "','" 
                    + p.getEmail()+ "','" 
                    + p.getNoHP()+ "','" 
                    + p.getFoto() + "')";
            statement.execute(query);
        } catch (Exception e) {
            throw new IllegalArgumentException("terjadi kesalahan saat save pegawai kasir");
        }
    }
    
    public void SavePegawaiKeuangan(Pegawai_Keuangan p){
        try {
            String query = "insert into `pegawai_keuangan`(`nip`, `nama`, `username`, `password`, `tglLahir`, `alamat`, `email`, `NoHP`, `foto`) values "
                    + "('" + p.getNip() + "','" 
                    + p.getNama()+ "','" 
                    + p.getUsername()+ "','" 
                    + p.getPassword()+ "','" 
                    + new SimpleDateFormat("yyyy-MM-dd").format(p.getTglLahir()) + "','" 
                    + p.getAlamat()+ "','" 
                    + p.getEmail()+ "','" 
                    + p.getNoHP()+ "','" 
                    + p.getFoto() + "')";
            statement.execute(query);
        } catch (Exception e) {
            throw new IllegalArgumentException("terjadi kesalahan saat save Admin");
        }
    }
    
    public void SaveBarang(Barang b){
        try {
            String query = "insert into `barang`(`namaBarang`, `jumlah`, `harga`) values "
                    + "('" + b.getNamaBarang()+ "'," 
                    + b.getJumlah()+ "," 
                    + b.getHarga()+ ")";
            statement.execute(query);
        } catch (Exception e) {
            throw new IllegalArgumentException("terjadi kesalahan saat save barang");
        }
    }
    
    public void SavePesanan(Pesanan p, String nip){
        try {
            String query = "insert into `pesanan`(`nip`, `idPesanan`, `statusPesanan`, `biaya`, `keterangan`, `tglPesan`, `konfirmasi`) values "
                    + "('" + nip + "','" 
                    + p.getIdPesanan()+ "','" 
                    + p.getStatusPesanan()+ "'," 
                    + p.getBiaya()+ ",'" 
                    + p.getKeterangan()+ "'," 
                    + null + "," 
                    + p.getKonfirmasi()+ ")";
            statement.execute(query);
        } catch (Exception e) {
            throw new IllegalArgumentException("terjadi kesalahan saat save pesanan");
        }
    }
    
    public void SaveTransaksi(Transaksi t, String nip){
        try {
            String query = "insert into `transaksi`(``nip`, `idTransaksi`, `totalHarga`, `status`, `tglTransaksi`) values "
                    + "('" + nip + "','" 
                    + t.getIdTransaksi()+ "'," 
                    + t.getTotalHarga()+ ",'" 
                    + t.getStatus()+ "','" 
                    + new SimpleDateFormat("yyyy-MM-dd").format(t.getTglTransaksi()) + "')";
            statement.execute(query);
        } catch (Exception e) {
            throw new IllegalArgumentException("terjadi kesalahan saat save transaksi");
        }
    }
    
    public void SaveBarangDibeli(Transaksi t){
        try {
            int i = 0;
            while (t.getBarangDibeli(i) != null) {
                Barang b = t.getBarangDibeli(i);
                long totalHarga = b.getHarga()*b.getJumlah();
                String query = "insert into `barangdibeli`(`idTransaksi`, `namaBarang`, `jumlah`, `totalHarga`) values "
                    + "('" + t.getIdTransaksi() + "','" 
                    + b.getNamaBarang()+ "'," 
                    + b.getJumlah()+ "," 
                    + totalHarga + ")";
                statement.execute(query);
                i++;
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("terjadi kesalahan saat save barang dibeli");
        }
    }
    
    public void SaveListPesanan(Pesanan p){
        try {
            int i = 0;
            while (p.getListpesanan(i) != null) {
                Barang b = p.getListpesanan(i);
                long totalHarga = b.getHarga()*b.getJumlah();
                String query = "insert into `listpesanan`(`idPesanan`, `namaBarang`, `jumlah`, `totalHarga`) values "
                    + "('" + p.getIdPesanan()+ "','" 
                    + b.getNamaBarang()+ "'," 
                    + b.getJumlah()+ "," 
                    + totalHarga + ")";
                statement.execute(query);
                i++;
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("terjadi kesalahan saat save list pesanan");
        }
    }
    
    public void updateAdmin(Admin a) {
        try {
            String query = "update `admin` set `password`='" + a.getPassword()+ "',"
                    + "`alamat`='" + a.getAlamat()+ "',"
                    + "`NoHP`='" + a.getNoHP()+ "',"
                    + "`foto`='" + a.getFoto()+ "' "
                    + "where `nip`='" + a.getNip()+"'";
            statement.executeUpdate(query);
        } catch (Exception e) {
            throw new IllegalArgumentException("terjadi kesalahan saat update Admin");
        }
    }
    
    public void updateManajer(Manajer m) {
        try {
            String query = "update `manajer` set `password`='" + m.getPassword()+ "',"
                    + "`alamat`='" + m.getAlamat()+ "',"
                    + "`NoHP`='" + m.getNoHP()+ "',"
                    + "`foto`='" + m.getFoto()+ "' "
                    + "Where `nip`='" + m.getNip()+"'";
            statement.executeUpdate(query);
        } catch (Exception e) {
            throw new IllegalArgumentException("terjadi kesalahan saat update Manajer");
        }
    }
    
    public void updatePegawaiGudang(Pegawai_Gudang p) {
        try {
            String query = "update `pegawai_gudang` set `username`='" + p.getUsername()+ "',"
                    + "`password`='" + p.getPassword()+ "',"
                    + "`alamat`='" + p.getAlamat()+ "',"
                    + "`NoHP`='" + p.getNoHP()+ "',"
                    + "`foto`='" + p.getFoto()+ "' "
                    + "Where `nip`='" + p.getNip()+"'";
            statement.executeUpdate(query);
        } catch (Exception e) {
            throw new IllegalArgumentException("terjadi kesalahan saat update Pegawai Gudang");
        }
    }
    
    public void updatePegawaiKasir(Pegawai_Kasir p) {
        try {
            String query = "update `pegawai_kasir` set `username`='" + p.getUsername()+ "',"
                    + "`password`='" + p.getPassword()+ "',"
                    + "`alamat`='" + p.getAlamat()+ "',"
                    + "`NoHP`='" + p.getNoHP()+ "',"
                    + "`foto`='" + p.getFoto()+ "' "
                    + "Where `nip`='" + p.getNip()+"'";
            statement.executeUpdate(query);
        } catch (Exception e) {
            throw new IllegalArgumentException("terjadi kesalahan saat update Pegawai Kasir");
        }
    }
    
    public void updatePegawaiKeuangan(Pegawai_Keuangan p) {
        try {
            String query = "update `pegawai_keuangan` set `username`='" + p.getUsername()+ "',"
                    + "`password`='" + p.getPassword()+ "',"
                    + "`alamat`='" + p.getAlamat()+ "'"
                    + "`NoHP`='" + p.getNoHP()+ "',"
                    + "`foto`='" + p.getFoto()+ "' "
                    + "Where `nip`='" + p.getNip()+"'";
            statement.executeUpdate(query);
        } catch (Exception e) {
            throw new IllegalArgumentException("terjadi kesalahan saat update Pegawai Keuangan");
        }
    }
    
    public void updateBarang(Barang b){
        try {
            String query = "update `barang` set `jumlah`=" + b.getJumlah() +","
                    + "`harga`=" + b.getHarga() + " "
                    + "Where `nama`='" + b.getNamaBarang()+"'";
            statement.executeUpdate(query);
        } catch (Exception e) {
            throw new IllegalArgumentException("terjadi kesalahan saat update Pegawai Keuangan");
        }
    }
    
    public void updateKonfirmasi(Pesanan p){
        try {
            String query = "update `pesanan` set `konfirmasi`='" + p.getKonfirmasi()+"',"
                    + "Where `idPesanan`='" + p.getIdPesanan()+"'";
            statement.executeUpdate(query);
        } catch (Exception e) {
            throw new IllegalArgumentException("terjadi kesalahan saat update Pegawai Keuangan");
        }
    }
    
    public void updateStatusPesanan(Pesanan p){
        try {
            String query = "update `pesanan` set `statusPesanan`='" + p.getStatusPesanan()+"',"
                    + "Where `idPesanan`='" + p.getIdPesanan()+"'";
            statement.executeUpdate(query);
        } catch (Exception e) {
            throw new IllegalArgumentException("terjadi kesalahan saat update Pegawai Keuangan");
        }
    }
    
    public void deleteManajer(Manajer m){
        try {
            String query = "delete from `manajer` Where `nip`='" + m.getNip()+"'";
            statement.executeUpdate(query);
        } catch (Exception e) {
            throw new IllegalArgumentException("terjadi kesalahan saat delete manajer");
        }
    }
    
    public void deletePegawaiGudang(Pegawai_Gudang p){
        try {
            String query = "delete from `pegawai_gudang` Where `nip`='" + p.getNip()+"'";
            statement.executeUpdate(query);
        } catch (Exception e) {
            throw new IllegalArgumentException("terjadi kesalahan saat delete pegawai gudang");
        }
    }
    
    public void deletePegawaiKasir(Pegawai_Kasir p){
        try {
            String query = "delete from `pegawai_kasir` Where `nip`='" + p.getNip()+"'";
            statement.executeUpdate(query);
        } catch (Exception e) {
            throw new IllegalArgumentException("terjadi kesalahan saat delete pegawai kasir");
        }
    }
    
    public void deletePegawaiKeuangan(Pegawai_Keuangan p){
        try {
            String query = "delete from `pegawai_keuangan` Where `nip`='" + p.getNip()+"'";
            statement.executeUpdate(query);
        } catch (Exception e) {
            throw new IllegalArgumentException("terjadi kesalahan saat delete pegawai keuangan");
        }
    }
    
    public void deleteBarang(Barang b){
        try {
            String query = "delete from `barang` Where `namaBarang`='" + b.getNamaBarang()+"'";
            statement.executeUpdate(query);
        } catch (Exception e) {
            throw new IllegalArgumentException("terjadi kesalahan saat delete barang");
        }
    }
    
    public void deletePesanan(Pesanan p){
        try {
            String query = "delete from `pesanan` Where `idPesanan`='" + p.getIdPesanan()+"'";
            statement.executeUpdate(query);
        } catch (Exception e) {
            throw new IllegalArgumentException("terjadi kesalahan saat delete pesanan");
        }
    }
    
    public void deleteTransaksi(Transaksi t){
        try {
            String query = "delete from `transaksi` Where `idTransaksi`='" + t.getIdTransaksi()+"'";
            statement.executeUpdate(query);
        } catch (Exception e) {
            throw new IllegalArgumentException("terjadi kesalahan saat delete transaksi");
        }
    }
    
    public void deleteBarangDibeli(String idTransaksi, String namaBarang){
        try {
            String query = "delete from `barangdibeli` Where `idTransaksi`='" + idTransaksi + "' AND `namaBarang`='"+ namaBarang + "'";
            statement.executeUpdate(query);
        } catch (Exception e) {
            throw new IllegalArgumentException("terjadi kesalahan saat delete list pesanan");
        }
    }
    
    public void deleteListPesanan(String idPesanan, String namaBarang){
        try {
            String query = "delete from `listpesanan` Where `idPesanan`='" + idPesanan + "' AND `namaBarang`='"+ namaBarang + "'";
            statement.executeUpdate(query);
        } catch (Exception e) {
            throw new IllegalArgumentException("terjadi kesalahan saat delete list pesanan");
        }
    }
    
    
    public User searchUser(String nip){
        try {
            User p = null;
            String query = "select * from `admin` Where `nip`='" + nip + "'";
            ResultSet rs = statement.executeQuery(query);
            if(rs.next()){
                p = new Admin(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
            }
            else{
                query = "select * from `manajer` Where `nip`='" + nip + "'";
                rs = statement.executeQuery(query);
                if(rs.next()){
                    p = new Manajer(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
                } 
                else {
                    query = "select * from `pegawai_gudang` Where `nip`='" + nip + "'";
                    rs = statement.executeQuery(query);
                    if(rs.next()){
                        p = new Pegawai_Gudang(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
                    }
                    else{
                        query = "select * from `pegawai_kasir` Where `nip`='" + nip + "'";
                        rs = statement.executeQuery(query);
                        if(rs.next()){
                            p = new Pegawai_Kasir(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
                        }
                        else{
                            query = "select * from `pegawai_keuangan` Where `nip`='" + nip + "'";
                            rs = statement.executeQuery(query);
                            if(rs.next()){
                                p = new Pegawai_Keuangan(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
                            }
                        }
                    }
                }
            }
            return p;
        } catch (Exception e) {
            throw new IllegalArgumentException("terjadi kesalahan saat mencari user");
        }
    }
    
    public ArrayList<Pesanan> searchPesananBerdasarTglPesanan(Date tgl){
        try{
            ArrayList<Pesanan> p = new ArrayList<>();
            String query = "select * from `pesanan` Where `tglPesan`='" + tgl + "'";
            ResultSet rs = statement.executeQuery(query);
            if(rs.next()){
                String query2 = "select * from `listpesanan` Where `idPesanan`='" + rs.getString(2) + "'";
                ResultSet rs2 = statement.executeQuery(query);
                ArrayList<Barang> b = new ArrayList<>();
                while (rs2.next()){
                    b.add(new Barang(rs.getString(1),rs.getInt(2),rs.getLong(3)));
                }
                p.add(new Pesanan(rs.getString(2),b, rs.getString(3), rs.getLong(4),rs.getString(5),rs.getDate(6),rs.getBoolean(7)));
            }
            return p;
        } catch (Exception e){
            throw new IllegalArgumentException("terjadi kesalahan saat mencari pesanan berdasar tgl");
        }
    }
        
    public ArrayList<Transaksi> searchTransaksiBerdasarTglTransaksi(Date tgl){
        try{
            ArrayList<Transaksi> p = new ArrayList<>();
            String query = "select * from `transaksi` Where `tglTransaksi`='" + tgl + "'";
            ResultSet rs = statement.executeQuery(query);
            if(rs.next()){
                String query2 = "select * from `barangdibeli` Where `idTransaksi`='" + rs.getString(2) + "'";
                ResultSet rs2 = statement.executeQuery(query);
                ArrayList<Barang> b = new ArrayList<>();
                while (rs2.next()){
                    b.add(new Barang(rs.getString(1),rs.getInt(2),rs.getLong(3)));
                }
                p.add(new Transaksi(rs.getString(2),b,rs.getLong(3),rs.getString(4),rs.getDate(5)));
            }
            return p;
        } catch (Exception e){
            throw new IllegalArgumentException("terjadi kesalahan saat mencari transaksi berdasar tgl");
        }
    }
    
    public Pesanan searchPesanan(String idPesanan){
        try{
            String query = "select * from `pesanan` Where `idPesanan`='" + idPesanan + "'";
            ResultSet rs = statement.executeQuery(query);
            if(rs.next()){
                String query2 = "select * from `listpesanan` Where `idPesanan`='" + rs.getString(2) + "'";
                ResultSet rs2 = statement.executeQuery(query);
                ArrayList<Barang> b = new ArrayList<>();
                while (rs2.next()){
                    b.add(new Barang(rs.getString(1),rs.getInt(2),rs.getLong(3)));
                }
                return (new Pesanan(rs.getString(2),b, rs.getString(3), rs.getLong(4),rs.getString(5),rs.getDate(6),rs.getBoolean(7)));
            } else {
                return null;
            }
        } catch (Exception e){
            throw new IllegalArgumentException("terjadi kesalahan saat mencari pesanan");
        }
    }
    
    public Transaksi searchTransaksi(String idTransaksi){
        try{
            String query = "select * from `transaksi` Where `idTransaksi`='" + idTransaksi + "'";
            ResultSet rs = statement.executeQuery(query);
            if(rs.next()){
                ArrayList<Barang> b = searchBarangDibeli(idTransaksi);
                return (new Transaksi(rs.getString(2),b,rs.getLong(3),rs.getString(4),rs.getDate(5)));
            } else {
                return null;
            }
            
        } catch (Exception e){
            throw new IllegalArgumentException("terjadi kesalahan saat mencari pesanan");
        }
    }
    
    public Barang searchBarang(String namaBarang){
        try{
            String query = "select * from `barang` Where `namaBarang`='" + namaBarang + "'";
            ResultSet rs = statement.executeQuery(query);
            if(rs.next()){
                return (new Barang(rs.getString(1),rs.getInt(2),rs.getLong(3)));
            } else {
                return null;
            }
        } catch (Exception e){
            throw new IllegalArgumentException("terjadi kesalahan saat mencari barang");
        }
    }
    
    public String searchNIPTransaksi(String idTransaksi){
        try {
            String query = "select * from `transaksi` Where `idTransaksi`='" + idTransaksi + "'";
            ResultSet rs = statement.executeQuery(query);
            if(rs.next()){
                return rs.getString(1);
            }else{
                return null;
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("terjadi kesalahan saat mencari NIP transaksi");
        }
    }
    
    public ArrayList<Barang> searchBarangDibeli(String idTransaksi){
        try {
            String query = "select * from `barangdibeli` Where `idTransaksi`='" + idTransaksi + "'";
            ResultSet rs = statement.executeQuery(query);
            ArrayList<Barang> b = new ArrayList<>();
            while (rs.next()){
                b.add(new Barang(rs.getString(2),rs.getInt(3),rs.getLong(4)));
            }
            return b;
        } catch (Exception e) {
            throw new IllegalArgumentException("terjadi kesalahan saat mencari barang dibeli");
        }
    }
    
    public String searchNIPPesanan(String idPesanan){
        try {
            String query = "select * from `pesanan` Where `idPesanan`='" + idPesanan + "'";
            ResultSet rs = statement.executeQuery(query);
            if(rs.next()){
                return rs.getString(1);
            }else{
                return null;
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("terjadi kesalahan saat mencari NIP pesanan");
        }
    }
    
    public ArrayList<Barang> searchListPesanan(String idPesanan){
        try {
            String query = "select * from `listpesanan` Where `idPesanan`='" + idPesanan + "'";
            ResultSet rs = statement.executeQuery(query);
            ArrayList<Barang> b = new ArrayList<>();
            while (rs.next()){
                b.add(new Barang(rs.getString(2),rs.getInt(3),rs.getLong(4)));
            }
            return b;
        } catch (Exception e) {
            throw new IllegalArgumentException("terjadi kesalahan saat mencari barang dibeli");
        }
    }
}

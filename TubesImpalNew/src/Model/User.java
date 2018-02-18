package Model;


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
public class User {
    private String nip;
    private String nama;
    private String username;
    private String password;
    private Date tglLahir;
    private String alamat;
    private String email;
    private String NoHP;
    private String foto;

    public User(String nip, String nama, String username, String password, Date tglLahir, String alamat, String email, String NoHP, String foto) {
        this.nip = nip;
        this.nama = nama;
        this.username = username;
        this.password = password;
        this.tglLahir = tglLahir;
        this.alamat = alamat;
        this.email = email;
        this.NoHP = NoHP;
        this.foto = foto;
    }

    
    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getTglLahir() {
        return tglLahir;
    }

    public void setTglLahir(Date tglLahir) {
        this.tglLahir = tglLahir;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNoHP() {
        return NoHP;
    }

    public void setNoHP(String NoHP) {
        this.NoHP = NoHP;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
    
    
}

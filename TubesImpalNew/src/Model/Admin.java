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
public class Admin extends User{

    public Admin(String nip, String nama, String username, String password, Date tglLahir, String alamat, String email, String NoHP, String foto) {
        super(nip,nama,username,password,tglLahir,alamat,email,NoHP, foto);
    }
    
    public void backupDatabase(){
        
    }
    
    public void resetPassword(){
        
    }
    
    public void tambahUser(){
        
    }
    
    public void DeleteUser(){
        
    }
    
}

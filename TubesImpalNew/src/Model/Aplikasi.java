/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Agung
 */
public class Aplikasi {
    private ArrayList<User> user;
    private Database db;

    public Aplikasi() {
        this.db = new Database();
        db.connect();
        user = db.loadUser();
    }
    
    public User Login(String username,String password){
        return db.verifikasilogin(username, password);
    }
}

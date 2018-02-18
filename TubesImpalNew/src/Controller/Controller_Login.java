/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.User;
import Model.Pegawai_Keuangan;
import Model.Admin;
import Model.Database;
import Model.Pegawai_Gudang;
import Model.Manajer;
import Model.Pegawai_Kasir;
import View.LoginView;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Agung
 */
public class Controller_Login implements ActionListener{
//    private Aplikasi aplikasi;
    private LoginView login;
    private Database db = new Database();
    

    public Controller_Login() {
//        aplikasi = new Aplikasi();
        db.connect();
        login = new LoginView();
        login.addActionListener(this);
        login.setVisible(true);
        login.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../Image/ICON6.PNG")));
        login.setTitle("Citra-Mart");
    }

    public User Login(String username,String password){
        return db.verifikasilogin(username, password);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        try{
            if(source.equals(login.getLoginButton())){
                try{
                    User u = Login(login.getTxtUsername().getText().toString(), login.getTxtPassword().getText().toString());
                    if( u instanceof Admin ){
                        new Controller_Admin((Admin) u);
                        login.dispose();
                    } else if( u instanceof Manajer ){
                        new Controller_Manajer((Manajer) u);
                        login.dispose();
                    } else if( u instanceof Pegawai_Gudang ){
                        new Controller_PegawaiGudang((Pegawai_Gudang) u);
                        login.dispose();
                    } else if( u instanceof Pegawai_Kasir ){
                        new Controller_PegawaiKasir((Pegawai_Kasir) u);
                        login.dispose();
                    } else if( u instanceof Pegawai_Keuangan ){
                        new Controller_PegawaiKeuangan((Pegawai_Keuangan) u);
                        login.dispose();
                    }else{
                        login.Reset();
                        JOptionPane.showMessageDialog(login, "username atau password salah");
                    }
                }catch (Exception e){
                    login.Reset();
                    JOptionPane.showMessageDialog(login, e.getMessage());
                }
            }
        } catch (Exception e){
          JOptionPane.showMessageDialog(login, e.getMessage());
        }
    }
    
    
}

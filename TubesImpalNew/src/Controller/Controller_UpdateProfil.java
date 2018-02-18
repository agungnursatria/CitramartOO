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
import View.UpdateProfilView;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 *
 * @author User
 */
public class Controller_UpdateProfil implements ActionListener{
    private Database db = new Database();
    private UpdateProfilView update;
    private User u;
    JFileChooser chooser = new JFileChooser();
    
    public Controller_UpdateProfil(String nip){
        update = new UpdateProfilView();
        update.addActionListener(this);
        update.setVisible(true);
        update.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../Image/ICON6.PNG")));
        update.setTitle("Citra-Mart");
        db.connect();
        u = db.searchUser(nip);
        update.getTxinohp_updtprofil().setText(u.getNoHP());
        update.getTxialamat_updtprofil().setText(u.getAlamat());
        
        // Setting Foto profile
        ImageIcon icon = new ImageIcon(getClass().getResource("../Image/QMark.png"));
        if(!u.getFoto().equals("")){
            icon = new ImageIcon(getClass().getResource("../Image/"+u.getFoto()));
        }
        Image image = icon.getImage().getScaledInstance(update.getImage().getWidth(), update.getImage().getHeight(), Image.SCALE_SMOOTH);
        update.getImage().setIcon(new ImageIcon(image));
        
    }
    
    public void actionPerformed(ActionEvent ae){
        Object source = ae.getSource();
        try{
            if(source.equals(update.getBtnbatal_updtprofil())){
                update.dispose();
            }else if(source.equals(update.getBtngantifoto_updtprofil())){
                chooser = new JFileChooser(new File("D:\\Documents/Telkom Penting/Tel-U/Semester 5/Impal/TubesImpalNew/src/Image/"));
                chooser.setFileFilter(new FileNameExtensionFilter("PNG images","png","jpg","jpeg"));
                int returnVal = chooser.showOpenDialog(update);
                if(returnVal == JFileChooser.APPROVE_OPTION) {
                    try {
                        //Update Foto pada database
                        u.setFoto(u.getNama()+".png");
                        if(u instanceof Admin){
                            db.updateAdmin((Admin) u);
                        }else if (u instanceof Manajer){
                            db.updateManajer((Manajer) u);
                        }else if (u instanceof Pegawai_Gudang){
                            db.updatePegawaiGudang((Pegawai_Gudang) u);
                        }else if (u instanceof Pegawai_Kasir){
                            db.updatePegawaiKasir((Pegawai_Kasir) u);
                        }else if (u instanceof Pegawai_Keuangan){
                            db.updatePegawaiKeuangan((Pegawai_Keuangan) u);
                        }
                        //Save Photo Profile
                        BufferedImage UploadedPicture = ImageIO.read(chooser.getSelectedFile());
                        ImageIO.write(UploadedPicture,"png",new File("D:\\Documents/Telkom Penting/Tel-U/Semester 5/Impal/TubesImpalNew/src/Image/"+u.getFoto()));
                        
                        TimeUnit.SECONDS.sleep(2);
                        // Set Phooto profile
                        ImageIcon icon = new ImageIcon(getClass().getResource("../Image/"+u.getFoto()));
                        Image image = icon.getImage().getScaledInstance(update.getImage().getWidth(), update.getImage().getHeight(), Image.SCALE_SMOOTH);
                        update.getImage().setIcon(new ImageIcon(image));
                        JOptionPane.showMessageDialog(update, "Upload image has been successful!");
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(update, "Failed to upload image!");
                    }
                }else{
                    JOptionPane.showMessageDialog(update, "No file chosen!");
                }
            }else if(source.equals(update.getBtnok_updtprofil())){
                if(update.getTxipasslama_updtprofil().toString() == u.getPassword() && update.getTxipassbaru_updtprofil().toString() != ""){
                    u.setPassword(update.getTxipassbaru_updtprofil().toString()); 
                }
                if(isNumeric(update.getTxinohp_updtprofil().getText().toString())){
                    u.setNoHP(update.getTxinohp_updtprofil().getText().toString());
                }
                u.setAlamat(update.getTxialamat_updtprofil().getText().toString());
                if(u instanceof Admin){
                    db.updateAdmin((Admin) u);
                }else if(u instanceof Manajer){
                    db.updateManajer((Manajer) u);
                } else if (u instanceof Pegawai_Gudang){
                    db.updatePegawaiGudang((Pegawai_Gudang) u);
                } else if (u instanceof Pegawai_Kasir){
                    db.updatePegawaiKasir((Pegawai_Kasir) u);
                } else if (u instanceof Pegawai_Keuangan){
                    db.updatePegawaiKeuangan((Pegawai_Keuangan) u);
                }
                update.dispose();
            }else if(source.equals(update.getBtnresetpass_updtprofil())){
                JPanel panel = new JPanel();
                panel.add(new JLabel("Masukkan password baru:"));
                JTextField textf = new JTextField("",20);
                panel.add(textf);

                int result = JOptionPane.showConfirmDialog(null, panel, "Reset Password", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                switch (result) {
                    case JOptionPane.OK_OPTION:
                        db.ResetPassword(textf.getText().toString());
                        break;
                }

            }
        }catch (Exception e){
          JOptionPane.showMessageDialog(update, e.getMessage());
        }
    }
    
    public static boolean isNumeric(String str) {
        for (char c : str.toCharArray()){
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }
}

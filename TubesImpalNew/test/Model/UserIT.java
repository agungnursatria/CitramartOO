/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Agung
 */
public class UserIT {
    
    public UserIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getNip method, of class User.
     */
    @Test
    public void testGetNip() {
        System.out.println("getNip");
        User instance = new User("","","","",null,"","","","");
        String expResult = "";
        String result = instance.getNip();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setNip method, of class User.
     */
    @Test
    public void testSetNip() {
        System.out.println("setNip");
        String nip = "";
        User instance = new User("","","","",null,"","","","");
        instance.setNip(nip);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getNama method, of class User.
     */
    @Test
    public void testGetNama() {
        System.out.println("getNama");
        User instance = new User("","","","",null,"","","","");
        String expResult = "";
        String result = instance.getNama();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setNama method, of class User.
     */
    @Test
    public void testSetNama() {
        System.out.println("setNama");
        String nama = "";
        User instance = new User("","","","",null,"","","","");
        instance.setNama(nama);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getUsername method, of class User.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        User instance = new User("","","","",null,"","","","");
        String expResult = "";
        String result = instance.getUsername();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setUsername method, of class User.
     */
    @Test
    public void testSetUsername() {
        System.out.println("setUsername");
        String username = "";
        User instance = new User("","","","",null,"","","","");
        instance.setUsername(username);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getPassword method, of class User.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        User instance = new User("","","","",null,"","","","");
        String expResult = "";
        String result = instance.getPassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setPassword method, of class User.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "";
        User instance = new User("","","","",null,"","","","");
        instance.setPassword(password);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getTglLahir method, of class User.
     */
    @Test
    public void testGetTglLahir() {
        System.out.println("getTglLahir");
        User instance = new User("","","","",null,"","","","");
        Date expResult = null;
        Date result = instance.getTglLahir();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setTglLahir method, of class User.
     */
    @Test
    public void testSetTglLahir() {
        System.out.println("setTglLahir");
        Date tglLahir = null;
        User instance = new User("","","","",null,"","","","");
        instance.setTglLahir(tglLahir);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getAlamat method, of class User.
     */
    @Test
    public void testGetAlamat() {
        System.out.println("getAlamat");
        User instance = new User("","","","",null,"","","","");
        String expResult = "";
        String result = instance.getAlamat();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setAlamat method, of class User.
     */
    @Test
    public void testSetAlamat() {
        System.out.println("setAlamat");
        String alamat = "";
        User instance = new User("","","","",null,"","","","");
        instance.setAlamat(alamat);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getEmail method, of class User.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        User instance = new User("","","","",null,"","","","");
        String expResult = "";
        String result = instance.getEmail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setEmail method, of class User.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "";
        User instance = new User("","","","",null,"","","","");
        instance.setEmail(email);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getNoHP method, of class User.
     */
    @Test
    public void testGetNoHP() {
        System.out.println("getNoHP");
        User instance = new User("","","","",null,"","","","");
        String expResult = "";
        String result = instance.getNoHP();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setNoHP method, of class User.
     */
    @Test
    public void testSetNoHP() {
        System.out.println("setNoHP");
        String NoHP = "";
        User instance = new User("","","","",null,"","","","");
        instance.setNoHP(NoHP);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getFoto method, of class User.
     */
    @Test
    public void testGetFoto() {
        System.out.println("getFoto");
        User instance = new User("","","","",null,"","","","");
        String expResult = "";
        String result = instance.getFoto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setFoto method, of class User.
     */
    @Test
    public void testSetFoto() {
        System.out.println("setFoto");
        String foto = "";
        User instance = new User("","","","",null,"","","","");
        instance.setFoto(foto);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}

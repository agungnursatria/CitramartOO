/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

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
public class AdminIT {
    
    public AdminIT() {
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
     * Test of backupDatabase method, of class Admin.
     */
    @Test
    public void testBackupDatabase() {
        System.out.println("backupDatabase");
        Admin instance = new Admin("","","","",null,"","","","");
        instance.backupDatabase();
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of resetPassword method, of class Admin.
     */
    @Test
    public void testResetPassword() {
        System.out.println("resetPassword");
        Admin instance = new Admin("","","","",null,"","","","");
        instance.resetPassword();
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of tambahUser method, of class Admin.
     */
    @Test
    public void testTambahUser() {
        System.out.println("tambahUser");
        Admin instance = new Admin("","","","",null,"","","","");
        instance.tambahUser();
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of DeleteUser method, of class Admin.
     */
    @Test
    public void testDeleteUser() {
        System.out.println("DeleteUser");
        Admin instance = new Admin("","","","",null,"","","","");
        instance.DeleteUser();
        // TODO review the generated test code and remove the default call to fail.
    }
    
}

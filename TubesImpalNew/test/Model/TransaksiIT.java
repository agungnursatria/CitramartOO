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
public class TransaksiIT {
    
    public TransaksiIT() {
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
     * Test of getIdTransaksi method, of class Transaksi.
     */
    @Test
    public void testGetIdTransaksi() {
        System.out.println("getIdTransaksi");
        Transaksi instance = new Transaksi("", null, 0, "", null);
        String expResult = "";
        String result = instance.getIdTransaksi();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setIdTransaksi method, of class Transaksi.
     */
    @Test
    public void testSetIdTransaksi() {
        System.out.println("setIdTransaksi");
        String idTransaksi = "";
        Transaksi instance = new Transaksi("", null, 0, "", null);
        instance.setIdTransaksi(idTransaksi);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of addBarangDibeli method, of class Transaksi.
     */
    @Test
    public void testAddBarangDibeli() {
        System.out.println("addBarangDibeli");
        Barang barang = null;
        Transaksi instance = new Transaksi("", null, 0, "", null);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getBarangDibeli method, of class Transaksi.
     */
    @Test
    public void testGetBarangDibeli() {
        System.out.println("getBarangDibeli");
        int i = 0;
        Transaksi instance = new Transaksi("", null, 0, "", null);
        Barang expResult = null;
        Barang result = null;
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getTotalHarga method, of class Transaksi.
     */
    @Test
    public void testGetTotalHarga() {
        System.out.println("getTotalHarga");
        Transaksi instance = new Transaksi("", null, 0, "", null);
        long expResult = 0;
        long result = instance.getTotalHarga();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setTotalHarga method, of class Transaksi.
     */
    @Test
    public void testSetTotalHarga() {
        System.out.println("setTotalHarga");
        long totalHarga = 0;
        Transaksi instance = new Transaksi("", null, 0, "", null);
        instance.setTotalHarga(totalHarga);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getStatus method, of class Transaksi.
     */
    @Test
    public void testGetStatus() {
        System.out.println("getStatus");
        Transaksi instance = new Transaksi("", null, 0, "", null);
        String expResult = "";
        String result = instance.getStatus();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setStatus method, of class Transaksi.
     */
    @Test
    public void testSetStatus() {
        System.out.println("setStatus");
        String status = "";
        Transaksi instance = new Transaksi("", null, 0, "", null);
        instance.setStatus(status);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getTglTransaksi method, of class Transaksi.
     */
    @Test
    public void testGetTglTransaksi() {
        System.out.println("getTglTransaksi");
        Transaksi instance = new Transaksi("", null, 0, "", null);
        Date expResult = null;
        Date result = instance.getTglTransaksi();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setTglTransaksi method, of class Transaksi.
     */
    @Test
    public void testSetTglTransaksi() {
        System.out.println("setTglTransaksi");
        Date tglTransaksi = null;
        Transaksi instance = new Transaksi("", null, 0, "", null);
        instance.setTglTransaksi(tglTransaksi);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}

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
public class BarangIT {
    
    public BarangIT() {
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
     * Test of getNamaBarang method, of class Barang.
     */
    @Test
    public void testGetNamaBarang() {
        System.out.println("getNamaBarang");
        Barang instance = new Barang("",0,0);
        String expResult = "";
        String result = instance.getNamaBarang();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setNamaBarang method, of class Barang.
     */
    @Test
    public void testSetNamaBarang() {
        System.out.println("setNamaBarang");
        String namaBarang = "";
        Barang instance = new Barang("",0,0);
        instance.setNamaBarang(namaBarang);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getJumlah method, of class Barang.
     */
    @Test
    public void testGetJumlah() {
        System.out.println("getJumlah");
        Barang instance = new Barang("",0,0);
        int expResult = 0;
        int result = instance.getJumlah();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setJumlah method, of class Barang.
     */
    @Test
    public void testSetJumlah() {
        System.out.println("setJumlah");
        int jumlah = 0;
        Barang instance = new Barang("",0,0);
        instance.setJumlah(jumlah);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getHarga method, of class Barang.
     */
    @Test
    public void testGetHarga() {
        System.out.println("getHarga");
        Barang instance = new Barang("",0,0);
        long expResult = 0;
        long result = instance.getHarga();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setHarga method, of class Barang.
     */
    @Test
    public void testSetHarga() {
        System.out.println("setHarga");
        long harga = 0;
        Barang instance = new Barang("",0,0);
        instance.setHarga(harga);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}

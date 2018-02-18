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
public class PesananIT {
    
    public PesananIT() {
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
     * Test of getIdPesanan method, of class Pesanan.
     */
    @Test
    public void testGetIdPesanan() {
        System.out.println("getIdPesanan");
        Pesanan instance = new Pesanan("", null, "", 0, "", null, false);
        String expResult = "";
        String result = instance.getIdPesanan();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setIdPesanan method, of class Pesanan.
     */
    @Test
    public void testSetIdPesanan() {
        System.out.println("setIdPesanan");
        String idPesanan = "";
        Pesanan instance = new Pesanan("", null, "", 0, "", null, false);
        instance.setIdPesanan(idPesanan);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getListpesanan method, of class Pesanan.
     */
    @Test
    public void testGetListpesanan() {
        System.out.println("getListpesanan");
        int i = 0;
        Pesanan instance = new Pesanan("", null, "", 0, "", null, false);
        Barang expResult = null;
        Barang result = instance.getListpesanan(i);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setListpesanan method, of class Pesanan.
     */
    @Test
    public void testaddListpesanan() {
        System.out.println("setListpesanan");
        Barang listpesanan = null;
        Pesanan instance = new Pesanan("", null, "", 0, "", null, false);
        instance.addListpesanan(listpesanan);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getBiaya method, of class Pesanan.
     */
    @Test
    public void testGetBiaya() {
        System.out.println("getBiaya");
        Pesanan instance = new Pesanan("", null, "", 0, "", null, false);
        long expResult = 0;
        long result = instance.getBiaya();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setBiaya method, of class Pesanan.
     */
    @Test
    public void testSetBiaya() {
        System.out.println("setBiaya");
        long biaya = 0;
        Pesanan instance = new Pesanan("", null, "", 0, "", null, false);
        instance.setBiaya(biaya);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getKeterangan method, of class Pesanan.
     */
    @Test
    public void testGetKeterangan() {
        System.out.println("getKeterangan");
        Pesanan instance = new Pesanan("", null, "", 0, "", null, false);
        String expResult = "";
        String result = instance.getKeterangan();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setKeterangan method, of class Pesanan.
     */
    @Test
    public void testSetKeterangan() {
        System.out.println("setKeterangan");
        String keterangan = "";
        Pesanan instance = new Pesanan("", null, "", 0, "", null, false);
        instance.setKeterangan(keterangan);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getTglPesan method, of class Pesanan.
     */
    @Test
    public void testGetTglPesan() {
        System.out.println("getTglPesan");
        Pesanan instance = new Pesanan("", null, "", 0, "", null, false);
        Date expResult = null;
        Date result = instance.getTglPesan();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setTglPesan method, of class Pesanan.
     */
    @Test
    public void testSetTglPesan() {
        System.out.println("setTglPesan");
        Date tglPesan = null;
        Pesanan instance = new Pesanan("", null, "", 0, "", null, false);
        instance.setTglPesan(tglPesan);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of isKonfirmasi method, of class Pesanan.
     */
    @Test
    public void testIsKonfirmasi() {
        System.out.println("isKonfirmasi");
        Pesanan instance = new Pesanan("", null, "", 0, "", null, false);
        boolean expResult = false;
        boolean result = instance.isKonfirmasi();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setKonfirmasi method, of class Pesanan.
     */
    @Test
    public void testSetKonfirmasi() {
        System.out.println("setKonfirmasi");
        boolean konfirmasi = false;
        Pesanan instance = new Pesanan("", null, "", 0, "", null, false);
        instance.setKonfirmasi(konfirmasi);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getKonfirmasi method, of class Pesanan.
     */
    @Test
    public void testGetKonfirmasi() {
        System.out.println("getKonfirmasi");
        Pesanan instance = new Pesanan("", null, "", 0, "", null, false);
        boolean expResult = false;
        boolean result = instance.getKonfirmasi();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    
}

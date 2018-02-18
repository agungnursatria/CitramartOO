/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
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
public class Pegawai_GudangIT {
    
    public Pegawai_GudangIT() {
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
     * Test of InputPesanan method, of class Pegawai_Gudang.
     */
    @Test
    public void testInputPesanan() {
        System.out.println("InputPesanan");
        String idPesanan = "";
        ArrayList<Barang> listpesanan = null;
        String statusPesanan = "";
        long biaya = 0L;
        String keterangan = "";
        Date tglPesan = null;
        boolean konfirmasi = false;
        Pegawai_Gudang instance = new Pegawai_Gudang("","","","",null,"","","","");
        instance.InputPesanan(idPesanan, listpesanan,statusPesanan, biaya, keterangan, tglPesan, konfirmasi);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of InputBarang method, of class Pegawai_Gudang.
     */
    @Test
    public void testInputBarang() {
        System.out.println("InputBarang");
        Barang barang = null;
        Pegawai_Gudang instance = new Pegawai_Gudang("","","","",null,"","","","");
        instance.InputBarang(barang);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of BacaDataStok method, of class Pegawai_Gudang.
     */
    @Test
    public void testBacaDataStok() {
        System.out.println("BacaDataStok");
        Barang barang = null;
        Pegawai_Gudang instance = new Pegawai_Gudang("","","","",null,"","","","");
//        instance.BacaDataStok(barang);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of BacaKonfirmasi method, of class Pegawai_Gudang.
     */
    @Test
    public void testBacaKonfirmasi() {
        System.out.println("BacaKonfirmasi");
        Pesanan pesanan = new Pesanan("", null,"", 0, "", null, false);
        Pegawai_Gudang instance = new Pegawai_Gudang("","","","",null,"","","","");
        boolean expResult = false;
//        boolean result = instance.BacaKonfirmasi(pesanan);
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}

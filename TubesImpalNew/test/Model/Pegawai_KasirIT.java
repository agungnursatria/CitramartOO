/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.time.Instant;
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
public class Pegawai_KasirIT {
    
    public Pegawai_KasirIT() {
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
     * Test of InputTransaksi method, of class Pegawai_Kasir.
     */
    @Test
    public void testInputTransaksi() {
        System.out.println("InputTransaksi");
        String idTransaksi = "1";
        ArrayList<Barang> barangDibeli = new ArrayList<Barang>();
        barangDibeli.add(new Barang("Pepsodent",2,8000));
        long totalHarga = 16000;
        String status = "lunas";
        Date tglTransaksi = Date.from(Instant.now());
        Pegawai_Kasir instance = new Pegawai_Kasir("1","Agung","agung","agung",Date.from(Instant.now()),"telkom","agung@test.com","14045","foto.jpg");
        boolean expResult = false;
        boolean result;
        instance.InputTransaksi(idTransaksi, barangDibeli, totalHarga, status, tglTransaksi);
        if(instance.transaksi.get(0)==null){
            result = false;
        }else
        {
            result = true;
        }
        assertEquals(expResult, result);
    }

    /**
     * Test of catatPiutang method, of class Pegawai_Kasir.
     */
//    @Test
//    public void testCatatPiutang() {
//        System.out.println("catatPiutang");
//        Pegawai_Kasir instance = new Pegawai_Kasir("","","","",null,"","","","");
//        instance.catatPiutang();
//        // TODO review the generated test code and remove the default call to fail.
//    }
    
}

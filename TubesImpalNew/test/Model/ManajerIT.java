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
public class ManajerIT {
    
    public ManajerIT() {
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
     * Test of InputKonfirmasi method, of class Manajer.
     */
    @Test
    public void testInputKonfirmasi() {
        System.out.println("InputKonfirmasi");
        Manajer instance = new Manajer("","","","",null,"","","","");
        instance.InputKonfirmasi();
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of BacaLaporanRugiLaba method, of class Manajer.
     */
    @Test
    public void testBacaLaporanRugiLaba() {
        System.out.println("BacaLaporanRugiLaba");
        Manajer instance = new Manajer("","","","",null,"","","","");
        instance.BacaLaporanRugiLaba();
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of BacaLaporanHutangPiutang method, of class Manajer.
     */
    @Test
    public void testBacaLaporanHutangPiutang() {
        System.out.println("BacaLaporanHutangPiutang");
        Manajer instance = new Manajer("","","","",null,"","","","");
        instance.BacaLaporanHutangPiutang();
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of BacaJurnalKeuangan method, of class Manajer.
     */
    @Test
    public void testBacaJurnalKeuangan() {
        System.out.println("BacaJurnalKeuangan");
        Manajer instance = new Manajer("","","","",null,"","","","");
        instance.BacaJurnalKeuangan();
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of BacaDataPesanan method, of class Manajer.
     */
    @Test
    public void testBacaDataPesanan() {
        System.out.println("BacaDataPesanan");
        Manajer instance = new Manajer("","","","",null,"","","","");
        instance.BacaDataPesanan();
        // TODO review the generated test code and remove the default call to fail.
    }
    
}

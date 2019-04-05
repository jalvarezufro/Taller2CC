/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import taller2.Taller2;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author JAVIER
 */
public class testTaller2 {

    @Test
    public void testdecToFloat() {

        assertEquals("0100110000000000", Taller2.decToFloat(16));
        assertEquals("0100110011000000", Taller2.decToFloat(19));
        assertEquals("1110100001100000", Taller2.decToFloat(-2240));

    }
    @Test
    public void testfloatToDec(){
        
        assertEquals(1800, Taller2.floatToDec("0110011100001000"),0);
        assertEquals(32000, Taller2.floatToDec("0111011111010000"),0);
        assertEquals(-15433, Taller2.floatToDec("1111001110001001"),1);
    }

}

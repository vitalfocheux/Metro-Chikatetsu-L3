package fr.ufc.l3info.oprog;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestBaseTicket {

    ITicket b1, b2, b3, b4, b5, b6;

    @Before
    public void setup(){
        b1 = new BaseTicket(false, 0);
        b2 = new BaseTicket(false, -1);
        b3 = new BaseTicket(false, 10);
        b4 = new BaseTicket(true, 0);
        b5 = new BaseTicket(true, -1);
        b6 = new BaseTicket(true, 10);
    }

    @Test
    public void isChildNotChild0Amount(){
        Assert.assertFalse(b1.isChild());
        Assert.assertEquals(b1.getAmount(), 0);
    }

    @Test
    /*
    *   Je m'attendais à ce que la valeur de b2.getAmount() renvoie 0 car l'initialisation avec le constructeur
    *   car la somme est négative sauf que cela renvoie la somme négative
    */
    public void isChildNotChildNegativeAmount_KO(){
        Assert.assertFalse(b2.isChild());
        Assert.assertEquals(b2.getAmount(), 0);
    }

    @Test
    public void isChildNotChildPositiveAmount(){
        Assert.assertFalse(b3.isChild());
        Assert.assertEquals(b3.getAmount(), 10);
    }

    @Test
    public void isChildChild0Amount(){
        Assert.assertTrue(b4.isChild());
        Assert.assertEquals(b4.getAmount(), 0);
    }

    @Test
    /*
     *   Je m'attendais à ce que la valeur de b5.getAmount() renvoie 0 car l'initialisation avec le constructeur
     *   car la somme est négative sauf que cela renvoie la somme négative
     */
    public void isChildChildNegativeAmount_KO(){
        Assert.assertTrue(b5.isChild());
        Assert.assertEquals(b5.getAmount(), 0);
    }

    @Test
    public void isChildChildPostiveAmount(){
        Assert.assertTrue(b6.isChild());
        Assert.assertEquals(b6.getAmount(), 10);
    }

    @Test
    public void enteringNullB1(){
        Assert.assertFalse(b1.entering(null));
        Assert.assertNull(b1.getEntryStation());
        Assert.assertEquals(b1.getAmount(), 0);
        Assert.assertFalse(b1.isChild());
        Assert.assertFalse(b1.isValid());
    }

    @Test
    /*
    Etant donné que le constructeur avec un montant négative initialise à la valeur négative et non à 0
     */
    public void enteringNullB2_KO(){
        Assert.assertFalse(b2.entering(null));
        Assert.assertNull(b2.getEntryStation());
        Assert.assertEquals(b2.getAmount(), 0);
        Assert.assertFalse(b2.isChild());
        Assert.assertFalse(b2.isValid());
    }

    @Test
    public void enteringNullB3(){
        Assert.assertFalse(b3.entering(null));
        Assert.assertNull(b3.getEntryStation());
        Assert.assertEquals(b3.getAmount(), 10);
        Assert.assertFalse(b3.isChild());
        Assert.assertFalse(b3.isValid());
    }

    @Test
    public void enteringNullB4(){
        Assert.assertFalse(b4.entering(null));
        Assert.assertNull(b4.getEntryStation());
        Assert.assertEquals(b4.getAmount(), 0);
        Assert.assertTrue(b4.isChild());
        Assert.assertFalse(b4.isValid());
    }

    @Test
    /*
    Etant donné que le constructeur avec un montant négative initialise à la valeur négative et non à 0
     */
    public void enteringNullB5_KO(){
        Assert.assertFalse(b5.entering(null));
        Assert.assertNull(b5.getEntryStation());
        Assert.assertEquals(b5.getAmount(), 0);
        Assert.assertTrue(b5.isChild());
        Assert.assertFalse(b5.isValid());
    }

    @Test
    public void enteringNullB6(){
        Assert.assertFalse(b6.entering(null));
        Assert.assertNull(b6.getEntryStation());
        Assert.assertEquals(b6.getAmount(), 10);
        Assert.assertTrue(b6.isChild());
        Assert.assertFalse(b6.isValid());
    }

    @Test
    public void enteringTrimB1(){
        Assert.assertFalse(b1.entering("   "));
        Assert.assertNull(b1.getEntryStation());
        Assert.assertEquals(b1.getAmount(), 0);
        Assert.assertFalse(b1.isChild());
        Assert.assertFalse(b1.isValid());
    }

    @Test
    /*
    Etant donné que le constructeur avec un montant négative initialise à la valeur négative et non à 0
     */
    public void enteringTrimB2_KO(){
        Assert.assertFalse(b2.entering("   "));
        Assert.assertNull(b2.getEntryStation());
        Assert.assertEquals(b2.getAmount(), 0);
        Assert.assertFalse(b2.isChild());
        Assert.assertFalse(b2.isValid());
    }

    @Test
    public void enteringTrimB3(){
        Assert.assertFalse(b3.entering("                "));
        Assert.assertNull(b3.getEntryStation());
        Assert.assertEquals(b3.getAmount(), 10);
        Assert.assertFalse(b3.isChild());
        Assert.assertFalse(b3.isValid());
    }

    @Test
    public void enteringTrimB4(){
        Assert.assertFalse(b4.entering("    "));
        Assert.assertNull(b4.getEntryStation());
        Assert.assertEquals(b4.getAmount(), 0);
        Assert.assertTrue(b4.isChild());
        Assert.assertFalse(b4.isValid());
    }

    @Test
    /*
    Etant donné que le constructeur avec un montant négative initialise à la valeur négative et non à 0
     */
    public void enteringTrimB5_KO(){
        Assert.assertFalse(b5.entering("    "));
        Assert.assertNull(b5.getEntryStation());
        Assert.assertEquals(b5.getAmount(), 0);
        Assert.assertTrue(b5.isChild());
        Assert.assertFalse(b5.isValid());
    }

    @Test
    public void enteringTrimB6(){
        Assert.assertFalse(b6.entering("   "));
        Assert.assertNull(b6.getEntryStation());
        Assert.assertEquals(b6.getAmount(), 10);
        Assert.assertTrue(b6.isChild());
        Assert.assertFalse(b6.isValid());
    }

    @Test
    public void enteringNoStringB1(){
        Assert.assertFalse(b1.entering(""));
        Assert.assertNull(b1.getEntryStation());
        Assert.assertEquals(b1.getAmount(), 0);
        Assert.assertFalse(b1.isChild());
        Assert.assertFalse(b1.isValid());
    }

    @Test
    /*
    Etant donné que le constructeur avec un montant négative initialise à la valeur négative et non à 0
     */
    public void enteringNoStringB2_KO(){
        Assert.assertFalse(b2.entering(""));
        Assert.assertNull(b2.getEntryStation());
        Assert.assertEquals(b2.getAmount(), 0);
        Assert.assertFalse(b2.isChild());
        Assert.assertFalse(b2.isValid());
    }

    @Test
    public void enteringNoStringB3(){
        Assert.assertFalse(b3.entering(""));
        Assert.assertNull(b3.getEntryStation());
        Assert.assertEquals(b3.getAmount(), 10);
        Assert.assertFalse(b3.isChild());
        Assert.assertFalse(b3.isValid());
    }

    @Test
    public void enteringNoStringB4(){
        Assert.assertFalse(b4.entering(""));
        Assert.assertNull(b4.getEntryStation());
        Assert.assertEquals(b4.getAmount(), 0);
        Assert.assertTrue(b4.isChild());
        Assert.assertFalse(b4.isValid());
    }

    @Test
    /*
    Etant donné que le constructeur avec un montant négative initialise à la valeur négative et non à 0
     */
    public void enteringNoStringB5_KO(){
        Assert.assertFalse(b5.entering(""));
        Assert.assertNull(b5.getEntryStation());
        Assert.assertEquals(b5.getAmount(), 0);
        Assert.assertTrue(b5.isChild());
        Assert.assertFalse(b5.isValid());
    }

    @Test
    public void enteringNoStringB6(){
        Assert.assertFalse(b6.entering(""));
        Assert.assertNull(b6.getEntryStation());
        Assert.assertEquals(b6.getAmount(), 10);
        Assert.assertTrue(b6.isChild());
        Assert.assertFalse(b6.isValid());
    }

    @Test
    public void enteringSuccesB1(){
        Assert.assertTrue(b1.entering("Station 1"));
        Assert.assertEquals(b1.getEntryStation(), "Station 1");
        Assert.assertEquals(b1.getAmount(), 0);
        Assert.assertFalse(b1.isChild());
        Assert.assertTrue(b1.isValid());
    }

    @Test
    /*
    Etant donné que le constructeur avec un montant négative initialise à la valeur négative et non à 0
     */
    public void enteringSuccesB2_KO(){
        Assert.assertTrue(b2.entering("Station 1"));
        Assert.assertEquals(b2.getEntryStation(), "Station 1");
        Assert.assertEquals(b2.getAmount(), 0);
        Assert.assertFalse(b2.isChild());
        Assert.assertTrue(b2.isValid());
    }

    @Test
    public void enteringSuccesB3(){
        Assert.assertTrue(b3.entering("Station 1"));
        Assert.assertEquals(b3.getEntryStation(), "Station 1");
        Assert.assertEquals(b3.getAmount(), 10);
        Assert.assertFalse(b3.isChild());
        Assert.assertTrue(b3.isValid());
    }

    @Test
    public void enteringSuccesB4(){
        Assert.assertTrue(b4.entering("Station 1"));
        Assert.assertEquals(b4.getEntryStation(), "Station 1");
        Assert.assertEquals(b4.getAmount(), 0);
        Assert.assertTrue(b4.isChild());
        Assert.assertTrue(b4.isValid());
    }

    @Test
    /*
    Etant donné que le constructeur avec un montant négative initialise à la valeur négative et non à 0
     */
    public void enteringSuccesB5_KO(){
        Assert.assertTrue(b5.entering("Station 1"));
        Assert.assertEquals(b5.getEntryStation(), "Station 1");
        Assert.assertEquals(b5.getAmount(), 0);
        Assert.assertTrue(b5.isChild());
        Assert.assertTrue(b5.isValid());
    }

    @Test
    public void enteringSuccesB6(){
        Assert.assertTrue(b6.entering("Station 1"));
        Assert.assertEquals(b6.getEntryStation(), "Station 1");
        Assert.assertEquals(b6.getAmount(), 10);
        Assert.assertTrue(b6.isChild());
        Assert.assertTrue(b6.isValid());
    }

    @Test
    public void enteringENTEREDB1(){
        Assert.assertTrue(b1.entering("S1"));
        Assert.assertFalse(b1.entering(""));
        Assert.assertNull(b1.getEntryStation());
        Assert.assertEquals(b1.getAmount(), 0);
        Assert.assertFalse(b1.isChild());
        Assert.assertFalse(b1.isValid());
    }

    @Test
    /*
    Etant donné que le constructeur avec un montant négative initialise à la valeur négative et non à 0
     */
    public void enteringENTEREDB2_KO(){
        Assert.assertTrue(b2.entering("S1"));
        Assert.assertFalse(b2.entering(""));
        Assert.assertNull(b2.getEntryStation());
        Assert.assertEquals(b2.getAmount(), 0);
        Assert.assertFalse(b2.isChild());
        Assert.assertFalse(b2.isValid());
    }

    @Test
    public void enteringENTEREDB3(){
        Assert.assertTrue(b3.entering("S1"));
        Assert.assertFalse(b3.entering(""));
        Assert.assertNull(b3.getEntryStation());
        Assert.assertEquals(b3.getAmount(), 10);
        Assert.assertFalse(b3.isChild());
        Assert.assertFalse(b3.isValid());
    }

    @Test
    public void enteringENTEREDB4(){
        Assert.assertTrue(b4.entering("S1"));
        Assert.assertFalse(b4.entering(""));
        Assert.assertNull(b4.getEntryStation());
        Assert.assertEquals(b4.getAmount(), 0);
        Assert.assertTrue(b4.isChild());
        Assert.assertFalse(b4.isValid());
    }

    @Test
    /*
    Etant donné que le constructeur avec un montant négative initialise à la valeur négative et non à 0
     */
    public void enteringENTEREDB5_KO(){
        Assert.assertTrue(b5.entering("S1"));
        Assert.assertFalse(b5.entering(""));
        Assert.assertNull(b5.getEntryStation());
        Assert.assertEquals(b5.getAmount(), 0);
        Assert.assertTrue(b5.isChild());
        Assert.assertFalse(b5.isValid());
    }

    @Test
    public void enteringENTEREDB6(){
        Assert.assertTrue(b6.entering("S1"));
        Assert.assertFalse(b6.entering(""));
        Assert.assertNull(b6.getEntryStation());
        Assert.assertEquals(b6.getAmount(), 10);
        Assert.assertTrue(b6.isChild());
        Assert.assertFalse(b6.isValid());
    }
/*
    @Test
    public void enteringSuccesWithTrimB1(){
        Assert.assertTrue(b1.entering("Station 1    "));
        Assert.assertEquals(b1.getEntryStation(), "Station 1");
    }

    @Test
    public void enteringSuccesWithTrimB2(){
        Assert.assertTrue(b2.entering("Station 1    "));
        Assert.assertEquals(b2.getEntryStation(), "Station 1");
    }

    @Test
    public void enteringSuccesWithTrimB3(){
        Assert.assertTrue(b3.entering("Station 1    "));
        Assert.assertEquals(b3.getEntryStation(), "Station 1");
    }

    @Test
    public void enteringSuccesWithTrimB4(){
        Assert.assertTrue(b4.entering("Station 1    "));
        Assert.assertEquals(b4.getEntryStation(), "Station 1");
    }

    @Test
    public void enteringSuccesWithTrimB5(){
        Assert.assertTrue(b5.entering("Station 1    "));
        Assert.assertEquals(b5.getEntryStation(), "Station 1");
    }

    @Test
    public void enteringSuccesWithTrimB6(){
        Assert.assertTrue(b6.entering("Station 1    "));
        Assert.assertEquals(b6.getEntryStation(), "Station 1");
    }*/

    @Test
    public void invalidateB1(){
        b1.invalidate();
        Assert.assertFalse(b1.isValid());
        Assert.assertFalse(b1.isChild());
        Assert.assertEquals(b1.getAmount(), 0);
    }

    @Test
    /*
    Etant donné que le constructeur avec un montant négative initialise à la valeur négative et non à 0
     */
    public void invalidateB2_KO(){
        b2.invalidate();
        Assert.assertFalse(b2.isValid());
        Assert.assertFalse(b2.isChild());
        Assert.assertEquals(b2.getAmount(), 0);
    }

    @Test
    public void invalidateB3(){
        b3.invalidate();
        Assert.assertFalse(b3.isValid());
        Assert.assertFalse(b3.isChild());
        Assert.assertEquals(b3.getAmount(), 10);
    }

    @Test
    public void invalidateB4(){
        b4.invalidate();
        Assert.assertFalse(b4.isValid());
        Assert.assertTrue(b4.isChild());
        Assert.assertEquals(b4.getAmount(), 0);
    }

    @Test
    /*
    Etant donné que le constructeur avec un montant négative initialise à la valeur négative et non à 0
     */
    public void invalidateB5_KO(){
        b5.invalidate();
        Assert.assertFalse(b5.isValid());
        Assert.assertTrue(b5.isChild());
        Assert.assertEquals(b5.getAmount(), 0);
    }

    @Test
    public void invalidateB6(){
        b6.invalidate();
        Assert.assertFalse(b6.isValid());
        Assert.assertTrue(b6.isChild());
        Assert.assertEquals(b6.getAmount(), 10);
    }

    @Test
    public void getEntryStationNotEntryB1(){
        Assert.assertNull(b1.getEntryStation());
    }

    @Test
    public void getEntryStationNotEntryB2(){
        Assert.assertNull(b2.getEntryStation());
    }

    @Test
    public void getEntryStationNotEntryB3(){
        Assert.assertNull(b3.getEntryStation());
    }

    @Test
    public void getEntryStationNotEntryB4(){
        Assert.assertNull(b4.getEntryStation());
    }

    @Test
    public void getEntryStationNotEntryB5(){
        Assert.assertNull(b5.getEntryStation());
    }

    @Test
    public void getEntryStationNotEntryB6(){
        Assert.assertNull(b6.getEntryStation());
    }

}

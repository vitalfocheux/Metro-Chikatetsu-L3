package fr.ufc.l3info.oprog;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestAdjustedTicket {

    ITicket b1, b2, b3, b4, b5, b6, a1_b1, a2_b1, a3_b1, a1_b2, a2_b2, a3_b2, a1_b3, a2_b3, a3_b3, a1_b4, a2_b4, a3_b4, a1_b5, a2_b5, a3_b5, a1_b6, a2_b6, a3_b6;

    @Before
    public void setup(){
        b1 = new BaseTicket(false, 0);
        b2 = new BaseTicket(false, -1);
        b3 = new BaseTicket(false, 10);
        b4 = new BaseTicket(true, 0);
        b5 = new BaseTicket(true, -1);
        b6 = new BaseTicket(true, 10);
        a1_b1 = new AdjustedTicket(b1, 0);
        a2_b1 = new AdjustedTicket(b1, -1);
        a3_b1 = new AdjustedTicket(b1, 10);
        a1_b2 = new AdjustedTicket(b2, 0);
        a2_b2 = new AdjustedTicket(b2, -1);
        a3_b2 = new AdjustedTicket(b2, 10);
        a1_b3 = new AdjustedTicket(b3, 0);
        a2_b3 = new AdjustedTicket(b3,-1);
        a3_b3 = new AdjustedTicket(b3,10);
        a1_b4 = new AdjustedTicket(b4,0);
        a2_b4 = new AdjustedTicket(b4,-1);
        a3_b4 = new AdjustedTicket(b4,10);
        a1_b5 = new AdjustedTicket(b5,0);
        a2_b5 = new AdjustedTicket(b5,-1);
        a3_b5 = new AdjustedTicket(b5,10);
        a1_b6 = new AdjustedTicket(b6,0);
        a2_b6 = new AdjustedTicket(b6,-1);
        a3_b6 = new AdjustedTicket(b6,10);
    }

    @Test(expected = NullPointerException.class)
    public void constructeurATNull0Amount(){
        b1 = new AdjustedTicket(null, 0);
    }

    @Test(expected = NullPointerException.class)
    public void constructeurATNullPositive(){
        b1 = new AdjustedTicket(null, 10);
    }

    @Test(expected = NullPointerException.class)
    public void constructeurATNullNegative(){
        b1 = new AdjustedTicket(null, -1);
    }

    @Test
    public void constructeurATNegativeAmountB1(){
        b1 = new AdjustedTicket(b1, -1);
        Assert.assertEquals(b1.getAmount(), 0);
        Assert.assertFalse(b1.isChild());
        Assert.assertTrue(b1.isValid());
    }

    @Test
    /*
    Etant donné que le constructeur BaseTicket avec un montant négative initialise à la valeur négative et non à 0
     */
    public void constructeurATNegativeAmountB2_KO(){
        b2 = new AdjustedTicket(b2, -1);
        Assert.assertEquals(b2.getAmount(), 0);
        Assert.assertFalse(b2.isChild());
        Assert.assertTrue(b2.isValid());
    }

    @Test
    public void constructeurATNegativeAmountB3(){
        b3 = new AdjustedTicket(b3, -1);
        Assert.assertEquals(b3.getAmount(), 10);
        Assert.assertFalse(b3.isChild());
        Assert.assertTrue(b3.isValid());
    }

    @Test
    public void constructeurATNegativeAmountB4(){
        b4 = new AdjustedTicket(b4, -1);
        Assert.assertEquals(b4.getAmount(), 0);
        Assert.assertTrue(b4.isChild());
        Assert.assertTrue(b4.isValid());
    }

    @Test
    /*
    Etant donné que le constructeur BaseTicket avec un montant négative initialise à la valeur négative et non à 0
     */
    public void constructeurATNegativeAmountB5_KO(){
        b5 = new AdjustedTicket(b5, -1);
        Assert.assertEquals(b5.getAmount(), 0);
        Assert.assertTrue(b5.isChild());
        Assert.assertTrue(b5.isValid());
    }

    @Test
    public void constructeurATNegativeAmountB6(){
        b6 = new AdjustedTicket(b6, -1);
        Assert.assertEquals(b6.getAmount(), 10);
        Assert.assertTrue(b6.isChild());
        Assert.assertTrue(b6.isValid());
    }

    @Test
    public void constructeurAT0AmountB1(){
        b1 = new AdjustedTicket(b1, 0);
        Assert.assertEquals(b1.getAmount(), 0);
        Assert.assertFalse(b1.isChild());
        Assert.assertTrue(b1.isValid());
    }

    @Test
    /*
    Etant donné que le constructeur BaseTicket avec un montant négative initialise à la valeur négative et non à 0
     */
    public void constructeurAT0AmountB2_KO(){
        b2 = new AdjustedTicket(b2, 0);
        Assert.assertEquals(b2.getAmount(), 0);
        Assert.assertFalse(b2.isChild());
        Assert.assertTrue(b2.isValid());
    }

    @Test
    public void constructeurAT0AmountB3(){
        b3 = new AdjustedTicket(b3, 0);
        Assert.assertEquals(b3.getAmount(), 10);
        Assert.assertFalse(b3.isChild());
        Assert.assertTrue(b3.isValid());
    }

    @Test
    public void constructeurAT0AmountB4(){
        b4 = new AdjustedTicket(b4, 0);
        Assert.assertEquals(b4.getAmount(), 0);
        Assert.assertTrue(b4.isChild());
        Assert.assertTrue(b4.isValid());
    }

    @Test
    /*
    Etant donné que le constructeur BaseTicket avec un montant négative initialise à la valeur négative et non à 0
     */
    public void constructeurAT0AmountB5_KO(){
        b5 = new AdjustedTicket(b5, 0);
        Assert.assertEquals(b5.getAmount(), 0);
        Assert.assertTrue(b5.isChild());
        Assert.assertTrue(b5.isValid());
    }

    @Test
    public void constructeurAT0AmountB6(){
        b6 = new AdjustedTicket(b6, 0);
        Assert.assertEquals(b6.getAmount(), 10);
        Assert.assertTrue(b6.isChild());
        Assert.assertTrue(b6.isValid());
    }

    @Test
    public void constructeurATPositiveAmountB1(){
        b1 = new AdjustedTicket(b1, 10);
        Assert.assertEquals(b1.getAmount(), 10);
        Assert.assertFalse(b1.isChild());
        Assert.assertTrue(b1.isValid());
    }

    @Test
    /*
    Etant donné que le constructeur BaseTicket avec un montant négative initialise à la valeur négative et non à 0
     */
    public void constructeurATPositiveAmountB2_KO(){
        b2 = new AdjustedTicket(b2, 10);
        Assert.assertEquals(b2.getAmount(), 10);
        Assert.assertFalse(b2.isChild());
        Assert.assertTrue(b2.isValid());
    }

    @Test
    public void constructeurATPositiveAmountB3(){
        b3 = new AdjustedTicket(b3, 10);
        Assert.assertEquals(b3.getAmount(), 20);
        Assert.assertFalse(b3.isChild());
        Assert.assertTrue(b3.isValid());
    }

    @Test
    public void constructeurAT0PositivemountB4(){
        b4 = new AdjustedTicket(b4, 10);
        Assert.assertEquals(b4.getAmount(), 10);
        Assert.assertTrue(b4.isChild());
        Assert.assertTrue(b4.isValid());
    }

    @Test
    /*
    Etant donné que le constructeur BaseTicket avec un montant négative initialise à la valeur négative et non à 0
     */
    public void constructeurATPositiveAmountB5_KO(){
        b5 = new AdjustedTicket(b5, 10);
        Assert.assertEquals(b5.getAmount(), 10);
        Assert.assertTrue(b5.isChild());
        Assert.assertTrue(b5.isValid());
    }

    @Test
    public void constructeurATPositiveAmountB6(){
        b6 = new AdjustedTicket(b6, 10);
        Assert.assertEquals(b6.getAmount(), 20);
        Assert.assertTrue(b6.isChild());
        Assert.assertTrue(b6.isValid());
    }

    @Test
    public void isChildA1_B1(){
        Assert.assertFalse(a1_b1.isChild());
    }

    @Test
    public void isChildA2_B1(){
        Assert.assertFalse(a2_b1.isChild());
    }

    @Test
    public void isChildA3_B1(){
        Assert.assertFalse(a3_b1.isChild());
    }

    @Test
    public void isChildA1_B2(){
        Assert.assertFalse(a1_b2.isChild());
    }

    @Test
    public void isChildA2_B2(){
        Assert.assertFalse(a2_b2.isChild());
    }

    @Test
    public void isChildA3_B2(){
        Assert.assertFalse(a3_b2.isChild());
    }

    @Test
    public void isChildA1_B3(){
        Assert.assertFalse(a1_b3.isChild());
    }

    @Test
    public void isChildA2_B3(){
        Assert.assertFalse(a2_b3.isChild());
    }

    @Test
    public void isChildA3_B3(){
        Assert.assertFalse(a3_b3.isChild());
    }

    @Test
    public void isChildA1_B4(){
        Assert.assertTrue(a1_b4.isChild());
    }

    @Test
    public void isChildA2_B4(){
        Assert.assertTrue(a2_b4.isChild());
    }

    @Test
    public void isChildA3_B4(){
        Assert.assertTrue(a3_b4.isChild());
    }

    @Test
    public void isChildA1_B5(){
        Assert.assertTrue(a1_b5.isChild());
    }

    @Test
    public void isChildA2_B5(){
        Assert.assertTrue(a2_b5.isChild());
    }

    @Test
    public void isChildA3_B5(){
        Assert.assertTrue(a3_b5.isChild());
    }

    @Test
    public void isChildA1_B6(){
        Assert.assertTrue(a1_b6.isChild());
    }

    @Test
    public void isChildA2_B6(){
        Assert.assertTrue(a2_b6.isChild());
    }

    @Test
    public void isChildA3_B6(){
        Assert.assertTrue(a3_b6.isChild());
    }

    @Test
    public void isValidA1_B1() {
        Assert.assertTrue(a1_b1.isValid());
    }

    @Test
    public void isValidA2_B1() {
        Assert.assertTrue(a2_b1.isValid());
    }

    @Test
    public void isValidA3_B1() {
        Assert.assertTrue(a3_b1.isValid());
    }

    @Test
    public void isValidA1_B2() {
        Assert.assertTrue(a1_b2.isValid());
    }

    @Test
    public void isValidA2_B2() {
        Assert.assertTrue(a2_b2.isValid());
    }

    @Test
    public void isValidA3_B2() {
        Assert.assertTrue(a3_b2.isValid());
    }

    @Test
    public void isValidA1_B3() {
        Assert.assertTrue(a1_b3.isValid());
    }

    @Test
    public void isValidA2_B3() {
        Assert.assertTrue(a2_b3.isValid());
    }

    @Test
    public void isValidA3_B3() {
        Assert.assertTrue(a3_b3.isValid());
    }

    @Test
    public void isValidA1_B4() {
        Assert.assertTrue(a1_b4.isValid());
    }

    @Test
    public void isValidA2_B4() {
        Assert.assertTrue(a2_b4.isValid());
    }

    @Test
    public void isValidA3_B4() {
        Assert.assertTrue(a3_b4.isValid());
    }

    @Test
    public void isValidA1_B5() {
        Assert.assertTrue(a1_b5.isValid());
    }

    @Test
    public void isValidA2_B5() {
        Assert.assertTrue(a2_b5.isValid());
    }

    @Test
    public void isValidA3_B5() {
        Assert.assertTrue(a3_b5.isValid());
    }

    @Test
    public void isValidA1_B6() {
        Assert.assertTrue(a1_b6.isValid());
    }

    @Test
    public void isValidA2_B6() {
        Assert.assertTrue(a2_b6.isValid());
    }

    @Test
    public void isValidA3_B6() {
        Assert.assertTrue(a3_b6.isValid());
    }

    @Test
    public void invalidateA1_B1(){
        a1_b1.invalidate();
        Assert.assertFalse(a1_b1.isValid());
    }

    @Test
    public void invalidateA2_B1(){
        a2_b1.invalidate();
        Assert.assertFalse(a2_b1.isValid());
    }

    @Test
    public void invalidateA3_B1(){
        a3_b1.invalidate();
        Assert.assertFalse(a3_b1.isValid());
    }

    @Test
    public void invalidateA1_B2(){
        a1_b2.invalidate();
        Assert.assertFalse(a1_b2.isValid());
    }

    @Test
    public void invalidateA2_B2(){
        a2_b2.invalidate();
        Assert.assertFalse(a2_b2.isValid());
    }

    @Test
    public void invalidateA3_B2(){
        a3_b2.invalidate();
        Assert.assertFalse(a3_b2.isValid());
    }

    @Test
    public void invalidateA1_B3(){
        a1_b3.invalidate();
        Assert.assertFalse(a1_b3.isValid());
    }

    @Test
    public void invalidateA2_B3(){
        a2_b3.invalidate();
        Assert.assertFalse(a2_b3.isValid());
    }

    @Test
    public void invalidateA3_B3(){
        a3_b3.invalidate();
        Assert.assertFalse(a3_b3.isValid());
    }

    @Test
    public void invalidateA1_B4(){
        a1_b4.invalidate();
        Assert.assertFalse(a1_b4.isValid());
    }

    @Test
    public void invalidateA2_B4(){
        a2_b4.invalidate();
        Assert.assertFalse(a2_b4.isValid());
    }

    @Test
    public void invalidateA3_B4(){
        a3_b4.invalidate();
        Assert.assertFalse(a3_b4.isValid());
    }

    @Test
    public void invalidateA1_B5(){
        a1_b5.invalidate();
        Assert.assertFalse(a1_b5.isValid());
    }

    @Test
    public void invalidateA2_B5(){
        a2_b5.invalidate();
        Assert.assertFalse(a2_b5.isValid());
    }

    @Test
    public void invalidateA3_B5(){
        a3_b5.invalidate();
        Assert.assertFalse(a3_b5.isValid());
    }

    @Test
    public void invalidateA1_B6(){
        a1_b6.invalidate();
        Assert.assertFalse(a1_b6.isValid());
    }

    @Test
    public void invalidateA2_B6(){
        a2_b6.invalidate();
        Assert.assertFalse(a2_b6.isValid());
    }

    @Test
    public void invalidateA3_B6(){
        a3_b6.invalidate();
        Assert.assertFalse(a3_b6.isValid());
    }

    @Test
    public void enteringNullA1_B1(){
        Assert.assertFalse(a1_b1.entering(null));
        Assert.assertNull(a1_b1.getEntryStation());
        Assert.assertEquals(a1_b1.getAmount(), 0);
        Assert.assertFalse(a1_b1.isChild());
        Assert.assertFalse(a1_b1.isValid());
    }

    @Test
    public void enteringNullA2_B1(){
        Assert.assertFalse(a2_b1.entering(null));
        Assert.assertNull(a2_b1.getEntryStation());
        Assert.assertEquals(a2_b1.getAmount(), 0);
        Assert.assertFalse(a2_b1.isChild());
        Assert.assertFalse(a2_b1.isValid());
    }

    @Test
    public void enteringNullA3_B1(){
        Assert.assertFalse(a3_b1.entering(null));
        Assert.assertNull(a3_b1.getEntryStation());
        Assert.assertEquals(a3_b1.getAmount(), 10);
        Assert.assertFalse(a3_b1.isChild());
        Assert.assertFalse(a3_b1.isValid());
    }

    @Test
    /*
    Etant donné que le constructeur BaseTicket avec un montant négative initialise à la valeur négative et non à 0
     */
    public void enteringNullA1_B2_KO(){
        Assert.assertFalse(a1_b2.entering(null));
        Assert.assertNull(a1_b2.getEntryStation());
        Assert.assertEquals(a1_b2.getAmount(), 0);
        Assert.assertFalse(a1_b2.isChild());
        Assert.assertFalse(a1_b2.isValid());
    }

    @Test
    /*
    Etant donné que le constructeur BaseTicket avec un montant négative initialise à la valeur négative et non à 0
     */
    public void enteringNullA2_B2_KO(){
        Assert.assertFalse(a2_b2.entering(null));
        Assert.assertNull(a2_b2.getEntryStation());
        Assert.assertEquals(a2_b2.getAmount(), 0);
        Assert.assertFalse(a2_b2.isChild());
        Assert.assertFalse(a2_b2.isValid());
    }

    @Test
    /*
    Etant donné que le constructeur BaseTicket avec un montant négative initialise à la valeur négative et non à 0
     */
    public void enteringNullA3_B2_KO(){
        Assert.assertFalse(a3_b2.entering(null));
        Assert.assertNull(a3_b2.getEntryStation());
        Assert.assertEquals(a3_b2.getAmount(), 10);
        Assert.assertFalse(a3_b2.isChild());
        Assert.assertFalse(a3_b2.isValid());
    }

    @Test
    public void enteringNullA1_B3(){
        Assert.assertFalse(a1_b3.entering(null));
        Assert.assertNull(a1_b3.getEntryStation());
        Assert.assertEquals(a1_b3.getAmount(), 10);
        Assert.assertFalse(a1_b3.isChild());
        Assert.assertFalse(a1_b3.isValid());
    }

    @Test
    public void enteringNullA2_B3(){
        Assert.assertFalse(a2_b3.entering(null));
        Assert.assertNull(a2_b3.getEntryStation());
        Assert.assertEquals(a2_b3.getAmount(), 10);
        Assert.assertFalse(a2_b3.isChild());
        Assert.assertFalse(a2_b3.isValid());
    }

    @Test
    public void enteringNullA3_B3(){
        Assert.assertFalse(a3_b3.entering(null));
        Assert.assertNull(a3_b3.getEntryStation());
        Assert.assertEquals(a3_b3.getAmount(), 20);
        Assert.assertFalse(a3_b3.isChild());
        Assert.assertFalse(a3_b3.isValid());
    }

    @Test
    public void enteringNullA1_B4(){
        Assert.assertFalse(a1_b4.entering(null));
        Assert.assertNull(a1_b4.getEntryStation());
        Assert.assertEquals(a1_b4.getAmount(), 0);
        Assert.assertTrue(a1_b4.isChild());
        Assert.assertFalse(a1_b4.isValid());
    }

    @Test
    public void enteringNullA2_B4(){
        Assert.assertFalse(a2_b4.entering(null));
        Assert.assertNull(a2_b4.getEntryStation());
        Assert.assertEquals(a2_b4.getAmount(), 0);
        Assert.assertTrue(a2_b4.isChild());
        Assert.assertFalse(a2_b4.isValid());
    }

    @Test
    public void enteringNullA3_B4(){
        Assert.assertFalse(a3_b4.entering(null));
        Assert.assertNull(a3_b4.getEntryStation());
        Assert.assertEquals(a3_b4.getAmount(), 10);
        Assert.assertTrue(a3_b4.isChild());
        Assert.assertFalse(a3_b4.isValid());
    }

    @Test
    /*
    Etant donné que le constructeur BaseTicket avec un montant négative initialise à la valeur négative et non à 0
     */
    public void enteringNullA1_B5_KO(){
        Assert.assertFalse(a1_b5.entering(null));
        Assert.assertNull(a1_b5.getEntryStation());
        Assert.assertEquals(a1_b5.getAmount(), 0);
        Assert.assertTrue(a1_b5.isChild());
        Assert.assertFalse(a1_b5.isValid());
    }

    @Test
    /*
    Etant donné que le constructeur BaseTicket avec un montant négative initialise à la valeur négative et non à 0
     */
    public void enteringNullA2_B5_KO(){
        Assert.assertFalse(a2_b5.entering(null));
        Assert.assertNull(a2_b5.getEntryStation());
        Assert.assertEquals(a2_b5.getAmount(), 0);
        Assert.assertTrue(a2_b5.isChild());
        Assert.assertFalse(a2_b5.isValid());
    }

    @Test
    /*
    Etant donné que le constructeur BaseTicket avec un montant négative initialise à la valeur négative et non à 0
     */
    public void enteringNullA3_B5_KO(){
        Assert.assertFalse(a3_b5.entering(null));
        Assert.assertNull(a3_b5.getEntryStation());
        Assert.assertEquals(a3_b5.getAmount(), 10);
        Assert.assertTrue(a3_b5.isChild());
        Assert.assertFalse(a3_b5.isValid());
    }

    @Test
    public void enteringNullA1_B6(){
        Assert.assertFalse(a1_b6.entering(null));
        Assert.assertNull(a1_b6.getEntryStation());
        Assert.assertEquals(a1_b6.getAmount(), 10);
        Assert.assertTrue(a1_b6.isChild());
        Assert.assertFalse(a1_b6.isValid());
    }

    @Test
    public void enteringNullA2_B6(){
        Assert.assertFalse(a2_b6.entering(null));
        Assert.assertNull(a2_b6.getEntryStation());
        Assert.assertEquals(a2_b6.getAmount(), 10);
        Assert.assertTrue(a2_b6.isChild());
        Assert.assertFalse(a2_b6.isValid());
    }

    @Test
    public void enteringNullA3_B6(){
        Assert.assertFalse(a3_b6.entering(null));
        Assert.assertNull(a3_b6.getEntryStation());
        Assert.assertEquals(a3_b6.getAmount(), 20);
        Assert.assertTrue(a3_b6.isChild());
        Assert.assertFalse(a3_b6.isValid());
    }

    @Test
    public void enteringTrimA1_B1(){
        Assert.assertFalse(a1_b1.entering("   "));
        Assert.assertNull(a1_b1.getEntryStation());
        Assert.assertEquals(a1_b1.getAmount(), 0);
        Assert.assertFalse(a1_b1.isChild());
        Assert.assertFalse(a1_b1.isValid());
    }

    @Test
    public void enteringTrimA2_B1(){
        Assert.assertFalse(a2_b1.entering("   "));
        Assert.assertNull(a2_b1.getEntryStation());
        Assert.assertEquals(a2_b1.getAmount(), 0);
        Assert.assertFalse(a2_b1.isChild());
        Assert.assertFalse(a2_b1.isValid());
    }

    @Test
    public void enteringTrimA3_B1(){
        Assert.assertFalse(a3_b1.entering("   "));
        Assert.assertNull(a3_b1.getEntryStation());
        Assert.assertEquals(a3_b1.getAmount(), 10);
        Assert.assertFalse(a3_b1.isChild());
        Assert.assertFalse(a3_b1.isValid());
    }

    @Test
    /*
    Etant donné que le constructeur BaseTicket avec un montant négative initialise à la valeur négative et non à 0
     */
    public void enteringTrimA1_B2_KO(){
        Assert.assertFalse(a1_b2.entering("   "));
        Assert.assertNull(a1_b2.getEntryStation());
        Assert.assertEquals(a1_b2.getAmount(), 0);
        Assert.assertFalse(a1_b2.isChild());
        Assert.assertFalse(a1_b2.isValid());
    }

    @Test
    /*
    Etant donné que le constructeur BaseTicket avec un montant négative initialise à la valeur négative et non à 0
     */
    public void enteringTrimA2_B2_KO(){
        Assert.assertFalse(a2_b2.entering("   "));
        Assert.assertNull(a2_b2.getEntryStation());
        Assert.assertEquals(a2_b2.getAmount(), 0);
        Assert.assertFalse(a2_b2.isChild());
        Assert.assertFalse(a2_b2.isValid());
    }

    @Test
    /*
    Etant donné que le constructeur BaseTicket avec un montant négative initialise à la valeur négative et non à 0
     */
    public void enteringTrimA3_B2_KO(){
        Assert.assertFalse(a3_b2.entering("   "));
        Assert.assertNull(a3_b2.getEntryStation());
        Assert.assertEquals(a3_b2.getAmount(), 10);
        Assert.assertFalse(a3_b2.isChild());
        Assert.assertFalse(a3_b2.isValid());
    }

    @Test
    public void enteringTrimA1_B3(){
        Assert.assertFalse(a1_b3.entering("   "));
        Assert.assertNull(a1_b3.getEntryStation());
        Assert.assertEquals(a1_b3.getAmount(), 10);
        Assert.assertFalse(a1_b3.isChild());
        Assert.assertFalse(a1_b3.isValid());
    }

    @Test
    public void enteringTrimA2_B3(){
        Assert.assertFalse(a2_b3.entering("   "));
        Assert.assertNull(a2_b3.getEntryStation());
        Assert.assertEquals(a2_b3.getAmount(), 10);
        Assert.assertFalse(a2_b3.isChild());
        Assert.assertFalse(a2_b3.isValid());
    }

    @Test
    public void enteringTrimA3_B3(){
        Assert.assertFalse(a3_b3.entering("   "));
        Assert.assertNull(a3_b3.getEntryStation());
        Assert.assertEquals(a3_b3.getAmount(), 20);
        Assert.assertFalse(a3_b3.isChild());
        Assert.assertFalse(a3_b3.isValid());
    }

    @Test
    public void enteringTrimA1_B4(){
        Assert.assertFalse(a1_b4.entering("   "));
        Assert.assertNull(a1_b4.getEntryStation());
        Assert.assertEquals(a1_b4.getAmount(), 0);
        Assert.assertTrue(a1_b4.isChild());
        Assert.assertFalse(a1_b4.isValid());
    }

    @Test
    public void enteringTrimA2_B4(){
        Assert.assertFalse(a2_b4.entering("   "));
        Assert.assertNull(a2_b4.getEntryStation());
        Assert.assertEquals(a2_b4.getAmount(), 0);
        Assert.assertTrue(a2_b4.isChild());
        Assert.assertFalse(a2_b4.isValid());
    }

    @Test
    public void enteringTrimA3_B4(){
        Assert.assertFalse(a3_b4.entering("   "));
        Assert.assertNull(a3_b4.getEntryStation());
        Assert.assertEquals(a3_b4.getAmount(), 10);
        Assert.assertTrue(a3_b4.isChild());
        Assert.assertFalse(a3_b4.isValid());
    }

    @Test
    /*
    Etant donné que le constructeur BaseTicket avec un montant négative initialise à la valeur négative et non à 0
     */
    public void enteringTrimA1_B5_KO(){
        Assert.assertFalse(a1_b5.entering("   "));
        Assert.assertNull(a1_b5.getEntryStation());
        Assert.assertEquals(a1_b5.getAmount(), 0);
        Assert.assertTrue(a1_b5.isChild());
        Assert.assertFalse(a1_b5.isValid());
    }

    @Test
    /*
    Etant donné que le constructeur BaseTicket avec un montant négative initialise à la valeur négative et non à 0
     */
    public void enteringTrimA2_B5_KO(){
        Assert.assertFalse(a2_b5.entering("   "));
        Assert.assertNull(a2_b5.getEntryStation());
        Assert.assertEquals(a2_b5.getAmount(), 0);
        Assert.assertTrue(a2_b5.isChild());
        Assert.assertFalse(a2_b5.isValid());
    }

    @Test
    /*
    Etant donné que le constructeur BaseTicket avec un montant négative initialise à la valeur négative et non à 0
     */
    public void enteringTrimA3_B5_KO(){
        Assert.assertFalse(a3_b5.entering("   "));
        Assert.assertNull(a3_b5.getEntryStation());
        Assert.assertEquals(a3_b5.getAmount(), 10);
        Assert.assertTrue(a3_b5.isChild());
        Assert.assertFalse(a3_b5.isValid());
    }

    @Test
    public void enteringTrimA1_B6(){
        Assert.assertFalse(a1_b6.entering("   "));
        Assert.assertNull(a1_b6.getEntryStation());
        Assert.assertEquals(a1_b6.getAmount(), 10);
        Assert.assertTrue(a1_b6.isChild());
        Assert.assertFalse(a1_b6.isValid());
    }

    @Test
    public void enteringTrimA2_B6(){
        Assert.assertFalse(a2_b6.entering("   "));
        Assert.assertNull(a2_b6.getEntryStation());
        Assert.assertEquals(a2_b6.getAmount(), 10);
        Assert.assertTrue(a2_b6.isChild());
        Assert.assertFalse(a2_b6.isValid());
    }

    @Test
    public void enteringTrimA3_B6(){
        Assert.assertFalse(a3_b6.entering("   "));
        Assert.assertNull(a3_b6.getEntryStation());
        Assert.assertEquals(a3_b6.getAmount(), 20);
        Assert.assertTrue(a3_b6.isChild());
        Assert.assertFalse(a3_b6.isValid());
    }

    @Test
    public void enteringNoStringA1_B1(){
        Assert.assertFalse(a1_b1.entering(""));
        Assert.assertNull(a1_b1.getEntryStation());
        Assert.assertEquals(a1_b1.getAmount(), 0);
        Assert.assertFalse(a1_b1.isChild());
        Assert.assertFalse(a1_b1.isValid());
    }

    @Test
    public void enteringNoStringA2_B1(){
        Assert.assertFalse(a2_b1.entering(""));
        Assert.assertNull(a2_b1.getEntryStation());
        Assert.assertEquals(a2_b1.getAmount(), 0);
        Assert.assertFalse(a2_b1.isChild());
        Assert.assertFalse(a2_b1.isValid());
    }

    @Test
    public void enteringNoStringA3_B1(){
        Assert.assertFalse(a3_b1.entering(""));
        Assert.assertNull(a3_b1.getEntryStation());
        Assert.assertEquals(a3_b1.getAmount(), 10);
        Assert.assertFalse(a3_b1.isChild());
        Assert.assertFalse(a3_b1.isValid());
    }

    @Test
    /*
    Etant donné que le constructeur BaseTicket avec un montant négative initialise à la valeur négative et non à 0
     */
    public void enteringNoStringA1_B2_KO(){
        Assert.assertFalse(a1_b2.entering(""));
        Assert.assertNull(a1_b2.getEntryStation());
        Assert.assertEquals(a1_b2.getAmount(), 0);
        Assert.assertFalse(a1_b2.isChild());
        Assert.assertFalse(a1_b2.isValid());
    }

    @Test
    /*
    Etant donné que le constructeur BaseTicket avec un montant négative initialise à la valeur négative et non à 0
     */
    public void enteringNoStringA2_B2_KO(){
        Assert.assertFalse(a2_b2.entering(""));
        Assert.assertNull(a2_b2.getEntryStation());
        Assert.assertEquals(a2_b2.getAmount(), 0);
        Assert.assertFalse(a2_b2.isChild());
        Assert.assertFalse(a2_b2.isValid());
    }

    @Test
    /*
    Etant donné que le constructeur BaseTicket avec un montant négative initialise à la valeur négative et non à 0
     */
    public void enteringNoStringA3_B2_KO(){
        Assert.assertFalse(a3_b2.entering(""));
        Assert.assertNull(a3_b2.getEntryStation());
        Assert.assertEquals(a3_b2.getAmount(), 10);
        Assert.assertFalse(a3_b2.isChild());
        Assert.assertFalse(a3_b2.isValid());
    }

    @Test
    public void enteringNoStringA1_B3(){
        Assert.assertFalse(a1_b3.entering(""));
        Assert.assertNull(a1_b3.getEntryStation());
        Assert.assertEquals(a1_b3.getAmount(), 10);
        Assert.assertFalse(a1_b3.isChild());
        Assert.assertFalse(a1_b3.isValid());
    }

    @Test
    public void enteringNoStringA2_B3(){
        Assert.assertFalse(a2_b3.entering(""));
        Assert.assertNull(a2_b3.getEntryStation());
        Assert.assertEquals(a2_b3.getAmount(), 10);
        Assert.assertFalse(a2_b3.isChild());
        Assert.assertFalse(a2_b3.isValid());
    }

    @Test
    public void enteringNoStringA3_B3(){
        Assert.assertFalse(a3_b3.entering(""));
        Assert.assertNull(a3_b3.getEntryStation());
        Assert.assertEquals(a3_b3.getAmount(), 20);
        Assert.assertFalse(a3_b3.isChild());
        Assert.assertFalse(a3_b3.isValid());
    }

    @Test
    public void enteringNoStringA1_B4(){
        Assert.assertFalse(a1_b4.entering(""));
        Assert.assertNull(a1_b4.getEntryStation());
        Assert.assertEquals(a1_b4.getAmount(), 0);
        Assert.assertTrue(a1_b4.isChild());
        Assert.assertFalse(a1_b4.isValid());
    }

    @Test
    public void enteringNoStringA2_B4(){
        Assert.assertFalse(a2_b4.entering(""));
        Assert.assertNull(a2_b4.getEntryStation());
        Assert.assertEquals(a2_b4.getAmount(), 0);
        Assert.assertTrue(a2_b4.isChild());
        Assert.assertFalse(a2_b4.isValid());
    }

    @Test
    public void enteringNoStringA3_B4(){
        Assert.assertFalse(a3_b4.entering(""));
        Assert.assertNull(a3_b4.getEntryStation());
        Assert.assertEquals(a3_b4.getAmount(), 10);
        Assert.assertTrue(a3_b4.isChild());
        Assert.assertFalse(a3_b4.isValid());
    }

    @Test
    /*
    Etant donné que le constructeur BaseTicket avec un montant négative initialise à la valeur négative et non à 0
     */
    public void enteringNoStringA1_B5_KO(){
        Assert.assertFalse(a1_b5.entering(""));
        Assert.assertNull(a1_b5.getEntryStation());
        Assert.assertEquals(a1_b5.getAmount(), 0);
        Assert.assertTrue(a1_b5.isChild());
        Assert.assertFalse(a1_b5.isValid());
    }

    @Test
    /*
    Etant donné que le constructeur BaseTicket avec un montant négative initialise à la valeur négative et non à 0
     */
    public void enteringNoStringA2_B5_KO(){
        Assert.assertFalse(a2_b5.entering(""));
        Assert.assertNull(a2_b5.getEntryStation());
        Assert.assertEquals(a2_b5.getAmount(), 0);
        Assert.assertTrue(a2_b5.isChild());
        Assert.assertFalse(a2_b5.isValid());
    }

    @Test
    /*
    Etant donné que le constructeur BaseTicket avec un montant négative initialise à la valeur négative et non à 0
     */
    public void enteringNoStringA3_B5_KO(){
        Assert.assertFalse(a3_b5.entering(""));
        Assert.assertNull(a3_b5.getEntryStation());
        Assert.assertEquals(a3_b5.getAmount(), 10);
        Assert.assertTrue(a3_b5.isChild());
        Assert.assertFalse(a3_b5.isValid());
    }

    @Test
    public void enteringNoStringA1_B6(){
        Assert.assertFalse(a1_b6.entering(""));
        Assert.assertNull(a1_b6.getEntryStation());
        Assert.assertEquals(a1_b6.getAmount(), 10);
        Assert.assertTrue(a1_b6.isChild());
        Assert.assertFalse(a1_b6.isValid());
    }

    @Test
    public void enteringNoStringA2_B6(){
        Assert.assertFalse(a2_b6.entering(""));
        Assert.assertNull(a2_b6.getEntryStation());
        Assert.assertEquals(a2_b6.getAmount(), 10);
        Assert.assertTrue(a2_b6.isChild());
        Assert.assertFalse(a2_b6.isValid());
    }

    @Test
    public void enteringNoStringA3_B6(){
        Assert.assertFalse(a3_b6.entering(""));
        Assert.assertNull(a3_b6.getEntryStation());
        Assert.assertEquals(a3_b6.getAmount(), 20);
        Assert.assertTrue(a3_b6.isChild());
        Assert.assertFalse(a3_b6.isValid());
    }

    @Test
    public void enteringSuccesA1_B1(){
        Assert.assertTrue(a1_b1.entering("Station 1"));
        Assert.assertEquals(a1_b1.getEntryStation(), "Station 1");
        Assert.assertEquals(a1_b1.getAmount(), 0);
        Assert.assertFalse(a1_b1.isChild());
        Assert.assertTrue(a1_b1.isValid());
    }

    @Test
    public void enteringSuccesA2_B1(){
        Assert.assertTrue(a2_b1.entering("Station 1"));
        Assert.assertEquals(a2_b1.getEntryStation(), "Station 1");
        Assert.assertEquals(a2_b1.getAmount(), 0);
        Assert.assertFalse(a2_b1.isChild());
        Assert.assertTrue(a2_b1.isValid());
    }

    @Test
    public void enteringSuccesA3_B1(){
        Assert.assertTrue(a3_b1.entering("Station 1"));
        Assert.assertEquals(a3_b1.getEntryStation(), "Station 1");
        Assert.assertEquals(a3_b1.getAmount(), 10);
        Assert.assertFalse(a3_b1.isChild());
        Assert.assertTrue(a3_b1.isValid());
    }

    @Test
    /*
    Etant donné que le constructeur BaseTicket avec un montant négative initialise à la valeur négative et non à 0
     */
    public void enteringSuccesA1_B2_KO(){
        Assert.assertTrue(a1_b2.entering("Station 1"));
        Assert.assertEquals(a1_b2.getEntryStation(), "Station 1");
        Assert.assertEquals(a1_b2.getAmount(), 0);
        Assert.assertFalse(a1_b2.isChild());
        Assert.assertTrue(a1_b2.isValid());
    }

    @Test
    /*
    Etant donné que le constructeur BaseTicket avec un montant négative initialise à la valeur négative et non à 0
     */
    public void enteringSuccesA2_B2_KO(){
        Assert.assertTrue(a2_b2.entering("Station 1"));
        Assert.assertEquals(a2_b2.getEntryStation(), "Station 1");
        Assert.assertEquals(a2_b2.getAmount(), 0);
        Assert.assertFalse(a2_b2.isChild());
        Assert.assertTrue(a2_b2.isValid());
    }

    @Test
    /*
    Etant donné que le constructeur BaseTicket avec un montant négative initialise à la valeur négative et non à 0
     */
    public void enteringSuccesA3_B2_KO(){
        Assert.assertTrue(a3_b2.entering("Station 1"));
        Assert.assertEquals(a3_b2.getEntryStation(), "Station 1");
        Assert.assertEquals(a3_b2.getAmount(), 10);
        Assert.assertFalse(a3_b2.isChild());
        Assert.assertTrue(a3_b2.isValid());
    }

    @Test
    public void enteringSuccesA1_B3(){
        Assert.assertTrue(a1_b3.entering("Station 1"));
        Assert.assertEquals(a1_b3.getEntryStation(), "Station 1");
        Assert.assertEquals(a1_b3.getAmount(), 10);
        Assert.assertFalse(a1_b3.isChild());
        Assert.assertTrue(a1_b3.isValid());
    }

    @Test
    public void enteringSuccesA2_B3(){
        Assert.assertTrue(a2_b3.entering("Station 1"));
        Assert.assertEquals(a2_b3.getEntryStation(), "Station 1");
        Assert.assertEquals(a2_b3.getAmount(), 10);
        Assert.assertFalse(a2_b3.isChild());
        Assert.assertTrue(a2_b3.isValid());
    }

    @Test
    public void enteringSuccesA3_B3(){
        Assert.assertTrue(a3_b3.entering("Station 1"));
        Assert.assertEquals(a3_b3.getEntryStation(), "Station 1");
        Assert.assertEquals(a3_b3.getAmount(), 20);
        Assert.assertFalse(a3_b3.isChild());
        Assert.assertTrue(a3_b3.isValid());
    }

    @Test
    public void enteringSuccesA1_B4(){
        Assert.assertTrue(a1_b4.entering("Station 1"));
        Assert.assertEquals(a1_b4.getEntryStation(), "Station 1");
        Assert.assertEquals(a1_b4.getAmount(), 0);
        Assert.assertTrue(a1_b4.isChild());
        Assert.assertTrue(a1_b4.isValid());
    }

    @Test
    public void enteringSuccesA2_B4(){
        Assert.assertTrue(a2_b4.entering("Station 1"));
        Assert.assertEquals(a2_b4.getEntryStation(), "Station 1");
        Assert.assertEquals(a2_b4.getAmount(), 0);
        Assert.assertTrue(a2_b4.isChild());
        Assert.assertTrue(a2_b4.isValid());
    }

    @Test
    public void enteringSuccesA3_B4(){
        Assert.assertTrue(a3_b4.entering("Station 1"));
        Assert.assertEquals(a3_b4.getEntryStation(), "Station 1");
        Assert.assertEquals(a3_b4.getAmount(), 10);
        Assert.assertTrue(a3_b4.isChild());
        Assert.assertTrue(a3_b4.isValid());
    }

    @Test
    /*
    Etant donné que le constructeur BaseTicket avec un montant négative initialise à la valeur négative et non à 0
     */
    public void enteringSuccesA1_B5_KO(){
        Assert.assertTrue(a1_b5.entering("Station 1"));
        Assert.assertEquals(a1_b5.getEntryStation(), "Station 1");
        Assert.assertEquals(a1_b5.getAmount(), 0);
        Assert.assertTrue(a1_b5.isChild());
        Assert.assertTrue(a1_b5.isValid());
    }

    @Test
    /*
    Etant donné que le constructeur BaseTicket avec un montant négative initialise à la valeur négative et non à 0
     */
    public void enteringSuccesA2_B5_KO(){
        Assert.assertTrue(a2_b5.entering("Station 1"));
        Assert.assertEquals(a2_b5.getEntryStation(), "Station 1");
        Assert.assertEquals(a2_b5.getAmount(), 0);
        Assert.assertTrue(a2_b5.isChild());
        Assert.assertTrue(a2_b5.isValid());
    }

    @Test
    /*
    Etant donné que le constructeur BaseTicket avec un montant négative initialise à la valeur négative et non à 0
     */
    public void enteringSuccesA3_B5_KO(){
        Assert.assertTrue(a3_b5.entering("Station 1"));
        Assert.assertEquals(a3_b5.getEntryStation(), "Station 1");
        Assert.assertEquals(a3_b5.getAmount(), 10);
        Assert.assertTrue(a3_b5.isChild());
        Assert.assertTrue(a3_b5.isValid());
    }

    @Test
    public void enteringSuccesA1_B6(){
        Assert.assertTrue(a1_b6.entering("Station 1"));
        Assert.assertEquals(a1_b6.getEntryStation(), "Station 1");
        Assert.assertEquals(a1_b6.getAmount(), 10);
        Assert.assertTrue(a1_b6.isChild());
        Assert.assertTrue(a1_b6.isValid());
    }

    @Test
    public void enteringSuccesA2_B6(){
        Assert.assertTrue(a2_b6.entering("Station 1"));
        Assert.assertEquals(a2_b6.getEntryStation(), "Station 1");
        Assert.assertEquals(a2_b6.getAmount(), 10);
        Assert.assertTrue(a2_b6.isChild());
        Assert.assertTrue(a2_b6.isValid());
    }

    @Test
    public void enteringSuccesA3_B6(){
        Assert.assertTrue(a3_b6.entering("Station 1"));
        Assert.assertEquals(a3_b6.getEntryStation(), "Station 1");
        Assert.assertEquals(a3_b6.getAmount(), 20);
        Assert.assertTrue(a3_b6.isChild());
        Assert.assertTrue(a3_b6.isValid());
    }

    @Test
    public void enteringENTEREDA1_B1(){
        Assert.assertTrue(a1_b1.entering("S1"));
        Assert.assertFalse(a1_b1.entering(""));
        Assert.assertNull(a1_b1.getEntryStation());
        Assert.assertEquals(a1_b1.getAmount(), 0);
        Assert.assertFalse(a1_b1.isChild());
        Assert.assertFalse(a1_b1.isValid());
    }

    @Test
    public void enteringENTEREDA2_B1(){
        Assert.assertTrue(a2_b1.entering("S1"));
        Assert.assertFalse(a2_b1.entering(""));
        Assert.assertNull(a2_b1.getEntryStation());
        Assert.assertEquals(a2_b1.getAmount(), 0);
        Assert.assertFalse(a2_b1.isChild());
        Assert.assertFalse(a2_b1.isValid());
    }

    @Test
    public void enteringENTEREDA3_B1(){
        Assert.assertTrue(a3_b1.entering("S1"));
        Assert.assertFalse(a3_b1.entering(""));
        Assert.assertNull(a3_b1.getEntryStation());
        Assert.assertEquals(a3_b1.getAmount(), 10);
        Assert.assertFalse(a3_b1.isChild());
        Assert.assertFalse(a3_b1.isValid());
    }

    @Test
    /*
    Etant donné que le constructeur BaseTicket avec un montant négative initialise à la valeur négative et non à 0
     */
    public void enteringENTEREDA1_B2_KO(){
        Assert.assertTrue(a1_b2.entering("S1"));
        Assert.assertFalse(a1_b2.entering(""));
        Assert.assertNull(a1_b2.getEntryStation());
        Assert.assertEquals(a1_b2.getAmount(), 0);
        Assert.assertFalse(a1_b2.isChild());
        Assert.assertFalse(a1_b2.isValid());
    }

    @Test
    /*
    Etant donné que le constructeur BaseTicket avec un montant négative initialise à la valeur négative et non à 0
     */
    public void enteringENTEREDA2_B2_KO(){
        Assert.assertTrue(a2_b2.entering("S1"));
        Assert.assertFalse(a2_b2.entering(""));
        Assert.assertNull(a2_b2.getEntryStation());
        Assert.assertEquals(a2_b2.getAmount(), 0);
        Assert.assertFalse(a2_b2.isChild());
        Assert.assertFalse(a2_b2.isValid());
    }

    @Test
    /*
    Etant donné que le constructeur BaseTicket avec un montant négative initialise à la valeur négative et non à 0
     */
    public void enteringENTEREDA3_B2_KO(){
        Assert.assertTrue(a3_b2.entering("S1"));
        Assert.assertFalse(a3_b2.entering(""));
        Assert.assertNull(a3_b2.getEntryStation());
        Assert.assertEquals(a3_b2.getAmount(), 10);
        Assert.assertFalse(a3_b2.isChild());
        Assert.assertFalse(a3_b2.isValid());
    }

    @Test
    public void enteringENTEREDA1_B3(){
        Assert.assertTrue(a1_b3.entering("S1"));
        Assert.assertFalse(a1_b3.entering(""));
        Assert.assertNull(a1_b3.getEntryStation());
        Assert.assertEquals(a1_b3.getAmount(), 10);
        Assert.assertFalse(a1_b3.isChild());
        Assert.assertFalse(a1_b3.isValid());
    }

    @Test
    public void enteringENTEREDA2_B3(){
        Assert.assertTrue(a2_b3.entering("S1"));
        Assert.assertFalse(a2_b3.entering(""));
        Assert.assertNull(a2_b3.getEntryStation());
        Assert.assertEquals(a2_b3.getAmount(), 10);
        Assert.assertFalse(a2_b3.isChild());
        Assert.assertFalse(a2_b3.isValid());
    }

    @Test
    public void enteringENTEREDA3_B3(){
        Assert.assertTrue(a3_b3.entering("S1"));
        Assert.assertFalse(a3_b3.entering(""));
        Assert.assertNull(a3_b3.getEntryStation());
        Assert.assertEquals(a3_b3.getAmount(), 20);
        Assert.assertFalse(a3_b3.isChild());
        Assert.assertFalse(a3_b3.isValid());
    }

    @Test
    public void enteringENTEREDA1_B4(){
        Assert.assertTrue(a1_b4.entering("S1"));
        Assert.assertFalse(a1_b4.entering(""));
        Assert.assertNull(a1_b4.getEntryStation());
        Assert.assertEquals(a1_b4.getAmount(), 0);
        Assert.assertTrue(a1_b4.isChild());
        Assert.assertFalse(a1_b4.isValid());
    }

    @Test
    public void enteringENTEREDA2_B4(){
        Assert.assertTrue(a2_b4.entering("S1"));
        Assert.assertFalse(a2_b4.entering(""));
        Assert.assertNull(a2_b4.getEntryStation());
        Assert.assertEquals(a2_b4.getAmount(), 0);
        Assert.assertTrue(a2_b4.isChild());
        Assert.assertFalse(a2_b4.isValid());
    }

    @Test
    public void enteringENTEREDA3_B4(){
        Assert.assertTrue(a3_b4.entering("S1"));
        Assert.assertFalse(a3_b4.entering(""));
        Assert.assertNull(a3_b4.getEntryStation());
        Assert.assertEquals(a3_b4.getAmount(), 10);
        Assert.assertTrue(a3_b4.isChild());
        Assert.assertFalse(a3_b4.isValid());
    }

    @Test
    /*
    Etant donné que le constructeur BaseTicket avec un montant négative initialise à la valeur négative et non à 0
     */
    public void enteringENTEREDA1_B5_KO(){
        Assert.assertTrue(a1_b5.entering("S1"));
        Assert.assertFalse(a1_b5.entering(""));
        Assert.assertNull(a1_b5.getEntryStation());
        Assert.assertEquals(a1_b5.getAmount(), 0);
        Assert.assertTrue(a1_b5.isChild());
        Assert.assertFalse(a1_b5.isValid());
    }

    @Test
    /*
    Etant donné que le constructeur BaseTicket avec un montant négative initialise à la valeur négative et non à 0
     */
    public void enteringENTEREDA2_B5_KO(){
        Assert.assertTrue(a2_b5.entering("S1"));
        Assert.assertFalse(a2_b5.entering(""));
        Assert.assertNull(a2_b5.getEntryStation());
        Assert.assertEquals(a2_b5.getAmount(), 0);
        Assert.assertTrue(a2_b5.isChild());
        Assert.assertFalse(a2_b5.isValid());
    }

    @Test
    /*
    Etant donné que le constructeur BaseTicket avec un montant négative initialise à la valeur négative et non à 0
     */
    public void enteringENTEREDA3_B5_KO(){
        Assert.assertTrue(a3_b5.entering("S1"));
        Assert.assertFalse(a3_b5.entering(""));
        Assert.assertNull(a3_b5.getEntryStation());
        Assert.assertEquals(a3_b5.getAmount(), 10);
        Assert.assertTrue(a3_b5.isChild());
        Assert.assertFalse(a3_b5.isValid());
    }

    @Test
    public void enteringENTEREDA1_B6(){
        Assert.assertTrue(a1_b6.entering("S1"));
        Assert.assertFalse(a1_b6.entering(""));
        Assert.assertNull(a1_b6.getEntryStation());
        Assert.assertEquals(a1_b6.getAmount(), 10);
        Assert.assertTrue(a1_b6.isChild());
        Assert.assertFalse(a1_b6.isValid());
    }

    @Test
    public void enteringENTEREDA2_B6(){
        Assert.assertTrue(a2_b6.entering("S1"));
        Assert.assertFalse(a2_b6.entering(""));
        Assert.assertNull(a2_b6.getEntryStation());
        Assert.assertEquals(a2_b6.getAmount(), 10);
        Assert.assertTrue(a2_b6.isChild());
        Assert.assertFalse(a2_b6.isValid());
    }

    @Test
    public void enteringENTEREDA3_B6(){
        Assert.assertTrue(a3_b6.entering("S1"));
        Assert.assertFalse(a3_b6.entering(""));
        Assert.assertNull(a3_b6.getEntryStation());
        Assert.assertEquals(a3_b6.getAmount(), 20);
        Assert.assertTrue(a3_b6.isChild());
        Assert.assertFalse(a3_b6.isValid());
    }

    @Test
    public void getEntryStationNotEntryA1_B1(){
        Assert.assertNull(a1_b1.getEntryStation());
    }

    @Test
    public void getEntryStationNotEntryA2_B1(){
        Assert.assertNull(a2_b1.getEntryStation());
    }

    @Test
    public void getEntryStationNotEntryA3_B1(){
        Assert.assertNull(a3_b1.getEntryStation());
    }

    @Test
    public void getEntryStationNotEntryA1_B2(){
        Assert.assertNull(a1_b2.getEntryStation());
    }

    @Test
    public void getEntryStationNotEntryA2_B2(){
        Assert.assertNull(a2_b2.getEntryStation());
    }

    @Test
    public void getEntryStationNotEntryA3_B2(){
        Assert.assertNull(a3_b2.getEntryStation());
    }

    @Test
    public void getEntryStationNotEntryA1_B3(){
        Assert.assertNull(a1_b3.getEntryStation());
    }

    @Test
    public void getEntryStationNotEntryA2_B3(){
        Assert.assertNull(a2_b3.getEntryStation());
    }

    @Test
    public void getEntryStationNotEntryA3_B3(){
        Assert.assertNull(a3_b3.getEntryStation());
    }

    @Test
    public void getEntryStationNotEntryA1_B4(){
        Assert.assertNull(a1_b4.getEntryStation());
    }

    @Test
    public void getEntryStationNotEntryA2_B4(){
        Assert.assertNull(a2_b4.getEntryStation());
    }

    @Test
    public void getEntryStationNotEntryA3_B4(){
        Assert.assertNull(a3_b4.getEntryStation());
    }

    @Test
    public void getEntryStationNotEntryA1_B5(){
        Assert.assertNull(a1_b5.getEntryStation());
    }

    @Test
    public void getEntryStationNotEntryA2_B5(){
        Assert.assertNull(a2_b5.getEntryStation());
    }

    @Test
    public void getEntryStationNotEntryA3_B5(){
        Assert.assertNull(a3_b5.getEntryStation());
    }

    @Test
    public void getEntryStationNotEntryA1_B6(){
        Assert.assertNull(a1_b6.getEntryStation());
    }

    @Test
    public void getEntryStationNotEntryA2_B6(){
        Assert.assertNull(a2_b6.getEntryStation());
    }

    @Test
    public void getEntryStationNotEntryA3_B6(){
        Assert.assertNull(a3_b6.getEntryStation());
    }

}

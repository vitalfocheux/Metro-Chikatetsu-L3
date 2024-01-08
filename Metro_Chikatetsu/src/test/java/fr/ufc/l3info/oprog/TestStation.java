package fr.ufc.l3info.oprog;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 * Test file for the Station class.
 */
public class TestStation {

    Station s, s1, s2, s3, s4, s5, s6, s7,s8, s10;

    @Before     // indicates that the method should be executed before each test
    public void setup() {
        // creation of an object to test
        s = new Station("ma Station");
        s1 = new Station("Station 1", "", 1, 0.0);
        s2 = new Station("Station 2", null, 0, 0.0);
        s3 = new Station("Station 3", "     ", 1, 1.0);
        s4 = new Station("Station 4", "Ligne1", 0, 0.0);
        s5 = new Station("Station 5", "Ligne1", 1, -1.0);
        s6 = new Station("Station 6", "Ligne1", 1, 0.0);
        s7 = new Station("Station 7", "Ligne1", 2, 1.0);
        s8 = new Station("Station 7" , "Ligne1", 3, 3.0);
        s10 = new Station("Station 7", "Ligne1", 2, 1.0);

    }

    @Test
    public void addLineWithMultipleLine(){
        Station s9 = new Station("Station");
        s9.addLine("Ligne1", 1,0.0);
        s9.addLine("Ligne2",1,0.0);
        Assert.assertEquals(s9.getLines().size(), 2);
    }

    @Test
    public void addLineReplace(){
        Station s9 = new Station("Station");
        s9.addLine("Ligne1", 7, 20.0);
        Assert.assertEquals(s9.getNumberForLine("Ligne1"), 7);
        Assert.assertEquals(20.0, s9.getDistanceForLine("Ligne1"), 0);
        s9.addLine("Ligne1",1,0.0);
        Assert.assertNotEquals(s9.getNumberForLine("Ligne1"), 7);
        Assert.assertNotEquals(20.0,s9.getDistanceForLine("Ligne1"),0.0);
        Assert.assertEquals(s9.getNumberForLine("Ligne1"), 1);
        Assert.assertEquals(0.0, s9.getDistanceForLine("Ligne1"),0.0);
    }

    @Test
    public void addLineNull(){
        Station s9 = new Station("Station");
        s9.addLine(null, 1, 0.0);
        Assert.assertEquals(s9.getLines().size(), 0);
    }

    @Test
    public void addLineVoidString(){
        Station s9 = new Station("Station");
        s9.addLine("", 1, 0.0);
        Assert.assertEquals(s9.getLines().size(), 0);
    }

    @Test
    public void addLineNumberZero(){
        Station s9 = new Station("Station");
        s9.addLine("Ligne1", 0, 0.0);
        Assert.assertEquals(s9.getLines().size(), 0);
        Assert.assertEquals(s9.getNumberForLine("Ligne1"), 0);
    }

    @Test
    public void addLineNegativeDist(){
        Station s9 = new Station("Station");
        s9.addLine("Ligne1", 1, -1.0);
        Assert.assertEquals(s9.getLines().size(), 0);
        Assert.assertTrue(s9.getDistanceForLine("Ligne1") < 0);
    }

    @Test
    public void addLineSpaceString(){
        Station s9 = new Station("Station");
        s9.addLine("    ", 1, 0.0);
        Assert.assertEquals(s9.getLines().size(), 0);
    }

    @Test
    public void removeLineUnsuccessful(){
        s6.removeLine("Ligne2");
        Assert.assertEquals(s6.getLines().size(), 1);
    }

    @Test
    public void removeLineNull(){
        s6.removeLine(null);
        Assert.assertEquals(s6.getLines().size(), 1);
    }

    @Test
    public void removeLineTrim(){
        s6.removeLine("   ");
        Assert.assertEquals(s6.getLines().size(), 1);
    }



    @Test
    public void testRemoveLine(){
        s6.removeLine("Ligne1");
        Assert.assertEquals(s6.getLines().size(), 0);
    }

    @Test
    public void testRemoveLineWithTrim(){
        s6.removeLine("     Ligne1   ");
        Assert.assertEquals(s6.getLines().size(), 0);
    }

    @Test   // indicates that this method is a test case
    public void testName() {
        // an observation that will obviously succeed
        Assert.assertNotNull(s);
        // an observation that will cause the test to fail:
        Assert.assertEquals("ma Station", s.getName());
    }

    @Test
    public void testGetNumberLineNotThisLine(){
        Assert.assertEquals(s7.getNumberForLine("Ligne2"), 0);
    }

    @Test
    public void testGetNumberLineNull(){
        Assert.assertEquals(s7.getNumberForLine(null), 0);
    }

    @Test
    public void testGetNumberLineTrim(){
        Assert.assertEquals(s7.getNumberForLine("   "), 0);
    }

    @Test
    public void testGetNumberLineWithTrim(){
        Assert.assertEquals(s7.getNumberForLine("  Ligne1 "), 2);
    }

    @Test
    public void testGetNumberLine(){
        Assert.assertEquals(s7.getNumberForLine("Ligne1"), 2);
    }

    @Test
    public void testGetDistanceLineNotThisLine(){
        Assert.assertTrue(s5.getDistanceForLine("Ligne1") < 0);
    }

    @Test
    public void testGetDistanceLineNull(){
        Assert.assertTrue(s7.getDistanceForLine(null) < 0);
    }

    @Test
    public void testGetDistanceLineTrim(){
        Assert.assertTrue(s7.getDistanceForLine("   ") < 0);
    }

    @Test
    public void testGetDistanceLineWithTrim(){
        Assert.assertEquals(s7.getDistanceForLine(" Ligne1   "), 1.0,0);
    }

    @Test
    public void testGetDistanceLine(){
        Assert.assertEquals(s7.getDistanceForLine("Ligne1"), 1.0, 0);
    }

    @Test
    public void testGetLines(){
        Assert.assertEquals(s8.getLines().size(), 1);
        Assert.assertEquals(s5.getLines().size(), 0);
    }

    @Test
    public void testHashcode(){
        Assert.assertEquals(s7.hashCode(), s10.hashCode());
    }

    @Test
    public void testEquals(){
        Station s1 = new Station("ma Station");
        Assert.assertEquals(s, s1);
    }

    @Test
    public void testEqualsNotStation(){
        Assert.assertFalse(s.equals(1));
    }

    @Test
    public void testEqualsNotEquals(){
        Assert.assertNotEquals(s, s7);
    }
}
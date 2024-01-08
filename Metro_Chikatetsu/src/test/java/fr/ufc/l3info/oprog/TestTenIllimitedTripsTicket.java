package fr.ufc.l3info.oprog;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TestTenIllimitedTripsTicket {

    TenIllimitedTripsTicket t1, t2;
    Map<Double, Integer> prices1, prices2, prices3, prices4, prices5, prices6, prices7;
    Network myNetwork;
    Station station1, station2, station3;
    Map<Double, Integer> prices;
    String s;
    Barrier myBarrier;

    @Before
    public void setup(){
        t1 = new TenIllimitedTripsTicket(false);
        t2 = new TenIllimitedTripsTicket(true);

        prices1 = new TreeMap<>();
        for(int i = 0; i < 11; ++i){
            prices1.put(i * 100.0, 400 * i);
        }

        prices2 = new TreeMap<>();
        prices2.put(-1.0, 400);

        prices3 = new TreeMap<>();
        for(int i = 0; i < 11; ++i){
            prices3.put(i * 100.0, -i * 400);
        }
        prices3.put(0.0, -1);

        prices4 = new TreeMap<>();
        for(int i = 0; i< 11; ++i){
            prices4.put(i * 100.0, i * 25);
        }

        prices5 = new TreeMap<>();
        for(int i = 0; i < 11; ++i){
            prices5.put(i * 100.0, 400 * i+1);
        }
        prices5.put(11 * 100.0, 400);

        prices6 = new TreeMap<>();
        for(int i = 0; i < 11; ++i){
            prices6.put(-i * 100.0, i * 400);
        }
        prices6.put(-999.0, 9990);

        prices7 = new TreeMap<>();
        prices7.put(0.0, -1);

        station1 = new Station("station 1");
        station2 = new Station("station 2");
        station3 = new Station("station 3");

        station1.addLine("Ligne A", 0, 0.0);
        station2.addLine("Ligne A", 2, 10.0);
        station3.addLine("Ligne A", 1, 5.0);

        myNetwork = new Network();

        myNetwork.addStation(station1);

        prices = new HashMap<>();
        prices.put(0.0, 10);
        prices.put(10.0, 20);
        prices.put(20.0, 30);
        prices.put(30.0, 40);

        s = "station 1";

        myBarrier = Barrier.build(myNetwork,s,prices);
    }

    @Test
    public void TITTisChild(){
        Assert.assertTrue(t2.isChild());
        Assert.assertTrue(t2.isValid());
        Assert.assertEquals(t2.getAmount(), Integer.MAX_VALUE);
        Assert.assertNull(t2.getEntryStation());
    }

    @Test
    public void TITTnotChild(){
        Assert.assertFalse(t1.isChild());
        Assert.assertTrue((t1.isValid()));
        Assert.assertEquals(t1.getAmount(), Integer.MAX_VALUE);
        Assert.assertNull(t1.getEntryStation());
    }

    @Test
    public void EnteringValidTicket() {
        Assert.assertTrue(t1.entering(s));
        Assert.assertEquals(s, t1.getEntryStation());
        Assert.assertEquals(Integer.MAX_VALUE, t1.getAmount());
        Assert.assertTrue(t1.isValid());
    }

    @Test
    public void EnteringInvalidTicket() {
        t1.invalidate();
        Assert.assertFalse(t1.entering(s));
        Assert.assertNull(t1.getEntryStation());
        Assert.assertFalse(t1.isValid());
    }

    @Test
    public void EnteringChildTicket() {
        Assert.assertTrue(t2.entering("station 2"));
        Assert.assertEquals("station 2", t2.getEntryStation());
        Assert.assertEquals(Integer.MAX_VALUE, t2.getAmount());
        Assert.assertTrue(t2.isValid());
    }

    @Test
    public void EnteringWithEmptyName() {
        Assert.assertFalse(t1.entering(""));
        Assert.assertNull(t1.getEntryStation());
        Assert.assertFalse(t1.isValid());
    }

    @Test
    public void NoTripsAfterEntering10Times() {
        for (int i = 0; i < 10; i++) {
            t1.entering(s);
        }
        Assert.assertFalse(t1.entering(s));
    }

    @Test
    public void TITTwithBarrier() {
        Assert.assertTrue(myBarrier.enter(t1));
    }

}

package fr.ufc.l3info.oprog;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TestBarrierIntegration {

    Map<Double, Integer> prices1, prices2, prices3, prices4, prices5, prices6, prices7;
    ITicket b1, b2, b3, b4, b5, b6;

    Network myNetwork;
    Station station1, station2, station3;
    Map<Double, Integer> prices;
    String s;

    @Before
    public void setup(){
        b1 = new BaseTicket(false, 0);
        b2 = new BaseTicket(false, -1);
        b3 = new BaseTicket(false, 10);
        b4 = new BaseTicket(true, 0);
        b5 = new BaseTicket(true, -1);
        b6 = new BaseTicket(true, 10);

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
    }

    // Tests of build()

    @Test
    public void testBarrierBuild_NetworkIsNull() {
        Assert.assertNull(Barrier.build(null, s, prices));
    }

    @Test
    public void testBarrierBuild_StationIsNull() {
        Assert.assertNull(Barrier.build(myNetwork, null, prices));
    }

    @Test
    public void testBarrierBuild_PricesMapIsNull() {
        Assert.assertNull(Barrier.build(myNetwork, s, null));
    }

    @Test
    public void testBarrierBuild_NetworkIsInvalid() {
        myNetwork.addStation(station2);
        Assert.assertNull(Barrier.build(myNetwork, s, prices));
    }

    @Test
    public void testBarrierBuild_StationIsNotInNetwork() {
        s = "Napoléon";
        Assert.assertNull(Barrier.build(myNetwork, s, prices));
    }

    @Test
    public void testBarrierBuild_PricesMapIsEmpty() {
        prices.clear();
        Assert.assertNull(Barrier.build(myNetwork, s, prices));
    }

    @Test
    public void testBarrierBuild_ADistanceIsNonPositive() {
        prices.put(-42.0, 40);
        Assert.assertNull(Barrier.build(myNetwork, s, prices));
    }

    @Test
    public void testBarrierBuild_APriceIsNegative() {
        prices.put(42.0, -40);
        Assert.assertNull(Barrier.build(myNetwork, s, prices));
    }

    @Test
    public void testBarrierBuild_APriceIsNotMultipleOfTen() {
        prices.put(42.0, 42);
        Assert.assertNull(Barrier.build(myNetwork, s, prices));
    }

    @Test
    public void testBarrierBuild_PricesAreNotCrescent() {
        prices.put(42.0, 40);
        prices.put(24.0, 80);
        Assert.assertNull(Barrier.build(myNetwork, s, prices));
    }

    @Test
    public void testBarrierBuild_TheMinDistanceIsNot0() {
        prices.clear();
        prices.put(7.0, 40);
        Assert.assertNull(Barrier.build(myNetwork, s, prices));
    }

    @Test
    public void buildInvalidNetwork(){
        Network n = new Network();
        n.addStation(new Station("S1"));
        Barrier b = Barrier.build(n, "S1", prices1);
        Assert.assertNull(b);
    }

    @Test
    public void buildInvalidNetworkDistCommence0(){
        Network n = new Network();
        n.addStation(new Station("S1"));
        Barrier b = Barrier.build(n, "S1", prices2);
        Assert.assertNull(b);
    }

    @Test
    public void buildInvalidNetworkTarificationNeg(){
        Network n = new Network();
        n.addStation(new Station("S1"));
        Barrier b = Barrier.build(n, "S1", prices3);
        Assert.assertNull(b);
    }

    @Test
    public void buildInvalidNetworkPriceNotMultiple10(){
        Network n = new Network();
        n.addStation(new Station("S1"));
        Barrier b = Barrier.build(n, "S1", prices4);
        Assert.assertNull(b);
    }

    @Test
    public void buildInvalidNetworkPriceNotCroissant(){
        Network n = new Network();
        n.addStation(new Station("S1"));
        Barrier b = Barrier.build(n, "S1", prices5);
        Assert.assertNull(b);
    }


    @Test
    public void buildStationNotInNetwork(){
        Network n = new Network();
        Station s1 = new Station("S1", "Ligne1", 1, 0.0);
        Station s2 = new Station("S2", "Ligne1", 2, 20.0);
        n.addStation(s1);
        n.addStation(s2);
        Barrier b = Barrier.build(n, "S3", prices1);
        Assert.assertNull(b);
    }

    @Test
    public void buildStationNotInNetworkDistCommence0(){
        Network n = new Network();
        Station s1 = new Station("S1", "Ligne1", 1, 0.0);
        Station s2 = new Station("S2", "Ligne1", 2, 20.0);
        n.addStation(s1);
        n.addStation(s2);
        Barrier b = Barrier.build(n, "S3", prices2);
        Assert.assertNull(b);
    }

    @Test
    public void buildStationNotInNetworkTarificationNeg(){
        Network n = new Network();
        Station s1 = new Station("S1", "Ligne1", 1, 0.0);
        Station s2 = new Station("S2", "Ligne1", 2, 20.0);
        n.addStation(s1);
        n.addStation(s2);
        Barrier b = Barrier.build(n, "S3", prices3);
        Assert.assertNull(b);
    }

    @Test
    public void buildStationNotInNetworkPriceNotMultiple10(){
        Network n = new Network();
        Station s1 = new Station("S1", "Ligne1", 1, 0.0);
        Station s2 = new Station("S2", "Ligne1", 2, 20.0);
        n.addStation(s1);
        n.addStation(s2);
        Barrier b = Barrier.build(n, "S3", prices4);
        Assert.assertNull(b);
    }

    @Test
    public void buildStationNotInNetworkPriceNotCroissant(){
        Network n = new Network();
        Station s1 = new Station("S1", "Ligne1", 1, 0.0);
        Station s2 = new Station("S2", "Ligne1", 2, 20.0);
        n.addStation(s1);
        n.addStation(s2);
        Barrier b = Barrier.build(n, "S3", prices5);
        Assert.assertNull(b);
    }

    @Test
    public void builTarificationDistanceCommence0(){
        Network n = new Network();
        Station s1 = new Station("S1", "Ligne1", 1, 0.0);
        Station s2 = new Station("S2", "Ligne1", 2, 20.0);
        n.addStation(s1);
        n.addStation(s2);
        Barrier b = Barrier.build(n, "S1", prices2);
        Assert.assertNull(b);
    }

    @Test
    public void buildTarificationNeg(){
        Network n = new Network();
        Station s1 = new Station("S1", "Ligne1", 1, 0.0);
        Station s2 = new Station("S2", "Ligne1", 2, 20.0);
        n.addStation(s1);
        n.addStation(s2);
        Barrier b = Barrier.build(n, "S1", prices3);
        Assert.assertNull(b);
    }

    @Test
    public void buildPriceNotMultiple10(){
        Network n = new Network();
        Station s1 = new Station("S1", "Ligne1", 1, 0.0);
        Station s2 = new Station("S2", "Ligne1", 2, 20.0);
        n.addStation(s1);
        n.addStation(s2);
        Barrier b = Barrier.build(n, "S1", prices4);
        Assert.assertNull(b);
    }

    @Test
    public void buildPriceNotCroissant(){
        Network n = new Network();
        Station s1 = new Station("S1", "Ligne1", 1, 0.0);
        Station s2 = new Station("S2", "Ligne1", 2, 20.0);
        n.addStation(s1);
        n.addStation(s2);
        Barrier b = Barrier.build(n, "S1", prices5);
        Assert.assertNull(b);
    }

    @Test
    public void buildDistAllNeg(){
        Network n = new Network();
        Station s1 = new Station("S1", "Ligne1", 1, 0.0);
        Station s2 = new Station("S2", "Ligne1", 2, 20.0);
        n.addStation(s1);
        n.addStation(s2);
        Barrier b = Barrier.build(n, "S1", prices6);
        Assert.assertNull(b);
    }
    @Test
    public void testTarificationCorrectInvalid() {
        Network n = new Network();
        Station s1 = new Station("S1", "Ligne1", 1, 0.0);
        Station s2 = new Station("S2", "Ligne1", 2, 20.0);
        n.addStation(s1);
        n.addStation(s2);

        Barrier b = Barrier.build(n, "S1", prices7);

        Assert.assertNull(b);
    }


}
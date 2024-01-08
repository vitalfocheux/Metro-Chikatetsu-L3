package fr.ufc.l3info.oprog;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import org.junit.runner.RunWith;

import java.util.Map;
import java.util.TreeMap;

@RunWith(MockitoJUnitRunner.Silent.class)
public class TestBarrierWithMocks {

    Map<Double, Integer> prices1, prices2, prices3, prices4, prices5;

    @Before
    public void setup(){
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

        prices4 = new TreeMap<>();
        for(int i = 0; i< 11; ++i){
            prices4.put(i * 100.0, i * 25);
        }

        prices5 = new TreeMap<>();
        for(int i = 0; i < 11; ++i){
            prices5.put(i * 100.0, 400 * i+1);
        }
        prices5.put(11 * 100.0, 400);
    }

    @Test
    public void buildInvalidNetwork(){
        Network mockNetwork = Mockito.mock(Network.class);
        Mockito.when(mockNetwork.getStationByName("S1")).thenReturn(new Station("S1"));
        Barrier b = Barrier.build(mockNetwork, "S1", prices1);
        Assert.assertNull(b);
    }

    @Test
    public void buildInvalidNetworkDistCommence0(){
        Network mockNetwork = Mockito.mock(Network.class);
        Mockito.when(mockNetwork.getStationByName("S1")).thenReturn(new Station("S1"));
        Barrier b = Barrier.build(mockNetwork, "S1", prices2);
        Assert.assertNull(b);
    }

    @Test
    public void buildInvalidNetworkTarificationNeg(){
        Network mockNetwork = Mockito.mock(Network.class);
        Mockito.when(mockNetwork.getStationByName("S1")).thenReturn(new Station("S1"));
        Barrier b = Barrier.build(mockNetwork, "S1", prices3);
        Assert.assertNull(b);
    }

    @Test
    public void buildInvalidNetworkPriceNotMultiple10(){
        Network mockNetwork = Mockito.mock(Network.class);
        Mockito.when(mockNetwork.getStationByName("S1")).thenReturn(new Station("S1"));
        Barrier b = Barrier.build(mockNetwork, "S1", prices4);
        Assert.assertNull(b);
    }

    @Test
    public void buildInvalidNetworkPriceNotCroissant(){
        Network mockNetwork = Mockito.mock(Network.class);
        Mockito.when(mockNetwork.getStationByName("S1")).thenReturn(new Station("S1"));
        Barrier b = Barrier.build(mockNetwork, "S1", prices5);
        Assert.assertNull(b);
    }


    @Test
    public void buildStationNotInNetwork(){
        Network mockNetwork = Mockito.mock(Network.class);
        Mockito.when(mockNetwork.isValid()).thenReturn(true);
        Barrier b = Barrier.build(mockNetwork, "S1", prices1);
        Assert.assertNull(b);
    }

    @Test
    public void buildStationNotInNetworkDistCommence0(){
        Network mockNetwork = Mockito.mock(Network.class);
        Mockito.when(mockNetwork.isValid()).thenReturn(true);
        Barrier b = Barrier.build(mockNetwork, "S1", prices2);
        Assert.assertNull(b);
    }

    @Test
    public void buildStationNotInNetworkTarificationNeg(){
        Network mockNetwork = Mockito.mock(Network.class);
        Mockito.when(mockNetwork.isValid()).thenReturn(true);
        Barrier b = Barrier.build(mockNetwork, "S1", prices3);
        Assert.assertNull(b);
    }

    @Test
    public void buildStationNotInNetworkPriceNotMultiple10(){
        Network mockNetwork = Mockito.mock(Network.class);
        Mockito.when(mockNetwork.isValid()).thenReturn(true);
        Barrier b = Barrier.build(mockNetwork, "S1", prices4);
        Assert.assertNull(b);
    }

    @Test
    public void buildStationNotInNetworkPriceNotCroissant(){
        Network mockNetwork = Mockito.mock(Network.class);
        Mockito.when(mockNetwork.isValid()).thenReturn(true);
        Barrier b = Barrier.build(mockNetwork, "S1", prices5);
        Assert.assertNull(b);
    }

    @Test
    public void builTarificationDistanceCommence0(){
        Network mockNetwork = Mockito.mock(Network.class);
        Mockito.when(mockNetwork.isValid()).thenReturn(true);
        Mockito.when(mockNetwork.getStationByName("S1")).thenReturn(new Station("S1"));
        Barrier b = Barrier.build(mockNetwork, "S1", prices2);
        Assert.assertNull(b);
    }

    @Test
    public void buildPriceNotMultiple10(){
        Network mockNetwork = Mockito.mock(Network.class);
        Mockito.when(mockNetwork.isValid()).thenReturn(true);
        Mockito.when(mockNetwork.getStationByName("S1")).thenReturn(new Station("S1"));
        Barrier b = Barrier.build(mockNetwork, "S1", prices4);
        Assert.assertNull(b);
    }

    @Test
    public void buildPriceNotCroissant(){
        Network mockNetwork = Mockito.mock(Network.class);
        Mockito.when(mockNetwork.isValid()).thenReturn(true);
        Mockito.when(mockNetwork.getStationByName("S1")).thenReturn(new Station("S1"));
        Barrier b = Barrier.build(mockNetwork, "S1", prices5);
        Assert.assertNull(b);
    }
}

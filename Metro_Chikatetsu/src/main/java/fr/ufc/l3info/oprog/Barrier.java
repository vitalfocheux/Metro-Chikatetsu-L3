package fr.ufc.l3info.oprog;

import java.util.HashMap;
import java.util.Map;

public class Barrier {

    Network myNetwork;
    String myStation;
    Map<Double, Integer> myPrices;
    private Barrier(Network net, String station, Map<Double, Integer> prices) {
        myNetwork = net;
        myStation = station;
        myPrices = prices;
    }

    public static Barrier build(Network n, String s, Map<Double, Integer> p) {
        if (n == null || s == null || p == null) return null;
        if (!n.isValid()){return null;}
        if(n.getStationByName(s) == null) return null;
        if (p.isEmpty()) return null;

        double minDist = -1;
        Map.Entry<Double, Integer> min = null;
        for (Map.Entry<Double, Integer> entry1 : p.entrySet()) {
            if (min == null) min = entry1;
            if (entry1.getValue() < min.getValue()) min = entry1;
            if (entry1.getKey() < 0) return null;
            if (entry1.getValue() <= 0) return null;
            if (minDist < 0) minDist = entry1.getKey();
            if (entry1.getKey() < minDist) minDist = entry1.getKey();
            if (entry1.getValue() % 10 != 0) return null;
            for (Map.Entry<Double, Integer> entry2 : p.entrySet()) {
                if (entry1 == entry2) continue;
                if (entry1.getKey() > entry2.getKey()) {
                    if (entry1.getValue() <= entry2.getValue()) return null;
                }
                else if (entry1.getKey() < entry2.getKey()) {
                    if (entry1.getValue() >= entry2.getValue()) return null;
                }
            }
        }
        if (minDist != 0) return null;
        if (min.getKey() != 0) return null;

        return new Barrier(n,s,p);
    }

    public boolean enter(ITicket t) {
        if (t.isValid() && t.getAmount() > 0 && t.getEntryStation() == null) {
            t.entering(myStation);
            return true;
        }
        if (t.getEntryStation() != null) t.invalidate();
        return false;
    }

    public boolean exit(ITicket t) {
        if (t == null) return false;
        System.out.println("a");
        if (!t.isValid()) return false;
        System.out.println("b");
        double dist = myNetwork.distance(t.getEntryStation(),myStation);
        int cost = -1;
        if (dist > 0.0) {
            System.out.println("c");
            double greaterInfLim = 0;
            for (Map.Entry<Double, Integer> entry : myPrices.entrySet()) {
                System.out.println("d" + entry.getValue());
                if (greaterInfLim <= entry.getKey() && entry.getKey() < dist) {
                    System.out.println("e" + entry.getValue());
                    greaterInfLim = entry.getKey();
                    cost = entry.getValue();
                }
            }
        }
        else {
            System.out.println("f");
            cost = myPrices.get(0.0);
        }
        System.out.println("g");
        if (t.isChild()) {
            System.out.println("h");
            cost = cost/2;
            cost = cost + cost%10;
        }
        System.out.println("i");
        if (cost > t.getAmount()) return false;
        System.out.println("j");
        t.invalidate();
        return true;
    }
}
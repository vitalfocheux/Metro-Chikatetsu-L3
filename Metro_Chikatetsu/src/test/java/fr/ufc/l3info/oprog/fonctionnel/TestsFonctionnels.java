package fr.ufc.l3info.oprog.fonctionnel;

import fr.ufc.l3info.oprog.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TestsFonctionnels {
    TicketMachine distrib = TicketMachine.getInstance();

    String station_name;
    Map<Double,Integer> prices = new HashMap<>();
    Network network_valid, network_notValid;
    Station station, s_namboku_1, s_namboku_2, s_namboku_3;
    Barrier bar1, bar2, bar3;

    //Pierre
    Network n;
    String tozai;
    Station c2, t01, t02, t03, t04, t05, t06, t07, t08, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19;
    Map<Double, Integer> price;
    ITicket ticketAdulte, ticketEnfant;

    @Before
    public void setup() {
        station_name = "Ora ora ora ora";
        network_valid = new Network();
        network_notValid = new Network();
        station = new Station(station_name);
        s_namboku_1 = new Station("Asabu", "Namboku Line", 1, 0);
        s_namboku_2 = new Station("Kita sanjuyo jo", "Namboku Line", 2, 3.0);
        s_namboku_3 = new Station("Kita nijuyo yo", "Namboku Line", 3, 5.0);
        network_valid.addStation(s_namboku_1);
        network_valid.addStation(s_namboku_2);
        network_valid.addStation(s_namboku_3);
        prices.put(0.0, 100);
        prices.put(3.0, 250);
        prices.put(5.0, 400);
        bar1 = Barrier.build(network_valid, s_namboku_1.getName(), prices);
        bar2 = Barrier.build(network_valid, s_namboku_2.getName(), prices);
        bar3 = Barrier.build(network_valid, s_namboku_3.getName(), prices);

        n = new Network();

        tozai = "Tozai Line";

        c2 = new Station("Odori");
        t01 = new Station("Miyanosawa", tozai, 1, 0.0);
        t02 = new Station("Hassamu minami", tozai, 2, 1.5);
        t03 = new Station("Kotoni", tozai, 3, 2.8);
        t04 = new Station("Nijuyonken", tozai, 4, 3.7);
        t05 = new Station("Nishi nijuhatchome", tozai, 5, 4.9);
        t06 = new Station("Maruyama koen", tozai, 6, 5.7);
        t07 = new Station("Nishi juhatchome", tozai, 7, 6.6);
        t08 = new Station("Nishi juitchome", tozai, 8, 7.5);
        c2.addLine(tozai, 9, 8.5);
        t10 = new Station("Bus Center mae", tozai, 10, 9.3);
        t11 = new Station("Kikusui", tozai, 11, 10.4);
        t12 = new Station("Higashi Sapporo", tozai, 12, 11.6);
        t13 = new Station("Shiroishi", tozai, 13, 12.7);
        t14 = new Station("Nango nana chome", tozai, 14, 14.1);
        t15 = new Station("Nango jusan chome", tozai, 15, 15.2);
        t16 = new Station("Nango juhatchome", tozai, 16, 16.4);
        t17 = new Station("Oyachi", tozai, 17, 17.9);
        t18 = new Station("Hibarigaoka", tozai, 18, 18.9);
        t19 = new Station("Shin Sapporo", tozai, 19, 20.1);
        n.addStation(t01);n.addStation(t02);n.addStation(t03);n.addStation(t04);n.addStation(t05);n.addStation(t06);n.addStation(t07);n.addStation(t08);n.addStation(c2);n.addStation(t10);n.addStation(t11);n.addStation(t12);n.addStation(t13);n.addStation(t14);n.addStation(t15);n.addStation(t16);n.addStation(t17);n.addStation(t18);n.addStation(t19);

        price = new HashMap<>();
        price.put(0.0, 100);
        price.put(5.0, 375);
        price.put(7.5, 500);
        price.put(12.0, 700);
        price.put(15.0, 850);
        price.put(21.0, 1000);

        ticketAdulte = distrib.buyTicket(false, 1000);
        ticketEnfant = distrib.buyTicket(true, 600);
    }


    @Test
    public void ticketNotEnoughAmountAdult_bar1(){ //scenar 1
        ITicket ticket = distrib.buyTicket(false,45);
        bar1.enter(ticket);
        Assert.assertFalse(bar1.exit(ticket));
    }

    /*@Test
    public void ticketNotEnoughAmountAdult_bis(){ //Scenar 1 *
        ITicket ticket = distrib.buyTicket(false,500);
        Station s_namboku_4 = new Station("Les Ratz","Namboku Line",4,6.3);
        network_valid.addStation(s_namboku_4);
        prices.put(7.0, 550);
        Barrier bar4 = Barrier.build(network_valid,s_namboku_4.getName(),prices);
        bar1.enter(ticket);
        Assert.assertFalse(bar4.exit(ticket));
    }*/

    @Test
    public void ticket_AllGood_Adult(){ //Scenar 1 Bis
        ITicket ticket = distrib.buyTicket(false,1000);
        bar1.enter(ticket);
        Assert.assertTrue(bar1.exit(ticket));
    }

    @Test
    public void ticket_AllGood_Adult_bis(){ //Scenar 1 Bis *
        ITicket ticket = distrib.buyTicket(false,1000);
        Station s_namboku_4 = new Station("Les Ratz","Namboku Line",4,6.3);
        network_valid.addStation(s_namboku_4);
        prices.put(7.0, 550);
        Barrier bar4 = Barrier.build(network_valid,s_namboku_4.getName(),prices);
        bar1.enter(ticket);
        Assert.assertTrue(bar4.exit(ticket));
    }


    @Test
    public void ticketNotEnoughAmountChild_bar1(){ //scenar 2
        ITicket ticket = distrib.buyTicket(true,45);
        bar1.enter(ticket);
        Assert.assertFalse(bar1.exit(ticket));
    }

    /*@Test
    public void ticketNotEnoughAmountChild_arrondie_dizaine_supp(){ //scenar 2
        Station s_namboku_4 = new Station("Les Ratz","Namboku Line",4,7.0);
        network_valid.addStation(s_namboku_4);
        prices.put(7.0, 550);
        Barrier bar4 = Barrier.build(network_valid,s_namboku_4.getName(),prices);
        ITicket ticket = distrib.buyTicket(true,275);
        bar1.enter(ticket);
        Assert.assertFalse(bar4.exit(ticket));
    }*/

    @Test
    public void ticket_AllGood_Child(){ //Scenar 2 Bis
        ITicket ticket = distrib.buyTicket(true,1000);
        bar1.enter(ticket);
        Assert.assertTrue(bar1.exit(ticket));
    }

    @Test
    public void ticket_AllGood_Child_arrondie_dizaine_supp(){ //Scenar 2 Bis
        Station s_namboku_4 = new Station("Les Ratz","Namboku Line",4,7.0);
        network_valid.addStation(s_namboku_4);
        prices.put(7.0, 550);
        Barrier bar4 = Barrier.build(network_valid,s_namboku_4.getName(),prices);
        ITicket ticket = distrib.buyTicket(true,280);
        bar1.enter(ticket);
        Assert.assertTrue(bar4.exit(ticket));
    }

    @Test
    public void ticketNotEnoughAmountAdult_butIsChild(){ // scenar 3
        ITicket ticket_adult = distrib.buyTicket(false,50);
        bar1.enter(ticket_adult);
        Assert.assertFalse(bar1.exit(ticket_adult));
        ITicket ticket_child = distrib.buyTicket(true,50);
        bar1.enter(ticket_child);
        Assert.assertTrue(bar1.exit(ticket_child));
    }

    @Test
    public void adjustedTicket_1time(){ //scenar 4
        ITicket ticket = distrib.buyTicket(false,45);
        bar1.enter(ticket);
        Assert.assertFalse(bar1.exit(ticket));
        ITicket adjusted_ticket = distrib.adjustFare(ticket, 65);
        Assert.assertTrue(bar1.exit(adjusted_ticket));
    }

    @Test
    public void adjustedTicket_2time(){ //scenar 5
        ITicket ticket = distrib.buyTicket(false,45);
        bar1.enter(ticket);
        Assert.assertFalse(bar1.exit(ticket));
        ITicket adjusted_ticket = distrib.adjustFare(ticket, 45);
        Assert.assertFalse(bar1.exit(adjusted_ticket));
        ITicket adjusted_ticket_2 = distrib.adjustFare(adjusted_ticket, 45);
        Assert.assertTrue(bar1.exit(adjusted_ticket_2));
    }

    /*@Test
    public void adjustedTicket_2time_bar2(){ //scenar 5 bar2
        ITicket ticket = distrib.buyTicket(false,45);
        bar1.enter(ticket);
        Assert.assertFalse(bar2.exit(ticket));
        ITicket adjusted_ticket =  distrib.adjustFare(ticket, 145);
        Assert.assertFalse(bar2.exit(adjusted_ticket));
        ITicket adjusted_ticket_2 = distrib.adjustFare(adjusted_ticket, 145);
        Assert.assertTrue(bar2.exit(adjusted_ticket_2));
    }*/

    @Test
    public void ticketNotValid(){ //scenar 6
        ITicket ticket = distrib.buyTicket(false,1000);
        ticket.invalidate();
        Assert.assertFalse(bar1.exit(ticket));
    }

    @Test
    public void tryToExit2TimesSameBar(){ //scenar 7
        ITicket ticket = distrib.buyTicket(false,1000);
        bar1.enter(ticket);
        Assert.assertTrue(bar1.exit(ticket));
        Assert.assertFalse(bar1.exit(ticket));
    }

    @Test
    public void tryToExit2TimesNotSameBar(){ //scenar 7
        ITicket ticket = distrib.buyTicket(false,1000);
        bar1.enter(ticket);
        Assert.assertTrue(bar1.exit(ticket));
        Assert.assertFalse(bar3.exit(ticket));
    }

   /* @Test
    public void ticketNotEntered(){ //scenar 8
        ITicket ticket = distrib.buyTicket(false,1000);
        Assert.assertFalse(bar1.exit(ticket));
    }*/

    /*@Test
    public void StationEnteringRemovedFromLine_SameEnterThanExit(){ //Scenario bombe nucléaire sur la station 1
        ITicket ticket = distrib.buyTicket(false,1000);
        bar1.enter(ticket);
        s_namboku_1.removeLine("Namboku Line");
        Assert.assertFalse(bar1.exit(ticket));
    }*/

    /*@Test
    public void StationEnteringRemovedFromLine_NotSameEnterThanExit(){ //Scenario bombe nucléaire sur la station 3
        ITicket ticket = distrib.buyTicket(false,1000);
        bar1.enter(ticket);
        s_namboku_1.removeLine("Namboku Line");
        Assert.assertFalse(bar3.exit(ticket));
    }*/

    /*
     * Scenar 1 : Est un adulte, station 1 > station 3 > pas assez d'argent
     * Scenar 2: Est un enfant, station 1 > 3 > pas assez d'argent
     * Scenar 1 bis : Est un adulte s1 > s2 > assez d'argent
     * Scenar 2 bis : Est un enfant s1 > s2 > assez d'argent
     * Scenar 3 : Est un enfant , station 1 > 3 pas assez d'argent pour un adulte mais assez pour enfant
     * Scenar 4: Peu importe, s1 > s3 > pas assez d'argent > MAIS ON AJOUTE DU FRIC > assez d'argent
     * Scenar 5: Pas assez d'argent pour sortir > on ajoute fric > toujours pas assez > on rajoute fric > on peut sortir
     * Scenar 6 : Ticket invalide de base
     * Scenar 7 : On essaye de sortir deux fois avec le meme ticket -> meme barrière
     * Scenar 7 bis : On essaye de sortir deux fois meais pas la meme station
     * Scenar 8 : On essaye de sortir avec un tikcet qui n'est jamais entré quelque part
     */

    /*@Test
    public void testExitBadTicket(){
        ITicket t = distrib.buyTicket(false, 10000000);
        Barrier b = Barrier.build(n, t01.getName(), price);
        Assert.assertTrue(b.enter(t));
        t.invalidate();
        Assert.assertFalse(b.exit(t));
    }*/

    /*@Test
    public void testExitUsedTicket(){
        ITicket t = distrib.buyTicket(false, 1000);
        Barrier b = Barrier.build(n, t01.getName(), price);
        Assert.assertTrue(b.enter(t));
        Assert.assertTrue(b.exit(t));
        Assert.assertFalse(b.enter(t));
    }*/

    /*@Test
    public void testExitNoEntryStation(){
        ITicket t = distrib.buyTicket(false, 1000);
        Barrier b = Barrier.build(n, t01.getName(), price);
        Assert.assertFalse(b.exit(t));
    }*/

    /*@Test
    public void testExitNotEnoughMoney(){
        ITicket t = distrib.buyTicket(false, 100);
        Barrier b = Barrier.build(n, t01.getName(), price);
        Barrier b2 = Barrier.build(n, t17.getName(), price);
        Assert.assertTrue(b.enter(t));
        Assert.assertFalse(b2.exit(t));
    }*/

    /*@Test
    public void testExitRefuelMoney(){
        ITicket t = distrib.buyTicket(false, 100);
        Barrier b = Barrier.build(n, t01.getName(), price);
        Barrier b2 = Barrier.build(n, t17.getName(), price);
        Assert.assertTrue(b.enter(t));
        Assert.assertFalse(b2.exit(t));
        ITicket ta = distrib.adjustFare(t, 1000);
        Assert.assertTrue(b2.exit(ta));
    }*/

    /*@Test
    public void testReEnterWithAlreadyExitedRefuelMoney(){
        ITicket t = distrib.buyTicket(false, 100);
        Barrier b = Barrier.build(n, t01.getName(), price);
        Barrier b2 = Barrier.build(n, t17.getName(), price);
        Assert.assertTrue(b.enter(t));
        Assert.assertFalse(b2.exit(t));
        ITicket ta = distrib.adjustFare(t, 1000);
        Assert.assertTrue(b2.exit(ta));
        Assert.assertFalse(b2.enter(ta));
    }*/

   /*@Test
    public void testExitEnoughMoneyAsChild(){
        ITicket t = distrib.buyTicket(true, 50);
        Barrier b = Barrier.build(n, t01.getName(), price);
        Assert.assertTrue(b.enter(t));
        Assert.assertTrue(b.exit(t));
    }*/

    /*@Test
    public void testExitFailDespiteRefuelMoneyAsChild(){
        ITicket t = distrib.buyTicket(true, 100);
        Barrier b = Barrier.build(n, t01.getName(), price);
        Barrier b2 = Barrier.build(n, t05.getName(), price);
        Assert.assertTrue(b.enter(t));
        Assert.assertFalse(b2.exit(t));
        ITicket ta = distrib.adjustFare(t, 87);
        Assert.assertFalse(b2.exit(ta));
        Assert.assertTrue(ta.isValid());
    }*/

   /* @Test
    public void testExitRemoveOriginStation(){
        ITicket t = distrib.buyTicket(false, 10000000);
        Barrier b = Barrier.build(n, t01.getName(), price);
        Barrier b2 = Barrier.build(n, t07.getName(), price);
        Assert.assertTrue(b.enter(t));
        t01.removeLine(tozai);
        Assert.assertFalse(b2.exit(t));
    }*/

    /*@Test
    public void testExitRemoveOriginStation2(){
        ITicket t = distrib.buyTicket(false, 10000000);
        Barrier b = Barrier.build(n, t01.getName(), price);
        Assert.assertTrue(b.enter(t));
        t01.removeLine(tozai);
        Assert.assertFalse(b.exit(t));
    }*/

    /*@Test
    public void testEntreeCorrecte(){
        Assert.assertTrue(ticketAdulte.isValid());
        Assert.assertTrue(ticketEnfant.isValid());

        Barrier barrierMiyanosawa = Barrier.build(n, t01.getName(), price);
        Assert.assertTrue(barrierMiyanosawa.enter(ticketAdulte));
        Assert.assertTrue(barrierMiyanosawa.enter(ticketEnfant));

        Assert.assertTrue(ticketAdulte.isValid());
        Assert.assertTrue(ticketEnfant.isValid());

        Barrier barrierShinSapporo = Barrier.build(n, t15.getName(), price);
        Assert.assertTrue(barrierShinSapporo.exit(ticketAdulte));
        Assert.assertTrue(barrierShinSapporo.exit(ticketEnfant));

        Assert.assertFalse(ticketAdulte.isValid());
        Assert.assertFalse(ticketEnfant.isValid());
    }*/

    /*@Test
    public void testExitRefuelMoneyAsChild(){
        ITicket ticketEnfantShort = distrib.buyTicket(true, 100);
        Barrier b = Barrier.build(n, t01.getName(), price);
        Barrier b2 = Barrier.build(n, t19.getName(), price);
        Assert.assertTrue(b.enter(ticketEnfantShort));
        Assert.assertFalse(b2.exit(ticketEnfantShort));
        ITicket ta = distrib.adjustFare(ticketEnfantShort, 100);
        Assert.assertFalse(b2.exit(ta));
        Assert.assertTrue(ta.isValid());
        ITicket taa = distrib.adjustFare(ta, 1000);
        Assert.assertTrue(b2.exit(taa));
        Assert.assertFalse(taa.isValid());
    }*/

    @Test
    public void tenTripsTicket_adult(){
        ITicket ticket = distrib.buyTicket(false);
        bar1.enter(ticket);
        Assert.assertTrue(bar1.exit(ticket));
    }

    @Test
    public void tenTripsTicket_child(){
        ITicket ticket = distrib.buyTicket(true);
        bar1.enter(ticket);
        Assert.assertTrue(bar1.exit(ticket));
    }

    /*@Test
    public void tenTripsTicket_testEntreeCorrecte(){
        ticketAdulte = distrib.buyTicket(false);
        ticketEnfant = distrib.buyTicket(true);
        Assert.assertTrue(ticketAdulte.isValid());
        Assert.assertTrue(ticketEnfant.isValid());

        Barrier barrierMiyanosawa = Barrier.build(n, t01.getName(), price);
        Assert.assertTrue(barrierMiyanosawa.enter(ticketAdulte));
        Assert.assertTrue(barrierMiyanosawa.enter(ticketEnfant));

        Assert.assertTrue(ticketAdulte.isValid());
        Assert.assertTrue(ticketEnfant.isValid());

        Barrier barrierShinSapporo = Barrier.build(n, t15.getName(), price);
        Assert.assertTrue(barrierShinSapporo.exit(ticketAdulte));
        Assert.assertTrue(barrierShinSapporo.exit(ticketEnfant));
    }*/

    /*@Test
    public void tenTripsTicket_Test10EntreesSortiesPlus1Entree() {
        ticketAdulte = distrib.buyTicket(false);
        Barrier barrierMiyanosawa = Barrier.build(n, t01.getName(), price);
        Barrier barrierShinSapporo = Barrier.build(n, t15.getName(), price);
        for (int i = 0; i < 10; i++) {
            Assert.assertTrue(barrierMiyanosawa.enter(ticketAdulte));
            Assert.assertTrue(barrierShinSapporo.exit(ticketAdulte));
        }
        Assert.assertFalse(ticketAdulte.isValid());
        Assert.assertFalse(barrierShinSapporo.enter(ticketAdulte));
    }*/

    /*@Test
    public void tenTripsTicket_1AllesRetours() {
        ITicket ticket = distrib.buyTicket(false);
        bar1.enter(ticket);
        Assert.assertTrue(bar3.exit(ticket));
        bar3.enter(ticket);
        Assert.assertTrue(ticket.isValid());
        Assert.assertTrue(bar1.exit(ticket));
    }*/

    /*@Test
    public void tenTripsTicket_5AllesRetours() {
        ITicket ticket = distrib.buyTicket(false);
        for (int i = 0; i < 5; i++) {
            bar1.enter(ticket);
            Assert.assertTrue(bar3.exit(ticket));
            bar3.enter(ticket);
            Assert.assertTrue(bar1.exit(ticket));
        }
        Assert.assertFalse(ticket.isValid());
    }*/

    /*@Test
    public void tenTripsTicket_1AllesRetours_AndOneMore() {
        ITicket ticket = distrib.buyTicket(false);
        bar1.enter(ticket);
        Assert.assertTrue(bar3.exit(ticket));
        bar3.enter(ticket);
        Assert.assertTrue(ticket.isValid());
        Assert.assertTrue(bar1.exit(ticket));

        Assert.assertFalse(ticket.isValid());
        Assert.assertTrue(bar1.enter(ticket));
        Assert.assertTrue(ticket.isValid());
        Assert.assertTrue(bar3.exit(ticket));
        Assert.assertFalse(ticket.isValid());
    }*/

    /*@Test
    public void tenTripsTicket_5AllesRetours_AndOneMore() {
        ITicket ticket = distrib.buyTicket(false);
        for (int i = 0; i < 5; i++) {
            bar1.enter(ticket);
            Assert.assertTrue(bar3.exit(ticket));
            bar3.enter(ticket);
            Assert.assertTrue(bar1.exit(ticket));
        }
        Assert.assertFalse(ticket.isValid());
        Assert.assertFalse(bar1.enter(ticket));
        Assert.assertFalse(bar3.exit(ticket));
        Assert.assertFalse(ticket.isValid());
    }*/

}
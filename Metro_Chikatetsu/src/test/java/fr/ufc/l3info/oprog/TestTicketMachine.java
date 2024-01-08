package fr.ufc.l3info.oprog;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestTicketMachine {

    TicketMachine machine;
    ITicket myTicket;

    @Before
    public void setup() {
        machine = TicketMachine.getInstance();
    }

    // Tests for buyTicket()

    @Test
    public void buyTicketAdultNoAmount () {
        myTicket = machine.buyTicket(false);
        boolean instanceOf10illiTripsTicket = myTicket instanceof TenIllimitedTripsTicket;
        Assert.assertTrue(instanceOf10illiTripsTicket && !myTicket.isChild());
    }

    @Test
    public void buyTicketAdultPosAmount () {
        myTicket = machine.buyTicket(false, 10);
        boolean instanceOfBaseTicket = myTicket instanceof BaseTicket;
        boolean goodAmount = (10 == myTicket.getAmount());
        Assert.assertTrue(goodAmount && instanceOfBaseTicket && !myTicket.isChild());
    }

    @Test
    public void buyTicketAdultAmount0 () {
        myTicket = machine.buyTicket(false, 0);
        Assert.assertNull(myTicket);
    }

    @Test
    public void buyTicketAdultAmountNeg() {
        myTicket = machine.buyTicket(false, -42);
        Assert.assertNull(myTicket);
    }

    @Test
    public void buyTicketChildNoAmount () {
        myTicket = machine.buyTicket(true);
        boolean instanceOf10illiTripsTicket = myTicket instanceof TenIllimitedTripsTicket;
        Assert.assertTrue(instanceOf10illiTripsTicket && myTicket.isChild());
    }

    @Test
    public void buyTicketChildPosAmount() {
        myTicket = machine.buyTicket(true, 10);
        boolean instanceOfBaseTicket = myTicket instanceof BaseTicket;
        boolean goodAmount = (10 == myTicket.getAmount());
        Assert.assertTrue(goodAmount && instanceOfBaseTicket && myTicket.isChild());
    }

    @Test
    public void buyTicketChildAmount0() {
        myTicket = machine.buyTicket(true, 0);
        Assert.assertNull(myTicket);
    }

    @Test
    public void buyTicketChildAmountNeg() {
        myTicket = machine.buyTicket(true, -42);
        Assert.assertNull(myTicket);
    }

    @Test
    public void buyTicketAdultAmountNull() {
        myTicket = machine.buyTicket(false, null);
        Assert.assertNull(myTicket);
    }

    @Test
    public void buyTicketChildAmountNull() {
        myTicket = machine.buyTicket(true, null);
        Assert.assertNull(myTicket);
    }

    // Tests for adjustFare()

    @Test
    public void adjustFareTicketNull() {
        myTicket = machine.adjustFare(null,42);
        Assert.assertNull(myTicket);
    }

    @Test
    public void adjustFareTenTripsIllimitedTicket() {
        ITicket newTicket = new TenIllimitedTripsTicket(true);
        myTicket = machine.adjustFare(newTicket, 42);
        Assert.assertEquals(newTicket,myTicket);
    }

    @Test
    public void adjustFareBaseTicket() {
        ITicket newTicket = new BaseTicket(true, 42);
        myTicket = machine.adjustFare(newTicket,42);
        boolean instanceOfAdjustedTicket = myTicket instanceof AdjustedTicket;
        boolean goodAmount = (84 == myTicket.getAmount());
        Assert.assertTrue(goodAmount && instanceOfAdjustedTicket);
    }

    @Test
    public void adjustFareAdjustedTicket() {
        ITicket newTicket = new AdjustedTicket(new BaseTicket(true, 42), 42);
        myTicket = machine.adjustFare(newTicket,42);
        boolean instanceOfAdjustedTicket = myTicket instanceof AdjustedTicket;
        boolean goodAmount = (126 == myTicket.getAmount());
        Assert.assertTrue(goodAmount && instanceOfAdjustedTicket);
    }

    @Test
    public void adjustFareAmount0() {
        ITicket newTicket = new BaseTicket(true, 42);
        myTicket = machine.adjustFare(newTicket,0);
        Assert.assertEquals(newTicket,myTicket);
    }

    @Test
    public void adjustFareAmountNeg() {
        ITicket newTicket = new BaseTicket(true, 42);
        myTicket = machine.adjustFare(newTicket,-42);
        Assert.assertEquals(newTicket,myTicket);
    }
}

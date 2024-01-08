package fr.ufc.l3info.oprog;

public class TicketMachine {

    private static final TicketMachine INSTANCE = new TicketMachine();

    private TicketMachine(){

    }

    public synchronized static TicketMachine getInstance(){
        return INSTANCE;
    }

    public ITicket buyTicket(boolean child, int... amount){
        if (amount == null) return null;
        if(amount.length == 1){
            if(amount[0] > 0){
                return new BaseTicket(child, amount[0]);
            }else{
                return null;
            }
        }
        return new TenIllimitedTripsTicket(child);
    }

    public ITicket adjustFare(ITicket old, int amount){
        if(old == null){
            return null;
        }
        if(amount <= 0 || old instanceof TenIllimitedTripsTicket){
            return old;
        }
        return new AdjustedTicket(old, amount);
    }
}

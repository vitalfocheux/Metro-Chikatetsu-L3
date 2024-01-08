package fr.ufc.l3info.oprog;

public class AdjustedTicket implements ITicket{

    private final int ISSUED = 0;
    private final int ENTERED = 1;
    private final int INVALID = 2;

    private ITicket initial;
    private int amount;
    private int originalAmount;
    private int state;
    private String station;


    protected AdjustedTicket(ITicket initial, int amount){
        if(initial == null){
            throw new NullPointerException("Le ticket ne peut pas être null");
        }
        this.initial = initial;
        this.amount = Math.max(amount, 0);
        this.originalAmount = initial.getAmount();
        this.state = ISSUED;

    }
    @Override
    public boolean isChild() {
        return initial.isChild();
    }

    @Override
    public String getEntryStation() {
        return (this.state == ENTERED) ? station : null;
    }

    @Override
    public boolean entering(String name) {
        if(this.state == ISSUED && name != null && !name.trim().isEmpty()){
            state = ENTERED;
            station = name;
            return true;
        }
        invalidate();
        return false;
    }

    @Override
    public void invalidate() {
        state = INVALID;
    }

    @Override
    public int getAmount() {
        return amount + originalAmount;
    }

    @Override
    public boolean isValid() {
        return state != INVALID;
    }
}

package fr.ufc.l3info.oprog;

public class TenIllimitedTripsTicket implements ITicket{

    private boolean child;
    private int trips;
    private String entry = "should not be returned";
    private int state;
    final private int ISSUED = 0;
    final private int ENTERED = 1;
    final private int INVALID = 2;

    protected TenIllimitedTripsTicket(boolean child){
        this.child = child;
        this.state = ISSUED;
        this.trips = 10;
    }
    @Override
    public boolean isChild() {
        return this.child;
    }

    @Override
    public String getEntryStation() {
        return (state == ENTERED) ? entry : null;
    }

    @Override
    public boolean entering(String name) {
        if ((this.state == ISSUED || this.state == ENTERED) && this.trips > 0 && name != null && !name.trim().equals("") ) {
            entry = name;
            this.state = ENTERED;
            --this.trips;
            return true;
        }
        invalidate();
        return false;
    }

    @Override
    public void invalidate() {
        this.state = INVALID;
    }

    @Override
    public int getAmount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isValid() {
        return this.state != INVALID;
    }
}

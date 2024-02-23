package bbshop.entities;

public class Barber {

    BarberShopManager barberShopManager;

    public Barber(BarberShopManager barberShopManager) {
        this.barberShopManager = barberShopManager;
        this.state = State.AVAILABLE;
    }

    public void serve(Customer customer) {
        // serve the customer
        this.state = State.AVAILABLE;
        barberShopManager.notify(this);
    }

    private int id;
    private State state;
    private Customer currentCustomer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Customer getCurrentCustomer() {
        return currentCustomer;
    }

    public void setCurrentCustomer(Customer currentCustomer) {
        this.currentCustomer = currentCustomer;
    }
}

package bbshop.entities;

public class BarberShopManager {

    BarberShop barberShop;

    public void setBarberShop(BarberShop barberShop) {
        this.barberShop = barberShop;
    }

    public boolean enterCustomer(Customer customer) {
        for (Barber barber : barberShop.getBarbers()) {
            if(barber.getState().equals(State.AVAILABLE)) {
                this.serve(barber);
                return true;
            }
        }
        // no barber is free, make customer seat on the bench
        if(barberShop.getBench().getCustomers().size() == barberShop.getBench().getSize()) {
            // can't server customer
            return false;
        } else {
            barberShop.getBench().getCustomers().add(customer);
            return true;
        }
    }

    public void serve(Barber barber) {
        Customer customer = barberShop.getAssignCustomerStrategy().assignCustomer();
        synchronized (barber) {
            if(barber.getState().equals(State.AVAILABLE)) {

                barber.setCurrentCustomer(customer);
                barber.setState(State.BUSY);
            }
        }
    }

    public void notify(Barber barber) {
        this.serve(barber);
    }

}

package bbshop.entities;

import bbshop.strategies.AssignCustomerStrategy;

import java.util.List;

public class BarberShop {

    private List<Barber> barbers;
    private Bench bench;

    private AssignCustomerStrategy assignCustomerStrategy;

    public BarberShop(List<Barber> barbers, Bench bench, AssignCustomerStrategy assignCustomerStrategy) {
        this.barbers = barbers;
        this.bench = bench;
        this.assignCustomerStrategy = assignCustomerStrategy;
    }

    public List<Barber> getBarbers() {
        return barbers;
    }

    public void setBarbers(List<Barber> barbers) {
        this.barbers = barbers;
    }

    public Bench getBench() {
        return bench;
    }

    public void setBench(Bench bench) {
        this.bench = bench;
    }

    public AssignCustomerStrategy getAssignCustomerStrategy() {
        return assignCustomerStrategy;
    }

    public void setAssignCustomerStrategy(AssignCustomerStrategy assignCustomerStrategy) {
        this.assignCustomerStrategy = assignCustomerStrategy;
    }
}

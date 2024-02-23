package bbshop.strategies;

import bbshop.entities.Bench;
import bbshop.entities.Customer;

public class SequentialAssignmentStrategy implements AssignCustomerStrategy{

    private int currentIndex;
    private Bench bench;

    public SequentialAssignmentStrategy(Bench bench) {
        this.bench = bench;
        this.currentIndex = -1;
    }

    @Override
    public Customer assignCustomer() {
        if(this.bench.getSize() > currentIndex) {
            currentIndex++;
            return this.bench.getCustomers().get(currentIndex);
        } else {
            return null;
        }
    }
}

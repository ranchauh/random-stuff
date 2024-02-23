package bbshop.entities;

import java.util.ArrayList;
import java.util.List;

public class Bench {
    private int size;
    private List<Customer> customers;

    public Bench(int size) {
        this.size = size;
        this.customers = new ArrayList<>();
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}

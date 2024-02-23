package bbshop;

import bbshop.entities.*;
import bbshop.strategies.AssignCustomerStrategy;
import bbshop.strategies.SequentialAssignmentStrategy;

import java.util.List;

public class Client {
    public static void main(String[] args) {
        BarberShopManager barberShopManager = new BarberShopManager();
        List<Barber> barbers = List.of(
                new Barber(barberShopManager),
                new Barber(barberShopManager)
        );
        Bench bench = new Bench(5);
        AssignCustomerStrategy assignementStrategy  = new SequentialAssignmentStrategy(bench);
        BarberShop barberShop = new BarberShop(barbers, bench, assignementStrategy);

        barberShopManager.setBarberShop(barberShop);

        barberShopManager.enterCustomer(new Customer());
        barberShopManager.enterCustomer(new Customer());
        barberShopManager.enterCustomer(new Customer());
        barberShopManager.enterCustomer(new Customer());
        barberShopManager.enterCustomer(new Customer());
        barberShopManager.enterCustomer(new Customer());
        barberShopManager.enterCustomer(new Customer());

        barberShopManager.serve(barbers.get(0));


    }
}

package model;

import enums.PaymentMethod;
import enums.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

class CashierTest {
    static Customer customer;
    Product product;

    static Cashier cashier =new Cashier("Chichi","034",Role.Cashier,customer);
    Cashier cashier1 = new Cashier("Joyce","034",Role.Cashier,customer);
    Customer customer1 = new Customer("Seun",PaymentMethod.Cash);

    @BeforeEach
    void setUp() {
    }

    @Test
    void cashierCanSell(){
        Customer customer = new Customer("Seun", PaymentMethod.Cash);
//        Cashier cashier = new Cashier("chinelo", 5, false);
        assertEquals(Boolean.TRUE, cashier.canSell(customer));
    }


    @Test
    void cashierCanReceiveCardPayment() {
        String actual = cashier.receivePayment(new Customer("Chimudia",PaymentMethod.Card));
        assertEquals("Cashier asks customers to enter card pin.",actual);

    }

    @Test
    void cashierCanReceiveCashPayment() {
        String actual = cashier.receivePayment(new Customer("Chimudia",PaymentMethod.Cash));
        assertEquals("Cashier received Cash payment",actual);

    }
    @Test
    void  cashierComparesProductWithChocolateChips(){
        //if i made a mistake in the productname of my method, it doesn/t reflect on my tests. How do I go about it?
        customer1.getCustomerCart().add(new Product("Chocolate Chip","cookies", 5,0));
        String actual = cashier1.comparingProducts(customer1);
        assertEquals("Chocolate Chip added to queue", actual);
    }
    @Test
    void  cashierComparesProductWithCarrots(){
        customer1.getCustomerCart().add(new Product("Carrot","Bars",2,0));
        String actual = cashier1.comparingProducts(customer1);
        assertEquals("Carrot has been added to queue", actual);
    }
    @Test
    void  cashierComparesProductWithBananas(){
        customer1.getCustomerCart().add(new Product("Banana","snacks", 7,0));
        var expected = "Banana has been added to queue";
         var actual = cashier1.comparingProducts(customer1);
         assertEquals(expected, actual);
    }
    @Test
    void  cashierComparesProductWithPotatochips(){
        customer1.getCustomerCart().add(new Product("Potato Chips","snacks", 7,0));
        var expected = "Potato Chips has been added to Queue";
        var actual = cashier1.comparingProducts(customer1);
        assertEquals(expected, actual);
    }
}
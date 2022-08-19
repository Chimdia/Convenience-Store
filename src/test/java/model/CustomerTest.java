package model;

import enums.PaymentMethod;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
    Customer customer;
    Store store;


    CustomerTest() {

    }

    @BeforeEach
    void setUp() {

    }

    @Test
    void canBuyProducts() {

        Store store = new Store();
        store.addProduct(new Product("Chocolate Chip", "Cookies", 177, 0));


        customer = new Customer("Seun" ,PaymentMethod.Cash);

        String actual = customer.canBuy("Chocolate Chip", "cookies,", 177, store, customer);
        assertEquals("Chocolate Chip", actual);

    }


    @Test
    void canBuyOnlyAvailableQuantity() {

        Store store = new Store();store.addProduct(new Product("Chocolate Chip", "Cookies", 177, 0));

        customer = new Customer("Seun", PaymentMethod.Cash);

        String actual = customer.canBuy("Chocolate Chip", "cookies,", 5000, store, customer);
        assertEquals("Sorry Only this quantity Available. kindly Reorder!!" ,actual);

    }

    @Test
    void cannotBuyWhenQuantityIsZero() {

        Store store = new Store();store.addProduct(new Product("Chocolate Chip", "Cookies", 0, 0));

        customer = new Customer("Seun", PaymentMethod.Cash);

        String actual = customer.canBuy("Chocolate Chip", "cookies,", 10, store, customer);
        assertEquals("Out Of Stock" ,actual);

    }
}
package model;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ManagerTest {
    static Customer customer;
    static Cashier cashier;
    Manager manager = Manager.getInstance();

    @BeforeEach
    void setUp() {
    }

    @Test
    void shouldTestForHiredCashier() {

        Cashier cashier = new Cashier("chinelo", 5, false);
        assertEquals(Boolean.TRUE, manager.canHireACashier(cashier));
    }


    @Test
    void shouldNotHireCashierWhenYearOfExperienceIsLessThanThree() {

        Cashier cashier = new Cashier("chinelo", 2, false);
        assertEquals(Boolean.FALSE, manager.canHireACashier(cashier));
    }

    @Test
    void shouldNotHireCashierWhenCashierIsTrue() {

        Cashier cashier = new Cashier("chinelo", 5, true);
        assertEquals(Boolean.FALSE, manager.canHireACashier(cashier));
    }
}
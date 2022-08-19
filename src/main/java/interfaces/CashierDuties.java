package interfaces;

import model.Customer;
import model.Product;

import java.util.List;


public interface CashierDuties {
    boolean canSell(Customer customer);

//    public void receivePayment(Customer customer, PaymentMethod paymentMethod);
//    public  void  issuesReceipt(Customer customer);
    public void issuesReceipt(Customer customer);
}

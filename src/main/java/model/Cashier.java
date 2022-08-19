package model;


import enums.PaymentMethod;
import enums.Role;
import interfaces.CashierDuties;


import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Cashier extends Person implements CashierDuties {
    private boolean isHired = false;
    private int yearsOfExperience;

    private String name;
    private String StaffId;
    private Role role;
    private PaymentMethod paymentMethod;
    private Customer customer;

//    public Cashier(String chichi, String staffId, Role cashier, Customer customer) {
//
//    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public Cashier(String name, int yearsOfExperience, boolean isHired) {
        this.isHired = isHired;
        this.yearsOfExperience = yearsOfExperience;
        this.name = name;
    }

    public Cashier(String name, String staffId, Role role, Customer customer) {
        this.name = name;
        StaffId = staffId;
        this.role = role;
        this.customer= customer;
    }


    public String getName() {
        return name;
    }

    public boolean isHired(boolean b) {

        return isHired;
    }

    public void setHired(boolean hired) {

        isHired = hired;
    }

    public int getYearsOfExperience() {

        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {

        this.yearsOfExperience = yearsOfExperience;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getStaffId() {

        return StaffId;
    }

    public void setStaffId(String staffId) {

        StaffId = staffId;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {

        this.role = role;
    }

    public Customer getCustomer() {

        return customer;
    }

    public void setCustomer(Customer customer) {

        this.customer = customer;
    }


    public boolean canSell(Customer customer) {
        double totalCost = 0;
        if (role == Role.Cashier) {
            for (Product products : customer.getCustomerCart()) {
                totalCost = products.getPrice() * products.getQuantity();
                System.out.println(customer.getCustomerCart()+"\n" + "  Total Cost: " + totalCost);
//                System.out.println(customerCart);
            }
            return true;

        }
        return false;
    }




    public String receivePayment(Customer customer) {
        if (role == Role.Cashier && customer.getPaymentMethod() == PaymentMethod.Cash) {
            System.out.println(role + " received " + customer.getPaymentMethod() + " payment");
            return role + " received " + customer.getPaymentMethod() + " payment";
        } else if (role == Role.Cashier && customer.getPaymentMethod() == PaymentMethod.Card) {
            System.out.println(role + " asks customer to enter pin");
            return role + " asks customers to enter card pin.";
        } else {
            return role + "not permitted to receive payment.";
        }
    }


//    @Override
//    public boolean canSell(Customer customer) {
//        return false;
//    }

    @Override
    public synchronized void issuesReceipt(Customer customer/*, List<Product> customerCart*/) {

             double totalCost=0;
        for (Product products : customer.getCustomerCart()) {
            totalCost = products.getPrice() * products.getQuantity();
//            System.out.println(customer.getPaymentMethod() + " PAYMENT 1");
               if(customer.getPaymentMethod() == PaymentMethod.Card){
                     System.out.println("\nCustomer " + customer.getName() + "'s Purchase Receipt\n"  + "*".repeat(35) );
                     System.out.println("Product Name: " + products.getProductName() + "\nPrice:" + products.getPrice() + "\nQty: " + products.getQuantity() + "\nTotal Cost " + totalCost);
                     System.out.println(customer.getPaymentMethod() + " PAYMENT");
                     System.out.println("Thanks for your patronage, here's your receipt");
                     System.out.println("-".repeat(60));
                     }

               if (customer.getPaymentMethod() == PaymentMethod.Cash){
//                   System.out.println("_".repeat(60)+ "\n");
                   System.out.println("\nCustomer " + customer.getName() + "'s Purchase Receipt\n" + "*".repeat(35));
                   System.out.println(" Product Name: " + products.getProductName() + "\nPrice:" + products.getPrice() + "\nQty: " + products.getQuantity() + "  \nTotal Cost:" + totalCost);
                   System.out.println("Thanks for your patronage, here's your receipt");
                   System.out.println(customer.getPaymentMethod() + " PAYMENT");
                   System.out.println("-".repeat(60));
               }
               }
        }

      private static Queue<Customer> customerQueue = new LinkedList<>();

    public  Queue<Customer> getCustomerQueue() {

        return customerQueue;
    }


    public Queue<DTO> getChocolateChip() {
        return ChocolateChip;
    }

    public Queue<DTO> getCarrot() {
        return Carrot;
    }

    public Queue<DTO> getPotatoChip() {
        return PotatoChip;
    }

    public Queue<DTO> getBanana() {
        return Banana;
    }

    private Queue<DTO> ChocolateChip = new PriorityQueue<>(new Productcomparator());
    private Queue<DTO> Carrot = new PriorityQueue<>(new Productcomparator());
    private Queue<DTO> PotatoChip = new PriorityQueue<>(new Productcomparator());
    private Queue<DTO> Banana = new PriorityQueue<>(new Productcomparator());

    public  String comparingProducts(Customer customer){
        String outPut = "";
            for (Product product: customer.getCustomerCart()) {
               if(product.getProductName().trim().equalsIgnoreCase("Chocolate Chip")) {
                   ChocolateChip.add(new DTO(product.getProductName(), product.getQuantity(),customer.getName()));
                   System.out.println(product.getProductName()+ " has been added to queue");
                   outPut = "Chocolate Chip added to queue";

               } else if(product.getProductName().trim().equalsIgnoreCase("Carrot")){
                    Carrot.add(new DTO(product.getProductName(), product.getQuantity(),customer.getName()));
                   System.out.println(product.getProductName()+ " has been added to queue");
                    outPut = "Carrot has been added to queue";

               } else if(product.getProductName().trim().equalsIgnoreCase("Potato Chips")){
                    PotatoChip.add(new DTO(product.getProductName(), product.getQuantity(),customer.getName()));
                   System.out.println(product.getProductName()+ " has been added to queue");
                    outPut = "Potato Chips has been added to Queue";
               }
                else if(product.getProductName().trim().equalsIgnoreCase("Banana")){
                    Banana.add(new DTO(product.getProductName(), product.getQuantity(),customer.getName()));
                   System.out.println(product.getProductName()+ " has been added to queue");
                    outPut = "Banana has been added to queue";
               }

            }
            return outPut;
        }

public  String fifoQueue(Customer customer, Queue<Customer> customerQueue) {
    String output = "";
    boolean isAdded = customerQueue.add(customer);
    if (isAdded) {
        output = "Customer Added";
    } else {
        output = "Customer not added";
    }
    return output;
}
public  boolean printQueueList(Queue<Customer>customerQueue){
            while (!customerQueue.isEmpty()){
                issuesReceipt(customerQueue.poll());
            }
            return true;
}


}









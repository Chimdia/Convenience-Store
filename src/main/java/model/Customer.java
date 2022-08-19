package model;

import enums.PaymentMethod;


import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Customer extends Person {
//    private Product product;
    private String name;

//    private int qtyBuying;

    private  List<Product> customerCart = new ArrayList<>();


    private PaymentMethod paymentMethod;

    public Customer(String name, PaymentMethod paymentMethod) {
        this.name = name;
        this.paymentMethod = paymentMethod;
    }

    public  List<Product> getCustomerCart() {
        return customerCart;
    }

    public void setCustomerCart(List<Product> customerCart) {
        this.customerCart = customerCart;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //    public Product getProduct() {
//        return product;
//    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {

        this.paymentMethod = paymentMethod;
    }

    public String canBuy( String productName , String category, int quantity, Store store, Customer customer) {

//            int output = 0;

            for (Product product : store.getSupplyList()) {
                if (productName.equalsIgnoreCase(product.getProductName()) && product.getQuantity() >= quantity) {
                        customer.getCustomerCart().add(new Product(productName,category, quantity, product.getPrice()));
                        product.setQuantity(product.getQuantity() - quantity);


//                        System.out.println("Available Product Quantity: " + product.getQuantity()) ;
                        System.out.println(quantity + " " + product.getProductName() + " has been added to customer " + customer.getName() + "'s cart");
//                        output = 0;
                        return productName;
//                        break;
                    } if (product.getQuantity() < quantity && product.getQuantity() != 0) {
                        //System.out.println("Sorry Only " +  product.getQuantity() + " " +  product.getProductName() + " left!! \n " + " Kindly reorder.");
//                        String result = "Sorry Only " +  product.getQuantity() + " " +  product.getProductName() + " left!! " + " Kindly reorder.";
                        System.out.println("Sorry Only " + product.getQuantity() + " " + product.getProductName() + " left!!" + " Kindly Reorder.");
                        return "Sorry Only this quantity Available. kindly Reorder!!";

                    } if (product.getQuantity() == 0){ //!(product.getProductName().equals(product.getProductName()) || product.getQuantity() > 0)) {
                        System.out.println(product.getProductName() + " is out of Stock");
//                        output = 1;
//                        break;
                    return "Out Of Stock";
                 }
                  }


        return productName;
    }

    @Override
    public String toString() {
        return
                "Customer " + name + '\'' +
                "\n " + customerCart + "\n" +
                "" + paymentMethod + " payment\n"
                ;
    }
}

